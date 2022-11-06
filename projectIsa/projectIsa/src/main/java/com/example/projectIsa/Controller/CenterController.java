package com.example.projectIsa.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.DTO.CentersDTO;
import com.example.projectIsa.Service.ICenterService;

@RestController
@RequestMapping("/center")
public class CenterController {
	
	private final ICenterService centerService;

    public CenterController(ICenterService centerService) {
    	this.centerService = centerService;
    }
    
    @GetMapping("/getAllCenters")
    public List<CentersDTO> getAllCenters() {
        return centerService.getAllCenters();
    }
    
    @GetMapping("/searchCenters/{search}")
    public ResponseEntity getByUsername(@PathVariable String search) {
        try {
        	return new ResponseEntity(centerService.searchByNameAndAddress(search), HttpStatus.OK);
        } catch (Exception e) {
        	return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(value = "/registerCenter", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerCenter(@RequestBody CentersDTO center) {
        try {
        	System.out.println("stigao sam");
        	return new ResponseEntity(centerService.registerCenter(center), HttpStatus.OK);
        } catch (Exception e) {
        	return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
