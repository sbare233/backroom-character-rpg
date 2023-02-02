package wupin;

import br.game;
import br.ui;

public class hunningtu502 {
	public void useonetime(){
		if(game.map[ui.usey][ui.usex]==0) {
			int[] d=ui.downfrommap(0,ui.usey,ui.usex);
			game.map[ui.usey][ui.usex]=1;
			game.bm[(d[1]+1)*3+d[2]+1][d[3]][d[4]]=1;
		}
	}
}
