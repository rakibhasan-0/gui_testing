import javax.swing.*;
import java.io.*;

public class ReadAndWrite {

    public static void readFile (JFrame frame, JTextArea textArea) throws IOException {

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

                textArea.setText(str.toString());
                reader.close();

            }
            catch(Exception e){
                System.out.println("Error reading");
            }
        }
        else{
            JOptionPane.showMessageDialog(frame, "The user doesn't want it");
        }

    }

    public static void writeFile(JTextArea textArea, JFrame frame) throws IOException{

        JFileChooser fc = new JFileChooser();
        int r = fc.showSaveDialog(null);

        if(r == JFileChooser.APPROVE_OPTION){
            File f = new File(fc.getSelectedFile().getAbsolutePath());
            try{
                FileWriter writer = new FileWriter(f,false);
                BufferedWriter w = new BufferedWriter(writer);
                w.write(textArea.getText());
                w.flush();
                w.close();
            }
            catch(IOException e){
                System.out.println("Something went wrong");
            }
        }
    }

}

