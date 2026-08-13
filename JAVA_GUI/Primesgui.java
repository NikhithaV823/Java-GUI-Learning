import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Primesgui extends JFrame implements ActionListener {
    private JTextField nt1;
    private JTextArea oparea;
    public Primesgui() 
    {
        setTitle("Prime Numbers List");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel toppan = new JPanel();
        JLabel nl1 = new JLabel("Enter integer>=2");
        toppan.add(nl1);
        nt1 = new JTextField(5);
        toppan.add(nt1);
        JButton genbtn = new JButton("GENERATE");
        toppan.add(genbtn);
        add(toppan, BorderLayout.NORTH);
        oparea = new JTextArea(20, 20);
        oparea.setEditable(false);
        oparea.setForeground(Color.GRAY);
        JScrollPane scroll = new JScrollPane(oparea);
        add(scroll, BorderLayout.CENTER);
        genbtn.addActionListener(this); // lambda function
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            int n = Integer.parseInt(nt1.getText());
            if (n < 2) {
                oparea.setText("Enter number>=2");
                return;
            }
            StringBuilder s = new StringBuilder("Prime Numbers upto " + n + " are:\n");
            for (int i = 2; i < n; i++) {
                if (isPrime(i))
                    s.append(i).append(" ");
            }
            oparea.setText(s.toString());
        } catch (NumberFormatException ex) {
            oparea.setText("Invalid Input!Please enter a valid integer:");
        }
    }
    private boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Primesgui(); 
        }); 
    }
}
