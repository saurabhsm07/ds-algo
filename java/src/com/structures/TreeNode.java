package com.structures;


public class TreeNode {
		public int data ;
		public TreeNode left,right;
		public TreeNode(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		left=right=null;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[data=");
			builder.append(data);
			builder.append("]");
			return builder.toString();
		}
		
	}

