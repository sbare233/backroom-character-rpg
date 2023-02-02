package lvlc;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import br.fumo;
import br.fx;
import br.game;
import br.p;
import br.ui;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import model.block;
import model.lvl;
import model.mob;



public class level {
	//static Image[][] caizhi=new Image[11][11];
	//static Icon[][] icon=new Icon[11][11];
	public static HashMap<Integer,block> blocks=new HashMap<Integer,block>();
	static int bldf;
	public static int onbuild;
	public static int[] mapos=new int[5];
	static String[] wu=new String[200];
	/*static void readcz(){
		File f=new File("../level0.png");
		for(int i=0;i<3;i++)
		for(int j=0;j<11;j++) {
			caizhi[j][i]=readcaizhi.make(f, j, i);
			icon[j][i]=new ImageIcon(caizhi[j][i]);
		}
	}*/
	public static void mapadjust() {
		if (ui.dim.width > 4000) {
			// 大屏幕缩放
		}
		Iterator<Entry<String, Node>> it = fx.fxs.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, Node> next = it.next();
			Node n = next.getValue();
			ui.fxpane.getChildren().remove(n);
		}
		fx.fxs.clear();
		int inif=0;
		if(ui.xi==0)inif=1;
		ui.xi = (int) ((ui.zhu.getWidth()) / 40) + 1;
		ui.yi = (int) ((ui.zhu.getHeight()) / 40) + 1;
		for (int i = 0; i < ui.yi; i++) {
			for (int j = 0; j < ui.xi; j++) {
				ui.zhu.getChildren().remove(ui.g[i][j]);
				ui.b[i][j] = new Label("");
				if (i == ui.yi / 2 && j == ui.xi / 2) {
					ui.zhu.getChildren().remove(ui.u);
					ui.u = new Label("你");
					ui.u.setFont(ui.bfont);
//					u.setEffect(new GaussianBlur());
//					Reflection r1 = new Reflection();
//					r1.setFraction(0.9f);
//					ui.u.setEffect(r1);
                    ui.u.setPadding(new Insets(0, 0, 0, 0));
                    ui.u.setPrefSize(40, 40);
                    ui.u.setBackground(ui.backtm);
                    ui.u.setTextFill(Color.color(1, 1, 1));
                    ui.u.setBorder(null);
                    ui.zhu.getChildren().add(ui.u);
                    ui.u.setTranslateX(j*40);
                    ui.u.setTranslateY(i*40);
				} else {
					ui.g[i][j]=makeblock(ui.b[i][j],i,j);
                    ui.zhu.getChildren().add(ui.g[i][j]);
                    ui.g[i][j].setTranslateX(j*40);
                    ui.g[i][j].setTranslateY(i*40);
				}
			}
		}

//		if(inif==1) {
//			if(game.bm[4][ui.yi/2][ui.xi/2]!=0) {
//				game.bm[4][ui.yi/2][ui.xi/2]=0;
//				game.bm[4][ui.yi/2-1][ui.xi/2]=0;
//				game.bm[4][ui.yi/2+1][ui.xi/2]=0;
//				game.bm[4][ui.yi/2][ui.xi/2-1]=0;
//				game.bm[4][ui.yi/2][ui.xi/2+1]=0;
//			}
//		}
		if (br.game.map[ui.yi / 2][ui.xi / 2] == 1){
				br.game.clip();
		}
		ui.imagetoascii.setPrefSize(ui.othermenu.getWidth(), ui.othermenu.getHeight());
	}
	static Group makeblock(Label b,int i,int j) {
		Group g=null;
		try {
			Class<?> c=Class.forName("lvls"+game.lvlat/100+".lvl"+game.lvlat);
			Object o=c.newInstance();
			Method m=c.getMethod("makeblock",Label.class,int.class,int.class);
			return (Group) m.invoke(o,b,i,j);	
		} catch (Exception e) {
		}
		int m=game.map[i][j];
		level.setlabel(m,i,j);
		b.setFont(ui.bfont);
		b.setPadding(new Insets(0, 0, 0, 0));
	    b.setPrefSize(40, 40);
	    b.setBackground(ui.backtm);
	    b.setBorder(null);
        g=new Group();
        g.getChildren().add(b);
        return g;
	}
	public static void mapmove(int dir) {
		
		int x=ui.xi/2;
		int y=ui.yi/2;
		if(dir==1) {
			//if(game.map[y-1][x]==1&&fumo.untouchf==0) {//通过id判断碰撞
			if(ui.hidelist.containsKey(game.map[y-1][x])&&fumo.untouchf==0) {//通过文字判断碰撞
				bldf=1;
			}
			else {
				Iterator<Entry<String, Node>> it = fx.fxm.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Node> next = it.next();
					Node w = next.getValue();
					w.setTranslateY(w.getTranslateY()+40);
				}
				game.posy--;
				bldf=0;
				mob.moveall(1,0);
			}
		}
		else if(dir==2) {
			//if(game.map[y+1][x]==1&&fumo.untouchf==0) {
			if(ui.hidelist.containsKey(game.map[y+1][x])&&fumo.untouchf==0) {
				bldf=1;
			}
			else {
				Iterator<Entry<String, Node>> it = fx.fxm.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Node> next = it.next();
					Node w = next.getValue();
					w.setTranslateY(w.getTranslateY()-40);
				}
				game.posy++;
				bldf=0;
				mob.moveall(-1,0);
			}
		}
		else if(dir==3) {
			//if(game.map[y][x-1]==1&&fumo.untouchf==0) {
			if(ui.hidelist.containsKey(game.map[y][x-1])&&fumo.untouchf==0) {
				bldf=1;
			}
			else {
				Iterator<Entry<String, Node>> it = fx.fxm.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Node> next = it.next();
					Node w = next.getValue();
					w.setTranslateX(w.getTranslateX()+40);
				}
				game.posx--;
				bldf=0;
				mob.moveall(0,1);
			}
		}
		else if(dir==4) {
			//if(game.map[y][x+1]==1&&fumo.untouchf==0) {
			if(ui.hidelist.containsKey(game.map[y][x+1])&&fumo.untouchf==0) {
				bldf=1;
			}
			else {
				Iterator<Entry<String, Node>> it = fx.fxm.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, Node> next = it.next();
					Node w = next.getValue();
					w.setTranslateX(w.getTranslateX()-40);
				}
				game.posx++;
				bldf=0;
				mob.moveall(0,-1);
			}
		}
		else if(dir==5) {
				bldf=0;
		}
		
		if(bldf==0) {
			mapos=ui.downfrommap();
			
			if(game.posy<=0&&game.posx<=0) {
				for(int i=0;i<100;i++) {
					for(int j=0;j<100;j++) {
						if(i<-game.posy&&j<-game.posx)game.map[i][j]=game.bm[0][100+game.posy+i][100+game.posx+j]; 
						else if(i<-game.posy&&j>=-game.posx)game.map[i][j]=game.bm[1][100+game.posy+i][game.posx+j];
						else if(i>=-game.posy&&j<-game.posx)game.map[i][j]=game.bm[3][game.posy+i][100+game.posx+j];
						else if(i>=-game.posy&&j>=-game.posx)game.map[i][j]=game.bm[4][game.posy+i][game.posx+j];
					}
				}
			}
			else if(game.posy<=0&&game.posx>0) {
				for(int i=0;i<100;i++) {
					for(int j=0;j<100;j++) {
						if(i<-game.posy&&j<100-game.posx)game.map[i][j]=game.bm[1][100+game.posy+i][game.posx+j]; 
						else if(i<-game.posy&&j>=100-game.posx)game.map[i][j]=game.bm[2][100+game.posy+i][-100+game.posx+j];
						else if(i>=-game.posy&&j<100-game.posx)game.map[i][j]=game.bm[4][game.posy+i][game.posx+j];
						else if(i>=-game.posy&&j>=100-game.posx)game.map[i][j]=game.bm[5][game.posy+i][-100+game.posx+j];
					}
				}
			}
			else if(game.posy>0&&game.posx<=0) {
				for(int i=0;i<100;i++) {
					for(int j=0;j<100;j++) {
						if(i<100-game.posy&&j<-game.posx)game.map[i][j]=game.bm[3][game.posy+i][100+game.posx+j]; 
						else if(i<100-game.posy&&j>=-game.posx)game.map[i][j]=game.bm[4][game.posy+i][game.posx+j];
						else if(i>=100-game.posy&&j<-game.posx)game.map[i][j]=game.bm[6][-100+game.posy+i][100+game.posx+j];
						else if(i>=100-game.posy&&j>=-game.posx)game.map[i][j]=game.bm[7][-100+game.posy+i][game.posx+j];
					}
				}
			}
			else if(game.posy>0&&game.posx>0) {
				for(int i=0;i<100;i++) {
					for(int j=0;j<100;j++) {
						if(i<100-game.posy&&j<100-game.posx)game.map[i][j]=game.bm[4][game.posy+i][game.posx+j]; 
						else if(i<100-game.posy&&j>=100-game.posx)game.map[i][j]=game.bm[5][game.posy+i][-100+game.posx+j];
						else if(i>=100-game.posy&&j<100-game.posx)game.map[i][j]=game.bm[7][-100+game.posy+i][game.posx+j];
						else if(i>=100-game.posy&&j>=100-game.posx)game.map[i][j]=game.bm[8][-100+game.posy+i][-100+game.posx+j];
					}
				}
			}
		}
		
		if(bldf==0) {
			ui.hide();
			if(game.posy==-100) {
				game.bm[8]=game.bm[5];
				game.bm[7]=game.bm[4];
				game.bm[6]=game.bm[3];
				game.bm[5]=game.bm[2];
				game.bm[4]=game.bm[1];
				game.bm[3]=game.bm[0];
				game.bm[2]=new int[100][100];
				game.bm[1]=new int[100][100];
				game.bm[0]=new int[100][100];
				game.posy=0;
				game.mapy--;
				onbuild=2;
				game.bm[2]=wallbuild.build(game.bm[2],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				onbuild=1;
				game.bm[1]=wallbuild.build(game.bm[1],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				onbuild=0;
				game.bm[0]=wallbuild.build(game.bm[0],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				
				mapos=ui.downfrommap();
				game.bm[2]=randomdrop.drop(game.bm[2], game.mapy-1,game.mapx+1);
				game.bm[1]=randomdrop.drop(game.bm[1], game.mapy-1,game.mapx);
				game.bm[0]=randomdrop.drop(game.bm[0], game.mapy-1,game.mapx-1);
			}
			if(game.posy==100) {
				game.bm[0]=game.bm[3];
				game.bm[1]=game.bm[4];
				game.bm[2]=game.bm[5];
				game.bm[3]=game.bm[6];
				game.bm[4]=game.bm[7];
				game.bm[5]=game.bm[8];
				game.bm[6]=new int[100][100];
				game.bm[7]=new int[100][100];
				game.bm[8]=new int[100][100];
				game.posy=0;
				game.mapy++;
				onbuild=6;
				game.bm[6]=wallbuild.build(game.bm[6],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				onbuild=7;
				game.bm[7]=wallbuild.build(game.bm[7],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				onbuild=8;
				game.bm[8]=wallbuild.build(game.bm[8],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				
				
				mapos=ui.downfrommap();
				game.bm[6]=randomdrop.drop(game.bm[6], game.mapy+1,  game.mapx-1);
				game.bm[7]=randomdrop.drop(game.bm[7], game.mapy+1,  game.mapx);
				game.bm[8]=randomdrop.drop(game.bm[8], game.mapy+1,  game.mapx+1);
			}
			if(game.posx==-100) {
				game.bm[2]=game.bm[1];
				game.bm[5]=game.bm[4];
				game.bm[8]=game.bm[7];
				game.bm[1]=game.bm[0];
				game.bm[4]=game.bm[3];
				game.bm[7]=game.bm[6];
				game.bm[0]=new int[100][100];
				game.bm[3]=new int[100][100];
				game.bm[6]=new int[100][100];
				game.posx=0;
				game.mapx--;
				onbuild=0;
				game.bm[0]=wallbuild.build(game.bm[0],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				onbuild=3;
				game.bm[3]=wallbuild.build(game.bm[3],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				onbuild=6;
				game.bm[6]=wallbuild.build(game.bm[6],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				
				mapos=ui.downfrommap();
				game.bm[0]=randomdrop.drop(game.bm[0], game.mapy-1,  game.mapx-1);
				game.bm[3]=randomdrop.drop(game.bm[3], game.mapy,  game.mapx-1);
				game.bm[6]=randomdrop.drop(game.bm[6], game.mapy+1,  game.mapx-1);
			}
			if(game.posx==100) {
				game.bm[0]=game.bm[1];
				game.bm[3]=game.bm[4];
				game.bm[6]=game.bm[7];
				game.bm[1]=game.bm[2];
				game.bm[4]=game.bm[5];
				game.bm[7]=game.bm[8];
				game.bm[2]=new int[100][100];
				game.bm[5]=new int[100][100];
				game.bm[8]=new int[100][100];
				game.posx=0;
				game.mapx++;
				onbuild=2;
				game.bm[2]=wallbuild.build(game.bm[2],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				onbuild=5;
				game.bm[5]=wallbuild.build(game.bm[5],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				onbuild=8;
				game.bm[8]=wallbuild.build(game.bm[8],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
				
				
				mapos=ui.downfrommap();
				game.bm[2]=randomdrop.drop(game.bm[2], game.mapy-1,game.mapx+1);
				game.bm[5]=randomdrop.drop(game.bm[5], game.mapy,game.mapx+1);
				game.bm[8]=randomdrop.drop(game.bm[8], game.mapy+1,game.mapx+1);
			}
			light.reflight();
			for(int i=0;i<ui.yi;i++) {
				for(int j=0;j<ui.xi;j++) {
					int m=game.map[i][j];
					setlabel(m,i,j);
					
					buildlight(m,i,j);
				}
				//System.out.println();
			}
			for(int i=0;i<ui.yi;i++) {
				for(int j=0;j<ui.xi;j++) {
					int m=game.mobmap[i+100][j+100];
					if(m!=0)
					setmoblabel(m,i,j);
				}
				//System.out.println();
			}
		}
	}
	public static void createcore() {
		// TODO Auto-generated method stub
		
	}
	public static void createnlvl() {
			for(int k=0;k<9;k++) {
				level.onbuild=0;
				game.bm[k]=new int[100][100];
				game.bm[k]=wallbuild.build(game.bm[k],game.wallarg[0], game.wallarg[1],
						game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);	
		}
	}
	public static void createslvl() {
		// TODO Auto-generated method stub
		
	}
	public static void createolvl() {
		// TODO Auto-generated method stub
		
	}
	public static void setlabel(int m,int i,int j) {
		if(blocks.containsKey((Integer)m)) {
			block b=blocks.get(m);
			ui.b[i][j].setText(b.zi[Math.abs(i+j+game.posx+game.posy)%b.zi.length]);
			ui.b[i][j].setTextFill(b.c);					
		}
	}
	public static void setmoblabel(int m,int i,int j) {
		if(m==2001) {
			ui.b[i][j].setText("人");
			ui.b[i][j].setTextFill(Color.WHITE);	
		}
		else if(m==1001) {
			ui.b[i][j].setText("门");
			ui.b[i][j].setTextFill(Color.WHITE);	
		}
	}
	public static void buildlight(int m,int i,int j) {
		if(game.lightf[100+i+game.posy][100+j+game.posx]!=0) {
			double l=(double)game.light[100+i+game.posy][100+j+game.posx]/(double)game.lightf[100+i+game.posy][100+j+game.posx];
			Color c=Color.valueOf(ui.b[i][j].getTextFill().toString());
			double r0=c.getRed(),g0=c.getGreen(),b0=c.getBlue();
			double r=r0+l/3,g=g0+l/3,b=b0+l/3;
			ui.b[i][j].setTextFill(Color.color((r<0?0:(r>1?1:r)),(g<0?0:(g>1?1:g)),(b<0?0:(b>1?1:b)),1));
		}
//		try {
//			Class<?> c=Class.forName("lvls.lvl"+game.lvlat);
//			Object o=c.newInstance();
//			Method me=c.getMethod("buildlight",int.class,int.class,int.class);
//			me.invoke(o,m,i,j);	
//		} catch (Exception e) {
//			//e.printStackTrace();
//		}
	}
}