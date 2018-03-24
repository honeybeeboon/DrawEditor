import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//マウスによる動作を設定するリスナークラス
class DrawController implements MouseListener,MouseMotionListener {
	protected DrawModel model;
	protected int dragStartX,dragStartY;
	public DrawController(DrawModel a) {
		model = a;
	}
	public void mouseClicked(MouseEvent e) { }
	//マウスが押されたら開始位置を設定し、図形を作成
	public void mousePressed(MouseEvent e) {
		dragStartX = e.getX(); dragStartY = e.getY();
		if(SwingUtilities.isRightMouseButton(e) == true)
			       model.undo();
		 else if(SwingUtilities.isLeftMouseButton(e) == true)
			 model.createFigure(dragStartX,dragStartY);
			         }
	//マウスが押された状態から戻ったら図形を更新
	public void mouseReleased(MouseEvent e) { 
		model.reshapeFigure(dragStartX,dragStartY,e.getX(),e.getY());
	}
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { 
		
	}
	//マウスがドラッグされたら図形を更新
	public void mouseDragged(MouseEvent e) {
		model.reshapeFigure(dragStartX,dragStartY,e.getX(),e.getY());
	}
	public void mouseMoved(MouseEvent e) { 
		
	}
}