package lvls0;
//Level 0
//“假如你不小心在错误的地方从现实中切出，你最终将坠入后室，这里只有腐臭的潮湿地毯，令人发狂的单调黄色，荧光灯全力运作发出的永无止境的嗡鸣，还有令人深陷其中的大约六亿平方英里随机分割的空荡房间。
//倘若你听见有什么东西在附近徘徊，愿上帝保佑你吧，因为它一定也听见了你的声音……”
//
// 
//
//生存难度：
//等级 1
//安全
//稳定 
//极少量实体 
// 
//Thebackrooms.jpg
//Level 0的第一张照片。
//
//Level 0 是后室的第一层，也是许多人所遭遇的第一层。
//
//描述：
//Level 0 是一处非线性空间，外观类似于一家零售店的储藏后室。与它此前被确认的形式相似，Level 0 中的所有房间都在外观上呈现出具有共同表面特征的统一制式模样，例如泛黄的墙纸、潮湿的地毯和以不一致方式安装的荧光灯具。然而，本层中不存在两个完全相同的房间。
//
//被安装在本层空间中的荧光灯保持无规律闪烁，并以恒定频率发出嗡鸣。这种噪声尤其响亮，明显比正常的荧光灯所能制造的噪音更加刺耳，而对灯具装置进行检查以确定噪声来源的尝试以失败告终。浸湿地毯的物质成分始终无法被查明。它既不是水，同时也不能被安全地饮用。1
//
//在Level 0中，线性空间发生了相当大的变化；以至于可能顺着直线行走却返回起点，而沿着你的足迹折返将会导致一组新的、不同的房间替代已经通过的房间出现。由于这一点，以及各房间之间的视觉相似性，试图在后室中进行稳定的导航是十分困难的。指南针和GPS定位器等设备无法在本层中正常运行，无线电通信则会变得失真且不可靠。
//
//Level 0是完全静止且不存在生命的。尽管它是后室的主要入口，却从未有人员报告在本层内与其他流浪者发生接触。据推测，绝大多数人员在离开本层前就已死亡，主要死因可能包括：脱水，饥饿，感官剥夺和孤独造成的心理创伤。然而，没有任何尸体被报告发现以支持这些假定存在的死亡案例。尝试以小组形式进入Level 0将导致小组人员分离并失散，直至该小组退出本层。
//
//在Level 0中，人员普遍会产生幻觉，通常包括以下几种：
//
//荧光灯的噪音音量逐渐增加至震耳欲聋的程度，随后突然归于寂静。
//观察到门的出现。
//观察到楼梯的出现。
//突发的既视感（déjà vu）。
//听见类似人类说话声的声音，内容却并不接近于任何一种已知语言。
//在视线运动时用余光发现类似昆虫的物体在墙纸下爬行，一旦直接观察墙壁就会消失。
//听见类似昆虫发出的吱吱声。
//根据化验分析，Level 0内的CO₂水平正在以稳定速率上升。这一现象代表的意义尚不明确。
//
//实体：
//已知本层内不存在任何实体，包括其他人类。若你看到、听到或遭遇了任何你确信为另一个流浪者的事物，那并不是人类。
//
//入口和出口：
//入口
//因意外“切出”（no-clip）现实的界限是进入Level 0最统一的方式，进一步说，这也是进入整个后室世界的统一方式。更多信息请参阅“后室基本生存指南”。
//
//在Level 283的堡垒中，极其少见地存在散发霉味的木门；这些门通向Level 0。
//
//出口
//离开Level 0的唯一方式是“切出”（no-clipping）本层，这一般会导致流浪者进入Level 1。由于刚进入Level 0的新手通常不熟悉后室的机制，为了离开本层，保持你对所在位置的认知并快速适应当前环境是十分必要的。
//
//马尼拉房间的入口十分罕见，但可能在朝任意方向跋涉极长的距离后抵达。与Level 0不一样，流浪者可以自由地在马尼拉房间相遇，不过本房间是一条死路，不存在离开Level 0的出口。更准确的说，它的作用是作为在长途跋涉中幸存下来的流浪者的集合室。
//
//另外，可以在马尼拉房间中找到来自M.E.G.的文档，它可以帮助新人生存并逃脱。在 [数据丢失] 中可以找到有关如何“切出”的说明。
//
//作者（们）的信息
//« Level -0 | Level 0 | Level 1 »
//
//Footnotes
//1. 分析中发现了胸膜液的痕迹


import java.util.Random;
import br.game;
import br.rw;
import br.ui;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lvlc.level;
import lvlc.randomdrop;
import lvlc.wallbuild;
import model.block;
import model.wupin;
import sub.midiplayer;
import sub.wendang;

public class lvl0 {
	public static int maniamadef,lmapx,lmapy;
	public static wupin[] drop= {
			new wupin(509,0,0,0,0,1000,0,0,0,"megxinshouzhinan","MEG新手指南",
					"详情][]在wiki",""),
			new wupin(510,0,0,0,0,0,0,0,0,"beiwurandexinshouzhinan","被污染的新手指南",
					"沾满了黑色液体,][]看不见内容了",""),};
	static EventHandler<ActionEvent> evt=e->{
		event(1);
		event(2);
	};
	static Timeline timer=new Timeline(new KeyFrame(Duration.millis(500),evt));
	public void rtwall() {
		ui.hidelist.clear();
		ui.hidelist.put(1, null);
		ui.hidelist.put(6, null);
		game.wallarg[0]=1;game.wallarg[1]=300;
		game.wallarg[2]=1;game.wallarg[3]=7;
		game.wallarg[4]=3;game.wallarg[5]=15;game.wallarg[6]=4;
		level.blocks.clear();
		level.blocks.put(0, new block(new String[]{"地","毯"},Color.color(0.682,0.583,0.277,1.000)));
		level.blocks.put(1, new block(new String[]{"墙","壁"},Color.color(0.913,0.855,0.702,1.000)));
		level.blocks.put(4, new block(new String[]{"桌"},Color.color(0.690,0.393,0.120,1.000)));
		level.blocks.put(5, new block(new String[]{"椅"},Color.color(0.690,0.393,0.120,1.000)));
		level.blocks.put(6, new block(new String[]{"墙"},Color.color(0.988,0.946,0.888,1.000)));
		level.blocks.put(7, new block(new String[]{"尸"},Color.color(0.459,0.293,0.054,1.000)));
		midiplayer.qiege("LittlMan");
	}
	public static void play() {
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.setAutoReverse(true);
		timer.play();
	}
	public static void stop() {
		timer.stop();
	}
	public static void event(int eid){
		switch(eid) {
			case 1:{
				if(maniamadef==0) {
					makemania(game.mapy,game.mapx);
				}
			}
			case 2:{
				if(Math.abs(game.mapx-lmapx)>2||Math.abs(game.mapy-lmapy)>2) {
					lmapx=game.mapx;
					lmapy=game.mapy;
					maniamadef=0;
				}
			}
		}
	}
	public int[][] drop(int[][] map,int mapy,int mapx) {
		Random r=randomdrop.r;
		//new p(mapy+","+mapx+"\n");
		int a=r.nextInt(10);
		for(int i=0;i<a;i++) {
			int x=r.nextInt(100);
			int y=r.nextInt(100);
			if(map[y][x]==0) {
				map[y][x]=7;
				wupin w1=drop[1];
				randomdrop.putdrop(mapy,mapx,y,x,w1);
				//new p(game.lvlat+","+mapy+","+mapx+","+y+","+x+"\n");
			}
		}
		return map;
	}
	static void makemania(int mapy,int mapx) {
		lmapx=game.mapx;
		lmapy=game.mapy;
		int dir = 0;
		if(mapx>1)dir=5;
		else if(mapx<-1)dir=3;
		else if(mapy>1)dir=7;
		else if(mapy<-1)dir=1;
		if(dir!=0) {
			int mapy1=0,mapx1=0;
			if(dir==5) {mapy1=mapy;mapx1=mapx+1;}
			if(dir==3) {mapy1=mapy;mapx1=mapx-1;}
			if(dir==7) {mapy1=mapy+1;mapx1=mapx;}
			if(dir==1) {mapy1=mapy-1;mapx1=mapx;}
			//int w= (int)(7+Math.random()*5),l= (int)(7+Math.random()*5);
			int w=10,l=10;
			game.bm[dir]=wallbuild.room(game.bm[dir], 0, 0,l,w, 6);
			game.bm[dir]=wallbuild.one(game.bm[dir],1,1,4);
			game.bm[dir]=wallbuild.one(game.bm[dir],1,2,5);
			game.bm[dir]=wallbuild.one(game.bm[dir],0,w/2,0);
			game.bm[dir]=wallbuild.one(game.bm[dir],l,w/2,0);
			game.bm[dir]=wallbuild.one(game.bm[dir],l/2,0,0);
			game.bm[dir]=wallbuild.one(game.bm[dir],l/2,w,0);
			randomdrop.putdrop(mapy1,mapx1,1,1,drop[0]);
			maniamadef=1;
		}
	}
	public void clip() {
		Random r=wallbuild.r;
		int i=r.nextInt(10);
		if(i>0) {
			stop();
			game.enter(1);
		}
		else {
			int x=r.nextInt(200)-100;
			int y=r.nextInt(200)-100;
			game.posx=x;
			game.posy=y;
			level.mapmove(5);
		}
	}
	public Group makeblock(Label b,int i,int j) {
		//int m=game.map[i][j];
		//level.setlabel(m,i,j);
		b.setFont(ui.bfont);
		b.setPadding(new Insets(0, 0, 0, 0));
	    b.setPrefSize(40, 40);
	    b.setBackground(ui.backtm);
	    b.setBorder(null);
	        
	        /*
        int w = 100;
        int h = 100;
        FloatMap map = new FloatMap();
        map.setWidth(w);
        map.setHeight(h);
        
        for (int i = 0; i < w; i++) {
            double v = (Math.sin(i / 50.0 * Math.PI) - 0.5) / 40.0;
            for (int j = 0; j < h; j++) {
                map.setSamples(i, j, 0.0f, (float) v);
            }
        }
        DisplacementMap dm = new DisplacementMap();
        dm.setMapData(map);
        b.setEffect(dm);*/
        Group g=new Group();
        g.getChildren().add(b);
//        Reflection r1 = new Reflection();
//        r1.setFraction(0.9f);
//        g.setEffect(r1);
        Group g1=new Group();
        g1.getChildren().add(g);
        /*MotionBlur mb = new MotionBlur();
        mb.setRadius(5.0f);
        mb.setAngle(45.0f);
        g1.setEffect(mb);*/
		return g1;
	}
//	public void on(wupin w) {
//		if(w.eventkey==1000) {
//			onpick(w);
//		}
//	}
//	public void onpick(wupin w) {
//		if(w.pinyin.equals("megxinshouzhinan")) {
//			String[] ss=new String[7];
//			for(int i=0;i<7;i++) {
//				ss[i]=rw.reads("juqing/0/新手指南"+String.valueOf(i+1)+".txt");
//			}
//			//new p(s);
//			new wendang(ss,new Color(0.955,0.905,0.814,1.000),Color.BLACK).show();
//		}
//	}
}