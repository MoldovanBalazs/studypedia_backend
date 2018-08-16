package ro.internteam.studypedia.model;

public class SubmitEntry {

    private String subject;
    private String articleType;
    private String title;
    private String description;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
