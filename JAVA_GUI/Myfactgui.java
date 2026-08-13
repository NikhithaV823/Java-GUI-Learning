import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Myfactgui extends JFrame
{
    private static final int WIDTH=400;
    private static final int HEIGHT=200;
    JTextField jt1;
    JTextField jt2;
    public Myfactgui()
    {
        setTitle("Compute Factorial");
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel jl1=new JLabel("Enter the value");
        JLabel jl2=new JLabel("Factorial value");
        jt1=new JTextField(20);
        jt2=new JTextField(20);
        JButton jb1=new JButton("COMPUTE FACT");
        JButton jb2=new JButton("EXIT");
        getContentPane().setBackground(new Color(230,240,255)); //setBackground.Color.RED/GREEN/BLUE
        Font fl=new Font("Arial",Font.BOLD,14);
        Font ft=new Font("Consolas",Font.PLAIN,14);
        Font fb=new Font("Arial",Font.BOLD,15);
        jl1.setFont(fl);
        jl2.setFont(fl);
        jb1.setFont(fb);
        jb2.setFont(fb);   
        jt1.setFont(ft);
        jt2.setFont(fb);
        jt1.setEditable(true);
        jt2.setEditable(false);
        add(jl1);
        add(jt1);
        add(jl2);
        add(jt2);
        add(jb1);
        add(jb2);
        jt1.addActionListener(new MyListener1());
        jb1.addActionListener(new MyListener1());
        jb2.addActionListener(new MyListener2());
        setVisible(true);
    }
    private class MyListener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            try{
            int k=Integer.parseInt(jt1.getText());
            if(k<0)
            {
                jt2.setText("Factorial is not calculated");
            }
            else{
                int f=1;
                for(int i=1;i<=k;i++)
                {
                    f*=i;
                }
                jt2.setText(" "+f);
            }
           }
           catch(NumberFormatException e)
           {
               jt2.setText("Please enter a valid integer");
           }

        }
    }
    private class MyListener2 implements ActionListener{
        public void actionPerformed(ActionEvent ae)
        {
            System.exit(0);
        }
    }
    public static void main(String[] args)
    {
        new Myfactgui();
    }
    
}