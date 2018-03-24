import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

//直線を描くクラス
public class LineFigure extends Figure implements  Serializable{
	public LineFigure(int x,int y,int w,int h,Color c) {
		super(x,y,w,h,c);//Figureクラスのコンストラクタを呼び出す
	}
	//位置とサイズを再設定
	public void reshape(int x1,int y1,int x2,int y2) {
		  setLocation(x1,y1);
		  setSize(x2,y2);
		}
	//色を設定し、直線を描く
	public void draw(Graphics g){
	g.setColor(color);
	g.drawLine(x, y, width, height);
	
	}
}
