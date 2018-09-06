package in.semicolonindia.vollypostdemoexample2;

/**
 * Created by MPAYAL-PC on 9/19/2017.
 */

@SuppressWarnings("ALL")
public class ItemDetails {
    private String notice_id;
    private String notice_title;
    private String date;
    private String description;

    public ItemDetails(String notice_id, String notice_title, String date, String description) {
        this.notice_id = notice_id;
        this.notice_title = notice_title;
        this.date = date;
        this.description = description;
    }

    public String getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(String notice_id) {
        this.notice_id = notice_id;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}