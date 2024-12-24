package com.socialmedia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Set;

@Entity
@Data
@Table(name = "celebrity")

public class Celebrity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "celeb_id")
    private int celeb_id;

    @Column(name = "celeb_name")
    private String celeb_name;

    @Column(name = "celeb_followers")
    private long celeb_followers;

    @Column(name = "address")
    private String address;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @Column(nullable = false)
//    @JsonManagedReference
//    private Set<PlatformEntity> platforms ;
//
//    public Celebrity() {
//    }

    public Celebrity(int celeb_id, String celeb_name, long celeb_followers, String address) {
        this.celeb_id = celeb_id;
        this.celeb_name = celeb_name;
        this.celeb_followers = celeb_followers;
        this.address = address;
//        this.platforms = platforms;
    }

    public int getCeleb_id() {
        return celeb_id;
    }

    public void setCeleb_id(int celeb_id) {
        this.celeb_id = celeb_id;
    }

    public String getCeleb_name() {
        return celeb_name;
    }

    public void setCeleb_name(String celeb_name) {
        this.celeb_name = celeb_name;
    }

    public long getCeleb_followers() {
        return celeb_followers;
    }

    public void setCeleb_followers(long celeb_followers) {
        this.celeb_followers = celeb_followers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public Set<PlatformEntity> getPlatforms() {
//        return platforms;
//    }
//
//    public void setPlatforms(Set<PlatformEntity> platforms) {
//        this.platforms = platforms;
//    }
}
