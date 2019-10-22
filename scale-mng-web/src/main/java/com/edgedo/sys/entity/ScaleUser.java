package com.edgedo.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("scale_user")
public class ScaleUser implements Serializable{
	
		
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
	 * 属性描述:用户名
	 */
	@TableField(value="USER_NAME",exist=true)
	String userName;

	/**
	 * 属性描述:性别
	 */
	@TableField(value="USER_SEX",exist=true)
	String userSex;

	/**
	 * 属性描述:年龄
	 */
	@TableField(value="USER_AGE",exist=true)
	String userAge;

	/**
	 * 属性描述:手机号
	 */
	@TableField(value="PHONE_NUM",exist=true)
	String phoneNum;

	/**
	 * 属性描述:邮箱
	 */
	@TableField(value="USER_EMAIL",exist=true)
	String userEmail;

	/**
	 * 属性描述:部门
	 */
	@TableField(value="USER_DEPARTMENT",exist=true)
	String userDepartment;

	/**
	 * 属性描述:工号
	 */
	@TableField(value="JOB_NUMBER",exist=true)
	String jobNumber;

	/**
	 * 属性描述:用户类型
	 */
	@TableField(value="USER_TYPE",exist=true)
	String userType;

	/**
	 * 属性描述:所属企业ID
	 */
	@TableField(value="OWNER_COM_ID",exist=true)
	String ownerComId;

	/**
	 * 属性描述:所属企业名
	 */
	@TableField(value="OWNER_COM_NAME",exist=true)
	String ownerComName;

	/**
	 * 属性描述:用户状态
	 */
	@TableField(value="USER_STATE",exist=true)
	String userState;


	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
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


	public String getUserName(){
		return this.userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}


	public String getUserSex(){
		return this.userSex;
	}

	public void setUserSex(String userSex){
		this.userSex=userSex;
	}


	public String getUserAge(){
		return this.userAge;
	}

	public void setUserAge(String userAge){
		this.userAge=userAge;
	}


	public String getPhoneNum(){
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum){
		this.phoneNum=phoneNum;
	}


	public String getUserType(){
		return this.userType;
	}

	public void setUserType(String userType){
		this.userType=userType;
	}


	public String getOwnerComId(){
		return this.ownerComId;
	}

	public void setOwnerComId(String ownerComId){
		this.ownerComId=ownerComId;
	}


	public String getOwnerComName(){
		return this.ownerComName;
	}

	public void setOwnerComName(String ownerComName){
		this.ownerComName=ownerComName;
	}


	public String getUserState(){
		return this.userState;
	}

	public void setUserState(String userState){
		this.userState=userState;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", userName=").append(userName);			
			sb.append(", userSex=").append(userSex);			
			sb.append(", userAge=").append(userAge);			
			sb.append(", phoneNum=").append(phoneNum);			
			sb.append(", userType=").append(userType);			
			sb.append(", ownerComId=").append(ownerComId);			
			sb.append(", ownerComName=").append(ownerComName);
			sb.append(", userEmail=").append(userEmail);
			sb.append(", userDepartment=").append(userDepartment);
			sb.append(", jobNumber=").append(jobNumber);
			sb.append(", userState=").append(userState);			
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
        ScaleUser other = (ScaleUser) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getUserName() == null ? other.getId() == null : this.getUserName().equals(other.getUserName()))		
				        		&&(this.getUserSex() == null ? other.getId() == null : this.getUserSex().equals(other.getUserSex()))		
				        		&&(this.getUserAge() == null ? other.getId() == null : this.getUserAge().equals(other.getUserAge()))		
				        		&&(this.getPhoneNum() == null ? other.getId() == null : this.getPhoneNum().equals(other.getPhoneNum()))		
				        		&&(this.getUserType() == null ? other.getId() == null : this.getUserType().equals(other.getUserType()))		
				        		&&(this.getOwnerComId() == null ? other.getId() == null : this.getOwnerComId().equals(other.getOwnerComId()))		
				        		&&(this.getOwnerComName() == null ? other.getId() == null : this.getOwnerComName().equals(other.getOwnerComName()))
								&&(this.getUserEmail() == null ? other.getId() == null : this.getUserEmail().equals(other.getUserEmail()))
								&&(this.getUserDepartment() == null ? other.getId() == null : this.getUserDepartment().equals(other.getUserDepartment()))
								&&(this.getJobNumber() == null ? other.getId() == null : this.getJobNumber().equals(other.getJobNumber()))
				        		&&(this.getUserState() == null ? other.getId() == null : this.getUserState().equals(other.getUserState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());		
		        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());		
		        result = prime * result + ((getUserAge() == null) ? 0 : getUserAge().hashCode());		
		        result = prime * result + ((getPhoneNum() == null) ? 0 : getPhoneNum().hashCode());		
		        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());		
		        result = prime * result + ((getOwnerComId() == null) ? 0 : getOwnerComId().hashCode());		
		        result = prime * result + ((getOwnerComName() == null) ? 0 : getOwnerComName().hashCode());
				result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
				result = prime * result + ((getUserDepartment() == null) ? 0 : getUserDepartment().hashCode());
				result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
		        result = prime * result + ((getUserState() == null) ? 0 : getUserState().hashCode());		
		;
        return result;
    }

}
