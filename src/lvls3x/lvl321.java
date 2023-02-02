//Level 321
// 
//
//生存难度：
//等级 4
//
// 
// 
// 
//paintroom
//一个放满了画作和美术用品的创作者工作室。
//
//Level 321 是后室的第322层。Level 321于最近被找到，并首先被一位从不知道何时睡下的床上醒来的探索者发现。
//
//描述:
//Level 321是一个巨大的，有着蜿蜒的走廊和许多中等尺寸的房间的层级，经常会出现有关动画的大量工具。这个地方看起来像是一个20世纪30年代的有着老旧的动画设备、故事板桌和弗莱彻时代风格人物的海报的动画工作室。
//奇怪的是，它也恰巧堆满了克伦威尔时代的剑、枪、盾以及其它的战争工具。
//该层级有未知数量的楼层，而这些楼层的尺寸可能是无限的。墙壁上经常被涂有从拟人物体到动物的粗略图片。墙壁通常是红色、蓝色、黄色和白色的。
//
//房间种类：
//创作者工作室
//这些是有着绘图桌、铅笔、彩铅、刷子、颜料、石雕工具、一面镜子、削木工具、缝纫工具和针织工具的房间。
//重要的是，如果一个人类试图画下一个 Entity 115，也被称为“文中人”的实例，在他们结束绘画或结束写下任何他们想要“文中人”所拥有的附加特征时，将会生成一个新的实体实例，并会像父母那样对待他们。大多数时候这些往往表现为儿童，除非你写下的那些文字并非如此。
//
//住宅
//这些房间是能找到的最普遍的，并且或多或少是酒店房间。它们有两个15×8英尺的浴室和一个25×30英寸的卧室。
//
//神圣房间
//这些房间就像教堂中主要区域里人们坐等服务的地方。通向这里的门被涂上了一个金色的J。这些房间经常空空如也，布满灰尘，但井井有条。
//
//“文中人”
//它们是该层级所产，但是它们几乎已经偏向于Level 10。它们有着黑色瘦长的卡通四肢并且在脸上绘有黑色圆点样的眼睛和一个在闭上时表现为一条线的嘴巴。值得注意的奇怪的地方是，当它们张开嘴巴说话或进食时，它们拥有卡通一样的牙齿和舌头。
//
//它们往往十分迷信，并且会讲述不同且被认为有趣的都市传说和有奇怪崇拜的人类，一些选择尽它们所能保护他们，除非人类先攻击它们。它们有属于它们自己的正常运作的社会，并会竭尽全力保护它们的社区免受如笑魇、窃皮者等敌对实体的侵害。
//
//入口与出口：
//入口
//要进入这里，你可以在Level 13的一栋公寓中的地板上手持写生簿入睡，然后你会在Level 321醒来。从Level 57中的一副绘有一张放有美术用品的桌子的画切出也会带你来这。
//
//出口
//如果你找到了一扇贴着一张有一捆谷物的图片的门，走进它，你将会到达Level 10。在一个月的时间中于同一个卧室过夜会在第五周的第一天把你带回Level 13。
package lvls3x;

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

public class lvl321{}