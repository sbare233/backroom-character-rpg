//Level C-253
//评分: 
//+10
//+
//–
//X
// 
//
//生存难度：
//等级 3
//
// 
// 
// 
//Level C-253是后室C层群的第253层。
//
//ZDhmNWFhNC5qcGVn.jpg
//两个“巨型墙面”结构相接处（在有光单元格内拍摄）
//
//描述
//Level C-253由无数个规格为20m×20m×20m的灰白色立方体框架结构构成。框架的每条边都是底面为2m×2m规格的正方形的四棱柱。为了方便表达，一个立方体框架被称为一个单元格。
//
//该层级为无重力环境，流浪者可以利用框架向各方向移动。在该层级中，向远处观望仅能观测到黑色的虚空般的景象，而少部分框架内存在无形的光源1。此种光源出于未知原因仅能照亮一个单元格内的物体，即使能从稍近处观察到亮光。因此建议流浪者携带发光物品以安全地在该层级内穿梭。
//
//由于该层级缺少重力、高度对称，且能见度较低，故在刚进入层级时流浪者难以辨别方向。任何在框架上做标记的尝试都以失败告终。当一个区域缺少流浪者的观察时，该区域似乎会自动恢复原状。然而，实体和流浪者不会因此消失。有流浪者尝试利用这一点，通过观察实体分布的密度以辨别位置。
//
//少数单元格的中心会存在物品，包括但不限于食物、未知用途的金属零件，一些手写的纸条。一些纸条有用各国语言书写的诗句，其上的内容被描述为“圣洁的，宁静的”，一般与“深渊”一词有关;还有少部分用未知语言书写的句子，目前还无法被理解。
//
//该层级有多种结构，目前被探明的结构类型如下:
//
//- 收起
//最常见的结构，特征为内部中空。
//
//- 收起
//一般呈3×3×3的立方体结构。该结构通常会堆积在一起，而一“堆”的数量一般为3~6个。其中的液体被证实为杏仁水。该结构数量稀少，且在黑暗环境中难以被察觉。出于未知原因，其中的杏仁水不会溢出，即使有流浪者在其中制造扰动。此外，不要试图穿过该结构，否则您极有可能被困住。
//
//- 收起
//该结构十分罕见，起初被认为是Level C-253的边界。该结构是一面横跨至少300个单元格长度的墙。由于面积广大而且通常亮度不足，爬菌会在上面生成。所以如果您看见前方为实心墙，请立刻返回，不要逗留。
//
//- 收起
//该结构为一个立方体顶点处的黑色装置。其形状为球形，其表面分布着复杂的纹路。若流浪者用手指沿着纹路滑动超过10秒，则该结构发出一团明亮的蓝光，随后，这种光线如同电流，以较快的速度沿着立方体的边开始传导。这将导致体积为36个单元格的区域全部被短暂地照亮，而这会吸引实体的注意力。所以强烈建议不要触摸装置。
//
//
//
//该层级中的实体仅有爬菌和空间爬行者。其中爬菌的数量最多，分布也最广泛。由于该层级不存在重力，爬菌将可以在空间内自由移动，变得更加危险。因此建议至少两人一组在该层级探索，不要单独行动。
//基地、前哨与社区
//“测绘小队”
//由25人组成，态度友好，自称拥有丰富的物资。
//热衷于在该层级寻找方向。可以向你指出离他们最近的各种结构的位置。
//驻扎在数个有光区间附近。与M.E.G驻Level C-253基地有频繁的交流。
//M.E.G驻Level C-253基地
//由480名成员组成，驻扎在三个最近的“水立方”结构之间。已经尽可能地布置力量防范实体。
//接纳所有友善的流浪者。
//入口与出口
//入口
//在Level 11的建筑工地内停留超过30分钟可将您送到该层级。
//在Level C-128的卡勒巴格房间里的终端先后输入“x/y/z=n,n∈Z”后选择“确认”将把您传送到该层级。
//出口
//在“巨型墙面”切出可以去往Level 0。
//在“水立方”中失去意识可能死亡，也可能将你送到Level 7。
//与另一名流浪者在同一时间内触发“节点”装置，并且“节点”发出的光芒相遇时，两名流浪者都将被送往Level 1。
//在任何一个有光单元格内停留超过五天将把你送到Level 12。
//作者信息
//« Level C-252 | Level C-253 | Level C-254 »
//
//Footnotes
//1. 在该区域内观测到的虚空将变为白色，但仍然无法看清远处的其他结构
package lvls12x;

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

public class lvl1253{}