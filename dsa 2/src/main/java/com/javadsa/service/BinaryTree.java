package com.javadsa.service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	private TreeNode root;
	
	public void createTreeNode() {
		TreeNode first= new TreeNode(1);
		TreeNode second= new TreeNode(2);
		TreeNode third= new TreeNode(3);
		TreeNode fourth= new TreeNode(4);
		TreeNode fifth= new TreeNode(5);
		TreeNode sixth= new TreeNode(6);
		TreeNode seventh= new TreeNode(7);
		
		root=first;
		root.left=second;
		root.right=third;
		
		second.left=fourth;
		second.right=fifth;
		
		third.left=sixth;
		third.right=seventh;
	}
	
	
	public void preOrderByRecursion(TreeNode root) { // learn Recursion work
		if(root==null) {
			System.out.print(" ~ ");
			return;
		}
		System.out.print(root.data+" ");
		preOrderByRecursion(root.left);
		preOrderByRecursion(root.right);
	}
	
	public void preOrderByStackIterator(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> stack= new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp= stack.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null) {
				stack.push(temp.right);
			}
			if(temp.left!=null) {
				stack.push(temp.left);
			}
		}

	}
	
	
	public void inOrderByRecursion(TreeNode root) {
		
		if(root==null) {
			return;
		}
		
		inOrderByRecursion(root.left);
		System.out.print(root.data+" \n");
		inOrderByRecursion(root.right);
		
	}
	
	
	public void inOrderByStack(TreeNode root) {
		
		if(root==null) {
			return;
		}
		Stack<TreeNode> stack= new Stack<>();
		TreeNode temp= root;
		
		while(!stack.isEmpty() || temp!=null) {
			if(temp!=null) {
				stack.push(temp);
				temp= temp.left;
			}else {
				temp=stack.pop();
				System.out.print(temp.data+" ");
				temp=temp.right;
			}
			
		}
		
	}
	
	
	public void levelOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		Queue<TreeNode> queue= new LinkedList<>(); //FIFO
		queue.offer(root);
		while(queue!=null) {
			TreeNode temp=queue.poll();
			System.out.println(temp.data+" ");
			if(temp.left!=null) {
				queue.offer(temp.left);
			}
			if(temp.right!=null) {
				queue.offer(temp.right);
			}
		}
	}
	
	
	public TreeNode insertIntoSearchTree(TreeNode root, int value) {
		if(root==null) {
			root=new TreeNode(value);
			 return root;
		}
		if(value<root.data) {
			root.left=insertIntoSearchTree(root.left,value);
		}
		if(value>root.data) {
			root.right=insertIntoSearchTree(root.right,value);
		}
		return root;
	}
	
	
	public TreeNode searchInSearchTree(TreeNode root,int value) {
		if(root==null || root.data==value) {
			return root;
		}
		
		if(value<root.data) {
			return searchInSearchTree(root.left,value);
		}else {
			return searchInSearchTree(root.right, value);
		}
	}
	
	public boolean isValidSearchTree(TreeNode root, long min,long max) {
		if(root==null) {
			return true;
		}
		if(max< root.data || root.data<=min ) {
			return false;
		}
		boolean left=isValidSearchTree(root.left,min,root.data);
		if(left) {
			boolean right=isValidSearchTree(root.right,root.data,max);
			return right;
		}
		return false;
	}
	
	
	
	public boolean isSymmetryBinaryTree(TreeNode root) {
		if(root==null) {
			return true;
			
		}
		Stack<TreeNode> stack= new Stack<>();
		stack.push(root.right);
		stack.push(root.left);
		while(!stack.isEmpty()) {
			
			TreeNode nLeft= stack.pop();
			TreeNode nRight= stack.pop();
			
			if(nLeft==null && nRight==null) {
				return true;
				
			}
			if(nLeft.data==nRight.data) {
				continue;
			}
			if(nLeft==null || nRight==null) {
				return false;
			}
			if(nLeft.data!=nRight.data) {
				return false;
			}
			stack.push(nLeft.left);
			stack.push(nRight.right);
			stack.push(nLeft.right);
			stack.push(nRight.left);
		}
		return true;
	}
	
	public void zigZagTraversal(TreeNode node) {
		
		Stack<TreeNode> parentStack= new Stack<>();
		Stack<TreeNode> childStack= new Stack<>();
		
		parentStack.push(node);
		childStack.push(root.left);
		childStack.push(root.right);
	}
	
	
	
	public void printElementsOfBinaryTree(Integer[] array) {
		BtNode root= new BtNode(array[0], null, null) ;
		Pair pair= new Pair(root,1);
		
		Stack<Pair> stack= new Stack<>();
		stack.push(pair);
		int index=0;
		while(stack.size()>0) {
			Pair nodeState= stack.peek();
			if(nodeState.state==1) {
				index++;
				if(array[index]!=null) {
					nodeState.node.left=new BtNode(array[index], null, null);
					Pair lPair= new Pair(nodeState.node.left,1);
					stack.push(lPair);
				}else {
					nodeState.node.left=null;
				}
				nodeState.state++;
			}
			else if(nodeState.state==2) {
				index++;
				if(array[index]!=null) {
					nodeState.node.right=new BtNode(array[index], null, null);
					Pair lPair= new Pair(nodeState.node.right,2);
					stack.push(lPair);
				}else {
					nodeState.node.right=null;
				}
				nodeState.state++;
				
			}else {
				stack.pop();
			}
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		BinaryTree bt= new BinaryTree();
		bt.createTreeNode();
		
		//bt.preOrderByRecursion(bt.root);
		
		bt.preOrderByStackIterator(bt.root);
		System.out.println("---------");
		bt.inOrderByStack(bt.root);
		
		
	}

}
