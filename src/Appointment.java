import java.io.*;
import java.util.ArrayList;
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

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Appointment other = (Appointment) obj;

        return doctor.equals(other.doctor) &&
                patient.equals(other.patient) &&
                date.equals(other.date);
    }

    public void saveAppointment(Appointment appointment)
    {
        final String APPOINTMENTS_FILE = "appointments.ser";
        ArrayList<Appointment> appointments = new ArrayList<>();
        try(ObjectInputStream ais = new ObjectInputStream(new FileInputStream(APPOINTMENTS_FILE)))
        {
            appointments = (ArrayList<Appointment>) ais.readObject();
        }
        catch (FileNotFoundException e)
        {
            // first time file doesn't exist
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        appointments.add(appointment);
        try(ObjectOutputStream aos = new ObjectOutputStream(new FileOutputStream(APPOINTMENTS_FILE)))
        {
            aos.writeObject(appointments);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void readAppointment(){

        final String APPOINTMENTS_FILE = "appointments.ser";

        try(ObjectInputStream ais = new ObjectInputStream(new FileInputStream(APPOINTMENTS_FILE)))
        {
            ArrayList<Appointment> appointments = (ArrayList<Appointment>) ais.readObject();
            for(Appointment appointment : appointments)
            {
                System.out.println(appointment);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAppointment(Appointment appointment){
        final String APPOINTMENTS_FILE = "appointments.ser";

        ArrayList<Appointment> appointments = new ArrayList<>();
        try(ObjectInputStream ais = new ObjectInputStream(new FileInputStream(APPOINTMENTS_FILE)))
        {
            appointments = (ArrayList<Appointment>) ais.readObject();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        appointments.remove(appointment);
        try(ObjectOutputStream aos = new ObjectOutputStream(new FileOutputStream(APPOINTMENTS_FILE)))
        {
            aos.writeObject(appointments);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void updateAppointment(Appointment oldAppointment, Date newDate)
    {
        final String APPOINTMENTS_FILE = "appointments.ser";
        ArrayList<Appointment> appointments = new ArrayList<>();

        try(ObjectInputStream ais = new ObjectInputStream(new FileInputStream(APPOINTMENTS_FILE)))
        {
            appointments = (ArrayList<Appointment>) ais.readObject();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        for(Appointment appt : appointments)
        {
            if(appt.equals(oldAppointment))
            {
                appt.setDate(newDate);
            }
        }
        try(ObjectOutputStream aos = new ObjectOutputStream(new FileOutputStream(APPOINTMENTS_FILE)))
        {
            aos.writeObject(appointments);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
