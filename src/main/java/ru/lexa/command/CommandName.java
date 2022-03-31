package ru.lexa.command;

public enum CommandName {

	ADD("add"),
	INFO("info"),
	SAVE("save"),
	HELP("help"),
	EXIT("exit");

	private final String commandName;

	CommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getCommandName() {
		return commandName;
	}

}
