import java.io.*;
import java.util.*;

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

    @Override
    public boolean equals(Object obj){

        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        Patient other = (Patient) obj;

        return getId().equals(other.getId());
    }

    public void savePatient(Patient patient){
        final String PATIENTS_FILE = "patients.ser";
        ArrayList<Patient> patients = new ArrayList<>();

        try(ObjectInputStream pis = new ObjectInputStream(new FileInputStream(PATIENTS_FILE)))
        {
            patients = (ArrayList<Patient>) pis.readObject();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        patients.add(patient);

        try(ObjectOutputStream pos = new ObjectOutputStream(new FileOutputStream(PATIENTS_FILE)))
        {
            pos.writeObject(patients);
        }
        catch (Exception e)
        {
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
