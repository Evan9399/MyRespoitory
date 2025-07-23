package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//建立建構式、自動帶入所有參數
@NoArgsConstructor//建立建構式、不帶入參數 ()
@EqualsAndHashCode //比較物件內的內容是否相同
public class User {
	@Exclude//
	private Long id;
	
	private String name;
	
}