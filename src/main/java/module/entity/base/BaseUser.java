package module.entity.base;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
@SuppressWarnings("all")
public class BaseUser implements Serializable{
    private String id;

    private String nickname;

    private String userName;

    private String passWord;

    private Date creDate;

    private String status;

    private Blob pic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Blob getPic() {
        return pic;
    }

    public void setPic(Blob pic) {
        this.pic = pic;
    }

    public BaseUser() {
    }

    public BaseUser(String id, String nickname, String userName, String passWord, Date creDate, String status, Blob pic) {
        this.id = id;
        this.nickname = nickname;
        this.userName = userName;
        this.passWord = passWord;
        this.creDate = creDate;
        this.status = status;
        this.pic = pic;
    }
}