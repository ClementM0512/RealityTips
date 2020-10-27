package application;

public class VCExecption extends Exception {

  private String label;
  
  public VCExecption(String label) {
    super();
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}
