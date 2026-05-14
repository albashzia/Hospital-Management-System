import javax.swing.text.html.HTMLDocument;

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

    public void display(){
        System.out.println("===Patient Details===\n");
        super.display();
        System.out.println("Illness: "+ getIllness());
    }

    @Override
    public String toString() {
        return "Patient ID: " + super.getId() +
                ", Name: " + super.getName() +
                ", Age: " + super.getAge() +
                ", Illness: " + this.getIllness();
    }

}
