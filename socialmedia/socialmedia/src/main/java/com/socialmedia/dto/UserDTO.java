package com.socialmedia.dto;

import com.socialmedia.entity.PlatformEntity;

import java.util.List;

public class UserDTO {

    private int user_id;

    private String user_name;

    private String user_address;

    private List<PlatformEntity> platforms;  // Changed to PlatformEntity

    public UserDTO() {
    }

    public UserDTO(int user_id, String user_name, String user_address, List<PlatformEntity> platforms) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_address = user_address;
        this.platforms = platforms;
    }

    // Getters and setters
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

    public List<PlatformEntity> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<PlatformEntity> platforms) {
        this.platforms = platforms;
    }
}
