package Lab08;

public class Patient {
    public int number;
    public String careNeeds;
    public String medicationNeeds;

    String[] medications = {"Diabetes medication (diamed)", "heart medication (hrtrace)", "Blood thinner medication (blothin)", "ashtma medication", "antibiotic amoxycilin", "penecilin"};
    String[] needs = {"blood pressure taken and recorded", "assessed for stability"};

    public Patient() {
        this.number = -1;
        this.careNeeds = "N/A";
        this.medicationNeeds = "N/A";
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public String getCareNeeds(){
        return careNeeds;
    }

    public void setCareNeeds(String careNeeds){
        this.careNeeds = careNeeds;
    }

    public String getMedicationNeeds(){
        return medicationNeeds;
    }

    public void setMedicationNeeds(String medicationNeeds){
        this.medicationNeeds = medicationNeeds;
    }

}