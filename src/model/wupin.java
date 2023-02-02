package model;

import java.util.Objects;

import br.game;

public class wupin {
	public int id;
	public int type;
	public int value;
	public int attack;
	public int defense;
	public int eventkey;
	public int weight;
	public int usetime;
	public int waerposotion;
	//type:0.文本，堆叠999 1.材料，堆叠999；2.消耗品，堆叠999；3道具，不堆叠 4.武器，不堆叠；5.护甲，不堆叠；
	//eventkey触发事件
	//wearposition 0:不可穿戴 1.戒指 2.头 3.项链 4左手 5护甲 6右手 7左腿 8背包 9右腿
	// 10四肢 11双手同时使用 12双手皆可 13双腿同时 14背后护甲皆可 15头项链戒指皆可 16所有位置同时 17所有位置皆可
	public String pinyin;
	public String name;
	public String text;
	public String fumo;
	public double idd;
	public wupin(int id, int type,int value, int attack, int defense, 
			int eventkey,int weight,int usetime, int waerposotion,
			String pingyin,String name,String text,String fumo) {
		this.id = id;
		this.type = type;
		this.value = value;
		this.attack = attack;
		this.defense = defense;
		this.eventkey = eventkey;
		this.weight = weight;
		this.usetime=usetime;
		this.waerposotion = waerposotion;
		this.pinyin=pingyin;
		this.name=name;
		this.text = text;
		this.fumo = fumo;
		if(type>2)this.idd=Math.random();
		else this.idd=0;
	}
	public boolean equals(wupin w){
        if(id==w.id&&value==w.value&&
        		attack==w.attack&&defense==w.defense&&
        		pinyin.equals(w.pinyin)&&name.equals(w.name)&&
        		text.equals(w.text)&&fumo.equals(w.fumo)&&
        		idd==w.idd)
            return true;
        return false;
    }
	@Override
	public int hashCode() {
		return Objects.hash(attack, defense, eventkey, fumo, id, idd, name, pinyin, text, type, usetime, value,
				waerposotion, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		wupin other = (wupin) obj;
		return attack == other.attack && defense == other.defense && eventkey == other.eventkey
				&& Objects.equals(fumo, other.fumo) && id == other.id
				&& Double.doubleToLongBits(idd) == Double.doubleToLongBits(other.idd)
				&& Objects.equals(name, other.name) && Objects.equals(pinyin, other.pinyin)
				&& Objects.equals(text, other.text) && type == other.type && usetime == other.usetime
				&& value == other.value && waerposotion == other.waerposotion && weight == other.weight;
	}
	public int[] getAll() {
		int[] s= {
				this.type,
				0,
				this.value,
				this.attack,
				this.defense,
				this.weight,
				this.usetime,
				this.waerposotion
					};
		return s;
		
	}	
}
