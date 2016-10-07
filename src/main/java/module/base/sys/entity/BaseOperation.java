package module.base.sys.entity;

/**
 * 资源操作
 * Created by lx on 2016/10/7.
 */
public class BaseOperation {
    private String id;
    private String resourcesName;
    private String parentId;
    private String memo;
    private String icon;
    private String comment;
    private String url;
    private String zStatus;

    public BaseOperation() {
    }

    public BaseOperation(String id, String resourcesName, String parentId, String memo, String icon, String comment, String url, String zStatus) {
        this.id = id;
        this.resourcesName = resourcesName;
        this.parentId = parentId;
        this.memo = memo;
        this.icon = icon;
        this.comment = comment;
        this.url = url;
        this.zStatus = zStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourcesName() {
        return resourcesName;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getzStatus() {
        return zStatus;
    }

    public void setzStatus(String zStatus) {
        this.zStatus = zStatus;
    }
}
