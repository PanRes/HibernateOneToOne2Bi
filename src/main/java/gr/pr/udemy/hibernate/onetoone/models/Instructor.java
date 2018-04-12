package gr.pr.udemy.hibernate.onetoone.models;

import javax.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {
	
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	
	@Basic
	@Column(name = "first_name", nullable = true, length = 45)
	private String firstName;
	
	@Basic
	@Column(name = "last_name", nullable = true, length = 45)
	private String lastName;
	
	@Basic
	@Column(name = "email", nullable = true, length = 45)
	private String  email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetailId;
	
	public Instructor() {
	}
	
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Instructor)) return false;
		
		Instructor that = (Instructor) o;
		
		if (getId() != that.getId()) return false;
		if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
			return false;
		if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
			return false;
		if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
		return getInstructorDetailId() != null ? getInstructorDetailId().equals(that.getInstructorDetailId()) : that.getInstructorDetailId() == null;
	}
	
	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
		result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
		result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
		result = 31 * result + (getInstructorDetailId() != null ? getInstructorDetailId().hashCode() : 0);
		return result;
	}
	
	public InstructorDetail getInstructorDetailId() {
		return instructorDetailId;
	}
	
	public void setInstructorDetailId(InstructorDetail instructorDetailId) {
		this.instructorDetailId = instructorDetailId;
	}
	
	@Override
	public String toString() {
		return "Instructor{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", instructorDetailId=" + instructorDetailId +
				'}';
	}
}
