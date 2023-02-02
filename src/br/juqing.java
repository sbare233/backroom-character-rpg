package br;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.wupin;

public class juqing {

	static HashMap<String, Integer> juqing = new HashMap<String, Integer>();

	public static void pjuqing() {
//		String s = rw.reads("./juqing/kaishi.txt");
//		Scanner sc = new Scanner(s);
//		while (sc.hasNext()) {
//			juqing.put(sc.next(), sc.nextInt());
//		}
//		sc.close();
//		Iterator<Entry<String, Integer>> it = juqing.entrySet().iterator();
//		while (it.hasNext()) {
//			Entry<String, Integer> next = it.next();
//			Integer i = next.getValue();
//			String st = next.getKey();
//			String juben = rw.reads("./juqing/" + st + ".txt");
//			playjuqing(juben, i);
//		}
	}
	static void playjuqing(String juben, int row) {
		Scanner sc = new Scanner(juben);
		if (sc.hasNext()) {
			int querenf = 0, waitt = 0;
			int xuanze=0;
			String key = sc.nextLine();
			for (int i = 0; i < row; i++)
				sc.nextLine();
			String n = sc.nextLine();
			if (!n.equals("")) {
				//new p(row + ".");
				//new p(n + "\n");
				if (n.equals("暂停游戏")) {
					game.stopf = 0;
					game.stop();
				} else if (n.equals("结束暂停")) {
					game.stopf = 1;
					game.stop();	
				} else if (n.equals("展示文字")) {
					TextArea dh0=new TextArea();
					dh0.setWrapText(true);
					dh0.setEditable(false);
					int r=0;
					while (true) {
						String s = sc.nextLine();
						if (s.contains("结束展示"))
							break;
						else {
							if(r>0)dh0.appendText("\n");
							dh0.appendText(s);
						}
							
						row++;
						r++;
						juqing.put(key, row);
						
					}
					dh0.setPrefRowCount(r);
					dh0.setPrefHeight(r*28);
					ui.dh.add(dh0,0,ui.dh.getChildren().size());
					
					
					Platform.runLater(()->{
//						if(ui.dh.getChildren().size()>20) {
//							for(int i=0;i<ui.dh.getChildren().size()-20;i++) {
//								ui.dh.add(new Label(""),0,i);
//							}
//						}
//						ScrollPane scrollPane = (ScrollPane) dh0.lookup(".scroll-pane");  
//						scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
						ui.dhs.setVvalue(100);});
				} else if (n.contains("展示文字")) {
					int l = Integer.parseInt(n.substring(4));
					TextArea dh0=new TextArea();
					dh0.setWrapText(true);
					dh0.setEditable(false);
					for (int k = 0; k < l; k++) {
						if(k==0)dh0.appendText(sc.nextLine());
						else dh0.appendText("\n" + sc.nextLine());
						row++;
						juqing.put(key, row);
					}
					//ui.dh.autosize();
					dh0.setPrefRowCount(l);
					dh0.setPrefHeight(l*28);
					
					ui.dh.add(dh0,0,ui.dh.getChildren().size());
					
					Platform.runLater(()->{
//						if(ui.dh.getChildren().size()>20) {
//							for(int i=0;i<ui.dh.getChildren().size()-20;i++) {
//								ui.dh.add(new Label(""),0,i);
//							}
//						}
//						ScrollPane scrollPane = (ScrollPane) dh0.lookup(".scroll-pane");  
//						scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
						ui.dhs.setVvalue(100);});
				} else if (n.equals("描述任务")) {
					while (true) {
						String s = sc.nextLine();
						if (s.contains("结束描述"))
							break;
						else
							// TODO
							row++;
						juqing.put(key, row);
					}
				} else if (n.contains("描述任务")) {
					int l = Integer.parseInt(n.substring(4));
					for (int k = 0; k < l; k++) {
						// TODO
						row++;
						juqing.put(key, row);
					}
				} else if (n.contains("确认后"))
					querenf = 1;
				 else if(n.contains("创建选项")) {
					xuanze=Integer.parseInt(n.substring(4));
					//TODO
				 }
				else if (n.contains("秒后")) {
					waitt = Integer.parseInt(n.substring(0, n.indexOf("秒")));
				} else if (n.contains("给")) {
					Scanner sc1 = new Scanner(n);
					sc1.next();
					String mubiao = sc1.next();
					String wupinkey = sc1.next();
					wupin w=wupinlist.list.get(wupinkey);
					int num = sc1.nextInt();
					int k = 0;
					if (mubiao.equals("玩家")){
						if(w.type<3)
							game.bag.put(w, game.bag.get(w)+num);	
						else
							game.bag.put(w, 1);
					}
				} 
				else if(n.contains("属性")){
					Scanner sc1=new Scanner(n);
					sc1.next();
					String s=sc1.next();
					String p=sc1.next();
					int num=sc1.nextInt();
					int plus=0;
					if(p.equals("增加"))plus=1;
					else if(p.equals("减少"))plus=-1;
					//int hp,sn,mp,st,sp,dx,sa,ey,lu,lo;
					//"气血","毅力","智慧","力量","速度","灵巧","口才","见识","运气","外貌"
					if(s.equals("气血"))game.man.hp+=plus*num;
					else if(s.equals("毅力"))game.man.sn+=plus*num;
					else if(s.equals("智慧"))game.man.mp+=plus*num;
					else if(s.equals("力量"))game.man.st+=plus*num;
					else if(s.equals("速度"))game.man.sp+=plus*num;
					else if(s.equals("灵巧"))game.man.dx+=plus*num;
					else if(s.equals("口才"))game.man.sa+=plus*num;
					else if(s.equals("见识"))game.man.ey+=plus*num;
					else if(s.equals("运气"))game.man.lu+=plus*num;
					else if(s.equals("外貌"))game.man.lo+=plus*num;
					sc1.close();
					game.refman();
				}else if(n.contains("关闭窗口")) {
						ui.stages.get(n.substring(4)).close();
					}
				}
			if (sc.hasNext()) {
				sc.close();
				row++;
				juqing.put(key, row);
				if (querenf == 1) {
					Button queren = new Button("确认");
					ui.infosubmit.getChildren().clear();
					queren.setFont(ui.bfont);
					queren.setPadding(new Insets(0, 0, 0, 0));
					queren.setBackground(ui.backbl);
					queren.setTextFill(Color.WHITE);
					queren.setOnMouseClicked(e -> {
						playjuqing(juben, juqing.get(key));
						ui.infosubmit.getChildren().remove(queren);
					});
					ui.infosubmit.getChildren().addAll(queren, ui.order, ui.buff, ui.shezhi);
				}
				else if (xuanze >0) {
					Button queren = new Button("确认");
					ui.infosubmit.getChildren().clear();
					queren.setFont(ui.bfont);
					queren.setPadding(new Insets(0, 0, 0, 0));
					queren.setBackground(ui.backbl);
					queren.setTextFill(Color.WHITE);
					queren.setOnMouseClicked(e -> {
						playjuqing(juben, juqing.get(key));
						ui.infosubmit.getChildren().remove(queren);
					});
					ui.infosubmit.getChildren().addAll(queren, ui.order, ui.buff, ui.shezhi);
				}
				else if (waitt != 0) {
					Timeline tm = new Timeline(new KeyFrame(Duration.millis(1000 * waitt), e1 -> {
						playjuqing(juben, juqing.get(key));
					}));
					tm.setCycleCount(1);
					tm.play();
				} else
					playjuqing(juben, juqing.get(key));
			}
		}	
	}
}
