package com.tan.erp.web.entity;

import java.io.Serializable;
import java.util.Date;

public class PpProject implements Serializable {
    private Long id;

    private String projectCode;

    private String projectName;

    private Long contractId;

    private String contractCode;

    private Integer projectStatus;

    private Integer projectCategory;

    private String projectCounty;

    private Integer concreteQuantity;

    private Date commencementDate;

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

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
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
        this.contractCode = contractCode == null ? null : contractCode.trim();
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
        this.projectCounty = projectCounty == null ? null : projectCounty.trim();
    }

    public Integer getConcreteQuantity() {
        return concreteQuantity;
    }

    public void setConcreteQuantity(Integer concreteQuantity) {
        this.concreteQuantity = concreteQuantity;
    }

    public Date getCommencementDate() {
        return commencementDate;
    }

    public void setCommencementDate(Date commencementDate) {
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
        this.constructionUnit = constructionUnit == null ? null : constructionUnit.trim();
    }

    public String getAccountingUnit() {
        return accountingUnit;
    }

    public void setAccountingUnit(String accountingUnit) {
        this.accountingUnit = accountingUnit == null ? null : accountingUnit.trim();
    }

    public String getInvestmentUnit() {
        return investmentUnit;
    }

    public void setInvestmentUnit(String investmentUnit) {
        this.investmentUnit = investmentUnit == null ? null : investmentUnit.trim();
    }

    public String getSupervisorsUnit() {
        return supervisorsUnit;
    }

    public void setSupervisorsUnit(String supervisorsUnit) {
        this.supervisorsUnit = supervisorsUnit == null ? null : supervisorsUnit.trim();
    }

    public String getConstructionPlace() {
        return constructionPlace;
    }

    public void setConstructionPlace(String constructionPlace) {
        this.constructionPlace = constructionPlace == null ? null : constructionPlace.trim();
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
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getLiaisonPerson() {
        return liaisonPerson;
    }

    public void setLiaisonPerson(String liaisonPerson) {
        this.liaisonPerson = liaisonPerson == null ? null : liaisonPerson.trim();
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
    }

    public String getTechnicalRequirement() {
        return technicalRequirement;
    }

    public void setTechnicalRequirement(String technicalRequirement) {
        this.technicalRequirement = technicalRequirement == null ? null : technicalRequirement.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
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