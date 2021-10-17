package com.lenscartapp.model;
/**
 * @author SumanD
 *
 */
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
	@Id
	@GeneratedValue(generator = "brand_gene", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "brand_gene", sequenceName = "brand_seq", allocationSize = 1, initialValue = 1)
	private Integer brandId;
	@Column(length = 30)
	private String shape;
	@Column(length = 30)
	private String type;
	@Column(length = 30)
	private String brandName;
	private Double price;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "brand")
	
	//@JoinColumn(name="brand_id")
	@JsonIgnore
	private Set<Frame> frameList;
	public Brand(String shape, String type, String brandName, Double price) {
		super();
		this.shape = shape;
		this.type = type;
		this.brandName = brandName;
		this.price = price;
	}
	
	
//	public Brand(String shape, String type, String brandName, Double price, Set<Frame> frameList) {
//		super();
//		this.shape = shape;
//		this.type = type;
//		this.brandName = brandName;
//		this.price = price;
//		this.frameList = frameList;
//	}
	

	
	




	

}
