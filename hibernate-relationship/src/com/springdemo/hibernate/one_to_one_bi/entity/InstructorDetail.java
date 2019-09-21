package com.springdemo.hibernate.one_to_one_bi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	
	@Column(name = "hobby")
	private String hobby;
	
	/**
	 * if you want to remove delete operation out from association
	 * then you need to execute the following code first to remove association
	 * instructurDetail.getInstructor().setInstructorDetail(null);
	 */
//	@OneToOne(mappedBy = "instructorDetail", 
//			cascade = {CascadeType.DETACH
//					, CascadeType.MERGE
//					, CascadeType.PERSIST
//					, CascadeType.REFRESH}) // if you want to remove delete operation out from association
	@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL) // if you want all 
	private Instructor instructor;

	public InstructorDetail() {}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby
//				+ ", instructor=" + instructor
				+ "]";
	}
}
