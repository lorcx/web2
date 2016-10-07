package module.base.sys.entity;

import java.util.Date;

/**
 * Created by lx on 2016/10/7.
 */
public class BaseRole {
    private String id;
    private String roleName;
    private String status;
    private String creDept;
    private String creUser;
    private Date creDate;

    public BaseRole() {
    }

    public BaseRole(String id, String roleName, String status, String creDept, String creUser, Date creDate) {
        this.id = id;
        this.roleName = roleName;
        this.status = status;
        this.creDept = creDept;
        this.creUser = creUser;
        this.creDate = creDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreDept() {
        return creDept;
    }

    public void setCreDept(String creDept) {
        this.creDept = creDept;
    }

    public String getCreUser() {
        return creUser;
    }

    public void setCreUser(String creUser) {
        this.creUser = creUser;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }
}
