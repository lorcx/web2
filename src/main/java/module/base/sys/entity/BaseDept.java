package module.base.sys.entity;

import java.util.Date;

/**
 * 部门
 * Created by lx on 2016/10/7.
 */
public class BaseDept {
    private String id;
    private String name;
    private String deptName;
    private String superId;
    private String status;
    private Date creDate;
    private String deptCode;
    private String orderNo;
    private String deptAbbr;
    private String deptLevel;
    private String description;

    public BaseDept() {
    }

    public BaseDept(String id, String name, String deptName, String superId, String status, Date creDate, String deptCode, String orderNo, String deptAbbr, String deptLevel, String description) {
        this.id = id;
        this.name = name;
        this.deptName = deptName;
        this.superId = superId;
        this.status = status;
        this.creDate = creDate;
        this.deptCode = deptCode;
        this.orderNo = orderNo;
        this.deptAbbr = deptAbbr;
        this.deptLevel = deptLevel;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDeptAbbr() {
        return deptAbbr;
    }

    public void setDeptAbbr(String deptAbbr) {
        this.deptAbbr = deptAbbr;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }
}
