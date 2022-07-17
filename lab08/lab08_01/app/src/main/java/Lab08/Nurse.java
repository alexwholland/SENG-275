package Lab08;

public class Nurse{

    public String name;
    public String shift;

    public Nurse(){
        this.name = "";
        this.shift = "";
    }

    public Nurse(String name, String shift) {
        this.name = name;
        this.shift = shift;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getShift(){
        return shift;
    }

    public void setShift(String shift){
        this.shift = shift;
    }

}