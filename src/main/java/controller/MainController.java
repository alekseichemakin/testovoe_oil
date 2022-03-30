package controller;

import dao.EquipmentDAO;
import dao.WellDAO;
import entity.Equipment;
import entity.Well;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainController {
	private WellDAO wellDAO;
	private EquipmentDAO equipmentDAO;

	public MainController(WellDAO wellDAO, EquipmentDAO equipmentDAO) {
		this.wellDAO = wellDAO;
		this.equipmentDAO = equipmentDAO;
	}


	public void createEquipment(String wellName, int equipmentAmount) {
		Well well = wellDAO.getByName(wellName);
		if (well == null) {
			well = new Well();
			well.setName(wellName);
			wellDAO.add(well);
		}

		well.setEquipment(generateEquipment(equipmentAmount, well));
		wellDAO.update(well);
	}

	public void getInformation(String wells) {
		String[] wellsName = wells.split(" ");
		for (String name : wellsName) {
			Well well = wellDAO.getByName(name);
			if (well == null) {
				System.out.println(name + " - well doesnt exist");
			} else {
				System.out.println(name + " - " + well.getEquipment().size());
			}
		}
	}

	public void saveToXml(String filename) {
//		for (Well well : wellDAO.getAll()) {
				try {
					JAXBContext context = JAXBContext.newInstance(DbInfo.class);
					Marshaller marshaller = context.createMarshaller();
					// устанавливаем флаг для читабельного вывода XML в JAXB
					marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

					// маршаллинг объекта в файл
					marshaller.marshal(new DbInfo(wellDAO.getAll()), new File("/home/lexa/IdeaProjects/testovoe_oil/test.xml"));
				} catch (JAXBException e) {
					e.printStackTrace();
				}
//		}
	}

	private List<Equipment> generateEquipment(int amount, Well well) {
		List<Equipment> equipmentList;
		long lastId = 0L;

		if (well.getEquipment() != null && !well.getEquipment().isEmpty()) {
			equipmentList = well.getEquipment();
			lastId = well.getEquipment().stream()
					.sorted(Collections.reverseOrder(Comparator.comparing(Equipment::getId)))
					.findFirst()
					.get().getId();
		} else {
			equipmentList = new ArrayList<>();
		}

		for (int i = 0; i < amount; i++) {
			lastId++;
			Equipment equipment = new Equipment();
			String name = "EQ_" + well.getId() + "_" + lastId;
			equipment.setName(name);
			equipmentList.add(equipment);
		}
		return equipmentList;
	}

	@XmlRootElement(name = "dbinfo")
	static class DbInfo {
		List<Well> wellList;

		public DbInfo(List<Well> wellList) {
			this.wellList = wellList;
		}

		public void setWellList(List<Well> wellList) {
			this.wellList = wellList;
		}

		public DbInfo() {
		}

		public List<Well> getWellList() {
			return wellList;
		}
	}
}
