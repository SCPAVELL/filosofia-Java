package firstProgrammJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelloDate {

	private static List<Double> movingAverage(int n, List<Integer> arr, int windowSize) {
		// ваше решение
		List<Double> result = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < windowSize; i++) {
			sum += arr.get(i);
		}
		result.add((double) sum / windowSize);

		for (int i = windowSize; i < n; i++) {
			sum += arr.get(i) - arr.get(i - windowSize);
			result.add((double) sum / windowSize);
		}

		return result;

	}

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
			int n = readInt(reader);
			List<Integer> arr = readList(reader);
			int windowSize = readInt(reader);
			List<Double> result = movingAverage(n, arr, windowSize);
			for (double elem : result) {
				writer.write(elem + " ");
			}
		}
	}

	private static int readInt(BufferedReader reader) throws IOException {
		return Integer.parseInt(reader.readLine());
	}

	private static List<Integer> readList(BufferedReader reader) throws IOException {
		return Arrays.asList(reader.readLine().split(" ")).stream().map(elem -> Integer.parseInt(elem))
				.collect(Collectors.toList());
	}
}