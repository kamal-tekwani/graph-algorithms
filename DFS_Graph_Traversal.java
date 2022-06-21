package com.home.dsa.graph.algo;

import java.util.ArrayList;
import java.util.List;

// Link : https://www.youtube.com/watch?v=uDWljP2PGmU

public class DFS_Graph_Traversal 
{
	/*
	 * Time Complexity : O(N+E)
	 * N is the time taken for visiting N nodes and E is for travelling through adjacent nodes overall.
	 * 
	 * Space Complexity : O(N+E) + O(N) + O(N)
	 * Space for Adjacency List, Visited Array and Auxillary Space.
	 */

	public List<Integer> dfs_graph_traversal(int n,List<ArrayList<Integer>> adjacency)
	{
		List<Integer> dfs = new ArrayList<Integer>();
		boolean visited[] = new boolean[n+1];

		for(int i=1 ; i<=n ; i++)
			// If the node is not visited, call the dfs for that node.
			if(visited[i] == false)
				dfs(i, visited, adjacency, dfs);

		return dfs;
	}

	public void dfs(int i, boolean visited[], List<ArrayList<Integer>> adjacency, List<Integer> dfs)
	{
		dfs.add(i);
		visited[i] = true;

		// Iterating over all the adjacents nodes and call dfs if they are not visted earlier.
		for(int it : adjacency.get(i))
		{
			if(visited[it] == false)
				dfs(it, visited, adjacency, dfs);
		}
	}
}
