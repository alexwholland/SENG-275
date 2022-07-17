package Lab08;

public class Task extends Patient{
    public int patientNumber;
    public String careProvided;
    public String timeOfCare;
    public String assignedNurseName;

    public Task(){
        this.patientNumber = -1;
        this.careProvided = "N/A";
        this.timeOfCare = "N/A";
        this.assignedNurseName = "N/A";
    }

    public Task(int patientNumber, String careProvided, String timeOfCare, String assignedNurseName){
        this.patientNumber = patientNumber;
        this.careProvided = careProvided;
        this.timeOfCare = timeOfCare;
        this.assignedNurseName = assignedNurseName;
    }

    public int getPatientNumber(){
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber){
        this.patientNumber = patientNumber;
    }

    public String getCareProvided(){
        return careProvided;
    }

    public void setCareProvided(String careProvided){
        this.careProvided = careProvided;
    }

    public String getTimeOfCare(){
        return timeOfCare;
    }

    public void setTimeOfCare(String timeOfCare){
        this.timeOfCare = timeOfCare;
    }

    public String getAssignedNurseName(){
        return assignedNurseName;
    }

    public void setAssignedNurseName(String assignedNurseName){
        this.assignedNurseName = assignedNurseName;
    }
}