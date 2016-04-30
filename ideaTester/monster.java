package ideaTester;

import java.util.*;
import java.io.*;

public class monster 
{
	private Scanner read;
	File file1;
	private String mName;
	private String mDescrip;
	private String mStats;
	//private int level;
	private int habitat;
	private int wQuad;                                                         
	stats monsterStats;
	private int baseLvl, hp, strength, defense, speed, intellegence, observation;
	private String condition;
	Map location = new Map();
	public monster(String mName, int wQuad)
	{
		
		habitat = wQuad % 10;
		wQuad = wQuad / 10;
		baseLvl = (( wQuad * habitat) + 3);
		monsterStats = new stats(baseLvl);
		mStats = monsterStats.toString();
		hp = monsterStats.getHp();
		strength = monsterStats.getStrength();
		defense = monsterStats.getDefense();
		speed = monsterStats.getSpeed();
		intellegence = monsterStats.getIntellegence();
		observation = monsterStats.getObservation();
		
	}
	public String getMonCondition(int healthPercentage, String mName) throws FileNotFoundException
	{
		file1 = new File("C:\\Users\\Naeem A. T-Pearson\\Desktop\\School Books& programs\\eclipse\\ideaTester\\src\\ideaTester\\monster\\" + mName + ".txt");
		System.out.println(mName);
		String line;
		read = new Scanner(file1);
		while(read.hasNextLine())
		{
			line = read.nextLine();
			if(line.length() < 4)
			{
				if((Integer.parseInt(line) == 100) && (healthPercentage == 100))
				{
					condition = read.nextLine();
					
				}
				else if((Integer.parseInt(line) >= 65) && (healthPercentage >= 65))
				{
					condition = read.nextLine();
				}
				else if((Integer.parseInt(line) >= 30) && (healthPercentage >= 30))
				{
					condition = read.nextLine();
				}
				else
				{
					if((Integer.parseInt(line) >= 0) && (healthPercentage >= 0))
					{
						condition = read.nextLine();
					}
					
				}
			}
			
		}
		return condition;
	}
	public void setMonBaseLvl(int baseLvl)
	{
		this.baseLvl = baseLvl;
	}
	public int getMonBaseLvl()
	{
		return baseLvl;
	}
	public void setMonhp(int hp)
	{
		this.hp = hp;
	}
	public int getMonHp()
	{
		return hp;
	}
	public void setMonStrength(int strength)
	{
		this.strength = strength;
	}
	public int getMonStrength()
	{
		return strength;
	}
	public void setMonDefense(int defense)
	{
		this.defense = defense;
	}
	public int getMonDefense()
	{
		return defense;
	}
	public void setMonSpeed(int speed)
	{
		this.speed = speed;
	}
	public int getMonSpeed()
	{
		return speed;
	}
	public void setMonIntellegence(int intellegence)
	{
		this.intellegence = intellegence;
	}
	public int getMonIntellegence()
	{
		return intellegence;
	}
	public void setMonOvservation(int observation)
	{
		this.observation = observation;
	}
	public int getMonObservation()
	{
		return observation;
	}
	public String monString()
	{
		return "Monster = " + mName + "\n" + 
			   "Monster description = " + mDescrip + "\n" + 
			   "Monster stats = " + mStats;
	}
	
}
