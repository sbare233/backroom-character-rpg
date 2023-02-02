package br;

import java.util.HashMap;

import javafx.geometry.Insets;
import model.bagitembutton;
import model.wupin;

public class wupinlist {
	public static int curser;
	public static String[] wearposition= {"戒指","头","项链","左手","护甲","右手","左腿","背后","右腿"};
	//type:0.文本，堆叠999 1.材料，堆叠999；2.消耗品，堆叠999；3道具，不堆叠 4.武器，不堆叠；5.护甲，不堆叠；
	//eventkey触发事件 1 镐子
	//wearposition 0:不可穿戴 1.戒指 2.头 3.项链 4左手 5护甲 6右手 7左腿 8背后 9右腿
	// 10四肢 11双手同时使用 12双手皆可 13双腿同时 14背后护甲皆可 15头项链戒指皆可 16所有位置同时 17所有位置皆可
	public static HashMap<String,wupin> list=new HashMap<String,wupin>();
	wupinlist(){
		rw.readwupin("wupin.txt");
	}
	public static void f() {
		ui.itb.getChildren().clear();
		int i=0;
		for(wupin key:game.bag.keySet()){

			ui.its[i]=new bagitembutton(key.name,key);
			ui.itb.add(ui.its[i],1,i);
			ui.its[i].setOnMouseClicked(ui.clickbagitem);
				//ui.its[i].setBackground(ui.backlg);
			ui.its[i].setStyle("-fx-background-color:lightgrey");
			if(ui.its[i].getText()==clickbagitem.onusename)
					ui.its[i].setStyle("-fx-background-color:grey");
					//ui.its[i].setBackground(ui.backg);
			ui.its[i].setPadding(new Insets(0,0,0,0));
			ui.its[i].setFont(ui.bfont);
			ui.its[i].setVisible(true);
			i++;
		}
		ui.itb.setVisible(false);
		ui.itb.setVisible(true);
	}
	static void f(String s) {
		try {
		ui.itb.getChildren().clear();
		int i=0;
		for(wupin key:game.bag.keySet()){
			if(key.name.contains(s)||key.pinyin.contains(s)) {	
				ui.its[i]=new bagitembutton(key.name,key);
				ui.itb.add(ui.its[i],1,i);
				ui.its[i].setOnMouseClicked(ui.clickbagitem);
				ui.its[i].setStyle("-fx-background-color:lightgrey");
				if(ui.its[i].getText()==clickbagitem.onusename)
					ui.its[i].setStyle("-fx-background-color:grey");
				ui.its[i].setPadding(new Insets(0,0,0,0));
				ui.its[i].setFont(ui.bfont);
				ui.its[i].setVisible(true);
				i++;
			}
		}
		if(ui.itb.getChildren().isEmpty())
			f();
		ui.itb.setVisible(false);
		ui.itb.setVisible(true);
	}catch(Exception e) {}
	}
}
