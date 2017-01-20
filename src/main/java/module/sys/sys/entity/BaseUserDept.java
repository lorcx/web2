package module.sys.sys.entity;

/**
 * Created by lx on 2016/10/7.
 */
public class BaseUserDept {
    private String id;
    private String userId;
    private String deptId;

    public BaseUserDept() {
    }

    public BaseUserDept(String id, String userId, String deptId) {
        this.id = id;
        this.userId = userId;
        this.deptId = deptId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
