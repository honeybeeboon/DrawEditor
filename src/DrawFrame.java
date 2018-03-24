import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class DrawFrame extends JFrame implements ActionListener{

	DrawModel model;
	ViewPanel view;
	DrawController cont;

	JMenuItem mi10,mi11,mi12,mi13,mi21,mi22,mi23,
	mi24,mi25,mi26,mi31;//メニューアイテム
	public DrawFrame(){
		model=new DrawModel();
		cont =new DrawController(model);
		view=new ViewPanel(model,cont);
		this.setBackground(Color.black);//背景の設定
		this.setTitle("Draw Editor");//タイトルの設定
		this.setLayout(new GridLayout(1,1));//レイアウト
		this.setSize(500,500);//フレームの大きさ
		this.add(view);

		//メニューバー
		JMenuBar menubar = new JMenuBar();
		//メニューの設定
		JMenu menu1 = new JMenu("menu");
		JMenu menu2 = new JMenu("Figure");
		JMenu menu3 =new JMenu("Color Chooser");
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		//メニューアイテムの設定
		mi13=new JMenuItem("save");
		mi10=new JMenuItem("close");
		mi31 =new JMenuItem("color");
		mi21 = new JMenuItem("Circle");mi11=new JMenuItem("Undo");
		mi12=new JMenuItem("Clear");
		mi22 = new JMenuItem("fillCircle");mi23 = new JMenuItem("Line");
		mi24 = new JMenuItem("Rectangle");mi25 = new JMenuItem("fillRectangle");
		mi26 = new JMenuItem("Round");
		//それぞれのメニューにメニューアイテムを追加
		menu1.add(mi10);menu3.add(mi31);menu1.add(mi13);
		menu1.add(mi11);menu1.add(mi12);
		menu2.add(mi21); menu2.add(mi22); menu2.add(mi23);
		menu2.add(mi24); menu2.add(mi25);menu2.add(mi26);
		setJMenuBar(menubar);
		//ActionListerに登録
		mi10.addActionListener(this);
		mi11.addActionListener(this);mi13.addActionListener(this);
		mi21.addActionListener(this);mi12.addActionListener(this);
		mi22.addActionListener(this);mi23.addActionListener(this);
		mi24.addActionListener(this);mi25.addActionListener(this);
		mi31.addActionListener(this);mi26.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	//メニューが押された時の反応を設定
	public void actionPerformed(ActionEvent e){ 
		if (e.getSource()==mi11) model.undo();
		else if(e.getSource()==mi10) System.exit(0);
		else if (e.getSource()==mi12) model.clear();
		else if (e.getSource()==mi21) model.setfigure("Circle");
		else if (e.getSource()==mi22) model.setfigure("fillCircle");
		else if (e.getSource()==mi23) model.setfigure("Line");
		else if (e.getSource()==mi24) model.setfigure("Rectangle");
		else if (e.getSource()==mi25) model.setfigure("fillRectangle");
		else if (e.getSource()==mi26) model.setfigure("Round");
		//ColorChooser
		else if (e.getSource()==mi31){
			JColorChooser colorchooser = new JColorChooser();
			Color color = colorchooser.showDialog(this, "Choose Color", Color.white);
			if(color != null){
				model.setPanelColor(color);
			}
		}

		else if(e.getSource()==mi13){
			try{

				System.out.println("ファイル名を指定してください");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String name = reader.readLine();

				ObjectOutput out = new ObjectOutputStream(new FileOutputStream(name));
				ArrayList <Figure> fig=model.getFigures();
				int size=fig.size();
				for (int i=0; i<size; i++) {
					out.writeObject(fig.get(i));
				}

				out.flush();
				out.close();
				reader.close();

				System.out.println(name + "に保存されました");
			}catch (FileNotFoundException d) {
				d.printStackTrace();
			} catch (IOException d) {
				d.printStackTrace();
			}	
		}
	}
//メイン関数
	public static void main(String argv[]) {
		new DrawFrame();
	}
}
