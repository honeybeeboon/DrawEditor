import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
//図形を監視するパネルのクラス
class ViewPanel extends JPanel implements Observer,Serializable {
  protected ArrayList<Figure> fig;
  protected DrawModel model;
  //パネルにマウスイベントを追加、
  public ViewPanel(DrawModel m,DrawController c) {
    this.setBackground(Color.white);
    this.addMouseListener(c);
    this.addMouseMotionListener(c);
    model = m;
    model.addObserver(this);
  }
  //図形をリストから取り出し、パネルに描く
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    fig = model.getFigures();
    for(int i = 0; i < fig.size(); i++) {
      Figure f = fig.get(i);
      f.draw(g);
    }
  }
  //図形を更新
  public void update(Observable o,Object arg){
    repaint();
  }
}