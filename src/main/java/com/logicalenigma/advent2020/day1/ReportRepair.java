package com.logicalenigma.advent2020.day1;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

public class ReportRepair {

	public static void main(String[] args) {
		try {
			doWork();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void doWork() throws IOException {

		List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("src/main/resources", "day1.txt"));

		lines.stream().forEach(System.out::println);

	}
}