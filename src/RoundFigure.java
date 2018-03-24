import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.*;
//楕円を縦横に複数重ねた図形を描くクラス
public class RoundFigure extends Figure implements  Serializable{
	public RoundFigure(int x,int y,int w,int h,Color c) {
		super(x,y,w,h,c);
	}
	//位置と大きさを再設定
	public void reshape(int x1,int y1,int x2,int y2) {
		int newx = Math.min(x1,x2);
		int newy = Math.min(y1,y2);
		int neww = Math.abs(x1-x2);
		int newh = Math.abs(y1-y2);
		setLocation(newx,newy);
		setSize(neww,newh);
	}
	//色を設定し、図形を描く
	public void draw(Graphics g){
		int i;
		g.setColor(color);
		for(i=0;width-40*i>0||height-40*i>0;i++){
			   g.drawOval(x+20*i, y, width-40*i, height);
		 	    g.drawOval(x, y+20*i, width, height-40*i);
			
		}

	}

}
