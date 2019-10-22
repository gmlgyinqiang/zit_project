package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_signatrue")
public class ScaleSignatrue implements Serializable{
	
		
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
	 * 属性描述:签名地址
	 */
	@TableField(value="SIGNARUTE_ADDRESS",exist=true)
	java.lang.String signaruteAddress;
	
	/**
	 * 属性描述:医生姓名
	 */
	@TableField(value="DOCTOR_NAME",exist=true)
	java.lang.String doctorName;
	
	/**
	 * 属性描述:dateState
	 */
	@TableField(value="DATE_STATE",exist=true)
	java.lang.String dateState;
	
	
	
	
	
	
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
	
	
	public java.lang.String getSignaruteAddress(){
		return this.signaruteAddress;
	}
	
	public void setSignaruteAddress(java.lang.String signaruteAddress){
		this.signaruteAddress=signaruteAddress;
	}
	
	
	public java.lang.String getDoctorName(){
		return this.doctorName;
	}
	
	public void setDoctorName(java.lang.String doctorName){
		this.doctorName=doctorName;
	}
	
	
	public java.lang.String getDateState(){
		return this.dateState;
	}
	
	public void setDateState(java.lang.String dateState){
		this.dateState=dateState;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", signaruteAddress=").append(signaruteAddress);			
			sb.append(", doctorName=").append(doctorName);			
			sb.append(", dateState=").append(dateState);			
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
        ScaleSignatrue other = (ScaleSignatrue) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getSignaruteAddress() == null ? other.getId() == null : this.getSignaruteAddress().equals(other.getSignaruteAddress()))		
				        		&&(this.getDoctorName() == null ? other.getId() == null : this.getDoctorName().equals(other.getDoctorName()))		
				        		&&(this.getDateState() == null ? other.getId() == null : this.getDateState().equals(other.getDateState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getSignaruteAddress() == null) ? 0 : getSignaruteAddress().hashCode());		
		        result = prime * result + ((getDoctorName() == null) ? 0 : getDoctorName().hashCode());		
		        result = prime * result + ((getDateState() == null) ? 0 : getDateState().hashCode());		
		;
        return result;
    }

}
