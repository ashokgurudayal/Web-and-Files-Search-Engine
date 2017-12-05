package com.filesearchengine.controller;

import com.filesearchengine.model.ButtonClickFunctionalities;

public class BaseController {
	public static String buttonClearAllFIlesClicked(){
		return ButtonClickFunctionalities.cleanAllFiles();
	}
	public static String buttonAddFilesUrlClicked(){
		return ButtonClickFunctionalities.addFilesUrl();
	}
	public static String buttonAddFilesDirClicked(){
		return ButtonClickFunctionalities.addFilesDir();
	}
	public static String buttonTokenizeClicked(){
		return ButtonClickFunctionalities.tokenize();
	}
	public static String buttonPorterStemmerClicked(){
		return ButtonClickFunctionalities.porterStemmer();
	}
	public static String buttonInvertedIndexClicked(){
		return ButtonClickFunctionalities.invertedIndex();
	}
	public static String buttonSortClicked(){
		return ButtonClickFunctionalities.sort();
	}
	public static String buttonSearchStringClicked(){
		return ButtonClickFunctionalities.searchString();
	}
	public static String buttonRemoveSpecialCharClicked(){
		return ButtonClickFunctionalities.removeSpecialChar();
	}
	public static String buttontokenizeSearchStringClicked(){
		return ButtonClickFunctionalities.tokenizeSearchString();
	}
	public static String buttonTfIdfTransformClicked(){
		return ButtonClickFunctionalities.tfidfTransform();
	}
	public static String buttonWordOccurenceClicked(){
		return ButtonClickFunctionalities.wordOccurence();
	}
	public static String buttonFindBestMatchedClicked(){
		return ButtonClickFunctionalities.findBestMatched();
	}
	public static String buttonPorterStemmerSearchStringClicked() {
		// TODO Auto-generated method stub
		return ButtonClickFunctionalities.PorterStemmerSearchString();
	}
	public static String buttonScoreGenerateClicked() {
		// TODO Auto-generated method stub
		return ButtonClickFunctionalities.scoreGenerate();
	}
	public static String buttonEditDistanceClicked() {
		// TODO Auto-generated method stub
		return ButtonClickFunctionalities.editDistanceClicked();
	}
	


}
