import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.*;

public class CircleFigure extends Figure implements  Serializable{//楕円を描くクラス

	public CircleFigure(int x,int y,int w,int h,Color c) {
		super(x,y,w,h,c);//Figureクラスのコンストラクタをsuperで呼び出す
	}
	//図形を更新する(位置とサイズを再設定)
	public void reshape(int x1,int y1,int x2,int y2) {
		int newx = Math.min(x1,x2);
		int newy = Math.min(y1,y2);
		int neww = Math.abs(x1-x2);
		int newh = Math.abs(y1-y2);
		setLocation(newx,newy);
		setSize(neww,newh);
	}
	//色を設定し位置(x,y)サイズ(width,height)の楕円を描く
	public void draw(Graphics g){
		g.setColor(color);
		g.drawOval(x, y, width, height);

	}


	

}
