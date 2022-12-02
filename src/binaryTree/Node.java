package binaryTree;
//Programmer: Quinn Murphy
//Date: 11/29/22
//Assignment 6: Binary Tree
//Class: CS145
//References: StackOverflow, YouTube, 
// class discussion page

// Here is the node class for our data. It is 
// pretty simple. All it has is one node with 
// all the strings and index. Practically identical
// to the other phonebook program. 

public class Node {
	
	int data; // will be our index
	Node left;
	Node right;
	public String firstName;
	public String lastName;
	public String street;
	public String city;
	public String state;
	public String zip;
	public String email;
	public String phoneNumber;
	public Node next;
	
	public Node(int data, String firstName, String lastName, String street, String city, 
				String state, String zip, String email, String phoneNumber) {
		this.data = data;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.phoneNumber = phoneNumber;
		
		
	}

}
