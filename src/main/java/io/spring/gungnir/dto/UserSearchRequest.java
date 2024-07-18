package io.spring.gungnir.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserSearchRequest implements Serializable{

	private String id;
	private String name;
	private String symphogear_name;

}
