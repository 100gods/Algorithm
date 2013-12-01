import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
In a world which survives on food, water, oxygen and text messages; we notice that people often don’t bother much about punctuation and grammar in their text messages. 
This is somewhat understandable, partly because every extra keystroke on a miniature keypad takes a lot more work than it would take on a laptop or a desktop.

We’d like to build a small sub-feature of a punctuation corrector which can handle one small but specific, 
and frequent issue: detecting (and correcting) whether the appropriate form of the word ought to be “its” or “it’s” - a common point of confusion in general.

It's is the contraction of "it is" and "it has."  
Its is a possessive form - i.e., it shows ownership.  

You are given sentences which contain one or more occurrences of either ‘its’ or ‘it’s’. 
These occurrences have been replaced by three question marks (???). Display with correct form of the sentence, 
with the question marks replaced by either ‘it’s’ or ‘its’, as appropriate.
*/
public class Solution {

    static Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
    static Map<String,Integer> copyMap = new HashMap<String, Integer>();

    /**
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
	// TODO Auto-generated method stub
	File file = new File(System.getProperty("user.dir")+"/corpus.txt");
	//File file = new File("/home/saurabh/Desktop/corpus.txt");
	BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
	String line = new String();
	Map<String, Integer> mapValue = new HashMap<>();
	while ((line = bufferedReader.readLine()) != null) {
	    if (line.matches(".*[iI]t is.*")) {
		int value = 0;
		String word = null;
		if((line.split("[iI]t is").length<2)) continue;
		if ((line.split("[iI]t is").length>=2)&&((line.split("[iI]t is")[1].trim().split("\\ ").length>=1)&&(line.split("[iI]t is")[1].trim().split("\\ ")[0].equals("a")
			|| line.split("[iI]t is")[1].trim().split("\\ ")[0]
				.equals("an")
			|| line.split("[iI]t is")[1].trim().split("\\ ")[0]
				.equals("the")))) {
		    word = line.split("[iI]t is")[1].trim().split("\\ ").length >=2 ?line.split("[iI]t is")[1].trim().split("\\ ")[1]:line.split("[iI]t is")[1].trim().split("\\ ")[0] ;
		} else {
		    word = line.split("[iI]t is")[1].trim().split("\\ ")[0];
		    
		}
		word=word.trim().replaceAll("[^a-zA-Z]+","");
		mapValue = map.get(word);
		if (mapValue == null) {
		    mapValue = new HashMap<>();
		    mapValue.put("N", 1);
		    mapValue.put("V", 0);
		    map.put(word, mapValue);
		} else {
		    value = mapValue.get("N") + 1;
		    mapValue.put("N", value);
		    map.put(word, mapValue);

		}
	    } else if (line.matches(".*[iI]t has.*")) {
		int value = 0;
		String word = null;
		if((line.split("[iI]t has").length<2)) continue;
		if ((line.split("[iI]t has").length>=2)&&((line.split("[iI]t has")[1].trim().split("\\ ").length>=1)&&(line.split("[iI]t has")[1].trim().split("\\ ")[0].equals("a")
			|| line.split("[iI]t has")[1].trim().split("\\ ")[0]
				.equals("an")
			|| line.split("[iI]t has")[1].trim().split("\\ ")[0]
				.equals("the")))) {
		    word = line.split("[iI]t has")[1].trim().split("\\ ").length >=2 ?line.split("[iI]t has")[1].trim().split("\\ ")[1]:line.split("[iI]t is")[1].trim().split("\\ ")[0] ;
		} else {
		    word = line.split("[iI]t has")[1].trim().split("\\ ")[0];
		    
		}
		word=word.trim().replaceAll("[^a-zA-Z]+","");
		mapValue = map.get(word);
		if (mapValue == null) {
		    mapValue = new HashMap<>();
		    mapValue.put("N", 1);
		    mapValue.put("V", 0);
		    map.put(word, mapValue);
		} else {
		    value = mapValue.get("N") + 1;
		    mapValue.put("N", value);
		    map.put(word, mapValue);

		}
	    } else if (line.matches(".*[iI]t's.*")) {
		int value = 0;
		String word = null;
		if((line.split("[iI]t's").length<2)) continue;
		if ((line.split("[iI]t's").length>=2)&&((line.split("[iI]t's")[1].trim().split("\\ ").length>=1)&&(line.split("[iI]t's")[1].trim().split("\\ ")[0].equals("a")
			|| line.split("[iI]t's")[1].trim().split("\\ ")[0]
				.equals("an")
			|| line.split("[iI]t's")[1].trim().split("\\ ")[0]
				.equals("the")))) {
		    word = line.split("[iI]t's")[1].trim().split("\\ ").length >=2 ?line.split("[iI]t's")[1].trim().split("\\ ")[1]:line.split("[iI]t's")[1].trim().split("\\ ")[0] ;
		} else {
		    word = line.split("[iI]t's")[1].trim().split("\\ ")[0];
		    
		}
		word=word.trim().replaceAll("[^a-zA-Z]+","");
		mapValue = map.get(word);
		if (mapValue == null) {
		    mapValue = new HashMap<>();
		    mapValue.put("V", 1);
		    mapValue.put("N", 0);
		    map.put(word, mapValue);
		} else {
		    value = mapValue.get("V") + 1;
		    mapValue.put("V", value);
		    map.put(word, mapValue);

		}
	    }

	}
	//System.out.println(map);
	for (Entry<String, Map<String, Integer>> ratio : map.entrySet()) {
	    if (ratio.getValue().get("V")==0) {
		copyMap.put(ratio.getKey(), 2);
	    }else{
		
		
		copyMap.put(ratio.getKey(), (ratio.getValue().get("N")/ratio.getValue().get("V")));
	    }
	}
	Scanner scanner=new Scanner(System.in);
	int n=Integer.parseInt(scanner.nextLine().trim());
	String lineString=null;
	String[] words=null;
	Integer value=0;
	boolean flag=false;
	
	for (int i = 0; i < n; i++) {
	    lineString=scanner.nextLine().trim();
	    words=lineString.split("\\?{3}");
	    // check first index 
	    if(lineString.indexOf("???") == 0 ) flag=true;
	    if (lineString.indexOf("???") == lineString.length()-3-2|| words.length < 2) {
		 lineString=lineString.replaceAll("\\?{3}", "its" );
            System.out.println(lineString);
	    }else{
		String word=words[1].split("\\ ")[0].length() < 2 ? words[1].split("\\ ")[1]:words[1].split("\\ ")[0];
		value=copyMap.get(word.trim().replaceAll("[^a-zA-Z]+",""));
		String repl=null;
		if (flag ) {
		    repl="It's";
		}else if(null == value|| value>1){
		    repl="its";
		}else if(value >1){
		    repl="Its";
		}else{
		    repl="it's";
		}
		lineString=lineString.replaceAll("\\?{3}",repl);
		System.out.println(lineString);
            flag=false;
	}
	}
	
	
    }








}
