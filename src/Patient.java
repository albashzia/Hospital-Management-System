import java.io.*;

public class Patient extends Person implements Serializable{
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

    public void savePatient(Patient patient){
        final String PATIENTS_FILE = "patients.ser";
        try {
            ObjectOutputStream pos = new ObjectOutputStream(new FileOutputStream(PATIENTS_FILE));
            pos.writeObject(patient);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void readPatient(){
        final String PATIENTS_FILE = "patients.ser";
        try {
            ObjectInputStream pis = new ObjectInputStream(new FileInputStream(PATIENTS_FILE));
            while (true){
                Patient patient = (Patient) pis.readObject();
                System.out.println(patient.toString());
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
