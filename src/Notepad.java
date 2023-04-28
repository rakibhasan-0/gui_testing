import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Notepad implements ActionListener {
    JFrame frame;
    JTextArea textArea;

    public Notepad(){

        frame = new JFrame();
        Font font = new Font("Arial",Font.PLAIN,15);
        textArea = new JTextArea();
        JMenuBar menuBar = new JMenuBar();

        textArea.setFont(font);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open");
        file.add(open);
        open.addActionListener(this);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVisible(true);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JMenuItem newFile = new JMenuItem("New File");
        file.add(newFile);
        newFile.addActionListener(this);

        JMenuItem save = new JMenuItem("Save");
        file.add(save);
        newFile.addActionListener(this);

        JMenuItem close = new JMenuItem("Close");
        file.add(close);
        close.addActionListener(this);

        JMenuItem copy = new JMenuItem("Copy");
        edit.add(copy);
        copy.addActionListener(this);

        JMenuItem cut = new JMenuItem("Cut");
        edit.add(cut);
        cut.addActionListener(this);

        JMenuItem paste = new JMenuItem("Paste");
        edit.add(paste);
        paste.addActionListener(this);

        help.addActionListener(this);

        menuBar.add(file); menuBar.add(edit); menuBar.add(help);

        frame.setJMenuBar(menuBar);
        frame.add(textArea);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals("Open")){
            try {
                ReadAndWrite.readFile(frame,textArea);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
