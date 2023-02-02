package wupin;

import br.rw;
import javafx.scene.paint.Color;
import model.wupin;
import sub.wendang;

public class megxinshouzhinan509 {
	public void use(wupin w,int j){
		String[] ss=new String[7];
		for(int i=0;i<7;i++) {
			ss[i]=rw.reads("juqing/0/新手指南"+String.valueOf(i+1)+".txt");
		}
		new wendang(ss,new Color(0.955,0.905,0.814,1.000),Color.BLACK).show();
	}
}
