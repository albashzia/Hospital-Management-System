public class Patient extends Person{
    private String illness;

    Patient(){
        super();
        this.illness = null;
    }

    Patient(String id, String name, int age, String illness){
        super(id,name,age);
        this.illness = illness;
    }

    public void setIllness(String illness){
        this.illness = illness;
    }

    public String getIllness(){
        return this.illness;
    }

}
