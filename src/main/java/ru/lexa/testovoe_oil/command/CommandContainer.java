package ru.lexa.testovoe_oil.command;

import ru.lexa.testovoe_oil.dao.EquipmentDAO;
import ru.lexa.testovoe_oil.dao.WellDAO;
import com.google.common.collect.ImmutableMap;

import static ru.lexa.testovoe_oil.command.CommandName.*;

public class CommandContainer {
	private final ImmutableMap<String, Command> commandMap;
	private final Command unknownCommand;

	public CommandContainer(WellDAO wellDAO, EquipmentDAO equipmentDAO) {
		commandMap = ImmutableMap.<String, Command>builder()
				.put(ADD.getCommandName(), new AddCommand(wellDAO))
				.put(INFO.getCommandName(), new InfoCommand(wellDAO))
				.put(SAVE.getCommandName(), new SaveCommand(wellDAO))
				.put(HELP.getCommandName(), new HelpCommand())
				.build();

		unknownCommand = new UnknownCommand();
	}

	public Command retrieveCommand(String commandIdentifier) {
		return commandMap.getOrDefault(commandIdentifier, unknownCommand);
	}

}
