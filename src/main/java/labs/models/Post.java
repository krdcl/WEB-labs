package labs.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "posts")
public class Post {
	final int DESCRIPTION_LENGTH = 25;
	@Id
	@GeneratedValue
    private Long id;
	
	@NotNull
	@ManyToOne
	//much posts in one user
    private User author;
    
	@NotBlank
    @Size(min = 1, max = 2048)
    private String text;
    
	@NotNull
    private Date createdAt;
    
	public Post(User author, String text, Date createdAt) {
		this.author = author;
		this.text = text;
		this.createdAt = createdAt;
	}

	public Post() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	public String getDescription(){
		if (text.length()>DESCRIPTION_LENGTH)
			return text.substring(0, DESCRIPTION_LENGTH-1);
		return text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
    
	
    
}
