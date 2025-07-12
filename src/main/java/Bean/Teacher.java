package Bean;

public class Teacher {

	private int id;
	
	private String teacherName;
	private String courseName;
	private int workExp;
	private String lang;
	public Teacher() {
	
	}
	public String getTeacherName() {
		return teacherName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getWorkExp() {
		return workExp;
	}
	public void setWorkExp(int workExp) {
		this.workExp = workExp;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	@Override
	public String toString() {
		return "Teacher [teacherName=" + teacherName + ", courseName=" + courseName + ", workExp=" + workExp + ", lang="
				+ lang + "]";
	}
	
	
}
