package com.socialmedia.controller;

import com.socialmedia.dto.CelebrityDTO;
import com.socialmedia.service.CelebService;
import com.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/celebrity")
public class Celebrity {

    @Autowired
    private CelebService celebService;

    @GetMapping("/getallcelebrity")
    public  List<CelebrityDTO> getAllCelebrity(){
        return celebService.getAllCelebrity();
    }

    @GetMapping("/getcelebrity/{id}")
    public CelebrityDTO getCelebrity(@PathVariable int id){
        return celebService.getCelebrity(id);
    }

    @PostMapping("/addcelebrity")
    public CelebrityDTO setCelebrity(@RequestBody CelebrityDTO celebrityDTO){
        return celebService.addCelebrity(celebrityDTO);
    }

    @PutMapping("updatecelebrity")
    public CelebrityDTO updateCelebrity(@RequestBody CelebrityDTO user){
        return celebService.updateCelebrity(user);
    }

    @DeleteMapping("deletecelebrity/{id}")
    public String deleteCelebrity(@PathVariable int id){
        return celebService.deleteCelebrity(id);
    }
}
