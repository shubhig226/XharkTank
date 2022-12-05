package com.crio.xsharktank.repository;

import com.crio.xsharktank.entity.CounterOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterOfferRepository extends JpaRepository<CounterOffer, Integer> {

}
