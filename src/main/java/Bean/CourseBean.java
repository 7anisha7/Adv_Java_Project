package Bean;

public class CourseBean {
private String cid;
private String cname;
private int cduration;
private double cfee;
private double rate;
private String teachName;
private String lang;
private String desc;
private String image;
public CourseBean() {}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public int getCduration() {
	return cduration;
}
public void setCduration(int cduration) {
	this.cduration = cduration;
}
public double getCfee() {
	return cfee;
}
public void setCfee(double cfee) {
	this.cfee = cfee;
}
public double getRate() {
	return rate;
}
public void setRate(double rate) {
	this.rate = rate;
}
public String getTeachName() {
	return teachName;
}
public void setTeachName(String teachName) {
	this.teachName = teachName;
}
public String getLang() {
	return lang;
}
public void setLang(String lang) {
	this.lang = lang;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}

@Override
public String toString() {
	return "CourseBean [cid=" + cid + ", cname=" + cname + ", cduration=" + cduration + ", cfee=" + cfee + ", rate="
			+ rate + ", teachName=" + teachName + ", lang=" + lang + ", desc=" + desc + ", image=" + image + "]";
}


}
