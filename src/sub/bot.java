package sub;

import java.util.Scanner;

import br.game;
import br.ui;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import lvlc.level;

public class bot {
	public static void speak(String s){
		s=s.replaceAll("你","我");
		if(s.contains("吧")||s.contains("吗")||s.contains("？")||s.contains("?")) {
			double r=Math.random();
			if(r<.3) {
				s=s.replaceAll("吗","");
				s=s.replaceAll("吧","");
				s=s.replaceAll("？","！");
			}
			else if(r>0.6)s="？";
			else s="????????";
		}
		TextField dh0=new TextField();
		dh0.setEditable(false);
		dh0.appendText("系统："+s);
		ui.dh.add(dh0,0,ui.dh.getChildren().size());
		
		Platform.runLater(()->{
//			if(ui.dh.getChildren().size()>20) {
//				for(int i=0;i<ui.dh.getChildren().size()-20;i++) {
//					ui.dh.add(new Label(""),0,i);
//				}
//			}
			ui.dhs.setVvalue(100);});
	}
	public static void talk() {
		ui.w = 0;
		ui.s = 0;
		ui.a = 0;
		ui.d = 0;
		if (ui.speakedf == 0) {
			ui.infospeak.add(ui.speak, 0, 0);
			ui.order.setText("发送");
			ui.speak.requestFocus();
			ui.speakedf = 1;
		} else {
			ui.infospeak.getChildren().remove(ui.speak);
			ui.order.setText("说话");
			String s = ui.speak.getText();
			if (s.length() > 0) {
				TextField dh0=new TextField();
				dh0.setEditable(false);
				dh0.appendText(ui.name.getText() + "：" + s);
				ui.dh.add(dh0,0,ui.dh.getChildren().size());
				Platform.runLater(()->{
//					if(ui.dh.getChildren().size()>20) {
//						for(int i=0;i<ui.dh.getChildren().size()-20;i++) {
//							ui.dh.add(new Label(""),0,i);
//						}
//					}
					ui.dhs.setVvalue(100);});
				if (!s.contains("/")) {
					bot.speak(s);
				} else {
					command(s);
				}
			}
			ui.speak.setText("");
			ui.speakedf = 0;
			ui.zhu.requestFocus();
		}
	}

	public static void command(String s) {
		Scanner sc = new Scanner(s);
		String s1 = sc.next();
		switch (s1) {
		case "/tp": {
			try {
				int i1 = sc.nextInt();
				int i2 = sc.nextInt();
				game.tp(i1, i2);
			}catch(Exception e) {}
		}
		case "/give": {
		}
		case "/clip": {
			try {
				int i1 = sc.nextInt();
				game.enter(i1);
			}catch(Exception e) {}
		}
		}
		sc.close();
	}
}
