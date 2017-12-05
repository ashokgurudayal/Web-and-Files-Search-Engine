package com.filesearchengine.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor; 
import org.apache.poi.xwpf.usermodel.XWPFDocument; 


import org.jsoup.Jsoup;
import org.tartarus.snowball.ext.PorterStemmer;

import com.filesearchengine.views.DesktopUI;

public class ButtonClickFunctionalities {
	static String textBox;
	static ArrayList<ArrayList<String>> matrix;
	static HashMap<String, List<Occurrence>> invertedIndex = new HashMap<String, List<Occurrence>>();
	static ArrayList<String> searchStringWords;
	static ArrayList<String> searchStringWordsStemmed;
	static ArrayList<Double> searchStringWordsWeights;
	static Double[][] docScore;
	static TST<List<String>> tst;
	static int docsInCompetition;

	public static void getTextFieldValue() {
		textBox = DesktopUI.textField.getText();
	}

	/**
	 * This function would be invoked when the clean all files button would be
	 * clicked TODO : Analysis folder contains files to be analyzed later on.
	 * Create a folder 'Analysis' (in class path). write code to clean all the
	 * files(if they are present) in the Analysis folder
	 * 
	 * @return String to be displayed in the Result text area
	 */
	public static String cleanAllFiles() {
		getTextFieldValue();
		// Clean all files functionalities
		// here
		File fin = new File(".\\Analysis");
		File[] finlist = fin.listFiles();
		for (int n = 0; n < finlist.length; n++) {
			if (finlist[n].isFile()) {
				System.gc();

				finlist[n].delete();
			}
		}
		return "Files cleaned successfully";
		// Clean all files functionalities
	}

	/**
	 * This function would be invoked when the add files url button would be
	 * clicked TODO : Create a file 'url.txt' (in class path) with many urls in
	 * seperate lines. Connect to all the urls in that txt file and save all
	 * contents of those webpages as .txt Use JSoup for this Save those files in
	 * the 'Analysis' folder
	 * 
	 * @return String to be displayed in the Result text area
	 */
	public static String addFilesUrl() {
		try {
		getTextFieldValue();// here
		BufferedReader br;
		
			br = new BufferedReader(new FileReader("url.txt"));
		String line;
		int c = 1;
		while ((line = br.readLine()) != null) {
			// process the line.
			org.jsoup.nodes.Document doc = Jsoup.connect(line).get();
			// org.jsoup.nodes.Document doc =
			// Jsoup.connect("http://blogs.windsorstar.com/news/woman-to-be-charged-with-child-abandonment-after-infants-found-in-apartment-stairwell").get();
			String text = doc.text();
			System.out.println(text);
			PrintWriter out = new PrintWriter(".\\Analysis\\doc" + c + ".txt", "UTF-8");
			c++;
			out.println(text);
			out.close();

		}
		br.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Connected to url and saved the files into ANALYSIS folder";
	}

	

	/**
	 * This function would be invoked when the add files dir button would be
	 * clicked TODO: Create a folder in class path 'Input' Take all the
	 * .doc,.pdf,.txt files present in that file,convert to .txt and save it in
	 * 'Analysis' folder
	 * 
	 * @return String to be displayed in the Result text area
	 */
	public static String addFilesDir() {
		final File folder = new File(".\\Input");
		java.io.File file = null; 
		int fileC = 0;
		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory()) {
				try {
					System.out.println("path:"+".\\Input\\"+fileEntry.getName());
				file = new java.io.File(".\\Input\\"+fileEntry.getName()); 
				java.io.FileInputStream fis = new java.io.FileInputStream(file.getAbsolutePath()); 
				XWPFDocument doc = new XWPFDocument(fis);
				
				XWPFWordExtractor ex ;
				ex = new XWPFWordExtractor(doc); 
				String text = ex.getText(); 

				//write the text in txt file java.io.File fil = new java.io.File("D:\\New.txt"); 
				java.io.Writer output = new java.io.BufferedWriter(new java.io.FileWriter(".\\Analysis\\Doc"+fileC+".txt"));
				fileC++;
				output.write(text); 
				output.close(); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	        }
		}
		getTextFieldValue();
		return "Saved the files from INPUT into ANALYSIS folder";
	}

	/**
	 * This function would be invoked when the tokenize button would be clicked
	 * TODO: Take all the files present in the folder and split each words and
	 * store it as ArrayList There will be n ArrayLists for n documents.
	 * 
	 * @return String to be displayed in the Result text area
	 */
	public static String tokenize() {
		String displayStr = "";
		matrix = new ArrayList<ArrayList<String>>();
		ArrayList<String> words = new ArrayList<String>();
		try {

			final File folder = new File(".\\Analysis");
			int c = 0;
			for (final File fileEntry : folder.listFiles()) {
				c++;
				displayStr = displayStr.concat("Doc" + c + ":");
				words = new ArrayList<String>();
				if (!fileEntry.isDirectory()) {
					fileEntry.getName();

					Scanner sc = new Scanner(new File(".\\Analysis\\" + fileEntry.getName()));

					String s;
					while (sc.hasNextLine()) {
						s = sc.nextLine();
						s = s.toLowerCase();
						s = s.replaceAll("[^a-zA-Z0-9\\s]", " ");
						StringTokenizer st = new StringTokenizer(s);
						while (st.hasMoreTokens()) {
							words.add(st.nextToken());
						}

					}
					displayStr = displayStr.concat(Integer.toString(words.size()) + "\n");
				}

				matrix.add(words);
			}

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		return ("Words have been tokenized.Words in each document:\n" + displayStr);
	}

	/**
	 * This function would be invoked when the porter stemmer button would be
	 * clicked TODO: Take the n ArrayLists, iterate through it,convert each word
	 * into it's root form using porter stemmer algorith and save it back to the
	 * arraylist.
	 * 
	 * @return String to be displayed in the Result text area
	 */
	public static String porterStemmer() {
		String displayStr = "\nSample conversion.Original:\n";
		for (int i = 0; i < matrix.get(0).size(); i++) {
			displayStr = displayStr.concat(" " + matrix.get(0).get(i));
		}

		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.get(i).size(); j++) {
				matrix.get(i).set(j, getPorterStemmer(matrix.get(i).get(j)));

			}
			System.out.println("");
		}
		// for (int i = 0; i < matrix.size(); i++) {
		// for (int j = 0; j < matrix.get(i).size(); j++) {
		// System.out.print(" " + matrix.get(i).get(j) + " ");
		//
		// }
		// System.out.println("");
		// }
		displayStr = displayStr.concat("\nAfter PorterStemmer\n");
		for (int i = 0; i < matrix.get(0).size(); i++) {
			displayStr = displayStr.concat(" " + matrix.get(0).get(i));
		}
		return ("Words have been stemmed to root form" + displayStr);
	}

	public static String getPorterStemmer(String initialStr) {
		getTextFieldValue();
		PorterStemmer ps = new PorterStemmer();
		ps.setCurrent(initialStr); // set string you need to stem
		ps.stem(); // stem the word
		return ps.getCurrent();// get the stemmed word
	}

	/**
	 * This function would be invoked when the inverted index button would be
	 * clicked TODO: Inverted index is a data structure in which we store word
	 * as key followed by it's occurrence in every other document.eg: key:walk
	 * value:doc1-3,doc2-5,doc3-7
	 * 
	 * @return String to be displayed in the Result text area
	 */
	public static String invertedIndex() {
		// FOR TESTING PURPOSE
		// ArrayList<ArrayList<String>> matrix = new
		// ArrayList<ArrayList<String>>();
		// ArrayList<String> oneDArray = new ArrayList<String>();
		// // for (int j = 0; j < 20; j++) {
		// // oneDArray = new ArrayList<String>();
		// // for (int i = 0; i < 5; i++) {
		// // oneDArray.add("Doc"+1+"word" + 1);
		// // }
		// //
		// // matrix.add(oneDArray);
		// // }
		// for (int j = 0; j < 3; j++) {
		// oneDArray = new ArrayList<String>();
		//
		// if (j == 0) {
		// oneDArray.add("hello");
		// oneDArray.add("there");
		// oneDArray.add("hello");
		// oneDArray.add("how");
		// oneDArray.add("google");
		// oneDArray.add("nice");
		// } else if (j == 1) {
		// oneDArray.add("by");
		// oneDArray.add("how");
		// oneDArray.add("by");
		// oneDArray.add("by");
		// } else {
		// oneDArray.add("how");
		// oneDArray.add("by");
		// oneDArray.add("there");
		// oneDArray.add("how");
		// oneDArray.add("good");
		// }
		// matrix.add(oneDArray);
		//
		// }

		// ITERATE AND CREATE INVERTED INDEX
		for (int j = 0; j < matrix.size(); j++) { // no. of docs
			for (int i = 0; i < matrix.get(j).size(); i++) { // no of words in
																// doc j
				System.out.print(" " + matrix.get(j).get(i) + " ");
				if (!invertedIndex.containsKey(matrix.get(j).get(i))) { // if
																		// invertedindex
																		// doesnt
																		// word
																		// matrix.get(j).get(i)
					// Create a new key and list as value
					Occurrence o = new Occurrence();
					o.setDocId(j);
					o.setTermFrequency(1);
					List<Occurrence> l = new ArrayList<Occurrence>();
					l.add(o);
					invertedIndex.put(matrix.get(j).get(i), l);
				} else { // if inverted index has word
							// get the list of occurrences
					List<Occurrence> l = invertedIndex.get(matrix.get(j).get(i));
					int flag = 0;
					// check if there is a entry for that doc
					for (Occurrence occurrenceEntry : l) {
						if (occurrenceEntry.getDocId() == j) {
							occurrenceEntry.setTermFrequency(occurrenceEntry.getTermFrequency() + 1);
							flag = 1;
							break;
						}
					}
					// If there is no entry for that doc
					if (flag == 0) {
						Occurrence oc = new Occurrence();
						oc.setDocId(j);
						oc.setTermFrequency(1);
						l.add(oc);
					}
				}
			}
			System.out.println();
		}
		String displayString = "";
		for (String key : invertedIndex.keySet()) {
			List<Occurrence> l = invertedIndex.get(key);
			displayString = displayString.concat("\n" + String.format("%1$-20s", key));
			// for(int i=1;i<=invertedIndex.size();i++){
			// int flag = 0;
			// int occ = 0;
			// for(Occurrence oc:l){
			// if(i==oc.getDocId()){
			// flag = 1;
			// occ = oc.getTermFrequency();
			// break;
			// }
			// else if(i<oc.getDocId()){
			// break;
			// }
			// }
			// if(flag == 0){
			// displayString = displayString.concat(" ");
			// }
			// else{
			// displayString = displayString.concat(" "+String.format("%1$-3s",
			// Integer.toString(occ)));
			// }
			// }

		}

		return ("\tHashMap was created successfully..\n\t Total number of words found:" + invertedIndex.size() + "\n"
				+ displayString);
	}

	/**
	 * This function would be invoked when the sort button would be clicked
	 * TODO: Sort the data structure that was created in the earlier step So
	 * that it takes the lesser time to search
	 * 
	 * @return String to be displayed in the Result text area
	 */
	public static String sort() {
		getTextFieldValue();
		return textBox;
	}

	/**
	 * This function would be invoked when the search string button would be
	 * clicked
	 * 
	 * @return String to be displayed in the Result text area
	 */
	public static String searchString() {
		getTextFieldValue();
		return "Enter a Search String above";
	}

	/**
	 * This function would be invoked when the remove special char button would
	 * be clicked TODO: write a regular expression to remove the special
	 * characters in the input string copy the updated input string to the
	 * search text box
	 * 
	 * @return String to be displayed in the Result text area
	 */
	public static String removeSpecialChar() {
		getTextFieldValue();
		// Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
		// Matcher match= pt.matcher(c);
		// while(match.find())
		// {
		// String s= match.group();
		// c=c.replaceAll("\\"+s, "");
		// }
		// System.out.println(c);
		// Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
		String displayText = "";
		displayText = displayText.concat("\n\tOriginal String:" + textBox);
		String s = textBox.replaceAll("[^a-zA-Z0-9\\s]", " ");
		s = s.toLowerCase();
		displayText = displayText.concat("\n\tConverted String:" + s);
		DesktopUI.textField.setText(s);
		return displayText;
	}

	/**
	 * This function would be invoked when the Tokenize in search string button
	 * would be clicked TODO: If there is a misspelled word,try to divide and
	 * make it meaning full.eg:'hellothere' should be made as 'hello there'
	 * Update the search string as the updated text
	 * 
	 * @return String to be displayed in the Result text area
	 */
	public static String tokenizeSearchString() {
		getTextFieldValue();
		String displayString = "\n";
		searchStringWords = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(textBox);
		int c = 0;
		while (st.hasMoreTokens()) {
			c++;
			String w = st.nextToken();
			displayString = displayString.concat("Word " + c + ":" + w + "\n");
			searchStringWords.add(w);
		}

		return displayString;
	}

	public static String PorterStemmerSearchString() {
		// TODO Auto-generated method stub
		searchStringWordsStemmed = new ArrayList<String>();
		getTextFieldValue();
		String displayString = "Original : " + textBox + "\nStemmed Result :";

		String stemmedWord;
		for (String s : searchStringWords) {
			stemmedWord = getPorterStemmer(s);
			searchStringWordsStemmed.add(stemmedWord);
			displayString = displayString.concat(stemmedWord + " ");
		}
		return displayString;
	}

	public static String tfidfTransform() {
		getTextFieldValue();
		String displayText = "";
		searchStringWordsWeights = new ArrayList<Double>();
		for (String s : searchStringWordsStemmed) {
			System.out.println("WORD:"+s);
			double wt = computeIdf(s);
			searchStringWordsWeights.add(wt);
			displayText = displayText.concat("\nWORD:" + s + "  " + "WEIGHT:" + wt);
		}
		return displayText;
	}

	public static double computeIdf(String word) {
		int nd = matrix.size();
		if(invertedIndex.containsKey(word)){
		double df = invertedIndex.get(word).size();
		System.out.println("Word:" + word);
		System.out.println("nd:" + nd);
		System.out.println("df of word:" + df);
		double idf = Math.log((2 + nd) / (1 + df));
		return (Math.abs(Math.round(idf * 100.0) / 100.0));
		}
		else return 1.0;
	}

	public static String wordOccurence() {
		getTextFieldValue();
		tst = new TST<List<String>>();
		// docScore = new String[matrix.size()][2];
		for (String w : searchStringWordsStemmed) {
			if (invertedIndex.containsKey(w)) {
				List<Occurrence> occ = invertedIndex.get(w);
				for (Occurrence c : occ) {
					if (tst.get("Doc" + Integer.toString(c.getDocId())) == null) {
						List<String> l = new ArrayList<String>();
						l.add(w + ":" + c.getTermFrequency());
						tst.put("Doc" + Integer.toString(c.getDocId()), l);
					} else {
						List<String> l = tst.get("Doc" + Integer.toString(c.getDocId()));
						l.add(w + ":" + c.getTermFrequency());
						tst.put("Doc" + Integer.toString(c.getDocId()), l);
					}
				}
			}
		}
		String displayText = "WORD OCCURENCES FOR EACH DOC FROM HASH TABLE--- HAS BEEN SAVED--- TO TRIE\n";
		docsInCompetition = 0;
		for (int i = 0; i < matrix.size(); i++) {
			if (tst.get("Doc" + i) != null) {
				docsInCompetition++;
				List<String> l = tst.get("Doc" + i);
				int score = 0;
				for (String s : l) {
					score = score + Integer.parseInt(s.split(":")[1]);

				}
				displayText = displayText.concat("\nDoc " + i + ":" + l + "=" + score);
			}

		}

		System.out.println("Trie value:" + tst.get("Doc0"));
		return displayText;
	}

	public static String findBestMatched() {
		getTextFieldValue();
		Arrays.sort(docScore, new Comparator<Double[]>() {
			public int compare(Double[] entry1, Double[] entry2) {
				// TODO Auto-generated method stub
				final Double score1 = entry1[1];
				final Double score2 = entry2[1];
				return score2.compareTo(score1);
			}
		});
		String displayText = "SCORE ARRAY WAS SORTED USING DUAL PIVOT SORT \nDOCUMENTS IN ORDER OF MATCH:";
		for (int i = 0; i < docsInCompetition; i++) {
			double dDocId = docScore[i][0];
			int iDocId = (int) dDocId;
			displayText = displayText.concat("\nDoc " + iDocId + "  SCORE:" + docScore[i][1]);
		}
		return displayText;
	}

	public static String scoreGenerate() {
		// TODO Auto-generated method stub

		docScore = new Double[docsInCompetition][2];
		String displayText = "WORD OCCURENCE IN DOCS\n";
		int docsInCompetitionC = 0;
		for (int i = 0; i < matrix.size(); i++) {
			double eachDocScore = 0.0;
			if (tst.get("Doc" + i) != null) {
				List<String> l = tst.get("Doc" + i);
				int score = 0;
				for (String s : l) {
					score = score + Integer.parseInt(s.split(":")[1]);
					int pos = findPosWordInSearchWordsStemmed(s.split(":")[0]);
					double wtOfWord = searchStringWordsWeights.get(pos);
					eachDocScore = eachDocScore
							+ Math.round((Integer.parseInt(s.split(":")[1]) * wtOfWord) * 100.0) / 100.0;
				}
				displayText = displayText.concat("\nDoc " + i + ":" + l + "=" + score);
				docScore[docsInCompetitionC][0] = (double) i;
				docScore[docsInCompetitionC][1] = Math.round( eachDocScore * 100.0) / 100.0;
				docsInCompetitionC++;
			}

		}
		displayText = displayText + "\n\nWORD WEIGHTS\n";

		for (int i = 0; i < searchStringWordsStemmed.size(); i++) {
			displayText = displayText.concat(
					"\nWORD:" + searchStringWordsStemmed.get(i) + "  " + "WEIGHT:" + searchStringWordsWeights.get(i));
		}
		displayText = displayText + "\n\nEACH DOC SCORE\n";
		for (int i = 0; i < docsInCompetitionC; i++) {
			double dDocId = docScore[i][0];
			int iDocId = (int) dDocId;
			displayText = displayText.concat("\nDoc " + iDocId + "  Score:" + docScore[i][1]);
		}
		return displayText;
	}

	private static int findPosWordInSearchWordsStemmed(String s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < searchStringWordsStemmed.size(); i++) {
			System.out.println("searchStringWordsStemmed.get(i):" + searchStringWordsStemmed.get(i));
			System.out.println("word" + s);
			if (s.equalsIgnoreCase(searchStringWordsStemmed.get(i))) {

				return i;
			}
		}
		return 0;
	}

	public static String editDistanceClicked() {
		// TODO Auto-generated method stub
		String displayText = "Computed Edit Distance for the search string words.\n";
		displayText = displayText.concat("\nThe words in the Search String before Edit Distance Computations\n");
		for (String st : searchStringWords) {
			displayText = displayText.concat(st + "\n");
		}
		int c = 0;
		int len = searchStringWords.size();
		System.out.println("Started");
		for (int k = 0; k < len; k++) {
			String s = searchStringWords.get(k);
			for (int i = 0; i < matrix.size(); i++) {
				for (int j = 0; j < matrix.get(i).size(); j++) {
					if (Sequences.editDistance(s, matrix.get(i).get(j)) == 1) {
						c++;
						// displayText = displayText.concat("
						// "+matrix.get(i).get(j));
						searchStringWords.add(matrix.get(i).get(j));
					}
				}
			}
		}

		System.out.println();
		System.out.println("Output");
		if (c > 0) {
			Set<String> hs = new HashSet<String>();
			hs.addAll(searchStringWords);
			searchStringWords.clear();
			searchStringWords.addAll(hs);
			displayText = displayText.concat("\nThe words in the Search String after Edit Distance Computations\n");
			String newWord = "";
			for (String s : searchStringWords) {
				displayText = displayText.concat(s + "\n");
				newWord = newWord.concat(s + " ");
			}
			DesktopUI.textField.setText(newWord);
		} else {
			displayText = displayText
					.concat("\nNo words were added as extra since there were no words with a edit distance of 1");
		}
		return displayText;
	}
}
