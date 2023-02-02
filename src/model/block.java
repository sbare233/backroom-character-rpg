package model;

import javafx.scene.paint.Color;

public class block {
	public String[] zi;
	public Color c;
	public String[] getZi() {
		return zi;
	}
	public void setZi(String[] zi) {
		this.zi = zi;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	public block(String[] zi,Color c){
		this.zi=zi;
		this.c=c;
	}
}
