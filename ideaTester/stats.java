package ideaTester;

import java.io.FileNotFoundException;
import java.util.*;

public class stats 
{
	private int lvl = 1;
	private int hp = 100;
	private int strength = 5;
	private int speed = 5;
	private int defense = 5;
	private int observation = 5;
	private int intellegence = 5;
	private int expAmt = 0;
	//player p1 = new player(pName, pDescrip);
	Random randomGenerator = new Random();
	saveLoad sOrL = new saveLoad();
	
	public stats()
	{
		lvl = 1;
		hp = 100;
		strength = 20;
		defense = 20;
		speed = 20;
		observation = 20;
		intellegence = 20;
		expAmt = 100;
	}
	public stats(String pName) throws NumberFormatException, FileNotFoundException
	{
		lvl = Integer.parseInt(sOrL.load("000003", "Level"));
		hp = Integer.parseInt(sOrL.load("000003", "Health"));
		strength = Integer.parseInt(sOrL.load("000003", "Strength"));
		defense = Integer.parseInt(sOrL.load("000003", "Defense"));
		speed = Integer.parseInt(sOrL.load("000003", "Speed"));
		observation = Integer.parseInt(sOrL.load("000003", "Observation"));
		intellegence = Integer.parseInt(sOrL.load("000003", "Intellegence"));
		expAmt = Integer.parseInt(sOrL.load("000003", "ToNextLevel"));
	}
	//beginning monster statistics
	//as monsters will be able to spawn in random areas at whatever level this  will allow them to have 
	public stats(int level)
	{
		lvl = level;
		int mBonus;
		expAmt = 0;
		hp = 100;
		for(int i = 0; i < lvl; i++)
		{ 
			mBonus = randomGenerator.nextInt(5);
			System.out.println("I propose a test");
			switch(mBonus)
			{
			
				case 0: hp = hp + 6;
						break;
			
				case 1:	strength = strength + 6;
						break;
				
				case 2: defense = defense + 6;
						break;
				
				case 3: speed = speed + 6;
						break;
				
				case 4: intellegence = intellegence + 6;
						break;
			}
		}
		observation = intellegence;
		
	}
	
	public int expGain(int pLevel, int mLevel)
	{
		int expGained;
		expGained = mLevel / pLevel;
		expAmt = expAmt + expGained;
		setExpAmt(expAmt);
		
		return expAmt;
	}
	public String lvlUp(int expAmt, int level, int pChoice)
	{
		lvl = level + 1;
		setLvl(lvl);
		String lvledStat = "";
		switch(pChoice)
		{
			case 0: 
				{
					hp = hp + 6;
					setHp(hp);
					lvledStat = "HealthV";
					break;
				}
			case 1:	
				{
					strength = strength + 6;
					setStrength(strength);
					lvledStat = "HtrV";
					break;
				}
			case 2: 
				{
					defense = defense + 6;
					setDefense(defense);
					lvledStat = "DefV";
					break;
				}
			case 3: 
				{
					speed = speed + 6;
					setSpeed(speed);
					lvledStat = "SpdV";
					break;
				}
			case 4: 
				{
					intellegence = intellegence + 6;
					setIntellegence(intellegence);
					lvledStat = "IntelV";
					break;
				}
					
		}
		return lvledStat;
	}
	public void setLvl(int lvl)
	{
		this.lvl = lvl;
	}
	public int getLvl()
	{
		return lvl;
	}
	public void setHp(int hp)
	{
		this.hp = hp;
	}
	public int getHp()
	{
		return hp;
	}
	public void setStrength(int strength)
	{
		this.strength = strength;
	}
	public int getStrength()
	{
		return strength;
	}
	public void setDefense(int defense)
	{
		this.defense = defense;
	}
	public int getDefense()
	{
		return defense;
	}
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}	
	public int getSpeed()
	{
		return speed;
	}
	public void setObservation(int observation)
	{
		this.observation = observation;
	}
	public int getObservation()
	{
		return observation;
	}
	public void setIntellegence(int intellegence)
	{
		this.intellegence = intellegence;
	}
	public int getIntellegence()
	{
		return intellegence;
	}
	public void setExpAmt(int expAmt)
	{
		this.expAmt = expAmt;
	}
	public int getExpAmt()
	{
		return expAmt;
	}
	
	

	
	
	
	
	public String toString()
	{
		return "Lvl = " + getLvl() + "\n" +
			   "HP = " + getHp() + "\n" + 
			   "Strength = " + getStrength() + "\n" +
			   "Defense = " + getDefense() + "\n" +
			   "Speed = " + getSpeed() + "\n" +
			   "Observation = " + getObservation() + "\n" + 
			   "Intellegence = " + getIntellegence() + "\n" + 
			   "current amount of exp= " + getExpAmt();
	}
}
