/*package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "winery_user")
public class User {

    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;

    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @DateTimeFormat(pattern="dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime accountCreationDate;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountCreationDate = LocalDateTime.now();
    }


    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }


    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}

 */