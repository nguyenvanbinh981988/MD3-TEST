package Model;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate birthDay;
    private String address;
    private String phone;
    private String email;
    private ClassSt classSt;

    public Student(String name, LocalDate birthDay, String address, String phone, String email, ClassSt classSt) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classSt = classSt;
    }

    public Student(int id,String name, LocalDate birthDay, String address, String phone, String email, ClassSt classSt) {
        this.id= id;
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.classSt = classSt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClassSt getClassSt() {
        return classSt;
    }

    public void setClassSt(ClassSt classroom) {
        this.classSt = classSt;
    }
}
