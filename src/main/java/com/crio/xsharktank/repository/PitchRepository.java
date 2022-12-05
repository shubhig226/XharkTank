package com.crio.xsharktank.repository;

import com.crio.xsharktank.entity.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitchRepository extends JpaRepository<Pitch, String> {

}
