package com.edgedo.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("scale")
public class Scale implements Serializable{


	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;

	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;

	/**
	 * 属性描述:量表名
	 */
	@TableField(value="SCALE_NAME",exist=true)
	String scaleName;

	/**
	 * 属性描述:量表描述
	 */
	@TableField(value="SCALE_DESCRIPTION",exist=true)
	String scaleDescription;

	/**
	 * 属性描述:量表价格
	 */
	@TableField(value="SCALE_PRICE",exist=true)
	java.math.BigDecimal scalePrice;

	/**
	 * 属性描述:量表折扣价格
	 */
	@TableField(value="DISCOUNT_PRICE",exist=true)
	java.math.BigDecimal discountPrice;

	/**
	 * 属性描述:题目数量·
	 */
	@TableField(value="QUESTION_SUM_NUM",exist=true)
	Integer questionSumNum;

	/**
	 * 属性描述:已测人数·
	 */
	@TableField(value="TEST_PEOPLE_NUM",exist=true)
	Integer testPeopleNum;

	/**
	 * 属性描述:小图
	 */
	@TableField(value="SMALL_IMAGE_URL",exist=true)
	String smallImageUrl;

	/**
	 * 属性描述:大图
	 */
	@TableField(value="ORDER_NUM",exist=true)
	String orderNum;

	/**
	 * 属性描述:大图
	 */
	@TableField(value="BIG_IMAGE_URL",exist=true)
	String bigImageUrl;

	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	String dataState;

	/**
	 * 属性描述: 折扣状态
	 */
	@TableField(value="DISCOUNT_STATE",exist=true)
	String discountState;

	public String getDiscountState() {
		return discountState;
	}

	public Scale setDiscountState(String discountState) {
		this.discountState = discountState;
		return this;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getQuestionSumNum() {
		return questionSumNum;
	}

	public void setQuestionSumNum(Integer questionSumNum) {
		this.questionSumNum = questionSumNum;
	}

	public String getId(){
		return this.id;
	}

	public void setId(String id){
		this.id=id;
	}


	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}


	public String getScaleName(){
		return this.scaleName;
	}

	public void setScaleName(String scaleName){
		this.scaleName=scaleName;
	}


	public String getScaleDescription(){
		return this.scaleDescription;
	}

	public void setScaleDescription(String scaleDescription){
		this.scaleDescription=scaleDescription;
	}


	public java.math.BigDecimal getScalePrice(){
		return this.scalePrice;
	}

	public void setScalePrice(java.math.BigDecimal scalePrice){
		this.scalePrice=scalePrice;
	}

	public java.math.BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(java.math.BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Integer getTestPeopleNum(){
		return this.testPeopleNum;
	}

	public void setTestPeopleNum(Integer testPeopleNum){
		this.testPeopleNum=testPeopleNum;
	}


	public String getSmallImageUrl(){
		return this.smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl){
		this.smallImageUrl=smallImageUrl;
	}


	public String getBigImageUrl(){
		return this.bigImageUrl;
	}

	public void setBigImageUrl(String bigImageUrl){
		this.bigImageUrl=bigImageUrl;
	}


	public String getDataState(){
		return this.dataState;
	}

	public void setDataState(String dataState){
		this.dataState=dataState;
	}




	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", createTime=").append(createTime);
		sb.append(", scaleName=").append(scaleName);
		sb.append(", scaleDescription=").append(scaleDescription);
		sb.append(", scalePrice=").append(scalePrice);
		sb.append(", discountPrice=").append(discountPrice);
		sb.append(", testPeopleNum=").append(testPeopleNum);
		sb.append(", smallImageUrl=").append(smallImageUrl);
		sb.append(", bigImageUrl=").append(bigImageUrl);
		sb.append(", dataState=").append(dataState);
		sb.append(", discountState=").append(discountState);
		sb.append("]");
		return sb.toString();
	}


	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Scale other = (Scale) that;
		boolean flag = true;
		return  flag
				&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))
				&&(this.getScaleName() == null ? other.getId() == null : this.getScaleName().equals(other.getScaleName()))
				&&(this.getScaleDescription() == null ? other.getId() == null : this.getScaleDescription().equals(other.getScaleDescription()))
				&&(this.getScalePrice() == null ? other.getId() == null : this.getScalePrice().equals(other.getScalePrice()))
				&&(this.getDiscountPrice() == null ? other.getId() == null : this.getDiscountPrice().equals(other.getDiscountPrice()))
				&&(this.getTestPeopleNum() == null ? other.getId() == null : this.getTestPeopleNum().equals(other.getTestPeopleNum()))
				&&(this.getSmallImageUrl() == null ? other.getId() == null : this.getSmallImageUrl().equals(other.getSmallImageUrl()))
				&&(this.getBigImageUrl() == null ? other.getId() == null : this.getBigImageUrl().equals(other.getBigImageUrl()))
				&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))
				&&(this.getDiscountState() == null ? other.getId() == null : this.getDiscountState().equals(other.getDiscountState()))
				;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getScaleName() == null) ? 0 : getScaleName().hashCode());
		result = prime * result + ((getScaleDescription() == null) ? 0 : getScaleDescription().hashCode());
		result = prime * result + ((getScalePrice() == null) ? 0 : getScalePrice().hashCode());
		result = prime * result + ((getDiscountPrice() == null) ? 0 : getDiscountPrice().hashCode());
		result = prime * result + ((getTestPeopleNum() == null) ? 0 : getTestPeopleNum().hashCode());
		result = prime * result + ((getSmallImageUrl() == null) ? 0 : getSmallImageUrl().hashCode());
		result = prime * result + ((getBigImageUrl() == null) ? 0 : getBigImageUrl().hashCode());
		result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());
		result = prime * result + ((getDiscountState() == null) ? 0 : getDiscountState().hashCode());
		;
		return result;
	}

}
