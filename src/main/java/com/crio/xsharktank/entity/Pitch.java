package com.crio.xsharktank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Data
@Table(name = "Pitch")
public class Pitch extends AbstractEntity {


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntrepreneur() {
		return entrepreneur;
	}

	public void setEntrepreneur(String entrepreneur) {
		this.entrepreneur = entrepreneur;
	}

	public String getPitchTitle() {
		return pitchTitle;
	}

	public void setPitchTitle(String pitchTitle) {
		this.pitchTitle = pitchTitle;
	}

	public String getPitchIdea() {
		return pitchIdea;
	}

	public void setPitchIdea(String pitchIdea) {
		this.pitchIdea = pitchIdea;
	}

	public int getAskAmount() {
		return askAmount;
	}

	public void setAskAmount(int askAmount) {
		this.askAmount = askAmount;
	}

	public float getEquity() {
		return equity;
	}

	public void setEquity(float equity) {
		this.equity = equity;
	}

	public List<CounterOffer> getOffers() {
		return offers;
	}

	public void setOffers(List<CounterOffer> offers) {
		this.offers = offers;
	}

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column
    private String id;

    @Column
    private String entrepreneur;

    @Column
    private String pitchTitle;

    @Column
    private String pitchIdea;

    @Column
    private int askAmount;

    @Column
    private float equity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pitch", fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<CounterOffer> offers = new ArrayList<>();

}
