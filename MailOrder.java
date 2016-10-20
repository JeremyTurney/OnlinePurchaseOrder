package HW2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MailOrder 
{
	public void processOrder() 
	{// start method processOrder
		Scanner input = new Scanner ( System.in );//Allows you to take input from keyboard
		
		int productNumber[] = { 10012, 11234, 12198, 11265, 10213 }; // creates productOrder numbers and set them.
		double unitPrice[] = { 2.98, 4.50, 9.98, 4.49, 6.87 }; // creates unitPrice and sets unit prices
		int currentInventoryLevel[] = { 10, 8, 15, 3, 0 }; // creates currentInventorLevel array and sets the inventory level.
		double itemAmount = 0.00; // creates itemAmount variable
		double itemCost = 0.00; // itemCost is created and set to 0
		boolean number = false; // number boolean is created and is set to false
		int location = 0; //  // location variable is set to 0
		DecimalFormat format = new DecimalFormat("#,##0.00"); // when format.format is used it sets the decimal of that variable to 2 places
		
		System.out.println( "Please enter a product number to buy or -99 = end: " ); // asks keyboard to enter a productNumber or -99 to exit program
		int productOrder = 0;// creates productOrder cariable
		productOrder = input.nextInt(); //sets productOrder to what was entered in the keyboard
		
		while ( productOrder != -99 ) // as long as the productOrder does not equal -99 then we will keep looping through
		{//start while loop
			
			for ( int i = 0; i <= 4; i++ ) // allows us to go through each product number in the array
			{//start for loop
					
				if ( productOrder == productNumber[i] ) // if product can be found 
					{ // start if statement 1
					 	number = true; // number becomes true
					 	location = i; // location is set to i 
					}// end if statement 1
			}// end for loop
			
				if ( number == true) // if number equals true
				{ // start if statement 2
						
					if (currentInventoryLevel[location] > 0) // if currentInventorLevel is available
						{ // start if statement 3
							
							System.out.println( "Unit Price: $" + format.format(unitPrice[location]) +  " Current Quantity Available: " + currentInventoryLevel[location] ); // shows keyboard the price and quantity of the product that is being ordered
						
							System.out.println( "Enter quantity ordered: " ); // asks keyboard to enter quantity ordered
							int quantityOrder = 0; // creates a variable called quantityOrder
							quantityOrder = input.nextInt(); // inputs from keyboard quantityOrder
							
								if ( quantityOrder > 0 ) // if the quantity of the order is greater then 0. You cannot order any item that is equal to or less then 0;
								{// start if statement 4
									
									if ( quantityOrder >= currentInventoryLevel[location] ) // if quantity ordered is greater than or equal to the inventory level
									{// start if statement 5
										
										System.out.println( "Quantity Sold: " + currentInventoryLevel[location] ); // outputs the quantity sold and sells them the max possible which is the max inventory available
									
										itemCost =   currentInventoryLevel[location] * unitPrice[location]; // itemAmount calculates the price of the order
										
										System.out.println("Item Amount: $" + format.format( itemCost )  ); // outputs price of order
									
										currentInventoryLevel[location] = 0;
									}// end if statement 5
									
									else // else to if ( quantityOrder >= currentInventoryLevel[i] )
									{ // start else statement 1
										
										System.out.println( "Quantity Sold: " + quantityOrder ); //output Quantity Sold: quantity ordered
										
										itemCost =  quantityOrder * unitPrice[location]; // creates a variable that gets the price of the order
										
										System.out.println( "Item Amount: $" + format.format( itemCost )  ); //outputs price of the order
										
										currentInventoryLevel[location] -= quantityOrder; // subtracts the quantity ordered from Inventory to get the accurate inventory available
										
									}// end else statement 1
								
									
								}// end if statement 4
								
								else //else to if ( quantityOrder > 0 )
								{ // start else statement 2
									
									System.out.println( "Invalid quantity entered. " ); //output Invalid quantity entered.
									
								} // end else statement 2
							
						}// end if statement 3
						
						else // else to if (currentInventoryLevel[i] > 0)
						{// start else statement 3
							
							System.out.println( "This item is out of stock. Please pick another one" ); // output This item is out of stock. Please pick another one
							
						}// end else statement 3
							
					}//end if statement 2
				
					else // else to if ( productOrder == productNumber[i] )
					{ //start else statement 4; 
						
						System.out.println( "Invalid product number." ); // output Invalid product number
						
						//i = productNumber.length; // allows for loop to end;
				
					} // end else statement 4
				
			itemAmount += itemCost; // itemAmount adds up total cost of all purchases
					
			System.out.println( "Please enter the next product number to buy or -99 = end: " ); // asks keyboard for another order or -99 to exit program
			//int productOrder1 = 0; // creates productOrder1 and sets it to 0
			productOrder = input.nextInt(); // gets the value of productOrder1 from keyboard
			
			//productOrder = productOrder; // sets productOrder equal to productorder1 to see if we exit while loop or go through it again
			
		}// end while loop
		
		System.out.println( "Order Total Amount: $" + format.format ( itemAmount ) ); // tells keyboard the final cost of all products
		
		System.out.print( "Bye" ); // tells keyboard bye
		
	}// end method processOrder

}// end class MailOrder
