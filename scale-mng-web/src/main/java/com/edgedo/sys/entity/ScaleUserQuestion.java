package com.edgedo.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("scale_user_question")
public class ScaleUserQuestion implements Serializable{
	
		
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
	 * 属性描述:题号
	 */
	@TableField(value="QUESTION_NUM",exist=true)
	Integer questionNum;

	/**
	 * 属性描述:题目描述
	 */
	@TableField(value="QUESTION_DESC",exist=true)
	String questionDesc;

	/**
	 * 属性描述:是否完成
	 */
	@TableField(value="IS_FINISHED",exist=true)
	String isFinished;

	/**
	 * 属性描述:题目得分
	 */
	@TableField(value="QUESTION_GET_SCORE",exist=true)
	java.math.BigDecimal questionGetScore;

	/**
	 * 属性描述:所属用户ID
	 */
	@TableField(value="USER_ID",exist=true)
	String userId;

	/**
	 * 属性描述:所属用户问卷ID
	 */
	@TableField(value="OWNER_USER_SCALE_ID",exist=true)
	String ownerUserScaleId;

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


	public Integer getQuestionNum(){
		return this.questionNum;
	}

	public void setQuestionNum(Integer questionNum){
		this.questionNum=questionNum;
	}


	public String getQuestionDesc(){
		return this.questionDesc;
	}

	public void setQuestionDesc(String questionDesc){
		this.questionDesc=questionDesc;
	}


	public String getIsFinished(){
		return this.isFinished;
	}

	public void setIsFinished(String isFinished){
		this.isFinished=isFinished;
	}


	public java.math.BigDecimal getQuestionGetScore(){
		return this.questionGetScore;
	}

	public void setQuestionGetScore(java.math.BigDecimal questionGetScore){
		this.questionGetScore=questionGetScore;
	}


	public String getUserId(){
		return this.userId;
	}

	public void setUserId(String userId){
		this.userId=userId;
	}


	public String getOwnerUserScaleId(){
		return this.ownerUserScaleId;
	}

	public void setOwnerUserScaleId(String ownerUserScaleId){
		this.ownerUserScaleId=ownerUserScaleId;
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
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", questionNum=").append(questionNum);			
			sb.append(", questionDesc=").append(questionDesc);			
			sb.append(", isFinished=").append(isFinished);			
			sb.append(", questionGetScore=").append(questionGetScore);			
			sb.append(", userId=").append(userId);			
			sb.append(", ownerUserScaleId=").append(ownerUserScaleId);			
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
        ScaleUserQuestion other = (ScaleUserQuestion) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getQuestionNum() == null ? other.getId() == null : this.getQuestionNum().equals(other.getQuestionNum()))		
				        		&&(this.getQuestionDesc() == null ? other.getId() == null : this.getQuestionDesc().equals(other.getQuestionDesc()))		
				        		&&(this.getIsFinished() == null ? other.getId() == null : this.getIsFinished().equals(other.getIsFinished()))		
				        		&&(this.getQuestionGetScore() == null ? other.getId() == null : this.getQuestionGetScore().equals(other.getQuestionGetScore()))		
				        		&&(this.getUserId() == null ? other.getId() == null : this.getUserId().equals(other.getUserId()))		
				        		&&(this.getOwnerUserScaleId() == null ? other.getId() == null : this.getOwnerUserScaleId().equals(other.getOwnerUserScaleId()))		
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
		        result = prime * result + ((getQuestionNum() == null) ? 0 : getQuestionNum().hashCode());		
		        result = prime * result + ((getQuestionDesc() == null) ? 0 : getQuestionDesc().hashCode());		
		        result = prime * result + ((getIsFinished() == null) ? 0 : getIsFinished().hashCode());		
		        result = prime * result + ((getQuestionGetScore() == null) ? 0 : getQuestionGetScore().hashCode());		
		        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());		
		        result = prime * result + ((getOwnerUserScaleId() == null) ? 0 : getOwnerUserScaleId().hashCode());		
		        result = prime * result + ((getOwnerScaleId() == null) ? 0 : getOwnerScaleId().hashCode());		
		        result = prime * result + ((getOwnerScaleName() == null) ? 0 : getOwnerScaleName().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
