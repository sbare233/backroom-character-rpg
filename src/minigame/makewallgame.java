package minigame;

import br.game;
import br.p;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import lvlc.wallbuild;

public class makewallgame extends Stage{
	int[] arg= {1,1,1};
	Rectangle[][] rs=new Rectangle[100][100];
	int id;
	public makewallgame(){
		Pane all=new Pane();
		GridPane p=new GridPane();
		all.getChildren().add(p);
		p.setPrefSize(500,500);
		all.setPrefSize(700,500);

		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				rs[i][j]=new Rectangle(5,5);
				//rs[i][j].setFill(Color.BLACK);
				p.add(rs[i][j], j, i);
			}
		}
		GridPane p1=new GridPane();
		all.getChildren().add(p1);
		p1.setLayoutX(500);
		p1.setPrefSize(200, 500);
		for(id=0;id<1;id++) {
			Slider s=new Slider();
			p1.add(s,0,id);
			s.setOnMouseDragged(e->{
				//s.setValue(1);
				arg[id-1]=(int) s.getValue();
				//new p(arg[id-1]+"\n");
				makewall();
			});
		}
		
		Scene sc=new Scene(all);
		this.setScene(sc);
	}
	private void makewall() {
			//game.wallarg[0]=1;game.wallarg[1]=300;
			//game.wallarg[2]=1;game.wallarg[3]=7;
			//game.wallarg[4]=3;game.wallarg[5]=15;game.wallarg[6]=4;
		int[][] wall=wallbuild.build(new int[100][100],game.wallarg[0],game.wallarg[1],game.wallarg[2],game.wallarg[3],game.wallarg[4],game.wallarg[5],game.wallarg[6]);
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(wall[i][j]!=0&&wall[i][j]!=20)rs[i][j].setFill(Color.WHITE);
				else rs[i][j].setFill(Color.BLACK);
			}
		}
	}
}
