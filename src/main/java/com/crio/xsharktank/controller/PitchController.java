package com.crio.xsharktank.controller;

import com.crio.xsharktank.dto.CounterOfferDto;
import com.crio.xsharktank.dto.PitchDto;
import com.crio.xsharktank.entity.Pitch;
import com.crio.xsharktank.service.PitchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pitches")
public class PitchController {

    Logger log = LoggerFactory.getLogger((PitchController.class));

    @Autowired
    private final PitchService pitchService;

    public PitchController(PitchService pitchService) {
        this.pitchService = pitchService;
    }

    @GetMapping
    List<Pitch> getAllPitches() {
        return pitchService.getAllPitch();
    }

    @GetMapping("/{pitchId}")
    ResponseEntity<Pitch> getPitch(@PathVariable(name = "pitchId") String pitchId) {
        Pitch pitch = pitchService.getPitch(pitchId);
        if (pitch == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pitch, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Map<String, String>> addPitch(@Valid @RequestBody PitchDto pitchDto) {
        log.info("PitchDto from request : {}", pitchDto);
        String id = pitchService.addPitch(pitchDto);
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PostMapping("/{pitchId}/makeOffer")
    ResponseEntity<Map<String, String>> makeOffer(@PathVariable String pitchId, @Valid @RequestBody CounterOfferDto offer) {
        if (pitchId.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        String id = pitchService.updatePitch(offer, pitchId);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
