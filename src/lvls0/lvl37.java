package lvls0;
//Level 37
// 
//
//生存难度：
//等级 3
//
// 
// 
// 
//new37.jpg
//一张在蓝天下拍摄的Level 37的照片
//
//Level 37是后室的第38层，这一层级是一片不断延伸的丛林。
//
//描述：
//Level 37似乎是一个绵延不绝的拥有许多树木与可食用果实的丛林。这一层级的天空大多是不自然的紫色，但可以看到它变成天蓝色或石灰绿色。这里似乎有一条向多个方向分叉的土路，如果你离开这条路，它就会通向未知的丛林地区，这是非常危险的。如果你在任何一个路口一直朝一个方向走，它总是会指向相同的地方。如果你不断向左走，你最终会到达一个有另一条路的瀑布，要注意这个区域有穿得像18世纪20年代探险家的无面灵，他们通常持有手枪和步枪。如果你与他们相遇并且激怒了他们，他们会攻击你。他们有时会用被皮肤遮盖的嘴互相低语。
//
//继续沿着这条路走下去，你会来到一个被遗弃了很久的寺庙区。这个地区看起来像最初的玛雅文明，这里有前哨站和基地的残余，地板上散落着许多石碑，谈论着一个与其他团体合并为失落一族的组织-“失落的玛雅人”。这些石碑讲述了该组织的起源，并且说明了他们是怎么来到Level 37的。根据石碑的记载，这组人通过坐在一组位于丛林中央的办公椅上到达了Level 4。
//
//如果你不断向右走，你就会到达一个小木屋。这个屋子似乎是这些无面灵的主要基地，他们经常进出这座木屋。但如果你进入屋子，他们通常不会在那里。一旦你进入，你可能会遇到四种不同的情况。第一种可能发生的情况是，房间内的一切都很正常，没有什么异常。你可以在一个公告板上看到一些新闻剪报，内容是关于一群探险者组建探险队寻找古代寺庙和宝藏的故事;第二种情况开始于你打开门，你将到达一个似乎没有尽头的走廊，在你走了足够长的路之后，你最终会到达Level -1。第三种情况是，你会突发心脏病，大部分骨头会瞬间粉碎，或者你会变成一团雾。第四种情况，也是最奇怪的一种情况是，你最终会到达一个酒吧，在那里，员工会为你提供任何东西，因为你是“最忠实的顾客”，如果你要“特殊服务”，他会给你一杯不知道的东西。人们不知道喝下这种“饮料”后会发生什么。
//
//丛林的其余部分看起来非常随机且混乱，随机的建筑和房间出现在远离主要路径的地方，这些建筑大多以破坏物理的方式构造，这是不可能的。可以生成的实体有死亡飞蛾、钝人、杰瑞、窃皮者、悲尸和迷彩爬行者。这里也有各种各样生活在丛林中的普通动物，如各种鸟类、猴子、豹、大象等。被称为The Red Colony的实体组织也可以在这里找到。
//
//基地、前哨和社区
//尽管在Level 37中建立组织是可能的，但迄今为止，该层级依然没有任何一个组织被建立。
//
//入口与出口：
//入口
//进入Level 37是一件困难的事情，但这是值得的。当你到达Level 11时，你需要找到一个开阔的公园/场地。在草地上打滚，直到你晕过去。你会在丛林般的区域醒来，这里便是Level 37。深入Level 149中的障碍物也有小概率进入Level 37。
//
//出口
//如果要从该层级离开，你可以通过睡着的方式离开，然后你会在Level -2醒来，但并不推荐这样做。如果你在且只在日出的时候走向太阳，你会到达你进入Level 37时所使用的草地区域，这是你可以在不死亡的情况下离开这一层级的推荐方法。根据石碑上的记载，你还可以在丛林中找到一组办公椅并用它们进入Level 4。漫步到这一关卡的深处，有时会发现一片干燥的草地，然后你可以穿过草地进入Level 140。你可能还会在Level 37的中间发现一个小屋，进入它，盯着墙一段时间，然后回头，你会来到Level 62。有时候，丛林中的树木会不再像以前那样，它们会变得更像Level 39的树木，而不是Level 37的树木，这些树将围绕着一条明显不同的路径，如果你决定沿着它走，它将引导你到达Level 39。


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

public class lvl37{}