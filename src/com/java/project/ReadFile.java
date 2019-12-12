package com.java.project;

import java.io.*;
import java.util.*;

public class ReadFile {

	Scanner x;
	Grid grid = Grid.getInstance();
	LinkedList<String> gates = new LinkedList<String>();
	
	
	public void openFile(String path)
	{
		try {
			x = new Scanner(new File(path));
		}
		catch(Exception e) {
			System.out.println("Nie znaleziono pliku" + e);
		}
	}
	
	public void Read() 
	{
		ConvertData converter = new ConvertData();
		
		while(x.hasNext()) 
		{
			String a = x.next();
			String b = x.next();
			
			Vector3 v1 = converter.CheckPattern(a);
			Vector3 v2 = converter.CheckPattern(b);
			
			grid.CloseGate(v1,v2);
			System.out.println("v1: " + v1.x + v1.y + v1.z + " v2: " + v2.x + v2.y + v2.z);
		}
		
	}
	
	public void CloseFile()
	{
		x.close();
	}
	
	public void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	gates.add(fileEntry.getAbsolutePath());
	            System.out.println(fileEntry.getName());
	        }
	    }
	}
	
	public void LoadFile()
	{
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Podaj œcie¿kê dostêpu do plików: ");
		String directory = sc.next();
		
		
		final File folder = new File(directory);
		
		//D:\\Documents\\Code\\SpaceStation\\Gates
		listFilesForFolder(folder);
		grid.SetParameters();
		
		sc.close();
		
	}
}
