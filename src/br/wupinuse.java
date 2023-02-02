package br;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map.Entry;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;
import model.wupin;

public class wupinuse {
	public static int onuse;
	static int id;
	static  Timeline timeline;
	static void usewupin(){
		
		EventHandler<ActionEvent> u=e1->{
			useonetime();
		};
		
		if(timeline==null) {
			Iterator<Entry<String, Node>> it = fx.fxs.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String, Node> next = it.next();
				Node n = next.getValue();
				ui.fxpane.getChildren().remove(n);
			}fx.fxs.clear();
			timeline= new Timeline(new KeyFrame(Duration.millis(game.onuse.usetime/2), u));
			timeline.setCycleCount(Timeline.INDEFINITE);
			timeline.setAutoReverse(true);
			timeline.jumpTo(Duration.millis(game.onuse.usetime/2));
			timeline.play();	
		}
		onuse=1;
	}
	static void unusewupin() {
		try {
			double t=timeline.getKeyFrames().get(0).getTime().toMillis();
			EventHandler<ActionEvent> unused=e1->{
				try {
				onuse=0;
				timeline.stop();
				timeline=null;
				}catch(Exception e) {}	
			};
			EventHandler<ActionEvent> del=e2->{
				EventHandler<ActionEvent> de=e3->{
				Iterator<Entry<String, Node>> it = fx.fxs.entrySet().iterator();
				while(it.hasNext()) {
					Entry<String, Node> next = it.next();
					Node n = next.getValue();
					ui.fxpane.getChildren().remove(n);
				}fx.fxs.clear();};
				Timeline unused1= new Timeline(new KeyFrame(Duration.millis(3), de));
				unused1.setCycleCount(1);
				unused1.play();			
			};
			Timeline unused1= new Timeline(new KeyFrame(Duration.millis(t), unused));
			unused1.setCycleCount(1);
			unused1.setOnFinished(del);
			unused1.play();			
		}catch(Exception e){}
	}
	static void useonetime(){
		try {
			Class<?> c=Class.forName("wupin."+game.onuse.pinyin+game.onuse.id);
			Object o=c.newInstance();
			Method m=c.getMethod("useonetime");
			m.invoke(o);	
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
}
