//Level 120
// 
//
//生存难度：
//等级 2
//
// 
// 
// 
//level120.jpg
//其中一个服务器机房中的计算机显示块的图片
//
//Level 120为后室的第121层级。层级中不同的屋室内皆呈现出同样重复的损坏的服务器机房的样貌。其中一些的服务器可以生成白色的空屋或是漆黑的走廊。
//
//描述：
//Level 120包含有损毁的服务器机房，房内不再光洁的白地板上摊着很多支离破碎的计算机显示块。墙壁木制，已有腐烂，上贴有略脏的黄色墙纸。天花板由普通办公室的房顶铺砖构成，上装有已破碎或有故障的荧光灯。屋内多漆黑一片，光线都来自于第二类更为奇怪的房间之中。服务器机房以15-23个为一组。
//
//Level 120的第二类房间为白色空屋。它们以6-12间个为一组，其中有黑色的门可以通向其他白色房间。笑魇往往为房间的空旷所吸引，虽然它们常常沉溺于该房间自然发出的光中，但它们仍然会攻击你。
//
//最后一类房间为漆黑走廊。其狭小且极长，可以连接到不同的服务器机房。虽然此处很少有实体存在，不过由于在这里容易绊倒，故不建议走过这里，如果你被绊倒了，便很有可能伤到你自己，而且会意外产生此处三个实体之一——亚故障干扰体。
//
//寻找白色空屋或漆黑走廊较为容易，只需要找到一个比较完整的计算机显示块。将其启动，便可“载入”漆黑走廊或白色空屋。若想要逃离这些房间，需要一直沿着一个方向走，即可达到该组房间的边缘。在每组房间的边缘都存在有一些窗口，这些窗口通向带你到该子域的计算机显示块。由于这些窗口多已被打碎，所以你平常不需要再打破它们了。
//
//基地、前哨与社区：
//此层级中无已知基地、社区或前哨。
//
//故障干扰体
//故障干扰体为那些由死在后室中的人化成的僵尸般的故障体。在其他层级中变为故障干扰者的概率不大，但是在该层级死去的每一个人几乎都会变成故障干扰体。
//
//故障干扰体呈现为黑色的人形。其为像素块包裹，在死者的致命伤处会留下红色的印记，若其死于内伤，它们便通体成黑色。
//
//这写生物会使用尖锐的触手来攻击猎物。它会用触手切开猎物，要么使对象见红，要么直接毙命。如果仅仅让猎物流血，这时便会创造亚故障干扰体从而杀死猎物。
//
//亚故障干扰体
//亚故障干扰体为一个故障干扰体产生出来的各种繁殖体，当有人的体液或器官暴露于该层级中时，亚故障干扰体便会滋生。从一滴血到一节肠道，其可以从任何东西中侵入人体。它们的攻击方式与故障干扰体完全相同，即使用像素触手刺砍，但相对来说，故障干扰体的这种杀戮更具敌意且效率高。
//
//虽然上面两种实体都很危险，但是偶然遇见或生成的概率并不高，因此Level 120的生存难度只有2级。
//
//入口与出口：
//入口
//若要进入，你可以使用Level 25中的一个屏幕破碎的街机。街机的颜色不重要，你也可以通过打碎其他街机的屏幕来开启Level 25的通往本层级的门径。又或者你可以在Level 4.3中发现一扇标着“服务器机房”的门，通过该门即可来到此层级。
//
//出口
//若要离开，你可以在服务器机房或漆黑走廊中发现可以把你带回Level 4.3的门径，或者从服务器机房的墙壁切出，即可达到Level 70。
package lvls1x;

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

public class lvl120{}