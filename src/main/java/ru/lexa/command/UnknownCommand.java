package ru.lexa.command;

public class UnknownCommand implements Command{

	public static final String UNKNOWN_MESSAGE = "Command don't allowed \uD83D\uDE1F, use help for watch ru.lexa.command list";

	@Override
	public void execute() {
		System.out.println(UNKNOWN_MESSAGE);
	}
}
