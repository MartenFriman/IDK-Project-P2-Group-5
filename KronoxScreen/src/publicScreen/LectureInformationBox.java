package publicScreen;

public class LectureInformationBox {
	private String room;
	private String course;
	private String time;
  
	public LectureInformationBox(String room, String course, String time) {
		this.room = room;
		this.course = course;
		this.time = time;
	}
	
	public String getRoom() {
		return room;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String courseName) {
		this.course = courseName;
	}
	
	public String getTime() {
		return time;
	}
}
