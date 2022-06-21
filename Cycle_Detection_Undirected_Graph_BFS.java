package com.home.dsa.graph.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Link : https://www.youtube.com/watch?v=A8ko93TyOns

public class Cycle_Detection_Undirected_Graph_BFS
{
	// Tracking the previous node of the current node.

	class Node
	{
		int current;
		int previous;

		public Node(int current,int previous)
		{
			this.current = current;
			this.previous = previous;
		}
	}

	/*
	 * Time Complexity : O(N+E)
	 * N is the time taken for visiting N nodes, E is for travelling through adjacent nodes overall.
	 * 
	 * Space Complexity : O(N+E) + O(N) + O(N)
	 * Space for Adjacency List, visiting array and queue.
	 */

	public boolean checkCycleUndirectedGraphBFS(int i, boolean visited[], List<ArrayList<Integer>> adjacency)
	{
		Queue<Node> queue = new LinkedList<Node>();

		// Starting Node have always the previous node = -1;

		queue.add(new Node(i, -1));
		visited[i] = true;

		while(!queue.isEmpty())
		{
			int current = queue.peek().current;
			int previous = queue.peek().previous;
			queue.remove();

			for(int it : adjacency.get(current))
			{
				/*
				 * If the Adjacent Node is not visited, 
				 * Mark it as visited and add it in the Queue.
				 */
				if(visited[it] == false)
				{
					visited[it] = true;
					queue.add(new Node(it, current));
				}
				/* if the adjacent node is visited and,
				 * it is not the previous node,
				 * then there is a cycle in the graph
				 */
				else if(it != previous)
					return true;
			}
		}
		return false;
	}

	public boolean isCyclePresent(int n, List<ArrayList<Integer>> adjacency)
	{
		boolean visited[] = new boolean[n+1];
		Arrays.fill(visited, false);

		for(int i=1 ; i<=n ; i++)
			/*
			 * If the Node is not visited, 
			 * then process the Node for checking the cycle through BFS Traversal.
			 */
			if(visited[i] == false)
				if(checkCycleUndirectedGraphBFS(i, visited, adjacency))
					return true;
		return false;
	}
}
