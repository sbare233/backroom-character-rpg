package br;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import lvlc.level;
import model.bagitembutton;
import model.drop;
import model.mob;
import model.questbutton;
import model.wupin;
import sub.bot;
import sub.container;
import sub.imagetoascii;
import sub.midiplayer;
import sub.midiplayer1;
import sub.setting;
import sub.wupininfo;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;

public class ui extends Application {
	// static final String[]
	// font=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	public static Dimension dim;
	public static Scene scene;
	// static actp actp;
	public static game game;
	// static shez shez;
	public static String[] ts;
	public static String[] wears = {"戒指", "头部", "项链", "左手", "护甲", "右手", "左腿", "背包", "右腿" };
	public static ObservableList<String> midis;
	public static int xi,yi;
	public static int w,s,a,d;
	public static int mapwidth;
	public static int mapheight;
	public static int savetime = 1;
	public static int usex;
	public static int usey;
	public static int usexl;
	public static int useyl;
	public static int adedf, speakedf, craftpycf, wearycf, kuaijieycf, bagopf = 1, usef, diggedf, firstspeakf, craftsizef,
			recblinkf, containeropenf, f3f, showmidif, questopf,adjusttouxiangf, touxiangf,
			showshezhif,niuquf,mospresf,cursortf;
	public static double red, green, blue,mosx,mosy,cursort=1,ag;
	public static int[] craftv = new int[16];
	public static Slider[] sb = new Slider[9];
	public static SplitPane zuoyou, youinfo, zhudh, wupins;
	public static Pane floor,zhu, infoup, itemp, dop, middle,fxpane;
	public static StackPane all,uip;
	public static FlowPane access, infosubmit;
	public static BorderPane info, wupin;
	public static VBox maininfo, maininfo1, leftmenu;
	public static HBox leftmenu1;
	public static TextArea f3a, touxs;
	public static TextField name, searchitem, speak, craftnumber, changetou, opentou, touxz;
	public static ScrollPane dhs, items, othermenu, quests;
	public static ComboBox<String> ffont;
	public static Button order, shezhi, buff, craftb, crafty, kuaijieb, weard, bagb, questb, savetou, refreashtoub;
	public static bagitembutton[] cft = new bagitembutton[16], wearb = new bagitembutton[9], kuaijies = new bagitembutton[3];
	public static bagitembutton[] its = new bagitembutton[1000];
	public static questbutton[] qts = new questbutton[1000];
	public static Label[][] b = new Label[100][150];
	public static Group[][] g=new Group[100][150];
	public static Color c;
	public static Label hp, sn, mp, weight, p, lvlinfo, u, labelrec,stopl1,stopl2;
	public static Background backtm = new Background(new BackgroundFill(new Color(0,0,0,0), null, null));
	public static Background backbl = new Background(new BackgroundFill(Color.BLACK, null, null));
	public static Background backlg = new Background(new BackgroundFill(Color.LIGHTGREY, null, null));
	public static Background backg = new Background(new BackgroundFill(Color.GREY, null, null));
	public static Background backwt = new Background(new BackgroundFill(Color.WHITE, null, null));
	//static GridPane map;
	public static GridPane  craftp, wearp, mdbox, infospeak, itb, questgp, kuaijie,dh;
	public static Font bfont = new Font("Dialog", 30), afont = new Font("Dialog", 20), cfont = new Font("Dialog", 10),
			dfont = new Font("Dialog", 5);
	public static HashMap<String, Stage> stages = new HashMap<String, Stage>();
	public static HashMap<String, drop> drops = new HashMap<String, drop>();
	public static HashMap<String, ImageCursor> cursors=new HashMap<String, ImageCursor>();
	public static HashMap<Integer, Integer> hidelist=new HashMap<Integer, Integer>();
	
	public static clickbagitem clickbagitem = new clickbagitem();
	public static Circle cr;
	public static Rectangle rrr, hps, mps, sans;
	public static wupininfo wupininfo;
	public static container container;
	public static midiplayer midiplayer;
	public static imagetoascii imagetoascii;
	setting setting;
	skill skill;
	keylisten keylisten;
	clickwear clickwear;
	timer1 timer1;
	 static Timeline digger;
	

	public void start(Stage primaryStage) {
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});
		//map = new GridPane();
		othermenu = new ScrollPane();
		othermenu.setBackground(backbl);
		othermenu.setStyle("-fx-background:black");
		// othermenu.setContent(imagetoascii=new imagetoascii());

		wupin = new BorderPane();
		all = new StackPane();
		floor = new Pane();
		//floor.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, null, null)));
		floor.setBackground(backbl);
		all.getChildren().add(floor);
		zhu = new Pane();
		//zhu.setBackground(backbl);
		all.getChildren().add(zhu);
		fxpane = new Pane();
		
		//fxpane.setBackground(backtm);
		all.getChildren().add(fxpane);
		dh = new GridPane();
		dh.setBackground(backbl);
		dh.setStyle("-fx-text-color:white;-fx-control-inner-background:black");
		
		dhs = new ScrollPane(dh);
		dhs.setStyle("-fx-background:black");
		//dhs.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> dhs.setVvalue(1));

		
		info = new BorderPane();

		zhudh = new SplitPane();
		zhudh.setOrientation(Orientation.VERTICAL);
		zhudh.getItems().add(all);
		zhudh.getItems().add(dhs);
		
		wupins = new SplitPane();
		wupins.setOrientation(Orientation.VERTICAL);
		wupins.getItems().add(othermenu);
		wupins.getItems().add(wupin);
		wupins.setBackground(backbl);

		zuoyou = new SplitPane();
		zuoyou.setOrientation(Orientation.HORIZONTAL);
		zuoyou.getItems().add(wupins);
		zuoyou.getItems().add(zhudh);
		//zuoyou.setStyle("-fx-background:transparent;-fx-background-inner-color:transparent;");

		youinfo = new SplitPane();
		youinfo.setOrientation(Orientation.HORIZONTAL);
		youinfo.getItems().add(zuoyou);
		youinfo.getItems().add(info);
		//youinfo.setStyle("-fx-background:transparent;");
		maininfo = new VBox();
		info.setTop(infoup = new Pane(maininfo));
		maininfo.setPrefSize(dim.width / 8, dim.height / 3);
		maininfo.getChildren().add(name = new TextField("你的名字"));
		name.setPrefSize(dim.width / 10, dim.height / 40);
		name.setFont(afont);
		name.setBackground(backbl);
		name.setStyle("-fx-text-inner-color:white;");

		maininfo.getChildren().add(hp = new Label("生命  100/100"));
		hp.setFont(afont);
		hp.setTextFill(Color.color(1, 0.3, 0.5));
		maininfo.getChildren().add(hps = new Rectangle(0, 0, 200, 30));
		hps.setFill(new Color(1, 0.2, 0.2, 1));

		maininfo.getChildren().add(sn = new Label("意志  100/100"));
		sn.setFont(afont);
		sn.setTextFill(Color.color(0.5, 0.4, 0.5));
		maininfo.getChildren().add(sans = new Rectangle(0, 0, 200, 30));
		sans.setFill(new Color(0.5, 0.4, 0.5, 1));

		maininfo.getChildren().add(mp = new Label("魔力  100/100"));
		mp.setFont(afont);
		mp.setTextFill(Color.color(0.4, 0.4, 1));
		maininfo.getChildren().add(mps = new Rectangle(0, 0, 200, 30));
		mps.setFill(new Color(0.4, 0.4, 1, 1));

		maininfo.getChildren().add(weight = new Label("负重  100/100"));
		weight.setTextFill(Color.color(0.8, 0.8, 0.8));
		weight.setFont(afont);

		info.setBackground(backbl);
		info.setCenter(maininfo1 = new VBox());

		info.setBottom(infospeak = new GridPane());
		speak = new TextField();
		speak.setBackground(backbl);
		speak.setStyle("-fx-text-inner-color:white;");
		infospeak.add(infosubmit = new FlowPane(), 0, 1);

		infosubmit.setBackground(backbl);
		infosubmit.getChildren().add(order = new Button("说话"));
		order.setFont(bfont);
		order.setPadding(new Insets(0, 0, 0, 0));
		order.setBackground(backbl);
		order.setTextFill(Color.WHITE);
		order.setOnMouseClicked(e -> {
			bot.talk();
		});
		infosubmit.getChildren().add(buff = new Button("状态"));
		buff.setFont(bfont);
		buff.setPadding(new Insets(0, 0, 0, 0));
		buff.setBackground(backbl);
		buff.setTextFill(Color.WHITE);
		buff.setOnMouseClicked(e -> {
			if (f3f == 0) {
				maininfo1.getChildren().add(f3a = new TextArea());
				f3a.setBackground(backbl);
				f3a.setStyle("-fx-text-color:white;-fx-control-inner-background:black");
				f3a.setEditable(false);
				f3f = 1;
			} else {
				f3f = 0;
				maininfo1.getChildren().remove(f3a);
			}
		});
		infosubmit.getChildren().add(shezhi = new Button("设置"));
		shezhi.setFont(bfont);
		shezhi.setPadding(new Insets(0, 0, 0, 0));
		shezhi.setBackground(backbl);
		shezhi.setTextFill(Color.WHITE);
		infosubmit.setHgap(10);
		shezhi.setOnMouseClicked(e -> {
			if (showshezhif == 0) {
				showshezhif = 1;
				setting.show();
			} else {
				showshezhif = 0;
				setting.close();
			}
		});

		itb = new GridPane();
		itb.setVgap(2);
		itb.setHgap(4);
		items = new ScrollPane(itb);
		itb.setBackground(backbl);
		bagb = new Button("背包");
		bagb.setPadding(new Insets(0, 0, 0, 0));
		bagb.setBackground(backg);
		bagb.setFont(bfont);
		items.setPrefSize(dim.width / 9, dim.height * 3 / 4);
		items.setBackground(backlg);
		items.setStyle("-fx-background:black");

		questgp = new GridPane();
		questgp.setVgap(2);
		questgp.setHgap(4);
		quests = new ScrollPane(questgp);
		questgp.setBackground(backbl);
		questb = new Button("任务");
		questb.setPadding(new Insets(0, 0, 0, 0));
		questb.setBackground(backlg);
		questb.setFont(bfont);
		quests.setPrefSize(dim.width / 9, dim.height * 3 / 4);
		quests.setBackground(backbl);
		quests.setStyle("-fx-background:black");

		leftmenu = new VBox();
		wupin.setCenter(leftmenu);
		leftmenu.setBackground(backbl);
		leftmenu.getChildren().add(leftmenu1 = new HBox());

		leftmenu1.getChildren().add(bagb);
		leftmenu1.getChildren().add(new Rectangle(0, 0, 3, 5));
		leftmenu1.getChildren().add(questb);
		leftmenu.getChildren().add(items);
		// leftmenu.add(quests, 0, 3);
		// quests

		bagb.setOnMouseClicked(e -> {
			zhu.requestFocus();
			if (bagopf == 1) {
				leftmenu.getChildren().remove(items);
				bagb.setBackground(backlg);
				bagopf = 0;
			} else {

				leftmenu.getChildren().add(items);
				br.wupinlist.f();
				bagb.setBackground(backg);
				bagopf = 1;
				if (questopf == 1) {
					leftmenu.getChildren().remove(quests);
					questb.setBackground(backlg);
					questopf = 0;
				}
			}
		});

		questb.setOnMouseClicked(e -> {
			zhu.requestFocus();
			if (questopf == 1) {
				leftmenu.getChildren().remove(quests);
				questb.setBackground(backlg);
				questopf = 0;
			} else {

				leftmenu.getChildren().add(quests);
				questb.setBackground(backg);
				questopf = 1;
				if (bagopf == 1) {
					leftmenu.getChildren().remove(items);
					bagb.setBackground(backlg);
					bagopf = 0;
				}
			}
		});

		wupin.setBottom(middle = new Pane());
		middle.setPrefHeight(100);
		middle.getChildren().add(mdbox = new GridPane());
		mdbox.setBackground(backbl);
		mdbox.setVgap(5);
		mdbox.add(searchitem = new TextField("查找"), 0, 0);
		searchitem.setBackground(backbl);
		searchitem.setStyle("-fx-text-inner-color:white;");
		craftp = new GridPane();
		craftp.setVgap(1);
		craftp.setHgap(1);
		Label craftnl = new Label("合成数量");
		craftnl.setFont(afont);
		craftnl.setTextFill(Color.WHITE);
		craftnumber = new TextField("1");
		craftnumber.setFont(afont);
		craftnumber.setBackground(backbl);
		craftnumber.setStyle("-fx-text-inner-color:white;");
		craftp.add(craftnl, 4, 0);
		craftp.add(craftnumber, 4, 1);
		craftnumber.setOnMouseEntered(e -> {
			craftnumber.requestFocus();
			w = 0;
			s = 0;
			a = 0;
			d = 0;
		});
		craftnumber.setOnMouseExited(e -> {
			zhu.requestFocus();
		});
		wearp = new GridPane();
		wearp.setVgap(1);
		wearp.setHgap(1);
		clickwear=new clickwear();
		for (int i = 0; i < 9; i++) {
			wearb[i] = new bagitembutton();
			wearb[i].setText(wears[i]);
			wearb[i].setPadding(new Insets(0, 0, 0, 0));
			wearp.add(wearb[i], i % 3, (int) i / 3);
			wearb[i].setBackground(backg);
			wearb[i].setPrefSize(53, 53);
			wearb[i].setOnMouseClicked(clickwear);
		}
		craftsize(2);
		mdbox.add(access = new FlowPane(), 0, 3);
		access.getChildren().add(craftb = new Button("合成"));
		access.setHgap(10);
		access.setBackground(backlg);
		craftb.setFont(bfont);
		crafty = new Button("确认合成");
		craftb.setOnMouseClicked(e -> {
			zhu.requestFocus();
			if (craftpycf == 0) {
				middle.setPrefHeight(100 + 41 * craftsizef);
				mdbox.add(craftp, 0, 2);
				craftb.setText("取消");
				craftpycf = 1;
				access.getChildren().add(crafty);
				access.getChildren().remove(weard);
				access.getChildren().remove(kuaijieb);
			} else {
				craft.getallback();
				craftb.setText("合成");
				mdbox.getChildren().remove(craftp);
				middle.setPrefHeight(100);
				weard.setVisible(true);
				craftpycf = 0;
				access.getChildren().remove(crafty);
				access.getChildren().add(weard);
				access.getChildren().add(kuaijieb);
			}
		});
		craftb.setPadding(new Insets(0, 0, 0, 0));
		craftb.setBackground(backlg);

		crafty.setFont(bfont);
		crafty.setOnMouseClicked(e -> {
			zhu.requestFocus();
			craft.confirmcraft();
		});
		crafty.setPadding(new Insets(0, 0, 0, 0));
		crafty.setBackground(backlg);
		access.getChildren().add(weard = new Button("装备"));
		weard.setFont(bfont);
		weard.setPadding(new Insets(0, 0, 0, 0));
		weard.setBackground(backlg);
		weard.setOnMouseClicked(e -> {
			zhu.requestFocus();
			if (ui.wearycf == 0) {
				middle.setPrefHeight(261);
				mdbox.add(wearp, 0, 2);
				ui.weard.setText("保存");
				ui.craftb.setVisible(false);
				ui.kuaijieb.setVisible(false);
				ui.wearycf = 1;
			} else {
				ui.weard.setText("装备");
				mdbox.getChildren().remove(wearp);
				middle.setPrefHeight(100);
				ui.craftb.setVisible(true);
				ui.kuaijieb.setVisible(true);
				ui.wearycf = 0;
			}
		});
		kuaijie = new GridPane();
		kuaijie.setHgap(4);
		for (int i = 0; i < 3; i++) {
			kuaijie.add(kuaijies[i] = new bagitembutton(), i, 0);
			kuaijies[i].setText(String.valueOf(i + 1));
			kuaijies[i].setPadding(new Insets(0, 0, 0, 0));
			kuaijies[i].setBackground(backg);
			kuaijies[i].setPrefSize(53, 53);
			kuaijies[i].setFont(bfont);
			kuaijies[i].setOnMouseClicked(e -> {
				zhu.requestFocus();
				for (int j = 0; j < 3; j++)
					if (e.getSource() == kuaijies[j]) {
						if (br.game.onuse!=null) {
							if (kuaijies[j].w==null||!kuaijies[j].w.equals(br.game.onuse)) {
								kuaijies[j].bagid=br.clickbagitem.tapid;
								kuaijies[j].w=br.game.onuse;
								char[] c = {br.game.onuse.name.toCharArray()[0] };
								kuaijies[j].setText(String.valueOf(c));
								kuaijies[j].setBackground(backlg);
							} else {
								kuaijies[j].bagid=-1;
								kuaijies[j].w=null;
								kuaijies[j].setText(String.valueOf(j + 1));
								kuaijies[j].setBackground(backg);
							}
						}
					}
			});
		}
		access.getChildren().add(kuaijieb = new Button("快捷"));
		kuaijieb.setPadding(new Insets(0, 0, 0, 0));
		kuaijieb.setBackground(backlg);
		kuaijieb.setFont(bfont);
		kuaijieb.setOnMouseClicked(e -> {
			if (ui.kuaijieycf == 0) {
				middle.setPrefHeight(153);
				mdbox.add(kuaijie, 0, 2);
				ui.kuaijieb.setText("保存");
				ui.craftb.setVisible(false);
				ui.weard.setVisible(false);
				ui.kuaijieycf = 1;
			} else {
				ui.kuaijieb.setText("快捷");
				mdbox.getChildren().remove(kuaijie);
				middle.setPrefHeight(100);
				ui.craftb.setVisible(true);
				ui.weard.setVisible(true);
				ui.kuaijieycf = 0;
			}
		});

		zuoyou.setDividerPosition(0, 0.25);
		youinfo.setDividerPosition(0, 0.8);
		zhudh.setDividerPosition(0, 0.8);
		zhu.setPrefSize(1000, 800);

		all.setAlignment(Pos.TOP_LEFT);
		stopl1 = new Label("暂停状态无法切出");
		stopl2 = new Label("你不会砸瓦鲁多,你也不是咲夜");
		// rec

		cr = new Circle(0, 0, 8);
		cr.setTranslateX(20);
		cr.setTranslateY(25);
		cr.setFill(Color.RED);
		// fx.getChildren().add(cr);
		labelrec = new Label("REC");
		labelrec.setTranslateX(40);
		labelrec.setTranslateY(20);
		labelrec.setTextFill(Color.RED);
		labelrec.setFont(afont);
		
		uip=new StackPane();
		uip.getChildren().add(youinfo);
		scene = new Scene(uip, dim.width * 3 / 4, dim.height * 3 / 4);
		//scene.setFill(null);
		// scene.getStylesheets().add(getClass().getResource("br.css").toExternalForm());
		primaryStage.setScene(scene);
		stages.put("main", primaryStage);
		new wupinlist();
		
		sub.midiplayer.midis.setItems(midis);
		sub.midiplayer.midis.getSelectionModel().select("hello.mid");
		midiplayer1.songFile = sub.midiplayer.midis.getSelectionModel().getSelectedItem();
		midiplayer = new midiplayer();
		//midiplayer1.player.stop();// midi背景音乐
		
		// 头像
		imagetoascii = new imagetoascii();
		imagetoascii.setFont(dfont);
		imagetoascii.setPrefSize(othermenu.getWidth(), othermenu.getHeight());
		imagetoascii.setBackground(backbl);
		imagetoascii.setStyle("-fx-text-color:white;-fx-control-inner-background:black;");
		String path1 = System.getProperty("user.dir");
		path1 += "/touxiang/";
		imagetoascii.setText(rw.reads(path1 + "me.txt"));
		imagetoascii.setEditable(false);
		othermenu.setContent(imagetoascii);
		
		game = new game();
		new craft();
		mob.readlist();

		setting = new setting();
		skill=new skill();


		searchitem.setOnMouseEntered(e -> {
			searchitem.requestFocus();
			w = 0;
			s = 0;
			a = 0;
			d = 0;
		});
		searchitem.setOnKeyReleased(e -> {
			if (bagopf == 1)
				br.wupinlist.f(searchitem.getText());

		});
		
		// 全局监听
		youinfo.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.SLASH && speakedf == 0) {
				bot.talk();
				if (firstspeakf == 0) {
					speak.appendText("/");
					firstspeakf = 1;
				}
			}
			if (e.getCode() == KeyCode.ENTER) {
				bot.talk();
				firstspeakf = 1;
			}
			if (e.getCode() == KeyCode.SPACE) {
				br.game.stop();
			}
		});
		keylisten =new keylisten();
		zhu.setOnKeyPressed(keylisten);
		zhu.setOnKeyReleased(e -> {
			if (e.getCode() == KeyCode.W)
				w = 0;
			if (e.getCode() == KeyCode.S)
				s = 0;
			if (e.getCode() == KeyCode.A)
				a = 0;
			if (e.getCode() == KeyCode.D)
				d = 0;
		});
		all.setOnMouseEntered(e -> {
			zhu.requestFocus();
		});
		EventHandler<ActionEvent> dig = e1 -> {
			try {
			if (br.game.map[usey][usex] == 1&&usey<=yi/2+2&&usey>=yi/2-2&&usex<=xi/2+2&&usex>=xi/2-2) {
				if (red > 0)
					red -= 0.01 * br.game.onuse.attack / 4;
				if (green > 0)
					green -= 0.01 * br.game.onuse.attack / 4;
				if (blue > 0)
					blue -= 0.01 * br.game.onuse.attack / 4;
			}
			if (red >= 0 && green >= 0 && blue >= 0)
				b[usey][usex].setTextFill(Color.color(red, green, blue));
			else {
				red = c.getRed();
				green = c.getGreen();
				blue = c.getBlue();
				int a1 = (usey + br.game.posy + 100) / 100 * 3 + (usex + br.game.posx + 100) / 100,
						a2 = (usey + br.game.posy + 100) % 100, a3 = (usex + br.game.posx + 100) % 100;
				br.game.bm[a1][a2][a3] = 2;
				// br.game.map[usey][usex]=2;
				sc(usey, usex);
				level.mapmove(5);
				b[usey][usex].setText("物");

				int[] down = downfrommap(br.game.lvlat, br.game.mapy, br.game.mapx, br.game.posy, br.game.posx, usey,
						usex);
				String key1 = down[0] + "," + down[1] + "," + down[2] + "," + down[3] + "," + down[4];
				wupin w1 = br.wupinlist.list.get("hunningtu2");
				wupin[] h = { w1 };
				drops.put(key1, new drop(h,new int[]{1}));
				gatherdrop(down[0], down[1], down[2], down[3], down[4], -1, 0, key1);
				gatherdrop(down[0], down[1], down[2], down[3], down[4], 1, 0, key1);
				gatherdrop(down[0], down[1], down[2], down[3], down[4], 0, -1, key1);
				gatherdrop(down[0], down[1], down[2], down[3], down[4], 0, 1, key1);
				diggedf = 1;
			}
			}catch(Exception e) {}
		};
		digger = new Timeline(new KeyFrame(Duration.millis(100), dig));
		digger.setCycleCount(Timeline.INDEFINITE);
		digger.setAutoReverse(true);
		
        zhudh.setBackground(backtm);

		all.setOnMouseClicked(e -> {
			if (br.game.stopf == 0) {
				if (e.getButton() == MouseButton.PRIMARY) {
				
				}
				if (e.getButton() == MouseButton.SECONDARY) {
					int x = (int) ((e.getX() - zhu.getTranslateX()) / 40);
					int y = (int) ((e.getY() - zhu.getTranslateY()) / 40);
					//int m = br.game.map[y][x];
					//if (m == 2) {
						// down是通过目前相对坐标来获取持久化的绝对坐标
						int[] down = downfrommap(br.game.lvlat, br.game.mapy, br.game.mapx, br.game.posy, br.game.posx,
								y, x);
						// 以down坐标标记唯一的key
						String key = down[0] + "," + down[1] + "," + down[2] + "," + down[3] + "," + down[4];
						// 用key在所有掉落物中找到唯一掉落物
						drop d = drops.get(key);
						// new p(key+"\n");
						if (d != null && containeropenf == 0) {
							containeropenf = 1;
							// 初始化掉落物列表
							ui.container = new container();
							container.makeoutbutton(key);
							container.makeinbutton(key);
							othermenu.setContent(container);
						}
						int x1=x+100,y1=y+100;
						String key1 = down[0] + "," + down[1] + "," + down[2] + "," + y1 + "," + x1;
						if(br.game.mobmap[y+100][x+100]!=0) {
							br.game.mobsp.get(key1).react();
						}
					//}
				}
			}
		});
		
		all.setOnMousePressed(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				if (br.game.stopf == 0) {
					//if(br.game.onuse!=null&&br.game.onuse.type==4&&wupinuse.onuse==0) {
					if(br.game.onuse!=null&&wupinuse.onuse==0) {
						mospresf=1;
						wupinuse.usewupin();
					}
					usef = 1;
					usex = (int) ((e.getX() - zhu.getTranslateX()) / 40);
					usey = (int) ((e.getY() - zhu.getTranslateY()) / 40);
					if (br.game.onuse != null && br.game.onuse.eventkey == 1) {
						c = (Color) b[usey][usex].getTextFill();
						red = c.getRed();
						green = c.getGreen();
						blue = c.getBlue();
						if(br.game.onuse.id==1)
							if(usey<=yi/2+2&&usey>=yi/2-2&&usex<=xi/2+2&&usex>=xi/2-2)
								digger.play();
					}
				}
			}
		});
		all.setOnMouseDragged(e -> {
			mosx=e.getX();
			mosy=e.getY();
			if(br.game.stopf==0) {
				hide();
			}
			if (br.game.stopf == 0) {
				//if(br.game.onuse!=null&&br.game.onuse.type==4&&wupinuse.onuse==0) {
				if(br.game.onuse!=null&&wupinuse.onuse==0) {		
					wupinuse.usewupin();
				}
				if (usef == 1) {
					if (usexl != usex || useyl != usey) {
						if (useyl<b.length&&usexl<b[useyl].length&&b[useyl][usexl] != null)
							sc(useyl, usexl);
						usexl = usex;
						useyl = usey;
					}
					usex = (int) ((e.getX() - zhu.getLayoutX()) / 40);
					usey = (int) ((e.getY() - zhu.getLayoutX()) / 40);
					if (br.game.onuse != null && br.game.onuse.eventkey == 1) {
						c = (Color) b[usey][usex].getTextFill();
						red = c.getRed();
						green = c.getGreen();
						blue = c.getBlue();
						digger.play();
					}
				}
			}
		});
		all.setOnMouseReleased(e -> {
			mospresf=0;
			digger.stop();
			for (int i = 0; i < ui.yi; i++) {
				for (int j = 0; j < ui.xi; j++) {
					sc(i, j);
				}
			}
			wupinuse.unusewupin();
			usef = 0;
		});
		all.setOnMouseMoved(e->{
			mosx=e.getX();
			mosy=e.getY();
			if(br.game.stopf==0) {
				hide();
				usex = (int) ((e.getX() - zhu.getLayoutX()) / 40);
				usey = (int) ((e.getY() - zhu.getLayoutX()) / 40);
			}
			//hide1();
		});
		/////每隔时间执行
		timer1=new timer1();
		Timeline timer = new Timeline(new KeyFrame(Duration.millis(200), timer1));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.setAutoReverse(true);
		timer.play();
		for(double c=0.40;c<1;c+=0.01) {
			Circle cc=new Circle(5);
			cc.setFill(Color.color(c,c,c,1));
			SnapshotParameters sn1=new SnapshotParameters();
			sn1.setFill(Color.TRANSPARENT);
			WritableImage i1 = null;
			i1 = cc.snapshot(sn1, null);
			cursors.put("bw"+String.format("%.2f",c),new ImageCursor(i1)) ;
			//new p("bw"+String.format("%.2f",c));
		}
		AnimationTimer cu1 = new AnimationTimer() {
		    public void handle(long now) {	
		    	if(cursort>0.98)
					cursortf=1;
				else if(cursort<0.4)
					cursortf=0;
				if(cursortf==0)
					cursort+=0.01;
				else cursort-=0.01;
				
				scene.setCursor(cursors.get("bw"+String.format("%.2f",cursort)));
				//游标
		    }
		};
		cu1.start();
//		br.game.mobs.put(2001, new HashMap<Integer,mob>());
//		br.game.mobs.get(2001).put(0, mob.moblist.get("2001man"));
	
		//mob.actall();
	}

	/////
	public static int[] downfrommap() {
		return ui.downfrommap(br.game.lvlat, br.game.mapy, br.game.mapx, br.game.posy, br.game.posx,
				ui.yi / 2, ui.xi / 2);
	}
	public static int[] downfrommap(int usey, int usex) {
		return ui.downfrommap(br.game.lvlat, br.game.mapy, br.game.mapx, br.game.posy, br.game.posx,
				usey,usex);
	}
	public static int[] downfrommap(int putblock,int pointy, int pointx) {
		return ui.downfrommap(br.game.lvlat,0,0, br.game.posy, br.game.posx,
				pointy,pointx);
	}
	public static int[] downfrommap(int posy,int posx,int usey, int usex) {
		return ui.downfrommap(br.game.lvlat, br.game.mapy, br.game.mapx, posy, posx,
				usey,usex);
	}
	public static int[] downfrommap(int level, int mapy, int mapx, int posy, int posx, int usey, int usex) {
		int[] down = new int[5];
		int px = 0, py = 0;
		if (posx + usex < 0)
			px--;
		else if (posx + usex > 99)
			px++;
		if (posy + usey < 0)
			py--;
		else if (posy + usey > 99)
			py++;
		down[0] = level;
		down[1] = mapy + py;
		down[2] = mapx + px;
		down[3] = posy + usey - py * 100;
		down[4] = posx + usex - px * 100;
		return down;
	};

	@SuppressWarnings("unlikely-arg-type")
	public void gatherdrop(int level, int y1, int x1, int y2, int x2, int yy, int xx, String key1) {
		int a1 = (yy + usey + br.game.posy + 100) / 100 * 3 + (xx + usex + br.game.posx + 100) / 100,
				a2 = (yy + usey + br.game.posy + 100) % 100, a3 = (xx + usex + br.game.posx + 100) % 100;
		if (br.game.bm[a1][a2][a3] == 2) {
			br.game.bm[a1][a2][a3] = 0;
			b[usey + yy][usex + xx].setText("");
			int y = y2 + yy;
			int x = x2 + xx;
			String key = level + "," + y1 + "," + x1 + "," + y + "," + x;
			Iterator<Entry<model.wupin, Integer>> it;
			Iterator<Entry<model.wupin, Integer>> it1 = drops.get(key1).w.entrySet().iterator();
			while (it1.hasNext()) {
				Entry<model.wupin, Integer> next1 = it1.next();
				model.wupin i1 = next1.getKey();
				it = drops.get(key).w.entrySet().iterator();
				while (it.hasNext()) {
					Entry<model.wupin, Integer> next = it.next();
					Integer i = next.getValue();
					model.wupin w = next.getKey();
					if (i1.equals(i)) {
						drops.get(key1).w.put(i1,drops.get(key1).w.get(i1)+i);
						drops.get(key).w.remove(w);
					}
				}
			}
			it = drops.get(key).w.entrySet().iterator();
			while (it.hasNext()) {
				Entry<model.wupin, Integer> next = it.next();
				wupin w = next.getKey();
				Integer i = next.getValue();
				drops.get(key1).w.put(w, i);
			}
			drops.remove(key);
		}
	}

	

	public void sc(int y, int x) {
//		int id = br.game.map[y][x];
//
//		if (id == 1) {
//			ui.b[y][x].setTextFill(Color.YELLOW);
//		} else if (id == 2) {
//			ui.b[y][x].setTextFill(Color.GREY);
//		} else if (id == 6) {
//			ui.b[y][x].setTextFill(Color.RED);
//		}
	}

	public void craftsize(int s) {
		craftsizef = s;
		for (int i = 0; i < s * s; i++) {
			cft[i] = new bagitembutton();
			cft[i].setPadding(new Insets(0, 0, 0, 0));
			craftp.add(cft[i], i % s, (int) i / s);
			cft[i].setBackground(backg);
			cft[i].setPrefSize(40, 40);
			cft[i].setOnMouseClicked(e -> {
				for (int j = 0; j < 16; j++)
					if (e.getSource() == ui.cft[j]) {
						craft.clickcft(j);
					}
			});
		}
	}

	////

	public static void hide() {
		int[][] see=new int[yi][xi];
		//new p(yi);
		if(fumo.seeallf==0) {
			double dx=mosx-40*xi/2,dy=mosy-40*yi/2;
			ag=0;
			if(dx>=0&&dy<=0)
				ag=-Math.toDegrees(Math.atan(dy/dx));
			else if(dx<=0&&dy<=0)
				ag=-Math.toDegrees(Math.atan(dy/dx))+180;
			else if(dx<0&&dy>=0)
				ag=-Math.toDegrees(Math.atan(dy/dx))+180;
			else if(dx>=0&&dy>=0)
				ag=-Math.toDegrees(Math.atan(dy/dx))+360;
			//new p(ag+"\n");
			double ag1=(ag-90+360)%360,ag2=(ag+90+360)%360;
			for(float i=0;i<360;i+=0.4) {
				if(i<180) {
					int k=0,m=0;
					if(i<=90&&(((i<ag2&&ag>270)||(i>ag1&&ag>90))||(ag>=0&&ag<=90))) {
						k:for(int j=yi/2;j>-1;j--) {
							double k1=0;
							if(k==0)k1=k+0.5;
							else k1=k;
							while(k1/Math.tan(Math.toRadians(i))>m-0.5&&yi/2-k>-1&&xi/2+m<xi) {
									see[yi/2-k][xi/2+m]=1;
								if(hidelist.containsKey(br.game.map[yi/2-k][xi/2+m]))
									break k;
								m++;
							}
							k++;
							m--;
						}
					}
					else if((i>90&&i<=180)&&((i<ag2&&ag>=0&&ag<=90)||(i<ag2&&i>ag1))){
						k:for(int j=yi/2;j>-1;j--) {
							double k1=0;
							if(k==0)k1=k+0.5;
							else k1=k;
							while(k1/Math.tan(Math.toRadians(i))<m+0.5&&yi/2-k>-1&&xi/2+m>-1) {
								see[yi/2-k][xi/2+m]=1;
								if(hidelist.containsKey(br.game.map[yi/2-k][xi/2+m]))
									break k;
								m--;
							}
							k++;
							m++;
						}
					}
				}
				else {
					int k=0,m=0;
					if(i<=270&&((i<ag2&&ag>90&&ag<=180)||(i>ag1&&ag>270&&ag<360)||(i<ag2&&i>ag1))) {
						k:for(int j=yi/2;j<yi;j++) {
							double k1=0;
							if(k==0)k1=k-0.5;
							else k1=k;
							while(k1/Math.tan(Math.toRadians(i))<m+0.5&&yi/2-k<yi+1&&xi/2+m>-1) {
								see[yi/2-k][xi/2+m]=1;
								if(hidelist.containsKey(br.game.map[yi/2-k][xi/2+m]))
									break k;
								m--;
							}
							k--;
							m++;
						}
					}
					else if((i>270&&i<=360)&&((i<ag2&&ag>180&&ag<=270)||(i>ag1&&ag<90&&ag>=0)||(i<360&&ag>270&&ag<=360))){
						k:for(int j=yi/2;j<yi;j++) {
							double k1=0;
							if(k==0)k1=k-0.5;
							else k1=k;
							while(k1/Math.tan(Math.toRadians(i))>m-0.5&&yi/2-k<yi+1&&xi/2+m<xi) {
								see[yi/2-k][xi/2+m]=1;
								if(hidelist.containsKey(br.game.map[yi/2-k][xi/2+m]))
									break k;
								m++;
							}
							k--;
							m--;
						}
					}
				}
			}
		}
		else {
			for(int i=0;i<yi;i++) {
				for(int j=0;j<xi;j++) {
					see[i][j]=1;
				}
			}
		}
		for(int i=0;i<yi;i++) {
			if(see[i][1]==0)
				see[i][0]=0;
			if(see[i][xi-2]==0)
				see[i][xi-1]=0;
		}
		for(int i=0;i<yi;i++) {
			for(int j=0;j<xi;j++) {
				if(see[i][j]==0) {
					if(g[i][j]!=null) {
						g[i][j].setVisible(false);
					}
				}
				else {
					if(g[i][j]!=null) {
						g[i][j].setVisible(true);
					}
					//if(i*xi+j<lightpane.getChildren().size())
						//lightpane.getChildren().get(i*xi+j).setVisible(true);
				}
			}
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
