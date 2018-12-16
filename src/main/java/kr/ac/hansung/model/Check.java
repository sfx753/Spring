package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@ToString
public class Check {
	@Size(min=2,max=100,message="Name must be between 2 and 100 chars")
	private int id;
	@NotEmpty(message="The email address cannot be empty")
	private String year;
	@NotEmpty(message="The email address cannot be empty")
	private String semester;
	@NotEmpty(message="The email address cannot be empty")
	private String code;
	@NotEmpty(message="The email address cannot be empty")
	private String subject;
	@NotEmpty(message="The email address cannot be empty")
	private String kind;
	@Size(min=2,max=100,message="Name must be between 2 and 100 chars")
	private int point;
	public String toString() {
		return  year+"년" +semester +" 학기 " + " 과목코드 :" + code+" 과목명 : "+subject+
				" 구분  :"+ kind+ " 학점 : " +point; 
	}
}
