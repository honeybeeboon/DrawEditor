import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.io.Serializable;

//監視対象である図形を設定するクラス
class DrawModel extends Observable implements Serializable{
	protected ArrayList<Figure> fig;//図形を保存するArrayList
	protected Figure drawingFigure;//図形を1つ取り出して保存
	protected Color currentColor;//色
	protected String kfigure;//図形の種類
	protected ViewPanel model;
	public DrawModel() {
		fig = new ArrayList<Figure>();
		drawingFigure = null; 
		currentColor = Color.black;  
		kfigure="Line";
	}
	//図形の色を設定
	void setPanelColor(Color c){
		currentColor=c;
	}
	//メニューのStringを受け取って図形の種類を設定
	public void setfigure(String s){
		kfigure=s;
	}
	//図形のリストを返す
	public ArrayList<Figure> getFigures() {
		return fig;
	}
	//任意の図形を取り出して返す
	public Figure getFigure(int idx) {
		return fig.get(idx);
	}
	//最新１つの図形を削除
	public void undo(){
		fig.remove(fig.size()-1);
		setChanged();
		notifyObservers();

	}
	//パネルの図形を全て削除
	public void clear(){
		fig.clear();
		setChanged();
		notifyObservers();

	}


	public void createFigure(int x,int y) {
		//図形オブジェクトを作成しリストfigに保管
		Figure f=null;;
		if(kfigure.equals("Rectangle"))f= new RectangleFigure(x,y,0,0,currentColor);
		else if(kfigure.equals("Circle"))f= new CircleFigure(x,y,0,0,currentColor);
		else if(kfigure.equals("Line"))f= new LineFigure(x,y,x,y,currentColor);
		else if(kfigure.equals("fillCircle"))f= new FillCircleFigure(x,y,0,0,currentColor);
		else if(kfigure.equals("fillRectangle"))f= new FillRectangleFigure(x,y,0,0,currentColor);
		else if(kfigure.equals("Round"))f= new RoundFigure(x,y,0,0,currentColor);
		fig.add(f);
		drawingFigure = f;
		//図形が変更されたらフラグを立て、オブザーバーに伝える
		setChanged();
		notifyObservers();
	}
	
		//図形を更新する。図形が変更されたことをオブザーバーに伝える
	public void reshapeFigure(int x1,int y1,int x2,int y2) {
		if (drawingFigure != null) {
			drawingFigure.reshape(x1,y1,x2,y2);
			setChanged();
			notifyObservers();
		}
	}


}





