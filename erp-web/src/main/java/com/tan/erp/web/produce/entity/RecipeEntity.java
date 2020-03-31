package com.tan.erp.web.produce.entity;

import com.tan.erp.mybatis.annotation.Table;
import com.tan.erp.mybatis.annotation.TargetColumn;
import com.tan.erp.mybatis.annotation.TargetTable;
import com.tan.erp.web.base.entity.BaseEntity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * @Author: nieyy
 * @Date: 2020/3/7 21:34
 * @Version 1.0
 * @Description:
 */
@Table("pp_recipe")
@TargetTable("recipe")
public class RecipeEntity extends BaseEntity implements Serializable {
    @TargetColumn("RecipeID")
    private Long id;
    private String recipeCode;
    @TargetColumn("RecipeName")
    private String recipeName;
    @TargetColumn("intensityLevel")
    private String intensityLevel;
    @TargetColumn("sjb")
    private String waterBinderRatio;
    @TargetColumn("sl")
    private String sandRate;
    @TargetColumn("tld")
    private String slump;
    @TargetColumn("RecipeSN1")
    private String cement1;
    @TargetColumn("RecipeSN2")
    private String cement2;
    @TargetColumn("RecipeSN3")
    private String cement3;
    @TargetColumn("RecipeSZ")
    private String sand1;
    @TargetColumn("RecipeXSL")
    private String sand2;
    @TargetColumn("RecipeSZ1")
    private String sand3;
    @TargetColumn("RecipeDSL")
    private String bigStone;
    @TargetColumn("RecipeZSL")
    private String middleStone;
    @TargetColumn("RecipeSZ2")
    private String smallStone;
    @TargetColumn("RecipeFMH")
    private String flyash;
    @TargetColumn("RecipeKF")
    private String minePowder;
    @TargetColumn("RecipeWJJ1")
    private String additive1;
    @TargetColumn("RecipeWJJ2")
    private String additive2;
    @TargetColumn("RecipeSN4")
    private String additive3;
    @TargetColumn("RecipeFJJ")
    private String additive4;
    @TargetColumn("RecipeSHUI")
    private String water;
    @TargetColumn("RecipeOth1")
    private String other1;
    @TargetColumn("RecipeOth2")
    private String other2;
    @TargetColumn("ksd")
    private String ImpermeabilityLevel;
    @TargetColumn("kzd")
    private String bendLevel;
    @TargetColumn("sljdj")
    private String sandLevel;
    @TargetColumn("sszdlj")
    private String stoneDiameter;
    @TargetColumn("bgmd")
    private String apparentDensity;
    private Integer importFlag;
    private Integer status;
    private Integer deleteFlag;
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

    public String getRecipeCode() {
        return recipeCode;
    }

    public void setRecipeCode(String recipeCode) {
        this.recipeCode = recipeCode;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIntensityLevel() {
        return intensityLevel;
    }

    public void setIntensityLevel(String intensityLevel) {
        this.intensityLevel = intensityLevel;
    }

    public String getWaterBinderRatio() {
        return waterBinderRatio;
    }

    public void setWaterBinderRatio(String waterBinderRatio) {
        this.waterBinderRatio = waterBinderRatio;
    }

    public String getSandRate() {
        return sandRate;
    }

    public void setSandRate(String sandRate) {
        this.sandRate = sandRate;
    }

    public String getSlump() {
        return slump;
    }

    public void setSlump(String slump) {
        this.slump = slump;
    }

    public String getCement1() {
        return cement1;
    }

    public void setCement1(String cement1) {
        this.cement1 = cement1;
    }

    public String getCement2() {
        return cement2;
    }

    public void setCement2(String cement2) {
        this.cement2 = cement2;
    }

    public String getCement3() {
        return cement3;
    }

    public void setCement3(String cement3) {
        this.cement3 = cement3;
    }

    public String getSand1() {
        return sand1;
    }

    public void setSand1(String sand1) {
        this.sand1 = sand1;
    }

    public String getSand2() {
        return sand2;
    }

    public void setSand2(String sand2) {
        this.sand2 = sand2;
    }

    public String getSand3() {
        return sand3;
    }

    public void setSand3(String sand3) {
        this.sand3 = sand3;
    }

    public String getBigStone() {
        return bigStone;
    }

    public void setBigStone(String bigStone) {
        this.bigStone = bigStone;
    }

    public String getMiddleStone() {
        return middleStone;
    }

    public void setMiddleStone(String middleStone) {
        this.middleStone = middleStone;
    }

    public String getSmallStone() {
        return smallStone;
    }

    public void setSmallStone(String smallStone) {
        this.smallStone = smallStone;
    }

    public String getFlyash() {
        return flyash;
    }

    public void setFlyash(String flyash) {
        this.flyash = flyash;
    }

    public String getMinePowder() {
        return minePowder;
    }

    public void setMinePowder(String minePowder) {
        this.minePowder = minePowder;
    }

    public String getAdditive1() {
        return additive1;
    }

    public void setAdditive1(String additive1) {
        this.additive1 = additive1;
    }

    public String getAdditive2() {
        return additive2;
    }

    public void setAdditive2(String additive2) {
        this.additive2 = additive2;
    }

    public String getAdditive3() {
        return additive3;
    }

    public void setAdditive3(String additive3) {
        this.additive3 = additive3;
    }

    public String getAdditive4() {
        return additive4;
    }

    public void setAdditive4(String additive4) {
        this.additive4 = additive4;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getImpermeabilityLevel() {
        return ImpermeabilityLevel;
    }

    public void setImpermeabilityLevel(String impermeabilityLevel) {
        ImpermeabilityLevel = impermeabilityLevel;
    }

    public String getBendLevel() {
        return bendLevel;
    }

    public void setBendLevel(String bendLevel) {
        this.bendLevel = bendLevel;
    }

    public String getSandLevel() {
        return sandLevel;
    }

    public void setSandLevel(String sandLevel) {
        this.sandLevel = sandLevel;
    }

    public String getStoneDiameter() {
        return stoneDiameter;
    }

    public void setStoneDiameter(String stoneDiameter) {
        this.stoneDiameter = stoneDiameter;
    }

    public String getApparentDensity() {
        return apparentDensity;
    }

    public void setApparentDensity(String apparentDensity) {
        this.apparentDensity = apparentDensity;
    }

    public Integer getImportFlag() {
        return importFlag;
    }

    public void setImportFlag(Integer importFlag) {
        this.importFlag = importFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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
