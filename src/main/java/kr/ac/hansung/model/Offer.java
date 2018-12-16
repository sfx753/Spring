package kr.ac.hansung.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor //매개변수가 없는 생성자

//@ToString
public class Offer {
	
	
	private int id;
	@NotEmpty(message="The Code address cannot be empty")
	private String code;
	@NotEmpty(message="The Subject address cannot be empty")
	private String subject;
	@NotEmpty(message="The Classes address cannot be empty")
	private String classes;
	
	/*private int id;
	@Size(min=2,max=100,message="Name must be between 2 and 100 chars") //validate()검증 조건 만족하지않을시 메시지 까지
	private String name;
	@Email(message="please provide a valid email addreess")
	@NotEmpty(message="The email address cannot be empty")
	private String email;
	@Size(min=5,max=100,message="Text must be between 5 and 100 chars")
	private String text;*/

	public String toString() {
		return "과목코드: " + code + " 과목이름: " + subject + " 분반: " + classes;
	}
	/*@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}*/
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}*/
	
}
