package br;

import java.io.File;

import model.man;
import sub.makeman;

public class initial {
	public static int newf=0;
	public static int inif=0;
	public static String[] title={"","怎么会是呢","阈限空间","sssssssss boom!"};
	public static makeman makeman;
	public static String path="cundang.txt";
	public static File f;
	initial(){
		f=new File(path);
		if(!f.exists()) {
			inif=1;
			//tishi.intro();
			makeman=new makeman();
			ui.stages.get("make").show();
			ui.stages.get("main").setTitle("欢迎！");
			wupinlist.f();
			ui.midis=rw.readmid();
		}
		else {
			rw.readrenwu(f);
			ui.midis=rw.readmid();
			int r=(int)(Math.random()*title.length);
			ui.stages.get("main").setTitle(title[r]);
			ui.stages.get("main").show();			
			man.setman();
			wupinlist.f();
			ui.name.setText(game.man.name);
			juqing.pjuqing();
		}
	}
}
