package lvls0;
//Level 57
// 
//
//生存难度：
//等级 0
//
// 
// 
// 
//3RnEYYY_d.png
//“画家”的其中一幅画作，与Level 3的场景近似。
//
//Level 57是后室的第58层。它看起来像是一座庞大的画廊。
//
//描述：
//Level 57由两部分组成，此处分别称为“工作室”和“画廊”。
//
//Level 57的第一个部分，“画廊”，表现为经典的西方艺术画廊外观，但明显相对空旷许多：只陈列有后室相关的画作。这些画作的题材和风格各异，有的甚至采用了复杂的建筑平面图形式来表现。尽管存在一些差异，但“画廊”中的绝大部分画作都是后室中不同层级的不同艺术风格化的透视图。目前也已经发现了一幅似乎详细描绘Level 57本身的平面图，尽管其看上去杂乱无章，但被认为其中内容是有效的，可用于导航，该画作证明Level 57具有非随机的可理解的布局。从中可以看到“画家”不时会修改它。由于该层对人员施加的某种精神上的阻碍影响，触碰这些画作是不可能的。根据M.E.G.所记录，没人能够摆脱这种影响。
//
//可经由一组偶尔出现在画廊内的双开门进入“工作室”。认为它们不难找到，但通常需要进行大范围的搜索，因为双开门的出现位置似乎很自然地避开了流浪者。“工作室”是一个占地很大的区域，里面摆满了绘画用材和未完成的画作。当其中没有流浪者时，工作室的布局和内容似乎会发生变化，但总存在一个固定的独立区域供“画家”工作。虽然画廊里摆满了有关后室的画像，但工作室里的布局似乎表现了前厅中的人物、地点和物体。
//
//基地、前哨和社区
//该层没有已知的基地或前哨站。
//
//
//“画家”
//“画家”是一个行为消极的友好实体，外表为中等身高的年轻女性，有长长的棕色头发，瞳孔是一种无法描述的颜色。除非画家要去画廊中摆放一幅新画作，否则她不会离开工作室。尽管画家绘制了许多描写后室的画像，但她似乎对后室一无所知，并在得知后也会经常忘记自己身处后室中。画家是唯一完全了解Level 57平面结构的实体，但她拒绝透露任何相关信息，声称这些知识是“商业机密”。
//
//入口和出口：
//入口
//Level 57可通过Level 0中的画作切入，或经由打开并通过位于Level 21的华丽门扉来进入。尝试移动Level 283中某幅描绘忧虑小丑的画作也会将流浪者传送到Level 57。
//
//出口
//可以向画家询问通往出口的路，她会指引你去往位于工作室一头的一扇锁住的门。画家可以经由请求打开这扇门，即打开了通往Level 21的出口。也可通过画廊中的某幅画来切出，这将导向画中描绘的层级。不建议通过非后室题材的画作切出，因为这会随机你的目的地。


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

public class lvl57{}