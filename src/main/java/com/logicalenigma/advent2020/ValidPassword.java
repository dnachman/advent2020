package com.logicalenigma.advent2020;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;


public class ValidPassword {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("src/main/resources", "day2.txt"));

		doPartOne(lines);
		doPartTwo(lines);
	}

	public static void doPartOne(List<String> lines) {

		int numMatches = 0;
		for (String line : lines) {
			// get the colon
			int colonPosition = line.indexOf(":");
			// get the pattern
			String pattern = line.substring(0, colonPosition);
			int lowerBound = Integer.parseInt(pattern.substring(0,pattern.indexOf("-")));
			int upperBound = Integer.parseInt(pattern.substring(pattern.indexOf("-")+1, pattern.indexOf(" ")));
			String matchString = pattern.substring(pattern.length() - 1);

			// get the rest
			String password = line.substring(colonPosition+2);

			// see if match
			long count = password.chars().filter(ch -> ch == matchString.charAt(0)).count();
			if (count >= lowerBound && count <= upperBound) {
				numMatches += 1;
			}

		}

		System.out.println(numMatches);
	}

	public static void doPartTwo(List<String> lines) {

		int numMatches = 0;
		for (String line : lines) {
			// get the colon
			int colonPosition = line.indexOf(":");
			// get the pattern
			String pattern = line.substring(0, colonPosition);
			int firstBound = Integer.parseInt(pattern.substring(0,pattern.indexOf("-")));
			int secondBound = Integer.parseInt(pattern.substring(pattern.indexOf("-")+1, pattern.indexOf(" ")));
			String matchString = pattern.substring(pattern.length() - 1);

			// get the rest
			String password = line.substring(colonPosition+2);

			if (password.substring(firstBound - 1, firstBound).equals(matchString) ){
				// first matches, second can't
				if (!password.substring(secondBound - 1, secondBound).equals(matchString) ) {
					numMatches += 1;
				}
			}
			else {
				// first didn't match
				if (password.substring(secondBound - 1, secondBound).equals(matchString) ) {
					numMatches += 1;
				}
			}

		}

		System.out.println(numMatches);
	}
	
}
