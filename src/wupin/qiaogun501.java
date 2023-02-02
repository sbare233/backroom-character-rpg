package wupin;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import br.fx;
import br.ui;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import model.wupin;

public class qiaogun501 {
	public void use(wupin w,int i) {
		ui.stages.get("main").setTitle("宇宙CQC");
	}
	public void useonetime() {
		fourtest(ui.mosx,ui.mosy);
	}
	static void fourtest(double ex,double ey){
		int dir;
		if(fx.fxnamecount.containsKey("fourdir")) {
			dir=fx.fxnamecount.get("fourdir");
			fx.fxnamecount.put("fourdir",-dir);
		}
		else fx.fxnamecount.put("fourdir",1);
		double xc=(int)(ui.xi/2)*40+15;
		double yc=(int)(ui.yi/2)*40+20;
		double x =ex - ui.zhu.getTranslateX()-xc;
		double y =ey - ui.zhu.getTranslateY()-yc;
		@SuppressWarnings("unused")
		int xf,yf;
		if(x>0)xf=1;else xf=-1;
		if(y>0)yf=1;else yf=-1;
		double atan=Math.atan(y/x);
		double degree=Math.toDegrees(atan)+(xf-1)*90;
		fx.fxnamecount.remove("fourdel");
		fx.fxnamecount.remove("four");
		fx.fxnamecount.put("four",0);
		for(int i=0;fx.fxm.containsKey("four"+i);i++) {
			ui.fxpane.getChildren().remove(fx.fxm.get("four"+i));
			fx.fxm.remove("four"+i);
		}
		if(fx.timelines.containsKey("four")){
			fx.timelines.get("four").stop();
			fx.timelines.remove("four");
		}
		Timeline tm= new Timeline(new KeyFrame(Duration.millis(2),e1->{
			if(fx.fxnamecount.containsKey("four")) {
			int i=fx.fxnamecount.get("four");
			four(xc+(60)*Math.cos(Math.toRadians(degree+5*i*fx.fxnamecount.get("fourdir"))),
					yc+(60)*Math.sin(Math.toRadians(degree+5*i*fx.fxnamecount.get("fourdir"))),
					degree+5*i*fx.fxnamecount.get("fourdir"),
					(20)*Math.cos(Math.toRadians(40)),
					(20)*Math.sin(Math.toRadians(40)),
					(60-2*i)*Math.cos(Math.toRadians(40)),
					(60-2*i)*Math.sin(Math.toRadians(40)),
					(58-2*i)*Math.cos(Math.toRadians(50)),
					(58-2*i)*Math.sin(Math.toRadians(50)),
					(20)*Math.cos(Math.toRadians(50)),
					(20)*Math.sin(Math.toRadians(50)));
			qiaogun(xc+(60)*Math.cos(Math.toRadians(degree+5*i*fx.fxnamecount.get("fourdir"))),
					yc-10+(60)*Math.sin(Math.toRadians(degree+5*i*fx.fxnamecount.get("fourdir"))),
					degree+5*i*fx.fxnamecount.get("fourdir")+90);
		}}));
		tm.setCycleCount(60);
		tm.setAutoReverse(true);
		EventHandler<ActionEvent> dis=eee->{
			
			EventHandler<ActionEvent> d=e1->{
				int i;
				if(fx.fxnamecount.containsKey("fourdel")) {
					i=fx.fxnamecount.get("fourdel");
					fx.fxnamecount.remove("fourdel");
				}
				else i=-1;
            	i++;
            	fx.fxnamecount.put("fourdel",i);
				if(fx.fxm.containsKey("four"+i)) {
					ui.fxpane.getChildren().remove(fx.fxm.get("four"+i));
					fx.fxm.remove("four"+i); 
				}
			};
			EventHandler<ActionEvent> d1=e2->{
				if(fx.fxs.containsKey("qiaogun1")) {
            		ui.fxpane.getChildren().remove(fx.fxs.get("qiaogun1"));
            	}
				if(fx.fxs.containsKey("qiaogun2")) {
            		ui.fxpane.getChildren().remove(fx.fxs.get("qiaogun2"));
            	}
				for(int j=0;j<100;j++) {
					if(fx.fxm.containsKey("four"+j)) {
						ui.fxpane.getChildren().remove(fx.fxm.get("four"+j)); 
						ui.fxpane.getChildren().remove(fx.fxm.get("four"+j));
						fx.fxm.remove("four"+j); 
					}
				}
			};
			Timeline disp= new Timeline(new KeyFrame(Duration.millis(3), d));
			disp.setCycleCount(60);
			disp.setAutoReverse(true);
			disp.setOnFinished(d1);
			disp.play();	
		};
		tm.setOnFinished(dis);
		tm.play();
		fx.timelines.put("four",tm);
	}
	static void four(double x,double y,double degree,double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4) {
		FutureTask<String> s1 = new FutureTask<String>(new Callable<String>(){
            public String call() throws Exception {
            	Polygon four = new Polygon();
            	four.getPoints().addAll(new Double[]{x1,y1,x2,y2,x3,y3,x4,y4});
            	four.setFill(new Color(1,1,1,1));
            	four.setTranslateX(x-(x1+x2+x3+x4)/4);
            	four.setTranslateY(y-(y1+y2+y3+y4)/4);
            	four.setRotate(degree-45);
            	GaussianBlur gs=new GaussianBlur();
            	gs.setRadius(15);
            	four.setEffect(gs);
            	four.setCache(true);
            	ui.fxpane.getChildren().add(four);
            	int i=fx.fxnamecount.get("four");
            	fx.fxnamecount.remove("four");
            	fx.fxnamecount.put("four",i+1);
            	if(fx.fxm.containsKey("four"+i)) 
            		ui.fxpane.getChildren().remove(fx.fxm.get("four"+i));
            	fx.fxm.put("four"+i,four);
            	return "";
            }
		});
		Platform.runLater(s1);
	}
	static void qiaogun(double x,double y,double degree) {
		FutureTask<String> s1 = new FutureTask<String>(new Callable<String>(){
            public String call() throws Exception {
            	Rectangle r1=new Rectangle(2,7,10,5);
            	r1.setTranslateX(-10);
            	r1.setTranslateY(-10);
            	r1.setRotate(20);
            	Rectangle r2=new Rectangle(0,0,5,30);
            	Rectangle r3=new Rectangle(2,28,10,5);
            	r3.setRotate(200);
            	Shape sh1=Shape.union(r1, r3);
            	Group qiaogun=new Group(sh1);
            	qiaogun.setTranslateX(x);
            	qiaogun.setTranslateY(y);
            	qiaogun.setRotate(degree);
            	r2.setTranslateX(x);
            	r2.setTranslateY(y);
            	r2.setRotate(degree);
            	r2.setFill(Color.INDIANRED);
            	sh1.setFill(Color.DARKGRAY);
            	if(fx.fxs.containsKey("qiaogun1")) {
            		ui.fxpane.getChildren().remove(fx.fxs.get("qiaogun1"));
            		fx.fxs.remove("qiaogun1");
            	}
            	fx.fxs.put("qiaogun1",qiaogun);
            	if(fx.fxs.containsKey("qiaogun2")) {
            		ui.fxpane.getChildren().remove(fx.fxs.get("qiaogun2"));
            		fx.fxs.remove("qiaogun2");
            	}
            	fx.fxs.put("qiaogun2",r2);
            	ui.fxpane.getChildren().add(qiaogun);
            	ui.fxpane.getChildren().add(r2);
            	return "";
            }
		});
		Platform.runLater(s1);
	}
}
