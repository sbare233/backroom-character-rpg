package br;

import java.util.HashMap;

public class fumo {
	enum e{};
	public static int untouchf,seeallf;
	public static HashMap<String,Integer> fumolist=new HashMap<String,Integer>();
	public static void refreashdefense() {
		status.defense=0;
		fumolist.clear();
		status.speed=100;
		untouchf=0;
		seeallf=0;
		int inif=0;
		for(int i=0;i<9;i++) {
			if(ui.wearb[i].onuse!=0) {
				inif=1;
				status.defense+=game.weard[i].defense;
				String fumo=game.weard[i].fumo;
				//new p(fumo);
				readfumo(fumo);
			}
		}
		if(inif==0) {
			for(int i=0;i<9;i++) {
				if(game.weard[i]!=null) {
					inif=1;
					ui.wearb[i].onuse = game.weard[i].waerposotion;
					ui.wearb[i].setText(game.weard[i].name);
					ui.wearb[i].setBackground(ui.backlg);
					String fumo=game.weard[i].fumo;
					//new p(fumo);
					readfumo(fumo);
				}
			}
		}
		if(fumolist.containsKey("速度"))status.speed=100/fumolist.get("速度");
		if(fumolist.containsKey("虚空行者"))untouchf=1;
		if(fumolist.containsKey("全视"))seeallf=1;
		//new p(fumos.get("速度"));
	}
	public static void readfumo(String fumo) {
		for(int j=0;j!=-1&&fumo!=null&&fumo.length()>2;) {
			j=fumo.indexOf("]")+1;
			String s=fumo.substring(0, j);
			//new p(s+"\n");
			fumo=fumo.substring(j);
			//new p(fumo+"\n");
			String name=s.substring((s.indexOf("[")+1),s.indexOf(":"));
			int value=Integer.parseInt(s.substring((s.indexOf(":")+1),s.indexOf("]")));
			//new p(name);
			//new p(value);
			if(fumolist.containsKey(name)) {
				value+=fumolist.get(name);
				fumolist.remove(name);
			}
			fumolist.put(name,value);
		}
	}
}
