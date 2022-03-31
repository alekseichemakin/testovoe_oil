package ru.lexa.testovoe_oil.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class IOService {
	private static Scanner scanner;

	public static Scanner getScanner() {
		if (scanner == null)
			scanner = new Scanner(System.in);
		return scanner;
	}

	public static void close() {
		scanner.close();
	}
}
