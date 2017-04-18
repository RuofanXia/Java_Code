package Amz_OA2;

import java.util.*;
public class Solution {
    private static double distance(Point a, Point b)
    {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
     
    public static Point[] closestPoint(Point[] array, final Point origin, int k)
    {
        if(k > array.length) return array;
        Point[] res = new Point[k];
        Arrays.sort(array, new Comparator<Point>()
        {
            @Override
            public int compare(Point a, Point b)
            {
                return Double.compare(distance(a, origin), distance(b, origin));
            }
         
        });
        for(int i = 0; i < k; i++) res[i] = array[i];
        return res;
    }
    public static Point[] closestPoint2(Point[] array, final Point origin, int k)
    {
        if(k > array.length) return array;
        Point[] res = new Point[k];
        PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>()
        {
            @Override
            public int compare(Point a, Point b)
            {
                return -Double.compare(distance(a, origin), distance(b, origin));
            }
        });
        for(Point p: array) queue.offer(p);
        while(queue.size() > k) queue.poll();
        for(int i = 0; i < k; i++) res[k - 1 - i] = queue.poll();
        return res;
    }
    public static void main(String[] args)
    {
        Point origin = new Point(0, 0);
        Point[] input = new Point[]{new Point(0, 2), new Point(1, 1), new Point(-1, 0), new Point(2, 0), new Point(3, 0)};
        Point[] output = closestPoint2(input, origin, 4);
        System.out.println("input");
        for(Point i : input) System.out.print("("+i.x+", "+i.y+") ");
        System.out.println("");
        System.out.println("output");
        for(Point i : output) System.out.print("("+i.x+", "+i.y+") ");
         
         
    }
}
