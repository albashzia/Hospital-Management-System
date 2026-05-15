import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Patient p1 = new Patient("P01", "Ali", 25, "Fever");
        Patient p2 = new Patient("P02", "Ahmed", 30, "Flu");

        Doctor d1 = new Doctor("D01", "Dr. Noman", 45, "Cardiologist");

        p1.savePatient(p1);
        p2.savePatient(p2);

        d1.saveDoctor(d1);

        Date today = new Date();

        Appointment a1 = new Appointment(d1, p1, today);

        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DATE, 1);

        Appointment a2 = new Appointment(d1, p2, cal.getTime());


        a1.saveAppointment(a1);
        a2.saveAppointment(a2);

        final String FILE = "appointments.ser";
        ArrayList<Appointment> appointments = new ArrayList<>();

        try (ObjectInputStream ais =
                     new ObjectInputStream(new FileInputStream(FILE))) {

            appointments = (ArrayList<Appointment>) ais.readObject();

        } catch (Exception e) {
            System.out.println("Error reading appointments: " + e.getMessage());
        }


        System.out.println("\n=== TODAY'S APPOINTMENTS ===");

        Date currentDate = new Date();

        for (Appointment appt : appointments) {

            if (appt.getDate().getDate() == currentDate.getDate()
                    && appt.getDate().getMonth() == currentDate.getMonth()
                    && appt.getDate().getYear() == currentDate.getYear()) {

                System.out.println(appt);
            }
        }


        for (Appointment appt : appointments) {

            Date apptDate = appt.getDate();

            Calendar c = Calendar.getInstance();
            c.setTime(apptDate);
            c.add(Calendar.DATE, 1);

            appt.setDate(c.getTime());
        }

        try (ObjectOutputStream aos =
                     new ObjectOutputStream(new FileOutputStream(FILE))) {

            aos.writeObject(appointments);

        } catch (Exception e) {
            System.out.println("Error saving updated appointments: " + e.getMessage());
        }


        System.out.println("\n=== UPDATED APPOINTMENTS ===");

        for (Appointment appt : appointments) {
            System.out.println(appt);
        }
    }
}
