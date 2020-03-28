package com.tan.erp.web.produce.entity;

import com.tan.erp.mybatis.annotation.Table;
import com.tan.erp.mybatis.annotation.TargetColumn;
import com.tan.erp.mybatis.annotation.TargetTable;
import com.tan.erp.web.base.entity.BaseEntity;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * @Author: nieyy
 * @Date: 2020/3/4 21:51
 * @Version 1.0
 * @Description:
 */

@TargetTable("Task")
@Table("pp_task")
public class TaskEntity extends BaseEntity implements Serializable {
    @TargetColumn("TaskID")
    private Integer id;
    private String taskCode;
    @TargetColumn("TaskName")
    private String taskName;
    @TargetColumn("StationID")
    private Integer stationId;
    private String stationName;
    @TargetColumn("CustomerID")
    private Integer customerId;
    @TargetColumn("CustomerName")
    private String customerName;
    @TargetColumn("OrderID")
    private Integer orderId;
    @TargetColumn("ItemID")
    private Long projectId;
    private String projectCode;
    @TargetColumn("RecipeNo")
    private Integer recipeId;
    private String recipeCode;
    @TargetColumn("EmployeeID")
    private Integer employeeId;
    @TargetColumn("EmployeeName")
    private String EmployeeName;
    @TargetColumn("ProjectName")
    private String projectName;
    @TargetColumn("ProjectCmpy")
    private String projectCoreInfo;
    @TargetColumn("ProjectPart")
    private String pourPart;
    @TargetColumn("WorkMethod")
    private String pourMethod;
    @TargetColumn("Distance")
    private Integer transportDistance;
    @TargetColumn("PlanCount")
    private Integer planQuantity;
    @TargetColumn("OutCount")
    private Integer outQuantity;
    @TargetColumn("EndCount")
    private Integer endQuantity;
    @TargetColumn("planDate")
    private LocalDate planDate;
    @TargetColumn("ShipToAdd1")
    private String deliveryTelephone;
    @TargetColumn("Ustate")
    private Integer status;


    private String contractId;
    private String contractCode;
    private String constructionUnit;
    private String accountingUnit;
    private String intensityLevel;
    private LocalDate deliveryDate;
    private String productSpec;
    private String slump;
    private String impermeabilityLevel;
    private String frostResistanceLevel;
    private String bendLevel;
    private String anticorrosiveLevel;
    private String technicalRequirement;
    private String otherRequirement;

    private String createUser;
    private String createUserName;
    private Instant createTime;
    private String modifyUser;
    private Instant modifyTime;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeCode() {
        return recipeCode;
    }

    public void setRecipeCode(String recipeCode) {
        this.recipeCode = recipeCode;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCoreInfo() {
        return projectCoreInfo;
    }

    public void setProjectCoreInfo(String projectCoreInfo) {
        this.projectCoreInfo = projectCoreInfo;
    }

    public String getPourPart() {
        return pourPart;
    }

    public void setPourPart(String pourPart) {
        this.pourPart = pourPart;
    }

    public String getPourMethod() {
        return pourMethod;
    }

    public void setPourMethod(String pourMethod) {
        this.pourMethod = pourMethod;
    }

    public Integer getTransportDistance() {
        return transportDistance;
    }

    public void setTransportDistance(Integer transportDistance) {
        this.transportDistance = transportDistance;
    }

    public Integer getPlanQuantity() {
        return planQuantity;
    }

    public void setPlanQuantity(Integer planQuantity) {
        this.planQuantity = planQuantity;
    }

    public Integer getOutQuantity() {
        return outQuantity;
    }

    public void setOutQuantity(Integer outQuantity) {
        this.outQuantity = outQuantity;
    }

    public Integer getEndQuantity() {
        return endQuantity;
    }

    public void setEndQuantity(Integer endQuantity) {
        this.endQuantity = endQuantity;
    }

    public LocalDate getPlanDate() {
        return planDate;
    }

    public void setPlanDate(LocalDate planDate) {
        this.planDate = planDate;
    }

    public String getDeliveryTelephone() {
        return deliveryTelephone;
    }

    public void setDeliveryTelephone(String deliveryTelephone) {
        this.deliveryTelephone = deliveryTelephone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getAccountingUnit() {
        return accountingUnit;
    }

    public void setAccountingUnit(String accountingUnit) {
        this.accountingUnit = accountingUnit;
    }

    public String getIntensityLevel() {
        return intensityLevel;
    }

    public void setIntensityLevel(String intensityLevel) {
        this.intensityLevel = intensityLevel;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
    }

    public String getImpermeabilityLevel() {
        return impermeabilityLevel;
    }

    public void setImpermeabilityLevel(String impermeabilityLevel) {
        this.impermeabilityLevel = impermeabilityLevel;
    }

    public String getFrostResistanceLevel() {
        return frostResistanceLevel;
    }

    public void setFrostResistanceLevel(String frostResistanceLevel) {
        this.frostResistanceLevel = frostResistanceLevel;
    }

    public String getBendLevel() {
        return bendLevel;
    }

    public void setBendLevel(String bendLevel) {
        this.bendLevel = bendLevel;
    }

    public String getAnticorrosiveLevel() {
        return anticorrosiveLevel;
    }

    public void setAnticorrosiveLevel(String anticorrosiveLevel) {
        this.anticorrosiveLevel = anticorrosiveLevel;
    }

    public String getTechnicalRequirement() {
        return technicalRequirement;
    }

    public void setTechnicalRequirement(String technicalRequirement) {
        this.technicalRequirement = technicalRequirement;
    }

    public String getOtherRequirement() {
        return otherRequirement;
    }

    public void setOtherRequirement(String otherRequirement) {
        this.otherRequirement = otherRequirement;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Instant getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Instant modifyTime) {
        this.modifyTime = modifyTime;
    }
}
