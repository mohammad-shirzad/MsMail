package model.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Inbox")
public class EmailDto implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "FromAccount")
    private String from;

    @Column(name = "ToAccount")
    private String to;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @Column(name = "ReadStatus")
    private boolean read;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public EmailDto(String from, String to, String title, String content, boolean read) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.content = content;
        this.read = read;
    }

    public EmailDto() {
    }
}
