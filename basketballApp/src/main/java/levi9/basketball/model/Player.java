package levi9.basketball.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "Player")
public class Player {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;
	
	@Column (name = "team")
    private String team;

	@Column(name = "leag")
	private String leag;

	@Column(name = "pos1")
	private String pos1;
	
	@Column(name = "pos2")
	private String pos2;
	
	@Column(name = "pos3")
	private String pos3;

	@Column(name = "year")
	private String year;

	@Column (name = "stats_id")
	private Long stats;

	
	
	
	public Player() {
	}

	
	public Player(Player play) {
		this.id = play.id;
		this.firstname = play.firstname;
		this.lastname = play.lastname;
		this.team = play.team;
		this.leag = play.leag;
		this.pos1 = play.pos1;
		this.pos2 = play.pos2;
		this.pos3 = play.pos3;
		this.year = play.year;
		this.stats = play.stats;
	}

	public Long getStats() {
		return stats;
	}

	public void setStats(Long stats) {
		this.stats = stats;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getLeag() {
		return leag;
	}

	public void setLeag(String leag) {
		this.leag = leag;
	}

	public String getPos1() {
		return pos1;
	}

	public void setPos1(String pos1) {
		this.pos1 = pos1;
	}

	public String getPos2() {
		return pos2;
	}

	public void setPos2(String pos2) {
		this.pos2 = pos2;
	}

	public String getPos3() {
		return pos3;
	}

	public void setPos3(String pos3) {
		this.pos3 = pos3;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}


}