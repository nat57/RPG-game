package ideaTester;

import java.io.FileNotFoundException;
import java.util.*;

public class player 
{
	private String pName;
	private String pDescrip;
	private String pEquip;
	private String companion;
	private String pStats;
	private int lvlV, healthV, attackV, defV, spdV, strV, obsV, intelV, expAmtV, wDV, aV;
	Random randomGenerator = new Random();
	private saveLoad loadData = new saveLoad();
	stats playerStats;
	stats loadStats;
	private equipPiece hA = new equipPiece("head");
	private equipPiece ubA = new equipPiece("UprB");
	private equipPiece lbA = new equipPiece("LwrB");
	equipPiece loadHead;
	equipPiece loadUprB;
	equipPiece loadLwrB;
	private weaponStuffs wD = new weaponStuffs();
	weaponStuffs loadWeapon;
	equipment  playerEquipment = new equipment();
	
	
	
	public player(String playerName) throws FileNotFoundException
	{
		loadWeapon = new weaponStuffs(pName);
		playerStats = new stats(pName);
		loadHead = new equipPiece("000004", "head");
		loadUprB = new equipPiece("000004", "uprB");
		loadLwrB = new equipPiece("000004", "lwrB");
		pName = loadData.load("000001", "plyrName");
		pDescrip = loadData.load("000002", "plyrDescrip");
		pStats = playerStats.toString();
		lvlV = playerStats.getLvl();
		healthV = playerStats.getHp();
		wDV = Integer.parseInt(loadWeapon.getWeaponDamage());
		aV = Integer.parseInt(loadHead.getArmorV("head")) + Integer.parseInt(loadUprB.getArmorV("UprB")) + Integer.parseInt(loadLwrB.getArmorV("LwrB"));
		strV = playerStats.getStrength();
		attackV =  strV+ wDV;
		defV =  playerStats.getDefense() + aV;
		spdV = playerStats.getSpeed();
		obsV = playerStats.getObservation();
		intelV = playerStats.getIntellegence();
		expAmtV = playerStats.getExpAmt();
	}

	public player(String playerName, String description)
	{
		playerStats = new stats();
		pName = playerName;
		pDescrip = description;
		pStats = playerStats.toString();
		pEquip = playerEquipment.myString();
		companion = "handy (:o)";
		lvlV = playerStats.getLvl();
		healthV  = playerStats.getHp();
		wDV = Integer.parseInt(wD.getWeaponDamage());
		aV = Integer.parseInt(hA.getArmorV("head")) + Integer.parseInt(ubA.getArmorV("UprB")) + Integer.parseInt(lbA.getArmorV("LwrB"));
		attackV = playerStats.getStrength() + wDV;
		defV =  playerStats.getDefense() + aV;
		spdV = playerStats.getSpeed();
		obsV = playerStats.getObservation();
		intelV = playerStats.getIntellegence();
		expAmtV = playerStats.getExpAmt();
	}
	
	
	//public get
	
	
	public void setLvlV(int lvlV) 
	{
		this.lvlV = lvlV;
	}
	public int getLvlV() 
	{
		return lvlV;
	}
	public void setHealthV(int healthV) 
	{
		this.healthV = healthV;
	}
	public int getHealthV() 
	{
		return healthV;
	}
	public void setStrV(int strV) 
	{
		this.strV = strV;
	}
	public int getStrV() 
	{
		return strV;
	}
	public void setAttackV(int attackV) 
	{
		this.attackV = attackV;
	}
	public int getAttackV() 
	{
		return attackV;
	}
	public void setDefV(int defV) 
	{
		this.defV = defV;
	}
	public int getDefV() 
	{
		return defV;
	}
	public void setSpdV(int spdV) 
	{
		this.spdV = spdV;
	}
	public int getSpdV() 
	{
		return spdV;
	}
	public void setObsV(int obsV) 
	{
		this.obsV = obsV;
	}
	public int getObsV() 
	{
		return obsV;
	}
	public void setIntelV(int intelV) 
	{
		this.intelV = intelV;
	}
	public int getIntelV() 
	{
		return intelV;
	}
	public void setExpAmtV(int expAmtV, int mLvl) 
	{
		this.expAmtV = playerStats.expGain(lvlV, mLvl);;
	}
	public int getExpAmtV() 
	{
		return expAmtV;
	}
	public void setSDV(int wDV) 
	{
		this.wDV = wDV;
	}
	public int getWDV() 
	{
		return wDV;
	}
	public void setaV(int aV) 
	{
		this.aV = aV;
	}
	public int getaV() 
	{
		return aV;
	}
	

	
	
	public String toString()
	{
		return "Player name = " + pName + "\n" + 
			   "Player Description = " + pDescrip + "\n" +
			   "Player stats = " + pStats + "\n" + 
			   "Player equipment = " + pEquip + "\n" + 
			   "Companion = " + companion;
	}
}
