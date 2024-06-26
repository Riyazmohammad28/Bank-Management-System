
package bankmanagementsystem;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
           JButton deposite,withdraw,fastcash,mini,pinchange,bal,exit;
           String pinno;
    Transactions(String pinno){
         this.pinno=pinno;
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
         
         JLabel text=new JLabel("Please select your transaction");
         text.setBounds(210,300,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text);
         
         deposite=new JButton("Deposite");
         deposite.setBounds(170,415,150,30);
         deposite.addActionListener(this);
         image.add(deposite);
         
         withdraw=new JButton("Cash Withdrawl");
         withdraw.setBounds(355,415,150,30);
         withdraw.addActionListener(this);
         image.add(withdraw);
         
         fastcash=new JButton("Fast Cash");
         fastcash.setBounds(170,450,150,30);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         mini=new JButton("Mini Statement");
         mini.setBounds(355,450,150,30);
         mini.addActionListener(this);
         image.add(mini);
         
         pinchange=new JButton("Pin Change");
         pinchange.setBounds(170,485,150,30);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
           bal=new JButton("Balance Enquiry");
         bal.setBounds(355,485,150,30);
         bal.addActionListener(this);
         image.add(bal);
         
         exit=new JButton("Exit");
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
            System.exit(0);
            
        }else if(ae.getSource()==deposite){
           setVisible(false);
           new Deposite(pinno).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinno).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pinno).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new Pinchange(pinno).setVisible(true);
        }else if(ae.getSource()==bal){
            setVisible(false);
            new Balanceenquiry(pinno).setVisible(true);
        }else if(ae.getSource()==mini){
            new Ministatement(pinno).setVisible(true);
        }
    }
    public static void main(String[] args){
        new Transactions("");
    }
}
