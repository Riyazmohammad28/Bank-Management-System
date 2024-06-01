package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupOne extends JFrame implements ActionListener {
	JTextField nameText,fnameText,enameText,addText,cText,stText,pText,dText;
        long random;
        JButton next;
        JRadioButton male,female,other,maried,unmaried;
	SignupOne(){
	setLayout(null);
	Random ran=new Random();
	 random=Math.abs((ran.nextLong() % 9000L) + 1000L);
	JLabel formno=new JLabel("APPLICATION FORM NUMBER."+random);
	formno.setFont(new Font("Raleway",Font.BOLD,38));
	formno.setBounds(140,20,700,40);
	add(formno);
	getContentPane().setBackground(Color.WHITE);
	setSize(850,800);
	setLocation(350,10);
	setVisible(true);
	JLabel personDetail=new JLabel("Page 1:Personal Details");
	personDetail.setFont(new Font("Raleway",Font.BOLD,22));
	personDetail.setBounds(290,80,400,30);
	add(personDetail);
	JLabel name=new JLabel("Name: ");
	name.setFont(new Font("Raleway",Font.BOLD,20));
	name.setBounds(100,140,100,30);
	add(name);
	nameText =new JTextField();
	nameText.setFont(new Font("Raleway",Font.BOLD,20));
	nameText.setBounds(300,140,400,30);
	add(nameText);


	JLabel fname=new JLabel("Father's Name: ");
	fname.setFont(new Font("Raleway",Font.BOLD,20));
	fname.setBounds(100,190,200,30);
	add(fname);
	fnameText =new JTextField();
	fnameText.setFont(new Font("Raleway",Font.BOLD,20));
	fnameText.setBounds(300,190,400,30);
	add(fnameText);





	JLabel dob=new JLabel("Date of Birth: ");
	dob.setFont(new Font("Raleway",Font.BOLD,20));
	dob.setBounds(100,240,200,30);
	add(dob);
	dText =new JTextField();
	dText.setFont(new Font("Raleway",Font.BOLD,20));
	dText.setBounds(300,240,400,30);
	add(dText);


	JLabel gender=new JLabel("Gender: ");
	gender.setFont(new Font("Raleway",Font.BOLD,20));
	gender.setBounds(100,290,200,30);
	add(gender);
	 male=new JRadioButton("Male");
	male.setBounds(300,290,60,30);
	male.setBackground(Color.WHITE);
	 female=new JRadioButton("Femail");
	female.setBounds(450,290,120,30);
	female.setBackground(Color.WHITE);
	add(male);
	add(female);

	ButtonGroup gendergroup=new ButtonGroup();
	gendergroup.add(male);
	gendergroup.add(female);

	JLabel email=new JLabel("Email address: ");
	email.setFont(new Font("Raleway",Font.BOLD,20));
	email.setBounds(100,340,200,30);
	add(email);
	enameText =new JTextField();
	enameText.setFont(new Font("Raleway",Font.BOLD,20));
	enameText.setBounds(300,340,400,30);
	add(enameText);




	JLabel marital=new JLabel("Marital status: ");
	marital.setFont(new Font("Raleway",Font.BOLD,20));
	marital.setBounds(100,390,200,30);
	add(marital);
	
	 maried=new JRadioButton("Maried");
	maried.setBounds(300,390,100,30);
	maried.setBackground(Color.WHITE);
	 unmaried=new JRadioButton("UnMaried");
	unmaried.setBounds(450,390,100,30);
	unmaried.setBackground(Color.WHITE);
	add(maried);
	add(unmaried);

	 other=new JRadioButton("other");
	other.setBounds(630,390,100,30);
	other.setBackground(Color.WHITE);
	add(other);

	ButtonGroup gendergroup1=new ButtonGroup();
	gendergroup1.add(maried);
	gendergroup1.add(unmaried);
	gendergroup1.add(other);



	JLabel address=new JLabel("Address: ");
	address.setFont(new Font("Raleway",Font.BOLD,20));
	address.setBounds(100,440,200,30);
	add(address);
	addText =new JTextField();
	addText.setFont(new Font("Raleway",Font.BOLD,20));
	addText.setBounds(300,440,400,30);
	add(addText);



	JLabel city=new JLabel("City: ");
	city.setFont(new Font("Raleway",Font.BOLD,20));
	city.setBounds(100,490,200,30);
	add(city);
	cText =new JTextField();
	cText.setFont(new Font("Raleway",Font.BOLD,20));
	cText.setBounds(300,490,400,30);
	add(cText);



	JLabel st=new JLabel("Sate: ");
	st.setFont(new Font("Raleway",Font.BOLD,20));
	st.setBounds(100,540,200,30);
	add(st);
	stText =new JTextField();
	stText.setFont(new Font("Raleway",Font.BOLD,20));
	stText.setBounds(300,540,400,30);
	add(stText);


	JLabel pincode=new JLabel("Pin code: ");
	pincode.setFont(new Font("Raleway",Font.BOLD,20));
	pincode.setBounds(100,590,200,30);
	add(pincode);
	pText =new JTextField();
	pText.setFont(new Font("Raleway",Font.BOLD,20));
	pText.setBounds(300,590,400,30);
	add(pText);
	 
	 next=new JButton("Next");
	next.setBackground(Color.BLACK);
	next.setForeground(Color.WHITE);
	next.setFont(new Font("Raleway",Font.BOLD,14));
	next.setBounds(620,660,80,30);
        next.addActionListener(this);
	add(next);

}
        public void actionPerformed(ActionEvent ae){
           String formno=""+random;
           String name=nameText.getText().trim();
           String fname=fnameText.getText().trim();
           String gender=null;
           if(male.isSelected()){
               gender="Male";
           } else if(female.isSelected()){
               gender="Female";
           }
           String email=enameText.getText();
           String marital=null;
           if(maried.isSelected()){
               marital="Married";
           }else if(unmaried.isSelected()){
               marital="Unmared";
        } else if(other.isSelected()){
            marital="other";
        }
           String address=addText.getText();
           String city=cText.getText();
           String st=stText.getText();
           String pin=pText.getText();
           String dob=dText.getText();
           
           try{
               
               if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name is Required");
}            else{
                   Conn c=new Conn();
                   String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+st+"')";
                   c.s.executeUpdate(query);
                   setVisible(false);
                   new SignupTwo(formno).setVisible(true);
                   
               }
               
           }catch(Exception e){
               System.out.println(e);
           }
          
        }
        
	public static void main(String[] args){
		new SignupOne();

}



}