package levi9.basketball.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DreamTeam")
public class DreamTeam {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "team_name")
	private String name;
	
	@Column(name = "pl1")
	private String player1;
	
	@Column(name = "pl2")
	private String player2;
	
	@Column(name = "pl3")
	private String player3;
	
	@Column(name = "pl4")
	private String player4;
	
	@Column(name = "pl5")
	private String player5;

	public DreamTeam() {
	}

	public DreamTeam(DreamTeam dt) {
		this.id = dt.id;
		this.name = dt.name;
		this.player1 = dt.player1;
		this.player2 = dt.player2;
		this.player3 = dt.player3;
		this.player4 = dt.player4;
		this.player5 = dt.player5;
	}


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

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public String getPlayer3() {
		return player3;
	}

	public void setPlayer3(String player3) {
		this.player3 = player3;
	}

	public String getPlayer4() {
		return player4;
	}

	public void setPlayer4(String player4) {
		this.player4 = player4;
	}

	public String getPlayer5() {
		return player5;
	}

	public void setPlayer5(String player5) {
		this.player5 = player5;
	}
	
	
	
}
