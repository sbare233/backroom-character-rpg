package sub;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.ui;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class videotoascii extends Stage{
	public static double x1,x2,x3,y1,y2,y3,it=4;
	public static float r1=1,g1=1,b1=1;
	public static int onf=0,ht=100,wt=100,big=5;
	public static Slider[] sb=new Slider[10];
	public static Label[][] lbs;
	public static String pic="./touxiang/1.jpeg";
	public static String base = "　，一二和紫龓";
	public static TextField tf,hf,wf,bf;
	public static Pane p;
	public static BorderPane all;
	public static GridPane gp;
	public static ScrollPane sp;
	Timeline t=new Timeline(new KeyFrame(Duration.millis(300),e1->{
		onf=0;
	}));
	public videotoascii(){
//		base = touxz.getText();
		gp=new GridPane();
		p=new Pane();
		sp=new ScrollPane(p);
		all=new BorderPane();
		for(int i=0;i<10;i++) {
			gp.add(sb[i]=new Slider(),0,i);
			sb[i].setOnMouseDragged(e->{
				if(onf==0) {
					get();
					onf=1;
					t.play();
				}
			});
		}
		sb[0].setValue(100);
		sb[1].setValue(100);
		sb[2].setValue(100);
		sb[3].setValue(0);
		sb[4].setValue(60);
		sb[5].setValue(0);
		sb[6].setValue(60);
		sb[7].setValue(100);
		sb[8].setValue(100);
		sb[9].setValue(40);
		gp.add(tf=new TextField(),0,10);
		tf.setText("1.jpeg");
		GridPane gp1;
		gp.add(gp1=new GridPane(),0,11);
		gp1.add(new Label("长"), 0, 0);
		gp1.add(hf=new TextField("100"), 1, 0);
		hf.setPrefWidth(70);
		gp1.add(new Label("宽"), 2, 0);
		gp1.add(wf=new TextField("100"), 3, 0);
		wf.setPrefWidth(70);
		gp1.add(new Label("大"), 4, 0);
		gp1.add(bf=new TextField("5"), 5, 0);
		bf.setPrefWidth(50);
		lbs=new Label[100][100];
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				lbs[i][j]=new Label();
				p.getChildren().add(lbs[i][j]);
				lbs[i][j].setPadding(new Insets(0,0,0,0));
				lbs[i][j].setPrefSize(5,5);
				lbs[i][j].setFont(ui.dfont); 
				lbs[i][j].setTranslateY(5*i);
				lbs[i][j].setTranslateX(5*j);
				lbs[i][j].setBackground(ui.backbl);
			}
		}
		p.setPrefSize(500,500);
		p.setBackground(ui.backbl);
		all.setLeft(sp);
		all.setRight(gp);
		Scene sc=new Scene(all);
		this.setScene(sc);	
		get();
	}
	public void get() {
		pic="./touxiang/"+tf.getText();
		r1 = (float) sb[0].getValue() / 100;
		g1 = (float) sb[1].getValue() / 100;
		b1 = (float) sb[2].getValue() / 100;
		x1 = sb[3].getValue() / 100;
		x2 = sb[4].getValue() / 100;
		y1 = sb[5].getValue() / 100;
		y2 = sb[6].getValue() / 100;
		x3 = sb[7].getValue() / 100;
		y3 = sb[8].getValue() / 100;
		it = sb[9].getValue() / 10;
		int h1=Integer.parseInt(hf.getText());
		int w1=Integer.parseInt(wf.getText());
		int big1=Integer.parseInt(bf.getText());
		if(h1!=ht||w1!=wt||big1!=big) {
			ht=h1;
			wt=w1;
			big=big1;
			Font f=new Font("Dialog", big);
			p.getChildren().clear();
			lbs=new Label[(int) ht][(int) wt];
			for(int i=0;i<ht;i++) {
				for(int j=0;j<wt;j++) {
					lbs[i][j]=new Label();
					p.getChildren().add(lbs[i][j]);
					lbs[i][j].setPadding(new Insets(0,0,0,0));
					lbs[i][j].setPrefSize(big,big);
					lbs[i][j].setFont(f); 
					lbs[i][j].setTranslateY(big*i);
					lbs[i][j].setTranslateX(big*j);
					lbs[i][j].setBackground(ui.backbl);
				}
			}
			p.setPrefSize(wt*5,ht*5);
			all.setPrefSize(gp.getWidth()+wt*5, ht*5);
			this.setMinWidth(gp.getWidth()+wt*5.25);
			this.setMinHeight(ht*5.25);
		}
		vap(pic,x1,x2,y1,y2,x3,y3,it);
	}
	public void vap(String path,double startx,double endx,double starty,double endy,double w,double l,double it) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(w, l), null);
            Image i = ato.filter(image, null);
            image=(BufferedImage)i;
            int k=0;
            for (int y = (int) (image.getHeight()*starty); y < image.getHeight()*endy&&k<ht; y +=it) {
                int m=0;
            	for (int x = (int) (image.getWidth()*startx); x < image.getWidth()*endx&&m<wt; x+=it) {
                	int pixel = image.getRGB(x, y);
                    int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    float gray = r1 * r/5 + g1 * g/5 + b1 * b/5;
                    int index = Math.round(gray * (base.length() + 1) / 255);          
                    String s3=(index>= base.length() ? base.substring(base.length()-1, base.length()) :(""+base.charAt(index)));
                    lbs[k][m].setText(s3);
                    lbs[k][m].setTextFill(Color.color(r1*r/255,g1*g/255,b1*b/255));      
                    m++;
            	}
            	k++;
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
