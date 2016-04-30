package ideaTester;

import java.io.FileNotFoundException;

//import java.util.*;

public class equipPiece 
{
	private String pieceName;
	private String pieceDescrip;
	private String weight;
	private String armorV;
	saveLoad sOrL = new saveLoad();
	public equipPiece(String area)
	{
		if(area.equalsIgnoreCase("head"))
		{
			//System.out.println("do i have a helmet or hat");
			pieceName = "Beginners Hat";
			pieceDescrip = "Cute Hat with a V on the front in red lipstick or nail polish";
			weight = "0";
			armorV = "1";
		}
		else if(area.equalsIgnoreCase("UprB"))
		{
			//System.out.println("do i have a shirt and gloves");
			pieceName = "Beginner Shirt";
			pieceDescrip = "An easily ripable shirt";
			weight = "0";
			armorV = "2";
		}
		else if(area.equalsIgnoreCase("LwrB"))
		{
			//System.out.println("do i have pants and shoes");
			pieceName = "mountain kid 's pants";
			pieceDescrip = "It has a hole for a tail";
			armorV = "2";
			weight = "0";
		}
		else
		{
			System.out.println("Invalid Armor Piece");
			//i need to have some sort of try catch or make sure that they will say one of those 3
		}
	}
	
	public equipPiece(String filePos, String areaPos) throws FileNotFoundException
	{
		if(areaPos.substring(0,3).equalsIgnoreCase("Head"))
		{
			pieceName = sOrL.load(filePos, areaPos);
			pieceDescrip = sOrL.load(filePos, areaPos);
			armorV = sOrL.load(filePos, areaPos);
			weight = sOrL.load(filePos, areaPos);
		}
		if(areaPos.substring(0,3).equalsIgnoreCase("UprB"))
		{
			pieceName = sOrL.load(filePos, areaPos);
			pieceDescrip = sOrL.load(filePos, areaPos);
			armorV = sOrL.load(filePos, areaPos);
			weight = sOrL.load(filePos, areaPos);
		}
		if(areaPos.substring(0,3).equalsIgnoreCase("LwrB"))
		{
			pieceName = sOrL.load(filePos, areaPos);
			pieceDescrip = sOrL.load(filePos, areaPos);
			armorV = sOrL.load(filePos, areaPos);
			weight = sOrL.load(filePos, areaPos);
		}
	}
	
	public void setPieceName(String area, String pieceName)
	{
		this.pieceName = pieceName;
	}
	public String getPieceName(String area)
	{
		return pieceName;
	}
	public void setPieceDescrip(String area, String pieceDescrip)
	{
		this.pieceDescrip = pieceDescrip;
	}
	public String getPieceDescrip(String area)
	{
		return pieceDescrip;
	}
	public void setArmorV(String area, String armorV)
	{
		this.armorV = armorV;
	}
	public String getArmorV(String area)
	{
		return armorV;
	}
	public void setWeight(String area, String weight)
	{
		this.weight = weight;
	}
	public String getWeight(String area)
	{
		return weight;
	}
	
	
	
	
	
	
	public String toString()
	{
		return "";
	}
	
	//public equipPiece(int monsterLvl, String monster)
	//{
	//	
	//}
	
}
