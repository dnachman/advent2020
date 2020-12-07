package com.logicalenigma.advent2020;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;


public class TobogganTrajectory {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("src/main/resources", "day3.txt"));

		long result = doPartOne(lines, 1, 1) * doPartOne(lines, 3, 1) * doPartOne(lines, 5, 1) * doPartOne(lines, 7, 1) * doPartOne(lines, 1, 2);
		System.out.println("Final " + result);
	}

	public static int doPartOne(List<String> lines, int rightSteps, int downSteps) {

		int numTrees = 0;
		int horizontalIndex = 0;
		int verticalIndex = 0;
		Object[] lineArray = lines.toArray();

		// for first row, increment immediately
		verticalIndex += downSteps;
		int lineWidth = ((String)lineArray[verticalIndex]).length();
		while (verticalIndex < lineArray.length) {
			boolean tree = false;
			// check 
			horizontalIndex += rightSteps;
			int normalizedIndex = horizontalIndex % lineWidth;
			String line = (String) lineArray[verticalIndex];
			String point = line.substring(normalizedIndex, normalizedIndex + 1);
			// System.out.println(point);
			if (point.equals("#")) {
				numTrees += 1;
				tree = true;
			}

			// debug
			System.out.println(verticalIndex + " : " + line.substring(0, normalizedIndex) + (tree ? "X" : "O") + line.substring(normalizedIndex+1));

			verticalIndex += downSteps;

		}

		System.out.println(numTrees);
		return numTrees;
	}
	
}
