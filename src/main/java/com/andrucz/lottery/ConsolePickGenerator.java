package com.andrucz.lottery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public final class ConsolePickGenerator {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			for (;;) {
				System.out.print("Numbers count: ");
				int count = Integer.parseInt(reader.readLine());
				
				System.out.print("Minimum: ");
				int min = Integer.parseInt(reader.readLine());
				
				System.out.print("Maximum: ");
				int max = Integer.parseInt(reader.readLine());
				
				System.out.print("Picks: ");
				int picks = Integer.parseInt(reader.readLine());
				
				StringBuilder sb = new StringBuilder();
				
				for (int i = 0; i < picks; i++) {
				
					Set<Integer> pick = PickGenerator.generatePick(count, min, max);
					
					for (Integer n : pick) {
						sb.append(n).append('\t');
					}
					sb.append("\r\n");
				}
				
				System.out.println(sb.toString());
			}
			
		} finally {
			reader.close();
		}
	}
	
}
