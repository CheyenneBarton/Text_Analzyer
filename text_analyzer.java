package cen3024;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

public class text_analyzer { 
	
	static HashMap<String, Integer> freq = new HashMap<>();

    public static void main(String[] args) {   
 
    	//getting path to the file
    	Path path = Paths.get("ravenpoem.txt");
    	
    	try {
    		//put the file into a string
    		String poem = Files.readString((path));
    		
    		//convert string to lowercase
    		poem = poem.toLowerCase();
    		
    		//put each word in their own array
            String [] words = poem.split(" ");
    		
    		//use Regex to only keep letters
  	      	Pattern p = Pattern.compile("[a-z]+");
  	      	Matcher m = p.matcher(poem);

  	      	//each call to find() will find the next word in the string
  	      	while (m.find()) {
  	      		//seperated and formatted words are put into a string
  	      		String word = m.group();	      		
  	        
  	        	//get the words
  	            Integer f = freq.get(word);
  	            
  	            //if word is found
  	            if  (f == null)
  	            {
  	            	freq.put(word, 1);
  	            } 
  	        //if same word is found, increase count
  	            else 
  	            {
  	            	freq.put(word, f+1);
  	            }
  	      	}
  	      	
  	      //sort the HashMap to top 20 and in descending order
  	      freq.entrySet().stream()
          .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
          .limit(20) 
          .forEach(System.out::println);


    	} catch (IOException xIo) {
            xIo.printStackTrace();
    	}
    }
  }
