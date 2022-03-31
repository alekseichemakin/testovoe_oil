package ru.lexa.testovoe_oil.command;

import ru.lexa.testovoe_oil.dao.WellDAO;
import ru.lexa.testovoe_oil.entity.Well;
import ru.lexa.testovoe_oil.service.IOService;

public class InfoCommand implements Command {

	private WellDAO wellDAO;

	public InfoCommand(WellDAO wellDAO) {
		this.wellDAO = wellDAO;
	}

	@Override
	public void execute() {
		System.out.print("Input well names in format [name name ...]: ");
		String wells = IOService.getScanner().nextLine();

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
}
