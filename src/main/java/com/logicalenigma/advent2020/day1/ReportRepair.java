package com.logicalenigma.advent2020.day1;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

public class ReportRepair {

	public static void main(String[] args) {
		try {
			doWorkFor2();
			doWorkFor3();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void doWorkFor3() throws IOException {

		List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("src/main/resources", "day1.txt"));

		for (int i = 0; i < lines.size(); i++ ) {
			for (int j =0; j < lines.size(); j++ ) {
				for (int k =0; k < lines.size(); k++ ) {
					if ( i != j && j != k) {
						int num1 = Integer.parseInt(lines.get(i));
						int num2 = Integer.parseInt(lines.get(j));
						int num3 = Integer.parseInt(lines.get(k));
						int sum = num1 + num2 + num3;
						if (sum == 2020){
							System.out.println(num1 + " * " + num2 + " * " + num3 + " = " + num1 * num2 * num3);
							break;
						}
					}
				}
			}
		}
	}

	public static void doWorkFor2() throws IOException {

		List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("src/main/resources", "day1.txt"));

		for (int i = 0; i < lines.size(); i++ ) {
			for (int j =0; j < lines.size(); j++ ) {
				if ( i != j ) {
					int num1 = Integer.parseInt(lines.get(i));
					int num2 = Integer.parseInt(lines.get(j));
					int sum = num1 + num2;
					if (sum == 2020){
						System.out.println(num1 + " * " + num2 + " = " + num1 * num2 );
						break;
					}
				}
			}
		}


	}
}