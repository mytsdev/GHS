/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 25.02.2015
  * @author 
  */

public class Wrapper {
  
  // Anfang Attribute
  private String entry1;
  private String entry2;
  // Ende Attribute
  
  public Wrapper(String pInput1, String pInput2) {
    entry1 = pInput1;
    entry2 = pInput2;
  }

  // Anfang Methoden
  public String getEntry1(){
    return entry1;   
  }
  public String getEntry2(){
    return entry2;  
  }

  // Ende Methoden
} // end of Wrapper
