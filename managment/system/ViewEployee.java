
package employee.managment.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEployee extends JFrame implements ActionListener{
    
    JTable table;
    Choice employeeid;
    JButton search, print, update, back;
    
    ViewEployee() {
        
//      getContentPane().setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel srclbl = new JLabel("Search by Employee Id");
        srclbl.setBounds(20,20,150,20);
        add(srclbl);
        
        employeeid = new Choice();
        employeeid.setBounds(180,20,150,20);
        add(employeeid);
        
        table = new JTable();
        
        // table me employeeid search kerne ke liye
         try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from employe");
            while(rs.next()){
                employeeid.add(rs.getString("empid"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
         // table bna rha h
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from employe");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== search)
        {
          String query = "select * from employe where empId = '"+employeeid.getSelectedItem()+"'";
          try{
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery(query);
              table.setModel(DbUtils.resultSetToTableModel(rs));
          }catch(Exception e){
              e.printStackTrace();
          }
        }
        if(ae.getSource()==print)
        {
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
                     
            }
        }
        if(ae.getSource()==update)
        {
            setVisible(false);
            new UpdateEmployee(employeeid.getSelectedItem());
        }
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Home();
        }
//        }else{
//            setVisible(false);
//            new Home();
//        }
    }
    public static void main(String args[])
    {
        new ViewEployee();
    }
}
