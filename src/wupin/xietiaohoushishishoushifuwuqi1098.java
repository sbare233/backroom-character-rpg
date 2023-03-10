//Object C-98 - “协调后室时授时服务器”
//评分: +49+–x
//
//
//物品编号：C-98
//覆盖范围：一切Wi-Fi覆盖的层级
//描述
//Flashingsecond.gif
//图中的闪烁约为一秒一次
//
//协调后室时授时服务器是一项基于协调后室时Coordinated Backroom Time纪年方式、藉由网络时间协议NTP提供精确后室时间与所处层级时间的服务器系统。该服务器系统由后室家居生产厂设立，致力于向所有身处后室的流浪者提供精准且通用的后室标准时间。
//
//协调后室时（BTC）
//协调后室时（Coordinated Backroom Time, BTC）是奠基于前厅协调世界时Coordinated Universal Time的后室时间标准。其以原子时的秒长1为基础，在时刻上尽量接近于协调世界时，以配合流浪者的使用习惯。
//
//BTC偏移量，即各层级的时区由以下形式表示：BTC-[l]:[aaaa]:[bbbb]:[cccc]-[d]。
//
//“l”为该层级的序号，以“L”+“层群编号”+“层级编号”组成，i层群编号可省略。
//
//例：Level C-102将转写为“LC102”。
//
//【问】：若为隐藏层级的场合应如何处理？
//【答】：[调整中]
//
//“a”指代所在层级客观时间尺度与Level 0客观时间尺度的比值。
//
//例：若层级x的时间流逝1秒的同时，在Level 0同势能的空间下于这段时间经过了2秒，则该层级“a”取值为00.50。
//
//“b”指代所在层级主观时间尺度与Level 0主观时间尺度的比值。
//
//该项取值通常为[01.00]。在部分阶层中，生命体的主观时间尺度将会与客观尺度脱节。即生物体可能能够于该阶层的1客观秒内做出正常层级数客观秒内的行为，或需要数客观秒才能够做到正常层级1客观秒就能完成的事情。
//例：若一位于Level 0、100m短跑平均成绩为10秒的流浪者，在技术与体力相同的情况下、于客观时间尺度与Level 0相同的层级y同势能的空间下100m短跑平均成绩为1秒，则该层级y的“b”取值为00.10。
//
//“c”为该层级中时间不稳定程度的标识，以第一位数字表示该层级客观时间尺度的不稳定性、第二位数字则表示该层级主观时间尺度的不稳定性。c的两位数字取值越大，该层级中的时间则越不可信。
//
//0	无任何波动，本层级时间流逝遵循相对论原理。
//1~3	层级时间尺度波动率۞＜0.01秒/每秒，仅需求精密计时的科学研究者应注意此等级的时间波动。
//4~6	层级时间尺度波动率 0.01秒/每秒≤۞＜1秒/每秒 ，该层级的时间波动将对流浪者的日常生活造成一定影响。
//7~8	层级时间尺度波动率 1秒/每秒≤۞＜10秒/每秒，该层级的时间波动将被视为层级间的主要灾害性影响之一。
//9	层级时间尺度波动率 10秒/每秒≤۞，通常不建议任何流浪者进入该层级。
//i	特殊符号，标明时间在该层级不存在意义，或时间以一种无法理解的形式运作。
//“d”为存在某种程度的循环（如昼夜循环）时，依照此循环所界定的“一日”等同于的该层级客观标准小时的数量，以代表该层级时区下一日的计数方式。当该层级不存在可界定日期的循环时，以∅或省略该项表示。
//
//例：若层级z一昼夜为72小时，则该层级z的“d”取值为72。
//
//
//由于各层级时间状态的不一致性，各层级的时区表示法将配合独立的时区时使用，以匹配该层级的状态。若需要进行通讯交流等跨层级行为时，请参考服务器提供的协调后室时2与本层级的时区表示，进行合理的时间调配。
//技术原理
//介于B.F.P.F.与黑星的技术授权协议，该服务器的相关技术详细信息将于2050年4月11日前处于绝密状态。
//
//·协调世界时的同步依赖于Wi-Fi传来的、来自前厅的时间戳。本服务器将持续监听自前厅传来的时间戳，结合铯原子钟的读数，对协调后室时进行实时的修正调整3。
//·层级时区时的设立与修正依赖于各层级的报告与分析结果。若您发现您所处层级的时间与本服务器层级时区编号所表述的情况不一致，或您对现在仍未勘探完全的层级有所了解，请登录time.bfpf.com并留言说明，我们将尽快予以答复。感谢您的支持与理解。
//·据[已编辑]研究，层级的时间状态与层级秘钥震动频率的分型具有正相关，根据对已有层级的层级秘钥进行扫描分析，便可在不长期滞留于层级的情况下分析与界定危险层级的时间数据。若您有未完全勘探层级的层级秘钥且有意协助我们，请携带层级秘钥前往Level C-45进行频率扫描。我们将于网站中记录您的名字与贡献，以表您对于本服务器与“时间度量统一工程”的卓越贡献。
//
//接入方式
//计算机设备：
//打开“控制面板” > “时钟和区域” > “设置时间和日期” > “Internet时间” > “更改设置”
//将时间服务器更改为 time.bfpf.com 或 time.bfpf.br
//对于需要精确时间刻度的用户，请使用 time.bfpf.br/TAI.css 以获取前厅国际原子时授时。
//
//移动设备：
//在计算机端下载并安装Android Debug Bridge工具
//将手机连接至计算机
//打开控制台，输入：
//adb shell settings put global ntp_server time.bfpf.com
//确认手机NTP服务信息，输入：
//adb shell settings get global ntp_server
//确认无误即可
//
//Footnotes
//1. 1单位秒的定义为：当位于该层级的铯-133原子非扰动基态的超精细能级跃迁频率ΔνCs以单位 Hz（即s−1）表示时，将其固定数值取为 9192631770。位于Level 0时的1秒时间尺度与前厅等同，为协调后室时的基准时间单位。
//2. 即Level 0时区下的基准协调后室时，BTC-L0:01.00:01.00:00。
//3. 协调世界时将通过不规则的加入闰秒以抵消地球自转的影响，本服务器将对此进行实时调整。
package wupin;

public class xietiaohoushishishoushifuwuqi1098 {

}
