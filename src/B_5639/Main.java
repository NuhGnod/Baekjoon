package B_5639;

import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int d) {
		this.data = d;

	}

}

class Tree {
	Node root;

	void add(int data) {
		if (root == null) {
			root = new Node(data);
			return;

		}
		add(root, data);
	}

	void add(Node node, int data) {
		if (node == null) {
			return;
		}
		if (node.data < data) {
			if (node.right == null) {
				node.right = new Node(data);
			} else {
				add(node.right, data);
			}
		} else {
			if (node.left == null) {
				node.left = new Node(data);
			} else {
				add(node.left, data);
			}
		}
	}

	void printPostOrder() {
		printPostOrder(root);
	}
	void printPostOrder(Node node) {
		if(node == null)return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.println(node.data);
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tree tree = new Tree();

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;

			}
			if(s.length()<=0)break;
			tree.add(Integer.parseInt(s));

		}
		tree.printPostOrder();

	}

}
