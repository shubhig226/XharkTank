package com.crio.xsharktank.service;

import com.crio.xsharktank.converter.CounterOfferDtoToEntityConverter;
import com.crio.xsharktank.converter.PitchDtoToEntityConverter;
import com.crio.xsharktank.dto.CounterOfferDto;
import com.crio.xsharktank.dto.PitchDto;
import com.crio.xsharktank.entity.CounterOffer;
import com.crio.xsharktank.entity.Pitch;
import com.crio.xsharktank.repository.PitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PitchServiceImpl implements PitchService {

    @Autowired
    private PitchRepository repository;

    public PitchServiceImpl(PitchRepository repository) {
        this.repository = repository;
    }

    @Override
    public String addPitch(PitchDto dto) {
        Pitch entity = PitchDtoToEntityConverter.convert(dto);

        Pitch savedPitch = repository.save(entity);

        return savedPitch.getId();
    }

    @Override
    public String updatePitch(CounterOfferDto offer, String id) {
        CounterOffer counterOffer = CounterOfferDtoToEntityConverter.convert(offer);

        Pitch pitch = repository.findById(id).orElse(null);
        if (Objects.isNull(pitch)) {
            return null;
        }
        counterOffer.setPitch(pitch);
        pitch.getOffers().add(counterOffer);
        pitch = repository.save(pitch);
        List<CounterOffer> offers = pitch.getOffers();
        return offers.get(offers.size() - 1).getId();
    }

    @Override
    public List<Pitch> getAllPitch() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "addedOn"));
    }

    @Override
    public Pitch getPitch(String id) {
        return repository.findById(id).orElse(null);
    }
}
