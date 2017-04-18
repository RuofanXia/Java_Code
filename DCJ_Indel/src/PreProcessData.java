
import java.io.File;
import java.io.IOException;
import java.util.*;

public class PreProcessData {
	static final String IN_FILE_NAME = "example.genome";
	static final String DELIM = " ";
	
	public static List<List<List<Integer>>> ReadInData() {
		List<List<List<Integer>>> all_data = new ArrayList<List<List<Integer>>>();	
		try
		{
			Scanner readFile = new Scanner(new File(IN_FILE_NAME));
			List<List<Integer>> data = new ArrayList<List<Integer>>();
			while (readFile.hasNextLine())
			{
				String fileLine = readFile.nextLine();
				if (!fileLine.equals("") && fileLine.charAt(0) == '>')
				{
					if (data.size() != 0)
					{
						all_data.add(data);
						data = new ArrayList<List<Integer>>();
					}
				}
				else if (!fileLine.equals("") && fileLine.charAt(0) == 'C')
				{
					String[] split_data = fileLine.split(DELIM);
					ArrayList<Integer> line_data = new ArrayList<Integer>();
					for (int i=1; i<split_data.length; i++)
					{
						line_data.add(Integer.parseInt(split_data[i]));
					}
					data.add(line_data);
				}
			}
			all_data.add(data);
			/*
			for (int i=0; i<all_data.size(); i++)
			{
				System.out.println("G: ");
				for (int j=0; j<all_data.get(i).size(); j++)
				{
					System.out.print("C: ");
					for (int k=0; k<all_data.get(i).get(j).size(); k++)
					{
						System.out.print(all_data.get(i).get(j).get(k) + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			*/
			readFile.close();
			
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		return all_data;
	}
	
	public static Set<Integer> equalGene(List<List<List<Integer>>> all_data)
	{
		Set<Integer> set = new HashSet<Integer>();
		if (all_data.size()<2) 
		{
			System.out.println("Genome Number Smaller than 2");
			System.exit(0);
		}
		List<List<Integer>> first_Genome = all_data.get(0);
		for (int i=0; i<first_Genome.size(); i++)
		{
			for (int j=0; j<first_Genome.get(i).size(); j++)
			{
				int val = Math.abs(first_Genome.get(i).get(j));
				set.add(val);
			}
		}
		
		Set<Integer> g = new HashSet<Integer>();
		
		List<List<Integer>> second_Genome = all_data.get(1);
		for (int i=0; i<second_Genome.size(); i++)
		{
			for (int j=0; j<second_Genome.get(i).size(); j++)
			{
				int val = Math.abs(second_Genome.get(i).get(j));
				if (set.contains(val))
				{
					g.add(val);
				}					
			}
		}
		
		return g;
	}
	
	public static List<HashMap<Integer,int[]>> genearteTable(List<List<Integer>> genome, Set<Integer> g)
	{
		List<HashMap<Integer,int[]>> result = new ArrayList<HashMap<Integer, int[]>>();
		int index = 1;
		HashMap<Integer, int[]> order_table = new HashMap<Integer, int[]>();
		HashMap<Integer, int[]> gene_table = new HashMap<Integer, int[]>();
		for (int i=0; i<genome.size(); i++)
		{
			List<Integer> list = genome.get(i);
			List<Integer> valid = new ArrayList<Integer>();
			for (int j=0; j<list.size(); j++)
			{
				int val = Math.abs(list.get(j));
				if (g.contains(val))
				{
					valid.add(list.get(j));
				}
			}
			if (valid.size() == 0) continue;
			int[] encode = new int[valid.size()*2 + 2];
			encode[0] = -1;
			encode[encode.length-1] = -1;
			int node_index = 1;
			for (int j=0; j<valid.size(); j++)
			{
				int val = valid.get(j);
				if (val > 0)
				{
					encode[node_index++] = val*2-1;
					encode[node_index++] = val*2;
				}
				else
				{
					encode[node_index++] = val*2*(-1);
					encode[node_index++] = val*2*(-1)-1;
				}
			}
			for (int j=0; j<encode.length; j+=2)
			{
				int[] first_second = new int[2];
				first_second[0] = encode[j];
				first_second[1] = encode[j+1];
				int temp = index;
				order_table.put(index++, first_second);
				if(encode[j] != -1)
				{
					if (encode[j] % 2 == 0)
					{
						int gene = encode[j] / 2;
						int[] head_tail;
						if (gene_table.containsKey(gene))
						{
							head_tail = gene_table.get(gene);
						}
						else
						{
							head_tail = new int[2];
						}
						head_tail[1] = temp;
						gene_table.put(gene, head_tail);
					}
					else
					{
						int gene = (encode[j] + 1) / 2;
						int[] head_tail;
						if (gene_table.containsKey(gene))
						{
							head_tail = gene_table.get(gene);
						}
						else
						{
							head_tail = new int[2];
						}
						head_tail[0] = temp;
						gene_table.put(gene, head_tail);
					}
				}
				if(encode[j+1] != -1)
				{
					if (encode[j+1] % 2 == 0)
					{
						int gene = encode[j+1] / 2;
						int[] head_tail;
						if (gene_table.containsKey(gene))
						{
							head_tail = gene_table.get(gene);
						}
						else
						{
							head_tail = new int[2];
						}
						head_tail[1] = temp;
						gene_table.put(gene, head_tail);
					}
					else
					{
						int gene = (encode[j+1] + 1) / 2;
						int[] head_tail;
						if (gene_table.containsKey(gene))
						{
							head_tail = gene_table.get(gene);
						}
						else
						{
							head_tail = new int[2];
						}
						head_tail[0] = temp;
						gene_table.put(gene, head_tail);
					}
				}
			}
		}
		result.add(order_table);
		result.add(gene_table);
		
		return result;
	}
	
	public static List<Components> generateComponent(List<List<Integer>> genome_a, List<List<Integer>> genome_b, List<HashMap<Integer,int[]>> table, Set<Integer> set)
	{
		return null;
	}
	
	public static ListNode[] convertLinkedList(List<List<Integer>> genome, Set<Integer> set, int tag)
	{
		ListNode[] ga_linklist = new ListNode[genome.size()];
		for (int i=0; i<genome.size(); i++)
		{
			List<Integer> chromosome= genome.get(i);
			List<Integer> unique = new ArrayList<Integer>();
			for (int j=0; j<chromosome.size(); j++)
			{
				int val = chromosome.get(j);
				if (set.contains(Math.abs(val)))
				{
					unique.add(val);
				}
			}
			ListNode head;
			if (unique.size() > 0)
			{
				int[] unique_num = new int[unique.size()*2+2];
				unique_num[0] = 0;
				unique_num[unique_num.length-1] = 0;
				int index = 1;
				for (int j = 0; j<unique.size(); j++)
				{
					int val = unique.get(j);
					if (val > 0)
					{
						unique_num[index++] = val*2-1;
						unique_num[index++] = val*2;
					}
					else
					{
						unique_num[index++] = val*(-2);
						unique_num[index++] = val*(-2)-1;
					}
				}
				head = new ListNode(unique_num[0], unique_num[1], tag, 0);
				int j=2;
				ListNode prev = head;
				while(j<unique_num.length-1)
				{
					ListNode node = new ListNode(unique_num[j], unique_num[j+1], tag, 0);
					prev.next = node;
					node.prev = prev;
					prev = prev.next;
					j += 2;
				}
			}
			else
			{
				System.out.println("unique size is 0");
				head = new ListNode(0, 0, tag, 0);
			}
			
			int start = 0, end = 0;
			while(end < chromosome.size())
			{
				int val = chromosome.get(end);
				while(end<chromosome.size() && !set.contains(Math.abs(val)))
				{
					end++;
					if (end < chromosome.size()) val = chromosome.get(end);
					else break;
				}
				if (end > start)
				{
					int[] labels = new int[end-start];
					for (int j=start; j<end; j++)
					{
						labels[j-start] = chromosome.get(j);
					}
					int first_val = 0, second_val = 0;
					if(start > 0) 
					{
						first_val = chromosome.get(start-1) > 0 ? chromosome.get(start-1)*2 : chromosome.get(start-1)*(-1)*2-1;
					}
					else
					{
						first_val = 0;
					}
					if (end < chromosome.size())
					{
						second_val = chromosome.get(end) > 0 ? chromosome.get(end)*2-1 : chromosome.get(end)*(-2);
					}
					else
					{
						second_val = 0;
					}
					/*
					printLinkedList(head);
					System.out.println("first_val: " + first_val);
					System.out.println("second_val: " + second_val);
					*/
					ListNode target = findNode(head, first_val, second_val);
					if (target == null) System.out.println("NULL");
					target.label = labels;
				}
				start = end + 1;
				while(start<chromosome.size() && set.contains(Math.abs(chromosome.get(start))))
				{
					start++;
				}
				end = start;
			}
			ga_linklist[i] = head;
		}
		
		return ga_linklist;
	}
	
	public static ListNode findNode(ListNode head, int first, int second)
	{
		if (head == null ) return head;
		
		ListNode ptr = head;
		while(ptr != null)
		{
			if(ptr.first == first && ptr.second == second) return ptr;
			ptr = ptr.next;
		}
		
		return null;
	}
	
	/*for debug usage*/
	public static void printLinkedList(ListNode head)
	{
		if (head == null) return;
		ListNode tail = head;
		System.out.println("head to tail!");
		while(head != null)
		{
			System.out.println(head.first + " " + head.second);
			head = head.next;
		}
	
		while(tail.next != null)
		{
			tail = tail.next;
		}
		
		System.out.println("tail to head");
	
		while(tail != null)
		{
			System.out.println(tail.first + " " + tail.second);
			tail = tail.prev;
		}
	}
	
	public static void printLinkedListWithLabel(ListNode head)
	{
		if (head == null) return;
		ListNode tail = head;
		System.out.println("head to tail!");
		while(head != null)
		{
			System.out.print(head.first + " ");
			int[] label = head.label;
			if (label != null)
			{
				for (int i=0; i<label.length; i++)
				{
					System.out.print(label[i] + " ");
				}
			}
			System.out.print(head.second);
			System.out.println();
			head = head.next;
		}
	
		while(tail.next != null)
		{
			tail = tail.next;
		}
		
		System.out.println("tail to head");
	
		while(tail != null)
		{
			System.out.print(tail.first + " ");
			int[] label = tail.label;
			if (label != null)
			{
				for (int i=0; i<label.length; i++)
				{
					System.out.print(label[i] + " ");
				}
			}
			System.out.print(tail.second);
			System.out.println();
			tail = tail.prev;
		}
	}
}

