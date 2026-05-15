import java.io.*;
import java.util.Date;

public class Appointment implements Serializable{
    private Doctor doctor;
    private Patient patient;
    private Date date;

    Appointment(){
        this.doctor = null;
        this.patient = null;
        this.date = null;
    }

    Appointment(Doctor doctor, Patient patient, Date date){
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Patient getPatient(){
        return this.patient;
    }

    public Doctor getDoctor(){
        return this.doctor;
    }

    public Date getDate(){
        return this.date;
    }

    public void display(){
        System.out.println("===Appointment Details===\n");
        System.out.println("\n---Doctor Details---");
        System.out.println(doctor.toString());
        System.out.println("\n---Patient Details---");
        System.out.println(patient.toString());
        System.out.println("\n---Appointment Date---");
        System.out.println(date.toString());
    }

    public String toString(){
        return "Doctor: "+this.doctor.getName() +
                ", Patient: "+this.patient.getName()+
                ", Appointment Date: "+this.date;
    }

    public void saveAppointment(Appointment appointment){
        final String APPOINTMENTS_FILE = "appointments.ser";
        try {
            ObjectOutputStream aos = new ObjectOutputStream(new FileOutputStream(APPOINTMENTS_FILE));
            aos.writeObject(appointment);
        }
        catch (Exception e){
            e.getCause();
        }
    }
}
