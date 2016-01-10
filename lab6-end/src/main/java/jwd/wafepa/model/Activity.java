package jwd.wafepa.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="tblActivity")
public class Activity {

	@Id
	@Column(name="id")
	@GeneratedValue
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany (mappedBy="activity", fetch=FetchType.EAGER)
	private Set<Log> logs;
	
	private String adminComment;
	
	
	public Set<Log> getLogs() {
		return logs;
	}
	
	@Column(name="hidden", nullable=false, columnDefinition="boolean default false")
	private boolean hidden;
	
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="created", nullable = false)
	public Date created;
	
	@Column(name="deleted")
	public Date deleted;
	
	
	public Date getDeleted() {
		return deleted;
	}
	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}
	public void setLogs(Set<Log> logs) {
		this.logs = logs;
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
	public String getAdminComment() {
		return adminComment;
	}
	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
