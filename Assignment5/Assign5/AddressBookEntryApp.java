import java.lang.*;
import java.io.*;
import java.util.*;

class AddressBookEntryApp
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("Welcome to the Address Book Application\n");
		do
		{
			System.out.println("1. List entries");
			System.out.println("2. Add entry");
			System.out.println("3. Exit\n");
			System.out.print("Enter Menu Number: ");
			choice = sc.nextInt();
			if(Validator.checkMenuChoice(choice) == false) {
				choice = 5;
			}
			String eatNewLine = sc.nextLine(); 
			switch(choice)
			{
				case 1: String entries = AddressBookIO.getEntriesString();
						System.out.println("\n" + entries);
						break;
				case 2: System.out.print("\nEnter Name: ");
						String name = sc.nextLine();
						if(Validator.checkInput(name) == false)
						{
							System.out.println("Name can't be empty");
							break;
						}
						System.out.print("Enter email Address: ");
						String email = sc.nextLine();
						if(Validator.checkInput(email) == false)
						{
							System.out.println("email can't be empty");
							break;
						}
						System.out.print("Enter Phone Number: ");
						String cellNumber = sc.nextLine();
						if(Validator.checkInput(cellNumber) == false)
						{
							System.out.println("cellNumber can't be empty");
							break;
						}
						AddressBookEntry abeObj = new AddressBookEntry(name, email, cellNumber);
						if(AddressBookIO.saveEntry(abeObj))
						{
							System.out.println("\nThis entry has been saved.");
						}
						else {
							System.out.println("Error in saving entry, please try again");
						}
						break;
				case 3: System.out.println("\nGoodbye.");
						break;
				default: System.out.println("\nInvalid choice");
						 break;
			}
		}while(choice != 3);

	}
}