package model;

import javafx.scene.control.Button;

public class questbutton extends Button{
	public int questid;
	public String text;
	public questbutton(String s,int questid){
		setText(s);
		this.questid=questid;
	}
	public questbutton(){
		this.questid=-1;
	}
	
}
