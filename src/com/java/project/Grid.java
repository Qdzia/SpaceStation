package com.java.project;


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
	    int gridSize = 5;
	    int size = 2*gridSize+1;
    	boolean[][][] grid = new boolean[size][size][size];
    	
    	
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
	    
	    public void DrawGrid() 
	    {
	    	
	    	for(int k=0;k<size;k++) {
	    		for(int j=0;j<size;j++) {
	    			for(int i =0;i<size;i++) {
	    				if(grid[i][j][k]==true) System.out.print("  "); 
	    				else System.out.print("# ");
	    			
	    			}
	    			System.out.println("");
	    		}
	    		
	    		System.out.println("===============================================[ "+ k + " ]====");
	    	}
	    	
	    	System.out.println("");
	    }
	    
	    public boolean CheckPlace(Vector3 vek1,Vector3 vek2)
	    {
	    	//convert to grid coordinate
	    	vek1.Multiply(2);
	    	vek2.Multiply(2);
	    	vek1.Minus(1);
	    	vek2.Minus(1);
	    	
	    	Vector3 gate = vek2.SubVector(vek2,vek1);
	    	
	    	//Calculate gate coordinate
	    	int sum = gate.Sum();
	    	
	    	if(sum==2 ||sum ==-2) 
	    	{
	    		if(gate.x!=0) vek1.x+=sum/2;
	    		else if(gate.y!=0) vek1.y+=sum/2;
	    		else if(gate.z!=0) vek1.z+=sum/2;
	    	}
	    	
	    	return grid[vek1.x][vek1.y][vek1.z+2];
	    	
	    }
	    
	    public boolean CheckBorders(Vector3 current,Vector3 vek)
	    {
	    	if(vek.x>gridSize || vek.x<1) return false;
	    	if(vek.y>gridSize || vek.y<1) return false;
	    	if(vek.z>gridSize || vek.z<1) return false;
	    	
	    	if(!CheckPlace(current,vek)) return false;
	    		
	    	return true;
	    }


}
