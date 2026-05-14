import java.io.*;

public class Doctor extends Person implements Serializable{
    private String specialization;

    Doctor(){
        super();
        this.specialization = null;
    }

    Doctor(String id, String name, int age, String specialization){
        super(id,name,age);
        this.specialization = specialization ;
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    public String getSpecialization(){
        return this.specialization;
    }

    public void display(){
        System.out.println("===Doctor Details===\n");
        super.display();
        System.out.println("Specialization: "+ getSpecialization());
    }

    @Override
    public String toString() {
        return "Patient ID: " + super.getId() +
                ", Name: " + super.getName() +
                ", Age: " + super.getAge() +
                ", Specialization: " + this.getSpecialization();
    }

    public void saveDoctor(Doctor doctor){
        final String DOCTORS_FILE = "doctors.ser";
        try {
            ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream(DOCTORS_FILE));
            dos.writeObject(doctor);
        }
        catch (Exception e){
            e.getCause();
        }
    }
}
