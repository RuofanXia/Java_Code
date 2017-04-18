import java.util.*;

public class EliminationGame {
	public static int lastRemaining(int n) {
        if (n <= 1) return n;
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<=n; i++)
        {
            list.add(i);
        }
        
        int direction = 0;
        
        while(list.size()>1)
        {
            int step = 0;
            if (list.size() % 2 == 0)
            {
                step = list.size()/2;
            }
            else
            {
                step = list.size()/2 + 1;
            }
            if (direction == 0)
            {
                int index = 0;
                while(step>0)
                {
                    list.remove(index++);
                    step--;
                }
                direction = 1;
            }
            else
            {
                int index = list.size()-1;
                while(step>0)
                {
                    list.remove(index--);
                    step--;
                }
                direction = 0;
            }
        }
        return list.get(0);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lastRemaining(9));
	}

}
