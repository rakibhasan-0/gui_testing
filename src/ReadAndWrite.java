import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

}

