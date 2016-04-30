package ideaTester;

import java.util.*;
import java.io.*;

public class saveLoad 
{
	Scanner loader = new Scanner("playerInfo");
	
	File plyrF = new File("C:\\Users\\Naeem A. T-Pearson\\Desktop\\School Books& programs\\eclipse\\ideaTester\\src\\ideaTester\\playerInfo.txt");
	PrintWriter plyrSave;
	//player
	private int lvl;
	private int hp;
	private int strength;
	private int speed;
	private int defense;
	private int observation;
	private int intellegence;
	private int toNextLvl;
	
	private String pieceName;
	private String pieceDescrip;
	private String weight;
	private String armorV;
	
	private String weaponName;
	private String weaponDescrip;
	private String weaponDamage;
	private String weaponWeight;
	
	public String save()
	{
		try
		{
			plyrSave = new PrintWriter(plyrF);
			
		}
		catch(FileNotFoundException e)
		{
			
		}
		return armorV;
		 
	}
	
	//System.out.println("testing" + " testing" + "123");
	//String test4 = "";
	//System.out.println("testing testing 123");
    
	//System.out.println("testing testing 123");
    //Scanner read = new Scanner(file1);
    //System.out.println("testing testing 123");
	public String loadPlyrName(String filePos, String areaPos)
	{
		String line = "";
		loader.next();
		if(loader.next().equalsIgnoreCase(areaPos))
		{
			line = loader.nextLine();
			return line;
		}
		return line;
	}
	public String loadPlyrDescription(String filePos, String areaPos)
	{
		String line = "";
		int pos = Integer.parseInt(filePos);
		loader.nextLine();
		if(loader.nextLine().equalsIgnoreCase(areaPos))
		{
			
			while(!loader.nextLine().equalsIgnoreCase("000003" + pos++))
			{
				line = line + loader.nextLine();
			}
			return line;
		}
		return line;
	}
	public String loadPlyrStats(String filePos, String areaPos)
	{
		String line = "";
		int pos = Integer.parseInt(filePos);
		loader.next();
		while(!loader.next().equalsIgnoreCase("000004" + pos++))
		{
			
			if(loader.next().equalsIgnoreCase(areaPos))
			{
				line = loader.next();
				return line;
			}
			loader.nextLine();
			loader.next();
		}
		return line;
	}
	public String loadPlyrArmor(String filePos, String areaPos)
	{
		String line = "";
		int pos = Integer.parseInt(filePos);
		loader.nextLine();
		while(!loader.nextLine().equalsIgnoreCase("000005" + pos++))
		{
			if(loader.nextLine().equalsIgnoreCase(areaPos))
			{
				if(loader.nextLine().substring(11,14).equalsIgnoreCase("name"))
				{
					line = loader.nextLine();
					return line;
				}
				else if(loader.nextLine().substring(11,21).equalsIgnoreCase("description"))
				{
					loader.nextLine();
					while(!loader.nextLine().substring(11,16).equalsIgnoreCase("weight"))
					{
						line = line + loader.nextLine();
					}
					return line;
				}
				else if(loader.nextLine().substring(11,16).equalsIgnoreCase("weight"))
				{
					line = loader.nextLine();
					return line;
				}
				else if(loader.nextLine().substring(11,15).equalsIgnoreCase("value"))
				{
					line = loader.nextLine();
					return line;
				}
				else
				System.out.println("Im sorry the information wasn't found there is a chance that your weapon was lost");
			}
		}
		return line;
	}
	public String loadPlyrWeapon(String filePos, String areaPos)
	{
		String line = "";
		int pos = Integer.parseInt(filePos);
		loader.nextLine();
		while(!loader.nextLine().equalsIgnoreCase("000006" + pos++))
		{
			if(loader.nextLine().equalsIgnoreCase(areaPos))
			{
				if(loader.nextLine().substring(8,11).equalsIgnoreCase("name"))
				{
					line = loader.nextLine();
					return line;
				}
				else if(loader.nextLine().substring(8,18).equalsIgnoreCase("description"))
				{
					loader.nextLine();
					while(!loader.nextLine().substring(8,13).equalsIgnoreCase("weight"))
					{
						line = line + loader.nextLine();
					}
					return line;
				}
				else if(loader.nextLine().substring(8,13).equalsIgnoreCase("weight"))
				{
					line = loader.nextLine();
					return line;
				}
				else if(loader.nextLine().substring(8,12).equalsIgnoreCase("value"))
				{
					line = loader.nextLine();
					return line;
				}
				else
				{
					System.out.println("Im sorry the information wasn't found there is a chance that your weapon was lost");
				}
			}
		}
		return line;
	}
	public String load(String filePos, String areaPos) throws FileNotFoundException
	{
		String line = "";
		int pos;
		while(loader.hasNextLine()) 
		{
			loader.nextLine();
			if(loader.nextLine().equals(filePos)) 
			{
				pos = Integer.parseInt(filePos);
				switch(pos)
				{
					case 1:
					{
						line = loadPlyrName(filePos, areaPos);
						return line;
					}
					case 2:
					{
						line = loadPlyrDescription(filePos, areaPos);
						return line;
					}
					case 3:
					{
						line = loadPlyrStats(filePos, areaPos);
						return line;
					}
					case 4:
					{
						line = loadPlyrArmor(filePos, areaPos);
						return line;
					}
					case 5:	
					{
						line = loadPlyrWeapon(filePos, areaPos);
						return line;
					}
					case 6:
					{
						break;
					}
					case 7:
					{
						break;
					}
				}
			}
		}
		loader.close();
		
	
		return line;
		
	}
	public void npcInteractions() throws FileNotFoundException
	{
	}
}
