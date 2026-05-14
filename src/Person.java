abstract public class Person {
    public String id;
    public String name;
    public int age;

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

}
