package model;

import javafx.scene.control.Button;

public class keybutton extends Button{
	public String key;
	int onuse;
	String text;
	public keybutton(String s,String key){
		setText(s);
		this.key=key;
	}
	keybutton(){
	}
}
