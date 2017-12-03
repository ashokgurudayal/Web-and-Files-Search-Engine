package com.filesearchengine.model;

import com.filesearchengine.views.DesktopUI;

public class ButtonClickFunctionalities {
	static String textBox ;
	public static void getTextFieldValue(){
		 textBox = DesktopUI.textField.getText();
	}
	/**
	 * This function would be invoked when the clean all files 
	 * button would be clicked
	 * TODO :
	 * Analysis folder contains files to be analyzed later on.
	 * Create a folder 'Analysis' (in class path).
	 * write code to clean all the files(if they are present) in the Analysis folder
	 * @return String to be displayed in the Result text area
	 */
	public static String cleanAllFiles(){
		getTextFieldValue();
		//Clean all files functionalities
		return "Files cleaned successfully";
	}
	/**
	 * This function would be invoked when the add files url 
	 * button would be clicked
	 * TODO :
	 * Create a file 'url.txt' (in class path) with many urls in seperate lines.
	 * Connect to all the urls in that txt file and save all contents of those webpages as .txt
	 * Use JSoup for this
	 * Save those files in the 'Analysis' folder  
	 * @return String to be displayed in the Result text area
	 */
	public static String addFilesUrl(){
		getTextFieldValue();
		return textBox;
	}
	/**
	 * This function would be invoked when the add files dir 
	 * button would be clicked
	 * TODO:
	 * Create a folder in class path 'Input'
	 * Take all the .doc,.pdf,.txt files present in that file,convert to .txt and save it in 'Analysis' folder 
	 * @return String to be displayed in the Result text area
	 */
	public static String addFilesDir(){
		getTextFieldValue();
		return textBox;
	}
	/**
	 * This function would be invoked when the tokenize 
	 * button would be clicked
	 * TODO:
	 * Take all the files present in the folder and split each words and store it as ArrayList
	 * There will be n ArrayLists for n documents.
	 * @return String to be displayed in the Result text area
	 */
	public static String tokenize(){
		getTextFieldValue();
		return textBox;
	}
	/**
	 * This function would be invoked when the porter stemmer 
	 * button would be clicked
	 * TODO:
	 * Take the n ArrayLists, iterate through it,convert each word into it's root form using porter stemmer algorith
	 * and save it back to the arraylist.
	 * @return String to be displayed in the Result text area
	 */
	public static String porterStemmer(){
		getTextFieldValue();
		return textBox;
	}
	/**
	 * This function would be invoked when the inverted index 
	 * button would be clicked
	 * TODO: 
	 * Inverted index is a data structure in which we store word as key followed by it's occurrence in
	 * every other document.eg: key:walk value:doc1-3,doc2-5,doc3-7 
	 * @return String to be displayed in the Result text area
	 */
	public static String invertedIndex(){
		getTextFieldValue();
		return textBox;
	}
	/**
	 * This function would be invoked when the sort
	 * button would be clicked
	 * TODO:
	 * Sort the data structure that was created in the earlier step
	 * So that it takes the lesser time to search 
	 * @return String to be displayed in the Result text area
	 */
	public static String sort(){
		getTextFieldValue();
		return textBox;
	}
	/**
	 * This function would be invoked when the search string
	 * button would be clicked
	 * @return String to be displayed in the Result text area
	 */
	public static String searchString(){
		getTextFieldValue();
		return "Enter a Search String above";
	}
	/**
	 * This function would be invoked when the remove special char
	 * button would be clicked
	 * TODO:
	 * write a regular expression to remove the special characters in the input string
	 * copy the updated input string to the search text box
	 * @return String to be displayed in the Result text area
	 */
	public static String removeSpecialChar(){
		getTextFieldValue();
		return textBox;
	}
	/**
	 * This function would be invoked when the spellCheck
	 * button would be clicked
	 * TODO:
	 * If there is a misspelled word,try to divide and make it meaning full.eg:'hellothere' should be made as 'hello there'
	 * Update the search string as the updated text
	 * @return String to be displayed in the Result text area
	 */
	public static String spellCheck(){
		getTextFieldValue();
		return textBox;
	}
	
	public static String tfidfTransform(){
		getTextFieldValue();
		return textBox;
	}
	public static String wordOccurence(){
		getTextFieldValue();
		return textBox;
	}
	public static String findBestMatched(){
		getTextFieldValue();
		return textBox;
	}
}
