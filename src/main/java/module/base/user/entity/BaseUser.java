package module.base.user.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
@SuppressWarnings("all")
public class BaseUser implements Serializable{
    private String id;

    private String nickName;

    private String userName;

    private String passWord;

    private Date creDate;

    private String status;

    private Blob pic;

    public BaseUser() {
    }

    public BaseUser(String id, String nickName, String userName, String passWord, Date creDate, String status, Blob pic) {
        this.id = id;
        this.nickName = nickName;
        this.userName = userName;
        this.passWord = passWord;
        this.creDate = creDate;
        this.status = status;
        this.pic = pic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
        this.status = status;
    }

    public Blob getPic() {
        return pic;
    }

    public void setPic(Blob pic) {
        this.pic = pic;
    }
}