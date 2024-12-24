package com.socialmedia.service;

import com.socialmedia.dto.CelebrityDTO;
import com.socialmedia.entity.Celebrity;
import com.socialmedia.exception.CelebrityNotFoundException;
import com.socialmedia.repository.CelebRepository;
import com.socialmedia.repository.PlatformRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CelebService {

@Autowired
private CelebRepository celebRepository;

@Autowired
private ModelMapper mapper;

@Autowired
private PlatformRepo platformRepo;

//get
    public List<CelebrityDTO> getAllCelebrity(){
        return celebRepository.findAll().stream().map(celebrity->mapper.map(celebrity, CelebrityDTO.class)).collect(Collectors.toList());
    }

    public CelebrityDTO getCelebrity(int id) {
        return celebRepository.findById(id)
                .map(celebrity -> mapper.map(celebrity, CelebrityDTO.class))
                .orElseThrow(() -> new CelebrityNotFoundException("Celebrity not found with id: " + id));
    }


public CelebrityDTO addCelebrity(CelebrityDTO celebrityDTO) {


        Celebrity celebrityEntity = mapper.map(celebrityDTO, Celebrity.class);


        Celebrity savedCelebrity = celebRepository.save(celebrityEntity);

        return mapper.map(savedCelebrity, CelebrityDTO.class);

    }


//put

public  CelebrityDTO updateCelebrity(CelebrityDTO updatedCelebrity){

        Optional<Celebrity> existingCelebrity= celebRepository.findById(updatedCelebrity.getCeleb_id());

        if(existingCelebrity.isPresent()){
            Celebrity celebrity=existingCelebrity.get();
            celebrity.setAddress(updatedCelebrity.getAddress());
            celebrity.setCeleb_name(updatedCelebrity.getCeleb_name());
            celebrity.setCeleb_followers(updatedCelebrity.getCeleb_followers());

            celebRepository.save(celebrity);

            return mapper.map(celebrity,CelebrityDTO.class);
        }
        else {
            return null;
        }

    }

//delete
public String deleteCelebrity(int id) {

        if(celebRepository.findById(id)!=null){
            celebRepository.deleteById(id);
            return "Celebrity is successfully deleted";
        }
        else {
            return "Celebrity not found";
        }


//        Optional<Celebrity> existCeleb = celebRepository.findById(celebrityDTO.getCeleb_id());
//        if (existCeleb.isPresent()) {
//            celebRepository.delete(existCeleb.get());
//            return "Celebrity deleted successfully";
//        } else {
//            return "Celebrity doesn't exist";
//        }
    }




}
