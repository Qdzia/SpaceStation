package com.java.project;

public class ConvertData {

	public Vector3 ConvertToNumbers(String s)
	{
		//StringBuilder tmp = new StringBuilder("");
		String tmp = "";
		int limit = 0;
		StringBuilder sB = new StringBuilder(s);
		Vector3 cor = new Vector3(0,0,0);
		int min = 64;
		int max = 91;
		int stage = 0;
		
		for(int i=0;i<s.length();i++)
		{
			
			if((int)sB.charAt(i) > min && (int)sB.charAt(i) < max ) 
			{
				
				tmp = addChar(tmp,sB.charAt(i));
				limit++;
			}
			else if(limit==0) {
				System.out.println("Nie uda³o siê wczytaæ liczb, sprawdz ich poprawnoœæ");
				return new Vector3(0,0,0);
			}
			else 
			{
				System.out.println(StrToInt(tmp,stage) + "  ");
				if(stage==0) {max =123; min = 96; stage++;}
				else if(stage==1) {max =58; min = 47; stage++;}
				else System.out.println("B³ad odczytu");
				limit=0;
				i--;
			}
			
			
			
			
		}
		
		
		//String ss = tmp.toString();
		//cor.x =Integer.parseInt(ss);
		
		return cor;
		
		//System.out.println("Vector eql: " + cor.x + "  " + cor.y + "  " + cor.z);	
	}
	
	public int StrToInt(String s,int stage)
	{
		if(stage == 2) return Integer.parseInt(s);
		if(stage == 1) {
			
			StringBuilder tmp = new StringBuilder(s);
			return (int)tmp.charAt(0)-96;
		}
		if(stage == 0) return 8;
		
		System.out.println("B³ad conversji");
		return 999;
		
	}
	
	public String addChar(String str, char ch) {
		System.out.println(str + "\n");
		int position = str.length();
	    StringBuilder sb = new StringBuilder(str);
	    sb.insert(position, ch);
	    return sb.toString();
	}
		
}

