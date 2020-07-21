import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame {
	public int method=0;
	private int over=0;
	public void initialize(){
		JFrame f=new JFrame("Calculator");
		f.setLocation(500,200);
		f.setSize(350, 300);
		f.setResizable(false);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);;
			}
		});
		f.setLayout(new FlowLayout());
		
		JTextField t1=new JTextField(8);
		JTextField t2=new JTextField(8);
		JLabel e1=new JLabel("=");
		JTextField t3=new JTextField(8);
		
		JPanel pan1=new JPanel();
		pan1.setLayout(new FlowLayout());
		pan1.add(t1);
		pan1.add(t2);
		pan1.add(e1);
		pan1.add(t3);
		
		JTextField t4=new JTextField(8);
		JTextField t5=new JTextField(8);
		JLabel e2=new JLabel("=");
		JTextField t6=new JTextField(8);
		
		JPanel pan2=new JPanel();
		pan2.setLayout(new FlowLayout());
		pan2.add(t4);
		pan2.add(t5);
		pan2.add(e2);
		pan2.add(t6);
		
		JLabel l1=new JLabel("——————");
		JLabel l2=new JLabel("——————");
		JLabel l3=new JLabel("——————");
		
		JPanel pan3=new JPanel();
		pan3.setLayout(new FlowLayout());
		pan3.add(l1);
		pan3.add(l2);
		pan3.add(l3);
		
		
		JButton add=new JButton("+");
		add.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				method=1;
			}
		});
		JButton minus=new JButton("-");
		minus.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				method=2;
			}
		});
		JButton multiply=new JButton("*");
		multiply.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				method=3;
			}
		});
		JButton divide=new JButton("/");
		divide.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				method=4;
			}
		});
		JButton equal=new JButton("=");
		equal.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Fraction left=new Fraction();
				Fraction right=new Fraction();
				if(t1.getText()!="" && t4.getText()!=""){
					left.nume=Integer.parseInt(t1.getText());
					left.deno=Integer.parseInt(t4.getText());
					left.simplify();
					}
				if(t2.getText()!="" && t5.getText()!=""){
					right.nume=Integer.parseInt(t2.getText());
					right.deno=Integer.parseInt(t5.getText());
					right.simplify();
				}
				Fraction leftShadow=new Fraction(left);
				Fraction rightShadow=new Fraction(right);
				switch(method){
				case 1:
					leftShadow.add(rightShadow);
					t3.setText(String.valueOf(leftShadow.nume));
					t6.setText(String.valueOf(leftShadow.deno));
					break;
				case 2:
					leftShadow.minus(rightShadow);
					t3.setText(String.valueOf(leftShadow.nume));
					t6.setText(String.valueOf(leftShadow.deno));
					break;
				case 3:
					leftShadow.multiply(rightShadow);
					t3.setText(String.valueOf(leftShadow.nume));
					t6.setText(String.valueOf(leftShadow.deno));
					break;
				case 4:
					leftShadow.divide(rightShadow);
					t3.setText(String.valueOf(leftShadow.nume));
					t6.setText(String.valueOf(leftShadow.deno));
					break;
				}
				
				/*
				switch (method){
				case 1:	
					double temp1=Double.parseDouble(t1.getText())+Double.parseDouble(t2.getText());
					temp1*=10000;
					int trans1=(int)temp1;
					temp1=trans1/10000;
					t3.setText(String.valueOf(temp1));
					break;
				case 2:
					double temp2=Double.parseDouble(t1.getText())-Double.parseDouble(t2.getText());
					temp2*=10000;
					int trans2=(int)temp2;
					temp2=trans2/10000;
					t3.setText(String.valueOf(temp2));
					break;
				case 3:
					double temp3=Double.parseDouble(t1.getText())*Double.parseDouble(t2.getText());
					temp3*=10000;
					int trans3=(int)temp3;
					temp3=trans3/10000;
					t3.setText(String.valueOf(temp3));
					break;
				case 4:
					double temp4=Double.parseDouble(t1.getText())/Double.parseDouble(t2.getText());
					temp4*=10000;
					int trans4=(int)temp4;
					temp4=trans4/10000;
					t3.setText(String.valueOf(temp4));
					break;
				}*/
			}
		});
		JButton clear=new JButton("C");
		clear.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				method=0;
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				t6.setText(null);
			}
		});
		JPanel panButton=new JPanel();
		panButton.setLayout(new FlowLayout());
		panButton.add(add);
		panButton.add(minus);
		panButton.add(multiply);
		panButton.add(divide);
		panButton.add(equal);
		panButton.add(clear);
		
		JButton help=new JButton("help");
		help.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(over==0){
					over=1;
					JFrame h=new JFrame("help");
					h.setLocation(500, 200);
					h.setSize(250,150);
					JTextArea ta=new JTextArea();
					ta.setText("Hello,you should remember that \n I am the second cutest \n and the second most lovely.\n And enjoy this Fraction Calculator!");
					h.add(ta);
					h.setVisible(true);
					h.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							over=0;
							h.dispose();
						}
					});
				}
			}
		});
		
		f.add(pan1);
		f.add(pan3);
		f.add(pan2);
		f.add(panButton);
		f.add(help);
		f.setVisible(true);
	
		
	
	
	
	
	
	
	
	
	
	
	}
}

