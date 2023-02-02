package br;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class clickwear implements EventHandler<MouseEvent>{
	public void handle(MouseEvent e) {
			for (int j = 0; j < 9; j++) {
				if (e.getSource() == ui.wearb[j]) {
					// "0戒指", "1头部", "2项链", "3左手", "4护甲", "5右手", "6左腿", "7背包", "8右腿"
					// 0:不可穿戴 1.戒指 2.头 3.项链 4左手 5护甲 6右手 7左腿 8背包 9右腿
					// 10四肢 11双手同时使用 12双手皆可 13双腿同时 14背后护甲皆可 15头项链戒指皆可 16所有位置同时 17所有位置皆可
					if (ui.wearb[j].onuse == 1) {
						ui.wearb[j].onuse = 0;
						ui.wearb[j].setText(wupinlist.wearposition[j]);
						ui.wearb[j].setBackground(ui.backg);
						game.weard[j]=null;
					} else if (ui.wearb[j].onuse == 11) {
						ui.wearb[3].onuse = 0;
						ui.wearb[3].setText(wupinlist.wearposition[3]);
						ui.wearb[3].setBackground(ui.backg);
						game.weard[3]=null;
						ui.wearb[5].onuse = 0;
						ui.wearb[5].setText(wupinlist.wearposition[3]);
						ui.wearb[5].setBackground(ui.backg);
						game.weard[5]=null;
					} else if (ui.wearb[j].onuse == 13) {
						ui.wearb[6].onuse = 0;
						ui.wearb[6].setText(wupinlist.wearposition[j]);
						ui.wearb[6].setBackground(ui.backg);
						game.weard[6]=null;
						ui.wearb[8].onuse = 0;
						ui.wearb[8].setText(wupinlist.wearposition[j]);
						ui.wearb[8].setBackground(ui.backg);
						game.weard[8]=null;
					} else if (ui.wearb[j].onuse == 16) {
						for (int l = 0; l < 9; l++) {
							ui.wearb[j].onuse = 0;
							ui.wearb[j].setText(wupinlist.wearposition[j]);
							ui.wearb[j].setBackground(ui.backg);
							game.weard[j]=null;
						}
					} else if (br.game.onuse.type == 5){
						int k = br.game.onuse.waerposotion;
						int y = 0;
						if (k == 1 && j == 0)
							y = 1;
						else if (k == 2 && j == 1)
							y = 1;
						else if (k == 3 && j == 2)
							y = 1;
						else if (k == 4 && j == 3)
							y = 1;
						else if (k == 5 && j == 4)
							y = 1;
						else if (k == 6 && j == 5)
							y = 1;
						else if (k == 7 && j == 6)
							y = 1;
						else if (k == 8 && j == 7)
							y = 1;
						else if (k == 9 && j == 8)
							y = 1;
						else if (k == 10 && (j == 3 || j == 5 || j == 6 || j == 8))
							y = 1;
						else if (k == 11 && (j == 3 || j == 5))
							y = 2;
						else if (k == 12 && (j == 3 || j == 5))
							y = 1;
						else if (k == 13 && (j == 6 || j == 8))
							y = 2;
						else if (k == 14 && (j == 4 || j == 7))
							y = 1;
						else if (k == 15 && (j == 0 || j == 1 || j == 2))
							y = 1;
						else if (k == 16)
							y = 2;
						else if (k == 17)
							y = 1;
						if (y == 1) {
							// bagid指代防御力，text指代附魔，onuse指代穿着状态
							ui.wearb[j].setText(br.game.onuse.name);
							ui.wearb[j].setBackground(ui.backlg);
							ui.wearb[j].onuse = 1;
							game.weard[j]=br.game.onuse;
						} else if (y == 2) {
							if (k == 11) {
								ui.wearb[3].setText(br.game.onuse.name);
								ui.wearb[5].setText(br.game.onuse.name);
								ui.wearb[3].setBackground(ui.backlg);
								ui.wearb[5].setBackground(ui.backlg);
								ui.wearb[3].onuse = 11;
								ui.wearb[5].onuse = 11;
								game.weard[3]=br.game.onuse;
								game.weard[5]=br.game.onuse;
							} else if (k == 13) {
								ui.wearb[6].setText(br.game.onuse.name);
								ui.wearb[8].setText(br.game.onuse.name);
								ui.wearb[6].setBackground(ui.backlg);
								ui.wearb[8].setBackground(ui.backlg);
								ui.wearb[8].setText(br.game.onuse.name);
								ui.wearb[6].onuse = 13;
								ui.wearb[8].onuse = 13;
								game.weard[6]=br.game.onuse;
								game.weard[8]=br.game.onuse;
							} else if (k == 16) {
								for (int l = 0; l < 9; l++) {
									ui.wearb[j].setText(br.game.onuse.name);
									ui.wearb[j].setBackground(ui.backlg);
//									if (l == 0) {
//										ui.wearb[j].bagid = br.game.onuse.defense;
//										ui.wearb[j].text = br.game.onuse.fumo;
//									}
									ui.wearb[j].onuse = 16;
									game.weard[j]=br.game.onuse;
								}
							}
						}
					}
					
				}
			}
		fumo.refreashdefense();
	}
}
