package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupTwo extends JFrame implements ActionListener {
	JTextField nameText,fnameText,enameText,addText,cText,stText,pText,pan;
 
        JButton next;
        JRadioButton yes,no,eyes,eno;
        JComboBox religion,occ,education,income,category;
        String formno;
	SignupTwo(String formno){
           this.formno=formno;
	setLayout(null);
	setTitle("NEW APPLICATON FORM -PAGE 2");
	
	getContentPane().setBackground(Color.WHITE);
	setSize(850,800);
	setLocation(350,10);
	setVisible(true);
	JLabel personDetail=new JLabel("Page 2:Additional Details");
	personDetail.setFont(new Font("Raleway",Font.BOLD,22));
	personDetail.setBounds(290,80,400,30);
	add(personDetail);
        
	JLabel name=new JLabel("Religion: ");
	name.setFont(new Font("Raleway",Font.BOLD,20));
	name.setBounds(100,140,100,30);
	add(name);
            String valreligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
           religion=new JComboBox(valreligion);
           religion.setBounds(300,140,400,30);
           religion.setBackground(Color.WHITE);
	add(religion);
	

         
	JLabel fname=new JLabel("Category: ");
	fname.setFont(new Font("Raleway",Font.BOLD,20));
	fname.setBounds(100,190,200,30);
	add(fname);
        String valcategory[]={"General","OBC","SC","ST","Other"};
         category=new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
	category.setBackground(Color.WHITE);
	add(category);





	JLabel dob=new JLabel("Income: ");
	dob.setFont(new Font("Raleway",Font.BOLD,20));
	dob.setBounds(100,240,200,30);
	add(dob);
        String valincome[]={"Null","<1,50,000","<2,50,000","< 5,00,000","Upto 10,00,000"};
         income=new JComboBox(valincome);
        income.setBounds(300,240,400,30);
	income.setBackground(Color.WHITE);
	add(income);
	


	JLabel gender=new JLabel("Education: ");
	gender.setFont(new Font("Raleway",Font.BOLD,20));
	gender.setBounds(100,290,200,30);
	add(gender);
	
	

	JLabel email=new JLabel("Qualificcation: ");
	email.setFont(new Font("Raleway",Font.BOLD,20));
	email.setBounds(100,315,200,30);
	add(email);
        String val[]={"Non-Graduate","Graduation","Post Graduation","Doctarate","Other"};
        education=new JComboBox(val);
        education.setBounds(300,315,400,30);
	education.setBackground(Color.WHITE);
	add(education);
	
	JLabel marital=new JLabel("Occupation: ");
	marital.setFont(new Font("Raleway",Font.BOLD,20));
	marital.setBounds(100,390,200,30);
	add(marital);
         String valoc[]={"Salaried","Self-Employed","Businessman","Student","Other"};
         occ=new JComboBox(valoc);
        occ.setBounds(300,390,400,30);
	occ.setBackground(Color.WHITE);
	add(occ);
	
	
	JLabel address=new JLabel("Pan number: ");
	address.setFont(new Font("Raleway",Font.BOLD,20));
	address.setBounds(100,440,200,30);
	add(address);
	pan =new JTextField();
	pan.setFont(new Font("Raleway",Font.BOLD,20));
	pan.setBounds(300,440,400,30);
	add(pan);



	JLabel city=new JLabel("Aadhar number: ");
	city.setFont(new Font("Raleway",Font.BOLD,20));
	city.setBounds(100,490,200,30);
	add(city);
	cText =new JTextField();
	cText.setFont(new Font("Raleway",Font.BOLD,20));
	cText.setBounds(300,490,400,30);
	add(cText);



	JLabel st=new JLabel("Senior citizen: ");
	st.setFont(new Font("Raleway",Font.BOLD,20));
	st.setBounds(100,540,200,30);
	add(st);
	 yes=new JRadioButton("Yes");
         yes.setBounds(300,540,100,30);
         yes.setBackground(Color.WHITE);
         add(yes);

         no=new JRadioButton("No");
         no.setBounds(450,540,100,30);
         no.setBackground(Color.WHITE);
         add(no);
         ButtonGroup senior=new ButtonGroup();
         senior.add(yes);
         senior.add(no);
         
	JLabel pincode=new JLabel("Existing Account: ");
	pincode.setFont(new Font("Raleway",Font.BOLD,20));
	pincode.setBounds(100,590,200,30);
	add(pincode);
	eyes=new JRadioButton("Yes");
         eyes.setBounds(300,590,100,30);
         eyes.setBackground(Color.WHITE);
         add(eyes);

         eno=new JRadioButton("No");
         eno.setBounds(450,590,100,30);
         eno.setBackground(Color.WHITE);
         add(eno);
         ButtonGroup se=new ButtonGroup();
         se.add(eyes);
         se.add(eno);
	 
	 next=new JButton("Next");
	next.setBackground(Color.BLACK);
	next.setForeground(Color.WHITE);
	next.setFont(new Font("Raleway",Font.BOLD,14));
	next.setBounds(620,660,80,30);
        next.addActionListener(this);
	add(next);

}
        public void actionPerformed(ActionEvent ae){
           
           String sreligion=(String)religion.getSelectedItem();
           String scategory=(String)category.getSelectedItem();
           String sincome=(String)income.getSelectedItem();
           String seducation=(String)education.getSelectedItem();
           String socc=(String)occ.getSelectedItem();
           String seniorcitizen=null;
           if(yes.isSelected()){
               seniorcitizen="Yes";
           } else if(no.isSelected()){
               seniorcitizen="No";
           }
           
           String existingaccount=null;
           if(eyes.isSelected()){
               existingaccount="Yes";
           }else if(eno.isSelected()){
               existingaccount="No";
        }  
           String span=pan.getText();
           String saadhar=cText.getText();
           
           
           try{
                Conn c=new Conn();
                   String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+socc+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                   c.s.executeUpdate(query);
                   setVisible(false);
                   new Signupthree(formno).setVisible(true);
              
           }catch(Exception e){
               System.out.println(e);
           }
          
        }
        
	public static void main(String[] args){
		new SignupTwo("");

}



}