package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
   JButton login,signup,clear;  
   JTextField a;
   JPasswordField p;
 Login(){
	setLayout(null);
	setTitle("ATM");
	setSize(800,480);
	setVisible(true);
	setLocation(350,200);
	getContentPane().setBackground(Color.WHITE);
	JLabel text=new JLabel("Welcome to ATM");
	text.setBounds(200,40,400,40);
	text.setFont(new Font("Osward",Font.BOLD,38));
	add(text);

	JLabel cardno=new JLabel("Card Number:");
	cardno.setBounds(120,150,150,30);
	cardno.setFont(new Font("Raleway",Font.BOLD,20));
	add(cardno);
	JLabel pin=new JLabel("Enter Pin:");
	pin.setBounds(120,220,250,30);
	pin.setFont(new Font("Raleway",Font.BOLD,20));
	add(pin);
	 a=new JTextField();
	a.setBounds(300,150,230,30);
	a.setFont(new Font("Arial",Font.BOLD,14));
	add(a);
         p=new JPasswordField();
	p.setBounds(300,220,230,30);
	p.setFont(new Font("Arial",Font.BOLD,14));
	add(p);
	login=new JButton("SIGN IN");
	login.setBounds(300,300,100,30);
	login.setBackground(Color.BLACK);
	login.setForeground(Color.WHITE);
	login.addActionListener(this);
	add(login);
 	 clear=new JButton("CLEAR");
	clear.setBounds(430,300,100,30);
	clear.setBackground(Color.BLACK);
	clear.setForeground(Color.WHITE);
	clear.addActionListener(this);
	add(clear);
	signup=new JButton("SIGN UP");
	signup.setBounds(300,350,230,30);
	signup.setBackground(Color.BLACK);
	signup.setForeground(Color.WHITE);
	signup.addActionListener(this);
	add(signup);


}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==clear){
			a.setText("");
			p.setText("");
}
	else if(ae.getSource()==login){
		Conn conn=new Conn();
                String cardno=a.getText();
                String pinno=p.getText();
                String query="select * from login where cardno='"+cardno+"' and pin='"+pinno+"'";
                try{
                    ResultSet rs=conn.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pinno).setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
}
	else if(ae.getSource()==signup){
            setVisible(false);
             new SignupOne().setVisible(true);
		
}


}
  public static void main(String[] args){
	new Login();
}
}
