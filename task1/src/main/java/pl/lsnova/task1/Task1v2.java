package pl.lsnova.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1v2 {
	public BitSet solution(int[] input) {
		BitSet bitSet = new BitSet();
		for (int n : input) {
			bitSet.set(n);
		}
		return bitSet;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		IntStream.Builder streamBuilder = IntStream.builder();
		
		try (Scanner scanner = new Scanner(new File(args[0]))) {
			while (scanner.hasNextInt()) {
				streamBuilder.accept(scanner.nextInt());
			}
		}
		
		int[] input = streamBuilder.build().toArray();
		BitSet output = new Task1v2().solution(input);
		
		System.out.println(output.stream()
			.mapToObj(Integer::toString)
			.collect(Collectors.joining(" ")));
		System.out.println("count: " + input.length);
		System.out.println("distinct: " + output.cardinality());
		System.out.println("min: " + output.nextSetBit(0));
		System.out.println("max: " + output.previousSetBit(Integer.MAX_VALUE));
	}
}