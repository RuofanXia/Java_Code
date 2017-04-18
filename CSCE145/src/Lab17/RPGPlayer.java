package Lab17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RPGPlayer {
	public String name;
	private int hp, strength;
	private double speed;
	private String weapon;
	
	public RPGPlayer(){
		this.name = "";
		this.hp = 0;
		this.strength = 0;
		this.speed = 0;
		this.weapon = "";
	}
	
	public RPGPlayer(String aName, int aHp, int aStrength, double aSpeed, String aWeapon)
	{
		this.name = aName;
		this.hp = aHp;
		this.strength = aStrength;
		this.speed = aSpeed;
		this.weapon = aWeapon;
	}
	
	public RPGPlayer(String readFile)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(readFile));
			
			for (int i=0; i<5; i++)
			{
				String fileLine = fileScanner.nextLine();
				int index = fileLine.indexOf(" ");
				String att = fileLine.substring(0, index);
				String val = fileLine.substring(index+1);
				
				if (att.equalsIgnoreCase("name"))
				{
					this.name = val;
				}
				else if (att.equalsIgnoreCase("hp"))
				{
					this.hp = Integer.parseInt(val);
				}
				else if (att.equalsIgnoreCase("Strength"))
				{
					this.strength = Integer.parseInt(val);
				}
				else if  (att.equalsIgnoreCase("Speed"))
				{
					this.speed = Double.parseDouble(val);
				}
				else if (att.equalsIgnoreCase("Weapon"))
				{
					this.weapon = val;
				}
			}
			fileScanner.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//mutators
	public void setName(String aName)
	{
		this.name = aName;
	}
	
	public void setHP(int aHp)
	{
		this.hp = aHp;
	}
	
	public void setStrength(int aStrength)
	{
		this.strength = aStrength;
	}
	
	public void setSpeed(double aSpeed)
	{
		this.speed = aSpeed;
	}
	
	public void setWeapon(String aWeapon)
	{
		this.weapon = aWeapon;
	}
	
	//accessor
	public String getName()
	{
		return this.name;
	}
	
	public int getHP()
	{
		return this.hp;
	}
	
	public int getStrength()
	{
		return this.strength;
	}
	
	public double getSpeed()
	{
		return this.speed;
	}
	
	public String getWeapon()
	{
		return this.weapon;
	}
	
	//writePlayerFile 
	public void writePlayerFile(String writeInFile)
	{
		try
		{
			PrintWriter fileWrite = new PrintWriter(new FileOutputStream(writeInFile));
			fileWrite.println("Name " + this.name);
			fileWrite.println("HP " + this.hp);
			fileWrite.println("Strength " + this.strength);
			fileWrite.println("Speed " + this.speed);
			fileWrite.println("Weapon " + this.weapon);
			fileWrite.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//printInfo()
	public void printInfo()
	{
		System.out.println("The player " + this.name);
		System.out.println("HP: " + this.hp);
		System.out.println("Strength: " + this.strength);
		System.out.println("Speed: " + this.speed);
		System.out.println("Weapon: " + this.weapon);
	}
}
