package lvlc;

import java.lang.reflect.Method;
import java.util.Random;

import br.game;
import br.ui;
import br.wupinlist;
import model.drop;
import model.wupin;

public class randomdrop {
	public static long seed=Math.round(Math.random()*1000000);//种子
	public static Random r=new Random(seed);
	
	public static void inidrop() {
		int f=0;
		try {
			Class<?> c=Class.forName("lvls"+game.lvlat/100+".lvl"+game.lvlat);
			Object o=c.newInstance();
			Method m=c.getMethod("inidrop");
			m.invoke(o);
			f=1;
		} catch (Exception e) {
			//e.printStackTrace();
		}
		if(f==0) {
			for(int k=0;k<9;k++) {
				game.bm[k]=drop(game.bm[k],k/3-1,k%3-1);
			}
		}
	}
	
	public static int[][] drop(int[][] map,int mapy,int mapx){
		int f=0;
		try {
			Class<?> c=Class.forName("lvls"+game.lvlat/100+".lvl"+game.lvlat);
			Object o=c.newInstance();
			Method m=c.getMethod("drop",int[][].class,int.class,int.class);
			f=1;
			return (int[][]) m.invoke(o,map,mapy,mapx);
		} catch (Exception e) {
			//e.printStackTrace();
		}
		if(f==0) {
//			for(int i=0;i<100;i++) {
//				for(int j=0;j<100;j++)
//					if(map[i][j]==2)
//						map[i][j]=0;
//			}
			//new p(mapy+","+mapx+"\n");
			int a=r.nextInt(30);
			for(int i=0;i<a;i++) {
				int x=r.nextInt(100);
				int y=r.nextInt(100);
				if(map[y][x]==0) {
					map[y][x]=2;
					wupin w1=wupinlist.list.get("xingrenshui3");
					wupin w2=wupinlist.list.get("longrou5");
					wupin[] ws= {w1,w2};
					putdrop(mapy,mapx,y,x,ws,new int[]{1,1});
					//new p(game.lvlat+","+mapy+","+mapx+","+y+","+x+"\n");
				}
			}
		}
		return map;
	}
	public static void putdrop(int mapy,int mapx,int y,int x,wupin[] ws,int[] amount) {
		drop d=new drop(ws,amount);
		ui.drops.put(game.lvlat+","+mapy+","+mapx+","+y+","+x, d);
	}
	public static void putdrop(int mapy,int mapx,int y,int x,wupin w) {
		drop d=new drop(new wupin[]{w},new int[1]);
		ui.drops.put(game.lvlat+","+mapy+","+mapx+","+y+","+x, d);
	}
}
