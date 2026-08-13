import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Divgui  extends JFrame
{
    private JTextField n1field,n2field,resfield;
    private JButton divbtn;
    public Divgui()
    {
        setTitle("Integer Division ");
        setLayout(new FlowLayout());
        setBounds(550,350,300,200);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         JLabel jl1=new JLabel("   Enter the first Number:");
         JLabel jl2=new JLabel("       Enter the second Number:");
         JLabel jl3=new JLabel("          Result:");
         n1field=new JTextField(5);
         n2field=new JTextField(5);
         resfield=new JTextField(12);
         resfield.setFont(new Font("Arial",Font.ITALIC,20));
         resfield.setEditable(false);
         divbtn=new JButton("DIVIDE");
         add(jl1);
         add(n1field);
         add(jl2);
         add(n2field);
         add(jl3);
         add(resfield);
         add(new JLabel());
         add(divbtn);
         divbtn.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int n1=Integer.parseInt(n1field.getText().trim());
                    int n2=Integer.parseInt(n2field.getText().trim());
                    if(n2==0)
                    {
                        throw new ArithmeticException("Cannot Divide by Zero");
                    }
                    double res=(double)n1/n2;
                    resfield.setText(String.valueOf(res));
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null,"Please enter the valid integers in both fields!"
                    ,"Number Format Error", JOptionPane.ERROR_MESSAGE);
                   
                }
                catch(ArithmeticException ex)
                {
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Arithemetic Error",JOptionPane.ERROR_MESSAGE);
                }
            }
         });
         setVisible(true);
    }
    public static void main(String[] args)
    {
        new Divgui();
    }
}
