package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_company")
public class ScaleCompany implements Serializable{
	
		
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
	 * 属性描述:企业名
	 */
	@TableField(value="COMPANY_NAME",exist=true)
	String companyName;

	/**
	 * 属性描述:企业账号id
	 */
	@TableField(value="SYS_USER_ID",exist=true)
	String sysUserId;

	/**
	 * 属性描述:企业账号
	 */
	@TableField(value="SYS_USER_CODE",exist=true)
	String sysUserCode;
	
	/**
	 * 属性描述:企业描述
	 */
	@TableField(value="COMPANY_DESC",exist=true)
	String companyDesc;
	
	/**
	 * 属性描述:邮箱文案描述
	 */
	@TableField(value="COMPANY_MSG_DESC",exist=true)
	String companyMsgDesc;
	
	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	String dataState;
	
	public String getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getSysUserCode() {
		return sysUserCode;
	}

	public void setSysUserCode(String sysUserCode) {
		this.sysUserCode = sysUserCode;
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
	
	
	public String getCompanyName(){
		return this.companyName;
	}
	
	public void setCompanyName(String companyName){
		this.companyName=companyName;
	}
	
	
	public String getCompanyDesc(){
		return this.companyDesc;
	}
	
	public void setCompanyDesc(String companyDesc){
		this.companyDesc=companyDesc;
	}
	
	
	public String getDataState(){
		return this.dataState;
	}
	
	public void setDataState(String dataState){
		this.dataState=dataState;
	}
	
	
    public String getCompanyMsgDesc() {
		return companyMsgDesc;
	}

	public void setCompanyMsgDesc(String companyMsgDesc) {
		this.companyMsgDesc = companyMsgDesc;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", companyName=").append(companyName);			
			sb.append(", companyDesc=").append(companyDesc);
			sb.append(", companyMsgDesc=").append(companyMsgDesc);
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
        ScaleCompany other = (ScaleCompany) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCompanyName() == null ? other.getId() == null : this.getCompanyName().equals(other.getCompanyName()))		
				        		&&(this.getCompanyDesc() == null ? other.getId() == null : this.getCompanyDesc().equals(other.getCompanyDesc()))
				        		&&(this.getCompanyMsgDesc() == null ? other.getId() == null : this.getCompanyMsgDesc().equals(other.getCompanyMsgDesc()))
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());		
		        result = prime * result + ((getCompanyDesc() == null) ? 0 : getCompanyDesc().hashCode());
		        result = prime * result + ((getCompanyMsgDesc() == null) ? 0 : getCompanyMsgDesc().hashCode());
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
