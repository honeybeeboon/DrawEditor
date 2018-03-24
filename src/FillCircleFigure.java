import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.*;
//塗りつぶしの楕円を描くクラス
public class FillCircleFigure extends Figure implements  Serializable{
	public FillCircleFigure(int x,int y,int w,int h,Color c) {
		super(x,y,w,h,c);//Figureクラスのコンストラクタを呼び出す
	}
	//図形の位置とサイズを再設定
	public void reshape(int x1,int y1,int x2,int y2) {
		int newx = Math.min(x1,x2);
		int newy = Math.min(y1,y2);
		int neww = Math.abs(x1-x2);
		int newh = Math.abs(y1-y2);
		setLocation(newx,newy);
		setSize(neww,newh);
	}
	//図形の色を設定し、塗りつぶし楕円を描く
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, width, height);

	}

}