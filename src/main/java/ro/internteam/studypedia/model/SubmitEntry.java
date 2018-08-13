package ro.internteam.studypedia.model;

public class SubmitEntry {

    private String university;
    private String faculty;
    private String branch;
    private String subject;
    private String articleType;
    private String title;
    private String description;

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articletype) {
        this.articleType = articletype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void main(String[] args) {

    }
    public enum ArticleStatus { PENDING }
}
