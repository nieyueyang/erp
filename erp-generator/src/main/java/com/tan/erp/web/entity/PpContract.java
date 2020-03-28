package com.tan.erp.web.entity;

import java.io.Serializable;
import java.util.Date;

public class PpContract implements Serializable {
    private Long id;

    private String contractCode;

    private Integer stationId;

    private String projectName;

    private Long customerId;

    private String customerName;

    private String constructionUnit;

    private String accountingUnit;

    private Integer contractType;

    private Date planDate;

    private Integer planQuantity;

    private Integer maxAmount;

    private Integer settlementMethod;

    private String contractResponsiblePerson;

    private String constructionPlace;

    private Date signDate;

    private Date deliveryDate;

    private String telephone;

    private String liaisonPerson;

    private String pourPart;

    private String pourMethod;

    private String intensityLevel;

    private String impermeabilityLevel;

    private String frostResistanceLevel;

    private String bendLevel;

    private String anticorrosiveLevel;

    private String technicalRequirement;

    private String otherRequirement;

    private String slump;

    private Integer concreteQuantity;

    private Integer partSort;

    private String productSpec;

    private Integer materialType;

    private Integer stoneType;

    private Integer sandType;

    private Integer stoneDiameter;

    private Integer cementVariety;

    private String cementLable;

    private Integer status;

    private String createUser;

    private String createUserName;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit == null ? null : constructionUnit.trim();
    }

    public String getAccountingUnit() {
        return accountingUnit;
    }

    public void setAccountingUnit(String accountingUnit) {
        this.accountingUnit = accountingUnit == null ? null : accountingUnit.trim();
    }

    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Integer getPlanQuantity() {
        return planQuantity;
    }

    public void setPlanQuantity(Integer planQuantity) {
        this.planQuantity = planQuantity;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getSettlementMethod() {
        return settlementMethod;
    }

    public void setSettlementMethod(Integer settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    public String getContractResponsiblePerson() {
        return contractResponsiblePerson;
    }

    public void setContractResponsiblePerson(String contractResponsiblePerson) {
        this.contractResponsiblePerson = contractResponsiblePerson == null ? null : contractResponsiblePerson.trim();
    }

    public String getConstructionPlace() {
        return constructionPlace;
    }

    public void setConstructionPlace(String constructionPlace) {
        this.constructionPlace = constructionPlace == null ? null : constructionPlace.trim();
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getLiaisonPerson() {
        return liaisonPerson;
    }

    public void setLiaisonPerson(String liaisonPerson) {
        this.liaisonPerson = liaisonPerson == null ? null : liaisonPerson.trim();
    }

    public String getPourPart() {
        return pourPart;
    }

    public void setPourPart(String pourPart) {
        this.pourPart = pourPart == null ? null : pourPart.trim();
    }

    public String getPourMethod() {
        return pourMethod;
    }

    public void setPourMethod(String pourMethod) {
        this.pourMethod = pourMethod == null ? null : pourMethod.trim();
    }

    public String getIntensityLevel() {
        return intensityLevel;
    }

    public void setIntensityLevel(String intensityLevel) {
        this.intensityLevel = intensityLevel == null ? null : intensityLevel.trim();
    }

    public String getImpermeabilityLevel() {
        return impermeabilityLevel;
    }

    public void setImpermeabilityLevel(String impermeabilityLevel) {
        this.impermeabilityLevel = impermeabilityLevel == null ? null : impermeabilityLevel.trim();
    }

    public String getFrostResistanceLevel() {
        return frostResistanceLevel;
    }

    public void setFrostResistanceLevel(String frostResistanceLevel) {
        this.frostResistanceLevel = frostResistanceLevel == null ? null : frostResistanceLevel.trim();
    }

    public String getBendLevel() {
        return bendLevel;
    }

    public void setBendLevel(String bendLevel) {
        this.bendLevel = bendLevel == null ? null : bendLevel.trim();
    }

    public String getAnticorrosiveLevel() {
        return anticorrosiveLevel;
    }

    public void setAnticorrosiveLevel(String anticorrosiveLevel) {
        this.anticorrosiveLevel = anticorrosiveLevel == null ? null : anticorrosiveLevel.trim();
    }

    public String getTechnicalRequirement() {
        return technicalRequirement;
    }

    public void setTechnicalRequirement(String technicalRequirement) {
        this.technicalRequirement = technicalRequirement == null ? null : technicalRequirement.trim();
    }

    public String getOtherRequirement() {
        return otherRequirement;
    }

    public void setOtherRequirement(String otherRequirement) {
        this.otherRequirement = otherRequirement == null ? null : otherRequirement.trim();
    }

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump == null ? null : slump.trim();
    }

    public Integer getConcreteQuantity() {
        return concreteQuantity;
    }

    public void setConcreteQuantity(Integer concreteQuantity) {
        this.concreteQuantity = concreteQuantity;
    }

    public Integer getPartSort() {
        return partSort;
    }

    public void setPartSort(Integer partSort) {
        this.partSort = partSort;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec == null ? null : productSpec.trim();
    }

    public Integer getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Integer materialType) {
        this.materialType = materialType;
    }

    public Integer getStoneType() {
        return stoneType;
    }

    public void setStoneType(Integer stoneType) {
        this.stoneType = stoneType;
    }

    public Integer getSandType() {
        return sandType;
    }

    public void setSandType(Integer sandType) {
        this.sandType = sandType;
    }

    public Integer getStoneDiameter() {
        return stoneDiameter;
    }

    public void setStoneDiameter(Integer stoneDiameter) {
        this.stoneDiameter = stoneDiameter;
    }

    public Integer getCementVariety() {
        return cementVariety;
    }

    public void setCementVariety(Integer cementVariety) {
        this.cementVariety = cementVariety;
    }

    public String getCementLable() {
        return cementLable;
    }

    public void setCementLable(String cementLable) {
        this.cementLable = cementLable == null ? null : cementLable.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}