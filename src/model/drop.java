package model;

import java.util.HashMap;

public class drop {
	public HashMap<wupin,Integer> w=new HashMap<wupin,Integer>();
	public drop(wupin[] w,int[] amount){
		for(int i=0;i<w.length;i++) {
			this.w.put(w[i],amount[i]);
		}
	}
}
