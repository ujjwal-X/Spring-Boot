package com.socialmedia.dto;

import com.socialmedia.entity.PlatformEntity;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Data
@Getter
public class CelebrityDTO {

    private int celeb_id;

//    @Column(nullable = false,unique = true)
    private String celeb_name;

//    @Column(nullable = false)
    private long celeb_followers;

//    @Column(nullable = false)
    private String address;

//    @Column(nullable = false)
//    private Set<PlatformEntity> platforms ;

//    public CelebrityDTO() {
//    }

    public CelebrityDTO(int celeb_id, String celeb_name, long celeb_followers, String address) {
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
