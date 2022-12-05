package com.crio.xsharktank.converter;

import com.crio.xsharktank.dto.PitchDto;
import com.crio.xsharktank.entity.Pitch;

public class PitchDtoToEntityConverter {

    public static Pitch convert(PitchDto dto){
        Pitch entity = new Pitch();
        entity.setEntrepreneur(dto.getEntrepreneur());
        entity.setPitchTitle(dto.getPitchTitle());
        entity.setPitchIdea(dto.getPitchIdea());
        entity.setAskAmount(dto.getAskAmount());
        entity.setEquity(dto.getEquity());
        return entity;
    }
}