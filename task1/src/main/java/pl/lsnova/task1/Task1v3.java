package pl.lsnova.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1v3 {
	public SortedSet<Integer> solution(int[] input) {
		SortedSet<Integer> set = new TreeSet<>();
		for (int n : input) {
			set.add(n);
		}
		return set;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		IntStream.Builder streamBuilder = IntStream.builder();
		
		try (Scanner scanner = new Scanner(new File(args[0]))) {
			while (scanner.hasNextInt()) {
				streamBuilder.accept(scanner.nextInt());
			}
		}
		
		int[] input = streamBuilder.build().toArray();
		SortedSet<Integer> output = new Task1v3().solution(input);
		
		System.out.println(output.stream()
			.map(Object::toString)
			.collect(Collectors.joining(" ")));
		System.out.println("count: " + input.length);
		System.out.println("distinct: " + output.size());
		System.out.println("min: " + output.first());
		System.out.println("max: " + output.last());
	}
}