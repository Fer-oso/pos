package entitys;

import interfaces.entity.client.IClient;

public class Client implements IClient<Client, Integer>{

    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private Integer ssn;
    private boolean availability;
    private String phoneNumber;
    private static Integer countId = 0;

    public Client() {
        countId++;
        this.id = countId;
    }

    public Client(String name, String lastName, Integer age, Integer ssn, boolean availability, String phoneNumber) {
        countId++;
        this.id = countId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.ssn = ssn;
        this.availability = availability;
        this.phoneNumber = phoneNumber;
    }

    public static Integer getCountId() {
        return countId;
    }

    public static void setCountId(Integer aCountId) {
        countId = aCountId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", ssn=" + ssn + ", availability=" + availability + ", phoneNumber=" + phoneNumber + '}';
    }

}
