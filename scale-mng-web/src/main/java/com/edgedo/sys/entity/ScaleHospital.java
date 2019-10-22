package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_hospital")
public class ScaleHospital implements Serializable{
	
		
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
	 * 属性描述:医院名
	 */
	@TableField(value="HOSPITAL_NAME",exist=true)
	java.lang.String hospitalName;
	
	/**
	 * 属性描述:医院描述
	 */
	@TableField(value="HOSPITAL_DESC",exist=true)
	java.lang.String hospitalDesc;
	
	/**
	 * 属性描述:医院地址
	 */
	@TableField(value="HOSPITAL_ADDRESS",exist=true)
	java.lang.String hospitalAddress;
	
	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	java.lang.String dataState;

	/**
	 * 属性描述:打开方式
	 */
	@TableField(value="OPEN_TYPE",exist=true)
	String openType;

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
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
	
	
	public java.lang.String getHospitalName(){
		return this.hospitalName;
	}
	
	public void setHospitalName(java.lang.String hospitalName){
		this.hospitalName=hospitalName;
	}
	
	
	public java.lang.String getHospitalDesc(){
		return this.hospitalDesc;
	}
	
	public void setHospitalDesc(java.lang.String hospitalDesc){
		this.hospitalDesc=hospitalDesc;
	}
	
	
	public java.lang.String getHospitalAddress(){
		return this.hospitalAddress;
	}
	
	public void setHospitalAddress(java.lang.String hospitalAddress){
		this.hospitalAddress=hospitalAddress;
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
			sb.append(", hospitalName=").append(hospitalName);			
			sb.append(", hospitalDesc=").append(hospitalDesc);			
			sb.append(", hospitalAddress=").append(hospitalAddress);			
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
        ScaleHospital other = (ScaleHospital) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getHospitalName() == null ? other.getId() == null : this.getHospitalName().equals(other.getHospitalName()))		
				        		&&(this.getHospitalDesc() == null ? other.getId() == null : this.getHospitalDesc().equals(other.getHospitalDesc()))		
				        		&&(this.getHospitalAddress() == null ? other.getId() == null : this.getHospitalAddress().equals(other.getHospitalAddress()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getHospitalName() == null) ? 0 : getHospitalName().hashCode());		
		        result = prime * result + ((getHospitalDesc() == null) ? 0 : getHospitalDesc().hashCode());		
		        result = prime * result + ((getHospitalAddress() == null) ? 0 : getHospitalAddress().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
