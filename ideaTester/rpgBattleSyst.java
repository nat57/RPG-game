package ideaTester;


import java.io.*;
//import java.io.FileNotFoundException;
import java.util.*;


public class rpgBattleSyst 
{
	static Scanner plyrIn = new Scanner(System.in);
	Random randomGenerator = new Random();
	stats plyrWin; 
	monster m1; 
	static int pAction;
	player p1;
	int pLvl;
	int pHealth;
	int pAttack;
	int pSpeed;
	int pDefense;
	int pWeapon;
	int pStr;
	int pObs;
	int pIntel;
	int pPassCounter;
	int guardOrEvade;
	int evadeChance;
	int guardChance;
	int mLvl;
	int mHp;
	int mAtk;
	int mDef;
	int mSpd;
	int mIntel;
	int mCripCounter;
	
	public void getPlayerValues() 
	{
		pLvl = p1.getLvlV();
		
		pAttack = p1.getAttackV();
		pSpeed = p1.getSpdV();
		pDefense = p1.getDefV();
		pHealth = p1.getHealthV() + pDefense;
		pWeapon = p1.getWDV();
		pStr = p1.getStrV();
		pObs = p1.getObsV();
		pIntel = p1.getIntelV();
	}
	public void playerStartInfo(String pChoice, String pName, String pDescrip) throws FileNotFoundException
	{
		if(pChoice.equalsIgnoreCase("load"))
		{
			p1 = new player(pName);
			plyrWin = new stats(pName);
			getPlayerValues();
		}
		else
		{
			p1 = new player(pName, pDescrip);
			plyrWin = new stats();
			getPlayerValues();
		}
	}
	
	public int battleStart(String mName, int wQuad) throws FileNotFoundException
	{
		getPlayerValues();
		m1 = new monster(mName, wQuad);
		mLvl = m1.getMonBaseLvl();
		mHp = m1.getMonHp();
		mAtk = m1.getMonStrength();
		mDef = m1.getMonDefense();
		mSpd = m1.getMonSpeed();
		mIntel = m1.getMonIntellegence();
		int mObs = m1.getMonObservation();
		int mMaxHp = mHp;
		int mHpPercentage = 0;
		int mDamageTaken;
		int pDamageTaken;
		//int pPassCounter;
		mCripCounter = 0;
		
		System.out.println("testing testing 123");
		
		Scanner read;

		
		//int mLevel = 1;
		//int wQuad = 0;
		//monster m1 = new monster(wQuad, mLevel);
		//System.out.println(p1.toString());
		//System.out.println(m1.monString());
		
		
		//int mHealth = m1.getHealthV();
		//int mSpeed = m1.getSpdV();
		int pCalc = 0;
		do
		{
			int mEffect = 0;
			int effect = 0;
			int mAction = 0;
			
			mHpPercentage = mHp/mMaxHp;
			System.out.println(m1.getMonCondition(mHpPercentage, mName));
			if(pSpeed >= mSpd)
			{
				System.out.println(pHealth + "     " + mHp);
				pTurn();
				effect = pMove(pAction, mName);
				pCalc = pTurnCalc(pAction, effect, mName, mEffect);
				if (pCalc == 0)
				{
					return 0;
				}
				if(pCalc == 2)
				{
					return 2;
				}
				if(pCalc == 3)
				{
					return 3;
				}
				if(pCalc == 5)
					pAction = 9;
				if(mHp <= 0)
				{
					plyrWin.expGain(pLvl, mLvl);
					System.out.println("the " + mName + " backs down but you see a glint in it's eye. You can't help but feel that you have earned the " + mName + "'s respect");
					p1.setExpAmtV(pLvl, mLvl);
					return 1;
				}
				if(mCripCounter >= 3)
				{
					mSpd = mSpd /2;
					System.out.println("The " + mName + "'s legs seem to be injured, it moves at a slower pace");
				}
				mAction = mTurn();
				System.out.println("mAction = " + mAction + "       mEffect = " + mEffect);
				mEffect = mMove(mName, mAction);
				System.out.println("mEffect = " + mEffect);
				if((0 == mAction) && ((effect != 1) || (effect != 2)))
				{
					pHealth = pHealth - mEffect;
					System.out.println("pHealth = "+ pHealth);
					System.out.println(mEffect);
				}
				else 
				{
					if((mAction == 2)  && ((effect != 1) || (effect != 2)))
					{
						pHealth = pHealth - mEffect;
						System.out.println(mEffect);
					}
				}
			}
			else
			{
				System.out.println(pHealth + "     " + mHp);
				mTurn();
				mEffect = mMove(mName, mTurn());
				if((0 == mAction) && ((effect != 1) || (effect != 2)))
				{
					pHealth = pHealth - mEffect;
					System.out.println(mEffect);
				}
				else 
				{
					if((mAction == 2)  && ((effect != 1) || (effect != 2)))
					{
						pHealth = pHealth - mEffect;
						System.out.println(mEffect);
					}
				}
				if(pHealth <= 0)
				{
					System.out.println("you fall to your knees. The " + mName + "has a condisending look on it's face.");
					return 4;
				}
				pTurn();
				effect = pMove(pAction, mName);
				pCalc = pTurnCalc(pAction, effect, mName, mEffect);
				if (pCalc == 0)
				{
					return 0;
				}
				if(pCalc == 2)
				{
					return 2;
				}	
				if(pCalc == 3)
				{
					return 3;
				}
				if(pCalc == 5)
					pAction = 9;
				if(mCripCounter >= 3)
				{
					mSpd = mSpd /2;
					System.out.println("The " + mName + "'s legs seem to be injured, it moves at a slower pace");
				}
			}
		}
		while(((pHealth > 0) && (mHp > 0)) && (pAction != 8));
		if(pHealth <= 0)
		{
			System.out.println("you fall to your knees. The " + mName + "has a condisending look on it's face.");
			return 4;
		}
		if(mHp <= 0)
		{
			plyrWin.expGain(pLvl, mLvl);
			System.out.println("the " + mName + " backs down but you see a glint in it's eye. You can't help but feel that you have earned the " + mName + "'s respect");
			p1.setExpAmtV(pLvl, mLvl);
			return 1;
		}
		
		/*
		int randomInt = randomGenerator.nextInt(50);
		int randomInt2 = randomGenerator.nextInt(3);
		int randomInt3 = randomGenerator.nextInt(50);
		int mAge = randomGenerator.nextInt(10);
		int Php = 100;
		int Mhp = 100;
		
		String pAction = "attack";
		String mAction = "attack";
		//int bLeng;
		int pLvl, monstaLvl;
		pAttack = 0;
		int mAttack = 0;
		int weaponD = 0;
		String Player, Monster, weapon;
		pLvl = randomInt;
		monstaLvl = randomInt3;
		weapon = "";
		switch(randomInt2)
		{
			case 0: weapon = "sword";
					weaponD = 5;
					break;
				
			case 1: weapon = "daggers";
					weaponD = 2;
					break;	
		
			case 2: weapon = "hammer";
					weaponD = 10;
		}
		int pBonus;
		for(int i = 0; i < pLvl; i++)
		{ 
			pBonus = randomGenerator.nextInt(2);
			switch(pBonus)
			{
				case 0: Php = Php + 5;
			
				case 1:	pAttack = pAttack + 5;
			
			}
		}
		
		int mBonus = 0;
		for(int i = 0; i < mLvl; i++)
		{ 
			mBonus = randomGenerator.nextInt(2);
			switch(mBonus)
			{
				case 0: Mhp = Mhp + 5;
			
				case 1:	mAttack = mAttack + 5;
			
			}
		}

		pAttack = pAttack + weaponD;
		mAttack = mAttack + mAge;
		Player = "Person";
		Monster = "Hog";
		System.out.println(Player + " HP = " + Php + " and Attack = " + pAttack);
		System.out.println(Monster + " HP = " + Mhp + " and Attack = " + mAttack);
		while((Php > 0) && (Mhp > 0))
		{
			if(pAction.equalsIgnoreCase("attack"))
			{
				Mhp = Mhp - pAttack;
				System.out.println(Player + " attacks " + Monster + " with " + weapon);
				System.out.println(Monster + " suffers " + pAttack + " damage");
			}
			if(Mhp <= 0)
			{
				break;
			}
			if(mAction.equalsIgnoreCase("attack"))
			{
				Php = Php - mAttack;
				System.out.println(Monster + " attacks " + Player);
				System.out.println(Player + " suffers " + mAttack + " damage");
			}
			
		}
		if(Php > 0)
		{
			System.out.println(Player + " wins");
			System.out.println(randomInt2);
			System.out.println(Player + " is at lvl " + pLvl);
		}
		else
		{
			System.out.println(Monster + " wins");
			System.out.println("The " + Monster + "'s lvl is " + mLvl);
		}
		*/
		return 4;
	}
	
	public static int pTurn()
	{
		System.out.println("Input the number of the action that yu would like to take.");
		System.out.println("Attack 1 , Focus Attack 3, Special Attack 5, Surrender 7");
		System.out.println("Defend 2,  Talk 4,         Pacify 6,         Run 8");
		pAction = plyrIn.nextInt();
		return pAction;
	}
	
	public int pMove(int pAction, String mName)
	{
		int effect = 0;
		switch(pAction)
		{
			case 1:
			{
				System.out.println("lets try and attack");
				effect = pAttack;
				break;
			}
			case 2:
			{
				guardOrEvade = randomGenerator.nextInt(2);
				if(guardOrEvade == 0)
				{
					System.out.println("Your prepare to guard");
					guardChance = randomGenerator.nextInt(100);
					if(guardChance < 11)
					{
						System.out.println("You somehow manage to block the " + mName + " attack");
						effect = 1;
					}
					else
					{
						System.out.println("The" + mName + " managed to fend off your guard");
					}
				}
				else
				{
					System.out.println("Your get ready to evade");
					evadeChance = randomGenerator.nextInt(100);
					if(guardChance < (11 + (pSpeed - mSpd)))
					{
						System.out.println("You luckily dodge the " + mName + " blow");
						effect = 2;
					}
					else
					{
						System.out.println("the " + mName + " easily catches you with their attack");
					}
				}
				break;
			}
			case 3:
			{
				effect = pAttack/2;
				break;
			}
			case 4:
			{
				System.out.println("You try to talk to and reason with the " + mName);
				if(mIntel > pIntel)
				{
					System.out.println("but to no avail");
				}
				break;
			}
			case 5:
			{
				effect = pAttack + (pAttack/2);
				break;
			}
			case 6:
			{
				System.out.println("you try to pacify the enemy");
				break;
			}
			case 7:
			{
				System.out.println("you decide that it would be in your best interest to surrender");
				break;
			}
			case 8:
			{
				System.out.println("You try to run");
				break;
			}
		}
		return effect;
	}
	
	public int pTurnCalc(int pAction, int effect, String mName, int mEffect)
	{
		if((pAction == 1) && ((mEffect != 1) || (mEffect != 2 )))
		{
			mHp = mHp - effect;
			System.out.println(effect);
		}
		else if(pAction == 2)
		{
			System.out.println(effect);
		}
		else if((pAction == 3) && ((mEffect != 1) || (mEffect != 2 )))
		{
			mHp = mHp - effect;
			System.out.println("you decide to go for the legs");
			mCripCounter++;
			System.out.println(effect);
		}
		else if((pAction == 4) && (pIntel > mIntel))
		{
			pPassCounter++;
		}
		else if((pAction == 5) && ((mEffect != 1) || (mEffect != 2 )))
		{
			mHp = mHp - effect;
			System.out.println(effect);
		}
		else if(pAction == 6)
		{
			if(pPassCounter >= 3)
			{
				System.out.println("You convinced the " + mName + " to stand down");
				p1.setExpAmtV(pLvl, mLvl);
				return 0;
			}
			else
			{
				System.out.println("the " + mName + " looks at you like you are cray but you cant help but feel like a more peaceful option still exists");
			}
		}
		else if(pAction == 7)
		{
			System.out.println("The " + mName + " scoffs at you and walks away");
			return 3;
		}
		else 
		{
			pAction = 8;
		}
		if(pAction == 8)
		{
			int escape = randomGenerator.nextInt(100);
			if(escape < 11 + (pSpeed - mSpd))
			{
				System.out.println("you manage to run away from the fight");
				return 2;
			}
			else
			{
				System.out.println("your escape was impeaded by the " + mName + " who just happens to "
						+ "have a condisending look on it's face. The " + mName + " is looking down on you for trying to run");
				pAction = 9;
				return 5;
			}
		}
		return mHp;
	}
	
	public int mTurn()
	{
		int mAction = randomGenerator.nextInt(3);
		
		return mAction;
	}
	public int mMove(String mName, int mAction)
	{
		int mEffect = 0;
		switch(mAction)
		{
			case 0:
			{
				System.out.println("The " + mName + " attacks you");
				mEffect = mAtk;
				System.out.println("attack power = " + mAtk);
				System.out.println("mEffect = " + mEffect);
				return mEffect;
			}
			case 1:
			{
				guardOrEvade = randomGenerator.nextInt(2);
				if(guardOrEvade == 0)
				{
					System.out.println("the " + mName + " raises it's guard");
					guardChance = randomGenerator.nextInt(100);
					if(guardChance < 11)
					{
						System.out.println("the "+ mName + " managed to block your attack");
						mEffect = 1;
						return mEffect;
					}
					else
					{
						System.out.println("you blow right past the " + mName + " guard");
					}
				}
				else
				{
					System.out.println("The " + mName + " prepares to evade");
					evadeChance = randomGenerator.nextInt(100);
					if(guardChance < (11 + (mSpd - pSpeed)))
					{
						System.out.println("the " + mName + " dodeges your strike");
						mEffect = 2;
						return mEffect;
					}
					else
					{
						System.out.println("you hit the " + mName + " right in the middle of their meger dodge");
					}
				}
				return mEffect;
			}
			case 2:
			{
				System.out.println("The " + mName + " charges at you with a strong attack ..... this might hurt");
				mEffect = mAtk + (mAtk/2);
				System.out.println("attack power = " + mAtk);
				return mEffect;
			}
		}
		return mEffect;
	}
	
}