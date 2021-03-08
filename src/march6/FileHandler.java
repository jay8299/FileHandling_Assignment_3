package march6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

	public static void write(String path) {
		try {

			Scanner dr = new Scanner(System.in);
			System.out.println("\nEnter data to Write\n");
			String data = dr.nextLine();
			//dr.close();
			FileWriter myWriter = new FileWriter(path);
			myWriter.write(data);
			myWriter.close();
			System.out.println("\nData Entered to File");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void read(String path) {
		File myObj = new File(path);
		try {
			Scanner myReader = new Scanner(myObj);
			if (!myReader.hasNextLine())
				System.out.println("\nFile is Empty\n");
			else
				System.out.println("\nData in File is ::\n");
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void append(String path) {
		try {
			Scanner dr = new Scanner(System.in);
			System.out.println("\nEnter data to Append\n");
			String data = " "+dr.nextLine();
			//dr.close();
			FileWriter myWriter = new FileWriter(path, true);
			myWriter.write(data);
			myWriter.close();
			System.out.println("\nData Appended to File");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		String path = "C:\\Users\\ttiyyagura\\eclipse-workspace\\File Handling-TEK-Simplilearn-Mar-6\\text.txt";
		FileHandler fh = new FileHandler();
		fh.fileHandler(path);

	}

	public void fileHandler(String path) {
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		while (!exit) {
			System.out.println("\n********");
			System.out.println("Enter 1: to Write to a file");
			System.out.println("Enter 2: to Read a file");
			System.out.println("Enter 3: to Append a file");
			System.out.println("Enter 4: Exit ");
			System.out.println("Enter your option::");

			String val = scan.next();
			switch (val) {

			case "1": {
				write(path);
				break;
			}
			case "2": {
				read(path);
				break;
			}
			case "3": {
				append(path);
				break;
			}
			case "4": {
				exit = true;
				break;
			}
			default: {
				System.out.println("Invalid choice");
			}

			}
			if (exit) {
				System.out.println("\nExited");
				break;
			}

		}
		 scan.close();
	}
}
