import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> list = new HashMap<Integer, String>();
		list.put(0, "a");
		list.put(1, "b");
		list.put(0, "a");
		list.put(1, "b");
		list.put(0, "a");
		list.put(1, "b");
		list.put(0, "a");
		list.put(1, "b");
		list.put(0, "a");
		list.put(1, "b");
		list.put(0, "a");
		list.put(110, "b");
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		List keys = new ArrayList(list.keySet());
		System.out.println(keys.get(keys.size()-1));
		System.out.println(list.size());
	}

}
