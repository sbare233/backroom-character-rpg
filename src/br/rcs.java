package br;

import java.util.HashMap;

@SuppressWarnings("rawtypes")
public class rcs{
	static HashMap<String, HashMap> m;
	rcs(){
		if(m==null)
			m=new HashMap<String, HashMap>();
		m.put("craftlist",craft.craftlist);
		m.put("fumolist",fumo.fumolist);
		m.put("fxtls",fx.timelines);
		m.put("fxs",fx.fxs);
		m.put("fxm",fx.fxm);
		m.put("fxnc",fx.fxnamecount);
		m.put("mobs",game.mobs);
		m.put("quests",game.quests);
		m.put("stages",ui.stages);
		m.put("drops",ui.drops);
		m.put("wupinlist",wupinlist.list);
	}

}
