package binaryTree;

import java.util.Scanner;

//Programmer: Quinn Murphy
//Date: 11/29/22
//Assignment 6: Binary Search Tree Dictionary
//Class: CS145
//References: StackOverflow, YouTube, 
// class discussion page

// Here is the actual Binary tree class. It contains
// Every method needed for a typical recursion based 
// binary search tree. I got most of it from a binary 
// tree youtube video, but of course added methods 
// for searching in order, post order, and pre order, 
// as well as all the data needed for the address book.
// It works just fine as a binary tree.

public class BinaryTree {

	Node root;

	public void insert(Node node) {
		root = insertHelper(root, node);

	}

	private Node insertHelper(Node root, Node node) {

		int data = node.data;

		// if root equals nothing, it becomes root
		if (root == null) {
			root = node;
			return root;

		} else if (data < root.data) { // if data less then root node number
										// it becomes left child.
			root.left = insertHelper(root.left, node);
		} else { // if greater, it becomes right
			root.right = insertHelper(root.right, node);

		}

		return root;
	}

	public void display() {
		displayHelper(root);

	}
	
	public void displayPost() {
		displayHelperPost(root);
	}
	
	
	public void displayPre() {
		displayHelperPre(root);
	}
	
	

	private void displayHelper(Node root) {
		// if we want nums in order, we start with left
		// node as it is least value
		// we can reverse left and right to get decreasing
		// order
		// this is in order 
		if (root != null) {
			displayHelper(root.left);
			System.out.println("Index Number: " + root.data);
			System.out.println("First Name: " + root.firstName);
			System.out.println("Last Name: " + root.lastName);
			System.out.println("Street: " + root.street);
			System.out.println("State: " + root.state);
			System.out.println("Zip: " + root.zip);
			System.out.println("Phone Number: " + root.phoneNumber);
			displayHelper(root.right);

		}

	}
	
	private void displayHelperPost(Node root) {
		if (root != null) {
			// post order is left, right, data.
			displayHelper(root.left);
			displayHelper(root.right);
			System.out.println("Index Number: " + root.data);
			System.out.println("First Name: " + root.firstName);
			System.out.println("Last Name: " + root.lastName);
			System.out.println("Street: " + root.street);
			System.out.println("State: " + root.state);
			System.out.println("Zip: " + root.zip);
			System.out.println("Phone Number: " + root.phoneNumber);
		}
		
	}
	
	private void displayHelperPre(Node root) {
		if (root != null) {
			// pre order is data, left, right.
			System.out.println("Index Number: " + root.data);
			System.out.println("First Name: " + root.firstName);
			System.out.println("Last Name: " + root.lastName);
			System.out.println("Street: " + root.street);
			System.out.println("State: " + root.state);
			System.out.println("Zip: " + root.zip);
			System.out.println("Phone Number: " + root.phoneNumber);
			displayHelper(root.left);
			displayHelper(root.right);
		}
	}

	public boolean search(int data) {

		return searchHelper(root, data);

	}

	private boolean searchHelper(Node root, int data) {

		if (root == null) {
			return false;
			
			// searches for data number. 
	// if data is found, return true. 
	// if current data is greater then data
	// go left to find lesser numbers. same old formula

		} else if(root.data == data) {
			return true;
		}
		else if(root.data > data) {
			return searchHelper(root.left, data);
		}
		else {
			return searchHelper(root.right, data);
			
		}

		
	}
	
	

	public void remove(int data) {
		// if search can find the data (return true)
		// run remove
		if(search(data)) {
			removeHelper(root, data);
		}
		else {
			System.out.println(data + " could not be found");
		}

	}

	public Node removeHelper(Node root, int data) {
		
		if(root == null) {
			return root;
		}
		else if(data < root.data) {
			root.left = removeHelper(root.left, data);
		}
		else if(data > root.data) {
			root.right = removeHelper(root.right, data);
			
		}
		else // node is found 
			{
			// if leaf child, we dont have to shift around
			if(root.left == null && root.right == null) {
				root = null;
			}
			else if(root.right != null) { // find successor to replace node.. this one has children on right
				root.data = successor(root);
				root.right = removeHelper(root.right, root.data);
			}
			else { // find a predecessor to replace deleted node
				root.data = predecessor(root);
				root.left = removeHelper(root.left, root.data);
			}
			
		}
		return root;
	}

	private int successor(Node root) { // find least value below right child of root node (current)
		
		root = root.right;
		// after going right we will go as far left as we
		// can to find the least value
		while(root.left != null) {
			root = root.left;
		}
		
		
		return root.data;
	}

	private int predecessor(Node root) {
		root = root.left;
		// after going right we will go as far left as we
		// can to find the least value
		while(root.right != null) {
			root = root.right;
		}
		
		
		return root.data;// find greatest value below left child of root node (current)
		
	}

}
