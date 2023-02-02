package lvls0;
//Level 2
// 
//
//生存难度：
//等级 2
//不安全
//稳定 
//少量实体 
// 
//pipdreams.png
//出现在Level 2的未知实体
//
//Level 2是后室的第三层，也是最后一个你能够当作出发地点的层级。
//
//描述
//Level 2主要由暗黑色、灰色的混凝土维护隧道组成，绵延数百万英里。此层级的墙壁上布满了管道，偶尔还能见到通风管道。这些管道中通常会流动着一些黑色的粘稠液体。有时可以发现一些门，但它们大多数是上锁的或者通向一个死胡同，它们内部通常会有一些放置着随机物品的架子，大多数情况下是电脑。
//
//在Level 2走廊的某些区域，温度可能会高得令人难以忍受，可达43摄氏度（110华氏度）甚至更高。这通常发生在那些机器噪音最大的区域，如走廊的尽头。
//
//在此层级中出现的实体是后室中最危险的。通风管道中出现的噪音通常是由爬菌发出的。在Level 2的员工浴室中你还可以发现Mark。在此层级的其他实体还有：笑魇、幼年无面灵、肢团、猎犬、雄性死亡飞蛾、悲尸、爆酸者和窃皮者。你唯一要记住的就是当你看到任何实体时立马逃跑。上图中出现的实体仍然没有得到确认，此照片的拍摄者的命运也尚不明确。
//
//基地、前哨和社区
//“生还者”
//一个由29人组成的层级探索小组，领导人是Austin。他们是一个友善且乐于交易的团体。他们用从Level 1发现的木箱子装载他们的补给。他们也是第一个发现悲尸的团体。 此团体与一个名叫杰瑞的信众的前哨站经常发生冲突。
//
//办公区EL3A
//办公区EL3A是一个在Level 2的办公区域，是B.N.T.G.（不结盟贸易集团）30个成员在Level 2的居所。
//更多信息请参考办公区EL3A
//
//入口与出口
//入口
//Level 2是后室中少数几个能够从现实世界直接进入的层级。 你可以通过在Level 1中探索足够长的距离来进入Level 2。它也可以从枢纽进入。
//
//出口
//与大多数人的观念相反，Level 2中出现的门并非全部都是上锁的或通向死胡同。有些可以进入Level 3，Level 4，偶尔也会回到Level 1。找到一扇外表被滑稽地涂成五颜六色的未上锁的门会把你带到Level 283。如果你在Level 2极度闷热的区域切出的话，你可能会被困在Level 2.1。


import java.util.Random;

import br.game;
import br.p;
import br.ui;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;                                                      
import javafx.util.Duration;
import lvlc.level;
import lvlc.randomdrop;
import model.block;
import model.wupin;
import sub.midiplayer;

public class lvl2 {
	static int lposx,lposy,lmapx,lmapy,inif;
	static Random r=new Random();
	static int[][] sg=new int[6][4];
	//0第1行 2第三行 3第一列
	public static wupin[] drop= {
			new wupin(9,0,0,0,0,1000,0,0,0,"megxinshouzhinan","MEG新手指南",
					"详情][]在wiki",""),
			};
	public void rtwall() {//墙壁的遮挡信息，切歌，
		//生成墙壁的参数（也可以写game.wallarg[0]=0阻止默认生成并重写aftbuild）
		ui.hidelist.clear();
		ui.hidelist.put(21, null);
		midiplayer.qiege("LittlMan");
		game.wallarg[0]=0;
		level.blocks.clear();
		block b20=new block(new String[]{"混","凝","土","地"},Color.color(0.541,0.508,0.512,1.000));
		level.blocks.put(20, b20);
		block b21=new block(new String[]{"混","凝","土","墙"},Color.color(0.760,0.736,0.727,1.000));
		level.blocks.put(21, b21);
		for(int i=0;i<6;i++){
			int n=r.nextInt(4)+1;
			for(int j=0;j<n;j++) {
				sg[i][j]=r.nextInt(97);
			}
		}
	}
	public static int[][] aftbuild(int[][] map) {//重写楼层生成
		//Random r=new Random();
//		for(int i=0;i<6;i++){
//			for(int j=0;j<4;j++){
//				if(sg[i][j]!=0)
//					new p(sg[i][j]+"\n");
//			}
//		}
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				map[i][j]=0;
			}
		}
		int dx=game.mapx-lmapx;
		int dy=game.mapy-lmapy;
		if(dy==-1) {
			new p(1);
			for(int j=0;j<4;j++) {sg[2][j]=sg[1][j];sg[1][j]=sg[0][j];}
			int n=r.nextInt(4);
			for(int j=0;j<n;j++) {sg[0][j]=r.nextInt(97);}
		}
		else if(dy==1) {
			//new p(2);
			for(int j=0;j<4;j++) {sg[0][j]=sg[1][j];sg[1][j]=sg[2][j];}
			int n=r.nextInt(4);
			for(int j=0;j<n;j++) {sg[2][j]=r.nextInt(97);}
		}
		if(dx==-1) {
			//new p(3);
			for(int j=0;j<4;j++) {sg[5][j]=sg[4][j];sg[4][j]=sg[3][j];}
			int n=r.nextInt(4);
			for(int j=0;j<n;j++) {sg[3][j]=r.nextInt(97);}
		}
		else if(dx==1) {
			//new p(4);
			for(int j=0;j<4;j++) {sg[3][j]=sg[4][j];sg[4][j]=sg[5][j];}
			int n=r.nextInt(4);
			for(int j=0;j<n;j++) {sg[5][j]=r.nextInt(97);}
		}
		lmapx=game.mapx;
		lmapy=game.mapy;

		int[] xb=sg[level.onbuild%3+3],yb=sg[level.onbuild/3];
		for(int i=0;i<4&&xb[i]!=0;i++) {
			for(int j=0;j<100;j++) {
				if(map[j][xb[i]]!=20)
					map[j][xb[i]]=21;
				map[j][xb[i]+1]=20;
				map[j][xb[i]+2]=20;
				if(map[j][xb[i]+3]!=20)
					map[j][xb[i]+3]=21;
			}
		}
		for(int i=0;i<4&&yb[i]!=0;i++) {
			for(int j=0;j<100;j++) {
				if(map[yb[i]][j]!=20)
					map[yb[i]][j]=21;
				map[yb[i]+1][j]=20;
				map[yb[i]+2][j]=20;
				if(map[yb[i]+3][j]!=20)
					map[yb[i]+3][j]=21;
			}
		}
		
		
		return map;
	}
	EventHandler<ActionEvent> evt=e->{
		event(1);
	};
	Timeline timer=new Timeline(new KeyFrame(Duration.millis(500),evt));
	
	public void play() {//开始逻辑处理
//		for(int i=ui.yi;i<100+ui.yi;i++) {
//			for(int j=ui.xi;j<100+ui.xi;j++) {
//			if(game.map[i][j]==20)
//				game.tp(i-ui.yi,j-ui.xi);
//			}
//		}
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(game.map[i][j]==20&&inif==0) {
					inif=1;
					game.tp(i,j);
				}
			}
		}
		//把人移动到管道里
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.setAutoReverse(true);
		timer.play();
	}
	public void stop() {//停止逻辑处理，一般切出前调用
		timer.stop();
	}
	
	public void clip(int l) {//切出方法，l是楼层的编号
		stop();
		game.enter(l);
	}
	
	public int[][] drop(int[][] map,int mapy,int mapx) {//在这重写随机掉落
		Random r=randomdrop.r;
		//new p(mapy+","+mapx+"\n");
		int a=r.nextInt(10);
		for(int i=0;i<a;i++) {
			int x=r.nextInt(100);
			int y=r.nextInt(100);
			//if(map[y][x]==0) {
				map[y][x]=2;
				wupin w1=drop[0];
				randomdrop.putdrop(mapy,mapx,y,x,w1);
			//}
		}
		return map;
	}
	
	public void event(int eid){//一般事件处理写在这，500ms执行，在上面可以改 
		switch(eid) {
			case 1:{
				
			}
		}
	}
}