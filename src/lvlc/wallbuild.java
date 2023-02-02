package lvlc;

import java.lang.reflect.Method;
import java.util.Random;

import br.game;

public class wallbuild {
	static long seed=Math.round(Math.random()*1000000);//种子
	public static Random r=new Random(seed);
	public static int[][] build(int[][] map,int wallid,int a,int b,int c,int d,int e,int f){
		//int inin=r.nextInt(a);
		if(wallid!=0) {
			int inin=a;
			for(int i=0;i<inin;i++) {
				int y=r.nextInt(100);
				int x=r.nextInt(100);
				map[y][x]=wallid;
			}
			for(int i=0;i<100;i++)
				for(int j=0;j<100;j++) {
					//if(i%3==0&&j%3==0)map[i][j]=1;//调试
					if(map[i][j]==b) {			//b
						int i1=r.nextInt(c);	//c
						if(i1==1) {}
						else{//不是承重柱
							int i3=r.nextInt(d);//d
							//墙延伸拐弯前
							int i4=r.nextInt(e);//长度
							int i5=r.nextInt(f);//方向
							shen(map,i,j,i4,i5,wallid);					
							if(i3==1){
								i4=r.nextInt(e);//长度
								if(i5==0)i5=3;
								else i5--;
								shen(map,i,j,i4,i5,wallid);
							}
							if(i3==2){
								i4=r.nextInt(e);//长度
								if(i5==3)i5=0;
								else i5++;
								shen(map,i,j,i4,i5,wallid);
							}
						}
					}
				}
		}
		try {
			Class<?> cls=Class.forName("lvls"+game.lvlat/100+".lvl"+game.lvlat);
			Object o=cls.newInstance();
			Method m=cls.getMethod("aftbuild",int[][].class);
			m.invoke(o,map);
		} catch (Exception e1) {}
		return map;
	}
	static int[][] shen(int[][] map,int i,int j,int l,int d,int wallid){
		if(d==0) {
			for(int k=0;i-k>2&&i<100&&k<l&&map[i-k-1][j]!=wallid;k++) {
				try {
				if(map[i][j-1]!=wallid&&map[i][j+1]!=wallid)
					map[i-k][j]=wallid;
				}catch(Exception e) {}
			}
		}
		if(d==1) {
			for(int k=0;i+k+2<100&&k<l&&map[i+k+1][j]!=wallid;k++) {
				try {
					if(map[i][j-1]!=wallid&&map[i][j+1]!=wallid)
						map[i+k][j]=wallid;
				}catch(Exception e) {}
			}
		}
		if(d==2) {
			for(int k=0;j-k>2&&j<100&&k<l&&map[i][j-k-1]!=wallid;k++) {
				try {
					if(map[i-1][j]!=wallid&&map[i+1][j]!=wallid)
						map[i][j-k]=wallid;
				}catch(Exception e) {}
			}
		}
		if(d==3) {
			for(int k=0;j+k+2<100&&k<l&&map[i][j+k+1]!=wallid;k++) {
				try {
					if(map[i-1][j]!=wallid&&map[i+1][j]!=wallid)
						map[i][j+k]=wallid;
				}catch(Exception e) {}
			}
		}
		return map;
	}
	public static int[][] room(int[][] map,int y,int x,int l,int w,int wallid){
		for(int i=1;i<l;i++) {
			for(int j=1;j<w;j++) {
				map[y+i][x+j]=0;
			}
		}
		for(int i=0;i<=l;i++) {
				map[y+i][x]=wallid;
				map[y+i][x+w]=wallid;
		}
		for(int j=0;j<=w;j++) {
			map[y][x+j]=wallid;
			map[y+l][x+j]=wallid;
		}
		return map;
	}
	public static int[][] one(int[][] map,int y,int x,int wallid){
		map[y][x]=wallid;
		return map;
	}
	static int[][] space(int[][] map,int y,int x,int l,int w){
		for(int i=0;i<l;i++) {
			for(int j=0;j<w;j++) {
				map[y+i][x+j]=0;
			}
		}
		return map;
	}
	static int[][] fill(int[][] map,int y,int x,int l,int w,int wallid){
		for(int i=0;i<l;i++) {
			for(int j=0;j<w;j++) {
				map[y+i][x+j]=wallid;
			}
		}
		return map;
	}
}
