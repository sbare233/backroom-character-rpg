package wupin;
import java.util.HashMap;
	import java.util.Random;
	import br.game;
	import br.ui;
import javafx.animation.KeyFrame;
	import javafx.animation.KeyValue;
	import javafx.animation.Timeline;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.scene.Scene;
	import javafx.scene.control.Label;
	import javafx.scene.effect.Bloom;
	import javafx.scene.effect.GaussianBlur;
	import javafx.scene.effect.MotionBlur;
	import javafx.scene.input.KeyCode;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.Pane;
	import javafx.scene.layout.StackPane;
	import javafx.scene.paint.Color;
	import javafx.scene.paint.CycleMethod;
	import javafx.scene.paint.LinearGradient;
	import javafx.scene.paint.RadialGradient;
	import javafx.scene.paint.Stop;
	import javafx.scene.shape.Circle;
	import javafx.scene.shape.Ellipse;
	import javafx.scene.shape.Polygon;
	import javafx.scene.shape.Rectangle;
	import javafx.scene.web.WebView;
	import javafx.stage.Stage;
	import javafx.util.Duration;
import model.wupin;
public class shouji500 {
	
	public void use(wupin w,int i){
		phone phone = new phone();
		phone.show();
		ui.stages.get("main").setTitle("密客是你");
	}
	
	
	public class phone extends Stage{
		Label l;
		StackPane m,all;
		GridPane b,wk,bwl;
		Pane yy,g;
		Scene scene;
		int appf=0,wikif=0;
		int[] guidaoonuse=new int[4],key=new int[4];
		WebView w;
		double ms;
		double notetime;
		note[] ontap=new note[4];
		Rectangle[] yys=new Rectangle[4];

		MotionBlur mb;
		public phone(){
			wk=new GridPane();
			w=new WebView();
			wk.add(w, 0, 0);
			w.setPrefSize(500,800);
			
			bwl=new GridPane();
			
			yy=new Pane();
			yy.setPrefSize(500,800);
			yy.setBackground(ui.backbl);
			yys[0]=new Rectangle(2, 0, 120, 800);
			yys[1]=new Rectangle(127, 0, 120, 800);
			yys[2]=new Rectangle(252, 0, 120, 800);
			yys[3]=new Rectangle(377, 0, 120, 800);
			yys[0].setFill(new Color(0.6,0.6,0.6,0.5));
			yys[1].setFill(new Color(0.6,0.6,0.6,0.5));
			yys[2].setFill(new Color(0.6,0.6,0.6,0.5));
			yys[3].setFill(new Color(0.6,0.6,0.6,0.5));
			yy.getChildren().add(yys[0]);
			yy.getChildren().add(yys[1]);
			yy.getChildren().add(yys[2]);
			yy.getChildren().add(yys[3]);
			Bloom bl=new Bloom();
			bl.setThreshold(0.7);
			yy.setEffect(bl);
			mb=new MotionBlur();
			mb.setRadius(25);
			yy.setOnKeyPressed(e->{
				if(e.getCode()==KeyCode.D) {
					key[0]=1;
				}
				if(e.getCode()==KeyCode.F) {
					key[1]=1;
				}
				if(e.getCode()==KeyCode.J) {
					key[2]=1;
				}
				if(e.getCode()==KeyCode.K) {
					key[3]=1;
				}
			});
			yy.setOnKeyReleased(e->{
				if(e.getCode()==KeyCode.D) {
					key[0]=0;
				}
				if(e.getCode()==KeyCode.F) {
					key[1]=0;
				}
				if(e.getCode()==KeyCode.J) {
					key[2]=0;
				}
				if(e.getCode()==KeyCode.K) {
					key[3]=0;
				}
			});
			
			Stop[] stops = new Stop[] {new Stop(0, Color.BLACK), new Stop(1, Color.RED)};
	        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops);
	        Rectangle r1 = new Rectangle(0, 0, 500, 800);
	        r1.setFill(lg1);
			m=new StackPane();
			m.getChildren().add(r1);
			m.setPrefSize(500, 800);
			
			Rectangle r2 = new Rectangle(0, 0, 60, 60);
			r2.setFill(Color.AQUAMARINE);
			r2.setTranslateX(-150);
			r2.setTranslateY(-300);
			r2.setOnMouseClicked(e->{
				wiki();
			});
			Label wiki=new Label("wiki");
			wiki.setTranslateX(-150);
			wiki.setTranslateY(-250);
			wiki.setFont(ui.afont);
			wiki.setOnMouseClicked(e->{
				wiki();
			});
			m.getChildren().add(r2);
			m.getChildren().add(wiki);
		
			Rectangle r3 = new Rectangle(0, 0, 60, 60);
			r3.setFill(Color.GOLD);
			r3.setTranslateX(-50);
			r3.setTranslateY(-300);
			r3.setOnMouseClicked(e->{
				beiwanglu();
			});
			Label bei=new Label("备忘录");
			bei.setTranslateX(-50);
			bei.setTranslateY(-250);
			bei.setFont(ui.afont);
			bei.setOnMouseClicked(e->{
				beiwanglu();
			});
			m.getChildren().add(r3);
			m.getChildren().add(bei);
			
			Rectangle r4 = new Rectangle(0, 0, 60, 60);
			r4.setFill(Color.PURPLE);
			r4.setTranslateX(50);
			r4.setTranslateY(-300);
			r4.setOnMouseClicked(e->{
				yy();
				yy.requestFocus();
			});
			Label yyl=new Label("音游");
			yyl.setTranslateX(50);
			yyl.setTranslateY(-250);
			yyl.setFont(ui.afont);
			yyl.setOnMouseClicked(e->{
				yy();
				yy.requestFocus();
			});
			m.getChildren().add(r4);
			m.getChildren().add(yyl);
			
			g=new GridPane();
			g.getChildren().add(m);
			b=new GridPane();
			for(int j=0;j<19;j++) {
				@SuppressWarnings("unused")
				Rectangle r;
				if(j!=4&&j!=10&&j!=16)
					b.add(r=new Rectangle(0,0,21,70),j,0);
			}
			Polygon back=new Polygon(0.0, 20.0,
				    40.0,0.0,
				    40.0,40.0);
			back.setFill(Color.WHITE);
			b.add(back,4,0);
			back.setOnMouseClicked(e->{
				if(appf==1) {
					if(w.getEngine().getHistory().getCurrentIndex()>0)
						w.getEngine().getHistory().go(-1);
					else {
						g.getChildren().remove(wk);
						g.getChildren().remove(bwl);
						g.getChildren().remove(yy);
						g.getChildren().add(m);
					}
				}
			});
			Circle home=new Circle(23.0);
			home.setFill(Color.WHITE);
			b.add(home,10,0);
			home.setOnMouseClicked(e->{
				g.getChildren().remove(wk);
				g.getChildren().remove(bwl);
				g.getChildren().remove(yy);
				g.getChildren().add(m);
				appf=0;
			});
			Rectangle view=new Rectangle(40.0, 40.0);
			view.setFill(Color.WHITE);
			b.add(view,16,0);
			b.setTranslateY(730);
			b.setBackground(ui.backbl);
			
			all=new StackPane();
			all.getChildren().add(g);
			all.getChildren().add(b);
			scene = new Scene(all);
			setScene(scene);
			
		}
		void yyfx(int guidao) {
			if(key[guidao]==1) {
			EventHandler<ActionEvent> blink=e->{
				try {
				yys[guidao].setFill(new Color(0.6,0.6,0.6,0.5+0.1*ms%2));
				}catch(Exception ee) {}
			};
			EventHandler<ActionEvent> normal=eee->{
				yys[guidao].setFill(new Color(0.6,0.6,0.6,0.5));
			};
			Timeline fx= new Timeline(new KeyFrame(Duration.millis(16), blink));
			fx.setCycleCount(10);
			fx.setAutoReverse(true);
			fx.play();
			fx.setOnFinished(normal);
			if(ontap[guidao]!=null) {
				
				if(ontap[guidao].type==2) {
					/*Ellipse re=new Ellipse(60+guidao*125, 800, 60, 200);
					re.setFill(new Color(0.9,0.9,0.9,0.05));
					GaussianBlur gb=new GaussianBlur();
					gb.setRadius(62);
					re.setEffect(gb);
					yy.getChildren().add(re);
					EventHandler<ActionEvent> last=el->{
						try {
							re.setRadiusX(60+ms%50);
							}catch(Exception ee) {}
					};
					EventHandler<ActionEvent> del=el1->{
						yy.getChildren().remove(re);
						
					};
					Timeline fx1= new Timeline(new KeyFrame(Duration.millis(16),last));
					fx1.setCycleCount(10);
					fx1.setAutoReverse(true);
					fx1.play();
					fx1.setOnFinished(del);*/
					//太卡 弃用
					if(ontap[guidao].getTranslateY()>700)
						ontap[guidao]=null;
				}
				else {
					yy.getChildren().remove(ontap[guidao]);
				Ellipse re=new Ellipse(60+guidao*125, 800, 60, 200);
				re.setFill(new Color(0.9,0.9,0.9,0.3));
				GaussianBlur gb=new GaussianBlur();
				gb.setRadius(62);
				re.setEffect(gb);
				yy.getChildren().add(re);
				ontap[guidao]=null;
				EventHandler<ActionEvent> del=e2->{
					yy.getChildren().remove(re);
				};
				Timeline fx1= new Timeline(new KeyFrame(Duration.seconds(0), new KeyValue(re.translateYProperty(), 0)),
						new KeyFrame(Duration.seconds(1), new KeyValue(re.translateYProperty(),400)));
				fx1.setCycleCount(1);
				//fx1.setAutoReverse(true);
				fx1.play();
				fx1.setOnFinished(del);
				}
			}
			}
		}
		private void yy() {
			
			EventHandler<ActionEvent> listen = e0 -> {yyfx(0);yyfx(1);yyfx(2);yyfx(3);};
			Timeline fx= new Timeline(new KeyFrame(Duration.millis(5), listen));
			fx.setCycleCount(Timeline.INDEFINITE);
			fx.setAutoReverse(true);
			fx.play();
			
			g.getChildren().remove(m);
			g.getChildren().add(yy);
			appf=3;

			
			pu pu=new pu();
			pu.time=100000;
			int last=0;
			for(int i=0;i<1000;i++) {
				Random r=new Random();
				int t=r.nextInt(1000);
				int p=r.nextInt(4);
				int s=r.nextInt(100)+10;
				note no=new note(p,last);
				//no.setCache(true);
				
				no.setEffect(mb);
				
				pu.notes.put(i,no);
				last+=s;
				if(t%6==0) {
					pu.notes.get(i).type=2;
					pu.notes.get(i).len=50+t;
				}
			}
			EventHandler<ActionEvent> pumian = e -> {
				
					guidaoonuse[0]=0;guidaoonuse[1]=0;guidaoonuse[2]=0;guidaoonuse[3]=0;
					for(int notenum=4;notenum<yy.getChildren().size();notenum++) {
						if(yy.getChildren().get(notenum).getClass().getName().equals("br.phone$note")) {
							note n=(note)yy.getChildren().get(notenum);
							int d=(int) n.getTranslateY();
							/*if(n.type==2)
								n.setTranslateY(6*(ms-n.time-n.len));
							else 
								n.setTranslateY(6*(ms-n.time));*/
							if(n.ondrop==0) {
								Timeline tml= new Timeline(new KeyFrame(Duration.seconds(0), new KeyValue(n.translateYProperty(),-n.getHeight())),
										new KeyFrame(Duration.seconds((1000+n.getHeight())/1500), new KeyValue(n.translateYProperty(),1000)));
								tml.setCycleCount(1);
								tml.play();
								n.ondrop=1;
							}
							if(d<20)
								guidaoonuse[n.guidao]=1;
							if(d>900) 
								yy.getChildren().remove(notenum);
							if(d+n.getHeight()>700&&ontap[n.guidao]==null) {
								ontap[n.guidao]=n;
							}
						}
							
					}
					if(pu.notes.containsKey(pu.nownote)) {
						note n=pu.notes.get(pu.nownote);
						notetime=n.time;
						if(ms>=notetime) {
							
							if(n.type==2) {
								n.setFill(Color.BURLYWOOD);
								n.setHeight(n.len);
								n.setTranslateY(-n.len);
							}
							if(guidaoonuse[n.guidao]==0) {
								yy.getChildren().add(n);
							}
							//if(guidaoonuse[n.guidao]==1)
							//	new p(1);
							pu.nownote++;
						}
					}
				ms+=10;
				
			};
			Timeline tml= new Timeline(new KeyFrame(Duration.millis(10), pumian));
			tml.setCycleCount(pu.time);
			tml.setAutoReverse(true);
			tml.play();
			
		}
		private void beiwanglu() {
			
			
		}
		void wiki() {
			int i=game.lvlat;
			if(i==0||i==1||i==2) {
				w.getEngine().load("http://backrooms-wiki-cn.wikidot.com/");
			}
			else {
				l=new Label("未连接到网络");
				l.setPrefSize(500,800);
				l.setFont(ui.bfont);
				wk=new GridPane();
				wk.add(l, 0, 0);
			}
			g.getChildren().remove(m);
			g.getChildren().add(wk);
			appf=1;
		}
		class note extends Rectangle{
			int guidao,type,len,ondrop;
			double time;
			note(int i,double tm){
				super(125*i+2,-20,120,20);
				guidao=i;
				time=tm;
				Stop[] stops=new Stop[] {new Stop(0,Color.ALICEBLUE),new Stop(1,Color.DEEPSKYBLUE)};
				RadialGradient rg=new RadialGradient(0, 0, 60+125*i, 0, 80, false, CycleMethod.NO_CYCLE, stops);
				setFill(rg);
			}
			String getName(){
				return "note";
				
			}
		}
		class pu{
			int time;
			int nownote;
			HashMap<Integer,note> notes=new HashMap<Integer,note>();
			pu(){}
		}
	}
}
