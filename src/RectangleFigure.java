import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.*;

//四角形を描くクラス
public class RectangleFigure extends Figure implements  Serializable {
	public RectangleFigure(int x,int y,int w,int h,Color c) {
		super(x,y,w,h,c);//Figureクラスのコンストラクタを呼び出す
	}
	//位置とサイズを再設定
	public void reshape(int x1,int y1,int x2,int y2) {
		int newx = Math.min(x1,x2);
		int newy = Math.min(y1,y2);
		int neww = Math.abs(x1-x2);
		int newh = Math.abs(y1-y2);
		setLocation(newx,newy);
		setSize(neww,newh);
	}
	//色を設定し、直線を描く
	public void draw(Graphics g){
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}

}
