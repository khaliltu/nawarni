package tn.iit.nawarni.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.iit.nawarni.entities.enumerations.InternshipType;
import tn.iit.nawarni.entities.enumerations.PostType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String text;
	private String description;
	@Enumerated(EnumType.STRING)
	private PostType postType;
	@Enumerated(EnumType.STRING)
	private InternshipType internshipType;
	private String field;
	private int durationDays;
	private int internsRequired;
	private String path;
	private int level;
	@Temporal(TemporalType.DATE)
	private Date startingDate;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "post")
	private List<StudentApplication> studentApplications;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	@OneToOne(cascade = CascadeType.ALL)
	private Notification notification;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
	private List<Document> documents;

}
