package com.lenscartapp.model;
/**
 * @author SumanD
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lens {
	@Id
	@GeneratedValue(generator = "lens_gene", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "lens_gene", sequenceName = "lens_seq", allocationSize = 1, initialValue = 1)
	private Integer lensId;
	private String lensBrand;
	private String lensPower;
	@OneToOne(mappedBy = "lens")
	@JsonIgnore
	private Frame frame;

	public Lens(String lensBrand, String lensPower) {
		super();
		this.lensBrand = lensBrand;
		this.lensPower = lensPower;
	}

	@Override
	public String toString() {
		return "Lens [lensBrand=" + lensBrand + ", lensPower=" + lensPower + "]";
	}

}
