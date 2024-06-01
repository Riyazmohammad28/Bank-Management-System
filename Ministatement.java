
package bankmanagementsystem;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Ministatement extends JFrame{
   
    String pinno;
    Ministatement(String pinno){
        this.pinno=pinno;
        setTitle("MINI STATEMENT");
         setLayout(null);
        
        
        JLabel text=new JLabel();
        text.setBounds(20,140,400,200);
        add(text);
        
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        
         JLabel mini=new JLabel();
        mini.setBounds(20,80,300,20);
        add(mini);
        
        JLabel bal=new JLabel();
        bal.setBounds(20,400,300,20);
        add(bal);
         
        
        try{
            Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from login where pin='"+pinno+"'");
           while(rs.next()){
               mini.setText("Card Number: "+rs.getString("cardno").substring(0,4)+"XXXXXXXX"+rs.getString("cardno").substring(12));
               
           }
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn conn=new Conn();
            int bala=0;
             ResultSet rs=conn.s.executeQuery("select * from bank where pin = '"+pinno+"'");
             while(rs.next()){
                 text.setText(text.getText()+ "<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
             if (rs.getString("type").equals("Deposite")){
                        bala+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        bala-=Integer.parseInt(rs.getString("amount"));
                    }
             }
             bal.setText("Your current account balance is Rs"+bala);
        }catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
       
        setVisible(true);
        
    }
    
    
    public static void main(String[] args){
        new Ministatement("");
    }
}
