
package employee.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
   
    
    JTextField tfeducation,tffname,tfsalary,tfaddress,tfphone,tfemail,tfdesig,tfadhaar;
    JLabel lblempid;
     JButton add,back;  
     String empId;
     
    UpdateEmployee(String empId){
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD,25)); 
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelname);
        
       JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelfname);
        
       tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN, 20));
        add(labeldob);
        
           JLabel lbldob = new JLabel();
          lbldob.setBounds(200,200,150,30);
          add(lbldob);
          
          JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelsalary);
        
          tfsalary=new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN, 20));
        add(labeladdress);
        
         tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
         JLabel phone = new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("serif",Font.PLAIN, 20));
        add(phone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
         JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelemail);
        
          tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel edu = new JLabel("Email");
        edu.setBounds(400,300,150,30);
        edu.setFont(new Font("serif",Font.PLAIN, 20));
        add(edu);
        
         tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel desig = new JLabel("Designation");
        desig.setBounds(50,350,150,30);
        desig.setFont(new Font("serif",Font.PLAIN, 20));
        add(desig);
        
         tfdesig=new JTextField();
        tfdesig.setBounds(200,350,150,30);
        add(tfdesig);
        
        JLabel adhaar = new JLabel("Aadhar Number");
        adhaar.setBounds(400,350,150,30);
        adhaar.setFont(new Font("serif",Font.PLAIN, 20));
        add(adhaar);
        
         JLabel lbladhaar = new JLabel();
        lbladhaar.setBounds(600,350,150,30);
        add(lbladhaar);
        
        JLabel empid = new JLabel("Employee id");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("serif",Font.PLAIN, 20));
        add(empid);
        
         lblempid = new JLabel();
        lblempid.setBounds(200,400,150,30);
        lblempid.setFont(new Font("serif",Font.PLAIN, 20));
        add(lblempid);
        
        try{
            
            Conn c = new Conn();
            String query = "select * from employe where empid = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("edu"));
                lbladhaar.setText(rs.getString("adhaar"));
                lblempid.setText(rs.getString("empId"));
                tfdesig.setText(rs.getString("designation"));
                
                
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
          add = new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
         back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == add) {
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String edu = tfeducation.getText();
            String designation = tfdesig.getText();
            
            
            try {
                Conn conn = new Conn();
                String query = "update  employe set fname= '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone =  '"+phone+"', email = '"+email+"',edu =  '"+edu+"', designation = '"+designation+"' where empid = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated successfully");
                setVisible(false);
                new ViewEployee();
            }   catch(Exception e) {
                e.printStackTrace();
            }
        }
         if(ae.getSource()==back)
        {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[])
    {
        new UpdateEmployee("");
    }
}
