package sub;

import br.p;
import br.ui;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class wendang extends Stage{
	public wendang(String s) {
		this(s,"black","white");
	}
	public wendang(String s,String color,String fcolor){
		Pane all=new Pane();
		TextArea info =new TextArea();
		info.setPrefSize(400, 350);
		info.setWrapText(true);
		info.setEditable(false);
		info.setText(s);
		info.setStyle("-fx-text-inner-color:"+color+";-fx-control-inner-background:"+fcolor+";");
		ScrollPane sp=new ScrollPane(info);
		all.getChildren().add(sp);
		Scene sc=new Scene(all);
		setScene(sc);
	}
	int i=0;
	public wendang(String[] ss){
		this(ss, Color.WHITE,Color.BLACK);
	}
	public wendang(String[] ss, Color color,Color fcolor) {
		FlowPane all=new FlowPane();
		TextArea info =new TextArea();
		Background b=new Background(new BackgroundFill(color, null, null));
		info.setPrefSize(400, 350);
		info.setWrapText(true);
		info.setEditable(false);
		info.setText(ss[i]);
		String red=Integer.toHexString((int)(color.getRed()*255)),
			green=Integer.toHexString((int)(color.getGreen()*255)),
			blue=Integer.toHexString((int)(color.getBlue()*255)),
			fred=Integer.toHexString((int)(fcolor.getRed()*255)),
			fgreen=Integer.toHexString((int)(fcolor.getGreen()*255)),
			fblue=Integer.toHexString((int)(fcolor.getBlue()*255));
		if(red.length()==1)red="0"+red;
		if(green.length()==1)green="0"+green;
		if(blue.length()==1)blue="0"+blue;
		if(fred.length()==1)fred="0"+fred;
		if(fgreen.length()==1)fgreen="0"+fgreen;
		if(fblue.length()==1)fblue="0"+fblue;
		String c=red+green+blue,
				fc=fred+fgreen+fblue;
		info.setStyle("-fx-text-inner-color:#"+fc+"ff;-fx-control-inner-background:#"+c+"ff;");
		ScrollPane sp=new ScrollPane(info);
		all.getChildren().add(sp);
		Button prev,next;
		all.getChildren().add(prev=new Button("上一份文件"));
		prev.setOnMouseClicked(e->{
			if(i>0&&i<ss.length)i--;
			info.setText(ss[i]);
		});
		all.getChildren().add(next=new Button("下一份文件"));
		prev.setBackground(b);
		prev.setTextFill(fcolor);
		next.setOnMouseClicked(e->{
			if(i>-1&&i<ss.length-1)i++;
			info.setText(ss[i]);
		});
		next.setBackground(b);
		next.setTextFill(fcolor);
		all.setBackground(b);
		Scene sc=new Scene(all);
		setScene(sc);
	}
}
