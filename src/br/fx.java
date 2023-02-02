package br;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class fx{
	public static HashMap<String, Timeline> timelines= new HashMap<String, Timeline>();
	public static HashMap<String, Node> fxs = new HashMap<String, Node>();
	public static HashMap<String, Node> fxm = new HashMap<String, Node>();
	public static HashMap<String, Integer> fxnamecount=new HashMap<String,Integer>();
		static void fx1test(MouseEvent e){
			double x =e.getX() - ui.zhu.getTranslateX();
			double y =e.getY() - ui.zhu.getTranslateY();
			fxnamecount.remove("fx1");
			fxnamecount.put("fx1",0);
			for(int i=0;fx.fxs.containsKey("fx1"+i);i++) {
				ui.fxpane.getChildren().remove(fx.fxs.get("fx1"+i));
				fx.fxs.remove("fx1"+i);
			}
			if(timelines.containsKey("fx1")){
				timelines.get("fx1").stop();
				timelines.remove("fx1");
			}
			Timeline tm= new Timeline(new KeyFrame(Duration.millis(20),e1->{fx1(x,y);}));
			tm.setCycleCount(10);
			tm.setAutoReverse(true);
			tm.play();
			timelines.put("fx1",tm);
		}
		static void fx1(double x,double y) {
			FutureTask<String> s1 = new FutureTask<String>(new Callable<String>(){
	            public String call() throws Exception {
	            		Rectangle r=new Rectangle(0,0,10,10);
	            		r.setTranslateX(x);
	            		r.setTranslateY(y);
	                	r.setFill(new Color(1,1,1,1));
	                	r.setCache(true);
	                	GaussianBlur gs=new GaussianBlur();
	                	gs.setRadius(60);
	                	r.setEffect(gs);
	                	ui.fxpane.getChildren().add(r);
	                	int i=fxnamecount.get("fx1")+1;
	                	fxnamecount.remove("fx1");
	                	fxnamecount.put("fx1",i);
	                	fxs.put("fx1"+i,r);
					return "";
	            }
	        });
			Platform.runLater(s1);
		}
		static void triangle(double x1,double y1,double x2,double y2,double x3,double y3) {
			FutureTask<String> s1 = new FutureTask<String>(new Callable<String>(){
	            public String call() throws Exception {
	            	Polygon triangle = new Polygon();
	            	triangle.getPoints().addAll(new Double[]{x1,y1,x2,y2,x3,y3});
	            	ui.fxpane.getChildren().add(triangle);
	            	int i=fxnamecount.get("triangle")+1;
                	fxnamecount.remove("triangle");
                	fxnamecount.put("triangle",i);
                	fxm.put("triangle"+i,triangle);
	            	return "";
	            }
			});
			Platform.runLater(s1);
		}
		public static void spark(double x,double y,double degree,double sizex,double sizey,Color c) {
			FutureTask<String> s1 = new FutureTask<String>(new Callable<String>(){
	            public String call() throws Exception {
	            	Polygon spark = new Polygon();
	            	spark.getPoints().addAll(new Double[]{0.0,5.0,20.0,1.0,40.0,0.0,60.0,1.0,80.0,5.0,60.0,9.0,40.0,10.0,20.0,9.0});
	            	spark.setFill(c);
	            	spark.setTranslateX(x);
	            	spark.setTranslateY(y);
	            	spark.setRotate(degree);
	            	spark.setScaleX(sizex);
	            	spark.setScaleY(sizey);
					ui.fxpane.getChildren().add(spark);
	            	int i=fxnamecount.get("spark");
                	if(fxm.containsKey("spark"+i)) 
                		ui.fxpane.getChildren().remove(fx.fxm.get("spark"+i));
                	fxm.put("spark"+i,spark);
					return "";
	            }
			});
			Platform.runLater(s1);
		}
}
