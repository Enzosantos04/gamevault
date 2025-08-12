package com.gamevault.gamevault.mapper;

import com.gamevault.gamevault.dto.PlataformDTO;
import com.gamevault.gamevault.entity.Plataform;
import org.springframework.stereotype.Component;

@Component
public class PlataformMapper {

    public Plataform map(PlataformDTO dto){
        Plataform plataform = new Plataform();
        plataform.setId(plataform.getId());
        plataform.setName(plataform.getName());
        return plataform;
    }

    public PlataformDTO map(Plataform plataform){
        PlataformDTO dto = new PlataformDTO(plataform.getName(), plataform.getId());
        dto.setId(plataform.getId());
        dto.setName(plataform.getName());
        return dto;
    }
}
