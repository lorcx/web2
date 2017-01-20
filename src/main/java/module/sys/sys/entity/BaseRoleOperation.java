package module.sys.sys.entity;

/**
 * Created by lx on 2016/10/7.
 */
public class BaseRoleOperation {
    private String id;
    private String roleId;
    private String operationId;

    public BaseRoleOperation() {

    }
    public BaseRoleOperation(String id, String roleId, String operationId) {
        this.id = id;
        this.roleId = roleId;
        this.operationId = operationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }
}
