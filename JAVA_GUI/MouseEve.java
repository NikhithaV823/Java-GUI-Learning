import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseEve extends JFrame
{
    private JLabel statuslab;
    public MouseEve()
    {
        super("Mouse Event Demo");  //setTitle
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        statuslab=new JLabel("Move the mouse or click!",JLabel.CENTER);
        statuslab.setFont(new Font("Arial",Font.BOLD,15));
        add(statuslab,BorderLayout.SOUTH);
        MousePanel mp=new MousePanel();
        add(mp,BorderLayout.CENTER);
        setVisible(true);
    }
    private class MousePanel extends JPanel
    {
        public MousePanel()
        {
            setBackground(Color.CYAN);
            addMouseListener(new MouseHandler());
            addMouseMotionListener(new MouseMotionHandler());
        }
    }
    private class MouseHandler implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            statuslab.setText("Mouse Clicked at ("+e.getX()+","+e.getY()+")");
        }
        public void mousePressed(MouseEvent e)
        {
            statuslab.setText("Mouse Pressed");
        }
        public void mouseReleased(MouseEvent e)
        {
            statuslab.setText("Mouse Released");
        }
        public void mouseEntered(MouseEvent e)
        {
            statuslab.setText("Mouse Entered");
        }
        public void mouseExited(MouseEvent e)
        {
            statuslab.setText("Mouse Exited");
        }
    }
    public class MouseMotionHandler implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent e){
           statuslab.setText("Mouse Dragged at ("+e.getX()+","+e.getY()+")");}
        public void mouseMoved(MouseEvent e){
            statuslab.setText("Mouse Moved at ("+e.getX()+","+e.getY()+")");}
    }
    public static void main(String[] args){
        new MouseEve();}
}
