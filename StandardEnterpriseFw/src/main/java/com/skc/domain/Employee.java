package com.skc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="emp")
@NamedQuery(name="Employee.findAllByName",
			query="from Employee e where e.name=:name")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empId")
	private Long id;
	
	@Column(name="ename")
	private String name;
	
	@Column(name="sal")
	private Long salery;
	
	@ManyToOne(targetEntity=Departnment.class)
	@JoinColumn(name="dept_id",referencedColumnName="id")
	private Departnment departnment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSalery() {
		return salery;
	}
	public void setSalery(Long salery) {
		this.salery = salery;
	}
	public Departnment getDepartnment() {
		return departnment;
	}
	public void setDepartnment(Departnment departnment) {
		this.departnment = departnment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((departnment == null) ? 0 : departnment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salery == null) ? 0 : salery.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (departnment == null) {
			if (other.departnment != null)
				return false;
		} else if (!departnment.equals(other.departnment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salery == null) {
			if (other.salery != null)
				return false;
		} else if (!salery.equals(other.salery))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salery=" + salery
				+ ", departnment=" + departnment + "]";
	}
	
	
}
