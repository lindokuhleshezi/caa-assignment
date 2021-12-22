package com.caa.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="task")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String name;
	private String description;
	private Date date_time; 
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,targetEntity = User.class)
	@JoinTable(name = "user_tasks")
	private Set<User> user;
}
