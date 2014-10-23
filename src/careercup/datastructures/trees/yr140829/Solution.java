//-----------------------------------------------------------------------
// <copyright file="Solution.cs" company="MyCompany">
//     Copyright (c) MyCompany. All rights reserved.
// </copyright>
//-----------------------------------------------------------------------
package careercup.datastructures.trees.yr140829;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* http://www.careercup.com/question?id=5752678512590848
 Given a binary tree,Write a function to return all of the nodes from a given node and a given distance. The function has three parameters root, the given node and the given distance. For example 
 5 
 /\ 
 4 7 
 /\ 
 6 10 
 \ 
 12 
 Calling the function F(root,7,1) will the return all the nodes from node 7 with the distance 1 which is 6,10,5 
 another example is F(root.7,2) will the return nodes 12,4
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		TreeNode top = createTree();

		// 0
		int test = 0;
		test = test(top, test, 7, 1, Arrays.asList(5));

		// 1
		test = test(top, test, 7, 2, Arrays.asList(4));
	}

	private static int test(TreeNode top, int test, int start, int dist,
			List<Integer> expected) throws Exception {
		System.out.println("Test " + (test++));
		List<TreeNode> list = solve(top, start, dist);
		System.out.println("F(root," + start + "," + dist + ")");
		System.out.println("Actual: ");
		if (expected.size() != list.size()) {
			System.out.println("FAILED: Incorrect number of items in expected vs actual");
			// return;
		} else {
			HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
			for (TreeNode n : list) {
				System.out.print(n.val + " ");
				if (hash.containsKey(n.val)) {
					hash.put(n.val, hash.get(n.val) + 1);
				} else {
					hash.put(n.val, 1);
				}
			}
			System.out.println();
			for (int i = expected.size() - 1; i >= 0; i--) {
				int e = expected.get(i);
				boolean found = hash.containsKey(e) && (hash.get(e) > 0);

				if (!found) {
					System.out
							.println("FAILED: Following expected item not returned: "
									+ e);
					return test;
				} else {
					hash.put(e, hash.get(e) - 1);
				}
			}

			// if(expected.size()==0)
			// {
			System.out.println("PASSED");
			// }
		}
		System.out.println("-------------------------");
		return test;
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(5);
		TreeNode top = root;
		TreeNode node = new TreeNode(4);
		root.left = node;
		node = new TreeNode(7);
		root.right = node;
		root = root.left;
		node = new TreeNode(6);
		root.left = node;
		node = new TreeNode(10);
		root.right = node;
		root = root.left;
		node = new TreeNode(12);
		root.right = node;
		return top;
	}

	private static List<TreeNode> solve(TreeNode root, int val, int dist)
			throws Exception {
		List<TreeNode> result = new ArrayList<TreeNode>();
		Map<TreeNode,TreeNode> backTrack = new HashMap<TreeNode,TreeNode>();
		TreeNode startNode = findStartNode(root, val, backTrack);
		getDescendants(startNode,dist,backTrack,result);
		return result;
	}

	private static void getDescendants(TreeNode startNode, int dist,
			Map<TreeNode, TreeNode> backTrack, List<TreeNode> result) throws Exception {
		visited = new HashMap<TreeNode,Object>();
		getDescendants(startNode, dist, result);
		TreeNode current = startNode;
		if(current!=null && backTrack.containsKey(current)){
			TreeNode parent = backTrack.get(current);
			getDescendants(parent, dist-1, result);
			current = parent;
		}
	}

	private static Map<TreeNode,Object> visited;
	private static void getDescendants(TreeNode startNode, int dist,
			List<TreeNode> result) throws Exception {		
		if(startNode==null){ throw new Exception("Start node cannot be null!");}
		visited.put(startNode,null);
		if(dist==0){result.add(startNode);}
		if(startNode.left!=null && !visited.containsKey(startNode.left)){
			getDescendants(startNode.left, dist-1, result);
		}
		if(startNode.right!=null && !visited.containsKey(startNode.right)){
			getDescendants(startNode.right, dist-1, result);
		}
	}

	private static TreeNode findStartNode(TreeNode root, int val, Map<TreeNode,TreeNode> backTrack) throws Exception{
		if(root==null) {throw new Exception("Root should not be null!");}
		if(root.val==val) { return root; }
		if(root.left!=null){
			backTrack.put(root.left, root);		
			TreeNode found = findStartNode(root.left, val, backTrack);
			if(found!=null){return found;}
		}
		if(root.right!=null){
			backTrack.put(root.right,root);		
			TreeNode found = findStartNode(root.right, val, backTrack);
			if(found!=null){return found;}
		}
		return null;
	}
		

	private static List<TreeNode> find(TreeNode root, int val, int dist) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		Map<Integer, List<TreeNode>> levelHash = new HashMap<Integer, List<TreeNode>>();
		List<TreeNode> currentLevel = new ArrayList<TreeNode>();
		currentLevel.add(root);
		int k = 0;
		levelHash.put(k, currentLevel);
		int numInLevel = 1;
		int nextLevelCount = 0;
		TreeNode startNode = null;
		int currDist = 0;
		int startLevel = 0;
		// while(!q.isEmpty()){
		List<TreeNode> childLevel = new ArrayList<TreeNode>();
		for (int i = 0; i < currentLevel.size(); i++) {
			TreeNode next = currentLevel.get(i);
			--numInLevel;

			if (startNode == null && next.val == val) {
				startNode = next;
				startLevel = k;
			}
			if (startNode != null && currDist == dist) {
				result.add(next);
			}
			if (next.left != null) {
				nextLevelCount++;
				childLevel.add(next.left);
			}
			if (next.right != null) {
				nextLevelCount++;
				childLevel.add(next.right);
			}

			if (numInLevel == 0) {
				numInLevel = nextLevelCount;
				nextLevelCount = 0;
				if (childLevel.size() == 0) {
					break;
				} else {
					levelHash.put(++k, childLevel);
					currentLevel = childLevel;
					i = -1;
					childLevel = new ArrayList<TreeNode>();
				}
				if (startNode != null) {
					currDist++;
				}
				if (currDist > dist) {
					break;
				}
			}
		}

		if (startNode != null) {
			int prev = startLevel - dist;
			if (prev >= 0) {
				List<TreeNode> ancestors = levelHash.get(prev);
				result.addAll(ancestors);
			}
		}
		return result;
	}

}
