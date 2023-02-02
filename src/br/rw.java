package br;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import model.acttimer;
import model.mob;
import model.wupin;
import sub.wendang;

public class rw {
	static String[] a=new String[50];
	public static String path=System.getProperty("user.dir");
	static ObservableList<String> readmid() {
		File f1=new File(path+"/midis");
		String[] ss=f1.list();
		ObservableList<String> os=FXCollections.observableArrayList(ss);
//		for(String s1:ss) {
//			os.add(s1);
//		}
		return os;
	}
//	static String[] findfiletype(String[] ss,String type) {
//		int i=0;
//		String[] ss1=new String[150];
//		for(String s:ss) {
//			if(s.toLowerCase().endsWith(type)) {
//				ss1[i]=s;
//				i++;
//			}
//		}
//		return ss1;
//	}
	static void readrenwu(File f){
		try {
			 InputStream fi=new FileInputStream(f);
	            Scanner sc=new Scanner(fi);
	            game.man.setName(sc.next());
	            game.man.setHp(sc.nextInt());game.man.setSn(sc.nextInt());
	            game.man.setMp(sc.nextInt());game.man.setSt(sc.nextInt());game.man.setSp(sc.nextInt());
	            game.man.setDx(sc.nextInt());game.man.setSa(sc.nextInt());game.man.setEy(sc.nextInt());
	            game.man.setLu(sc.nextInt());game.man.setLo(sc.nextInt());
	            game.lvlat=sc.nextInt();status.hp=sc.nextInt();status.sn=sc.nextInt();
	            status.mp=sc.nextInt();status.weight=sc.nextInt();
	            sc.nextLine();
	            while(sc.hasNext()) {	
	            	//sc.nextLine();
	            	int id = sc.nextInt();
					int type = sc.nextInt();
					int value = sc.nextInt();
					int attack = sc.nextInt();
					int defense = sc.nextInt();
					int eventkey = sc.nextInt();
					int weight = sc.nextInt();
					int usetime = sc.nextInt();
					int waerposotion = sc.nextInt();
					String pinyin = sc.next();
					sc.nextLine();
					String name = sc.nextLine();
					String text = sc.nextLine();
					String fumo = sc.nextLine();
					wupin w=new wupin(id,type,value,
							attack,defense,eventkey,weight,usetime,waerposotion,
							pinyin,name,text,fumo);
		            game.bag.put(w,sc.nextInt());
		            sc.nextLine();
		            String s1=sc.nextLine();
		            Scanner sc2=new Scanner(s1);
		            while(sc2.hasNext()) {
		            	int wearpos=sc2.nextInt();
				        ui.wearb[wearpos].setText(w.name);
						ui.wearb[wearpos].setBackground(ui.backlg);
						ui.wearb[wearpos].bagid = w.defense;
						game.weard[wearpos]=w;    
		            }
		            sc2.close();
	            }
	            fumo.refreashdefense();
	            sc.close();
	            fi.close();
        } 
		catch (IOException e) {}
	}
	static void saverenwu(File f){
		try {
			if(initial.inif==0) {
				if(!f.exists())
					f.createNewFile();
				 OutputStream fw=new FileOutputStream(f);
				 BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fw,"UTF-8"));
					bw.write(game.man.getName()+" "+game.man.getHp()+" "+game.man.getSn()+" "
		            +game.man.getMp()+" "+game.man.getSt()+" "+game.man.getSp()+" "
		            +game.man.getDx()+" "+game.man.getSa()+" "+game.man.getEy()+" "
		            +game.man.getLu()+" "+game.man.getLo()+"\n"
		            +game.lvlat+" "+status.hp+" "+status.sn+" "+status.mp+" "+status.weight+"\n"+"\n");
					for(wupin w:game.bag.keySet()) {
						//new wupin(i, i, i, i, i, i, i, i, i, null, null);
						bw.write(w.id+" "+w.type+" "+w.value+" "+w.attack+" "+
							w.defense+" "+w.eventkey+" "+w.weight+" "+w.usetime+" "+w.waerposotion+" "+
							w.pinyin+"\n"+w.name+"\n"+w.text+"\n"+w.fumo+"\n"+
							(game.bag.containsKey(w)?game.bag.get(w):1)+"\n");
						for(int i=0;i<9;i++) {
					        if(game.weard[i]!=null&&game.weard[i].equals(w))bw.write(i+" ");
						}
						bw.write("\n");
					}
					
		            bw.close();
		            fw.close();
		            //System.out.print("saved");   	
			}
        } 
		catch (IOException e1) {
			//System.out.print("x");
		}
	}	
	public static String reads(String s) {
		File f=new File(s);
		String s1="";
		InputStream fi = null;
		try {
			fi = new FileInputStream(f);
			Scanner sc=new Scanner(fi);
			while(sc.hasNextLine()) {
				s1+=sc.nextLine();
				s1+="\n";
			}
			sc.close();
			fi.close();
		} catch (Exception e) {
		}
		
		return s1;
	}
	public static void writes(String s,String v) {
		try {
		File f=new File(s);
		OutputStream fo =new FileOutputStream(f);;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fo,"UTF-8"));
		Scanner sc=new Scanner(v);
		while(sc.hasNextLine()) {
			bw.write(sc.nextLine()+"\n");
		}
		sc.close();
		bw.close();
		fo.close();
		} catch (Exception e) {
		}
	}
	static void readwupin(String s){
		try {
			File f=new File(s);
			InputStream fi = new FileInputStream(f);
			Scanner sc = new Scanner(fi);
			while (sc.hasNext()) {
				int id = sc.nextInt();
				int type = sc.nextInt();
				int value = sc.nextInt();
				int attack = sc.nextInt();
				int defense = sc.nextInt();
				int eventkey = sc.nextInt();
				int weight = sc.nextInt();
				int usetime = sc.nextInt();
				int waerposotion = sc.nextInt();
				String pinyin = sc.next();
				sc.nextLine();
				String name = sc.nextLine();
				String text = sc.nextLine();
				String fumo = sc.nextLine();
				wupinlist.list.put(pinyin+String.valueOf(id),new wupin(id,type,value,
						attack,defense,eventkey,weight,usetime,waerposotion,
						pinyin,name,text,fumo));
				//向列表中添加物品放到sc.nextLine()下面去会失效，尚不清楚原因
				sc.nextLine();
			}
			sc.close();
			fi.close();
		} catch (Exception e) {
		}
	}
	public static void readcft(String s) {
		try {
		File f=new File(s);
		InputStream fi = new FileInputStream(f);
		Scanner sc = new Scanner(fi);
		while (sc.hasNext()) {
			craft.craftlist.put(sc.nextLine(),sc.nextLine());
		}
		sc.close();
		fi.close();
		} catch (Exception e) {}
	}
	public static void readmob(String s) {
		File f=new File(s);
		InputStream fi=null;
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(fi);
		String l1=sc.nextLine();
		Scanner sc1=new Scanner(l1);
		sc1.nextInt();
		int y=sc1.nextInt(),x=sc1.nextInt(),mapy=sc1.nextInt(),
				mapx=sc1.nextInt(),life=sc1.nextInt(),type=sc1.nextInt();
		String  name=sc1.next();
		int id1=0;
		if(game.mobs.containsKey(type))
			id1=game.mobs.get(type).size();
		sc1.close();
		HashMap<String,Integer> buffrange=new HashMap<String,Integer>();
		HashMap<Integer,wupin> w=new HashMap<Integer,wupin>();
		HashMap<Integer,Double> chance=new HashMap<Integer,Double>();
		HashMap<String,acttimer> act=new HashMap<String,acttimer>();
		String l2=sc.nextLine();
		sc1=new Scanner(l2);
		while(sc1.hasNext())
			buffrange.put(sc1.next(),sc1.nextInt());
		sc1.close();
		String l3=sc.nextLine();
		sc1=new Scanner(l3);
		while(sc1.hasNext())
			w.put(sc1.nextInt(),wupinlist.list.get(sc1.next()));
		sc1.close();
		String l4=sc.nextLine();
		sc1=new Scanner(l4);
		while(sc1.hasNext())
			chance.put(sc1.nextInt(),sc1.nextDouble());
		sc1.close();
		

		while(sc.hasNext()){
			String l=sc.nextLine();
			if(!l.equals("结束"))
				a[act.size()]=l;
			if(l.equals("结束")) {
				//new p(a+"\n");
		

			acttimer at=new acttimer() {
				public void handle(long now) {
					if(stt==0) {
						stt=now;
					}	
					if(now-stt>itv*10000000&&game.stopf==0) {//如果达到间隔进入选择器
						stt=now;
						times++;
						switch(cz) {
							case "移动":{
								int mx=Integer.parseInt(czs[0]);
								int my=Integer.parseInt(czs[1]);
								game.mobs.get(type)
								.get(mobid).move(my,mx);
							}
							case "打开面板":{
								if(!flags.containsKey("openf"))
									flags.put("openf",0);
								if(flags.get("openf")==1) {
									flags.put("openf",0);
									String[] ss=new String[7];
									for(int i=0;i<7;i++) {
										ss[i]=rw.reads("juqing/0/新手指南"+String.valueOf(i+1)+".txt");
									}
									new wendang(ss,new Color(0.955,0.905,0.814,1.000),Color.BLACK).show();
								}
							}
							case "右键效果":{
								if(!flags.containsKey("lreffectf"))
									flags.put("lreffectf",0);
								if(flags.get("lreffectf")==1) {
									flags.put("lreffectf",0);
									int lvl=Integer.parseInt(czs[0]);
									int chs=Integer.parseInt(czs[1]);
									try {
									Class<?> c=Class.forName("lvls"+lvl/100+".lvl"+lvl);
									Object o=c.newInstance();
									Method m1=c.getMethod("lreffect",int.class);
									m1.invoke(o,chs);	}catch(Exception e) {}
								}
							}
						}
					}
				}
			};
			
			String cz1 = "";
			String[] czs=new String[10];
			Scanner sc2=new Scanner(a[act.size()]);
			while(sc2.hasNext()) {	
				String li=sc2.nextLine();
				Scanner rl=new Scanner(li);
				at.setItv(rl.nextInt());
				cz1=rl.next();
				for(int ci=0;rl.hasNext();ci++) {
					czs[ci]=rl.next();
				}
				rl.close();
			}
			sc2.close();
			//new p(cz1+"\n");
			at.setCz(cz1);
		//	new p(czs[0]+"\n"+"\n");
			at.setCzs(czs);
			act.put(cz1, at);
		}
			
		}
		//new p(act.size()+"\n");
		sc.close();
		//new p(id1);
		mob m=new mob(id1,y,x,mapy,mapx,life,type,name,buffrange,w,chance,act);
		mob.moblist.put(type+name, m);
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
