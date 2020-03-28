package com.tan.erp.web.produce.entity;

import com.tan.erp.mybatis.annotation.Table;
import com.tan.erp.web.base.entity.BaseEntity;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * @Author: nieyy
 * @Date: 2020/3/13 19:35
 * @Version 1.0
 * @Description:
 */
@Table("pp_contract")
public class ContractEntity extends BaseEntity implements Serializable {
    private Long id;
    private String contractCode;
    private Integer stationId;
    private String stationName;
    private String projectName;
    private Long customerId;
    private String customerName;
    private String constructionUnit;
    private String accountingUnit;
    private Integer contractType;
    private LocalDate planDate;
    private Integer planQuantity;
    private Integer maxAmount;
    private Integer settlementMethod;
    private String contractResponsiblePerson;
    private String constructionPlace;
    private LocalDate signDate;
    private LocalDate deliveryDate;
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
    private Instant createTime;
    private String modifyUser;
    private Instant modifyTime;


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
        this.contractCode = contractCode;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
        this.customerName = customerName;
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

    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public LocalDate getPlanDate() {
        return planDate;
    }

    public void setPlanDate(LocalDate planDate) {
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
        this.contractResponsiblePerson = contractResponsiblePerson;
    }

    public String getConstructionPlace() {
        return constructionPlace;
    }

    public void setConstructionPlace(String constructionPlace) {
        this.constructionPlace = constructionPlace;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLiaisonPerson() {
        return liaisonPerson;
    }

    public void setLiaisonPerson(String liaisonPerson) {
        this.liaisonPerson = liaisonPerson;
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

    public String getIntensityLevel() {
        return intensityLevel;
    }

    public void setIntensityLevel(String intensityLevel) {
        this.intensityLevel = intensityLevel;
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

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
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
        this.productSpec = productSpec;
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
        this.cementLable = cementLable;
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
