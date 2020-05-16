package sessionproj;

import java.io.Serializable;
import java.util.ArrayList;

public class DataPackage implements Serializable {
    private String operationType;// add, list
    private Drug drug;
    private ArrayList<Drug> drugs;

    public DataPackage(String operationType, Drug drug) {
        this.operationType = operationType;
        this.drug = drug;
    }

    public DataPackage(String operationType) {
        this.operationType = operationType;
    }

    public DataPackage(ArrayList<Drug> drugs) {
        this.drugs = drugs;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(ArrayList<Drug> drugs) {
        this.drugs = drugs;
    }
    
    
}
