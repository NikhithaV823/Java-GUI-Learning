import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Calcigui extends JFrame implements ActionListener
{
    private String current="";
    private String op;
    private double first=0,second=0;
    private JTextField display;
     public Calcigui()
     {
        setTitle("Simple Calculator");
        setLayout(new BorderLayout(10,10));
        setBounds(550,300,300,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        display=new JTextField(30);
        display.setEditable(false);
        display.setFont(new Font("SansSerif",Font.ITALIC,24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        add(display,BorderLayout.NORTH);
        JPanel jp=new JPanel();
        jp.setLayout(new  GridLayout(5,4,4,4));
        String[] buts={"7","8","9","+","4","5","6","-","3","2","1","*","%","0","/","C",".","="};
        for(String but:buts)
        {
            JButton jb=new JButton(but);
            jb.setFont(new Font("Courier New",Font.BOLD,20));
            jb.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            jb.addActionListener(this);
            jp.add(jb);
        }
        add(jp,BorderLayout.CENTER);
        setVisible(true);
     }
     public void actionPerformed(ActionEvent ae)
     {
        String com=ae.getActionCommand();
        System.out.println("pressed "+com);
        if(com.matches("[0-9,.]"))
        {
            current+=com;
            display.setText(current);
        }
        
        else if(com.matches("[+\\-\\*%/]"))
        {
            if(!current.isEmpty())
            {
                try
                {
                first=Double.parseDouble(current);
                op=com;
                display.setText(display.getText()+op);
                current="";
                }
                catch(NumberFormatException e)
                {
                    display.setText("Error");
                }
            }
            else
               display.setText("Error");
        }
        else if(com.equals("="))
        {
            if(!current.isEmpty()&&!op.isEmpty())
            {
                try{
                second=Double.parseDouble(current);
                double res=0;
                switch(op)
                {
                    case "+":res=first+second;   break; 
                    case "-":res=first-second;   break; 
                    case "*":res=first*second;   break; 
                    case "/":
                        if(second==0)
                        {
                            display.setText("Can't divide by Zero");
                            return;
                        }
                        res=first/second;   break; 
                    case "%":res=first%second;   break;
                    default:display.setText("Invalid button");return; 
                }
                display.setText(String.valueOf(res));
                current=String.valueOf(res);
                op="";
                }
                catch(NumberFormatException e)
                {
                    display.setText("Error");
                }
            }
            else
               display.setText("Error");
        }
        else if(com.equals("C"))
        {
            current="";
            op="";
            first=0;
            display.setText("");
        }
        
    }
}
public class Mycalcigui
{ 
    public static void main(String[] args)
    {
       new Calcigui();
    }
}