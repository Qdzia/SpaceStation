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
		while(x.hasNext()) 
		{
			String a = x.next();
			String b = x.next();
			
			System.out.printf("%s %s \n", a,b);
		}
		
	}
	
	public void CloseFile()
	{
		x.close();
	}
}
