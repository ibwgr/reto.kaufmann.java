package Fach_3_Swing.ch.ibw.swing.uebungen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class CSVJTableExampleNextGen extends JFrame {

    private JTable table;
    private JButton btnAction;
    private Label labelFileAnzeige;
    private File f;

    public CSVJTableExampleNextGen()
    {
        super("CSVJTableExample");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnAction = new JButton("Dateiauswahl");
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
              //f = new File ("/home/rk/IntelliJ-Workspace/Semester1/src/Fach_3_Swing/ch/ibw/swing/uebungen/daten.csv");
                f = getFile();
                TableModel model = parseCSVAndCreateTableModel(f);
                table.setModel(model);

                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
                table.setRowSorter(sorter);

                labelFileAnzeige.setText("  " +f.getName() + " wurde geladen");
                labelFileAnzeige.setVisible(true);
            }
        });


        table = new JTable();
        table.setBackground(new Color(154,184,164));
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(1,2));
        add(jp,BorderLayout.SOUTH);
        jp.add(btnAction);

        labelFileAnzeige = new Label();
        jp.add(labelFileAnzeige);
        labelFileAnzeige.setVisible(false);

        pack();
        setVisible(true);
    }

    public File getFile() {
        JFileChooser fileChooser = new JFileChooser("/home/rk/temp");

        // Abstract Filefilter, muss accept implementieren
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // entweder nur CSV Files oder Verzeichnisse (zeigt beides an)
                return pathname.getName().toLowerCase().endsWith("csv")
                        || pathname.isDirectory();
            }
            @Override
            public String getDescription() {
                return "CSV Dateien";
            }
        };

        //Filter dem Filechooser setzen
        fileChooser.setFileFilter(filter);

        // fileChooser.showOpenDialog(this); erwartet eine Komponente, ein FRAME, also wir selbst!
        int returnCode = fileChooser.showOpenDialog(this);
        if (returnCode == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public static void main(final String[] args)
    {
        new CSVJTableExampleNextGen();
    }

    // ..................................................File kennt nur die Informationen der Datei, kann weder oeffnen, noch lesen!
    public TableModel parseCSVAndCreateTableModel(final File file)
    {
        // LISTE von ZEILEN MIT FELDERN
        // Vector ist wie eine ArrayList
        // kann aber dagegen nicht auf ein einzelnes Element zugreifen
        final Vector v = new Vector();

        // Ein "Leser", stellt Lesefunktionen bereit
        BufferedReader br = null;
        try {
            // Filereader oeffnet die Datei
            // der Zeiger steht auf oberster Position am Anfang
            br = new BufferedReader(new FileReader(file));

            // ----------------------------------
            // 1. ZEILE LESEN (HEADER)
            // ----------------------------------
            // auf erster Zeile die Beschriftung lesen
            // splitten bei semikolon (da csv file)
            String[] rowItems = br.readLine().split(";");
            // daraus ein Vector machen, also ARRAY -> VECTOR (wegen dem Table Model)
            final Vector header = new Vector(Arrays.asList(rowItems));

            // ----------------------------------
            // ALLE ZEILEN LESEN
            // ----------------------------------
            // Bufferreader, solange READY hat es noch Zeilen (sonst File fertiggelesen)
            while(br.ready()){
                // Zeile lesen
                rowItems = br.readLine().split(";");
                v.add( new Vector(Arrays.asList(rowItems)) );
            }

            // ----------------------------------
            // MODEL ERSTELLEN
            // ----------------------------------
            DefaultTableModel model = new DefaultTableModel(v,header);
            return model;

        } catch (Exception e) {
            // behandelt FileNotFoundException, IOException usw.
            e.printStackTrace();
        } finally {
            // FILE ZWINGEND SCHLIESSEN!
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
