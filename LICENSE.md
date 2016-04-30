package ideaTester;

//import java.util.*;

public class equipment 
{
	public int quality = 0;
	private equipPiece head = new equipPiece("head");
	private equipPiece upperBody = new equipPiece("UprB");
	private equipPiece lowerBody = new equipPiece("LwrB");
	private weaponStuffs weapons = new weaponStuffs();
	
	public equipPiece getHead() 
	{
		return head;
	}
	public void setHead(equipPiece head) 
	{
		this.head = head;
	}
	public equipPiece getUpperBody() 
	{
		return upperBody;
	}
	public void setUpperBody(equipPiece upperBody) 
	{
		this.upperBody = upperBody;
	}
	public equipPiece getLowerBody() 
	{
		return lowerBody;
	}
	public void setLowerBody(equipPiece lowerBody) 
	{
		this.lowerBody = lowerBody;
	}
	public weaponStuffs getWeapons() 
	{
		return weapons;
	}
	public void setWeapons(weaponStuffs weapons) 
	{
		this.weapons = weapons;
	}


	private String[] helm = new String[4];
	private String[] upBod = new String[4];
	private String[] loBod = new String[4];
	private String[] weapon = new String[4];
	
	public equipment()
	{
		//int armorString;
		//int armorVH = Integer.parseInt(head.getArmorV("head"));
		//int armorVU;
		//int armorVL;
		helm[0] = head.getPieceName("head");
		helm[1] = head.getPieceDescrip("head");
		helm[2] = head.getArmorV("head");
		helm[3] = head.getWeight("head");
		upBod[0] = upperBody.getPieceName("upBod");
		upBod[1] = upperBody.getPieceDescrip("upBod");
		upBod[2] = upperBody.getArmorV("upBod");
		upBod[3] = upperBody.getWeight("upBod");
		loBod[0] = lowerBody.getPieceName("loBod");
		loBod[1] = lowerBody.getPieceDescrip("loBod");
		loBod[2] = lowerBody.getArmorV("loBod");
		loBod[3] = lowerBody.getWeight("loBod");
		weapon[0] = weapons.getWeaponName();
		weapon[1] = weapons.getWeaponDescrip();
		weapon[2] = weapons.getWeaponDamage();
		weapon[3] = weapons.getWeaponWeight();
	}
	
	
	public String myString()
	{
		return "Head armor = " + helm[0] + "\t" + "Upper body armor = " + upBod[0] + "\t" + "Lower body armor = " + loBod[0] + "\n" + 
			   "Head armor description = " + helm[1] + "\t" + "Upper body armor description = " + upBod[1] + "\t" + "Lower body armor description = " + loBod[1] + "\n" + 
			   "Head armor value = " + helm[2] + "\t" + "Upper body armor value = " + upBod[2] + "\t" + "Lower body armor value = " + loBod[2] + "\n" + 
			   "Head armor weight = " + helm[3] + "\t" + "Upper body armor weight = " + upBod[3] + "\t" + "Lower body armor weight = " + loBod[3] + "\n" + 
			   "Weapon = " + weapon[0] + "\n" + 
			   "Weapon description = " + weapon[1] + "\n" + 
			   "Weapon damage = " + weapon[2] + "\n" +
			   "Weapon weight = " + weapon[3] + "\n";
	}
}
