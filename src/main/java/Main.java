import controller.MainController;
import entity.Equipment;
import entity.Well;
import service.EquipmentService;
import service.WellService;

public class Main {
	public static void main(String[] args) {
		EquipmentService equipmentService = new EquipmentService();
		WellService wellService = new WellService();

		MainController controller = new MainController(wellService, equipmentService);

		controller.createEquipment("a", 3);
		controller.createEquipment("s", 3);
		controller.getInformation("s a d");
		controller.saveToXml("a");
//		Well well = new Well();
//		well.setId(1L);
//		well.setName("test");

//		Well well1 = new Well();
//		well1.setId(1L);
//		well1.setName("test1");
//
//		Equipment equipment = new Equipment();
//		equipment.setId(1L);
//		equipment.setName("test");
//		equipment.setWell(well);
//
//		Equipment equipment1 = new Equipment();
//		equipment1.setId(1L);
//		equipment1.setName("test1");
//		equipment1.setWell(well1);
//
//		Equipment equipment2 = new Equipment();
//		equipment2.setId(1L);
//		equipment2.setName("test2");
//		equipment2.setWell(well);
//
//		wellService.add(well);
//		wellService.add(well1);
//		equipmentService.add(equipment);
//		equipmentService.add(equipment1);
//		equipmentService.add(equipment2);
//		controller.createEquipment("test", 1);
	}
}
