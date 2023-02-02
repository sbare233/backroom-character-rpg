package sub;

import java.io.File;

import br.rw;
import br.ui;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class setting extends Stage{
	final String infos="开发：sbare233\n本游戏根据The Backrooms中文维基改编，遵循CC-BY-SA协议，任何人可以对本软件进行修改和发行以及商业用途，并同样遵循CC-BY-SA协议";
	Button back,infob,save ,open;
	TextArea infoa;
	Pane all;
	GridPane p,infopane;
	Scene s;
	FileChooser fc=new FileChooser();
	public setting(){
		setOnCloseRequest(e->{ui.showshezhif=0;});
		all=new Pane();
		p=new GridPane();
		all.getChildren().add(p);
		p.setPrefSize(200,300);
		p.setAlignment(Pos.TOP_CENTER);
		p.add(infob=new Button("版权信息"),0,0);
		infob.setFont(ui.bfont);
		infopane=new GridPane();
		infob.setOnMouseClicked(e->{
			all.getChildren().clear();
			all.getChildren().add(infopane);
		});
		back=new Button("←");
		back.setOnMouseClicked(e->{
			all.getChildren().clear();
			all.getChildren().add(p);
		});
		p.add(save=new Button("保存"),0,1);
		save.setFont(ui.bfont);
		save.setOnMouseClicked(e->{
			fc.setInitialDirectory(new File(rw.path));
			File f=fc.showSaveDialog(getOwner());
			//TODO
		});
		p.add(open=new Button("读取"),0,2);
		open.setFont(ui.bfont);
		open.setOnMouseClicked(e->{
			fc.setInitialDirectory(new File(rw.path));
			File f=fc.showOpenDialog(getOwner());
			//TODO
			
		});
		infopane.add(back,0,0);
		infopane.add(infoa=new TextArea(infos),0,1);
		infoa.setPrefSize(200, 280);
		infoa.setWrapText(true);
		infoa.setEditable(false);
		s=new Scene(all);
		setScene(s);
	}
}
