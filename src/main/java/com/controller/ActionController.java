package com.controller;

public class ActionController {
	
	private static ActionController instance;

	public static ActionController getInstance() {
		if(instance == null){
			instance = new ActionController();
		}
		return instance;
	}
	
	public void selectLetter(String string){
		System.out.println(string);
	}

}
