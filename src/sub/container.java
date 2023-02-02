package sub;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import br.game;
import br.p;
import br.ui;
import br.wupinlist;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.bagitembutton;
import model.drop;
import model.wupin;

public class container extends Pane {
	static int changeid;
	static Button back;
	static TextField tf;
	static ScrollPane sp;
	static VBox v;
	static GridPane itb;
	static bagitembutton[] in = new bagitembutton[1000];
	static bagitembutton[] out = new bagitembutton[100],
			its = new bagitembutton[100];
	public static HashMap<wupin, Integer> wm;

	public container() {
		this.getChildren().add(v = new VBox());
		v.getChildren().add(sp = new ScrollPane());
		sp.setContent(itb = new GridPane());
		itb.setVgap(2);
		itb.setHgap(4);
		v.getChildren().add(tf = new TextField("存取数量(默认1)"));
		tf.setFont(ui.afont);
		tf.setOnMouseEntered(e -> {
			tf.requestFocus();
			ui.w = 0;
			ui.s = 0;
			ui.a = 0;
			ui.d = 0;
		});
		v.getChildren().add(back = new Button("关闭"));
		back.setFont(ui.afont);
		back.setOnMouseClicked(e -> {
			close();
		});
	}

	void close() {
		ui.othermenu.setContent(ui.imagetoascii);
		ui.containeropenf = 0;
		for (int k = 0; k < in.length; k++) {
			if (in[k] != null) {
				ui.itb.getChildren().remove(in[k]);
			}
		}
		wupinlist.f();
		ui.zhu.requestFocus();
	}

	/// 容器中的按钮
	public void makeoutbutton(String key) {
		drop d = ui.drops.get(key);
		sub.container.itb.getChildren().clear();
		wm = d.w;
		Iterator<Entry<wupin, Integer>> it = wm.entrySet().iterator();
		// 遍历掉落物
		for (int k = 0; it.hasNext(); k++) {
			Entry<wupin, Integer> next = it.next();
			wupin w = next.getKey();
			
			Integer amount=game.bag.containsKey(w)?game.bag.get(w):0;
			Integer amount1=next.getValue();
			sub.container.itb.add(sub.container.its[k] = new bagitembutton(w.name,w), 1, k);
			sub.container.its[k].setFont(ui.bfont);
			sub.container.its[k].setPadding(new Insets(0, 0, 0, 0));
			sub.container.its[k].setBackground(ui.backlg);
			sub.container.its[k].setOnMouseClicked(e2 -> {
				br.game.onshow = w;
				//new p(br.game.onshow.name+"\n");
				sub.wupininfo.infov = br.game.onshow.getAll();
				wupininfo.posf=2;
				ui.wupininfo = new wupininfo();
				ui.othermenu.setContent(ui.wupininfo);
				if(w.eventkey!=0) {
					try {
						Class<?> cls=Class.forName("lvls"+game.lvlat/100+".lvl"+game.lvlat);
						Object o=cls.newInstance();
						Method m=cls.getMethod("on",wupin.class);
						m.invoke(o,w);		
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});

			sub.container.itb.add(sub.container.out[k] = new bagitembutton("拿取",w), 0, k);
			sub.container.out[k].setFont(ui.bfont);
			sub.container.out[k].setPadding(new Insets(0, 0, 0, 0));
			sub.container.out[k].setBackground(ui.backlg);
			sub.container.out[k].setOnMouseClicked(e3 -> {
				for (int t = 0; t < sub.container.out.length && sub.container.out[t] != null; t++)
					if (e3.getSource() == sub.container.out[t])
						sub.container.changeid = t;
				int n = 1;
				try {
					n = Integer.parseInt(sub.container.tf.getText());
				} catch (Exception eee) {}
				//wupin w1 = sub.container.out[sub.container.changeid].w;
				
				if (n <= amount1) {
					// 判断物品是否相同
					if (w.type<3) {
						d.w.put(w, amount1-n);
						game.bag.put(w, amount+n);
					}
					else {
						d.w.remove(w);
						game.bag.put(w,1);
					}
					// new p(br.game.bag[br.container.changeid].amount);
				} else {
					if (w.type<3) {
						d.w.remove(w);
						game.bag.put(w, amount1+amount);
					}
					else {
						d.w.remove(w);
						game.bag.put(w,1);
						
					}
				}
				if(w.eventkey!=0) {
					try {
						Class<?> cls=Class.forName("lvls"+game.lvlat/100+".lvl"+game.lvlat);
						Object o=cls.newInstance();
						Method m=cls.getMethod("on",wupin.class);
						m.invoke(o,w);		
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				makeinbutton(key);
				makeoutbutton(key);
				wupinlist.f();
			});

		}
		// if (br.container.itb.getChildren().isEmpty()) {
		// br.ui.container.close();
		// }
	}

	// 背包的按钮变化
	public void makeinbutton(String key) {
		drop d = ui.drops.get(key);
		wupinlist.f();
		int i=0;
		for (wupin w:game.bag.keySet()) {

				sub.container.in[i] = new bagitembutton("存入",w);
				ui.itb.add(sub.container.in[i], 0, i);
				sub.container.in[i].setOnMouseClicked(e1 -> {
						int n = 1;
						try {
							n = Integer.parseInt(sub.container.tf.getText());
						} catch (Exception eee) {}
						Integer amount =game.bag.containsKey(w)?game.bag.get(w):0;
						Integer amount1=d.w.containsKey(w)?d.w.get(w):0;
						if (n <= amount) {
							// 判断物品是否相同
							if (w.type<3) {
								d.w.put(w, amount1+n);
								game.bag.put(w, amount-n);
							}
							else {
								d.w.put(w,1);
								game.bag.remove(w);
							}
							// new p(br.game.bag[br.container.changeid].amount);
						} else {
							if (w.type<3) {
								d.w.put(w, amount1+amount);
								game.bag.remove(w);
							}
							else {
								ui.drops.get(key).w.put(w,1);
								game.bag.remove(w);
								
							}
						}
							wupinlist.f();
							makeoutbutton(key);
							makeinbutton(key);				
				});
				sub.container.in[i].setBackground(ui.backlg);
				sub.container.in[i].setPadding(new Insets(0, 0, 0, 0));
				sub.container.in[i].setFont(ui.bfont);
				i++;
			}
		}
	
	public static int exchange(wupin w,int n) {
		int amount=game.bag.containsKey(w)?game.bag.get(w):0;
		if(w.type<3) {
			int i=amount+n;
			if(i>=0) {game.bag.put(w,i);return i;}
			else {game.bag.remove(w);return 0;}
		}
		else {
			int i=amount+n;
			if(i>=0) {game.bag.put(w,1);return 1;}
			else {game.bag.remove(w);return 0;}
		}
	}
	
}
