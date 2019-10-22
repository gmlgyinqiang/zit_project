package com.edgedo.sys.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_user_scale")
public class ScaleUserScale implements Serializable{

	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:所属订单ID
	 */
	@TableField(value="OWNER_ORDER_ID",exist=true)
	java.lang.String ownerOrderId;
	
	/**
	 * 属性描述:所属用户ID
	 */
	@TableField(value="USER_ID",exist=true)
	java.lang.String userId;
	
	/**
	 * 属性描述:用户类型
	 */
	@TableField(value="USER_TYPE",exist=true)
	java.lang.String userType;
	
	/**
	 * 属性描述:所属企业ID
	 */
	@TableField(value="OWNER_COM_ID",exist=true)
	java.lang.String ownerComId;
	
	/**
	 * 属性描述:所属企业名
	 */
	@TableField(value="OWNER_COM_NAME",exist=true)
	java.lang.String ownerComName;
	
	/**
	 * 属性描述:所属量表ID
	 */
	@TableField(value="SCALE_ID",exist=true)
	java.lang.String scaleId;
	
	/**
	 * 属性描述:量表名
	 */
	@TableField(value="SCALE_NAME",exist=true)
	java.lang.String scaleName;
	
	/**
	 * 属性描述:量表描述
	 */
	@TableField(value="SCALE_DESCRIPTION",exist=true)
	java.lang.String scaleDescription;
	
	/**
	 * 属性描述:量表价格
	 */
	@TableField(value="SCALE_PRICE",exist=true)
	java.math.BigDecimal scalePrice;
	
	/**
	 * 属性描述:量表状态
	 */
	@TableField(value="SCALE_STATE",exist=true)
	java.lang.String scaleState;
	
	/**
	 * 属性描述:题目数量
	 */
	@TableField(value="QUESTION_SUM_NUM",exist=true)
	java.lang.Integer questionSumNum;
	
	/**
	 * 属性描述:已完成题数量
	 */
	@TableField(value="QUESTION_FINISHED_NUM",exist=true)
	java.lang.Integer questionFinishedNum;
	
	/**
	 * 属性描述:当前题号
	 */
	@TableField(value="CURRENT_QUESTION_NUM",exist=true)
	java.lang.Integer currentQuestionNum;
	
	/**
	 * 属性描述:分数
	 */
	@TableField(value="SCALE_SCORE",exist=true)
	java.math.BigDecimal scaleScore;
	
	/**
	 * 属性描述:小图
	 */
	@TableField(value="SMALL_IMAGE_URL",exist=true)
	java.lang.String smallImageUrl;
	
	/**
	 * 属性描述:大图
	 */
	@TableField(value="BIG_IMAGE_URL",exist=true)
	java.lang.String bigImageUrl;




	@TableField(value="RESULT_URL",exist=true)
	java.lang.String resultURL;

	/**
	 * 属性描述:开始时间
	 */
	@TableField(value="START_TIME",exist=true)
	java.util.Date startTime;
	
	/**
	 * 属性描述:结束时间
	 */
	@TableField(value="END_TIME",exist=true)
	java.util.Date endTime;
	
	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	java.lang.String dataState;


	@TableField(value="IS_REMIND",exist=true)
	java.lang.String isRemind;


	public Date getUserEndTime() {
		return userEndTime;
	}

	public void setUserEndTime(Date userEndTime) {
		this.userEndTime = userEndTime;
	}

	/**
	 * 属性描述:开始时间
	 */
	@TableField(value="USER_END_TIME",exist=true)
	java.util.Date userEndTime;


	public String getIsRemind() {
		return isRemind;
	}

	public void setIsRemind(String isRemind) {
		this.isRemind = isRemind;
	}

	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	public java.lang.String getOwnerOrderId(){
		return this.ownerOrderId;
	}
	
	public void setOwnerOrderId(java.lang.String ownerOrderId){
		this.ownerOrderId=ownerOrderId;
	}
	
	
	public java.lang.String getUserId(){
		return this.userId;
	}
	
	public void setUserId(java.lang.String userId){
		this.userId=userId;
	}
	
	
	public java.lang.String getUserType(){
		return this.userType;
	}
	
	public void setUserType(java.lang.String userType){
		this.userType=userType;
	}
	
	
	public java.lang.String getOwnerComId(){
		return this.ownerComId;
	}
	
	public void setOwnerComId(java.lang.String ownerComId){
		this.ownerComId=ownerComId;
	}
	
	
	public java.lang.String getOwnerComName(){
		return this.ownerComName;
	}
	
	public void setOwnerComName(java.lang.String ownerComName){
		this.ownerComName=ownerComName;
	}
	
	
	public java.lang.String getScaleId(){
		return this.scaleId;
	}
	
	public void setScaleId(java.lang.String scaleId){
		this.scaleId=scaleId;
	}
	
	
	public java.lang.String getScaleName(){
		return this.scaleName;
	}
	
	public void setScaleName(java.lang.String scaleName){
		this.scaleName=scaleName;
	}
	
	
	public java.lang.String getScaleDescription(){
		return this.scaleDescription;
	}
	
	public void setScaleDescription(java.lang.String scaleDescription){
		this.scaleDescription=scaleDescription;
	}
	
	
	public java.math.BigDecimal getScalePrice(){
		return this.scalePrice;
	}
	
	public void setScalePrice(java.math.BigDecimal scalePrice){
		this.scalePrice=scalePrice;
	}
	
	
	public java.lang.String getScaleState(){
		return this.scaleState;
	}
	
	public void setScaleState(java.lang.String scaleState){
		this.scaleState=scaleState;
	}
	
	
	public java.lang.Integer getQuestionSumNum(){
		return this.questionSumNum;
	}
	
	public void setQuestionSumNum(java.lang.Integer questionSumNum){
		this.questionSumNum=questionSumNum;
	}
	
	
	public java.lang.Integer getQuestionFinishedNum(){
		return this.questionFinishedNum;
	}
	
	public void setQuestionFinishedNum(java.lang.Integer questionFinishedNum){
		this.questionFinishedNum=questionFinishedNum;
	}
	
	
	public java.lang.Integer getCurrentQuestionNum(){
		return this.currentQuestionNum;
	}
	
	public void setCurrentQuestionNum(java.lang.Integer currentQuestionNum){
		this.currentQuestionNum=currentQuestionNum;
	}
	
	
	public java.math.BigDecimal getScaleScore(){
		return this.scaleScore;
	}
	
	public void setScaleScore(java.math.BigDecimal scaleScore){
		this.scaleScore=scaleScore;
	}
	
	
	public java.lang.String getSmallImageUrl(){
		return this.smallImageUrl;
	}
	
	public void setSmallImageUrl(java.lang.String smallImageUrl){
		this.smallImageUrl=smallImageUrl;
	}
	
	
	public java.lang.String getBigImageUrl(){
		return this.bigImageUrl;
	}
	
	public void setBigImageUrl(java.lang.String bigImageUrl){
		this.bigImageUrl=bigImageUrl;
	}

	public java.lang.String getResultURL() {
		return resultURL;
	}

	public void setResultURL(java.lang.String resultURL) {
		this.resultURL = resultURL;
	}

	public java.util.Date getStartTime(){
		return this.startTime;
	}
	
	public void setStartTime(java.util.Date startTime){
		this.startTime=startTime;
	}
	
	
	public java.util.Date getEndTime(){
		return this.endTime;
	}
	
	public void setEndTime(java.util.Date endTime){
		this.endTime=endTime;
	}
	
	
	public java.lang.String getDataState(){
		return this.dataState;
	}
	
	public void setDataState(java.lang.String dataState){
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
			sb.append(", ownerOrderId=").append(ownerOrderId);			
			sb.append(", userId=").append(userId);			
			sb.append(", userType=").append(userType);			
			sb.append(", ownerComId=").append(ownerComId);			
			sb.append(", ownerComName=").append(ownerComName);			
			sb.append(", scaleId=").append(scaleId);			
			sb.append(", scaleName=").append(scaleName);			
			sb.append(", scaleDescription=").append(scaleDescription);			
			sb.append(", scalePrice=").append(scalePrice);			
			sb.append(", scaleState=").append(scaleState);			
			sb.append(", questionSumNum=").append(questionSumNum);			
			sb.append(", questionFinishedNum=").append(questionFinishedNum);			
			sb.append(", currentQuestionNum=").append(currentQuestionNum);			
			sb.append(", scaleScore=").append(scaleScore);			
			sb.append(", smallImageUrl=").append(smallImageUrl);			
			sb.append(", bigImageUrl=").append(bigImageUrl);			
			sb.append(", startTime=").append(startTime);			
			sb.append(", endTime=").append(endTime);			
			sb.append(", dataState=").append(dataState);			
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
        ScaleUserScale other = (ScaleUserScale) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getOwnerOrderId() == null ? other.getId() == null : this.getOwnerOrderId().equals(other.getOwnerOrderId()))		
				        		&&(this.getUserId() == null ? other.getId() == null : this.getUserId().equals(other.getUserId()))		
				        		&&(this.getUserType() == null ? other.getId() == null : this.getUserType().equals(other.getUserType()))		
				        		&&(this.getOwnerComId() == null ? other.getId() == null : this.getOwnerComId().equals(other.getOwnerComId()))		
				        		&&(this.getOwnerComName() == null ? other.getId() == null : this.getOwnerComName().equals(other.getOwnerComName()))		
				        		&&(this.getScaleId() == null ? other.getId() == null : this.getScaleId().equals(other.getScaleId()))		
				        		&&(this.getScaleName() == null ? other.getId() == null : this.getScaleName().equals(other.getScaleName()))		
				        		&&(this.getScaleDescription() == null ? other.getId() == null : this.getScaleDescription().equals(other.getScaleDescription()))		
				        		&&(this.getScalePrice() == null ? other.getId() == null : this.getScalePrice().equals(other.getScalePrice()))		
				        		&&(this.getScaleState() == null ? other.getId() == null : this.getScaleState().equals(other.getScaleState()))		
				        		&&(this.getQuestionSumNum() == null ? other.getId() == null : this.getQuestionSumNum().equals(other.getQuestionSumNum()))		
				        		&&(this.getQuestionFinishedNum() == null ? other.getId() == null : this.getQuestionFinishedNum().equals(other.getQuestionFinishedNum()))		
				        		&&(this.getCurrentQuestionNum() == null ? other.getId() == null : this.getCurrentQuestionNum().equals(other.getCurrentQuestionNum()))		
				        		&&(this.getScaleScore() == null ? other.getId() == null : this.getScaleScore().equals(other.getScaleScore()))		
				        		&&(this.getSmallImageUrl() == null ? other.getId() == null : this.getSmallImageUrl().equals(other.getSmallImageUrl()))		
				        		&&(this.getBigImageUrl() == null ? other.getId() == null : this.getBigImageUrl().equals(other.getBigImageUrl()))		
				        		&&(this.getStartTime() == null ? other.getId() == null : this.getStartTime().equals(other.getStartTime()))		
				        		&&(this.getEndTime() == null ? other.getId() == null : this.getEndTime().equals(other.getEndTime()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getOwnerOrderId() == null) ? 0 : getOwnerOrderId().hashCode());		
		        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());		
		        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());		
		        result = prime * result + ((getOwnerComId() == null) ? 0 : getOwnerComId().hashCode());		
		        result = prime * result + ((getOwnerComName() == null) ? 0 : getOwnerComName().hashCode());		
		        result = prime * result + ((getScaleId() == null) ? 0 : getScaleId().hashCode());		
		        result = prime * result + ((getScaleName() == null) ? 0 : getScaleName().hashCode());		
		        result = prime * result + ((getScaleDescription() == null) ? 0 : getScaleDescription().hashCode());		
		        result = prime * result + ((getScalePrice() == null) ? 0 : getScalePrice().hashCode());		
		        result = prime * result + ((getScaleState() == null) ? 0 : getScaleState().hashCode());		
		        result = prime * result + ((getQuestionSumNum() == null) ? 0 : getQuestionSumNum().hashCode());		
		        result = prime * result + ((getQuestionFinishedNum() == null) ? 0 : getQuestionFinishedNum().hashCode());		
		        result = prime * result + ((getCurrentQuestionNum() == null) ? 0 : getCurrentQuestionNum().hashCode());		
		        result = prime * result + ((getScaleScore() == null) ? 0 : getScaleScore().hashCode());		
		        result = prime * result + ((getSmallImageUrl() == null) ? 0 : getSmallImageUrl().hashCode());		
		        result = prime * result + ((getBigImageUrl() == null) ? 0 : getBigImageUrl().hashCode());		
		        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());		
		        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
