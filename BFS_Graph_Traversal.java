package com.home.dsa.graph.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Link : https://www.youtube.com/watch?v=UeE67iCK2lQ

public class BFS_Graph_Traversal
{
	/*
	 * Time Complexity : O(N+E)
	 * N is the time taken for visiting N nodes and E is for travelling through adjacent nodes overall.
	 * 
	 * Space Complexity : O(N+E) + O(N) + O(N)
	 * Space for Adjacency List, Visited Array and Auxillary Space.
	 */

	public List<Integer> bfs_graph_traversal(int n,ArrayList<ArrayList<Integer>> adjacency)
	{
		List<Integer> bfs = new ArrayList<Integer>();
		boolean visited[] = new boolean[n+1];

		for(int i=1 ; i<=n ; i++)
		{
			// if the node is not visited, call bfs on that node.
			if(visited[i] == false)
			{
				visited[i] = true;
				Queue<Integer> queue = new LinkedList<Integer>();
				// Putting the first node in the queue.
				queue.add(i);
				while(!queue.isEmpty())
				{
					Integer node = queue.poll();
					bfs.add(node);

					// Iterating all the adjacent nodes
					for(int it : adjacency.get(node))
					{
						// If the node is not visited, add in the queue by marking it visited node.
						if(visited[it] == false)
						{
							visited[it] = true;
							queue.add(it);
						}
					}
				}
			}
		}
		return bfs;
	}
}
