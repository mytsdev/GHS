import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.io.File;

/**
  * @version 1.0 vom 21.11.2021
  * @https://github.com/mytsdev 
  */

public class A3 extends JFrame {
  // Anfang Attribute
  private JTextField tfInput1 = new JTextField();
  private JTextField tfInput2 = new JTextField();
  private JNumberField nfEntryIndex = new JNumberField();
  private JButton bConfirm = new JButton();
  private JButton bClear = new JButton();
  private JButton bDelete = new JButton();
  private JButton bEdit = new JButton();
  private JButton bAdd = new JButton();
  private JTextArea taOutput = new JTextArea("");
  private JScrollPane taOutputScrollPane = new JScrollPane(taOutput);
  
  public List list1 = new List();
  // Ende Attribute
  
  public A3(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 430; 
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
    bConfirm.setBounds(320, 110, 81, 25);
    bConfirm.setText("Confirm");
    bConfirm.setMargin(new Insets(2, 2, 2, 2));
    bConfirm.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bConfirm_ActionPerformed(evt);
      }
    });
    cp.add(bConfirm);
    taOutputScrollPane.setBounds(10, 55, 220, 161);
    taOutput.setEditable(false);
    cp.add(taOutputScrollPane);
    tfInput2.setBounds(125, 10, 105, 25);
    cp.add(tfInput2);
    setTitle("A3 | M.T. & L.A.B.");
    bClear.setBounds(240, 190, 75, 25);
    bClear.setText("Clear");
    bClear.setMargin(new Insets(2, 2, 2, 2));
    bClear.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bClear_ActionPerformed(evt);
      }
    });
    cp.add(bClear);
    nfEntryIndex.setBounds(240, 55, 75, 20);
    nfEntryIndex.setText("");
    cp.add(nfEntryIndex);
    bDelete.setBounds(240, 80, 75, 25);
    bDelete.setText("Delete");
    bDelete.setMargin(new Insets(2, 2, 2, 2));
    bDelete.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDelete_ActionPerformed(evt);
      }
    });
    cp.add(bDelete);
    bEdit.setBounds(240, 110, 75, 25);
    bEdit.setText("Edit");
    bEdit.setMargin(new Insets(2, 2, 2, 2));
    bEdit.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bEdit_ActionPerformed(evt);
      }
    });
    cp.add(bEdit);
    bAdd.setBounds(240, 10, 80, 25);
    bAdd.setText("Add");
    bAdd.setMargin(new Insets(2, 2, 2, 2));
    bAdd.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bAdd_ActionPerformed(evt);
      }
    });
    cp.add(bAdd);
    setIconImage(new ImageIcon("E:/EZ.png").getImage());
    // Ende Komponenten
    
    setVisible(true);
    onStart();                           
  } // end of public A3
  
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
    showList();
  }
  
  public void bAdd_ActionPerformed(ActionEvent evt) {
    addToList();
    showList();
  } // end of bAdd_ActionPerformed
  
  public void bConfirm_ActionPerformed(ActionEvent evt) {
    editNode();
    showList();
  } // end of bConfirm_ActionPerformed
  
  public void bClear_ActionPerformed(ActionEvent evt) {
    clearList();
    showList();
  } // end of bClear_ActionPerformed
  
  public void bDelete_ActionPerformed(ActionEvent evt) {
    deleteNode();
    showList();
  } // end of bDelete_ActionPerformed
  
  public void bEdit_ActionPerformed(ActionEvent evt) {
    
    getNode();
  } // end of bEdit_ActionPerformed
  
  void addToList(){
    String input1 = tfInput1.getText();
    String input2 = tfInput2.getText();
    if ((!input1.equals("") && !input2.equals("")) && (!input1.contains(" ") && !input2.contains(" "))) {
      Wrapper w = new Wrapper(input1, input2);
      list1.append(w);
      tfInput1.setText("");
      tfInput2.setText("");
      updateDatabase();
    } 
  }
  
  void showList(){
    taOutput.setText("");
    list1.toFirst();
    int i = 1;
    while (list1.hasAccess() == true) { 
      Wrapper w = (Wrapper) list1.getObject();
      taOutput.append(i + ". " + w.getEntry1() + " " + w.getEntry2() + "\n");
      i++;
      list1.next();  
    } // end of while  
  }
  
  void clearList(){
    list1.toFirst();
    while (list1.hasAccess()) { 
      list1.remove();
    } // end of while
    updateDatabase();
  }
  
  void deleteNode(){
    int index = nfEntryIndex.getInt();
    if (index > 0) {
      list1.toFirst();
      for (int i = 0; i < index-1; i++) {
        list1.next();
      } // end of for
      list1.remove();
      nfEntryIndex.setInt(0);
    } // end of if
    updateDatabase();
  }
  
  void updateDatabase(){
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
  
  void getNode(){
    list1.toFirst();
    int indexLength = 1;
    while (list1.hasAccess()) { 
      indexLength++;
      list1.next();
    } // end of while
    int index = nfEntryIndex.getInt();
    if (indexLength > index && index > 0) {
      list1.toFirst();
      for (int i = 0; i < index-1; i++) {
        list1.next();
      } // end of for
      Wrapper w = (Wrapper) list1.getObject();
      tfInput1.setText(w.getEntry1());
      tfInput2.setText(w.getEntry2());
    } // end of if
  }
  
  void editNode(){
    Wrapper w = new Wrapper(tfInput1.getText(), tfInput2.getText());
    list1.setObject(w);
    tfInput1.setText("");
    tfInput2.setText("");
    nfEntryIndex.setInt(0);
    updateDatabase();
  }
  
  // Ende Methoden
  
  public static void main(String[] args) {
    new A3("A3");
  } // end of main
  
} // end of class A3
