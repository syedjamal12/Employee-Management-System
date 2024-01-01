

package employee.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    
    Splash(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // for remove by default layout
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80,30,1200,60); // for making layout
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this); //ActionPerformed method ko call krega
        image.add(clickhere);
        
        setSize(1170, 650);  //making a frame
        setLocation(200,50);
        setVisible(true);
        
        // for dippering
         while(true) {  // loop infinite time
            heading.setVisible(false);
            try {
                Thread.sleep(500); //half second use
            } catch (Exception e){
                
            } 
            
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
        }
    }
    public void actionPerformed(ActionEvent ae){ //abstract h isliye override krna pda
        setVisible(false); //ye page ko hide ker dega
        new login(); //ye login page open karega by constructor call
    }
    public static void main(String args[])
    {
        new Splash();
    }
}
