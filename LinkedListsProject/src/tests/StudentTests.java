package tests;

import static org.junit.Assert.assertTrue;

//import static org.junit.Assert.*;

import java.util.ArrayList;

//import java.util.Comparator;

import org.junit.Test;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;

public class StudentTests {
	BasicLinkedList<String> testList = new BasicLinkedList<String>();
	SortedLinkedList<String> testSorted = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
	

	
	@Test
	public void addToEndTest() {
		//System.out.print("add to end test with ");
		testList.addToEnd("first");
		testList.addToEnd("second");
		testList.addToEnd("third");
		//System.out.println("size: " + testList.getSize());
		String test = "";
		for(String str: testList) {
			test = test + str + " ";
		}
		String expected = "first second third ";
		assertTrue(test.equals(expected));
	}
	
	@Test
	public void addToFrontTest() {
		//System.out.print("add to front test with ");
		testList.addToFront("first");
		testList.addToFront("second");
		testList.addToFront("third");
		//System.out.println("size: " + testList.getSize());
		String test = "";
		for(String str: testList) {
			test = test + str + " ";
		}
		String expected = "third second first ";
		assertTrue(test.equals(expected));
	}
	
	@Test
	public void getFirstTest() {
		//System.out.println("Get Front Test:");
		testList.addToEnd("first");
		testList.addToEnd("second");
		testList.addToEnd("third");
		//System.out.println(testList.getFirst());
		
	}
	@Test
	public void getLastTest() {
		//System.out.println("Get Front Test:");
		testList.addToEnd("first");
		testList.addToEnd("second");
		testList.addToEnd("third");
		//System.out.println(testList.getLast());
		String test = testList.getLast();
		String expected = "third";
		assertTrue(test.equals(expected));
	}
	
	@Test
	public void retrieveLastTest() {
		//System.out.println("Retrieve Last Test:");
		testList.addToEnd("first");
		testList.addToEnd("second");
		testList.addToEnd("third");
		String result = "Beginning size: " + testList.getSize();
		assertTrue(testList.retrieveLastElement().equals("third"));
		assertTrue(testList.getSize() == 2);
		result = result + " removed: " + testList.retrieveLastElement();
		result = result + " End size: " + testList.getSize();
		
	
	}
	
	@Test
	public void retrieveFirstTest() {
		//System.out.println("Retrieve First Test:");
		testList.addToEnd("first");
		testList.addToEnd("second");
		testList.addToEnd("third");
		String result = "Beginning size: " + testList.getSize();
		assertTrue(testList.retrieveFirstElement().equals("first"));
		assertTrue(testList.getSize() == 2);
		result = result + " removed: " + testList.retrieveFirstElement();
		result = result + " End size: " + testList.getSize();
		//System.out.println(result);
	}
	
	
	
	@Test
	public void removeTarget() {
		//System.out.println("Remove Test:");
		testList.addToEnd("There");
		testList.addToEnd("hey");
		testList.addToEnd("there");
		testList.addToEnd("is");
		testList.addToEnd("a");
		testList.addToEnd("there");
		testList.addToEnd("thing");
		testList.addToEnd("there");
		String original = "";
		for(String str: testList) {
			original = original + str + " ";
		}
		//System.out.println(original);
		
		testList.remove("there", String.CASE_INSENSITIVE_ORDER);
		String removed = "";
		for(String str: testList) {
			removed = removed + str + " ";
		}
		//System.out.println(removed);
		String expected = "hey is a thing ";
		assertTrue(removed.equals(expected));
	}
	
	/*
	 * All working up to here
	 */
	
	@Test
	public void reverseArrayTest() {
		//System.out.println("Reverse Array Test:");
		testList.addToEnd("first");
		testList.addToEnd("second");
		testList.addToEnd("third");
		String original = "original: ";
		for(String str: testList) {
			original = original + str + " ";
		}
		ArrayList<String> reverse = testList.getReverseArrayList();
		String reversed = "reversed: ";
		for(String str: reverse) {
			reversed = reversed + str + " ";
		}
		//System.out.println(original);
		//System.out.println(reversed);
		String expected = "reversed: third second first ";
		assertTrue(reversed.equals(expected));
	}
	
	@Test
	public void reverseListTest() {
		//System.out.println("Reverse Linked Test:");
		testList.addToEnd("first");
		testList.addToEnd("second");
		testList.addToEnd("third");
		String original = "original: ";
		for(String str: testList) {
			original = original + str + " ";
		}
		BasicLinkedList<String> reverse = testList.getReverseList();
		String reversed = "reversed: ";
		for(String str: reverse) {
			reversed = reversed + str + " ";
		}
		//System.out.println(original);
		//System.out.println(reversed);
		String expected = "reversed: third second first ";
		assertTrue(reversed.equals(expected));
	}
	
	@Test
	public void sortedTestOne() {
		//System.out.println("Sorted Test:");
		//empty
		testSorted.add("Adam");
		//one
		testSorted.add("Bob");
		//last
		testSorted.add("Joe");
		//middle
		testSorted.add("Frank");
		//end
		testSorted.add("Zane");
	
		String test = "list: ";
		for(String str: testSorted) {
			test = test + str + " ";
		}

		//System.out.println(test);
		//System.out.println("size: " + testSorted.getSize());
		
		String expected = ("list: Adam Bob Frank Joe Zane ");
		assertTrue(test.equals(expected));
	}
	
	@Test
	public void sortedTestTwo() {
	
		testSorted.add("B");
		testSorted.add("B");
		testSorted.add("Quinn");
		testSorted.add("F");
		testSorted.add("A");
		
		
	
		String test = "list: ";
		for(String str: testSorted) {
			test = test + str + " ";
		}

		//System.out.println(test);
		//System.out.println("size: " + testSorted.getSize());
		
		String expected = ("list: A B B F Quinn ");
		assertTrue(test.equals(expected));
	}
	
	
	
	

}
