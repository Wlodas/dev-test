package pl.lsnova.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) throws FileNotFoundException {
		Graph graph = new Graph();
		
		try (Scanner fileScanner = new Scanner(new File(args[0]))) {
			fileScanner.nextLine(); // skipping unused edge count line
			while (fileScanner.hasNextLine()) {
				Scanner lineScanner = new Scanner(fileScanner.nextLine());
				graph.addEdge(lineScanner.nextInt(), lineScanner.nextInt());
			}
		}
		
		System.out.println(graph.countSubGraphs());
	}
}