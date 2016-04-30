package ideaTester;

import java.util.*;
import java.io.*;

public class game 
{
	static player p1;
	static saveLoad sOrL = new saveLoad();
	Map world = new Map();
	static Scanner plyrIn = new Scanner(System.in);
	static stats plyrWin;
	static Scanner read;
	File plyrF;
	static File mapF;
	static File intro;
	File forestF;
	static String pName;
	static String pDescrip;
	static int gCSpeech = 0;
	static File startGame = new File("C:\\Users\\Naeem A. T-Pearson\\Desktop\\School Books& programs\\eclipse\\ideaTester\\src\\ideaTester\\intro.txt");
	static rpgBattleSyst battleTime = new rpgBattleSyst();
	static int wQuad;
	static String location;
	static String locationDescrip;
	static Map atXplace = new Map();
	static int firstBattle = 1;
	int pLvl = p1.getLvlV();
	public static void main(String[] args) throws FileNotFoundException
	{
		
		System.out.println("Welcome to Game");
		System.out.println("Would you like to start a new game or continue");
		String pChoice = plyrIn.nextLine();
		//wQuad = 0;
		newOrLoad(pChoice);
		String playerInfo = p1.toString();
		System.out.println(playerInfo);
		System.out.println(gCSpeech);
		if(gCSpeech == 0)
		{
			read = new Scanner(startGame);
			while(read.hasNextLine())
			{
				String guardCaptainSpeech = read.nextLine();
				System.out.println(guardCaptainSpeech);
			}
			read.close();
		}
		wQuad = atXplace.spawnPlayer();
		location = atXplace.worldQuadrant(wQuad);
		locationDescrip = atXplace.habitatInfo(location, wQuad);
		System.out.println("Is it here " + locationDescrip);
		System.out.println("You can practice against me freashy (the captain says with a smug look on his face)");
		atXplace.foundMonster("monster", "Guard Captain", wQuad);
		int battleResult = battleTime.battleStart("Guard Captain", wQuad);
		while(!pChoice.equalsIgnoreCase("quit"))
		{
			if(firstBattle == 1)
			{
				System.out.println("Looks like you are ready to go out and do some solo training");
				System.out.println("what will you do now");
				firstBattle = 0;
			}
			else
			{
				System.out.println("You have chosen to " + pChoice);
			}
			
			//pChoice = plyrIn.nextLine();
			if(pChoice.equalsIgnoreCase("search"))
			{
				String found = atXplace.search(location, wQuad);
				if(found.substring(0, 6).equalsIgnoreCase("monser"))
				{
					
					battleResult = battleTime.battleStart(found.substring(8,found.length()), wQuad);
				}
			}
			else if(pChoice.equalsIgnoreCase(""))
			//train, search, leave the area, interact, visit) 		
			{
				//do that funtion
			}
			System.out.println();
			System.out.println("What do I do now");
			//atXplace. //get list of action options of player at X place
			pChoice = plyrIn.nextLine();
			while(!pChoice.equalsIgnoreCase("search"))
			{
				System.out.println("I suddenly realize that I cannot do that ...... hmmm what should I do");
				pChoice = plyrIn.nextLine();
			}
		}
	}
	
	public static void newOrLoad(String pChoice) throws FileNotFoundException
	{
		if(pChoice.equalsIgnoreCase("Load"))
		{
			System.out.println("please input your player's name?");
			pName = plyrIn.nextLine();
			p1 = new player(pName);
			try {
				sOrL.npcInteractions();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			plyrWin = new stats(pName);
			battleTime.playerStartInfo(pChoice, pName, pDescrip);
		}
		else
		{
			System.out.println("What is the character's name?");
			pName = plyrIn.nextLine();
			System.out.println("are your a male or female");
			pDescrip = plyrIn.nextLine();
			String pFullDescrip = "";
			pFullDescrip = pFullDescrip + " " + pDescrip + " ";
			p1 = new player(pName, pFullDescrip);
			plyrWin = new stats();
			battleTime.playerStartInfo(pChoice, pName, pDescrip);
			//p1 = new player(pName, pDescrip);
		}
		
		
//
//		mapF = new File("C:\\Users\\Naeem A. T-Pearson\\Desktop\\School Books& programs\\eclipse\\ideaTester\\src\\ideaTester\\gameMap.txt");
//		System.out.println("testing testing 123");
//		String test4 = "";
//		System.out.println("testing testing 123");
//	    try 
//	    {
//	    	System.out.println("testing testing 123");
//	        read = new Scanner(mapF);
//	        System.out.println("testing testing 123");
//	        while (read.hasNextLine()) 
//	        {
//	        	//should read location
//	        	System.out.println("testing testing hi");
//	        	String test = read.nextLine();
//	        	System.out.println(test);
//	        	//should read forest
//	        	String test2 = read.next();
//	        	System.out.println(test2);
//	        	//should read 1
//	        	int test3 = read.nextInt();
//	        	System.out.println(test3);
//	        	//should read location
//	        	test4 = read.nextLine();
//	        	System.out.println("testing testing 123");
//	        	System.out.println(test4);
//	        	//should read path to old kingdom
//	        	String test5 = read.nextLine();
//	        	System.out.println(test5);
//	        	String test6 = read.next();
//	        	System.out.println(test6);
//	        	// should read 2
//	            int i = read.nextInt();
//	            String test7 = read.nextLine();
//	            System.out.println(test7);
//	            //System.out.println("testing testing 123");
//	            System.out.println(i);
//	        }
//	        read.close();
//	    } 
//	    catch (FileNotFoundException e) 
//	    {
//	        e.printStackTrace();
//	    }
	}
}
