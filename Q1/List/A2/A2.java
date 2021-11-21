import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.io.File;

/**
  * @version 1.0 vom 17.11.2021
  * @https://github.com/mytsdev 
  */

public class A2 extends JFrame {
  // Anfang Attribute
  private JTextField tfInput1 = new JTextField();
  private JTextField tfInput2 = new JTextField();
  private JButton bAdd = new JButton();
  private JButton bShow = new JButton();
  private JButton bClear = new JButton();
  private JTextArea taOutput = new JTextArea("");
  private JScrollPane taOutputScrollPane = new JScrollPane(taOutput);
  
  public List list1 = new List();
  // Ende Attribute
  
  public A2(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 350; 
    int frameHeight = 260;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    tfInput1.setBounds(10, 10, 105, 25);
    cp.add(tfInput1);
    bAdd.setBounds(240, 10, 81, 25);
    bAdd.setText("Add");
    bAdd.setMargin(new Insets(2, 2, 2, 2));
    bAdd.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bAdd_ActionPerformed(evt);
      }
    });
    cp.add(bAdd);
    bShow.setBounds(240, 50, 81, 25);
    bShow.setText("Show");
    bShow.setMargin(new Insets(2, 2, 2, 2));
    bShow.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bShow_ActionPerformed(evt);
      }
    });
    cp.add(bShow);
    taOutputScrollPane.setBounds(10, 50, 220, 161);
    taOutput.setEditable(false);
    cp.add(taOutputScrollPane);
    tfInput2.setBounds(125, 10, 105, 25);
    cp.add(tfInput2);
    setTitle("A2 | M.T. & L.A.B.");
    bClear.setBounds(240, 185, 75, 25);
    bClear.setText("Clear");
    bClear.setMargin(new Insets(2, 2, 2, 2));
    bClear.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bClear_ActionPerformed(evt);
      }
    });
    cp.add(bClear);
    // Ende Komponenten
    
    setVisible(true);
    setIconImage(new ImageIcon("E:/EZ.png").getImage());
    onStart();                           
  } // end of public A2
  
  // Anfang Methoden
  public void onStart(){
    //Creates the "database.txt"-file if the file does not exist
    try {
      File fileDatabase = new File("database.txt");
      fileDatabase.createNewFile();
      FileOutputStream oFileDatabase = new FileOutputStream(fileDatabase, true);  
    } catch(Exception e) {
      e.printStackTrace();
    }
    //Reads the saved data of "database.txt"-file and puts it into the list
    try (BufferedReader br = new BufferedReader(new FileReader("database.txt"))){
      String line;
      while ((line = br.readLine()) != null) {
        if (line.contains(";") == true) {
          String[] splittedLine = line.split(";");
          Wrapper w = new Wrapper(splittedLine[0], splittedLine[1]);
          list1.append(w);  
        } // end of if   
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  public void bAdd_ActionPerformed(ActionEvent evt) {
    addToList();
  } // end of bAdd_ActionPerformed
  
  public void bShow_ActionPerformed(ActionEvent evt) {
    showList();
  } // end of bShow_ActionPerformed
  
  public void bClear_ActionPerformed(ActionEvent evt) {
    clearList();
    showList();
  } // end of bClear_ActionPerformed
  
  void addToList(){
    String input1 = tfInput1.getText();
    String input2 = tfInput2.getText();
    if ((!input1.equals("") && !input2.equals("")) && (!input1.contains(" ") && !input2.contains(" "))) {
      Wrapper w = new Wrapper(input1, input2);
      list1.append(w);
      tfInput1.setText("");
      tfInput2.setText("");
      databaseSave();
    } // end of if 
  }
  
  void showList(){
    taOutput.setText("");
    list1.toFirst();
    int i = 1;
    while (list1.hasAccess() == true) { 
      Wrapper w = (Wrapper) list1.getObject();
      taOutput.append(i + ". " +w.getEntry1() + " " + w.getEntry2() + "\n");
      i++;
      list1.next();  
    } // end of while  
  }
  
  void clearList(){
    list1.toFirst();
    while (list1.hasAccess() == true) { 
      list1.remove();
    } // end of while
    databaseSave();
  }

  void databaseSave(){
    try {
      new PrintWriter("database.txt").close();
    } catch(Exception e) {
      e.printStackTrace();
    }
    list1.toFirst();
    while (list1.hasAccess()) { 
      Wrapper w = (Wrapper)list1.getObject();
      try (FileWriter fw = new FileWriter("database.txt", true)){
        fw.write(w.getEntry1() + ";" + w.getEntry2() + "\r\n");
      } catch(Exception e) {
        e.printStackTrace();
      }
      list1.next();
    } // end of while
  }
  
  public static void main(String[] args) {
    new A2("A2");
  } // end of main
  
} // end of class A2
