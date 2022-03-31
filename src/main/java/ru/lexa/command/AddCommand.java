package ru.lexa.command;

import ru.lexa.dao.WellDAO;
import ru.lexa.entity.Equipment;
import ru.lexa.entity.Well;
import ru.lexa.service.IOService;

import java.util.*;

public class AddCommand implements Command {

	private WellDAO wellDAO;

	public AddCommand(WellDAO wellDAO) {
		this.wellDAO = wellDAO;
	}

	@Override
	public void execute() {

		Scanner scanner = IOService.getScanner();
		try {
			System.out.print("Well name: ");
			String wellName = scanner.nextLine();
			System.out.print("Equipment amount: ");
			int equipmentAmount = Integer.parseInt(scanner.nextLine());

			Well well = wellDAO.getByName(wellName);
			if (well == null) {
				well = new Well();
				well.setName(wellName);
				wellDAO.add(well);
			}

			well.setEquipment(generateEquipment(equipmentAmount, well));
			wellDAO.update(well);

		} catch (NumberFormatException e) {
			System.out.println("Warning: wrong number format");
			execute();
		}

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
}
