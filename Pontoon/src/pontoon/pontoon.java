package pontoon;

import java.util.Scanner;


/*
 * Date: 09/09/2020
 * Student Number: 11001826
 * Student Name: Connor Macleod 
 * Version:  3
 */

public class pontoon{
	
	

	static Scanner kboard = new Scanner(System.in);
    public static Scanner keyboard = new Scanner(System.in);

    
    
    
    public static int getRandomNumber()
	{
		return (int)(Math.random()*10 + 1);
	}
	
	public static int calcTotal(int card1,int card2) //returns total of cards 1 and 2
	{
		return(card1+card2);
	}
	
	public static boolean getResult(int total,int house) //returns the result of user total vs house
	{
		if (total>house && total<=21)
			return(true);
		else
			return(false);
	}
	
	public static boolean busted(int total) //returns the result of user cards if over 21
	{
		if (total>21)
			return(true);
		else
			return(false);
	}
	
	public static int houseTotal(int x) //returns the total of house cards
	{
		int house=0;
		while (house < x)
			house = calcTotal(getRandomNumber(),getRandomNumber());	
	return(house);
	}
	
	public static void displayCards(int cardsDrawn[]) //returns the values of each card drawn
	{
		System.out.print("Cards drawn: ");
		for (int x = 1;x<10;x++)
		{
		if (cardsDrawn[x]!=0)
				if (x==1)
					System.out.print(cardsDrawn[x]);
				else
					System.out.print(","+cardsDrawn[x]);	
		}
		System.out.println();
	}
	
	
public static void main(String[] args) // main method
	{
		final int minHouse = 16; 
		String choice="";
		int drawnCards[] = new int[10]; // max amount of cards that can be drawn = 7 
		int card1;
		int card2;
		int house = 0;
		int total;
		int cardvalue = 0;
		int cardCount = 3; //counts card numbers
		
		house = houseTotal(minHouse);
		drawnCards[0] = house;
		card1 = getRandomNumber();
		drawnCards[1] = card1;
		card2 = getRandomNumber();
		drawnCards[2] = card2;
		total = calcTotal(card1,card2);
		System.out.println("You have drawn "+card1+" and "+card2);
		System.out.println("Do you wish to draw another card y/n");
		choice=kboard.nextLine();

		while (choice.equalsIgnoreCase("y")) 
			{
			cardvalue=getRandomNumber();
			drawnCards[cardCount++] = cardvalue;
			System.out.println("You have drawn a "+cardvalue);
			total=calcTotal(total,cardvalue);
			if (busted(total)==true)
				{
				System.out.println("Busted! your cards totals are "+total+" which is over 21"); // display busted cards if over 21
				
				displayCards(drawnCards);
				break;
				}
			else
				System.out.println("Do you wish to draw another card y/n");
				choice=kboard.nextLine();
			}
		
		if (getResult(total,house)==true)
			{
			System.out.println("You have won with a total of "+total+". the house had a total of "+house);
			displayCards(drawnCards);
			}
			else
			{	
			System.out.println("You have lost with a total of "+total+", the house has a total of "+house);
			displayCards(drawnCards);
			}
	}
}
