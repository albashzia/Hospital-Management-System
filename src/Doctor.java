import java.io.*;
import java.util.*;

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

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        Doctor other = (Doctor) obj;
        return getId().equals(other.getId());
    }

    public void saveDoctor(Doctor doctor){
        final String DOCTORS_FILE = "doctors.ser";
        ArrayList<Doctor> doctors = new ArrayList<>();

        try(ObjectInputStream dis = new ObjectInputStream(new FileInputStream(DOCTORS_FILE)))
        {
            doctors = (ArrayList<Doctor>) dis.readObject();

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        doctors.add(doctor);

        try(ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream(DOCTORS_FILE)))
        {
            dos.writeObject(doctors);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void readDoctor(){
        final String DOCTORS_FILE = "doctors.ser";
        try(ObjectInputStream dis = new ObjectInputStream(new FileInputStream(DOCTORS_FILE)))
        {
            ArrayList<Doctor> doctors = (ArrayList<Doctor>) dis.readObject();
            for(Doctor doctor : doctors)
            {
                System.out.println(doctor);
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
