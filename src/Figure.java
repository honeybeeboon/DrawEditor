import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Figure {//全ての図形クラスの親となるクラス
	public int x,y,width,height,r;
	public Color color;
	public Figure(int x,int y,int w,int h,Color c) {
		//位置(x,y)とサイズ(width,height),色を定義
		this.x = x; this.y = y;  
		width = w; height = h;   
		color = c;  
	
	}
	public void setSize(int w,int h) {//図形の幅と高さを設定
		width = w; height = h;
	}
	public void setLocation(int x,int y) {//図形の位置を設定
		this.x = x; this.y = y;
	}
	
	//以下はそれぞれの図形クラスでオーバーライドするため未定義
	public void reshape(int x1,int y1,int x2,int y2) {
	}
	public void draw(Graphics g){
	}
}

