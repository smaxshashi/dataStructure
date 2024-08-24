package com.javadsa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListLearning {

	public static void placesLinkedList() {

		List<Places> myList = new LinkedList<Places>();

		Places place = new Places();
		place.setName("Bombay");
		place.setDistance(3000);
		myList.add(place);

		Places place2 = new Places();
		place.setName("Bangalore");
		place.setDistance(4000);
		myList.add(place2);

		Places place3 = new Places();
		place.setName("Patna");
		place.setDistance(2000);
		myList.add(place3);

		Places place4 = new Places();
		place.setName("Tamil Nadu");
		place.setDistance(4500);
		myList.add(place4);

		Places place5 = new Places();
		place.setName("kerala");
		place.setDistance(5000);
		myList.add(place5);

		Iterator<Places> iterator = myList.iterator();
		Places previousStation = myList.get(0);
		while (iterator.hasNext()) {
			System.out.println("Added Places " + previousStation);
			previousStation = iterator.next();
		}

	}

	public static void ascendingTwoMergedLinkedList() {

		Node node1 = new Node(5);
		node1.next = new Node(10);
		node1.next.next = new Node(20);
		node1.next.next.next = new Node(40);
		System.out.println("Node1 !---->> " + node1);

		Node node2 = new Node(1);
		node2.next = new Node(3);
		node2.next.next = new Node(6);
		node2.next.next.next = new Node(9);
		System.out.println("Node2 !---->> " + node2);
		
		List<Integer> mergedElements= new ArrayList<>();
		
		while(node1!=null) {
			mergedElements.add(node1.key);
			node1=node1.next;
		}
		
		while(node2!=null) {
			mergedElements.add(node2.key);
			node2=node2.next;
		}
		Collections.sort(mergedElements);
		System.out.println("Merged Linked list in Ascending ---->>> "+mergedElements.toString());
		
		
		Node newMergedNode= new Node(-1);
		Node initialNode=newMergedNode;
		for(int i=0;i<mergedElements.size();i++) {
			newMergedNode.next=new Node(mergedElements.get(i));
			newMergedNode=newMergedNode.next;
		}
		initialNode=initialNode.next;
		System.out.print("Merged LinkedList ------> ");
		while(initialNode!=null) {
			System.out.print(initialNode.key+" ");
			initialNode=initialNode.next;
		}
		
		Collections.reverse(mergedElements);
		//System.out.println("Merged Linked list in Descending ---->>> "+mergedElements.toString());
		
		
	}
	
	public static void reverseLinkedList() {
		
		// 4->3->2->1 == 1->2->3->4
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		
		Node current=node;
		Node prev=null;
		Node next=null;
		System.out.println("UnReversed "+node);
		while(current!=null) {
			next=current.next;
			current.next= prev;
			prev=current;
			current=next;
		}
		node=prev;
		System.out.println("Reversed "+node);
	}
	
	
	public static void addLastInLinkedList(int value,int position) {
		Node node = new Node(1);
		node.next = new Node(2);
		Node nodeToAdd = new Node(value);
		System.out.println(node);
		Node previous=node;
		int count=1;
		while(count<position-1) {
			previous= previous.next;
			count++;
		}
		Node current= previous.next;
		nodeToAdd.next=current;
		previous.next=nodeToAdd;
		
		System.out.println("LinkedList : "+node);
	}
	
	
	
	public static void deleteFromFirst() {
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next= new Node(3);
		System.out.println("LinkedList Inputed :: "+node);
		
		Node temp=node;
		node= node.next;
		temp.next=null;
		
		Node n=node;
		while(n!=null) {
			System.out.println("LinkedList :: "+node);
			n=n.next;
		}
		
		
		
	}
	
	
	public static void searchInLinkedList(int value) {
		Node node = new Node(1);
		node.next = new Node(3);
		node.next.next = new Node(5);

		Node current = node;
		while (current != null) {
			if (current.key == value) {
				System.out.println("Found It is here ");
			}
			current = current.next;
		}
		System.out.println("Not");

	}
	
	
	public static void middleOfLinkedList() {
		
		Node node = new Node(6);
		node.next = new Node(3);
		node.next.next = new Node(5);
		node.next.next.next = new Node(15);
		node.next.next.next.next = new Node(17);
		System.out.println("LinkedList "+node);
		
		Node slowPtr=node;
		Node fastPtr= node;
		
		while(fastPtr!=null&&fastPtr.next!=null) {
			slowPtr=slowPtr.next;
			fastPtr=fastPtr.next.next;
		}
		System.out.println("Middle Node "+slowPtr.key);
		
	}
	
	public static void lastFromLinkedList(int n) {
		
		Node node = new Node(6);
		node.next = new Node(3);
		node.next.next = new Node(5);
		node.next.next.next = new Node(15);
		node.next.next.next.next = new Node(17);
		System.out.println("LinkedList "+node);
		
		
		Node mainPtr= node;
		Node tempPtr=node;
		
		int count=0;
		while(count<n) {
			tempPtr=tempPtr.next;
			count++;
		}
		while(tempPtr!=null) {
			tempPtr=tempPtr.next;
			mainPtr= mainPtr.next;
		}
		System.out.println(mainPtr.key);
		
	}
	
	public static void removeKeyFromLinkedList(int value) {
		Node node = new Node(6);
		node.next = new Node(3);
		node.next.next = new Node(5);
		node.next.next.next = new Node(15);
		node.next.next.next.next = new Node(17);
		
		System.out.println(node);
		
		
		Node current= node;
		Node temp=null;
		
		while(current!=null && current.key==value) {
			current= current.next;
			return;
		}
		while(current!=null&&current.key!=value) {
			temp=current;
			current=current.next;
			
		}
		if(current==null) {
			return;
		}
		temp.next=current.next;
		System.out.println(node);
		
	}
	
	public static void ifContainsloop() {
		Node node = new Node(6);
		node.next = new Node(3);
		node.next.next = new Node(5);
		node.next.next.next = new Node(15);
		node.next.next.next.next = new Node(17);
		
		
		Node fastPtr=node;
		Node slowPtr=node;
		
		while(fastPtr!=null && fastPtr.next!=null) {
			fastPtr=fastPtr.next;
			slowPtr=slowPtr.next;
			if(fastPtr==slowPtr) {
				System.out.println("True");
			}
		}
		System.out.println("False");
	}
	
	public static void sumOfTwoLinkedListDigit(Node a,Node b) {
		// 2 -->3 -->5 -->1 -->null
		// 6 -->7 -->4 -->null
		
		System.out.println(a);
		System.out.println(b);
		Node dummyNode= new Node(0);
		Node tail= dummyNode;	
		int carry=0;
		while(a!=null|| b!=null) {
			int x=0;
			int y=0;
			if(a!=null) {
				x= a.key;
			}else {
				x=0;
			}
			if(b!=null) {
				y= b.key;
			}else {
				y= 0;
			}
			
			int sum=carry+x+y;
			carry=sum/10;
			tail.next=new Node(sum%10);
			tail=tail.next;
			
			if(a!=null) {
				a=a.next;
			}
			if(b!=null) {
				b=b.next;
			}
			
		}if(carry>0) {
			tail.next=new Node(carry);
		}
		System.out.println(dummyNode.next);
		
		
	}
	
	
	public static void partitioningAround(Node node, int num) {
		
		System.out.println(node);
		Node dummyNodeOne= new Node(0);
		Node tailOne= dummyNodeOne;
		Node dummyNodeTwo= new Node(0);
		Node tailTWo= dummyNodeTwo;
		
		Node head=node;
		while(head!=null) {
			
			if(head.key<num) {
				tailOne.next=new Node(head.key);
				tailOne= tailOne.next;
			}else {
				tailTWo.next=new Node(head.key);
				tailTWo= tailTWo.next;
			}
			head= head.next;
			
		}
		
		Node firstNode=dummyNodeOne.next;
		System.out.println(firstNode);
		Node secondNode= dummyNodeTwo.next;
		System.out.println(secondNode);
		
		tailOne.next= secondNode;
		System.out.println(firstNode);
		
	}
	
	public static Node reverseInGroup(Node node, int k) {
		System.out.println(node);
		 if(node == null) {
			 return null; 
		 }
	          
		int count =0;
		Node current = node;
		Node prev= null;
		Node next= null;
		while(current!=null && count<k) {
			next= current.next;
			current.next= prev;
			prev= current;
			current= next;	
			count++;
			
		}
		if(next!=null) {
			current.next=reverseInGroup(next,k);
		}
		return prev;
		
		
		
	}
	
	public static void mergeTwoLinkedList(Node a, Node b) {
		System.out.println(a+" "+b);
		
		Node dummyNode = new Node(0);
		Node tail= dummyNode;
		
		while(a!=null && b!=null) {
			
			if(a.key<b.key) {
				tail.next= a;
				tail= tail.next;
				a= a.next;
			}else {
				tail.next=b;
				tail= tail.next;
				b=b.next;
			}
		}
		if(a!=null) {
			tail.next=a;
		}else {
			tail.next=b;
		}
		
		System.out.println(dummyNode.next);
		
	}
	
	public static void flattening(Node node) {
		
	}
	
	
	
	public static void rotateLinkedList(Node node,int k) {
		
		System.out.println(node);
		Node dummNodeOne= new Node(0);
		Node dummNodeTwo= new Node(0);
		Node tailTwo=dummNodeTwo;
		Node tailOne=dummNodeOne;
		int count =0;
		
		Node head= node;
		while(count<k) {
			tailTwo.next=new Node(head.key);
			head= head.next;
			tailTwo= tailTwo.next;
			count++;
		}
		while(head!=null){
			tailOne.next=new Node(head.key);
			head= head.next;
			tailOne= tailOne.next;
		}
		
		dummNodeOne=dummNodeOne.next;
		
		//System.out.println(dummNodeOne);
		
		dummNodeTwo= dummNodeTwo.next;
		//System.out.println(dummNodeTwo);
		
		tailOne.next=dummNodeTwo;
		System.out.println(dummNodeOne);
			
		
		
	}
	
	public static void intersectionOfNode(Node a, Node b) {
		
		Node headA=a;
		Node headB=b;
		
		while(headA!=headB) {
			if(headA==null) {
				headA=headB;
				
			}else {
				headA= headA.next;
			}
			if(headB==null) {
				headB=headA;
			}else {
				headB= headB.next;
			}
		}
		System.out.println(headA);

		
	}
	
	
	public static Node reverseNode(Node node) {
		
		Node current = node;
		Node prev= null;
		Node next= null;
		while(current!=null) {
			next= current.next;
			current.next= prev;
			prev= current;
			current= next;		
		}
		node= prev;
		return node;
	}
	
	
	public static void main(String[] args) {
		
		//addLastInLinkedList(4,3);
		//deleteFromFirst();
		
		//searchInLinkedList(3);
		//middleOfLinkedList();
		
		//lastFromLinkedList(2);
		
		//removeKeyFromLinkedList(5);
		Node node = new Node(10);
		node.next = new Node(20);
		node.next.next = new Node(30);
		node.next.next.next = new Node(40);
		node.next.next.next.next = new Node(50);
		node.next.next.next.next.next = new Node(60);
		
		Node node2 = new Node(6);
		node2.next = new Node(4);
		node2.next.next = new Node(1);

		//reverseNode(node2);
		//partitioningAround(node,3);
		
		//sumOfTwoLinkedListDigit(node,node2);
		
		//mergeTwoLinkedList(node,node2);
		
		rotateLinkedList(node,4);
		
	}
	

}
