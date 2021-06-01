package entities;


import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Clients")
public class Client extends User {


    @Column(name = "fidelity", nullable = false)
    private int fidelity;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "telNumber", nullable = false)
    private String telNumber;

    @Column(name = "age", nullable = false)
    private int age;

    public Client(){}

    public Client(String username){
        this.setUsername(username);
    }

//    public Client(String username, String password, String fidelity, String name, String telNumber, int age) {
//        super(username, password);
//        this.fidelity = fidelity;
//        this.name = name;
//        this.telNumber = telNumber;
//        this.age = age;
//    }


    public Client(String username, String password, int fidelity, String name, String telNumber, int age) {
        super(username, password);
        this.fidelity = fidelity;
        this.name = name;
        this.telNumber = telNumber;
        this.age = age;
    }

//    @Column(name = "fidelity")
    public int getFidelity() {
        return fidelity;
    }

    public void setFidelity(int fidelity) {
        this.fidelity = fidelity;
    }

//    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Column(name = "nrTel")
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

//    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Client{" +
                "username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", fidelity=" + fidelity +
                ", name='" + name + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
