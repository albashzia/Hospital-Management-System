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

}
