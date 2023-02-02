package wupin;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import br.fx;
import br.game;
import br.ui;
import br.wupinuse;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class duanjian508 {
	public void useonetime() {
		vectorshot(ui.mosx,ui.mosy);
	}

	public static void vectorbullet(double x,double y,double degree) {
		FutureTask<String> s1 = new FutureTask<String>(new Callable<String>(){
	        public String call() throws Exception {
	        	Circle bu = new Circle(0,0,2);
	        	bu.setFill(Color.GOLD);
	        	bu.setScaleX(6);
	        	bu.setRotate(degree);
	        	bu.setTranslateX(x);
	        	bu.setTranslateY(y);
	        	GaussianBlur gs=new GaussianBlur();
	        	gs.setRadius(1);
	        	bu.setEffect(gs);
	        	bu.setCache(true);
	        	ui.fxpane.getChildren().add(bu);
	        	int i=fx.fxnamecount.containsKey("vectorbullet")?fx.fxnamecount.get("vectorbullet"):0;
	        	if(fx.fxm.containsKey("vectorbullet"+i)) 
	        		ui.fxpane.getChildren().remove(fx.fxm.get("vectorbullet"+i));
	        	fx.fxm.put("vectorbullet"+i,bu);
	        	return "";
	        }
		});
		Platform.runLater(s1);
	}

	public static void vectorgun(double x,double y,double degree,int xf,int yf) {
		FutureTask<String> s1 = new FutureTask<String>(new Callable<String>(){
	        public String call() throws Exception {
	        	Polygon grey = new Polygon();
	        	grey.getPoints().addAll(new Double[]{110.0,160.0,500.0,160.0,520.0,200.0,600.0,200.0,
	        			580.0,160.0,630.0,160.0,680.0,290.0,630.0,290.0,610.0,245.0,510.0,245.0,480.0,190.0,
	        			225.0,190.0,335.0,430.0,270.0,430.0,180.0,230.0,110.0,230.0});
	        	grey.setFill(Color.GREY);
	        	Polygon yell = new Polygon();
	        	yell.getPoints().addAll(new Double[]{225.0,190.0,440.0,190.0,480.0,255.0,440.0,255.0,
	        			415.0,220.0,360.0,220.0,400.0,290.0,277.0,290.0});
	        	yell.setFill(Color.BLANCHEDALMOND);
	        	yell.setTranslateX(36);
	        	yell.setTranslateY(46);
	        	grey.setScaleX(0.18);
	        	grey.setScaleY(0.18);
	        	yell.setScaleX(0.18);
	        	yell.setScaleY(0.18);
	        	Group g=new Group();
	        	g.getChildren().addAll(grey,yell);
	        	grey.setLayoutX(-395-8*Math.sin(Math.toRadians(degree))*xf);
	        	yell.setLayoutX(-395-8*Math.sin(Math.toRadians(degree))*xf);
	        	grey.setLayoutY(-288);
	        	yell.setLayoutY(-288);
	        	g.setTranslateX(x);
	        	g.setTranslateY(y);
	        	g.setRotate(degree);
	        	g.setScaleX(-0.5);
	        	g.setScaleY(0.5*xf);
	        	if(fx.fxs.containsKey("vectorgun")) {
	        		ui.fxpane.getChildren().remove(fx.fxs.get("vectorgun"));
	        		fx.fxs.remove("vectorgun");
	        	}
	        	fx.fxs.put("vectorgun",g);
	        	ui.fxpane.getChildren().add(g);
	        	return "";
	        }
		});
		Platform.runLater(s1);
	}

	public static void vectorspark(double x,double y,double degree) {
		vectorspark(0.5,x,y,degree,Color.LIGHTYELLOW,1,1,1,1,0,0);
	}

	public static void vectorspark(double time,double x,double y,double degree,Color c,double sizex,double sizey,double fx,double fy,double px,double py) {
				/*Iterator<Entry<String, Node>> it = fxm.entrySet().iterator();
				for (int k = 0; it.hasNext(); k++) {
					Entry<String, Node> next = it.next();
					Node w = next.getValue();
					String i = next.getKey();
					new p(i+"\n");
				}*/
				for(int k=0;k<10;k++) {
					if(br.fx.fxnamecount.containsKey("spark")) {
						int n=br.fx.fxnamecount.get("spark");
						br.fx.fxnamecount.put("spark",n+1);
					}
					else
						br.fx.fxnamecount.put("spark",0);
					int n=br.fx.fxnamecount.get("spark");
	
					br.fx.spark(x,y,degree,0.1+sizex*Math.random()/10,0.1+sizey*Math.random()/10,c);
					Polygon sp=(Polygon) br.fx.fxm.get("spark"+n);
					if(!br.fx.fxm.containsKey("spark"+n))
						sp=(Polygon) br.fx.fxm.get("spark"+(n-1));
					double rd=180*Math.random()-180*Math.random();
					Timeline t=new Timeline(
							new KeyFrame(Duration.seconds(0),
									new KeyValue(sp.translateXProperty(),sp.getTranslateX()),
									new KeyValue(sp.translateYProperty(),sp.getTranslateY()),
									new KeyValue(sp.rotateProperty(),sp.getRotate()),
									new KeyValue(sp.scaleXProperty(),sp.getScaleX()),
									new KeyValue(sp.scaleYProperty(),sp.getScaleY())),
							new KeyFrame(Duration.seconds(time),
									new KeyValue(sp.translateXProperty(),sp.getTranslateX()-fx*100*Math.cos(Math.toRadians(rd)+px)),
									new KeyValue(sp.translateYProperty(),sp.getTranslateY()-fy*100*Math.sin(Math.toRadians(rd)+py)),
									new KeyValue(sp.rotateProperty(),sp.getRotate()+rd),
									new KeyValue(sp.scaleXProperty(),0),
									new KeyValue(sp.scaleYProperty(),0))
							);
	//				Timeline t=new Timeline(
	//						new KeyFrame(Duration.millis(time),e->{
	//							int n1=0;
	//							if(fxnamecount.containsKey("spark")) 
	//								n1=fxnamecount.get("spark");
	//							fxm.get("spark"+n1).setTranslateX(fxm.get("spark"+n1).getTranslateX()-fx*100*Math.cos(Math.toRadians(rd)+px));
	//							fxm.get("spark"+n1).setTranslateY(fxm.get("spark"+n1).getTranslateY()-fy*100*Math.sin(Math.toRadians(rd)+py));
	//							fxm.get("spark"+n1).setRotate(fxm.get("spark"+n1).getRotate()+rd);
	//						}));
					t.setCycleCount(1);
					t.play();
					t.setOnFinished(e->{
						if(wupinuse.onuse==0) {
						Timeline t1=new Timeline(new KeyFrame(Duration.seconds(0.5)));
						t1.play();
						t1.setOnFinished(e1->{
							if(br.fx.fxnamecount.containsKey("spark")) {
								int n1=br.fx.fxnamecount.get("spark");
								for(int i=0;i<n1+10;i++) {
									ui.fxpane.getChildren().remove(br.fx.fxm.get("spark"+i));
									br.fx.fxm.remove("spark"+i);
								}
								br.fx.fxnamecount.put("spark",0);
							}
						});
						}
					});
				}
			}

	static void vectorshot(double ex,double ey){
		double xc=(int)(ui.xi/2)*40+15;
		double yc=(int)(ui.yi/2)*40+20;
		double x =ex - ui.zhu.getTranslateX()-xc;
		double y =ey - ui.zhu.getTranslateY()-yc;
		int xf,yf;
		if(x>0)xf=1;else xf=-1;
		if(y>0)yf=1;else yf=-1;
		double atan=Math.atan(y/x);
		double dg=Math.toDegrees(atan)+(xf-1)*90;
		double degree=dg==-90?-270:(dg==-270?-90:dg);
		double sanbu1=Math.random(),sanbu2=Math.random();
		if(fx.fxnamecount.containsKey("vectorbullet")) {
			int k=fx.fxnamecount.get("vectorbullet");
			fx.fxnamecount.put("vectorbullet",k+1);
		}
		else
			fx.fxnamecount.put("vectorbullet",0);
		int i=fx.fxnamecount.get("vectorbullet");
		//vectorbullet(xc+(35)*Math.cos(Math.toRadians(degree+(sanbu1-sanbu2)*5)),
		//		yc+(35)*Math.sin(Math.toRadians(degree+(sanbu1-sanbu2)*5)),
		//		degree+(sanbu1-sanbu2)*5);
		vectorbullet(xc,yc,degree+(sanbu1-sanbu2)*5);
		vectorgun(xc+(30)*Math.cos(Math.toRadians(degree)),
				yc+(30)*Math.sin(Math.toRadians(degree)),
				degree,xf,yf);
		//int len=(int)((Math.random()+1)*4);
		Timeline tm = new Timeline(new KeyFrame(Duration.millis(5), e1 -> {
			try{
			if (fx.fxnamecount.containsKey("vectorbullet" + i)) {
				int iii = fx.fxnamecount.get("vectorbullet" + i);
				fx.fxnamecount.put("vectorbullet" + i, iii + 1);
			} else
				fx.fxnamecount.put("vectorbullet" + i, 0);
			//int t = fxnamecount.get("vectorbullet" + i);			
			if(fx.fxs.containsKey("vectorgun"))
				fx.fxs.get("vectorgun").setRotate(degree+(sanbu1-sanbu2)*3);
			fx.fxm.get("vectorbullet" + i).setTranslateX(
					fx.fxm.get("vectorbullet" + i).getTranslateX() + 5*6 * Math.cos(Math.toRadians(degree+(sanbu1-sanbu2)*5)));
			fx.fxm.get("vectorbullet" + i).setTranslateY(
					fx.fxm.get("vectorbullet" + i).getTranslateY() + 5*6 * Math.sin(Math.toRadians(degree+(sanbu1-sanbu2)*5)));
			int yii=(int)(fx.fxm.get("vectorbullet" + i).getTranslateY()/40);
			int xii=(int)(fx.fxm.get("vectorbullet" + i).getTranslateX()/40);
			if(yii>-1&&xii>-1&&game.map[yii][xii]!=0) {
				Node n=fx.fxm.get("vectorbullet"+i);
				//n.setTranslateY((int)(ui.yi/2)*40+20);
				//n.setTranslateX((int)(ui.xi/2)*40+15);
				if(fx.fxm.size()>1)
					fx.fxm.remove("vectorbullet"+i);
				ui.fxpane.getChildren().remove(n);
				//fxnamecount.remove("vectorbullet"+i);
				fx.timelines.remove("vector"+fx.fxnamecount.get("vectorbullet"));
				//if((yii>ui.yi-2||yii<ui.yi+2)&&(xii>ui.xi-2||xii<ui.xi+2)) {
				//}
				vectorspark(n.getTranslateX()-40,
						n.getTranslateY(),degree);
			}
			else if(yii>-1&&xii>-1&&game.mobmap[yii+100][xii+100]!=0) {
				game.mobs.get(game.mobmap[yii+100][xii+100]).get(game.mobidmap[yii+100][xii+100]).life--;
				//new p(game.mobs.get(game.mobmap[yii+100][xii+100]).get(game.mobidmap[yii+100][xii+100]).life+"\n");
				Node n=fx.fxm.get("vectorbullet"+i);
				//n.setTranslateY((int)(ui.yi/2)*40+20);
				//n.setTranslateX((int)(ui.xi/2)*40+15);
				if(fx.fxm.size()>1)
					fx.fxm.remove("vectorbullet"+i);
				ui.fxpane.getChildren().remove(n);
				//fxnamecount.remove("vectorbullet"+i);
				fx.timelines.remove("vector"+fx.fxnamecount.get("vectorbullet"));
				//if((yii>ui.yi-2||yii<ui.yi+2)&&(xii>ui.xi-2||xii<ui.xi+2)) {
				//}
				vectorspark(1,n.getTranslateX()-40,
						n.getTranslateY(),degree,Color.color(0.8,0.1,0.1),3,9,0,0,0,20);
			}
		}catch(Exception e) {}
		}));
		tm.setCycleCount(500);
		tm.setAutoReverse(true);
		tm.setOnFinished(e->{fx.fxm.remove("vectorbullet"+i);});
		if(game.stopf==0)
			tm.play();
		fx.timelines.put("vector"+fx.fxnamecount.get("vectorbullet"),tm);
	}
	
}
