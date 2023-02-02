package br;

import java.lang.reflect.Method;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.wupin;
import sub.wupininfo;

public class clickbagitem implements EventHandler<MouseEvent> {
	public static wupin lastuse;
	public static int it;
	public static int tapid;
	public static String onusename;
	public void handle(MouseEvent e) {
		for (int i = 0; i < ui.its.length; i++)
			if (ui.its[i] != null && e.getSource() == ui.its[i]) {
				if (e.getButton() == MouseButton.PRIMARY) {
					tapid=i;
					u(i);
				} else if (e.getButton() == MouseButton.SECONDARY) {
					it = i;
					game.onshow = null;
					game.onshow = ui.its[i].w;
					//game.onshow = game.bag[ui.its[i].bagid];
					wupininfo.infov = game.onshow.getAll();
					wupininfo.posf=1;
					ui.wupininfo = new wupininfo();
					ui.othermenu.setContent(ui.wupininfo);
					// wupinlist.f();
				}
			}
		ui.zhu.requestFocus();
	}

	public void u(int i) {
		if (ui.its[i].onuse == 0) {
			//切换窗口标题
			if (game.onuse != null)
				for (int j = 0; j < ui.its.length; j++) {
					if (ui.its[j] != null)
						if (ui.its[j].w == lastuse)
							unuse(ui.its[j].w,j);
				}
			use(ui.its[i].w,i);
			lastuse = ui.its[i].w;
		} else {
			unuse(ui.its[i].w,i);
		}
	}

	public void use(wupin w,int i) {
		try {
			Class<?> c=Class.forName("wupin."+w.pinyin+w.id);
			Object o=c.newInstance();
			Method m=c.getMethod("use",wupin.class,int.class);
			m.invoke(o,w,i);	
		} catch (Exception e) {
		//	e.printStackTrace();
		}
//		if (w.type == 0) {
//			try {
//				Class<?> c=Class.forName("lvls.lvl"+(ui.its[i].w.eventkey-1000));
//				Object o=c.newInstance();
//				Method m=c.getMethod("onpick",wupin.class);
//				m.invoke(o,w);	
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} 
		game.onuse =w;
		// System.out.print(game.onuse.name);
		ui.its[i].setStyle("-fx-background-color:grey");
		//ui.its[i].setBackground(ui.backg);
		ui.its[i].onuse = 1;
		onusename = ui.its[i].getText();
		//if(ui.its[i].w.type==4&&ui.mospresf==1) {
		if(ui.mospresf==1) {
			wupinuse.usewupin();
		}
	}

	public void unuse(wupin w,int i) {
		try {
			Class<?> c=Class.forName("wupin."+w.pinyin+w.id);
			Object o=c.newInstance();
			Method m=c.getMethod("unuse",wupin.class,int.class);
			m.invoke(o,w,i);	
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		try {
			wupinuse.onuse=0;
			wupinuse.timeline.stop();
			wupinuse.timeline=null;
			}catch(Exception e) {}	
		ui.digger.stop();
		wupinuse.unusewupin();
		game.onuse=null;
		ui.its[i].setStyle("-fx-background-color:lightgrey");
		//ui.its[i].setBackground(ui.backlg);
		ui.its[i].onuse=0;
	}
}
