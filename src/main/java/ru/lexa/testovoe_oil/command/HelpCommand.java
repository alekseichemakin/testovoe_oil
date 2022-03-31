package ru.lexa.testovoe_oil.command;

import static ru.lexa.testovoe_oil.command.CommandName.*;

public class HelpCommand implements Command{

	public static final String HELP_MESSAGE = String.format("✨Available commands✨\n\n"
					+ "%s - add equipment to well [well equipment_amount]\n"
					+ "%s - get info from choose well [well_name well_name...]\n"
					+ "%s - save wells information to XML file [file_name]\n"
					+ "%s - getting help\n",
			ADD.getCommandName(), INFO.getCommandName(), SAVE.getCommandName(), HELP.getCommandName());

	@Override
	public void execute() {
		System.out.println(HELP_MESSAGE);
	}
}
