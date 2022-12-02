package binaryTree;

import java.util.Scanner;

//Programmer: Quinn Murphy
//Date: 11/29/22
//Assignment 6: Binary Search Tree Dictionary
//Class: CS145
//References: StackOverflow, YouTube, 
// class discussion page

// Alright so this is the main class, Tree. 
// It has the menu, initializes the actual binary tree,
// and contains the intro. To search in order, post order, or
// pre order, use the "show contacts" feature 
// This program is slightly weird...
// The add, remove, modify, show contacts features all work,
// but only if the binary tree is balanced. For instance, if 
// I make two node in the tree, one 3, and the other 4, I can 
// modify or delete either of them just fine. But if the tree is 
// unbalanced or there is only one node, you cannot modify or 
// delete the node. I am not sure how to make a tree that automatically
// balances itself, but I am sure it is possible. But with that being said, 
// this program is a bit janky. But like I said, all the features work 
// if the tree is balanced. 

public class Tree {
	// left most child lowest value
	// right most child highest value

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		Scanner scan = new Scanner(System.in);
		Intro();

		boolean quit = true;

		int UserChoice = scan.nextInt();
		scan.nextLine();
		while (quit) {
			// simple while loop checking for user input,
			// just like all our other programs.
			switch (UserChoice) {
			// used a switch case here, for fun.
			case 1:

				System.out.println("Enter first name?");
				String firstName = scan.nextLine();

				System.out.println("Enter index number for placement? MUST BE INTEGER!!");
				int data = scan.nextInt();

				System.out.println("Enter last name?");
				String lastName = scan.next();

				System.out.println("Enter state name?");
				String state = scan.next();

				System.out.println("Enter street name?");
				String street = scan.next();

				System.out.println("Enter city name?");
				String city = scan.next();

				System.out.println("Enter zip number?");
				String zip = scan.next();

				System.out.println("Enter email name?");
				String email = scan.next();

				System.out.println("Enter phonenumber?");
				String phoneNumber = scan.next();

				tree.insert(new Node(data, firstName, lastName, street, city, state, zip, email, phoneNumber));
				tree.display();
				break;

			case 2:
				System.out.println("Would you like to look up in");
				System.out.println("(1) In-Order, (2) Post-Order, or (3) Pre-Order?");
				System.out.println("Please type 1, 2, or 3.");
				int orderChoice = scan.nextInt();
				if (orderChoice == 1) {
					tree.display();
				} else if (orderChoice == 2) {
					tree.displayPost();
				} else if (orderChoice == 3) {
					tree.displayPre();
				}

				break;

			case 3:
				System.out.println("Enter index number of contact to modify?");
				tree.display();
				int modifyIndex = scan.nextInt();
				tree.remove(modifyIndex);

				System.out.println("Enter first name?");
				String modFirstName = scan.next();

				System.out.println("Enter last name?");
				String modLastName = scan.next();

				System.out.println("Enter state name?");
				String modState = scan.next();

				System.out.println("Enter street name?");
				String modStreet = scan.next();

				System.out.println("Enter city name?");
				String modCity = scan.next();

				System.out.println("Enter zip number?");
				String modZip = scan.nextLine();

				System.out.println("Enter email name?");
				String modEmail = scan.nextLine();

				System.out.println("Enter phonenumber?");
				String modPhoneNumber = scan.nextLine();

				tree.insert(new Node(modifyIndex, modFirstName, modLastName, modStreet, modCity, modState, modZip,
						modEmail, modPhoneNumber));
				tree.display();
				break;

			case 4:
				System.out.println("Enter index number of contact?");
				tree.display();
				int deleteIndex = scan.nextInt();
				tree.remove(deleteIndex);
				// System.out.println("\n\n success!");
				tree.display();

				break;

			case 5:
				System.out.println("Thanks for using the binary address dictionary!");
				System.exit(0); // will just leave program
				quit = false;
				break;

			}
			// just for infinite loop sake I added this just incase
			// we somehow leave the while loop.

			Intro();
			UserChoice = scan.nextInt();

		}

		// System.out.println(tree.search(5));

	}

	public static void Intro() {
		System.out.println("What would you like to do?");
		System.out.println("1. Add New Contact");
		System.out.println("2. Show Contacts");
		System.out.println("3. Modify Contact");
		System.out.println("4. Delete Contact (Using Index)");
		System.out.println("5. Quit Program");
	}

}
