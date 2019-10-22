package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_question_option")
public class ScaleQuestionOption implements Serializable{
	
		
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
	 * 属性描述:序号
	 */
	@TableField(value="OPTION_NUM",exist=true)
	java.lang.Integer optionNum;
	
	/**
	 * 属性描述:选项描述
	 */
	@TableField(value="OPTION_DESC",exist=true)
	java.lang.String optionDesc;
	
	/**
	 * 属性描述:分数
	 */
	@TableField(value="OPTION_SCORE",exist=true)
	java.math.BigDecimal optionScore;
	
	/**
	 * 属性描述:所属题目ID
	 */
	@TableField(value="OWNER_QUESTION_ID",exist=true)
	java.lang.String ownerQuestionId;
	
	/**
	 * 属性描述:所属题目描述
	 */
	@TableField(value="OWNER_QUESTION_DESC",exist=true)
	java.lang.String ownerQuestionDesc;
	
	/**
	 * 属性描述:所属量表ID
	 */
	@TableField(value="OWNER_SCALE_ID",exist=true)
	java.lang.String ownerScaleId;
	
	/**
	 * 属性描述:所属量表NAME
	 */
	@TableField(value="OWNER_SCALE_NAME",exist=true)
	java.lang.String ownerScaleName;
	
	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	java.lang.String dataState;
	
	
	
	
	
	
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
	
	
	public java.lang.Integer getOptionNum(){
		return this.optionNum;
	}
	
	public void setOptionNum(java.lang.Integer optionNum){
		this.optionNum=optionNum;
	}
	
	
	public java.lang.String getOptionDesc(){
		return this.optionDesc;
	}
	
	public void setOptionDesc(java.lang.String optionDesc){
		this.optionDesc=optionDesc;
	}
	
	
	public java.math.BigDecimal getOptionScore(){
		return this.optionScore;
	}
	
	public void setOptionScore(java.math.BigDecimal optionScore){
		this.optionScore=optionScore;
	}
	
	
	public java.lang.String getOwnerQuestionId(){
		return this.ownerQuestionId;
	}
	
	public void setOwnerQuestionId(java.lang.String ownerQuestionId){
		this.ownerQuestionId=ownerQuestionId;
	}
	
	
	public java.lang.String getOwnerQuestionDesc(){
		return this.ownerQuestionDesc;
	}
	
	public void setOwnerQuestionDesc(java.lang.String ownerQuestionDesc){
		this.ownerQuestionDesc=ownerQuestionDesc;
	}
	
	
	public java.lang.String getOwnerScaleId(){
		return this.ownerScaleId;
	}
	
	public void setOwnerScaleId(java.lang.String ownerScaleId){
		this.ownerScaleId=ownerScaleId;
	}
	
	
	public java.lang.String getOwnerScaleName(){
		return this.ownerScaleName;
	}
	
	public void setOwnerScaleName(java.lang.String ownerScaleName){
		this.ownerScaleName=ownerScaleName;
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
			sb.append(", optionNum=").append(optionNum);			
			sb.append(", optionDesc=").append(optionDesc);			
			sb.append(", optionScore=").append(optionScore);			
			sb.append(", ownerQuestionId=").append(ownerQuestionId);			
			sb.append(", ownerQuestionDesc=").append(ownerQuestionDesc);			
			sb.append(", ownerScaleId=").append(ownerScaleId);			
			sb.append(", ownerScaleName=").append(ownerScaleName);			
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
        ScaleQuestionOption other = (ScaleQuestionOption) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getOptionNum() == null ? other.getId() == null : this.getOptionNum().equals(other.getOptionNum()))		
				        		&&(this.getOptionDesc() == null ? other.getId() == null : this.getOptionDesc().equals(other.getOptionDesc()))		
				        		&&(this.getOptionScore() == null ? other.getId() == null : this.getOptionScore().equals(other.getOptionScore()))		
				        		&&(this.getOwnerQuestionId() == null ? other.getId() == null : this.getOwnerQuestionId().equals(other.getOwnerQuestionId()))		
				        		&&(this.getOwnerQuestionDesc() == null ? other.getId() == null : this.getOwnerQuestionDesc().equals(other.getOwnerQuestionDesc()))		
				        		&&(this.getOwnerScaleId() == null ? other.getId() == null : this.getOwnerScaleId().equals(other.getOwnerScaleId()))		
				        		&&(this.getOwnerScaleName() == null ? other.getId() == null : this.getOwnerScaleName().equals(other.getOwnerScaleName()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
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
		        result = prime * result + ((getOwnerQuestionId() == null) ? 0 : getOwnerQuestionId().hashCode());		
		        result = prime * result + ((getOwnerQuestionDesc() == null) ? 0 : getOwnerQuestionDesc().hashCode());		
		        result = prime * result + ((getOwnerScaleId() == null) ? 0 : getOwnerScaleId().hashCode());		
		        result = prime * result + ((getOwnerScaleName() == null) ? 0 : getOwnerScaleName().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
