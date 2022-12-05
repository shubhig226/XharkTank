package com.crio.xsharktank.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import java.util.List;

@Data
public class PitchDto {

    @JsonIgnore
    int id;

    @NotNull
    String entrepreneur;

    @NotNull
    String pitchTitle;

    @NotNull
    String pitchIdea;

    @NotNull
    int askAmount;

    @NotNull @Max(value = 100, message = "Percentage cannot be more than 100")
    float equity;

    @JsonIgnore
    List<CounterOfferDto> offers;
}
