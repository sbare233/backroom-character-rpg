package lvls0;
//Level 1
// 
//
//生存难度：
//等级 1
//安全
//稳定 
//极少量实体 
// 
//artistlivesinme.jpg
//最初发现时的Level 1
//
//Level 1是后室的第二层。
//
//描述：
//Level 1是一个巨大且绵延不绝的仓库，具有混凝土构成的地板和墙壁，裸露的钢筋以及在较低处悬浮的来源不明的雾气。这些雾气常常冷凝，形成地面上分布不均的水坑。 与Level 0不同，此层级拥有源源不断的水源和电力供应，只要采取适当的预防措施，流浪者们就可以无限期地在此居住下去。同时，它的规模也大得多，还带有楼梯、电梯、独立房间和走廊。
//
//此层级中会随机出现（或消失）一些补给箱，通常包含一些重要物资1和一些无用物品2。因箱子内容物的性质，应该谨慎对待它们。但与此同时它们也是宝贵的资源。
//
//artistdiesinme.jpg
//Level 1的一处走廊
//
//此外，墙壁上和地板上还会出现没有明显来源或意义的粗糙涂鸦和绘画。据了解，在黑暗时或无人直视时，这些涂鸦的外观会发生变化或直接消失。Level 1内的灯具容易出现闪烁或随机故障；当出现此种情况时，物资有可能会莫名其妙地消失，并有可能会出现敌对实体。这些实体很少成群结队地出现并发动攻击，并且似乎倾向于避免与灯光和人群接触。建议携带一个可靠的光源，并在睡觉或休息时把握好你不希望丢失的任何物品。
//
//Level 1是枢纽的家园。
//
//基地、前哨和社区
//M.E.G.（探险者总署）Alpha基地：
//这是M.E.G.的第一个主要基地。
//大约半数的团体和队伍都居住于此，主要为探险者和与B.N.T.G.共享的供应前哨提供居所。
//此基地很靠近Level 1的一个入口。
//对实体攻击等威胁进行了严密防范。
//B.N.T.G.商人之家：
//商人之家是一个类似于城市的大型综合建筑。
//大约有412名无敌意的居民。
//拥有基本的社会基础设施。
//流浪者的主要补给中心。
//贸易者的保险库设立在Level 1的存储大厅里。
//与The M.E.G.有着良好的沟通与交流关系。
//Tom的餐馆：
//由Tom经营，在切入后室前是一名厨师。
//拥有大量的食物储存，由B.N.T.G.每月供应。
//Tom是一个和蔼可亲且乐观的人，他的餐馆也是一个小型的社交中心。
//入口与出口：
//入口
//可以从Level 0切入此层级。本层级有许多入口；在许多层级中打开任意一道普通门都很有可能进入Level 1。此外，在Level 11.1中爬上一棵树，在Level 92中完成第五个事件，在Level 94中完成国王的试炼都是回到Level 1的可靠办法。
//
//出口
//你只需要继续探索后室就能离开Level 1。沿着任何延伸的走廊徘徊通常能够到达Level 2，找到墙上的洞就能进入Level 19，如果在天花板上有涂鸦的地方切出的话，你就能到一个派对上啦！
//
//补充材料：回收到的档案
//以下笔记回收自Level 1的不同地点，没有找到明显的来源。
//
//画者居于吾心
//画者逝于吾心
//
//你不想留下来参加派对吗？ =)
//
//烧掉我操蛋的尸体！
//
//蓝鸟在召唤你，抚慰你。你在这里很安全。
//
//黑皇后移到h5，这～就是将军～
//
//看看钟表吧，预言要临近了
//
//作者信息
//« Level 0 | Level 1 | Level 2 »
//
//Footnotes
//1. 如食物、杏仁水、电池，防水布、武器、衣物、医疗用品等
//2. 各种汽车零件、蜡笔盒、用过的注射器、部分烧焦的纸、活老鼠、因注射了某种未知物质而亢奋的老鼠、鞋带、零钱、一束人类毛发等


import java.util.HashMap;
import java.util.Random;

import br.game;
import br.p;
import br.pl;
import br.ui;
import br.wupinlist;
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
import model.mob;
import model.wupin;
import sub.midiplayer;

public class lvl1 {
	static int lposx,lposy,lvl2f,lmapx,lmapy,nobuildf;
	EventHandler<ActionEvent> evt=e->{
		event(1);
		event(2);
	};
	Timeline timer=new Timeline(new KeyFrame(Duration.millis(500),evt));
	
	public void rtwall() {
		ui.hidelist.clear();
		ui.hidelist.put(10, null);
		midiplayer.qiege("LittlMan");
		game.wallarg[0]=10;game.wallarg[1]=200;
		game.wallarg[2]=10;game.wallarg[3]=7;
		game.wallarg[4]=3;game.wallarg[5]=15;game.wallarg[6]=4;
		level.blocks.clear();
		level.blocks.put(2, new block(new String[]{"板","条","箱"},Color.color(0.839,0.781,0.566,1.000)));
		level.blocks.put(0, new block(new String[]{"混","凝","土","地"},Color.color(0.409,0.393,0.376,1.000)));
		level.blocks.put(10, new block(new String[]{"混","凝","土","墙"},Color.color(0.736,0.736,0.727,1.000)));
		level.blocks.put(11, new block(new String[]{"走","廊"},Color.color(0.711,0.702,0.694,1.000)));
		level.blocks.put(12, new block(new String[]{"门"},Color.color(0.748,0.665,0.475,1.000)));
		game.mobs.put(1001, new HashMap<Integer,mob>());
	}
	public void play() {
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.setAutoReverse(true);
		timer.play();
	}
	public void stop() {
		timer.stop();
	}
	public void event(int eid){
		switch(eid) {
			case 1:{
				if(game.posx!=lposx||game.posy!=lposy) {
					lposx=game.posx;
					lposy=game.posy;
					if(game.map[ui.yi/2][ui.xi/2]==11) {
						lvl2f++;
						//new p(lvl2f+"\n");
						if(lvl2f>10) {
							//new p(ui.ag+"\n");
							if((game.map[ui.yi/2][ui.xi/2+1]==10&&(ui.ag<10||ui.ag>350))||
									(game.map[ui.yi/2-1][ui.xi/2]==10&&ui.ag<100&&ui.ag>80)||
									(game.map[ui.yi/2][ui.xi/2-1]==10&&ui.ag<190&&ui.ag>170)||
									(game.map[ui.yi/2+1][ui.xi/2]==10&&ui.ag<280&&ui.ag>260))
								clip(2);
						}
					}			
				}
			}
			case 2:{
				if(game.mapx!=lmapx||game.mapy!=lmapy||(game.mapx==0&&game.mapy==0)) {
					lmapx=game.mapx;
					lmapy=game.mapy;
					for(int i=0;i<100;i++) {
						for(int j=0;j<100;j++) {
							if(game.bm[4][i][j]==2) {
								if(!ui.drops.containsKey(game.lvlat+","+lmapy+","+lmapx+","+i+","+j)) {
									//new p(1);
									wupin w1=wupinlist.list.get("xingrenshui3");
									wupin w2=wupinlist.list.get("longrou5");
									int[] d=ui.downfrommap(i,j,0,0);
									randomdrop.putdrop(d[1],d[2],d[3],d[4],new wupin[]{w1,w2},new int[] {1,1});
								}
							}

							if(game.bm[4][i][j]==3)game.bm[4][i][j]=0;
							
						}
					}
				}
			}
		}
	}
	public int[][] aftbuild(int[][] map) {
		if(nobuildf==0) {
		Random r=new Random();
		int n=r.nextInt(200)+100;
		for(int i=1;i<n;i++) {
			int y=r.nextInt(100),x=r.nextInt(100);
			map[y][x]=3;
		}
		for(int i=0;i<98;i++) {
			for(int j=0;j<98;j++) {
				if(map[i][j]==3) {
					int l=r.nextInt(30);
					int d=r.nextInt(3);
					if(d==0) {
						l:for(int k=0;k<l&&k+i<100;k++) {
							if(map[k+i-1][j]==10&&map[k+i-1][j+2]==10&&map[k+i+1][j]==10&&map[k+i+1][j+2]==10) {
								continue l;
							}
							map[k+i][j]=10;
							map[k+i][j+1]=11;
							if(k==l/2){
								int c=r.nextInt(1);
								if(c==0) {
									map[k+i][j+1]=11;
									mob men=mob.moblist.get("1001men").clone();
									men.move((level.onbuild/3-1)*100+k+i,(level.onbuild%3-1)*100+j+1);
									game.mobs.get(1001).put(game.mobs.get(1001).size(),men);
									new pl(game.mobmap[(level.onbuild/3)*100+k+i][(level.onbuild%3)*100+j+1]);
									
								}
							}
							map[k+i][j+2]=10;
						}
					}
					else if(d==1){
						k:for(int k=0;k<l&&k+j<100;k++) {
							if(map[i][k+j-1]==10&&map[i+2][k+j-1]==10&&map[i][k+j+1]==10&&map[i+2][k+j+1]==10) {
								continue k;
							}
							map[i][k+j]=10;
							map[i+1][k+j]=11;
							if(k==l/2){
								int c=r.nextInt(1);
								if(c==0) {
									map[k+i][j+1]=11;
									mob men=mob.moblist.get("1001men").clone();
									men.move((level.onbuild/3-1)*100+i+1,(level.onbuild%3-1)*100+k+j);	
									game.mobs.get(1001).put(game.mobs.get(1001).size(),men);
									new pl(game.mobmap[(level.onbuild/3)*100+i+1][(level.onbuild%3)*100+k+j]);
									
								}
							}
							map[i+2][k+j]=10;
						}
					}
					else if(i<91&&j<91){
						int ll=r.nextInt(10),ww=r.nextInt(10);
						wallbuild.room(map,i,j,ll,ww,10);
						map[i+ll/2][j]=0;map[i+ll/2][j+ww]=0;
						map[i][j+ww/2]=0;map[i+ll][j+ww/2]=0;
						if(ll>2&&ww>2) {
							int lll=i+r.nextInt(ll),www=j+r.nextInt(ww);
							map[lll][www]=2;	
						}
					}
				}
			}
		}
		//
		//什么bbug啊，为什么用了continue下面就不执行了啊
		//
		//
	
		//map=build1(map);
		}
		return map;
		
	}
//	public int[][] build1(int[][] map) {
////		Random r=new Random();
////		for(int i=1;i<99;i++) {
////			for(int j=1;j<99;j++) {
////				if(
////						//(map[i][j]!=10)&&
//////						((map[i][j-1]==10&&map[i][j+1]==10&&map[i-1][j-1]==10&&map[i-1][j+1]==10&&map[i+1][j-1]==10&&map[i+1][j+1]==10)||
//////						(map[i-1][j]==10&&map[i+1][j]==10&&map[i-1][j-1]==10&&map[i+1][j-1]==10&&map[i-1][j+1]==10&&map[i+1][j+1]==10))) {
////					((map[i-1][j-1]==10&&map[i-1][j+1]==10&&map[i+1][j-1]==10&&map[i+1][j+1]==10)||
////							(map[i-1][j-1]==10&&map[i+1][j-1]==10&&map[i-1][j+1]==10&&map[i+1][j+1]==10))) {
//////					if(map[i][j]==10) {
//////						if(map[i-1][j]==11) {
//////							new p(1);
//////							map[i+1][j-1]=11;
//////							map[i+1][j+1]=11;
//////						}
//////						else if(map[i][j-1]==11) {
//////							map[i-1][j+1]=11;
//////							map[i+1][j+1]=11;
//////						}
//////					}
//////					if(map[i+1][j-2]==10&&map[i+1][j+2]==10&&map[i-1][j-2]==10&&map[i-1][j+2]==10) {
//////						map[i][j-1]=11;
//////						map[i][j+1]=11;
//////					}
//////					else if(map[i+2][j-1]==10&&map[i+2][j+1]==10&&map[i-2][j-1]==10&&map[i-2][j+1]==10) {
//////						map[i-1][j]=11;
//////						map[i+1][j]=11;
//////					}
////					int w=r.nextInt(50);
////					if(w==0)map[i][j]=2;
////					else map[i][j]=11;
////				}
////			}
////		}
////		for(int i=0;i<100;i++) {
////			for(int j=1;j<100;j++) {
////				if(map[i][j]==3)map[i][j]=0;
////			}
////		}
//		return map;
//	}
//	public void clip() {
//		Random r=wallbuild.r;
//		int i=r.nextInt(10);
//	}
	public void clip(int l) {
		if(l==2) {
			stop();
			game.enter(2);
		}
	}
	public void lreffect(int id) {
		switch(id) {
			case 0:{
				game.tp(0, 0);
			}
		}
	}
//	public void inidrop() {
//		
//	}
//	public int[][] drop(int[][] map,int mapy,int mapx) {
//		return map;
//		
//	}g
//	public Group makeblock(Label b,int i,int j) {
//		int m=game.map[i][j];
//		level.setlabel(m,i,j);
//		b.setFont(ui.bfont);
//		b.setPadding(new Insets(0, 0, 0, 0));
//	    b.setPrefSize(40, 40);
//	    b.setBackground(ui.backtm);
//	    b.setBorder(null);
//        Group g=new Group();
//        g.getChildren().add(b);
//        return g;
//	}
}