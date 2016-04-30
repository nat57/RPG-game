package ideaTester;
import java.util.*;
import java.io.*;

public class Map 
{
	//need to code player location
	//need to code places for wilderness
	//need to code places for cities
	//cities can have loops with nested switch statements calling for the places in the city
	//the places in the city will call functions that allow the player to choose options for what they can do at that store and read out the store information
	//every city will have a leave city option 
	//all points of wilderness can be reached only by city 000 or by city 
	//wilderness will be a strait shot
	//have a for loop that asks player if they want to return to a or b place or go 1 level deeper into the terrain
	//wilderness shall be catagorized 1 - 9 each will have 0 - 9 levels so wilderness 1 shall be reffered to at 10 and the first area shall be mod 10 of it
	//area 2 of it can be mod 10 of 11
	private int wQuad;
	private int habitat;
	private String location;
	private Scanner read;
	File file1;
	File file2;
	Random randomGenerator = new Random();
	int randomInt;
	rpgBattleSyst fight = new rpgBattleSyst();
	public int spawnPlayer()
	{
		//if the file does not exist
		wQuad = 05;
		//if the file exists read location of the player from the file
		return wQuad;
	}
	public String worldQuadrant(int wQuad)
	{
		file1 = new File("C:\\Users\\Naeem A. T-Pearson\\Desktop\\School Books& programs\\eclipse\\ideaTester\\src\\ideaTester\\gameMap.txt");
		location = "";
		String habitatDescrip = "";
	    try 
	    {

	        read = new Scanner(file1);
	        
	        while (read.hasNextLine()) 
	        {
	        	
	        	String line = read.nextLine();
	        	System.out.println(line);
	        	if(line.length() < 4)
	        	{	
	        		int num = Integer.parseInt(line);
	        		System.out.println(num);
	        		if(Integer.parseInt(line) == wQuad)
	        		{
	        			location = read.nextLine();
	        		}
	        		//habitatDescrip = habitatInfo(location, wQuad);
	        		break;
	        	}
	        	
	        	
	        	//should read location
	        	//String test = read.nextLine();
	        	//should read forest
	        	//String test2 = read.next();
	        	//should read 1
	        	//String test3 = read.next();
	        	//should read location
	        	//test4 = read.nextLine();
	        	//should read path to old kingdom
	        	//String test5 = read.next();
	        	// should read 2
	            //int i = read.nextInt();
	            //System.out.println(i);
	        }
	        read.close();
	        
	    } 
	    catch (FileNotFoundException e) 
	    {
	        e.printStackTrace();
	    }
	    
	    return location;
	}
	public String habitatInfo(String location, int wQuad)
	{
		String line = "";
		file1 = new File("C:\\Users\\Naeem A. T-Pearson\\Desktop\\School Books& programs\\eclipse\\ideaTester\\src\\ideaTester\\" + location + ".txt");
		habitat = wQuad%10;
	    try 
	    {
	        read = new Scanner(file1);
	        String line2 = read.nextLine();
	        String line3 = line2;
        	System.out.println(line3);
        	while(read.hasNextLine()) 
			{
        		if(line2.length() < 3)
        		{	
        			System.out.println("im here 2" + line2);
        			if(Integer.parseInt(line3) == habitat)
        			{
        				//location = read.nextLine(); 
        				line = line + read.nextLine();
        				while (read.hasNextLine()) 
        				{
        					line2 = read.nextLine();
        					System.out.println(line2);
        					if(line2.length() > 3)
        					{
        						line = line + "\n" + line2;
        					
        					}
        					else
        					{
        						break;
        					}
        				}		
        			}
        		}
			}
	        read.close();
	    }
	    catch (FileNotFoundException e) 
	    {
	        e.printStackTrace();
	    }
	    
	    return line;
	}
	public void foundMonster(String folderName, String mName, int wQuad) throws FileNotFoundException
	{
		String line = "";
		file1 = new File("C:\\Users\\Naeem A. T-Pearson\\Desktop\\School Books& programs\\eclipse\\ideaTester\\src\\ideaTester\\" + folderName + "\\" + mName + ".txt");
		//habitat = wQuad%10;
		System.out.println(folderName);
		String line2;
		 read = new Scanner(file1);
	    while(read.hasNextLine())
		{
			line = read.nextLine();
			System.out.println(line);
			if(line.equalsIgnoreCase("condition"))
			{
				break;
			}
		}
		read.close();
	}
	public String foundItem(String item)
	{
		System.out.println("I found a " + item);
		return item;
	}
	public String search(String location, int wQuad)
	{
		String line = "";
		String line3 ="";
		String found = "";
		file1 = new File("C:\\Users\\Naeem A. T-Pearson\\Desktop\\School Books& programs\\eclipse\\ideaTester\\src\\ideaTester\\" + location + ".txt");
		habitat = wQuad%10;
		String line2;
	    try 
	    {
	        read = new Scanner(file1);
        	while(read.hasNextLine()) 
			{
        		 line2 = read.nextLine();
        		System.out.println(line2);
        		if(line2.length() < 3)
        		{	
        			
        			if(Integer.parseInt(line2) == habitat)
        			{
        				break;		
        			}
        		}
			}//location = read.nextLine(); 
        	while (read.hasNextLine()) 
        	{
        		
        		line2 = read.nextLine();
        		line3 = line2;
        		if(line2.equalsIgnoreCase("search"))
        		{
        			
        			
        			//System.out.println("im here");
        			
        			randomInt = randomGenerator.nextInt(6);
        			break;
        		}
        	}
        	while(read.hasNextLine())
        	{
        		
        		line2 = read.nextLine();
        		if(line2.length() < 3)
        		{
        			line3 = line2;
        		}
        		if(Integer.parseInt(line3) == randomInt)
        		{
        			line = read.nextLine();
        			line2 = read.nextLine();
        			if(line.equalsIgnoreCase("monster"))
        			{
        				foundMonster(line, line2, wQuad);
        				return  line + " " + line2;
        			}
        			else if(line.equalsIgnoreCase("item"))
        			{
        				foundItem(line2);
        			}
        			else
        			{
        				System.out.println("well that was a wast of time. ...... I didn't find a thing");
        				break;
        			}
        		}
        	}
	        read.close();
	    }
	    catch (FileNotFoundException e) 
	    {
	        e.printStackTrace();
	    }
	    found = "nothing";
	    return found;
	}
	
}
