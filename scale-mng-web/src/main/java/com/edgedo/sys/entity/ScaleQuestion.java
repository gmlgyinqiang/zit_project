package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_question")
public class ScaleQuestion implements Serializable{
	
		
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
	 * 属性描述:题号
	 */
	@TableField(value="QUESTION_NUM",exist=true)
	java.lang.Integer questionNum;
	
	/**
	 * 属性描述:题目描述
	 */
	@TableField(value="QUESTION_DESC",exist=true)
	java.lang.String questionDesc;
	
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
	
	
	public java.lang.Integer getQuestionNum(){
		return this.questionNum;
	}
	
	public void setQuestionNum(java.lang.Integer questionNum){
		this.questionNum=questionNum;
	}
	
	
	public java.lang.String getQuestionDesc(){
		return this.questionDesc;
	}
	
	public void setQuestionDesc(java.lang.String questionDesc){
		this.questionDesc=questionDesc;
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
			sb.append(", questionNum=").append(questionNum);			
			sb.append(", questionDesc=").append(questionDesc);			
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
        ScaleQuestion other = (ScaleQuestion) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getQuestionNum() == null ? other.getId() == null : this.getQuestionNum().equals(other.getQuestionNum()))		
				        		&&(this.getQuestionDesc() == null ? other.getId() == null : this.getQuestionDesc().equals(other.getQuestionDesc()))		
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
		        result = prime * result + ((getOwnerScaleId() == null) ? 0 : getOwnerScaleId().hashCode());		
		        result = prime * result + ((getOwnerScaleName() == null) ? 0 : getOwnerScaleName().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
