package com.edgedo.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("scale_user_question_option")
public class ScaleUserQuestionOption implements Serializable{
	
		
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
	 * 属性描述:序号
	 */
	@TableField(value="OPTION_NUM",exist=true)
	Integer optionNum;

	/**
	 * 属性描述:选项描述
	 */
	@TableField(value="OPTION_DESC",exist=true)
	String optionDesc;

	/**
	 * 属性描述:分数
	 */
	@TableField(value="OPTION_SCORE",exist=true)
	java.math.BigDecimal optionScore;

	/**
	 * 属性描述:是否选中
	 */
	@TableField(value="IS_CHECKED",exist=true)
	String isChecked;

	/**
	 * 属性描述:所属用户题目ID
	 */
	@TableField(value="OWNER_USER_QUESTION_ID",exist=true)
	String ownerUserQuestionId;

	/**
	 * 属性描述:所属题目描述
	 */
	@TableField(value="OWNER_QUESTION_DESC",exist=true)
	String ownerQuestionDesc;

	/**
	 * 属性描述:所属用户ID
	 */
	@TableField(value="USER_ID",exist=true)
	String userId;

	/**
	 * 属性描述:所属量表ID
	 */
	@TableField(value="OWNER_SCALE_ID",exist=true)
	String ownerScaleId;

	/**
	 * 属性描述:所属量表NAME
	 */
	@TableField(value="OWNER_SCALE_NAME",exist=true)
	String ownerScaleName;

	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	String dataState;

	/**
	 * 属性描述:所属题目ID
	 */
	@TableField(value="OWNER_QUESTION_ID",exist=true)
	String ownerQuestionId;






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


	public Integer getOptionNum(){
		return this.optionNum;
	}

	public void setOptionNum(Integer optionNum){
		this.optionNum=optionNum;
	}


	public String getOptionDesc(){
		return this.optionDesc;
	}

	public void setOptionDesc(String optionDesc){
		this.optionDesc=optionDesc;
	}


	public java.math.BigDecimal getOptionScore(){
		return this.optionScore;
	}

	public void setOptionScore(java.math.BigDecimal optionScore){
		this.optionScore=optionScore;
	}


	public String getIsChecked(){
		return this.isChecked;
	}

	public void setIsChecked(String isChecked){
		this.isChecked=isChecked;
	}


	public String getOwnerUserQuestionId(){
		return this.ownerUserQuestionId;
	}

	public void setOwnerUserQuestionId(String ownerUserQuestionId){
		this.ownerUserQuestionId=ownerUserQuestionId;
	}


	public String getOwnerQuestionDesc(){
		return this.ownerQuestionDesc;
	}

	public void setOwnerQuestionDesc(String ownerQuestionDesc){
		this.ownerQuestionDesc=ownerQuestionDesc;
	}


	public String getUserId(){
		return this.userId;
	}

	public void setUserId(String userId){
		this.userId=userId;
	}


	public String getOwnerScaleId(){
		return this.ownerScaleId;
	}

	public void setOwnerScaleId(String ownerScaleId){
		this.ownerScaleId=ownerScaleId;
	}


	public String getOwnerScaleName(){
		return this.ownerScaleName;
	}

	public void setOwnerScaleName(String ownerScaleName){
		this.ownerScaleName=ownerScaleName;
	}


	public String getDataState(){
		return this.dataState;
	}

	public void setDataState(String dataState){
		this.dataState=dataState;
	}


	public String getOwnerQuestionId(){
		return this.ownerQuestionId;
	}

	public void setOwnerQuestionId(String ownerQuestionId){
		this.ownerQuestionId=ownerQuestionId;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", optionNum=").append(optionNum);			
			sb.append(", optionDesc=").append(optionDesc);			
			sb.append(", optionScore=").append(optionScore);			
			sb.append(", isChecked=").append(isChecked);			
			sb.append(", ownerUserQuestionId=").append(ownerUserQuestionId);			
			sb.append(", ownerQuestionDesc=").append(ownerQuestionDesc);			
			sb.append(", userId=").append(userId);			
			sb.append(", ownerScaleId=").append(ownerScaleId);			
			sb.append(", ownerScaleName=").append(ownerScaleName);			
			sb.append(", dataState=").append(dataState);			
			sb.append(", ownerQuestionId=").append(ownerQuestionId);			
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
        ScaleUserQuestionOption other = (ScaleUserQuestionOption) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getOptionNum() == null ? other.getId() == null : this.getOptionNum().equals(other.getOptionNum()))		
				        		&&(this.getOptionDesc() == null ? other.getId() == null : this.getOptionDesc().equals(other.getOptionDesc()))		
				        		&&(this.getOptionScore() == null ? other.getId() == null : this.getOptionScore().equals(other.getOptionScore()))		
				        		&&(this.getIsChecked() == null ? other.getId() == null : this.getIsChecked().equals(other.getIsChecked()))		
				        		&&(this.getOwnerUserQuestionId() == null ? other.getId() == null : this.getOwnerUserQuestionId().equals(other.getOwnerUserQuestionId()))		
				        		&&(this.getOwnerQuestionDesc() == null ? other.getId() == null : this.getOwnerQuestionDesc().equals(other.getOwnerQuestionDesc()))		
				        		&&(this.getUserId() == null ? other.getId() == null : this.getUserId().equals(other.getUserId()))		
				        		&&(this.getOwnerScaleId() == null ? other.getId() == null : this.getOwnerScaleId().equals(other.getOwnerScaleId()))		
				        		&&(this.getOwnerScaleName() == null ? other.getId() == null : this.getOwnerScaleName().equals(other.getOwnerScaleName()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				        		&&(this.getOwnerQuestionId() == null ? other.getId() == null : this.getOwnerQuestionId().equals(other.getOwnerQuestionId()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getOptionNum() == null) ? 0 : getOptionNum().hashCode());		
		        result = prime * result + ((getOptionDesc() == null) ? 0 : getOptionDesc().hashCode());		
		        result = prime * result + ((getOptionScore() == null) ? 0 : getOptionScore().hashCode());		
		        result = prime * result + ((getIsChecked() == null) ? 0 : getIsChecked().hashCode());		
		        result = prime * result + ((getOwnerUserQuestionId() == null) ? 0 : getOwnerUserQuestionId().hashCode());		
		        result = prime * result + ((getOwnerQuestionDesc() == null) ? 0 : getOwnerQuestionDesc().hashCode());		
		        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());		
		        result = prime * result + ((getOwnerScaleId() == null) ? 0 : getOwnerScaleId().hashCode());		
		        result = prime * result + ((getOwnerScaleName() == null) ? 0 : getOwnerScaleName().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		        result = prime * result + ((getOwnerQuestionId() == null) ? 0 : getOwnerQuestionId().hashCode());		
		;
        return result;
    }

}
