import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JTextField;



/*
Author @ptam1
Project Summary: A mock bank account program where a user can check, deposit, and withdraw from 
                 a checking's and saving's accounts. The checking's account has an intial balance of $123.00, 
                and saving's account has an intial balance of $50.00. 
*/



public class BankAccount extends JFrame 
{
    
    JRadioButton depositCBtn, depositSBtn, withdrawCBtn, withdrawSBtn;
    JTextField input;
    JLabel text;
    JButton enterBtn, checkingBtn, savingBtn;
    JPanel panel;
    String storeInput;
    double userInput;
    private static double checkingAmount = 123;
    private static double savingAmount = 50;
    private static JLabel amountLabel;
    
    
    public  BankAccount()
            {
                prepareGUI();
            }
   
    
    // prepareGUI() method intializes the textfield, radio buttons with their action listeners, labels, and sets up the GUI layout. 
    private void prepareGUI()
    {
        input = new JTextField();
         

        depositCBtn = new JRadioButton("Deposit into Checking");
        depositSBtn = new JRadioButton("Deposit into Saving");
        withdrawCBtn = new JRadioButton("Withdraw from Checking");
        withdrawSBtn = new JRadioButton("Withdraw from Saving");
    
        ButtonGroup group = new ButtonGroup();
        group.add(depositCBtn);
        group.add(depositSBtn);
        group.add(withdrawCBtn);
        group.add(withdrawSBtn);
        
        
       text = new JLabel("Enter your amount:");
       text.setFont(new Font("Courier New", Font.BOLD, 12));
       amountLabel = new JLabel("Total Amount = ");
       amountLabel.setFont(new Font("Courier New", Font.BOLD, 12));
       
       
       enterBtn = new JButton("Enter");
       enterBtn.addActionListener(new ActionListener()
      {
      @Override 
      public void actionPerformed(ActionEvent e)
      {
         try{
             if(input.getText().isEmpty())
             {
	 int space=Integer.parseInt ("");
         int usrInput=Integer.parseInt(input.getText());
             }
          }catch(NumberFormatException n){
	 String error = "Enter A Valid Amount!";  
         JOptionPane.showMessageDialog(new JFrame(), error, "Error!",
         JOptionPane.ERROR_MESSAGE);
       }
         checkSelection();
      }
      });
 
      checkingBtn = new JButton("Check Checking's Account");
      checkingBtn.addActionListener(new ActionListener()
      {
      @Override 
      public void actionPerformed(ActionEvent e)
      {
           String s = Double.toString(checkingAmount);
           amountLabel.setText("Total Amount =" +  " " + "$" +   new BigDecimal(s).setScale(2, 2)); 
      }
      });
       
        
      savingBtn = new JButton("Check Saving's Account");
      savingBtn.addActionListener(new ActionListener()
      {
      @Override 
      public void actionPerformed(ActionEvent e)
      {
     
                 String s = Double.toString(savingAmount);
                 amountLabel.setText("Total Amount =" +  " " + "$" +   new BigDecimal(s).setScale(2, 2)); 
      }
      });

       createGroupLayout(checkingBtn,savingBtn, depositCBtn, depositSBtn, withdrawCBtn,withdrawSBtn);
    }
      
    //checkSelection() method determines which radio button has been selected, and displays the current checking's or saving's amount. 
    public void checkSelection()
    {
         userInput = Double.parseDouble(input.getText()); 
 
    if(depositCBtn.isSelected())
        {
          checkingAmount +=userInput;
          String s = Double.toString(checkingAmount);
          amountLabel.setText("Total Amount =" +  " " + "$" +   new BigDecimal(s).setScale(2, 2));   
        } 
   else if (withdrawCBtn.isSelected())
        {
            checkingAmount -= userInput;
             String s = Double.toString(checkingAmount);
             amountLabel.setText("Total Amount =" +  " " + "$" +   new BigDecimal(s).setScale(2, 2)); 
          
        }
   else if (depositSBtn.isSelected())    
        {
            savingAmount +=userInput;
             String s = Double.toString(savingAmount);
            amountLabel.setText("Total Amount =" +  " " + "$" +   new BigDecimal(s).setScale(2, 2)); 
    
        }
   else 
        {
            savingAmount -= userInput;
            String s = Double.toString(savingAmount);
            amountLabel.setText("Total Amount =" +  " " + "$" +   new BigDecimal(s).setScale(2, 2));
        }
    }
  
 
   
    
    //createGroupLayout() method intializes, and sets up the frame and positions of the labels, textfield, and buttons. 
    public void createGroupLayout(JComponent... arg)
    {
        JFrame frame = new JFrame("Bank Account GUI");
        frame.setPreferredSize(new Dimension(1000, 150));
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
       
        Container contentPanel = frame.getContentPane();
        GroupLayout layout = new GroupLayout(contentPanel);
        contentPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    
layout.setHorizontalGroup(layout.createSequentialGroup()
    .addComponent(amountLabel)
    .addComponent(text)
    .addGroup(layout.createSequentialGroup()
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(input)
    .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(checkingBtn)
                .addComponent(savingBtn))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(depositCBtn)
                .addComponent(depositSBtn))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(withdrawCBtn)
                .addComponent(withdrawSBtn)))))
   .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
       .addComponent(enterBtn))
   
);

layout.setVerticalGroup(layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
      .addComponent(amountLabel))
         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
           .addComponent(text)
           .addComponent(input)
           .addComponent(enterBtn))
       
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(checkingBtn)
                .addComponent(depositCBtn)
                .addComponent(withdrawCBtn))
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(savingBtn)
                .addComponent(depositSBtn)
                .addComponent(withdrawSBtn))))
        
);

      frame.pack();
      frame.setVisible(true);
    }
  
    
    public static void main(String args[])
    {
      
        BankAccount acc = new BankAccount();
        acc.pack();
        acc.setVisible(true);
      
    }
}
