import java.io.Serializable;

abstract public class Person implements Serializable {
    private String id;
    private String name;
    private int age;

    Person(){
        id = "0";
        name = null;
        age = 0;
    }

    Person(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void display(){
        System.out.println("Id: "+this.getId());
        System.out.println("Name: "+this.getName());
        System.out.println("Age: "+this.getAge());
    }

}
