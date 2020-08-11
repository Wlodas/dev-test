package pl.lsnova.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task2 {
	private static final int SUM_VALUE_OF_PAIR = 13;
	
	public List<IntPair> solution(int[] input) {
		List<IntPair> pairs = new ArrayList<>();
		
		for (int firstNumberIndex = 0; firstNumberIndex < input.length - 1; firstNumberIndex++) {
			for (int secondNumberIndex = firstNumberIndex + 1; secondNumberIndex < input.length; secondNumberIndex++) {
				int first = input[firstNumberIndex];
				int second = input[secondNumberIndex];
				
				if (first + second == SUM_VALUE_OF_PAIR) {
					pairs.add(new IntPair(Math.min(first, second), Math.max(first, second)));
				}
			}
		}
		
		pairs.sort(Comparator.comparingInt(IntPair::getLeft));
		
		return pairs;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		IntStream.Builder streamBuilder = IntStream.builder();
		
		try (Scanner scanner = new Scanner(new File(args[0]))) {
			while (scanner.hasNextInt()) {
				streamBuilder.accept(scanner.nextInt());
			}
		}
		
		List<IntPair> pairs = new Task2().solution(streamBuilder.build().toArray());
		
		pairs.forEach(pair -> System.out.println(pair.getLeft() + " " + pair.getRight()));
	}
}