package application;

import java.io.File;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		String home = System.getProperty("user.home");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();

		File path = new File(home + strPath);
		

		File[] folders = path.listFiles(File::isDirectory);

		System.out.println("FOLDERS:");

		for (File folder : folders) {

			System.out.println(folder);

		}
		

		File[] files = path.listFiles(File::isFile);

		System.out.println("FILES:");

		for (File file : files) {

			System.out.println(file);

		}
		
		try {
		
		String subdir = "Subdir";
		
		boolean success = new File(strPath + File.separator + subdir).mkdir();
		
		System.out.println();
		System.out.println("Directory created successfully: " + success);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		sc.close();

	}
}