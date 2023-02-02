package wupin;

import br.rw;
import javafx.scene.paint.Color;
import model.wupin;
import sub.wendang;

public class shiti1051 {
	public void use(wupin w,int i) {
			if(w.pinyin.equals("megxinshouzhinan")) {
				String[] ss=new String[7];
				for(int j=0;j<7;j++) {
					ss[j]=rw.reads("juqing/ziyuan/ziyuan"+String.valueOf(j));
				}
				//new p(s);
				new wendang(ss,new Color(0.955,0.905,0.814,1.000),Color.BLACK).show();
			}
		}
	

}
