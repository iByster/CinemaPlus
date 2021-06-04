package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Admins")
public class Admin extends User {
    @Column(name = "admin-mode", nullable = false)
    private String adminMode;

    public Admin(){}


    public Admin(String username){
        this.setUsername(username);
    }


    public Admin(String username, String password, String adminMode) {
        super(username, password);
        this.adminMode = adminMode;
    }

    public String getAdminMode() {
        return adminMode;
    }

    public void setAdminMode(String adminMode) {
        this.adminMode = adminMode;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username=" + getUsername() + '\'' +
                "username=" + getPassword() + '\'' +
                "adminMode='" + adminMode + '\'' +
                '}';
    }
}
