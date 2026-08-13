import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Trafficgui extends JFrame implements ActionListener
{
    private JRadioButton redbtn,yellowbtn,greenbtn;
    private JPanel lightpanel;
    public Trafficgui()
    {
        setTitle("Traffic Light");
        setSize(300,450);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        redbtn=new JRadioButton("RED");
        yellowbtn=new JRadioButton("YELLOW");
        greenbtn=new JRadioButton("GREEN");
        ButtonGroup group=new ButtonGroup();
        group.add(redbtn);
        group.add(yellowbtn);
        group.add(greenbtn);
        add(redbtn);
        add(yellowbtn);
        add(greenbtn);
        lightpanel=new JPanel()
        {protected void paintComponent(Graphics g)   //Anonymous class(without instance)
        {
            super.paintComponent(g);
            g.setColor(Color.GRAY);
            g.fillOval(90,20,100,100);
            g.fillOval(90,130,100,100);
            g.fillOval(90,240,100, 100);
            if(redbtn.isSelected())
            {
                g.setColor(Color.RED);
                g.fillOval(90,20,100,100);
            }
             if(yellowbtn.isSelected())
            {
                g.setColor(Color.YELLOW);
                g.fillOval(90,130,100,100);
            }
             if(greenbtn.isSelected())
            {
                g.setColor(Color.GREEN);
                g.fillOval(90,240,100,100);
            }
        }};
        lightpanel.setPreferredSize(new Dimension(280,380));
        add(lightpanel);
        redbtn.addActionListener(this);
        yellowbtn.addActionListener(this);
        greenbtn.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        lightpanel.repaint();
    }
    public static void main(String[] args)
    {
        new Trafficgui();
    }
    
}
