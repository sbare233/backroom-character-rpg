package sub;

import java.io.File;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class midiplayer1 extends Thread{
	public static Sequence currentSound;// 音序
	public static Sequencer player;// 默认音序器
	public static String songFile;// 歌曲
	public midiplayer1() {
		r();
	}
	static public void r() {
		try {
			File file = new File("midis/"+songFile);
			currentSound = MidiSystem.getSequence(file);// 获取音序文件
			player = MidiSystem.getSequencer();// 获取音序器
			player.open();
			player.setSequence(currentSound);// 设置音序器播放指定音乐文件
			player.start();
			player.setLoopCount(100000);
			midiplayer.onplayf=1;
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}
