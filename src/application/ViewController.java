package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ViewController implements Initializable {

  @FXML
  private Button btnCalc;

  @FXML
  private TextField txtFldBill;

  @FXML
  private TextField txtFldTip;

  @FXML
  private TextField txtFldNbPeople;

  @FXML
  private TextField txtFldTipPerso;

  @FXML
  private TextField txtFldTotalPerso;
  
  @FXML
  private TextField DatTip;
  
  @FXML
  private Text TxtError;

  //-------------------------------------------
  //               Methodes
  // -------------------------------------------
  
  public void Clac(ActionEvent e) throws VCExecption{
    String txtEnregCat;
    String fileName = "C:\\Users\\Eleve\\Documents\\moneyFile.txt";
    try {
      this.TxtError.setText("");
      
      checkInt("Bill", txtFldBill.getText());
      checkInt("Tip", txtFldTip.getText());
      checkInt("Nb people", txtFldNbPeople.getText());
      
      int bill = Integer.parseInt(txtFldBill.getText());
      int tip = Integer.parseInt(txtFldTip.getText());
      int nbPeople = Integer.parseInt(txtFldNbPeople.getText());
      
      int resTipPerPers = (((bill*tip)/100)/nbPeople);
      int resTotPerPers = ((bill+((bill*tip)/100))/nbPeople);
      
      this.txtFldTipPerso.setText(Integer.toString(resTipPerPers));
      this.txtFldTotalPerso.setText(Integer.toString(resTotPerPers));
      
      Writer wrt = new Writer(txtFldBill.getText(),txtFldTip.getText(),txtFldNbPeople.getText(),DatTip.getText());
      txtEnregCat = wrt.formaterTxt();
      wrt.fileWriter(fileName, txtEnregCat);
//      System.out.println(localDate);
      
      
    } catch (VCExecption err) {
      this.TxtError.setText("Error: saisie de "+ err.getLabel() + " incorrect" );
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
   this.txtFldTip.setText("10");
   this.txtFldNbPeople.setText("3"); 
  }
  
  public void checkInt(String label, String intToCheck) throws VCExecption{
    try {
      Integer.parseInt(intToCheck);
    } catch (Exception e) {
      throw new VCExecption(label);
    }
  }
}
