public class Doctor extends Person{
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
}
