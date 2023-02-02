package br;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import lvlc.level;
import minigame.makechargame;
import minigame.makewallgame;
import model.drop;
import model.wupin;
import sub.container;
import sub.videotoascii;
public class keylisten implements EventHandler<KeyEvent>{
	
	static Timeline move;
	static int canmovef=1;
	static EventHandler<ActionEvent> mov;
	keylisten(){
		mov = e -> {
			if(game.stopf==0) {
			if (ui.w == 1&&game.stopf==0)
				level.mapmove(1);
			if (ui.s == 1&&game.stopf==0)
				level.mapmove(2);
			if (ui.a == 1&&game.stopf==0)
				level.mapmove(3);
			if (ui.d == 1&&game.stopf==0)
				level.mapmove(4);
			//只往一个方向移动
			//ui.hide();
			}	
		};
		move= new Timeline(new KeyFrame(Duration.ZERO, mov),
				new KeyFrame(Duration.millis(br.status.speed*1),e->{
					if(ui.w+ui.a+ui.s+ui.d<2) {
						move.jumpTo(Duration.millis(br.status.speed*1.5));
					}
				}),
				new KeyFrame(Duration.millis(br.status.speed*0.4)));
		move.setCycleCount(Timeline.INDEFINITE);
		move.setAutoReverse(true);
	}
	public void handle(KeyEvent e) {
		
		if (game.stopf == 0) {
			if(e.getCode()==KeyCode.DIGIT1) {
				int id=ui.kuaijies[0].bagid;
				ui.clickbagitem.u(id);
			}
			if(e.getCode()==KeyCode.DIGIT2) {
				int id=ui.kuaijies[1].bagid;
				ui.clickbagitem.u(id);
			}
			if(e.getCode()==KeyCode.DIGIT3) {
				int id=ui.kuaijies[2].bagid;
				ui.clickbagitem.u(id);
			}
			if (e.getCode() == KeyCode.C) {
				int[] down = ui.downfrommap();
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						String key = down[0] + "," + down[1] + "," + down[2] + "," + (down[3] + i) + ","
								+ (down[4] + j);
						drop d = ui.drops.get(key);
						if (d != null) {
							HashMap<wupin, Integer> wm = d.w;
							Iterator<Entry<wupin, Integer>> it = wm.entrySet().iterator();
							while (it.hasNext()) {
								Entry<wupin, Integer> next = it.next();
								wupin w = next.getKey();
								if(w.eventkey!=0) {
									try {
										Class<?> c=Class.forName("lvls"+game.lvlat/100+".lvl"+game.lvlat);
										Object o=c.newInstance();
										Method m=c.getMethod("on",wupin.class);
										m.invoke(o,w);		
									} catch (Exception e1) {
										e1.printStackTrace();
									}
								}
								container.exchange(w,next.getValue());
								ui.drops.remove(key);
							}
							if (ui.containeropenf == 1) {
								ui.othermenu.setContent(ui.imagetoascii);
								ui.containeropenf = 0;
							}
							game.refwupininfo();
							wupinlist.f();
						}
						if (br.game.map[ui.yi / 2 + i][ui.xi / 2 + j] == 2) {
							ui.b[ui.yi / 2 + i][ui.xi / 2 + j].setText("");
							int a1 = (ui.yi / 2 + i + br.game.posy + 100) / 100 * 3
									+ (ui.xi / 2 + j + br.game.posx + 100) / 100,
									a2 = (ui.yi / 2 + i + br.game.posy + 100) % 100,
									a3 = (ui.xi / 2 + j + br.game.posx + 100) % 100;
							br.game.bm[a1][a2][a3] = 0;
						}
					}
				}
			}
			if (e.getCode() == KeyCode.W) {
				if (ui.w == 0&&canmovef==1) {
					level.mapmove(1);
					canmovef=0;
					Timeline stopmove=new Timeline(new KeyFrame(Duration.millis(br.status.speed*1),e1->{canmovef=1;}));
					stopmove.setCycleCount(1);
					stopmove.play();
					move.jumpTo(Duration.millis(br.status.speed*1/9));
				}
				ui.w = 1;
				if(move.getStatus()!=Animation.Status.RUNNING)
					move.play();
			}
			if (e.getCode() == KeyCode.S) {
				if (ui.s == 0&&canmovef==1) {
					level.mapmove(2);
					canmovef=0;
					Timeline stopmove=new Timeline(new KeyFrame(Duration.millis(br.status.speed*1),e1->{canmovef=1;}));
					stopmove.setCycleCount(1);
					stopmove.play();
					move.jumpTo(Duration.millis(br.status.speed*1/9));
				}
				ui.s = 1;
				if(move.getStatus()!=Animation.Status.RUNNING)
					move.play();
			}
			if (e.getCode() == KeyCode.A) {
				if (ui.a == 0&&canmovef==1) {
					level.mapmove(3);
					canmovef=0;
					Timeline stopmove=new Timeline(new KeyFrame(Duration.millis(br.status.speed*1),e1->{canmovef=1;}));
					stopmove.setCycleCount(1);
					stopmove.play();
					move.jumpTo(Duration.millis(br.status.speed*1/9));
				}
				ui.a = 1;
				if(move.getStatus()!=Animation.Status.RUNNING)
					move.play();
			}
			if (e.getCode() == KeyCode.D) {
				if (ui.d == 0&&canmovef==1) {
					level.mapmove(4);
					canmovef=0;
					Timeline stopmove=new Timeline(new KeyFrame(Duration.millis(br.status.speed*1),e1->{canmovef=1;}));
					stopmove.setCycleCount(1);
					stopmove.play();
					move.jumpTo(Duration.millis(br.status.speed*1/9));
				}
				ui.d = 1;
				if(move.getStatus()!=Animation.Status.RUNNING)
					move.play();
			}

			if (e.getCode() == KeyCode.F3) {
				if (ui.f3f == 0) {
					ui.maininfo1.getChildren().add(ui.f3a = new TextArea());
					ui.f3a.setBackground(ui.backbl);
					ui.f3a.setStyle("-fx-text-color:white;-fx-control-inner-background:black");
					ui.f3a.setEditable(false);
					ui.f3f = 1;
				} else {
					ui.f3f = 0;
					ui.maininfo1.getChildren().remove(ui.f3a);
				}
			}
			if (e.getCode() == KeyCode.F5) {
				ui.stages.put("chargame", new makechargame());
				ui.stages.get("chargame").show();
			}
			if (e.getCode() == KeyCode.F6) {
				ui.stages.put("wallgame", new makewallgame());
				ui.stages.get("wallgame").show();
			}
			if (e.getCode() == KeyCode.F8) {
				ui.stages.put("video", new videotoascii());
				ui.stages.get("video").show();
			}
			if (e.getCode() == KeyCode.F9) {
				if (ui.showmidif == 0) {
					ui.maininfo1.getChildren().add(ui.midiplayer);
					ui.showmidif = 1;
				} else {
					ui.showmidif = 0;
					ui.maininfo1.getChildren().remove(ui.midiplayer);
				}
			}
			if (e.getCode() == KeyCode.F10) {
				if (ui.touxiangf == 0) {
					ui.maininfo1.getChildren().add(ui.touxz = new TextField(sub.imagetoascii.base));

					for (int i = 0; i < 9; i++) {
						ui.maininfo1.getChildren().add(ui.sb[i] = new Slider());
						ui.sb[i].setOnMouseEntered(e1 -> {
							ui.adjusttouxiangf = 1;
						});

						ui.sb[i].setOnMouseExited(e1 -> {
							ui.adjusttouxiangf = 0;
						});
					}
					ui.sb[0].setValue(20);
					ui.sb[1].setValue(20);
					ui.sb[2].setValue(20);
					ui.sb[4].setValue(100);
					ui.sb[6].setValue(100);
					ui.sb[7].setValue(20);
					ui.sb[8].setValue(20);
					ui.opentou = new TextField();
					ui.maininfo1.getChildren().add(ui.opentou);
					ui.changetou = new TextField();
					ui.maininfo1.getChildren().add(ui.changetou);
					ui.maininfo1.getChildren().add(ui.refreashtoub = new Button("刷新"));
					ui.maininfo1.getChildren().add(ui.touxs = new TextArea());
					ui.touxs.setPrefHeight(200);
					String path = System.getProperty("user.dir");
					// String path=initial.f.getAbsolutePath()+"\touxiang";
					path += "/touxiang";
					// new p(path);
					File f = new File(path);
					ui.ts = f.list();
					for (String s : ui.ts) {
						ui.touxs.appendText(s + "\n");
					}
					ui.refreashtoub.setOnMouseClicked(e2 -> {
						ui.touxs.setText(null);
						ui.ts = f.list();
						for (String s : ui.ts) {
							ui.touxs.appendText(s + "\n");
						}
					});

					ui.changetou.setOnKeyReleased(e1 -> {
						String s = ui.changetou.getText();
						s += ".txt";
						for (String s1 : ui.ts) {
							if (s1.equals(s)) {
								String path2 = System.getProperty("user.dir");
								path2 += "/touxiang/";
								ui.imagetoascii.setText(rw.reads(path2 + s));
							}
						}
					});
					ui.opentou.setOnKeyReleased(e1 -> {
						String s = ui.opentou.getText();
						String s2 = s + ".jpg";
						String s3 = s + ".jpeg";
						String s4 = s + ".png";
						for (String s1 : ui.ts) {
							if (s1.equals(s2)) {
								sub.imagetoascii.pic = "./touxiang/" + s2;
							}
							if (s1.equals(s3)) {
								sub.imagetoascii.pic = "./touxiang/" + s3;
							}
							if (s1.equals(s4)) {
								sub.imagetoascii.pic = "./touxiang/" + s4;
							}
						}
					});
					ui.maininfo1.getChildren().add(ui.savetou = new Button("保存"));
					ui.savetou.setOnMouseClicked(e2 -> {
						rw.writes("./touxiang/" + ui.opentou.getText() + ".txt", ui.imagetoascii.getText());
					});
					ui.touxiangf = 1;
				} else {
					ui.touxiangf = 0;
					ui.maininfo1.getChildren().clear();
				}
			}
		}
	}
}