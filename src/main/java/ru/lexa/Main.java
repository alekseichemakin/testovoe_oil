package ru.lexa;

import ru.lexa.command.CommandContainer;
import ru.lexa.service.EquipmentService;
import ru.lexa.service.IOService;
import ru.lexa.service.WellService;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CommandContainer commandContainer = new CommandContainer(new WellService(), new EquipmentService());
		Scanner scanner = IOService.getScanner();
		while (true) {
			System.out.println("\n===========================");
			System.out.println("=Main menu: choose command=");
			System.out.println("===========================\n");
			String com = scanner.nextLine();
			commandContainer.retrieveCommand(com).execute();
		}
	}
}
