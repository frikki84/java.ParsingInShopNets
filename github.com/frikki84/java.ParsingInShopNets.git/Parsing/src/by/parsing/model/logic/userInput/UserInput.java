package by.parsing.model.logic.userInput;
import java.util.Scanner;

//take information from the user
public class UserInput {
	private static Scanner scanner = new Scanner(System.in);


	public static double inputDouble(String msg) {
		System.out.print(msg);
		return scanner.nextDouble();

	}

	public static String inputString(String msg) {
		System.out.print(msg);
		return scanner.nextLine();
	}

	public static int inputInt(String msg) {
		System.out.print(msg);
		return scanner.nextInt();

	}

}