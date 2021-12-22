package com.caa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String first_name;
	private String last_name;
	private String username;
	
}
