package Amz;

import java.util.*;

public class WordLadderOne {
	public int solution(String beginWord, String endWord, List<String> wordlist)
	{
		if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 || wordlist.size() == 0)
		{
			return 0;
		}
		
		HashSet<String> set = new HashSet<String>();
		
		for (String str : wordlist)
		{
			set.add(str);
		}
		
		Queue<String> queue = new LinkedList<String>();
		int level = 1;
		queue.offer(beginWord);
		
		while(!queue.isEmpty())
		{
			int size = queue.size();
			for (int i=0; i<size; i++)
			{
				String word = queue.poll();
				for (int j=0; j<word.length(); j++)
				{
					char[] chs = word.toCharArray();
					for (char c='a'; c<='z'; c++)
					{
						chs[j] = c;
						String temp = new String(chs);
						if (set.contains(temp) && temp.equals(endWord)) return level+1;
						if (set.contains(temp))
						{
							queue.offer(temp);
							set.remove(temp);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}
	
}
