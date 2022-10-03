package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the file full path: ");
		String Path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(Path))){
			
			Set<LogEntry> set = new HashSet<>();
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(" ");
				set.add(new LogEntry(fields[0], Date.from(Instant.parse(fields[1]))));
				
				line = br.readLine();
			}
			System.out.print("Total users: " + set.size());
			
		}
		
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		finally {
			sc.close();
		}

	}

}
