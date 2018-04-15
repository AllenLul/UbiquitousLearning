package just.learn.entity;
/*课件*/
public class Courseware extends Review{
    private Integer id;

    private Integer courseId;

    private Integer downlaodTimes;

    private String type;

    private String url;

    private String isPass;

    private String courseCap;

    private String handleType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getDownlaodTimes() {
        return downlaodTimes;
    }

    public void setDownlaodTimes(Integer downlaodTimes) {
        this.downlaodTimes = downlaodTimes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass == null ? null : isPass.trim();
    }

    public String getCourseCap() {
        return courseCap;
    }

    public void setCourseCap(String courseCap) {
        this.courseCap = courseCap == null ? null : courseCap.trim();
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType == null ? null : handleType.trim();
    }
}