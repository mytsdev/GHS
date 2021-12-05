import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @version 1.0, 04.12.2021
 * @author https://github.com/mytsdev 
 */

public class Morsecode extends JFrame {
  // Anfang Attribute
  private JTextArea taWords = new JTextArea("");
    private JScrollPane taWordsScrollPane = new JScrollPane(taWords);
  private JTextArea taMorse = new JTextArea("");
    private JScrollPane taMorseScrollPane = new JScrollPane(taMorse);
  private JButton bEncode = new JButton();
  private JButton bDecode = new JButton();
  private JButton bClear = new JButton();
  // Ende Attribute
  
  public Morsecode() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 350;
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Morsecode | M.T. & L.A.B.");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    taWordsScrollPane.setBounds(10, 10, 200, 100);
    cp.add(taWordsScrollPane);
    taMorseScrollPane.setBounds(10, 125, 200, 100);
    cp.add(taMorseScrollPane);
    bDecode.setBounds(215, 125, 100, 25);
    bDecode.setText("Decode");
    bDecode.setMargin(new Insets(2, 2, 2, 2));
    bDecode.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDecode_ActionPerformed(evt);
      }
    });
    cp.add(bDecode);
    bEncode.setBounds(215, 10, 100, 25);
    bEncode.setText("Encode");
    bEncode.setMargin(new Insets(2, 2, 2, 2));
    bEncode.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bEncode_ActionPerformed(evt);
      }
    });
    cp.add(bEncode);
    bClear.setBounds(10, 230, 100, 25);
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
  } // end of public Morsecode
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Morsecode();
  } // end of main

  public void bEncode_ActionPerformed(ActionEvent evt) {
    //encode(taWords.getText(), taMorse);
    taMorse.setText(encode(taWords.getText()));
  } // end of bEncode_ActionPerformed
  
  public void bDecode_ActionPerformed(ActionEvent evt) {
    taWords.setText(decode(taMorse.getText()));
  } // end of bDecode_ActionPerformed

  public void bClear_ActionPerformed(ActionEvent evt) {
    taWords.setText("");
    taMorse.setText("");
  } // end of bClear_ActionPerformed
  
  String encode(String input)
  {
    String output = "";
    if (!input.equals("")) {
      for (int i = 0; i < input.length(); i++) {
        output += encodeChar(input.toLowerCase().charAt(i)) + " ";  
      } 
    }
    return output;
  }

  String encodeChar(char input)
  {
    switch (input) {
      case 'a': return ".-";
      case 'b': return "-...";
      case 'c': return "-.-.";
      case 'd': return "-..";
      case 'e': return ".";
      case 'f': return "..-.";
      case 'g': return "--.";
      case 'h': return "....";
      case 'i': return "..";
      case 'j': return ".---";
      case 'k': return "-.-";
      case 'l': return ".-..";
      case 'm': return "--";
      case 'n': return "-.";
      case 'o': return "---";
      case 'p': return ".--.";
      case 'q': return "--.-";
      case 'r': return ".-.";
      case 's': return "...";
      case 't': return "-";
      case 'u': return "..-";
      case 'v': return "...-";
      case 'w': return ".--";
      case 'x': return "-..-";
      case 'y': return "-.--";
      case 'z': return "--..";
      case ' ': return "/";
    }
    return null;
  }

  String decode(String input)
  {
    String outputString = "";
    if (!input.equals("")) {
      String[] inputStrings = input.split(" ");
      for (int i = 0; i < inputStrings.length; i++) {
        outputString += decodeString(inputStrings[i]);
      }  
    }
    return outputString;
  }

  char decodeString(String input)
  {
    switch (input) {
      case ".-": return 'a';
      case "-...": return 'b';
      case "-.-.": return 'c';
      case "-..": return 'd';
      case ".": return 'e';
      case "..-.": return 'f';
      case "--.": return 'g';
      case "....": return 'h';
      case "..": return 'i';
      case ".---": return 'j';
      case "-.-": return 'k';
      case ".-..": return 'l';
      case "--": return 'm';
      case "-.": return 'n';
      case "---": return 'o';
      case ".--.": return 'p';
      case "--.-": return 'q';
      case ".-.": return 'r';
      case "...": return 's';
      case "-": return 't';
      case "..-": return 'u';
      case "...-": return 'v';
      case ".--": return 'w';
      case "-..-": return 'x';
      case "-.--": return 'y';
      case "--..": return 'z';
      case "/": return ' ';
    }
    return '↯';  
  }
  // Ende Methoden
} // end of class Morsecode
