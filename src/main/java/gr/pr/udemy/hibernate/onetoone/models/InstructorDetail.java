package gr.pr.udemy.hibernate.onetoone.models;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail",schema = "udemy")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private String id;
	
	@Basic
	@Column(name = "youtube_channel",length = 128)
	private String youtubeChannel;
	
	@Basic
	@Column(name = "hobby",length = 45)
	private String hobby;
	
	@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
	private Instructor instructor;
	
	public InstructorDetail() {
	
	}
	
	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getYoutubeChannel() {
		return youtubeChannel;
	}
	
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public Instructor getInstructor() {
		return instructor;
	}
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof InstructorDetail)) return false;
		
		InstructorDetail that = (InstructorDetail) o;
		
		if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		if (getYoutubeChannel() != null ? !getYoutubeChannel().equals(that.getYoutubeChannel()) : that.getYoutubeChannel() != null)
			return false;
		if (getHobby() != null ? !getHobby().equals(that.getHobby()) : that.getHobby() != null) return false;
		return getInstructor() != null ? getInstructor().equals(that.getInstructor()) : that.getInstructor() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getYoutubeChannel() != null ? getYoutubeChannel().hashCode() : 0);
		result = 31 * result + (getHobby() != null ? getHobby().hashCode() : 0);
		result = 31 * result + (getInstructor() != null ? getInstructor().hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		return "InstructorDetail{" +
				"id='" + id + '\'' +
				", youtubeChannel='" + youtubeChannel + '\'' +
				", hobby='" + hobby + '\'' +
				'}';
	}
}

