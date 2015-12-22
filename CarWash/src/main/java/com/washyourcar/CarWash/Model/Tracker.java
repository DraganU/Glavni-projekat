package com.washyourcar.CarWash.Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tblRecord")
public class Tracker {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;

	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name = "wash_id")
	private Wash wash;

	@Column(name = "date",  nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date date;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Wash getWash() {
		return wash;
	}

	public void setWash(Wash wash) {
		this.wash = wash;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
