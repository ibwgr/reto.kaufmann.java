package Fach_6_FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyBytes {
    public static void main(String[] args) {

        // dieses klasse zeigt nur das kopieren-konzept auf, mittels BINARY COPY
        // wenn man CHARACER COPY machen moechte, dann muesste man
        // den FileReader/FileWriter anstatt FileInputStream/FileOutputStream


        // dynamisch je nach PC/Server das aktuelle Verzeichnis ermitteln
        //Thread.currentThread().getContextClassLoader().getResourceAsStream();

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/Fach_6_FileIO/myDirectory/songs.txt");
            out = new FileOutputStream("src/Fach_6_FileIO/myDirectory/songs-copy.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    // schliessen
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    // schliessen
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
