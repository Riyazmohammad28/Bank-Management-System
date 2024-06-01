
package bankmanagementsystem;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener{
           JButton deposite,withdraw,fastcash,mini,pinchange,bal,exit;
           String pinno;
    Fastcash(String pinno){
         this.pinno=pinno;
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
         
         JLabel text=new JLabel("Select withdrawl amount");
         text.setBounds(210,300,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text);
         
         deposite=new JButton("Rs.100");
         deposite.setBounds(170,415,150,30);
         deposite.addActionListener(this);
         image.add(deposite);
         
         withdraw=new JButton("RS.500");
         withdraw.setBounds(355,415,150,30);
         withdraw.addActionListener(this);
         image.add(withdraw);
         
         fastcash=new JButton("Rs.1000");
         fastcash.setBounds(170,450,150,30);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         mini=new JButton("RS.2000");
         mini.setBounds(355,450,150,30);
         mini.addActionListener(this);
         image.add(mini);
         
         pinchange=new JButton("Rs.5000");
         pinchange.setBounds(170,485,150,30);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
           bal=new JButton("Rs.10000");
         bal.setBounds(355,485,150,30);
         bal.addActionListener(this);
         image.add(bal);
         
         exit=new JButton("Back");
         exit.setBounds(355,520,150,30);
         exit.addActionListener(this);
         image.add(exit);
         
         
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
     
       
    
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinno).setVisible(true);
            
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
                int bal=0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposite")){
                        bal+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource()!=exit && bal<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance" );
                    return;
                }
                Date date =new Date();
                String query="insert into bank values('"+pinno+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited Successfully");
                
                setVisible(false);
                new Transactions(pinno).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args){
        new Fastcash("");
    }
}
