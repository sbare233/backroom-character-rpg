package sub;

import br.initial;
import br.ui;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class midiplayer extends GridPane{
	public Thread runner;
	public Label label;
	public Slider s=new Slider(),progress=new Slider();
	public static ComboBox<String> midis=new ComboBox<String>();
	public static int onplayf;
	public midiplayer() {
		super();
		label = new Label("暂停");
		label.setFont(ui.bfont);
		add(midis,0,0);
		add(label, 0, 1);
		add(progress, 0, 2);
		//add(s,0,3);
		if (runner == null) {
			runner = new midiplayer1();
			runner.start();
		}
		midis.setOnAction(e->{
			midiplayer1.songFile=midis.getSelectionModel().getSelectedItem();
			midiplayer1.player.stop();
			midiplayer1.r();
			if(initial.inif==1)
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				midiplayer1.player.start();
				midiplayer1.player.setLoopCount(100000);
			label.setText("暂停");
		});
		/*progress.setOnMouseEntered(e->{
			onplayf=0;
			new p(midiplayer1.player.getMicrosecondPosition());
		});
		progress.setOnMouseExited(e->{
			long l=(long) (midiplayer1.player.getMicrosecondLength()*progress.getValue());
			new p(l);
			midiplayer1.player.setMicrosecondPosition(l);
			onplayf=1;
		});
		s.setOnDragDropped(e->{
		//	midiplayer1.player.set
		});*/
		label.setOnMouseClicked(e->{
			if(onplayf==0) {
				onplayf=1;
				label.setText("暂停");
				midiplayer1.player.start();
			}
			else {
				onplayf=0;
				label.setText("播放");
				midiplayer1.player.stop();
			}
		});
	}
	public static void qiege(String name) {
		midiplayer.midis.getSelectionModel().select(name+".mid");
		midiplayer1.songFile=midiplayer.midis.getSelectionModel().getSelectedItem();
		midiplayer1.player.stop();
		midiplayer1.r();
		midiplayer1.player.start();
		midiplayer1.player.setLoopCount(100000);
	}
}
