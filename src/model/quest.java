package model;
//读取文件 文件包含npc产生条件，在进入关键节点时遍历quest表的产生方法
public class quest {
	public int id;
	String name;
	String intro;
	String npckey;
	public quest(int id, String name, String intro, String npckey) {
		super();
		this.id = id;
		this.name = name;
		this.intro = intro;
		this.npckey = npckey;
	}
}
