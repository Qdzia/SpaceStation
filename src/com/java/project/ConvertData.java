package com.java.project;

public class ConvertData {

	public void ConvertToNumbers(String s)
	{
		StringBuilder tmp = new StringBuilder("");
		int stage = 0;
		StringBuilder sB = new StringBuilder(s);
		Vector3 cor = new Vector3(0,0,0);
		
		
		for(int i=0;i<s.length();i++)
		{
			
			/*if(stage==1) 
			{
				if((int)sB.charAt(i) > 64 && (int)sB.charAt(i) < 91) 
				{
					System.out.print("x");
				}
			}
			else 
			{
				
				stage=2;
				cor.z = 0;
				
			}	
			
			if(stage==2) 
			{
				if((int)sB.charAt(i) > 96 && (int)sB.charAt(i) < 123)
				{
					cor.y = (int)sB.charAt(i) - 97;
				}
			}
			else 
			{
				stage=2;
				
			} 
			
			if(stage==3) 
			{
				if((int)sB.charAt(i) > 47 && (int)sB.charAt(i) < 58)
				{
					tmp.append(sB.charAt(i));
				}
			}
			else 
			{
				String ss = tmp.toString();
				System.out.print(ss);
				cor.x =Integer.parseInt(ss);
				
			} */
			
			if((int)sB.charAt(i) > 64 && (int)sB.charAt(i) < 91 && stage==1) 
			{
				System.out.print("x");
			}else if((int)sB.charAt(i) > 96 && (int)sB.charAt(i) < 123 && stage==2) stage=2;
			else System.out.print("error");
			
			if((int)sB.charAt(i) > 96 && (int)sB.charAt(i) < 123 && stage==2)
			{
				cor.y = (int)sB.charAt(i) - 96;
			}else if((int)sB.charAt(i) > 47 && (int)sB.charAt(i) < 58 && stage==3) stage=3;
			
			if((int)sB.charAt(i) > 47 && (int)sB.charAt(i) < 58 && stage==3)
			{
				tmp.append(sB.charAt(i));
			}
			
			
			//System.out.println("\n\n====Nieprawidlowe dane wejsciowe=== \n");	
			
		}
		
		
		String ss = tmp.toString();
		cor.x =Integer.parseInt(ss);
		
		
		System.out.println("Vector eql: " + cor.x + "  " + cor.y + "  " + cor.z);	
	}
	
		
}

