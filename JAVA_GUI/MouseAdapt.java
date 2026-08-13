import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseAdapt extends JFrame
{
    private JLabel statuslab;
    public MouseAdapt()
    {
        setTitle("Mouse Event Adaptor Demo");  
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        statuslab=new JLabel("Move the mouse or click!",JLabel.CENTER);
        statuslab.setFont(new Font("Arial",Font.BOLD,15));
        add(statuslab,BorderLayout.SOUTH);
        JPanel MousePanel=new JPanel();
        MousePanel.setBackground(Color.CYAN);
        MousePanel.addMouseListener(new MouseAdapter()
        {
             public void mouseClicked(MouseEvent e)
            {
                statuslab.setText("Mouse Clicked at ("+e.getX()+","+e.getY()+")");
            }
              public void mouseEntered(MouseEvent e)
            {
                statuslab.setText("Mouse Entere the paneld");
            }
            public void mouseExited(MouseEvent e)
            {
                statuslab.setText("Mouse Exited the panel");
            }
        });
        MousePanel.addMouseMotionListener(new MouseMotionAdapter()
        {
         public void mouseDragged(MouseEvent e)
            {
            statuslab.setText("Mouse Dragged at ("+e.getX()+","+e.getY()+")");
            }
            public void mouseMoved(MouseEvent e)
            {
                statuslab.setText("Mouse Moved at ("+e.getX()+","+e.getY()+")");
            }
        });
        add(MousePanel,BorderLayout.CENTER);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new MouseAdapt();
    }
}

