
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposite extends JFrame implements ActionListener{
    JTextField a;
    JButton  dep,back;
    String pinno;
        Deposite(String pinno){
           this.pinno=pinno;
            setLayout(null);
            
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);
         
         JLabel text=new JLabel("Enter Amount");
         text.setForeground(Color.WHITE);
         text.setFont(new Font("System",Font.BOLD,16));
         text.setBounds(170,300,400,20);
         image.add(text);
         
         a=new JTextField();
         a.setFont(new Font("Raleway",Font.BOLD,22));
         a.setBounds(170,350,320,25);
         image.add(a);
         
          dep=new JButton("Deposite");
         dep.setBounds(355,485,150,30);
         dep.addActionListener(this);
         image.add(dep);
         
         
           
         back=new JButton("Back");
         back.setBounds(355,520,150,30);
         back.addActionListener(this);
         image.add(back);
         
         
         
         
            setSize(900,900);
            setLocation(300,0);
            setVisible(true);
    
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==dep){
                String no=a.getText();
                Date date=new Date();
                if(no.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter the ammount you want to deposite");
                    
                }else {
                   try{
                    Conn c=new Conn();
                    String query="insert into bank values('"+pinno+"','"+date+"','Deposite','"+no+"')";
                    c.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,"Rs"+no+"Deposite Successfully");
                   setVisible(false);
                   new Transactions(pinno).setVisible(true);
                   }catch(Exception e){
                    System.out.println(e);
                }
               }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinno).setVisible(true);
            }
            
        }
    public static void main(String[] args){
        new Deposite("");
    }
}
