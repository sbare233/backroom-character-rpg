package wupin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import br.game;
import br.p;
import br.status;
import br.ui;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import lvlc.level;
import model.wupin;

public class qi507 {
	public static Queue<Object[]> ql = new LinkedList<Object[]>();
	public int qif,qitimerf = 5;
	public Timeline tl;
	public void use(wupin w,int i) {
		ql=null;
		ql = new LinkedList<Object[]>();
		qif=1;
		tl = new Timeline(new KeyFrame(Duration.millis(200), 
				e->{if (qif == 1) {
						if (qitimerf < 5) {
							qitimerf++;
						} else {
							qitimerf = 0;
							q();
						}
				}}));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.setAutoReverse(true);
		tl.play();
		ui.stages.get("main").setTitle("永远的七日之都");
	}
	@SuppressWarnings("unchecked")
	public void unuse(wupin w,int i) {
		new p(1);
		if(tl!=null)
			tl.stop();
		qif=0;
		w.text="你把秒针拨回12点，][]不可思议的事发生了";
		//ui.wupininfo = new wupininfo();
		//ui.othermenu.setContent(ui.wupininfo);
		Object[] o=ql.poll();
		
		if(o!=null&&o.length>1) {
		game.bm=(int[][][]) (o[0]);
		game.map=(int[][]) (o[1]);
		game.bag=(HashMap<wupin, Integer>) (o[2]);
		game.lvlat=(int) (o[3]);
		status.hp=(int) (o[4]);
		status.sn=(int) (o[5]);
		status.mp=(int) (o[6]);
		status.weight=(int) (o[7]);
		game.mapy=(int) (o[8]);
		game.mapx=(int) (o[9]);
		game.posy=(int) (o[10]);
		game.posx=(int) (o[11]);
		}
		level.mapmove(5);	
	}
	
	public void q(){
		if (ql.size() > 7) {
			ql.poll();
		}
		Object[] o = { game.bm, game.map, game.bag, game.lvlat, status.hp, status.sn, status.mp, status.weight, game.mapy,
				game.mapx, game.posy, game.posx };
		ql.offer(o);
	}
}
