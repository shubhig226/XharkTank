package com.crio.xsharktank.converter;

import com.crio.xsharktank.dto.CounterOfferDto;
import com.crio.xsharktank.entity.CounterOffer;

public class CounterOfferDtoToEntityConverter {

    public static CounterOffer convert(CounterOfferDto dto){
        CounterOffer entity = new CounterOffer();
        entity.setInvestor(dto.getInvestor());
        entity.setAmount(dto.getAmount());
        entity.setEquity(dto.getEquity());
        entity.setComment(dto.getComment());
        return entity;
    }
}
