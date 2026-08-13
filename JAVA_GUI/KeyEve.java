import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class KeyEve extends JFrame
{
    private JTextField input;
    private JTextArea oparea;
    public KeyEve()
    {
        setTitle("Key Event Demo");
        setSize(400,300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new JLabel("Type something in the TExtField:"),BorderLayout.NORTH);
        input=new JTextField();
        oparea=new JTextArea();
        oparea.setEditable(false);
        add(input,BorderLayout.CENTER);
        add(new JScrollPane(oparea),BorderLayout.SOUTH);
        input.addKeyListener(new MykListener());
        setVisible(true);
    }
    private class MykListener implements KeyListener
    {
        public void keyTyped(KeyEvent e)
        {
            oparea.append("Key Typed:"+e.getKeyChar()+"\n");
        }
        public void keyPressed(KeyEvent e)
        {
            oparea.append("Key Pressed:"+KeyEvent.getKeyText(e.getKeyCode())+"\n");
        }
        public void keyReleased(KeyEvent e)
        {
            oparea.append("Key Released:"+KeyEvent.getKeyText(e.getKeyCode())+"\n");
        }
    }
    public static void main(String[] args)
    {
        new KeyEve();
    }
        
}
    

