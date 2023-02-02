//Level C-197
//评分: 
//+29
//+
//–
//X
// 
//
//生存难度：
//等级 1
//
// 
// 
// 
//C197.jpg
//Level C-197的一个楼梯。
//
//Level C-197是后室C层群的第197层。
//
//描述
//Level C-197是一座永无止境的，风格类似于19世纪欧洲的老式图书馆。图书馆一共两层，长度未知，宽度约10米，每一层的高度约3米，上楼的楼梯每隔10个书架出现一个。Level C-197内部所有光源都来自透过窗外模糊的米黄色窗纸的光。窗户每隔一个书架排布一个，且无法被打开或损坏。图书馆的某些书柜内会刷新包括杏仁水在内的一些基本生活物资。
//
//通过在本层级久居可得知，Level C-197外的“空间”并没有昼夜循环，任意时刻的光线强度都是固定的，这导致图书馆中心区域几乎永远处于黑暗状态。有许多未知实体在这片黑暗部分走动，因此请勿主动靠近中心区域。
//
//书架上排列着许多颜色和大小不同的书籍，当流浪者把书取下时，书架上贴的数字标签就会开始“借书时间”倒计时，若流浪者未在规定时间内归还书籍，书籍将会自动瞬移到原本的位置，如果这本书被带出了本层级，则其会瞬间消失，原书架上会多出一本该书的复制品。如果流浪者打翻一个书架，它将在瞬间恢复原状。
//
//造成本层级威胁性最大的因素是书籍内部的文字，当流浪者在阅读任何一本书籍时，都会产生“这本书文学内涵丰富”、“这本书很有吸引力”的想法，并不顾一切的将其读完（即使阅读者完全不认识上面的语言）。当他们读完一本书之后，就会进入“伪知识模式”，在这段时间内。他们会认为自己成为了某个领域的专家，并讲述一些完全不符合正常逻辑的怪话以及某些反常识的言论，包括但不限于：“水是剧毒的”、“人类是三角形的”、“黑色是最亮的颜色”。如果有人反驳他们的观点，他们将“据理力争”（那些理由基本上也是毫无逻辑的），和反驳者进行辩论，直到反驳者失去耐心认输为止。“伪知识模式”的持续时间由这本书的厚度而定，目前最长达到2个小时。
//
//以下是对进入“伪知识模式”的人士进行的提问调查：
//回答者在开始调查时阅读了一本计算机编程书
//
//提问一：1比2大吗？
//获得的答案：肯定是比2大，因为2不存在。
//
//追问一：2为什么会不存在呢？
//获得的答案：你是傻子吗？数字只有0和1，你拿1去和不存在的数比较，不存在的数怎么可能会比1大？
//
//回答者在开始调查时阅读了一本动物百科
//
//提问二：一般犀牛有几只角？
//获得的答案：当然是四只。
//
//追问二：我的意思是头上那个角。
//获得的答案：头上怎么可能长脚！你脑子有问题吧。
//
//回答者在开始调查时阅读了一本食品保健书
//
//提问三：水是有剧毒的吗？
//获得的答案：有。（随即，这位回答由于口渴而喝了一口杏仁水）
//
//追问三：你刚刚就喝了一口水，你不怕中毒身亡吗？
//获得的答案：杏仁水和水能一样嘛。
//
//（之后，这位回答者从味觉、颜色、甚至是口感上与提问者辩论了30分钟，直到提问者受不了逃离了现场。）
//
//基地、前哨与社区
//“之乎者也”书友会
//由6名流浪者组成的团体，一天中有一半时间用于读书和与其他人争论，争论内容已经超越了常人理解范围。请勿和这个团体产生任何交流，以免产生精神问题。
//入口与出口
//入口
//在Level C-67内找到并进入一扇牌子上写有“知识的海洋”的门可到达Level C-197。
//在Level C-199上找到一本封面写有“知识的海洋”的书，阅读完毕后即可被传送至Level C-197。
//在Level 33前50英里中找到一个“书店”商铺并进入，可到达Level C-197。
//出口
//连续阅读10本书且均未在“借书时间”倒计时以内归还，即可被传送至Level 4。
//第二层会极其罕见的刷新一个通向“第三层”的楼梯，向上即会到达Level C-83。
package lvls11x;

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

public class lvl1197{}