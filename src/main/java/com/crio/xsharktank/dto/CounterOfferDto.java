package com.crio.xsharktank.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
public class CounterOfferDto {

    @JsonIgnore
    int id;

    @NotNull
    String investor;

    @NotNull
    int amount;

    @NotNull
    @Max(value = 100, message = "Percentage cannot be more than 100")
    float equity;

    @NotNull
    String comment;
}
