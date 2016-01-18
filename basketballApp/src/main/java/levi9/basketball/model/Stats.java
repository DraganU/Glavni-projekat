package levi9.basketball.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stats")
public class Stats {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "gp")
	private int gp;

	@Column(name = "min")
	private int min;

	@Column(name = "pts")
	private int pts;

	@Column(name = "oreb")
	private int oreb;

	@Column(name = "dreb")
	private int dreb;

	@Column(name = "asts")
	private int asts;

	@Column(name = "stl")
	private int stl;

	@Column(name = "blk")
	private int blk;

	@Column(name = "too")
	private int to;

	@Column(name = "reb")
	private int reb;

	@Column(name = "pf")
	private int pf;

	@Column(name = "fga")
	private int fga;

	@Column(name = "fgm")
	private int fgm;

	@Column(name = "fta")
	private int fta;

	@Column(name = "ftm")
	private int ftm;

	@Column(name = "tpa")
	private int tpa;

	@Column(name = "tpm")
	private int tpm;

	public Stats() {
	}

	public Stats(Stats s) {
		this.id = s.id;
		this.gp = s.gp;
		this.min = s.min;
		this.pts = s.pts;
		this.oreb = s.oreb;
		this.dreb = s.dreb;
		this.asts = s.asts;
		this.stl = s.stl;
		this.blk = s.blk;
		this.to = s.to;
		this.reb = s.reb;
		this.pf = s.pf;
		this.fga = s.fga;
		this.fgm = s.fgm;
		this.fta = s.fta;
		this.ftm = s.ftm;
		this.tpa = s.tpa;
		this.tpm = s.tpm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGp() {
		return gp;
	}

	public void setGp(int gp) {
		this.gp = gp;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}

	public int getOreb() {
		return oreb;
	}

	public void setOreb(int oreb) {
		this.oreb = oreb;
	}

	public int getDreb() {
		return dreb;
	}

	public void setDreb(int dreb) {
		this.dreb = dreb;
	}

	public int getAsts() {
		return asts;
	}

	public void setAsts(int asts) {
		this.asts = asts;
	}

	public int getStl() {
		return stl;
	}

	public void setStl(int stl) {
		this.stl = stl;
	}

	public int getBlk() {
		return blk;
	}

	public void setBlk(int blk) {
		this.blk = blk;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getReb() {
		return reb;
	}

	public void setReb(int reb) {
		this.reb = reb;
	}

	public int getPf() {
		return pf;
	}

	public void setPf(int pf) {
		this.pf = pf;
	}

	public int getFga() {
		return fga;
	}

	public void setFga(int fga) {
		this.fga = fga;
	}

	public int getFgm() {
		return fgm;
	}

	public void setFgm(int fgm) {
		this.fgm = fgm;
	}

	public int getFta() {
		return fta;
	}

	public void setFta(int fta) {
		this.fta = fta;
	}

	public int getFtm() {
		return ftm;
	}

	public void setFtm(int ftm) {
		this.ftm = ftm;
	}

	public int getTpa() {
		return tpa;
	}

	public void setTpa(int tpa) {
		this.tpa = tpa;
	}

	public int getTpm() {
		return tpm;
	}

	public void setTpm(int tpm) {
		this.tpm = tpm;
	}

}
