import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
        System.out.println("action listener added");
        open.addActionListener(this);
        System.out.println("action listener added");

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVisible(true);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().add(scroll);

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
        System.out.println("it gets called");
        if(e.getActionCommand().equals("Open")){
            System.out.println("action has been performed");
            try {
                readFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getSource().equals("Save")){
            try {
                saveFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource().equals("New File")){
            textArea.setText("");
        }
        else if (e.getSource().equals("Cut")){
            textArea.cut();
        }
        else if (e.getSource().equals("Close")){
            frame.setVisible(false);
        }
    }

    private void readFile () throws FileNotFoundException {

        JFileChooser file = new JFileChooser();
        int r = file.showOpenDialog(null);
        File f = new File(file.getSelectedFile().getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(f));
        StringBuffer str = new StringBuffer();

        if( r == JFileChooser.APPROVE_OPTION){
            try{
                String line = reader.readLine();

                while(line != null){
                    str.append(line);
                    str.append(System.lineSeparator());
                    line = reader.readLine();
                }

                this.textArea.setText(str.toString());
                reader.close();

            }
            catch(Exception e){
                System.out.println("Error reading");
            }
        }
        else{
            JOptionPane.showMessageDialog(this.frame, "The user doesn't want it");
        }

    }

    private void saveFile() throws IOException{

        JFileChooser fc = new JFileChooser();
        int r = fc.showSaveDialog(null);

        if(r == JFileChooser.APPROVE_OPTION){
            File f = new File(fc.getSelectedFile().getAbsolutePath());
            try{
                FileWriter writer = new FileWriter(f,false);
                BufferedWriter w = new BufferedWriter(writer);
                w.write(this.textArea.getText());
                w.flush();
                w.close();
            }
            catch(IOException e){
                System.out.println("Something went wrong");
            }
        }
    }

    public static void main(String[] args) {
        new Notepad();
    }

}
