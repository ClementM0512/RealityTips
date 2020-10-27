package application;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Writer {
  
  private String bill;
  private String tip;
  private String nbPeople;
  private String datTip;
  
  public Writer(String bill, String tip, String nbPeople, String datTip) {
    this.bill = bill;
    this.tip = tip;
    this.nbPeople = nbPeople;
    this.datTip = datTip;
  }
  
  public String formaterTxt() {
    String res = null;
    res = this.datTip+';'+this.bill+';'+this.tip+';'+this.nbPeople;
    
    return res;
  }
  
  public void fileWriter(String fileName, String txt) {
    try {
      FileWriter writer = new FileWriter(fileName);
//      writer.write("\n");
      writer.write(txt);
     
      writer.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }catch (IOException e) {
      e.printStackTrace();
    }
  }
}
