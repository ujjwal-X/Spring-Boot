package com.socialmedia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String user_address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<PlatformEntity> platforms;

    public User() {
    }

    public User(int user_id, String user_name, String user_address, Set<PlatformEntity> platforms) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_address = user_address;
        this.platforms = platforms;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public Set<PlatformEntity> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<PlatformEntity> platforms) {
        this.platforms = platforms;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_address='" + user_address + '\'' +
                ", platforms=" + platforms +
                '}';
    }
}
