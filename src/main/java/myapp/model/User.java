package myapp.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;


public class User {
    @Size(max = 20, min = 3, message = "{user.name.empty}")
    String username;
    
    @Size(max = 20, min = 3, message = "{password.name.empty}")
    String password;

    @Range (min=4)
    int age;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    
    
}
