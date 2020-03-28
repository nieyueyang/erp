package com.tan.erp.web.produce.entity;

import com.tan.erp.mybatis.annotation.Table;
import com.tan.erp.web.base.entity.BaseEntity;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

public class ProjectEntity extends BaseEntity implements Serializable {
    private Long id;
    private String projectCode;
    private String projectName;
    private Long contractId;
    private String contractCode;


    private Integer stationId;
    private String stationName;
    private Long customerId;
    private String customerName;
    private LocalDate deliveryDate;
    private String pourPart;
    private String pourMethod;
    private LocalDate planDate;
    private Integer planQuantity;
    private String intensityLevel;
    private String impermeabilityLevel;
    private String frostResistanceLevel;
    private String bendLevel;
    private String anticorrosiveLevel;
    private String slump;



    private Integer projectStatus;
    private Integer projectCategory;
    private String projectCounty;
    private Integer concreteQuantity;
    private LocalDate commencementDate;
    private Integer planPeriod;
    private String constructionUnit;
    private String accountingUnit;
    private String investmentUnit;
    private String supervisorsUnit;
    private String constructionPlace;
    private Integer transportDistance;
    private Integer transportCost;
    private String telephone;
    private String liaisonPerson;
    private String legalRepresentative;
    private String technicalRequirement;
    private String supplier;
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

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Integer getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(Integer projectCategory) {
        this.projectCategory = projectCategory;
    }

    public String getProjectCounty() {
        return projectCounty;
    }

    public void setProjectCounty(String projectCounty) {
        this.projectCounty = projectCounty;
    }

    public Integer getConcreteQuantity() {
        return concreteQuantity;
    }

    public void setConcreteQuantity(Integer concreteQuantity) {
        this.concreteQuantity = concreteQuantity;
    }

    public LocalDate getCommencementDate() {
        return commencementDate;
    }

    public void setCommencementDate(LocalDate commencementDate) {
        this.commencementDate = commencementDate;
    }

    public Integer getPlanPeriod() {
        return planPeriod;
    }

    public void setPlanPeriod(Integer planPeriod) {
        this.planPeriod = planPeriod;
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

    public String getInvestmentUnit() {
        return investmentUnit;
    }

    public void setInvestmentUnit(String investmentUnit) {
        this.investmentUnit = investmentUnit;
    }

    public String getSupervisorsUnit() {
        return supervisorsUnit;
    }

    public void setSupervisorsUnit(String supervisorsUnit) {
        this.supervisorsUnit = supervisorsUnit;
    }

    public String getConstructionPlace() {
        return constructionPlace;
    }

    public void setConstructionPlace(String constructionPlace) {
        this.constructionPlace = constructionPlace;
    }

    public Integer getTransportDistance() {
        return transportDistance;
    }

    public void setTransportDistance(Integer transportDistance) {
        this.transportDistance = transportDistance;
    }

    public Integer getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(Integer transportCost) {
        this.transportCost = transportCost;
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

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getTechnicalRequirement() {
        return technicalRequirement;
    }

    public void setTechnicalRequirement(String technicalRequirement) {
        this.technicalRequirement = technicalRequirement;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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