package ru.lexa.testovoe_oil;

import net.bytebuddy.asm.Advice;
import ru.lexa.testovoe_oil.command.CommandContainer;
import ru.lexa.testovoe_oil.service.EquipmentService;
import ru.lexa.testovoe_oil.service.IOService;
import ru.lexa.testovoe_oil.service.WellService;

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
			if (com.equals("exit") || com.equals("quit"))
				return;
			commandContainer.retrieveCommand(com).execute();
		}
	}
}
