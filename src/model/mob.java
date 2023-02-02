package model;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import br.game;
import br.p;
import br.rw;
import javafx.animation.AnimationTimer;

public class mob {
	public int id,y,x,mapy,mapx,life,type;
	public long starttime,nowtime;
	public String name;
	public HashMap<String,Integer> buffrange=new HashMap<String,Integer>();
	public HashMap<Integer,wupin> w=new HashMap<Integer,wupin>();
	public HashMap<Integer,Double> chance=new HashMap<Integer,Double>();
	public HashMap<String, acttimer> act=new HashMap<String,acttimer>();
	
	public static HashMap<String,mob> moblist=new HashMap<String,mob>();
	public mob(){
		
	};
	public mob(int id, int y, int x, int mapy, int mapx,int life,int type, String name, HashMap<String, Integer> buffrange,
			HashMap<Integer, wupin> w,HashMap<Integer,Double> chance,HashMap<String, acttimer> act2) {
		this.id = id;
		this.y = y;
		this.x = x;
		this.mapy = mapy;
		this.mapx = mapx;
		this.type=type;
		this.name = name;
		this.life=life;
		this.buffrange = buffrange;
		this.w = w;
		this.chance=chance;
		for(String s:act2.keySet()) {
			act2.get(s).setMobid(id);
		}
		this.act = act2;
	}
	public mob clone() {
		return new mob(this.id,this.y,this.x,this.mapy,this.mapx,this.life,this.type,this.name,
				this.buffrange,this.w,this.chance,this.act);	
	}
	public static void readlist() {
		String path="mobs";
		File d=new File(path);
		String[] l=d.list();
		for(String s:l) {
			//new p("mobs/"+s);
			rw.readmob("mobs/"+s);
		}
	}
	void actp() {
		Iterator<Entry<String, acttimer>> it = act.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, acttimer> next = it.next();
			AnimationTimer actv = next.getValue();
			actv.stop();
			actv.start();
		}
	};
	public static void actall() {
		for(Integer Key:game.mobs.keySet()) {
			HashMap<Integer,mob> mobi=game.mobs.get(Key);
			Iterator<Entry<Integer,mob>> it=mobi.entrySet().iterator();
			while (it.hasNext()) {
				try {
					Integer i=it.next().getKey();
					mobi.get(i).actp();
				}catch(Exception e) {}
			}
		}
	}
	public static void stopall() {
		for(Integer Key:game.mobs.keySet()) {
			HashMap<Integer,mob> mobi=game.mobs.get(Key);
			Iterator<Entry<Integer,mob>> it=mobi.entrySet().iterator();
			while (it.hasNext()) {
				Integer i=it.next().getKey();
				//new p(i);
				HashMap<String, acttimer>act= mobi.get(i).act;
				for(String s:act.keySet()) {
					act.get(s).stop();
				}
			}
		}
	}
	public static void moveall(int my, int mx) {
		for(Integer Key:game.mobs.keySet()) {
			HashMap<Integer,mob> mobi=game.mobs.get(Key);
			Iterator<Entry<Integer,mob>> it=mobi.entrySet().iterator();
			while (it.hasNext()) {
				try {
					Integer i=it.next().getKey();
					mobi.get(i).move(my,mx);
				}catch(Exception e) {}
			}
		}
	}
	public void move(int my, int mx) {
		if(my==0&&mx==0) {
			
		}
		else {
			if(x>-1&&x<300&&y>-1&&y<300) {
				game.mobmap[y][x]=0;
				game.mobidmap[y][x]=0;
				game.mobsp.remove(game.lvlat+","+mapy+","+mapx+","+y+","+x);
			}
			x=x+mx;
			y=y+my;
			
		}
//		if(mapx==game.mapx&&mapy==game.mapy&&x<ui.xi&&y<ui.yi) {
//			game.bm[4][y][x]=type;
//			game.map[y][x]=type;
//			new p(x);
//			new p(y); 
//			new p(id+"\n");
//			
//		}
		//System.out.print(game.map[y][x]);
		if(x>-1&&x<300&&y>-1&&y<300) {
			game.mobmap[y][x]=type;
			game.mobidmap[y][x]=id;
			String key=game.lvlat+","+mapy+","+mapx+","+y+","+x;
			game.mobsp.put(key,this);
		}
//		if(x>99&&x<200&&y>99&&y<200) {
//			level.setlabel(game.mobmap[y-100][x-100], y-100, x-100);
//		}
	}
	public void react() {
		//new p(1);
		try {act.get("打开面板").flags.put("openf",1);}catch(Exception e) {}
		try {act.get("右键效果").flags.put("lreffectf",1);}catch(Exception e) {}
	}
}
