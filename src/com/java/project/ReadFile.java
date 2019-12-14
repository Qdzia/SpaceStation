package com.java.project;

import java.io.*;
import java.util.*;

public class ReadFile {

	Scanner x;
	Grid grid = Grid.getInstance();
	LinkedList<String> gates = new LinkedList<String>();
	Printer printer = Printer.getInstance();
	
	
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
			printer.gatesList += String.format("[Gate %d%d%d : %d%d%d] \n",v1.x, v1.y, v1.z, v2.x, v2.y, v2.z);
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
	        	printer.filenames.add(fileEntry.getName());
	        }
	    }
	}
	
	public void LoadFile()
	{
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Podaj �cie�k� dost�pu do plik�w: ");
		String directory = sc.next();
		//String directory = "D:\\Documents\\Code\\SpaceStation\\Gates";
		
		final File folder = new File(directory);
	
		listFilesForFolder(folder);
		grid.SetParameters();
		
		sc.close();
		
	}

}
