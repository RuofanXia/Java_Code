package SyntheticData;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class Synonym {
	public static String SynonymReplacement(String s )
	{
		/*
		System.setProperty("wordnet.database.dir", "/Users/Fan/Downloads/WordNet-3.0/dict");
		
		if (args.length > 0)
		{
			//  Concatenate the command-line、 arguments
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < args.length; i++)
			{
				buffer.append((i > 0 ? " " : "") + args[i]);
			}
			String wordForm = buffer.toString();
			//  Get the synsets containing the wrod form
			WordNetDatabase database = WordNetDatabase.getFileInstance();
			Synset[] synsets = database.getSynsets(wordForm);
			//  Display the word forms and definitions for synsets retrieved
			if (synsets.length > 0)
			{
				System.out.println("The following synsets contain '" +
						wordForm + "' or a possible base form " +
						"of that text:");
				for (int i = 0; i < synsets.length; i++)
				{
					System.out.println("");
					String[] wordForms = synsets[i].getWordForms();
					for (int j = 0; j < wordForms.length; j++)
					{
						System.out.print((j > 0 ? ", " : "") +
								wordForms[j]);
					}
					System.out.println(": " + synsets[i].getDefinition());
				}
			}
			else
			{
				System.err.println("No synsets exist that contain " +
						"the word form '" + wordForm + "'");
			}
		}
		else
		{
			System.err.println("You must specify " +
					"a word form for which to retrieve synsets.");
		}
		*/
		System.setProperty("wordnet.database.dir", "/Users/Fan/Downloads/WordNet-3.0/dict");
		WordNetDatabase database = WordNetDatabase.getFileInstance();
		Synset[] synsets = database.getSynsets(s);
		//  Display the word forms and definitions for synsets retrieved
		String res = "";
		Random r = new Random();
		if (synsets.length > 0)
		{
			System.out.println("The following synsets contain '" +
					s + "' or a possible base form " +
					"of that text:");
			Set<String> hs = new HashSet<String>();
			for (int i = 0; i < synsets.length; i++)
			{
				System.out.println("");
				String[] wordForms = synsets[i].getWordForms();
				for (int j = 0; j < wordForms.length; j++)
				{
					System.out.print((j > 0 ? ", " : "") +
							wordForms[j]);
					if (!wordForms[j].equals(s))
					{
						hs.add(wordForms[j]);
					}
						
				}
				System.out.println(": " + synsets[i].getDefinition());			
			}
			if (hs.size()>0)
			{
				int index = r.nextInt(hs.size());
				Iterator<String> iterator = hs.iterator();
				while(index>0 && iterator.hasNext())
				{
					iterator.next();
					index--;
				}
				
				res = iterator.next();
			}
		}
		else
		{
			System.err.println("No synsets exist that contain " +
					"the word form '" + s + "'");
		}
		return res;
	}
}
