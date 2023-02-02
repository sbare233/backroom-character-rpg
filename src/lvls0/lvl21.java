package lvls0;
//Level 21
// 
//
//生存难度：
//等级 4
//
// 
// 
// 
//level-21-cc.jpg
//Level 21的中间
//
//Level 21是后室的第22层。本层级包括四条长走廊以及走廊上随机放置的门。
//
//描述：
//Level 21是一包含了四条走廊的大层级。据估计，这些走廊都有大约26里长。这些走廊会在层级的中间交汇。本层级的中间是一个开放的小型广场，带有椅子和一张桌子。实体永远不会出现在该区域内，但会出现在走廊中。
//
//走廊被假定一直在变化，每隔一段时间就会移位并变形为新形态。这些走廊可能会变得无法被调查或被封锁。尽管这些走廊很诡异，但依旧存在一个常态。重复出现在走廊两侧的门将保持不变。这些门可以通向后室的随机位置，包括负层级和子层级。不过更多时候，它们会使你出现在Level 21的其他地方，或是让你撞墙。
//
//+ 展示已知门径
//本层级的走廊极端危险，有时会充满实体。实体的数量和类型会发生变化，尽管咔嗒机在本层级相对常见。在本层级曾目击过未知实体。走廊中也能发现随机物体，包括杏仁水，层级密钥，和火盐。其他物体则很少见。
//
//在本层级中发现的任何人都不能信任。不惜一切代价避免与他们接触。
//
//谣言说在一条走廊的“尽头”有一扇门，导致该走廊的长度比平时长很多。这扇门还没有被发现，但据说门后有宝贵的资源和许多有攻击性的实体。如果发现这扇门，不要进入它。应向M.E.G.报告。
//
//“出口”门的发现
//这扇谣传已久的门已被发现。它在前台右侧的走廊内，位于中间位置。这扇门上面有一个巨大的红色霓虹 "出口 "标志。这扇门在打开后将通向三条黑暗的走廊。这些走廊不会移位，并且其中会产生许多宝贵的资源。实体会成群结队地出现在这里，注意到它们有奇怪的组织方式。虽然这些走廊是无限的，但应注意观察每侧门设计的微妙变化，因为门的重复模式会随着走廊本身的不稳定增加而增加。这些重复的门不包含资源，只通向子层级和隐秘层级。建议不要去探索Level 21的这一部分。
//
//基地，前哨站和社区
//本层级没有已知的基地、前哨站和社区。
//
//入口和出口：
//入口
//可以通过进入Level 13墙壁上的各种裂口以抵达本层级。这些Warp Tears虽然在Level 11、Level 9和Level 6中偶尔也能遇到，但最稳定的是在Level 13和本层级之间，因发出尖声哀鸣而引人注意。层级之间的联系不详。本层级也可以从Level 1.5中通过随机机会穿墙进入。
//
//出口
//许多出口已在上文提及。


import java.util.Random;

import br.game;
import br.ui;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lvlc.randomdrop;
import model.wupin;
import sub.midiplayer;

public class lvl21{}