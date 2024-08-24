package com.javadsa.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class GenericTree {
	
	public class Node{
		
		int data;
		ArrayList<Node> children= new ArrayList<>();
		
	}
	
	
	
	public void displayGenericTree(Node node) {
		
		String str= node.data+"->";

		for(int i=0;i<node.children.size();i++) {
			str=str+node.children.get(i)+" ,";
		}
		str=str+".";
		System.out.println(str+"");
		
		for(int i=0;i<node.children.size();i++) {
			displayGenericTree(node.children.get(i));
		}
		
	}
	
	public void generateGenericTree(int[] arr) {
		
		Stack<Node> stack= new Stack<>();
		
		Node root= new Node();
		
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]==-1) {
				stack.pop();
				
			}else {
				
				Node tempNode= new Node();
				tempNode.data=arr[i];
				
				
				if(stack.size()>0) {
					
					Node ifAlreadyNodeInStack= stack.peek();
					ifAlreadyNodeInStack.children.add(tempNode);	
					
				}else {
					root= tempNode;
				}
				stack.push(tempNode);

			}

		}
		displayGenericTree(root);
		
		
	}
	
	
	
	public int maximumInGenericTree(Node node) {
		
		int overallMax=Integer.MIN_VALUE;
		
		for(Node child: node.children) {
			int childMax=maximumInGenericTree(child);
			overallMax=Math.max(childMax, overallMax);
			
		}
		overallMax=Math.max(node.data, overallMax);
		return overallMax;
		
		
	}
	
	public int heightOfGenericTree(Node node) {
		
		int height=-1;
		
		for(Node child:node.children) {
			int childHeight=heightOfGenericTree(child);
			height=Math.max(childHeight, height);
			
		}
		height=height+1;
		return height;
		
	}
	
	
	public void traversalInGenericTree(Node node) {
	
		//Pre order
		System.out.println("Pre order"+node.data);
		
		for(Node child:node.children) {
			traversalInGenericTree(child);
			
		}
	
		//Post order
		System.out.println("post order"+node.data);
			
	}
	
	public void levelOrderTraversal(Node node) {

		Queue<Node> queue = new ArrayDeque<>();

		queue.add(node);

		while (queue.size() > 0) {
			Node n = queue.remove();
			System.out.println(n.data);
			for (Node child : n.children) {
				queue.add(child);

			}
		}

	}
	
	
	public void levelOrderLineWiseTraversal(Node node) {
		
		Queue<Node> mainQueue = new ArrayDeque<>();
		mainQueue.add(node);
		
		Queue<Node> childQueue = new ArrayDeque<>();
		
		while(mainQueue.size()>0) {
			node=mainQueue.remove();
			System.out.println(node+" ");
			
			for(Node child:node.children) {
				
				childQueue.add(child);
			}
			if(mainQueue.size()==0) {
				mainQueue=childQueue;
				childQueue= new ArrayDeque<>();
				System.out.println();
			}
		}

	}
	
	
	public void levelOrderZigZag(Node node) {
		
		Stack<Node> mainStack= new Stack<>();
		mainStack.add(node);
		int level=1;
		Stack<Node> childStack= new Stack<>();
		while(mainStack.size()>0) {
			
			node= mainStack.pop();
			System.out.println(node.data);
			
			//add from left side in child stack
			if(level%2==0) {
				for(Node child:node.children) {
					childStack.add(child);
				
			    }
			}
			//add from right side in child stack
			else {
				for(int i=node.children.size()-1;i>=0;i--) {
					childStack.add(node.children.get(i));
				}

			}
			if(mainStack.size()==0) {
				mainStack= childStack;
				childStack= new Stack<>();
				level++;
				System.out.println();
			}

		}
		

	}
	
	public void mirrorOfGenericTree(Node node) {
		
		for(Node child:node.children) {
			mirrorOfGenericTree(child);	
		}
		
		Collections.reverse(node.children);
		
	}
	
	
	public void removeLeavesFromGenericTree(Node node) {

		for (int i = node.children.size() - 1; i >= 0; i--) {

			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(child);
			}

		}
		for (Node child : node.children) {
			removeLeavesFromGenericTree(child);
		}

	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		
		GenericTree tree= new GenericTree();
		
		tree.generateGenericTree(arr);
		
		
		
		
	}
		

}
