package com.crio.xsharktank.service;

import com.crio.xsharktank.dto.CounterOfferDto;
import com.crio.xsharktank.dto.PitchDto;
import com.crio.xsharktank.entity.Pitch;

import java.util.List;

public interface PitchService {
    String addPitch(PitchDto pitchDto);

    String updatePitch(CounterOfferDto offer, String id);

    List<Pitch> getAllPitch();

    Pitch getPitch(String id);
}
