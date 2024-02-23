package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.constraint.CheckCase;
import hasanalmudev.belajarjavavalidation1.enums.CaseMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {

    private List<@NotBlank(message = "hobbies can not blank") String> hobbies;
    @NotBlank(message = "{person.firstname.notblank}")
    @CheckCase(mode = CaseMode.LOWER,message = "firstName must be lower")
    @Size(max = 20,
            message = "{person.firstname.size}")
    private String firstName;

    @NotBlank(message = "{person.lastname.notblank}")
    @CheckCase(mode = CaseMode.LOWER,message = "lastName must be lower")
    @Size(max = 20,
            message = "{person.lastname.notblank}")
    private String lastName;

    @NotNull(message = "{person.addres.notnull}")
    @Valid // nested validation
    private Address address;

    @Valid
    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Valid
    public Person(@NotBlank(message = "{person.firstname.notblank}") String firstName,
                  @NotBlank(message = "{person.lastname.notblank}") String lastName,
                  @NotNull(message = "{person.addres.notnull}") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }

    public void sayHello(@NotBlank(message = "name can not blank") String name) {
        System.out.println("hello " + name + " my name is " + firstName);
    }

    @NotBlank(message = "fullName can not blank")
    public String fullName() {
        return firstName + " " + lastName;
    }
}
