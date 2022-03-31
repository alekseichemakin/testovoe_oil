package ru.lexa.testovoe_oil.command;

public class UnknownCommand implements Command{

	public static final String UNKNOWN_MESSAGE = "Command don't allowed, use help for watch command list";

	@Override
	public void execute() {
		System.out.println(UNKNOWN_MESSAGE);
	}
}
