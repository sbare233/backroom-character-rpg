package sub;
import java.util.Iterator;
import java.util.Map.Entry;

import br.game;
import br.initial;
import br.juqing;
import br.status;
import br.ui;
import br.wupinlist;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.man;
import model.wupin;

public class makeman extends Stage{
		static TextField name;
		static Label[] pointsn=new Label[10],points=new Label[10];
		static Button random,create;
		static ComboBox<String> job; 
		static VBox box;
		static Pane n,c;
		static GridPane pp;
		static int[] p=new int[10];
		static String[] point= {"气血","毅力","智慧","力量","速度","灵巧","口才","见识","运气","外貌"},
				jobs= {"普通人","养生专家","戒过毒的人","大贤者","大力士","跑步运动员","小偷","杠精","博物学家","经常踩狗屎的人","整过容的人"};

		
		public makeman() {
			this.setOnCloseRequest(e->{
				System.exit(0);
			});
			box=new VBox();
			box.getChildren().add(n=new Pane());
			n.getChildren().add(new Label("你的名字"));
			n.getChildren().add(name=new TextField());
			name.setOnMouseEntered(e->{
				name.requestFocus();
			});
			box.getChildren().add(c=new Pane());
			box.getChildren().add(random=new Button("随机属性"));
			random.setFont(ui.bfont);
			c.getChildren().add(job=new ComboBox<String>());
			job.getItems().addAll(jobs);
			job.getSelectionModel().select(0);
			random.setOnMouseClicked(e->{
				random();
			});
			
			box.getChildren().add(pp=new GridPane());
			//new GridLayout(5,4)
			for(int i=0;i<10;i++) {
				pp.add(pointsn[i]=new Label(point[i]+" "),i*2%4,i*2/4);
				pointsn[i].setFont(ui.bfont);
				pp.add(points[i]=new Label(String.valueOf(p[i])+"  "),(i*2+1)%4,(i*2+1)/4);
				points[i].setFont(ui.bfont);
			}
			box.getChildren().add(create=new Button("创建角色"));
			create.setFont(ui.bfont);
			create.setOnMouseClicked(e->{
				if(game.pointrandomedf<4) {
					game.pointrandomedf++;
				}
				if(game.pointrandomedf==4) {
					game.man=new man("null",42,42,42,42,42,42,42,42,42,42);
					close();
					status.hp=42;status.sn=42;status.mp=42;status.weight=0;
					initial.inif=0;
					ui.stages.get("main").show();
					man.setman();
					ui.name.setText("null");
					int k=0;
					Iterator<Entry<String,wupin>> it =wupinlist.list.entrySet().iterator();
					while(it.hasNext()) {
						Entry<String, wupin> next = it.next();
						wupin w = next.getValue();
						//String i = next.getKey();
						game.bag.put(w,1);
						//new p(i+"\n");
						k++;
					}
					conti();
				}	
				else if(game.pointrandomedf==6){
					String s=makeman.name.getText();
					if(s.isEmpty()) {
						s="null";
					}
					game.man=new man(s,makeman.p[0]+50,makeman.p[1]+50,makeman.p[2]+50,
							makeman.p[3],makeman.p[4],makeman.p[5],makeman.p[6],makeman.p[7],makeman.p[8],makeman.p[9]);
					close();
					status.hp=makeman.p[0]+40;status.sn=makeman.p[1];status.mp=makeman.p[2]+50;status.weight=0;
					initial.inif=0;
					ui.stages.get("main").show();	
					man.setman();
					ui.name.setText(s);
					game.bag.put(wupinlist.list.get("phone500"),1);
					conti();
				}
			});
			//random();
			
			Scene scene = new Scene(box,260,380);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			setScene(scene);
			show();
			ui.stages.put("make", this);
		}
		public void conti(){
			wupinlist.f();
			game.wallarg[0]=1;game.wallarg[1]=300;
			game.wallarg[2]=1;game.wallarg[3]=7;
			game.wallarg[4]=3;game.wallarg[5]=15;game.wallarg[6]=4;
			game.make();
			ui.hidelist.put(1, null);
			ui.hidelist.put(6, null);
			midiplayer.qiege("LittlMan");
			juqing.pjuqing();
		}
		public void random() {
			game.pointrandomedf=6;
			if(job.getValue() =="普通人") {
				for(int i=0;i<10;i++)makeman.p[i]=10;
			}
			else{
				for(int i=0;i<10;i++)makeman.p[i]=0;
				for(int i=0;i<11;i++) {
					if(job.getValue()==jobs[i])
						makeman.p[i-1]=70;
				}
			}
			for(int i=0;i<10;i++) {
				makeman.p[i]+=50*Math.random();
				makeman.points[i].setText(String.valueOf(makeman.p[i]));
			}
		}
	}

