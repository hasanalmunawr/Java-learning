package hasanalmuDev.Belajarjavareflection;

import hasanalmuDev.Belajarjavareflection.Annotations.NotBlank;

import java.util.HashMap;
import java.util.List;

public class Person implements NameAble {

    @NotBlank
    private String firstName;
    @NotBlank(allowEmpetyString = true)
    private String lastName;
    private int age;

    private List<String> hobbies;
    private HashMap<Integer, String> size;

    public Person() {
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public HashMap<Integer, String> getSize() {
        return size;
    }

    public void setSize(HashMap<Integer, String> size) {
        this.size = size;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }


}
