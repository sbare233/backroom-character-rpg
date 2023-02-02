package br;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import lvlc.level;
import lvlc.randomdrop;
import model.lvl;
import model.man;
import model.mob;
import model.quest;
import model.wupin;
import sub.midiplayer1;
import sub.wupininfo;

public class game {
	public static initial ini;
	public static man man;
	public static wupin onuse,onshow;
	public static HashMap<wupin,Integer> bag=new HashMap<wupin,Integer>();
	public static wupin[] weard=new wupin[9];
	public static HashMap<Integer,HashMap<Integer,mob>> mobs=new HashMap<Integer,HashMap<Integer,mob>>();
	//通过type和id获得mob
	public static HashMap<String,mob> mobsp=new HashMap<String,mob>();
	//通过地图位置获得mob
	public static int lvlat=0,p,pointrandomedf=0;
	public static lvl[] nlvl=new lvl[1000],slvl=new lvl[1000],olvl=new lvl[1000],mlvl=new lvl[100];
	public static int[][] map=new int[100][100];
	public static int[][][] bm=new int[9][100][100];
	public static int[][] mobmap=new int[300][300];
	public static int[][] mobidmap=new int[300][300];
	public static int[][] lightsc=new int[300][300];
	public static int[][] light=new int[300][300];
	public static int[][] lightf=new int[300][300];
	public static int[][] temp=new int[300][300];
	public static int posx=0,posy=0;
	public static int mapx=0,mapy=0;
	public static int stopf;
	public static int[] wallarg=new int[10];//,game.wallid,300, 1, 7, 3, 15, 4
	public static HashMap<String, quest> quests = new HashMap<String, quest>();
	
	//static HashMap<String,HashMap<?,?>> rcsmap=new HashMap<String,HashMap<?,?>>();
	
	game(){
		man=new man();
		ini=new initial();
		
		//wallbuild.inibuild();
		if(initial.inif==0) {
			rtwall();
			make();
			play();
		}
		new rcs();
	}
	public static void rtwall() {
		try {
			Class<?> c=Class.forName("lvls"+lvlat/100+".lvl"+lvlat);
			Object o=c.newInstance();
			Method m=c.getMethod("rtwall");
			m.invoke(o);	
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	public static void make() {
		lvlc.light.makelight();
		game.switchlvl();	
		randomdrop.inidrop();
		ui.zhu.getChildren().clear();
		level.mapadjust();
		level.mapmove(5);	
	}
	public static void play() {
		try {
			Class<?> c=Class.forName("lvls"+lvlat/100+".lvl"+lvlat);
			Object o=c.newInstance();
			Method m1=c.getMethod("play");
			m1.invoke(o);	
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	public static void enter(int i) {
		game.lvlat=i;
		rtwall();
		make();
//		mob.stopall();
//		game.mobs.clear();
//		game.mobmap=new int[300][300];
//		game.mobidmap=new int[300][300];
		play();
	}
	public static void clip() {
		try {
			Class<?> c=Class.forName("lvls"+lvlat/100+".lvl"+lvlat);
			Object o=c.newInstance();
			Method m=c.getMethod("clip");
			m.invoke(o);		
		} catch (Exception e) {
		}
	}
	public static void tp(int i1,int i2) {
		mob.moveall(-i1+ui.yi/2+br.game.posy,-i2+ui.xi/2+br.game.posx);
		br.game.posy = i1-ui.yi/2;
		br.game.posx = i2-ui.xi/2;
		level.mapmove(5);		
	}
	public static void switchlvl(){
		if(lvlat<1000)level.createnlvl();
		else if(lvlat<2000)level.createslvl();
		else if(lvlat<3000)level.createolvl();
		else if(lvlat==3000)level.createcore();	
	}
	
	public static void stop() {
		if (stopf == 0) {
			stopf = 1;

			Iterator<Entry<String,Timeline>> it = fx.timelines.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Timeline> next = it.next();
				next.getValue().stop();
			}
			ui.rrr = new Rectangle(0, 0, ui.zhu.getWidth(), ui.zhu.getHeight());
			ui.rrr.setFill(new Color(0.5, 0.5, 0.5, 0.5));
			ui.fxpane.getChildren().add(ui.rrr);
			midiplayer1.player.stop();
			
			ui.stopl1.setTextFill(Color.WHITE);
			ui.stopl1.setTranslateX(ui.zhu.getWidth() - 70);
			ui.stopl1.setTranslateY(100);
			ui.stopl1.setFont(ui.bfont);
			ui.stopl1.setRotate(90);
			ui.fxpane.getChildren().add(ui.stopl1);

			ui.stopl2.setTextFill(Color.WHITE);
			ui.stopl2.setTranslateY(ui.zhu.getHeight());
			ui.stopl2.setFont(ui.bfont);
			ui.fxpane.getChildren().add(ui.stopl2);
			
			wupinuse.unusewupin();
		} else {
			stopf = 0;
			ui.fxpane.getChildren().remove(ui.rrr);
			ui.fxpane.getChildren().remove(ui.stopl1);
			ui.fxpane.getChildren().remove(ui.stopl2);
			midiplayer1.player.start();
			Iterator<Entry<String,Timeline>> it = fx.timelines.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Timeline> next = it.next();
				next.getValue().play();
			}
		}
	}
	public static void refman() {
		// TODO Auto-generated method stub
		
	}
	public static void refwupininfo() {
		if(ui.wupininfo!=null) {
			//game.onshow = game.bag[ui.its[clickbagitem.it].bagid];
			wupininfo.infov = game.onshow.getAll();
			ui.wupininfo = new wupininfo();
			ui.othermenu.setContent(ui.wupininfo);
		}
	}
	
}
