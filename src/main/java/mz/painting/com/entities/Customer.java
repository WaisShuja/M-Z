package mz.painting.com.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;


@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

//    @NotNull(message = "{name.not.null}")
//    @Size(min = 1, max = 25, message = "{name.size}")
    private String name;
//    @NotNull(message = "{field.not.empty}")
    private String suburb;
//    @NotNull
    private String email;
    private String phone;
    private String text;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", suburb='" + suburb + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
