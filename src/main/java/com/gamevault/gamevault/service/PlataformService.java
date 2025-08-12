package com.gamevault.gamevault.service;

import com.gamevault.gamevault.dto.PlataformDTO;
import com.gamevault.gamevault.entity.Plataform;
import com.gamevault.gamevault.mapper.PlataformMapper;
import com.gamevault.gamevault.repository.PlataformRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlataformService {
    private final PlataformRepository plataformRepository;
    private final PlataformMapper plataformMapper;

    public PlataformService(PlataformRepository plataformRepository, PlataformMapper plataformMapper) {
        this.plataformMapper = plataformMapper;
        this.plataformRepository = plataformRepository;
    }

    public List<PlataformDTO> getAllPlataforms() {
      List<Plataform> movies = plataformRepository.findAll();
        return movies.stream()
                .map(plataformMapper::map)
                .collect(Collectors.toList());
    }

    public PlataformDTO createPlataform(PlataformDTO plataformDTO) {
        Plataform plataform = plataformMapper.map(plataformDTO);
        Plataform savedPlataform = plataformRepository.save(plataform);
        return plataformMapper.map(savedPlataform);
    }

    public PlataformDTO getPlataformById(Long id){
        Optional<Plataform> plataformOptional = plataformRepository.findById(id);
        return plataformOptional.map(plataformMapper::map).orElse(null);
    }

    public void deletePlataformById(Long id){
         plataformRepository.deleteById(id);
    }
}
