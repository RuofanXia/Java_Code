package Amz_OA2;

import java.util.*;

public class KClosestPoints {
	public static Point[] solution(Point[] points, int k)
	{
		if (points.length <= k) return points;
		
		PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>(){
			public int compare(Point a, Point b)
			{
				int distance = (int)((b.x * b.x + b.y * b.y) - (a.x + a.x + a.y + a.y));
				return distance;
			}
		});
		//PriorityQueue<Point> queue = new PriorityQueue<Point>();
		
		for(int i=0; i<points.length; i++)
		{
			queue.offer(points[i]);
			if (queue.size()>k)
			{
				queue.poll();
			}
		}
		
		Point[] result = new Point[k];
		int index=0;
		while(!queue.isEmpty())
		{
			result[index++] = queue.poll();
		}
		return result;
	}
	
	public static void main(String[] args)
    {
        Point[] input = new Point[]{new Point(0, 2), new Point(1, 1), new Point(-1, 0), new Point(2, 0), new Point(3, 0)};
        Point[] output = solution(input, 4);
        System.out.println("input");
        for(Point i : input) System.out.print("("+i.x+", "+i.y+") ");
        System.out.println("");
        System.out.println("output");
        for(Point i : output) System.out.print("("+i.x+", "+i.y+") ");
         
         
    }
}	
