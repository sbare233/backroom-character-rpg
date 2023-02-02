package br;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.FloatMap;
import javafx.util.Duration;
import lvlc.level;
import sub.imagetoascii;
import sub.midiplayer1;

public class timer1 implements EventHandler<ActionEvent>{
	static int speed=100;
	public void handle(ActionEvent e) {
		//mob.actall();
		level.mapmove(5);
		if(status.speed!=speed) {
			speed=status.speed;
			keylisten.move.stop();
			keylisten.move=new Timeline(new KeyFrame(Duration.millis(br.status.speed), keylisten.mov));
			keylisten.move.setCycleCount(Timeline.INDEFINITE);
			keylisten.move.setAutoReverse(true);
		}
		if (ui.adjusttouxiangf == 1) {
			try {
				sub.imagetoascii.base = ui.touxz.getText();
				sub.imagetoascii.r1 = (float) ui.sb[0].getValue() / 100;
				sub.imagetoascii.g1 = (float) ui.sb[1].getValue() / 100;
				sub.imagetoascii.b1 = (float) ui.sb[2].getValue() / 100;
				sub.imagetoascii.x1 = ui.sb[3].getValue() / 100;
				sub.imagetoascii.x2 = ui.sb[4].getValue() / 100;
				sub.imagetoascii.y1 = ui.sb[5].getValue() / 100;
				sub.imagetoascii.y2 = ui.sb[6].getValue() / 100;
				sub.imagetoascii.x3 = ui.sb[7].getValue() / 100;
				sub.imagetoascii.y3 = ui.sb[8].getValue() / 100;

				ui.imagetoascii = new imagetoascii();
				ui.imagetoascii.setFont(ui.dfont);
				ui.othermenu.setContent(ui.imagetoascii);
				ui.imagetoascii.setPrefSize(ui.othermenu.getWidth(),ui. othermenu.getHeight());
				ui.imagetoascii.setBackground(ui.backbl);
				ui.imagetoascii.setStyle("-fx-text-color:white;-fx-control-inner-background:black;");
			} catch (Exception e3) {
			}
		}
		//new p(fx.fxm.size()+"\n");
		if(fx.fxm.size()<1) {
			fx.timelines.clear();
			//fx.fxs.clear();
			fx.fxm.clear();
			fx.fxnamecount.clear();
		}
		if (game.stopf == 0) {
			if(ui.niuquf==1) {
				int w = 200-ui.savetime;
				int h = 200-ui.savetime;
				if(ui.savetime>50) {
					w = 100+ui.savetime;
					h = 100+ui.savetime;
		        }
		        FloatMap map = new FloatMap();
		        map.setWidth(w);
		        map.setHeight(h);
		        for (int i = 0; i < w; i++) {
		            double v1 = (Math.sin(i / 50.0 * Math.PI) - 0.5) / 40.0;
		            
		            for (int j = 0; j < h; j++) {
		            	double v2 = (Math.sin(j / 50.0 * Math.PI) - 0.5) / 40.0;
		                map.setSamples(i, j, (float)v2, (float)v1);
		            }
		        }
		        DisplacementMap dm = new DisplacementMap();
		        dm.setMapData(map);
		        ui.all.setEffect(dm);
			}
			
			if (ui.f3f == 1) {
				ui.f3a.setText("mapy" + br.game.mapy + "    " + "mapx" + br.game.mapx + "\n" + "posy" + br.game.posy
						+ "    " + "posx" + br.game.posx + "\n" + "usey" + ui.usey + "   " + "usex" + ui.usex + "\n"+
						"lvl"+game.lvlat+"\n"+"mosx"+ui.mosx+"    "+"mosy"+ui.mosy+"\n"+"pointatid"+game.map[(int)ui.mosy/40][(int)ui.mosx/40]+"\n"+
						"maposy"+level.mapos[1]+"   "+"maposx"+level.mapos[2]+"\n"+
						"maposyy"+level.mapos[3]+"   "+"maposxx"+level.mapos[4]);
			}
			if (sub.midiplayer.onplayf == 1 && ui.showmidif == 1) {
				double d = (double) midiplayer1.player.getMicrosecondPosition()
						/ (double) midiplayer1.player.getMicrosecondLength();
				ui.midiplayer.progress.setValue(d);// 设置播放文件显示当前播放进度
			}
			if (ui.savetime == 20) {
				rw.saverenwu(initial.f);// 自动保存
				ui.savetime = 0;
			}
			ui.savetime++;

			if (ui.recblinkf == 0) {
				ui.all.getChildren().add(ui.cr);
				ui.all.getChildren().add(ui.labelrec);
			}
			ui.recblinkf++;
			if (ui.recblinkf == 6) {
				ui.all.getChildren().remove(ui.cr);
				ui.all.getChildren().remove(ui.labelrec);
			}
			if (ui.recblinkf == 10) {
				ui.recblinkf = 0;
			}
			if (ui.mapwidth != (int) ui.zhu.getWidth() || ui.mapheight != (int) ui.zhu.getHeight()) {
				if (ui.adedf == 0) {
					ui.mapwidth = (int) ui.zhu.getWidth();
					ui.mapheight = (int) ui.zhu.getHeight();
					level.mapadjust();
					ui.adedf = 1;
				} else {
					ui.mapwidth = (int) ui.zhu.getWidth();
					ui.mapheight = (int) ui.zhu.getHeight();
					level.mapadjust();
					ui.adedf--;
				}
			}
		}
	}
}
