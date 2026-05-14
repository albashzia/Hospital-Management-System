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
}
