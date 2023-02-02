//Level C-328
//评分: 
//+9
//+
//–
//X
// 
//
//生存难度：
//等级 3
//
//不安全且不稳定
//实体绝迹
//剪辑危害
//Level C-328是后室C层群的第328层。
//
//描述
//Level C-328是一座无限大的城市，里面充满了楼房，商店和摩天大厦。包括了可以在前厅中找到的城市建筑，这些建筑里的内部构造和家具是随机的，并且这里的某些建筑可以进入，而某些则不可以。这里的混凝土人行道大部分是正常的，但人行道有时会通向死胡同，或卡在建筑物中。有些人行道就像一个斜坡一样通向天空。Level C-328的环境是温暖又干燥的。这里的商店虽然是废弃的，但偶尔会出现一些有用的物品。
//
//在Level C-328你可以在饮水机、商业冰柜、苏打水自动售货机等地获取杏仁水，你也可以在一些建筑物的内部发现糖果、火盐、皇家口粮等等一些对流浪者有帮助的物品，并且这些物品可以带出层级。所以此层级可以作为收集物资的主要层级之一。
//
//虽然上述描述让流浪者认为Level C-328和Level 11相似，但与Level 11不同的是，Level C-328的建筑风格更偏向于动画，比如这里一些事物有和动画一样看起来光滑的感觉，并且这些建筑物的建筑材料的外表能鉴定出有一些艺术加工的成分，并且这里的建筑物的外表被用颜料进行各种各样的涂鸦。这让Level C-328看起来更像是Level 94和Level 11的结合，并且这里和前厅一样有昼夜分明。
//
//特殊事件记录
//虽然Level C-328看起来很安全，但Level C-328每隔5～10分钟就会发生以下特殊事件的其中一种，故M.E.G. 建议流浪者不要在Level C-328内逗留的时间过长。
//
//时间的不稳定变化
//Level C-328的时间不会像在前厅的时间一样正常运转。相反，Level C-328的时间反而是以一种故障的形式存在的1，其对流浪者的正常活动造成的影响会表现为以下形式：
//
//流浪者有时会以2分钟之前做的动作按照原来的运动轨迹做回2分钟之前的状态2。
//流浪者有时会突然快速3或者慢速做某个动作，又或者流浪者会频繁的做同一个动作。
//流浪者有时会卡在一个动作上静止不动。
//这些情况会导致流浪者不能在Level C-328进行正常的活动。
//
//凭空出现的一些东西
//在Level C-328的高空中有时会突然出现一些杂乱无章线条或者图形，这些杂乱的线条或图形会在空中快速的放大和缩小，等到这些线条或图形有了固定形状时会从高空中掉到地面上4或者是在半空中凭空消失，这些线条或者图形在掉在地上一段时间之后也会消失。流浪者如果不注意到就会被砸到然后严重受伤。
//
//“某些无形的力量”
//尽管这种情况比较少见，但当这种情况发生的时候，流浪者会感觉到自己在被一种无形的力量拽住衣服一样，然后流浪者会被拽到空中进行不规则的快速运动，最后会被拽到层级的一些地方5，等到这种感觉停下的时候流浪者才能继续行动。
//
//失去的画面
//有时在Level C-328你可能会注意到，你看到的画面会突然变成1～3分钟后的画面，中间被截掉的画面就算是用摄像机拍摄也不会拍摄到对应的画面，但如果询问当时在Level C-328的流浪者时，流浪者却还能口述到1～3分钟之前发生的画面。
//
//基地、前哨与社区
//因为本层级的特性，所以无法在此建立基地。
//
//入口和出口
//入口
//在Level C-303如果遭遇巨大的地形转变有较大的概率会传送至此层级。
//有传闻说Level 16的一次地形转变中有到达这里的入口，但未经证实，因此不建议去尝试。
//在任何层级（除了前厅）使用电子设备下载有关视频剪辑的软件并使用其剪辑视频就会有几率会传送至此层级
//在Level 11找到一处看起来像动画风格的地方，切入它会来到此层级
//出口
//在未被杂乱的线条或者图形砸到的情况下切入它大概率会来到Level 94。
//如果切入建筑物有小概率来到Level 11。
//在此层级有时会出现不是动画风格的地方，切入它会来到Level 11。
//作者信息
//« Level C-327 | Level C-328 | Level C-329 »
//
//Footnotes
//1. 带入此层级的闹钟和秒表也会失灵。
//2. 如果在此时发出的声音也会被倒放
//3. 最快会快到肉眼也会无法识别到流浪者。
//4. 在流浪者重新进入的时候这些东西会消失。
//5. 或者是被拽到高空中掉下而死。
package lvls13x;

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

public class lvl1328{}