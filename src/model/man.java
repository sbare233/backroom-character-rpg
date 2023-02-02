package model;

import br.game;
import br.status;
import br.ui;

public class man {
	public String name;
	public int hp,sn,mp,st,sp,dx,sa,ey,lu,lo;
	//"气血","毅力","智慧","力量","速度","灵巧","口才","见识","运气","外貌"
	public man(String name, int hp, int sn, int mp, int st, int sp, int dx, int sa, int ey, int lu, int lo) {
		this.name = name;
		this.hp = hp;
		this.sn = sn;
		this.mp = mp;
		this.st = st;
		this.sp = sp;
		this.dx = dx;
		this.sa = sa;
		this.ey = ey;
		this.lu = lu;
		this.lo = lo;
	}
	public man() {
	}
	public static void setman() {
		ui.hp.setText("生命  "+String.valueOf(status.hp)+"/"+String.valueOf(game.man.getHp()));
		double i=(double)status.hp/game.man.getHp();
		ui.hps.setWidth(i*200);
		ui.sn.setText("意志  "+String.valueOf(status.sn)+"/"+String.valueOf(game.man.getSn()));
		i=(double)status.sn/game.man.getSn();
		ui.sans.setWidth(i*200);
		ui.mp.setText("魔力  "+String.valueOf(status.mp)+"/"+String.valueOf(game.man.getMp()));
		i=(double)status.mp/game.man.getMp();
		ui.mps.setWidth(i*200);
		ui.weight.setText("负重  "+String.valueOf(status.weight)+"/"+String.valueOf(game.man.getSt()+status.space));
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getSt() {
		return st;
	}
	public void setSt(int st) {
		this.st = st;
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getSa() {
		return sa;
	}
	public void setSa(int sa) {
		this.sa = sa;
	}
	public int getEy() {
		return ey;
	}
	public void setEy(int ey) {
		this.ey = ey;
	}
	public int getLu() {
		return lu;
	}
	public void setLu(int lu) {
		this.lu = lu;
	}
	public int getLo() {
		return lo;
	}
	public void setLo(int lo) {
		this.lo = lo;
	}
}
