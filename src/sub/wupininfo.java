package sub;

import br.clickbagitem;
import br.game;
import br.p;
import br.ui;
import br.wupinlist;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.drop;
import model.wupin;

public class wupininfo extends Pane {
	public static int posf;
	public static GridPane info1, info2;
	public static VBox vb;
	public static Button gai, drop;
	public static TextArea te,fu;
	public static TextField m;
	public static Label[] vl = new Label[10], v = new Label[10];
	// id,type,amount,value,attack,defense,eventkey,waerposotion,usetime
	public static String[] valuename = { "类型", "数量", "价格", "攻击", "防御", "重量", "使用速度", "穿戴位置" };
	public static int[] infov;

	public wupininfo() {

		vb = new VBox();
		info1 = new GridPane();
		if(posf==1)
			infov[1]=game.bag.containsKey(game.onshow)?game.bag.get(game.onshow):0;
		else if(posf==2)
			infov[1]=container.wm.containsKey(game.onshow)?container.wm.get(game.onshow):0;
		for (int i = 0, j = 0; i < 6; i++) {
			if (i == 0) {
				String s = null;
				int k = infov[0];
				if (k == 0)
					s = "文本";
				if (k == 1)
					s = "材料";
				if (k == 2)
					s = "消耗品";
				if (k == 3)
					s = "道具";
				if (k == 4)
					s = "武器";
				if (k == 5)
					s = "护甲";
				// type:0.文本，堆叠999 1.材料，堆叠999；2.消耗品，堆叠999；3道具，不堆叠 4.武器，不堆叠；5.护甲，不堆叠；
				info1.add(vl[i] = new Label(valuename[i] + " "), j * 2 % 4, j * 2 / 4);
				vl[i].setFont(ui.bfont);
				info1.add(v[i] = new Label(s + "  "), (j * 2 + 1) % 4, (j * 2 + 1) / 4);
				v[i].setFont(ui.bfont);
				j++;
				
			} else if (infov[i] != 0) {
				
				info1.add(vl[i] = new Label(valuename[i] + " "), j * 2 % 4, j * 2 / 4);
				vl[i].setFont(ui.bfont);
				info1.add(v[i] = new Label(String.valueOf(infov[i]) + "  "), (j * 2 + 1) % 4, (j * 2 + 1) / 4);
				v[i].setFont(ui.bfont);
				j++;
			}
		}
		info2 = new GridPane();
		if (infov[6] != 0) {
			info2.add(vl[6] = new Label(valuename[6] + " "), 0, 1);
			vl[6].setFont(ui.bfont);
			info2.add(v[6] = new Label(String.valueOf(infov[6]) + "  "), 1, 1);
			v[6].setFont(ui.bfont);
		}
		String s = null;
		int i = infov[7];
		if (i == 0)
			s = "不可穿戴";
		if (i == 1)
			s = "戒指";
		if (i == 2)
			s = "头";
		if (i == 3)
			s = "项链";
		if (i == 4)
			s = "左手";
		if (i == 5)
			s = "护甲";
		if (i == 6)
			s = "右手";
		if (i == 7)
			s = "左腿";
		if (i == 8)
			s = "背后";
		if (i == 9)
			s = "右腿";
		if (i == 10)
			s = "四肢";
		if (i == 11)
			s = "双手同时使用";
		if (i == 12)
			s = "双手皆可";
		if (i == 13)
			s = "双腿同时";
		if (i == 14)
			s = "背后护甲皆可";
		if (i == 15)
			s = "头项链戒指皆可";
		if (i == 16)
			s = "所有位置同时";
		if (i == 17)
			s = "所有位置皆可";
		if (i != 0) {
			info2.add(vl[7] = new Label(valuename[7] + " "), 0, 2);
			vl[7].setFont(ui.bfont);
			info2.add(v[7] = new Label(s + "  "), 1, 2);
			v[7].setFont(ui.bfont);
		}
		s = game.onshow.name;
		s = s.replaceAll("\\[\\]\\[", " ");
		s = s.replaceAll("\\]\\[\\]", "\n");
		m = new TextField(s);
		
		m.setStyle("-fx-text-inner-color:white;-fx-control-inner-background:black;");
		m.setFont(ui.bfont);
		vb.getChildren().add(m);
		vb.getChildren().add(info1);
		vb.getChildren().add(info2);
		gai = new Button("保存描述并关闭");
		vb.getChildren().add(gai);
		gai.setStyle("-fx-background-color:black");
		gai.setTextFill(Color.WHITE);
		gai.setFont(ui.bfont);
		gai.setOnMouseClicked(e -> {
			if (ui.containeropenf == 0&&ui.its[clickbagitem.it].w != null) {
				String s1 = m.getText(), s2 = te.getText();
				s1 = s1.replaceAll(" ", "\\[\\]\\[");
				s1 = s1.replaceAll("\n", "\\]\\[\\]");
				s2 = s2.replaceAll(" ", "\\[\\]\\[");
				s2 = s2.replaceAll("\n", "\\]\\[\\]");
				ui.its[clickbagitem.it].w.name = s1;
				ui.its[clickbagitem.it].w.text = s2;
			}
			if(ui.containeropenf == 1)
				ui.othermenu.setContent(ui.container);
			else
				ui.othermenu.setContent(ui.imagetoascii);
			});
		
		te = new TextArea();
		te.setStyle("-fx-text-color:white;-fx-control-inner-background:black;");
		te.setFont(ui.afont);
		te.setPrefHeight(100);
		vb.getChildren().add(te);
		s = game.onshow.text;
		s = s.replaceAll("\\[\\]\\[", " ");
		s = s.replaceAll("\\]\\[\\]", "\n");
		te.setText(s);

		fu = new TextArea();
		fu.setStyle("-fx-text-color:white;-fx-control-inner-background:black;");
		fu.setFont(ui.afont);
		fu.setPrefHeight(100);
		vb.getChildren().add(fu);
		s = game.onshow.fumo;
		s = s.replaceAll("\\[", "");
		s = s.replaceAll("\\]", "");
		s = s.replaceAll(",","\n");
		fu.setText(s);
		
		drop = new Button("全部丢掉");
		drop.setStyle("-fx-background-color:black");
		drop.setTextFill(Color.WHITE);
		drop.setFont(ui.bfont);
		drop.setOnMouseClicked(e -> {
			int px = 0, py = 0;
			if (game.posx +(int)ui.xi/2< 0)
				px--;
			else if (game.posx +(int)ui.xi/2> 99)
				px++;
			if (game.posy +(int)ui.yi/2< 0)
				py--;
			else if (game.posy +(int)ui.yi/2> 99)
				py++;
			if (game.bm[4 + 3 * py + px][game.posy+(int)ui.yi/2 - py * 100][game.posx+(int)ui.xi/2 - px * 100] == 0&&ui.containeropenf==0) {
				//new p(1);
				game.bm[4 + 3 * py + px][game.posy+(int)ui.yi/2 - py * 100][game.posx+(int)ui.xi/2 - px * 100] = 2;
				//new p((4 + 3 * py + px)+"\n"+(game.posy - py * 100)+"\n"+(game.posx - px * 100));
				//game.map[(int)ui.yi/2][(int)ui.xi/2]=2;
				wupin w = game.onshow;
				
				wupin[] ws = {w};
				drop d = new drop(ws,new int[] {game.bag.get(w)});
				game.bag.remove(w);
				int[] down = ui.downfrommap(game.lvlat, game.mapy, game.mapx, game.posy+(int)ui.yi/2, game.posx+(int)ui.xi/2, 0, 0);
				String key = down[0] + "," + down[1] + "," + down[2] + "," + down[3] + "," + down[4];
				ui.drops.put(key, d);
			}
			wupinlist.f();
		});
		vb.getChildren().add(drop);
		this.getChildren().add(vb);
		setPrefWidth(80);
	}
}