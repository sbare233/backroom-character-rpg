package sub;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.scene.control.TextArea;

/**
 * 将一张图片生成为字符画
 *
 * @author 11475
 * @author sbare remade
 *
 */
public class imagetoascii extends TextArea{
	public static double x1,x2,x3=0.2,y1,y2,y3=0.2;
	public static float r1,g1,b1;
	public static String pic="./touxiang/1.jpg";
	public static String base = "　，一二和紫龓";// 字符串由复杂到简单
	public imagetoascii(){
		String s=createAsciiPic(pic,x1,x2,y1,y2,x3,y3);
		this.setText(s);
	}
    public static String createAsciiPic(String path,double startx,double endx,double starty,double endy,double w,double l) {
        String s="";
        try {
            BufferedImage image = ImageIO.read(new File(path));
            AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(w, l), null);
            Image i = ato.filter(image, null);
            image=(BufferedImage)i;
            for (int y = (int) (image.getHeight()*starty); y < image.getHeight()*endy; y += 2) {
                for (int x = (int) (image.getWidth()*startx); x < image.getWidth()*endx; x++) {
                    int pixel = image.getRGB(x, y);
                    int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    float gray = r1 * r + g1 * g + b1 * b;
                    int index = Math.round(gray * (base.length() + 1) / 255);
                    String s3=base.substring(base.length()-1, base.length());
                    s+=(index>= base.length() ? s3 :base.charAt(index));
                }
                s+="\n";
            }
        } catch (final IOException e) {
        }
		return s;
    }
}