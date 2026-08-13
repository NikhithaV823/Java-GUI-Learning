import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gcdcal extends JFrame implements ActionListener
{
    private JTextField n1,n2,res;
    private JButton gcdbtn,clear,exit;
    public Gcdcal()
    {
        setTitle("GDC Calculator");
        setSize(300,300);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel nl1=new JLabel("   Enter First Number:");
        JLabel nl2=new JLabel("      Enter Second Number:");
        JLabel rl=new JLabel("           GCD of two Numbers:");
        n1=new JTextField(5);
        n2=new JTextField(5);
        res=new JTextField(5);
        res.setEditable(false);
        gcdbtn=new JButton("GCD");
        clear=new JButton("CLEAR");
        exit=new JButton("EXIT");
        add(nl1); add(n1);
        add(nl2); add(n2);
        add(rl); add(res);
        add(gcdbtn);add(clear); add(exit);
        gcdbtn.addActionListener(this);
        gcdbtn.setBackground(Color.GREEN);
        clear.addActionListener(this);
        clear.setBackground(Color.BLUE);
        clear.setForeground(Color.WHITE);
        exit.addActionListener(this);
        exit.setBackground(Color.RED);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==gcdbtn)
        {
            try{
                int num1=Integer.parseInt(n1.getText());
                int num2=Integer.parseInt(n2.getText());
                while(num2!=0)
                {
                    int t=num2;
                    num2=num1%num2;
                    num1=t;
                }
                int result=Math.abs(num1);
                res.setText(String.valueOf(result));
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(new Gcdcal(),"Please enter valid Integers!",
                "Input Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()==clear)
        {
            n1.setText("");
            n2.setText("");
            res.setText("");
        }
        else if(e.getSource()==exit)
        {
            dispose();
            System.exit(0);
       }
    }
    public static void main(String[] args)
    {
        new Gcdcal();
    }
}

