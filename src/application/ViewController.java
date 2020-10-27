package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
  //            Init
  // -------------------------------------------
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
   this.txtFldTip.setText("10");
   this.txtFldNbPeople.setText("3"); 
  }
  
  //-------------------------------------------
  //         setters and getters
  // -------------------------------------------
  
  public Button getBtnCalc() {
    return btnCalc;
  }

  public void setBtnCalc(Button btnCalc) {
    this.btnCalc = btnCalc;
  }

  public TextField getTxtFldBill() {
    return txtFldBill;
  }

  public void setTxtFldBill(TextField txtFldBill) {
    this.txtFldBill = txtFldBill;
  }

  public TextField getTxtFldTip() {
    return txtFldTip;
  }

  public void setTxtFldTip(TextField txtFldTip) {
    this.txtFldTip = txtFldTip;
  }

  public TextField getTxtFldNbPeople() {
    return txtFldNbPeople;
  }

  public void setTxtFldNbPeople(TextField txtFldNbPeople) {
    this.txtFldNbPeople = txtFldNbPeople;
  }

  public TextField getTxtFldTipPerso() {
    return txtFldTipPerso;
  }

  public void setTxtFldTipPerso(TextField txtFldTipPerso) {
    this.txtFldTipPerso = txtFldTipPerso;
  }

  public TextField getTxtFldTotalPerso() {
    return txtFldTotalPerso;
  }

  public void setTxtFldTotalPerso(TextField txtFldTotalPerso) {
    this.txtFldTotalPerso = txtFldTotalPerso;
  }

  public TextField getDatTip() {
    return DatTip;
  }

  public void setDatTip(TextField datTip) {
    DatTip = datTip;
  }

  public Text getTxtError() {
    return TxtError;
  }

  public void setTxtError(Text txtError) {
    TxtError = txtError;
  }
  //-------------------------------------------
  //               Methodes
  // -------------------------------------------
  public void Clac(ActionEvent e) throws VCExecption{
    String txtEnregCat;
    String fileName = "moneyFile.txt";
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

      Reader rder = new Reader();
      
      System.out.println(Reader.readFile(fileName));
    } catch (VCExecption err) {
      this.TxtError.setText("Error: saisie de "+ err.getLabel() + " incorrect" );
    }
  }

  public void checkInt(String label, String intToCheck) throws VCExecption{
    try {
      Integer.parseInt(intToCheck);
    } catch (Exception e) {
      throw new VCExecption(label);
    }
  }
}
