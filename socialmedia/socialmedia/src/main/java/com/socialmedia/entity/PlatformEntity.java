package com.socialmedia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "platform")
public class PlatformEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int platform_id;

    @Column(nullable = false)
    private String platformName;

    @ManyToMany(mappedBy = "platforms")
    @JsonBackReference
    @JsonIgnore
    private Set<User> userList;


//    @ManyToMany(mappedBy = "platforms")
//    @JsonBackReference
//    @JsonIgnore
//    private Set<Celebrity> celebrityList;
    


    public PlatformEntity(int platform_id, String platformName, Set<User> userList) {
        this.platform_id = platform_id;
        this.platformName = platformName;
        this.userList = userList;
//        this.celebrityList = celebrityList;
    }

    public int getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(int platform_id) {
        this.platform_id = platform_id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

//    public Set<Celebrity> getCelebrityList() {
//        return celebrityList;
//    }
//
//    public void setCelebrityList(Set<Celebrity> celebrityList) {
//        this.celebrityList = celebrityList;
//    }
}
