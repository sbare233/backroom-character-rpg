package br;

import java.util.HashMap;

import model.wupin;
import sub.container;

public class craft {
	static HashMap<String,String> craftlist=new HashMap<String,String>();
	static HashMap<Integer,wupin> craftca=new HashMap<Integer,wupin>();
	craft(){
		rw.readcft("craft.txt");
		/*Iterator<Entry<String, String>> it = craftlist.entrySet().iterator();
		for (int k = 0; it.hasNext(); k++) {
			Entry<String, String> next = it.next();
			new p(next.getValue()+"\n");
			new p(next.getKey());
		}*/
	}
	static void confirmcraft(){
		String key="";
		for(int i=0;i<ui.craftsizef*ui.craftsizef;i++) {
			key+=ui.cft[i].w.pinyin+ui.cft[i].w.id+",";
		}
		String key1=key.replaceAll(",","");
		String target="";
		if(craftlist.containsKey(key))
			target= craftlist.get(key);
		else if(craftlist.containsKey(key1))
			target= craftlist.get(key1);
		if(target.equals("")) {
			getallback();
		}
		else {
			container.exchange(wupinlist.list.get(target),1);
			reput();
		}
		game.refwupininfo();
	}
	static void clickcft(int j) {
			if (ui.cft[j].w .equals(game.onuse)) {
				ui.cft[j].onuse=1;
				char[] c = {ui.cft[j].w.name.toCharArray()[0] };
				ui.cft[j].setText(String.valueOf(c));
				//new p(cft[j].text);
				ui.cft[j].setBackground(ui.backlg);
				wupin w=ui.cft[j].w;
				craftca.put(j, w);
				container.exchange(w, -1);
			} else {
				wupin w=ui.cft[j].w;
				craftca.remove(j);
				sub.container.exchange(w, 1);
				ui.cft[j].onuse = 0;
				ui.cft[j].setText(null);
				ui.cft[j].setBackground(ui.backg);
			}
		game.refwupininfo();
	}
	static void clearcft() {
		craftca.clear();
		for(int j=0;j<ui.craftsizef*ui.craftsizef;j++) {
			ui.cft[j].onuse = 0;
			ui.cft[j].setText(null);
			ui.cft[j].setBackground(ui.backg);
		}
		game.refwupininfo();
	}
	static void reput() {
		craftca.clear();
		for(int j=0;j<ui.craftsizef*ui.craftsizef;j++) {	
			if(game.bag.get(ui.cft[j].w)>0) {
				container.exchange(ui.cft[j].w,-1);
				craftca.put(j,ui.cft[j].w);
			}	
		}
		game.refwupininfo();
	}
	static void getallback() {
		for(int i=0;i<ui.craftsizef*ui.craftsizef;i++) {
			if(ui.cft[i].onuse==1){
				clickcft(i);
			}
		}
	}
}
