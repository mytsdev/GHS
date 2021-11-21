import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  * @version 1.0 vom 21.11.2021
  * @https://github.com/mytsdev 
  */

public class A1 extends JFrame {

  private JTextField tfInput1 = new JTextField();
  private JTextField tfInput2 = new JTextField();
  private JButton bAdd = new JButton();
  private JButton bShow = new JButton();
  private JButton bClear = new JButton();
  private JTextArea taOutput = new JTextArea("");
  private JScrollPane taOutputScrollPane = new JScrollPane(taOutput);
  
  public List list1 = new List();
  
  public A1(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 420; 
    int frameHeight = 250;
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
    bAdd.setBounds(230, 10, 81, 25);
    bAdd.setText("Add");
    bAdd.setMargin(new Insets(2, 2, 2, 2));
    bAdd.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bAdd_ActionPerformed(evt);
      }
    });
    cp.add(bAdd);
    bShow.setBounds(315, 10, 81, 25);
    bShow.setText("Show");
    bShow.setMargin(new Insets(2, 2, 2, 2));
    bShow.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bShow_ActionPerformed(evt);
      }
    });
    cp.add(bShow);
    taOutputScrollPane.setBounds(10, 45, 215, 161);
    cp.add(taOutputScrollPane);
    tfInput2.setBounds(120, 10, 105, 25);
    cp.add(tfInput2);
    setTitle("A1 | M.T. & L.A.B.");
    
    bClear.setBounds(230, 180, 75, 25);
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
  } // end of public A1
  
  public void bAdd_ActionPerformed(ActionEvent evt) {
    String input1 = tfInput1.getText();
    String input2 = tfInput2.getText();
    if(!input1.equals("") && !input2.equals("")){
      if (!input1.contains(" ") && !input2.contains(" ")) {
        Wrapper w = new Wrapper(input1, input2);
        list1.append(w);
        tfInput1.setText("");
        tfInput2.setText("");
      }
    }
  }
  
  public void bShow_ActionPerformed(ActionEvent evt) {
    showList();
  }
  
  public void bClear_ActionPerformed(ActionEvent evt) {
    list1.toFirst();
    while (list1.hasAccess()) { 
      list1.remove();
    }
    showList();
  }
  
  void showList(){
    taOutput.setText("");
    list1.toFirst();
    int i = 1;
    while (list1.hasAccess()) { 
      Wrapper w = (Wrapper) list1.getObject();
      taOutput.append(i + ". " + w.getEntry1() + " " + w.getEntry2() + "\n");
      i++;
      list1.next();
    }
  }

  public static void main(String[] args) {
    new A1("A1");
  }
  
}
