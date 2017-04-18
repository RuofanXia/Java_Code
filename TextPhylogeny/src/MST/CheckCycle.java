package MST;

import java.util.Stack;

public class CheckCycle {
	private Stack<Integer> stack;
    private int adjacencyMatrix[][];
 
    public CheckCycle()
    {
        stack = new Stack<Integer>();
    }
    
    public boolean checkCycle(int adjacency_matrix[][], int source)
    {
    	 boolean cyclepresent = false;
         int number_of_nodes = adjacency_matrix[source].length - 1;
  
         adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
         for (int sourcevertex = 1; sourcevertex <= number_of_nodes; sourcevertex++)
         {
             for (int destinationvertex = 1; destinationvertex <= number_of_nodes; destinationvertex++)
             {
                 adjacencyMatrix[sourcevertex][destinationvertex] = adjacency_matrix[sourcevertex][destinationvertex];
             }
          }
  
          int visited[] = new int[number_of_nodes + 1];
          int element = source;
          int i = source;
          visited[source] = 1;
          stack.push(source);
          
          while (!stack.isEmpty())
          {
              element = stack.peek();
              i = element;
              while (i <= number_of_nodes)
              {
                  if (adjacencyMatrix[element][i] >= 1 && visited[i] == 1)
                  {
                      if (stack.contains(i))
                      {
                          cyclepresent = true;
                          return cyclepresent;
                      }
                  }
                  if (adjacencyMatrix[element][i] >= 1 && visited[i] == 0)
                  {
                      stack.push(i);
                      visited[i] = 1;
                      adjacencyMatrix[element][i] = 0;// mark as labelled;
                      adjacencyMatrix[i][element] = 0;
                      element = i;
                      i = 1;
                      continue;
                   }
                   i++;
              }
              stack.pop();
         }
          
         return cyclepresent;
    }
}
