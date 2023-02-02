package lvls0;


import java.util.Random;

import br.game;
import br.ui;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lvlc.level;
import lvlc.randomdrop;
import model.block;
import model.wupin;
import sub.midiplayer;

//模板
//模板
//0安全稳定实体绝迹 1安全稳定极少量实体 
//2不安全稳定少量实体 3不安全不稳定少量实体
//4不安全不稳定中量实体 5不安全不稳定实体横行

public class lvl {
	static int lposx,lposy;
	public static void rtwall() {//墙壁的遮挡信息，切歌，
		//生成墙壁的参数（也可以写game.wallarg[0]=0阻止默认生成并重写aftbuild）
		ui.hidelist.clear();
		ui.hidelist.put(10, null);
		midiplayer.qiege("LittlMan");
		game.wallarg[0]=10;game.wallarg[1]=500;
		game.wallarg[2]=3;game.wallarg[3]=7;
		game.wallarg[4]=3;game.wallarg[5]=15;game.wallarg[6]=4;
		level.blocks.clear();
		level.blocks.put(0, new block(new String[]{"地","毯"},Color.color(0.682,0.583,0.277,1.000)));
		level.blocks.put(1, new block(new String[]{"墙","壁"},Color.color(0.913,0.855,0.702,1.000)));
	}
	public static int[][] aftbuild(int[][] map) {//重写楼层生成
		//Random r=new Random();
		return map;
	}
	EventHandler<ActionEvent> evt=e->{
		event(1);
	};
	Timeline timer=new Timeline(new KeyFrame(Duration.millis(500),evt));
	
	public void play() {//开始逻辑处理
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.setAutoReverse(true);
		timer.play();
	}
	public void stop() {//停止逻辑处理，一般切出前调用
		timer.stop();
	}
	
	public void clip(int l) {//切出方法，l是楼层的编号
		stop();
		game.enter(l);
	}
	
	public int[][] drop(int[][] map,int mapy,int mapx) {
		return map;//在这重写随机掉落
	}
	
	public void event(int eid){//一般事件处理写在这，500ms执行，在上面可以改 
		switch(eid) {
			case 1:{
				
			}
		}
	}
	public void lleffect(int id) {//左键实体以后的反应
		
	}
	public void lreffect(int id) {//右键实体以后的反应
		
	}
}
