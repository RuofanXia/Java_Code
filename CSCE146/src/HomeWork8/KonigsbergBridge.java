package HomeWork8;

import java.util.ArrayList;

public class KonigsbergBridge {
	
	int[][] matrix;
	int land, bridge;
	ArrayList<Integer> visitedBridges = new ArrayList<Integer>();
	public KonigsbergBridge(int land, int bridge)
	{
		this.land = land;
		this.bridge = bridge;
		matrix = new int[land][bridge];
	}
	
	public void addEdge(int land, int bridge, int weight)
	{
		matrix[land][bridge] = weight;
		
		/*
		 *			 [1,1,0,1,0,0,0]
		 *  matrix = [1,1,1,0,1,1,0]
		 *  	     [0,0,0,0,1,1,1]
		 *           [0,0,1,1,0,0,1]
		 */
	}
	
	public boolean DFSCheck(int start, int current)
	{
		if (visitedBridges.size() == (bridge - 1) && start == current) // terminate condition when all bridges visited, and current is the start.
		{
			return true;
		}
		if (visitedBridges.size() == (bridge - 1) && start != current) // terminate condition, when all bridges visited, but the current is't the start.
		{
			return false;
		}
		
		for (int i=1; i<bridge; i++)
		{
			if (visitedBridges.contains(i) == false && matrix[current][i] > 0) //check if the the bridge has been visited 
			{
				for (int j=1; j<land && j!=current; j++)
				{
					if(matrix[j][i] > 0)
					{
						visitedBridges.add(i); //add this bridge into array list.
						if(DFSCheck(start, j))
						{
							return true;
						}
						visitedBridges.remove(visitedBridges.size()-1); // if the DFSCheck return false, remove the last element in array list.
					}
				}
			}
		}
		return false;
	}
	
	public boolean findWay()
	{
		for (int i=0; i<land-1; i++)
		{
			if (DFSCheck(i+1, i+1)) // as long as we find one path then return, don't need to continue searching.
			{
				return true;
			}
		}
		
		return false;
	}
}
			
