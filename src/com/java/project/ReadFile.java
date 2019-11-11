package com.java.project;

import java.io.*;
import java.util.*;

public class ReadFile {

	Scanner x;
	
	
	public void openFile()
	{
		try {
			x = new Scanner(new File("D:\\Documents\\Code\\EclipseWorkspace\\SpaceStation\\src\\com\\java\\project\\DoorList.txt"));
		}
		catch(Exception e) {
			System.out.println("file not found");
		}
	}
	
	public void Read() 
	{
		ConvertData converter = new ConvertData();
		
		while(x.hasNext()) 
		{
			String a = x.next();
			String b = x.next();
			
			converter.ConvertToNumbers(a);
			System.out.println("   ");
			converter.ConvertToNumbers(b);
			System.out.println("\n");
		}
		
	}
	
	public void CloseFile()
	{
		x.close();
	}
}
