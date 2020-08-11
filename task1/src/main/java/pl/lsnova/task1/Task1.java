package pl.lsnova.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 {
	public int[] solution(int[] input) {
		return Arrays.stream(input)
			.distinct()
			.sorted()
			.toArray();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		IntStream.Builder streamBuilder = IntStream.builder();
		
		try (Scanner scanner = new Scanner(new File(args[0]))) {
			while (scanner.hasNextInt()) {
				streamBuilder.accept(scanner.nextInt());
			}
		}
		
		int[] input = streamBuilder.build().toArray();
		int[] output = new Task1().solution(input);
		
		System.out.println(Arrays.stream(output)
			.mapToObj(Integer::toString)
			.collect(Collectors.joining(" ")));
		System.out.println("count: " + input.length);
		System.out.println("distinct: " + output.length);
		System.out.println("min: " + output[0]);
		System.out.println("max: " + output[output.length - 1]);
	}
}