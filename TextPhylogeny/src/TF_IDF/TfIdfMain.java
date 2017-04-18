package TF_IDF;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Mubin Shrestha
 */
public class TfIdfMain {
    
    /**
     * Main method
     * @param args
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        DocumentParser dp = new DocumentParser();
        dp.parseFiles("/Users/Fan/Downloads/parse_data");
        dp.tfIdfCalculator(); //calculates tfidf
        dp.getCosineSimilarity(); //calculated cosine similarity   
    }
}

