import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class KeyAdapt extends JFrame 
{
    private JTextField input;
    private JTextArea  oparea;
    public KeyAdapt()
    {
        super("KeyEvent Adapter Example");
        setBounds(500,200,500,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new JLabel("Text something in the below Box"),BorderLayout.NORTH);
        input=new JTextField();
        add(input,BorderLayout.CENTER);
        oparea=new JTextArea();
         oparea.setEditable(false);
         JScrollPane sp=new JScrollPane(oparea);
        add(sp,BorderLayout.SOUTH);
        sp.setPreferredSize(new Dimension(500,250));
        input.addKeyListener(new MyKeyAdapt());
        setVisible(true);
    }
    private class MyKeyAdapt extends  KeyAdapter
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
        new KeyAdapt();
    }
}
