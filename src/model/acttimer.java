package model;

import java.util.HashMap;

import javafx.animation.AnimationTimer;

public class acttimer extends AnimationTimer{
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String[] getCzs() {
		return czs;
	}
	public void setCzs(String[] czs) {
		this.czs = czs;
	}
	public String getActs() {
		return acts;
	}
	public void setActs(String acts) {
		this.acts = acts;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public HashMap<String, Integer> getFlags() {
		return flags;
	}
	public void setFlags(HashMap<String, Integer> flags) {
		this.flags = flags;
	}
	public String cz="";
	public String[] czs=new String[8];
	public String acts="";
	public int mobid;
	public long stt;
	public int itv;//一个动作的延迟，总延迟为timer1的200ms
	public int times;
	public HashMap<String,Integer> flags=new HashMap<String,Integer>();
	public int getMobid() {
		return mobid;
	}
	public void setMobid(int mobid) {
		this.mobid = mobid;
	}
	public long ontime;
	public long getStt() {
		return stt;
	}
	public void setStt(long stt) {
		this.stt = stt;
	}
	public int getItv() {
		return itv;
	}
	public void setItv(int itv) {
		this.itv = itv;
	}
	public long getOntime() {
		return ontime;
	}
	public void setOntime(long ontime) {
		this.ontime = ontime;
	}
	public void handle(long now) {
	}
}


