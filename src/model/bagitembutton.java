package model;

import javafx.scene.control.Button;

public class bagitembutton extends Button{
	public int bagid;
	public int onuse;
	public wupin w;

	public bagitembutton(String s,wupin w){
		setText(s);
		this.w=w;
	}
	public bagitembutton(){
		
	}
}
