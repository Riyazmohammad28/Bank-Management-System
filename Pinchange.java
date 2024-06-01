
package bankmanagementsystem;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Pinchange extends JFrame implements ActionListener{
    JPasswordField  pin,rpin;
    JButton change,tchange;
    String pinno;
    Pinchange(String pinno){
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text=new JLabel("Change PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,200,500,35);
        image.add(text);
        JLabel ptext=new JLabel("New PIN:");
        ptext.setForeground(Color.WHITE);
        ptext.setFont(new Font("System",Font.BOLD,16));
        ptext.setBounds(165,320,180,25);
        image.add(ptext);
        
         pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        
        JLabel rtext=new JLabel("Re-Enter New PIN");
        rtext.setForeground(Color.WHITE);
        rtext.setFont(new Font("System",Font.BOLD,16));
        rtext.setBounds(165,360,180,25);
        image.add(rtext);
          
         rpin=new JPasswordField();
        rpin.setFont(new Font("Raleway",Font.BOLD,25));
        rpin.setBounds(330,360,180,25);
        image.add(rpin);
        
         change=new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        tchange=new JButton("BACK");
        tchange.setBounds(355,520,150,30);
        tchange.addActionListener(this);
        image.add(tchange);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==change){
        try{
           String npin=pin.getText();
           String repin=rpin.getText();
           
           if(!npin.equals(repin)){
               JOptionPane.showMessageDialog(null,"Entered PIN does not match");
               return;
           }
           if(npin.equals("")){
               JOptionPane.showMessageDialog(null,"Please enter  PIN  ");
               return;
           }
           if(repin.equals("")){
               JOptionPane.showMessageDialog(null,"Please Re-enter  PIN");
               return;
               
        }
           Conn conn=new Conn();
           String query1="update bank set pin ='"+repin+"'where pin='"+pinno+"'";
           String query2="update login set pin ='"+repin+"'where pin='"+pinno+"'";
           String query3="update signupthree set pin ='"+repin+"'where pin='"+pinno+"'";
           conn.s.executeUpdate(query1);
           conn.s.executeUpdate(query2);
           conn.s.executeUpdate(query3);

          JOptionPane.showMessageDialog(null,"PIN Changed successfully");

           setVisible(false);
           new Transactions(npin).setVisible(true);
           
        }catch(Exception e){
            System.out.println(e);
    }
       }else {
          setVisible(false);
          new Transactions(pinno).setVisible(true);
      } 
    }
    
    
    
    public static void main(String args[]){
        new Pinchange("").setVisible(true);
}
}
