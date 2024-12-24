package com.socialmedia.service;

import com.socialmedia.dto.UserDTO;
import com.socialmedia.entity.Celebrity;
import com.socialmedia.entity.PlatformEntity;
import com.socialmedia.entity.User;
import com.socialmedia.exception.CelebrityNotFoundException;
import com.socialmedia.exception.PlatformNotFoundException;
import com.socialmedia.exception.ResourceNotFoundException;
import com.socialmedia.exception.UserNotFoundException;
import com.socialmedia.repository.CelebRepository;
import com.socialmedia.repository.PlatformRepo;
import com.socialmedia.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlatformRepo platformRepo;

    @Autowired
    private CelebRepository celebRepository;

    @Autowired
    private ModelMapper mapper;

    //get
    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream()
                .map(user -> mapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO getUser(int id) {

        return userRepository.findById(id)
                .map(user -> mapper.map(user, UserDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("Resource not Found of id " + id));
    }


    public UserDTO addUser(UserDTO userDTO) {
        User userEntity = mapper.map(userDTO, User.class);

        Set<PlatformEntity> addPlatform = new HashSet<>();

        for (PlatformEntity p : userEntity.getPlatforms()) {
            Optional<PlatformEntity> platformExist = platformRepo.findByPlatformName(p.getPlatformName());
            if (platformExist.isPresent()) {
                addPlatform.add(platformExist.get());
            } else {
                addPlatform.add(p);
            }
        }
        userEntity.setPlatforms(addPlatform);

        User savedUser = userRepository.save(userEntity);

        return mapper.map(savedUser, UserDTO.class);

    }


    //post follow
    public String followCeleb(int userId, int celebId, String platform) {


        Optional<User> user = userRepository.findById(userId);
        Optional<Celebrity> celebrity = celebRepository.findById(celebId);


        if (!user.isPresent()) {
            throw new UserNotFoundException("User Not Found: " + userId);
        }


        if (!celebrity.isPresent()) {
            throw new CelebrityNotFoundException("Celebrity Not Found: " + celebId);
        }

//        if (platform.equalsIgnoreCase(user.get().getPlatforms().toString())) {
//            throw new PlatformNotFoundException("Platform Not Found "+user);
//        }
//
//        if (platform.equalsIgnoreCase(celebrity.get().getPlatforms().toString())) {
//            throw new PlatformNotFoundException("Platform Not Found "+celebrity);
//        }


        Celebrity celeb = celebrity.get();
        celeb.setCeleb_followers(celeb.getCeleb_followers() + 1);

        celebRepository.save(celeb);

        return "User " + userId + " successfully followed Celebrity " + celebId + " on platform " + platform;
    }




    //put
    public UserDTO updatedUser(UserDTO user){
        Optional<User> user1=userRepository.findById(user.getUser_id());
        if(user1.isPresent()){
            User optionalUser=user1.get();
            optionalUser.setUser_name(user.getUser_name());
            optionalUser.setUser_address(user.getUser_address());
            userRepository.save(optionalUser);
            return user;
        }else {
            return null;
        }
    }

    //delete

    public String deleteUser(int id){

        if(userRepository.findById(id)!=null){
            userRepository.deleteById(id);
            return "User is Successfully Deleted";
        }
        else {
            return "User not found";
        }

//       Optional<User> deletedUser= userRepository.findById(user.getUser_id());
//       if(deletedUser.isPresent()){
//           userRepository.delete(deletedUser.get());
//           return "User is Successfully Deleted";
//       }
//       else {
//           return "User is not found";
//       }
    }


}
