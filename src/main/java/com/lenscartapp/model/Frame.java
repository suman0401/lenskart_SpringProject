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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Frame {
	@Id
	@GeneratedValue(generator = "frame_gene", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "frame_gene", sequenceName = "frame_seq", allocationSize = 1, initialValue = 1)
	private Integer frameId;
	private Integer modelId;
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String framesize;
	@Column(length = 30)
	private String color;
	@Column(length = 30)
	private String gender;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lens_id")
	
	Lens lens;
	@ManyToOne(cascade = CascadeType.ALL)

	@JoinColumn(name = "brand_id")
	
	private Brand brand;
	@ManyToMany(fetch = FetchType.EAGER)

	@JoinTable(name = "frame_category", joinColumns = { @JoinColumn(name = "frame_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	@JsonIgnore
	private Set<Category> categoryList;

	public Frame(Integer modelId, String name, String framesize, String color, String gender, Lens lens, Brand brand,
			Set<Category> categoryList) {
		super();
		this.modelId = modelId;
		this.name = name;
		this.framesize = framesize;
		this.color = color;
		this.gender = gender;
		this.lens = lens;
		this.brand = brand;
		this.categoryList = categoryList;
	}

//FOR ONE TO ONE AND MANY TO ONE
//	public Frame(Integer modelId, String name, String framesize, String color, String gender) {
//		super();
//		this.modelId = modelId;
//		this.name = name;
//		this.framesize = framesize;
//		this.color = color;
//		this.gender = gender;
//
//	}

//FOR ALL RELATIONSHIP

}
