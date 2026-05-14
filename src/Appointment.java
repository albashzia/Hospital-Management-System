import javax.print.Doc;
import java.util.Date;

public class Appointment {
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

    public String toString(){
        return "Doctor: "+this.doctor.getName() +
                ", Patient: "+this.patient.getName()+
                ", Appointment Date: "+this.date;
    }
}
