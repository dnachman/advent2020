package com.logicalenigma.advent2020;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidPassport {

	public ValidPassport() {
	}

	public static void main(String[] args) throws IOException {
		ValidPassport vp = new ValidPassport();

		vp.doWork();
	}

	public void doWork() throws IOException {
		List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("src/main/resources", "day4.txt"));

		doPartOne(lines);
	}

	public void doPartOne(List<String> lines) {

		int numMatches = 0;
		Map<String,String> fields = new HashMap<>();;

		for (String line : lines) {
			if (line.equals("")) {
				// separator - check if valid
				if (isValid(fields)) {
					numMatches += 1;
				}

				// reset
				fields = new HashMap<>();

			}
			else {
				fields.putAll(parseLine(line));
			}
		}

		System.out.println(numMatches);
	}

	private Map<String, String> parseLine(String line) {
		Map<String, String> hashMap = new HashMap<>();

		String[] pairs = line.split(" ");
		for (String pair : pairs) {
			String[] nvp = pair.split(":");
			hashMap.put(nvp[0], nvp[1]);
		}

		return hashMap;
	}
	
	private boolean isValid(Map<String,String> fields) {

		if(fields.containsKey("byr") &&
				fields.containsKey("iyr") &&
				fields.containsKey("eyr") &&
				fields.containsKey("hgt") &&
				fields.containsKey("hcl") &&
				fields.containsKey("ecl") &&
				fields.containsKey("pid")) {
			return true;
		}
		return false;

	}

	
	
}
