import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notepad implements ActionListener {

    JFrame frame;
    JTextArea textArea;

    public Notepad(){

        frame = new JFrame();
        textArea = new JTextArea("Notepad");
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
