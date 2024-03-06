package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) {

		// /temp/ws-eclipse/Testing/sumary.csv

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String home = System.getProperty("user.home");

		List<Product> list = new ArrayList<>();

		System.out.println("Enter file path: ");
		String sourceFileStr = home + sc.nextLine();

		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		System.out.println(sourceFolderStr);

		String targetFileStr = sourceFolderStr + "/out/summary2.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

			String itemCsv = br.readLine();

			while (itemCsv != null) {

				String[] fields = itemCsv.split(";");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				list.add(new Product(name, price, quantity));

				itemCsv = br.readLine();

			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

				for (Product item : list) {
					if (item.getPrice() > 350.50) {
						bw.write(item.getName() + ";" + item.total());
						bw.newLine();
					}
					else {
						System.out.printf(item.getName() + "%.2f%n",item.getPrice());
					}
				}
				System.out.println(targetFileStr + " Created");
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());

		}
	}
}