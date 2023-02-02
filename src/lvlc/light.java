package lvlc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import br.game;
import br.p;
import br.ui;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class light {
	static long seed=Math.round(Math.random()*1000000);//种子
	static Random r=new Random(seed);
	public static void makelight() {
		game.lightsc=new int[300][300];
		int a=r.nextInt(2000)+1000;
		for(int i=0;i<a;i++) {
			int x=r.nextInt(300);
			int y=r.nextInt(300);
			game.lightsc[y][x]=5;
		}
		for(int i=0;i<a;i++) {
			int x=r.nextInt(300);
			int y=r.nextInt(300);
			game.lightsc[y][x]=-5;
		}
		
	}
	public static void reflight() {
		game.light=new int[300][300];
		game.lightf=new int[300][300];
		for(int i=0;i<300;i++) {
			for(int j=0;j<300;j++) {
				int l=game.lightsc[i][j];
				if(l!=0) {
					if(l>0) {
						for(int k=-l+1;k<l;k++) {
							for(int m=-l+1;m<l;m++) {
								if(i+k>0&&i+k<300&&j+m>0&&j+m<300) {
									int sj=Math.abs(k)+Math.abs(m);
									if(sj<=l) {
										game.light[i+k][j+m]=(game.light[i+k][j+m]+l-sj>l?l:game.light[i+k][j+m]+l-sj);								
										game.lightf[i+k][j+m]=l;
									}
								}
							}
						}
					}
//					else {
//						for(int k=l+1;k<-l;k++) {
//							for(int m=l+1;m<-l;m++) {
//								if(i+k>0&&i+k<300&&j+m>0&&j+m<300) {
//									int sj=Math.abs(k)+Math.abs(m);
//									if(sj<=Math.abs(l)) {
//										game.light[i+k][j+m]=(game.light[i+k][j+m]+l+sj<l?l:game.light[i+k][j+m]+l+sj);	
//										game.lightf[i+k][j+m]=l;
//									}
//								}
//							}
//						}
//					}
				}
			}
		}
	}
}
