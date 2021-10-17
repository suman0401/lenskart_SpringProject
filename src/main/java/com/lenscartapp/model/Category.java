package com.lenscartapp.model;
/**
 * @author SumanD
 *
 */
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Category {
	@Id
	@GeneratedValue(generator = "category_gene", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "category_gene", sequenceName = "category_seq", allocationSize = 1, initialValue = 1)
	private Integer categoryId;
	@Column(length = 30)
	private String categoryName;
	@Column(length = 30)
	private String material;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "categoryList")
	@JsonIgnore
	private Set<Frame> frameList;
   
	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", material=" + material + "]";
	}

	public Category(String categoryName, String material) {
		super();
		this.categoryName = categoryName;
		this.material = material;
	}

}
