package com.java.project;

import java.util.Scanner;

public class Grid {
	
	//Singleton
	 private static Grid INSTANCE;

	    private Grid() {
	    }

	    public static Grid getInstance() {
	        if(INSTANCE == null) {
	            INSTANCE = new Grid();
	        }
	        return INSTANCE;
	    }
	   
	  //Rest of code
	    int gridSize = 10;
	    int size = 2*gridSize+1;
    	boolean[][][] grid = new boolean[size][size][size];
    	
    	
    	public Room node;
    	public Room target;
    	public Vector3 targetVek;
    	
	    public void CreateGrid() 
		{
	    	
	    	for(int j=0;j<size;j++)
	    		for(int i =0;i<size;i++)
	    			for(int k=0;k<size;k++)
	    				grid[i][j][k] = true;
	    	
	    	for(int j=0;j<size;j++) 
	    	{
	    		for(int i =0;i<size;i++) 
		    	{
		    		grid[0][j][i] = false;
		    		grid[j][0][i] = false;
		    		
		    		grid[j][size-1][i] = false;
		    		grid[size-1][j][i] = false;
		    		
		    	}
	    		
	    	}
	    	
	    	for(int j=1;j<size-1;j+=2)
	    		for(int i=2;i<size-2;i+=2)
	    			for(int k=2;k<size-2;k+=2)
	    				grid[k][i][j] = false;
	    	
	    	for(int j=0;j<size;j+=2)
	    		for(int i=1;i<size-1;i++)
	    			for(int k=1;k<size-1;k++)
	    				grid[k][i][j] = false;
	    	
	    	for(int j=2;j<size-2;j+=2)
	    		for(int i=1;i<size-1;i+=2)
	    			for(int k=1;k<size-1;k+=2)
	    				grid[k][i][j] = true;
	    	
	    	
		}
	    
	    
	    public boolean CheckPlace(Vector3 vekA,Vector3 vekB)
	    {
	    	Vector3 gate = FindGate(vekA,vekB);
	    	
	    	if(!grid[gate.x][gate.y][gate.z]) 
	    		Printer.getInstance().encounteredGates += String.format("#: %d%d%d \n",gate.x,gate.y, gate.z);
	    	
	    	return grid[gate.x][gate.y][gate.z];
	    
	    }
	    
	    public boolean CheckBorders(Vector3 current,Vector3 vek)
	    {
	    	if(vek.x>gridSize || vek.x<1) return false;
	    	if(vek.y>gridSize || vek.y<1) return false;
	    	if(vek.z>gridSize || vek.z<1) return false;
	    	
	    	if(!CheckPlace(current,vek)) return false;
	    		
	    	
	    	return true;
	    }
	    
	    public boolean isRoom(Vector3 vek)
	    {
	    	return grid[vek.x*2-1][vek.y*2-1][vek.z*2-1];
	    }
	    
	    public Vector3 FindGate(Vector3 vekA,Vector3 vekB)
	    {
	    	//Fake copy
	    	
	    	Vector3 vek1 = new Vector3(vekA.x,vekA.y,vekA.z);
	    	Vector3 vek2 = new Vector3(vekB.x,vekB.y,vekB.z);
	    	
	    	Vector3 gate = vek2.SubVector(vek2,vek1);
	    	
	    	//Calculate gate coordinate
	    	int sum = gate.Sum();
	    	
	    	if(sum==1 ||sum ==-1) 
	    	{
	    		vek1.x = vek1.x*2-1;
	    		vek1.y = vek1.y*2-1;
	    		vek1.z = vek1.z*2-1;
	    		
	    		if(gate.x!=0) vek1.x+=sum;
	    		else if(gate.y!=0) vek1.y+=sum;
	    		else if(gate.z!=0) vek1.z+=sum;
	    			
	    	}
	    	
	    	return vek1;
	    	
	    }
	    
	    public void CloseGate(Vector3 vekA,Vector3 vekB)
	    {
	    	Vector3 gate = FindGate(vekA,vekB);
	    	
	    	grid[gate.x][gate.y][gate.z] = false;
	    	
	    }

	    public void SetParameters()
	    {
	    	Scanner sc = new Scanner(System.in); 
			
			System.out.println("Podaj punkt startu i koñca: ");
			int[] a = new int[6];
			try {
				
				for(int i = 0;i<6;i++) a[i] = sc.nextInt();
			
			}catch(Exception e) {
				System.out.println("Niepoprawy vektor" + e);
			}
			sc.close();
			
			for(int i = 0;i<6;i++) {
				if(a[i]>gridSize || a[i]<1)
					throw new IllegalArgumentException("To ten sam wektor mistrzu!");
			}
			
			if(a[0]==a[3] && a[1]==a[4] && a[2]==a[5])
				throw new IllegalArgumentException("To ten sam wektor mistrzu!");
			
			node = new Room(a[0],a[1],a[2]);
			targetVek = new Vector3(a[3],a[4],a[5]);
			
	    }
}
