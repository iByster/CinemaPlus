package entities;

public class Client extends User {
    private String fidelity;
    private String name;
    private String telNumber;
    private int age;

    public Client(String username, String password, String fidelity, String name, String telNumber, int age) {
        super(username, password);
        this.fidelity = fidelity;
        this.name = name;
        this.telNumber = telNumber;
        this.age = age;
    }

    public String getFidelity() {
        return fidelity;
    }

    public void setFidelity(String fidelity) {
        this.fidelity = fidelity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
