package com.gamevault.gamevault.controller;

import com.gamevault.gamevault.dto.PlataformDTO;
import com.gamevault.gamevault.service.PlataformService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamevault/plataform")
public class PlataformController {
    private final PlataformService plataformService;

    public PlataformController(PlataformService plataformService) {
        this.plataformService = plataformService;
    }


    @GetMapping
    public ResponseEntity<List<PlataformDTO>> getAllPlataforms() {
        List<PlataformDTO> plataforms = plataformService.getAllPlataforms();
        return ResponseEntity.status(HttpStatus.FOUND).body(plataforms);
    }

    @PostMapping
    public ResponseEntity<PlataformDTO> createPlataform(@RequestBody PlataformDTO plataformDTO){
        PlataformDTO createdPlataform = plataformService.createPlataform(plataformDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlataform);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlataformDTO> getPlataformById(@PathVariable Long id) {
        if (plataformService.getPlataformById(id) != null){
            PlataformDTO plataform = plataformService.getPlataformById(id);
            return ResponseEntity.ok(plataform);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlataformById(@PathVariable Long id){
        if(plataformService.getPlataformById(id) != null){
            plataformService.deletePlataformById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlataformById(@PathVariable Long id, @RequestBody PlataformDTO plataformDTO){
        if(plataformService.getPlataformById(id) != null){
            PlataformDTO updatedPlataform = plataformService.createPlataform(plataformDTO);
            return ResponseEntity.ok(updatedPlataform);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
