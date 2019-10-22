package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_company_order")
public class ScaleCompanyOrder implements Serializable{
	
		
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
	 * 属性描述:所属企业ID
	 */
	@TableField(value="OWNER_COMPANY_ID",exist=true)
	java.lang.String ownerCompanyId;
	
	/**
	 * 属性描述:所属企业名
	 */
	@TableField(value="OWNER_COMPANY_NAME",exist=true)
	java.lang.String ownerCompanyName;
	
	/**
	 * 属性描述:量表ID
	 */
	@TableField(value="SCALE_ID",exist=true)
	java.lang.String scaleId;
	
	/**
	 * 属性描述:量表名
	 */
	@TableField(value="SCALE_NAME",exist=true)
	java.lang.String scaleName;
	
	/**
	 * 属性描述:总次数
	 */
	@TableField(value="SUM_NUM",exist=true)
	java.lang.Integer sumNum;
	
	/**
	 * 属性描述:已用数
	 */
	@TableField(value="USED_NUM",exist=true)
	java.lang.Integer usedNum;
	
	/**
	 * 属性描述:可用数
	 */
	@TableField(value="USABLE_NUM",exist=true)
	java.lang.Integer usableNum;
	
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
	
	
	public java.lang.String getOwnerCompanyId(){
		return this.ownerCompanyId;
	}
	
	public void setOwnerCompanyId(java.lang.String ownerCompanyId){
		this.ownerCompanyId=ownerCompanyId;
	}
	
	
	public java.lang.String getOwnerCompanyName(){
		return this.ownerCompanyName;
	}
	
	public void setOwnerCompanyName(java.lang.String ownerCompanyName){
		this.ownerCompanyName=ownerCompanyName;
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
	
	
	public java.lang.Integer getSumNum(){
		return this.sumNum;
	}
	
	public void setSumNum(java.lang.Integer sumNum){
		this.sumNum=sumNum;
	}
	
	
	public java.lang.Integer getUsedNum(){
		return this.usedNum;
	}
	
	public void setUsedNum(java.lang.Integer usedNum){
		this.usedNum=usedNum;
	}
	
	
	public java.lang.Integer getUsableNum(){
		return this.usableNum;
	}
	
	public void setUsableNum(java.lang.Integer usableNum){
		this.usableNum=usableNum;
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
			sb.append(", ownerCompanyId=").append(ownerCompanyId);			
			sb.append(", ownerCompanyName=").append(ownerCompanyName);			
			sb.append(", scaleId=").append(scaleId);			
			sb.append(", scaleName=").append(scaleName);			
			sb.append(", sumNum=").append(sumNum);			
			sb.append(", usedNum=").append(usedNum);			
			sb.append(", usableNum=").append(usableNum);			
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
        ScaleCompanyOrder other = (ScaleCompanyOrder) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getOwnerCompanyId() == null ? other.getId() == null : this.getOwnerCompanyId().equals(other.getOwnerCompanyId()))		
				        		&&(this.getOwnerCompanyName() == null ? other.getId() == null : this.getOwnerCompanyName().equals(other.getOwnerCompanyName()))		
				        		&&(this.getScaleId() == null ? other.getId() == null : this.getScaleId().equals(other.getScaleId()))		
				        		&&(this.getScaleName() == null ? other.getId() == null : this.getScaleName().equals(other.getScaleName()))		
				        		&&(this.getSumNum() == null ? other.getId() == null : this.getSumNum().equals(other.getSumNum()))		
				        		&&(this.getUsedNum() == null ? other.getId() == null : this.getUsedNum().equals(other.getUsedNum()))		
				        		&&(this.getUsableNum() == null ? other.getId() == null : this.getUsableNum().equals(other.getUsableNum()))		
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
		        result = prime * result + ((getOwnerCompanyId() == null) ? 0 : getOwnerCompanyId().hashCode());		
		        result = prime * result + ((getOwnerCompanyName() == null) ? 0 : getOwnerCompanyName().hashCode());		
		        result = prime * result + ((getScaleId() == null) ? 0 : getScaleId().hashCode());		
		        result = prime * result + ((getScaleName() == null) ? 0 : getScaleName().hashCode());		
		        result = prime * result + ((getSumNum() == null) ? 0 : getSumNum().hashCode());		
		        result = prime * result + ((getUsedNum() == null) ? 0 : getUsedNum().hashCode());		
		        result = prime * result + ((getUsableNum() == null) ? 0 : getUsableNum().hashCode());		
		        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());		
		        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
