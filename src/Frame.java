import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame {
	public int method=0;
	//to remember what to do,add/minus/multiply/divide
	private int over=0;
	//to prevent more than one opening of help frame at the same time 
	public void initialize(){
		JFrame f=new JFrame("Calculator");//the title of the frame
		f.setLocation(500,200);//the location
		f.setSize(350, 300);//the size
		f.setResizable(false);
		//this frame cannot be change the size
		//to prevent the components escape from their former location
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {//what to do when the "x" is clicked
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		f.setLayout(new FlowLayout());//layout manager
		
		JLabel methodShow=new JLabel("");//to show what method is now
		
		JTextField t1=new JTextField(8);//the first one's numerator
		JTextField t2=new JTextField(8);//the second one's numerator
		JLabel e1=new JLabel("=");
		JTextField t3=new JTextField(8);//the result's numerator
		
		JPanel panNumerator=new JPanel();//the first floor
		panNumerator.setLayout(new FlowLayout());
		panNumerator.add(t1);
		panNumerator.add(t2);
		panNumerator.add(e1);
		panNumerator.add(t3);
		
		JTextField t4=new JTextField(8);//the first one's denominator
		JTextField t5=new JTextField(8);//the second one's denominator
		JLabel e2=new JLabel("=");
		JTextField t6=new JTextField(8);//the result's numerator
		
		JPanel panDenominator=new JPanel();//the third floor
		panDenominator.setLayout(new FlowLayout());
		panDenominator.add(t4);
		panDenominator.add(t5);
		panDenominator.add(e2);
		panDenominator.add(t6);
		
		JLabel l1=new JLabel("——————");//fractional line
		JLabel l2=new JLabel("——————");
		JLabel l3=new JLabel("——————");
		
		JPanel panFractionalLine=new JPanel();//the second floor
		panFractionalLine.setLayout(new FlowLayout());
		panFractionalLine.add(l1);
		panFractionalLine.add(l2);
		panFractionalLine.add(l3);
		
		
		JButton add=new JButton("+");//to add
		add.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				method=1;
				methodShow.setText("+");
			}
		});
		JButton minus=new JButton("-");//to minus
		minus.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				method=2;
				methodShow.setText("-");
			}
		});
		JButton multiply=new JButton("*");//to multiply
		multiply.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				method=3;
				methodShow.setText("*");
			}
		});
		JButton divide=new JButton("/");//to divide
		divide.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				method=4;
				methodShow.setText("/");
			}
		});
		JButton equal=new JButton("=");//print result
		
		equal.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Fraction left=new Fraction();//the first fraction
				Fraction right=new Fraction();//the second fraction
				if(
					//to make sure two fractions are given values to
						!(t1.getText().equals("") &&
								t4.getText().equals("") &&
								t2.getText().equals("") &&
								t5.getText().equals("")
						)
					){
						left.nume=Integer.parseInt(t1.getText());
						left.deno=Integer.parseInt(t4.getText());
						left.simplify();
						right.nume=Integer.parseInt(t2.getText());
						right.deno=Integer.parseInt(t5.getText());
						right.simplify();
						
						//I don't want to use the original two
						//so here are new two.
						Fraction leftShadow=new Fraction(left);
						Fraction rightShadow=new Fraction(right);

					switch (method) {//judge the method
						case 1:// +
							leftShadow.add(rightShadow);
							t3.setText(String.valueOf(leftShadow.nume));
							t6.setText(String.valueOf(leftShadow.deno));
							break;
						case 2:// -
							leftShadow.minus(rightShadow);
							t3.setText(String.valueOf(leftShadow.nume));
							t6.setText(String.valueOf(leftShadow.deno));
							break;
						case 3:// *
							leftShadow.multiply(rightShadow);
							t3.setText(String.valueOf(leftShadow.nume));
							t6.setText(String.valueOf(leftShadow.deno));
							break;
						case 4:// /
							leftShadow.divide(rightShadow);
							t3.setText(String.valueOf(leftShadow.nume));
							t6.setText(String.valueOf(leftShadow.deno));
							break;
					}
				}else{//when there's at least one blanket is null
					methodShow.setText("Error");
				}
			}
		});
		
		JButton clear=new JButton("C");//clear all
		clear.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				method=0;
				methodShow.setText("");
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
				t5.setText(null);
				t6.setText(null);
			}
		});
		JButton help=new JButton("help");//not a help,but a self-introduce
		help.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(over==0){
					over=1;
					JFrame h=new JFrame("help");
					h.setLocation(500, 200);
					h.setSize(250,150);
					JTextArea tA=new JTextArea();
					tA.setText("Hello,you should remember that \n I am the second cutest \n and the second most lovely.\n And enjoy this Fraction Calculator!");
					h.add(tA);
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
		JPanel panButton=new JPanel();//the fourth floor
		panButton.setLayout(new FlowLayout());
		panButton.add(add);
		panButton.add(minus);
		panButton.add(multiply);
		panButton.add(divide);
		panButton.add(equal);
		panButton.add(clear);
		panButton.add(help);

		f.add(panNumerator);
		f.add(panFractionalLine);
		f.add(panDenominator);
		f.add(panButton);
		f.add(methodShow);
		f.setVisible(true);
	}
}

