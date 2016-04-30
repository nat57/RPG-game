package ideaTester;

import java.io.FileNotFoundException;

//import java.util.*;

public class weaponStuffs 
{
	private String weaponName;
	private String weaponDescrip;
	private String weaponDamage;
	private String weaponWeight;
	saveLoad sOrL = new saveLoad();
	public weaponStuffs()
	{
		weaponName = "Multi purpose Stick";
		weaponDescrip = "Multi purpose huh ......... sounds like fun .... helpful even";
		weaponDamage = "2";
		weaponWeight = "0";
	}
	
	public weaponStuffs(String pName) throws FileNotFoundException
	{
		try {
			weaponName = sOrL.load("000005", "Name");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		weaponDescrip = sOrL.load("000005", "Description");
		weaponDamage = sOrL.load("000005", "Damage");
		weaponWeight = sOrL.load("000005", "weight");
	}
	
	public void setWeaponName(String weaponName)
	{
		this.weaponName = weaponName;
	}
	public String getWeaponName()
	{
		return weaponName;
	}
	public void setWeaponDescrip(String weaponDescrip)
	{
		this.weaponDescrip = weaponDescrip;
	}
	public String getWeaponDescrip()
	{
		return weaponDescrip;
	}
	public void setWeaponDamage(String weaponDamage)
	{
		this.weaponDamage = weaponDamage;
	}
	public String getWeaponDamage()
	{
		return weaponDamage;
	}
	public void setWeaponWeight(String weaponWeight)
	{
		this.weaponWeight = weaponWeight;
	}
	
	public String getWeaponWeight()
	{
		return weaponWeight;
	}
	public String toString()
	{
		return "Weapon = " + getWeaponName() + "\n" +
			   "Description = " + getWeaponDescrip() + "\n" + 
			   "Attack = " + getWeaponDamage() + "\n" +
			   "Weight = " + getWeaponWeight();
	}
}
