package com.java.project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertData {
	
	

	public Vector3 CheckPattern(String s)
	{
		RomanToNumber romeConventer = new RomanToNumber();
		Vector3 cor = new Vector3(-1,-1,-1);
		
		//Patterns of input
		Pattern pattern = Pattern.compile("[VILXC]+[a-z][1-9]+");
		Pattern rome = Pattern.compile("[VILXC]+");
		Pattern letter = Pattern.compile("[a-z]");
		Pattern number = Pattern.compile("[1-9]+");
		
		String str="";
		Matcher m = pattern.matcher(s);
		
		//Check order of pattern
		if(m.matches())
		{
			//Convert rome numbers
			m = rome.matcher(s);
			while (m.find())  str = m.group(0);   
			
			cor.z = romeConventer.romanToDecimal(str);
			
			
			//Convert letters numbers
			m = letter.matcher(s);
			while (m.find()) str = m.group(0); 
			
			char c=str.charAt(0);
			cor.y = (int) c - 96;
			
			
			//Convert numbers to integer
			m = number.matcher(s);
			while (m.find()) str = m.group(0);
			
			cor.x = Integer.parseInt(str);
			
			
			return cor;
		}
		else System.out.println("B³¹d odczytu");
		
		return null;
		
	}
	
}

