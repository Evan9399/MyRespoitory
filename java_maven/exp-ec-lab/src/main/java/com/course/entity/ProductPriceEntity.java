package com.course.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="PRODUCT_PRICE")
@Data
public class ProductPriceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="PRICE_SEQ_GEN")
	@SequenceGenerator(name="PRICE_SEQ_GEN" ,sequenceName = "PRICE_SEQ",allocationSize = 1)
	private long id;
	
	@Column
	private BigDecimal listPrice;//跟錢有關的都用BigDecimal
	
	@Column
	private BigDecimal salesPrice;
	
//	@Column
//	private Long productId;
	
    @OneToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private ProductEntity product;
	
}
