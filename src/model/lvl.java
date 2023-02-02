package model;

public class lvl {
	String lvlname,lvlid;
	int hardness,xxf;
	public lvl(String lvlname,String lvlid,int hardness,int xxf) {
		this.lvlname=lvlname;
		this.lvlid=lvlid;
		this.hardness=hardness;
		this.xxf=xxf;
	}
	public String getLvlname() {
		return lvlname;
	}
	public void setLvlname(String lvlname) {
		this.lvlname = lvlname;
	}
	public String getLvlid() {
		return lvlid;
	}
	public void setLvlid(String lvlid) {
		this.lvlid = lvlid;
	}
	public int getHardness() {
		return hardness;
	}
	public void setHardness(int hardness) {
		this.hardness = hardness;
	}
	public int getXxf() {
		return xxf;
	}
	public void setXxf(int xxf) {
		this.xxf = xxf;
	}
}
