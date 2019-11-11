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
	    public void CloseDoor(Vector3 first, Vector3 second) 
		{
			
		}
	    
	/*
	File file = new File("DoorList.txt");
    Scanner in = new Scanner(file);
    
	int size = 0;
	File blackList;
	
	
	public Grid(int size,String closeDoor) 
	{
		Cell[] grid = new Cell[size];
	}

	void ReadDoorList() 
	{
		

        String zdanie = in.nextLine();
        System.out.println(zdanie);
	}	
	*/
}
