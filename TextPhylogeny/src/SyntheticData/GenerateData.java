package SyntheticData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import edu.smu.tspell.wordnet.*;

/**
 * Displays word forms and definitions for synsets containing the word form
 * specified on the command line. To use this application, specify the word
 * form that you wish to view synsets for, as in the following example which
 * displays all synsets containing the word form "airplane":
 * <br>
 * java TestJAWS airplane
 */
public class GenerateData
{

	/**
	 * Main entry point. The command-line arguments are concatenated together
	 * (separated by spaces) and used as the word form to look up.
	 */
	public static void main(String[] args)
	{
		int[] nodes_num = {10};
		double[] edit_limit = {0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35, 0.40, 0.45, 0.50};
		//System.out.println(Synonym.SynonymReplacement("median"));
		Random random = new Random();
		
		String path = "/Users/Fan/Downloads/C50/C50test/AaronPressman/42764newsML.txt";
		String misspelPath = "/Users/Fan/Downloads/Misspell/missp.dat";
		String misspelWikiPath = "/Users/Fan/Downloads/Misspell/wikipedia_misspelling.dat";
		
		String data = ReadInData.readFile(new File(path));
		
		Map<String, ArrayList<String>> misspel_map = LoadMisspelData.LoadMissp(misspelPath);
		
		Map<String, ArrayList<String>> misspelwiki_map = LoadMisspelData.LoadWikiMissp(misspelWikiPath);
		
		String[] sentences = data.split("\\.");
		
		//System.out.println(sentences.length);
		
		//hold-out some sentences for insertion usage
		int hold_out_nums = sentences.length / 10;
		
		int[] hold_out_index = new int[hold_out_nums];
		
		for (int i=0; i<hold_out_nums; i++)
		{
			hold_out_index[i] = random.nextInt(sentences.length);
		}
		
		//randomly choose operation, 0 - 4, 0 : synonym exchange, 1: removal misspeling 2: insertion misspelling  3:insertion sentences 4: deletion sentences
		
		for (int i=0; i<nodes_num.length; i++)
		{
			List<Integer> hold_out_index_hs = new ArrayList<Integer>();
			
			for (int j=0; j<hold_out_nums; j++)
			{
				hold_out_index_hs.add(hold_out_index[j]);
			}
			for (int j=0; j<nodes_num[i]; j++)
			{
				String temp = new String(data);
				String[] temp_sentences = temp.split("\\.");
				int op =(int) (temp_sentences.length * edit_limit[random.nextInt(edit_limit.length)]);
				for (int k=0; k<op; k++)
				{
					int operation = random.nextInt(5);
					if (operation == 0)
					{
						//synonym exchange
						int sentence_index = random.nextInt(temp_sentences.length);
						while(hold_out_index_hs.contains(sentence_index))
						{
							sentence_index = random.nextInt(temp_sentences.length);
						}
						String line = temp_sentences[sentence_index];
						String[] words = line.split(" ");
						int word_index = random.nextInt(words.length);
						String word = words[word_index];
						String new_line = "";
						for (int l=0; l<words.length; l++)
						{
							if (l != word_index)
							{
								new_line += words[l] + " ";
							}
							else
							{
								new_line += Synonym.SynonymReplacement(word) + " ";
							}
						}
						if (!new_line.equals(""))
						{
							new_line = new_line.substring(0, new_line.length()-1);
							temp_sentences[sentence_index] = new_line;
						}
						
					}
					else if(operation == 1)
					{
						// misspel remove 
						int sentence_index = random.nextInt(temp_sentences.length);
						while(hold_out_index_hs.contains(sentence_index))
						{
							sentence_index = random.nextInt(temp_sentences.length);
						}
						String line = temp_sentences[sentence_index];
						String[] words = line.split(" ");
						for (int l=0; l<words.length; l++)
						{
							if (Misspelling.containsWord(misspel_map, words[l]))
							{
								words[l] = Misspelling.getCorrectWord(misspel_map, words[l]);
							}
							else if (Misspelling.containsWord(misspelwiki_map,words[l]))
							{
								words[l] = Misspelling.getCorrectWord(misspelwiki_map, words[l]);
							}
						}
						
						String new_line = "";
						for (int l=0; l<words.length; l++)
						{
							new_line += words[l] + " ";
						}
						if (!new_line.equals(""))
						{
							new_line = new_line.substring(0, new_line.length()-1);
							temp_sentences[sentence_index] = new_line;
						}
						
					}
					else if(operation == 2)
					{
						// insert misspelling
						int sentence_index = random.nextInt(temp_sentences.length);
						while(hold_out_index_hs.contains(sentence_index))
						{
							sentence_index = random.nextInt(temp_sentences.length);
						}
						String line = temp_sentences[sentence_index];
						String[] words = line.split(" ");
						int word_index = random.nextInt(words.length);
						String word = words[word_index];
						String new_line = "";
						if (Misspelling.containsWord(misspel_map, word))
						{
							for (int l=0; l<words.length; l++)
							{
								if (l != word_index)
								{
									new_line += words[l] + " ";
								}
								else
								{
									new_line += Misspelling.getInCorrectWord(misspel_map, word) + " ";
								}
							}
							
							
						}
						else if (Misspelling.containsWord(misspelwiki_map,word))
						{
							for (int l=0; l<words.length; l++)
							{
								if (l != word_index)
								{
									new_line += words[l] + " ";
								}
								else
								{
									new_line += Misspelling.getInCorrectWord(misspelwiki_map, word) + " ";
								}
							}
						}
						if (!new_line.equals(""))
						{
							new_line = new_line.substring(0, new_line.length()-1);
							temp_sentences[sentence_index] = new_line;
						}
						
					}
					
					else if(operation == 3)
					{
						if (hold_out_index_hs.size()> 0 )
						{	
							int index = random.nextInt(hold_out_index_hs.size());
							hold_out_index_hs.remove(index);
						}
						
					}
					else
					{
						int sentence_index = random.nextInt(temp_sentences.length);
						while(hold_out_index_hs.contains(sentence_index))
						{
							sentence_index = random.nextInt(temp_sentences.length);
						}
						hold_out_index_hs.add(sentence_index);
					}
					
					//write to disk
					String file_name = nodes_num[i] + "_Node_" + j + ".txt";
					try
					{
						File fout = new File(file_name);
						FileOutputStream fos = new FileOutputStream(fout);
					 
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
						for (int l = 0;  l< temp_sentences.length; l++) {
							if (!hold_out_index_hs.contains(l))
								bw.write(temp_sentences[l] + ".");
						}
					 
						bw.close();
					}
					catch(IOException e)
					{
						System.out.println(e.getMessage());
					}
				}
				
			}
		}
		
		
	}

}
