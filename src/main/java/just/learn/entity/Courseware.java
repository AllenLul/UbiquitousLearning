package just.learn.entity;

public class Courseware {
    private Integer id;

    private Integer courseId;//关联的课程id

    private Integer downlaodTimes;//下载次数

    private String type;//课件类型

    private String url;//课件文件路径

    private String isPass;//课件是否通过 1通过 0未通过

    private String courseCap;//忘记了

    private String handleType;//课件是否已经处理 1 已经处理 0 未处理

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