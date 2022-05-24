import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @version 1.0, 05.05.2022
 * @author https://github.com/mytsdev
 */

public class Caesarcipher extends JFrame {
  // Anfang Attribute
  private JLabel lMode = new JLabel();
  private JComboBox<String> cbMode = new JComboBox<String>();
  private DefaultComboBoxModel<String> cbModeModel = new DefaultComboBoxModel<String>();
  private JLabel lRotation = new JLabel();
  private JNumberField nfRotation = new JNumberField();
  private JTextArea taInput = new JTextArea("");
  private JScrollPane taInputScrollPane = new JScrollPane(taInput);
  private JLabel lInput = new JLabel();
  private JLabel lOutput = new JLabel();
  private JTextArea taOutput = new JTextArea("");
  private JScrollPane taOutputScrollPane = new JScrollPane(taOutput);
  private JButton bRun = new JButton();
  // Ende Attribute

  public Caesarcipher() {
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 545;
    int frameHeight = 535;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Caesarcipher | m.t. & l.a.b.");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten penis

    lMode.setBounds(5, 10, 40, 20);
    lMode.setText("Mode:");
    cp.add(lMode);
    cbMode.setModel(cbModeModel);
    cbMode.setBounds(45, 10, 90, 20);
    cbModeModel.addElement("Encode");
    cbModeModel.addElement("Decode");
    cbModeModel.addElement("Bruteforce");
    cbMode.setSelectedIndex(0);
    cp.add(cbMode);
    lRotation.setBounds(140, 10, 50, 20);
    lRotation.setText("Rotation:");
    cp.add(lRotation);
    nfRotation.setBounds(195, 10, 75, 20);
    nfRotation.setText("");
    cp.add(nfRotation);
    taInputScrollPane.setBounds(5, 50, 520, 200);
    cp.add(taInputScrollPane);
    lInput.setBounds(5, 30, 110, 20);
    lInput.setText("Input:");
    cp.add(lInput);
    lOutput.setBounds(5, 265, 110, 20);
    lOutput.setText("Output:");
    cp.add(lOutput);
    taOutputScrollPane.setBounds(5, 285, 520, 200);
    taOutput.setEditable(false);
    cp.add(taOutputScrollPane);
    bRun.setBounds(435, 10, 90, 25);
    bRun.setText("Run");
    bRun.setMargin(new Insets(2, 2, 2, 2));
    bRun.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bRun_ActionPerformed(evt);
      }
    });
    cp.add(bRun);
    // Ende Komponenten

    setVisible(true);
  } // end of public Caesarcipher

  // Anfang Methoden

  public static void main(String[] args) {
    new Caesarcipher();
  } // end of main

  public void bRun_ActionPerformed(ActionEvent evt) {
    String message = taInput.getText().toUpperCase();
    int index = cbMode.getSelectedIndex();
    int rotation;
    try {
      rotation = nfRotation.getInt() % 26;
    } catch (Exception e) {
      rotation = 0;
    }
    taInput.setText(message);
    if (index == 0) {
      taOutput.setText(encodeString(message, rotation));
    } else if (index == 1) {
      taOutput.setText(decodeString(message, rotation));
    } else if (index == 2) {
      taOutput.setText(decodeStringBruteforce(message));
    }
  } // end of bRun_ActionPerformed

  private String encodeString(String input, int rot) {
    String s = "";
    for (int i = 0; i < input.length(); i++) {
      s += encodeChar(input.charAt(i), rot);
    }
    return s;
  }

  private char encodeChar(char c, int rot) {
    char copy = c;
    if (Character.isLetter(c)) {
      char rotated = (char) (copy + rot);
      if (rotated > 'Z') {
        rotated = (char) (copy - (26 - rot));
      }
      copy = rotated;
    }
    return copy;
  }

  private String decodeString(String input, int rot) {
    String s = "";
    for (int i = 0; i < input.length(); i++) {
      s += decodeChar(input.charAt(i), rot);
    }
    return s;
  }

  private char decodeChar(char c, int rot) {
    char copy = c;
    if (Character.isLetter(c)) {
      char rotated = (char) (copy - rot);
      if (rotated < 'A') {
        rotated = (char) (copy + (26 - rot));
      }
      copy = rotated;
    }
    return copy;
  }

  private String decodeStringBruteforce(String message) {
    String s = "";
    for (int rot = 0; rot < 26; rot++) {
      s += decodeString(message, rot) + "\n";
    }
    return s;
  }

  // Ende Methoden
} // end of class Caesarcipher