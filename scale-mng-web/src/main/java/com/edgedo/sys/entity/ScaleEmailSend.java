package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_email_send")
public class ScaleEmailSend implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:用户名
	 */
	@TableField(value="USER_NAME",exist=true)
	java.lang.String userName;
	
	/**
	 * 属性描述:手机号
	 */
	@TableField(value="PHONE_NUM",exist=true)
	java.lang.String phoneNum;
	
	/**
	 * 属性描述:邮箱号
	 */
	@TableField(value="USER_EMAIL",exist=true)
	java.lang.String userEmail;
	
	/**
	 * 属性描述:发送时间
	 */
	@TableField(value="SEBD_TIME",exist=true)
	java.util.Date sebdTime;
	
	/**
	 * 属性描述:发送状态
	 */
	@TableField(value="SEND_STATE",exist=true)
	java.lang.String sendState;
	
	/**
	 * 属性描述:公司名称
	 */
	@TableField(value="COMPANY_NAME",exist=true)
	java.lang.String companyName;
	
	/**
	 * 属性描述:测试结果
	 */
	@TableField(value="TEST_RESULT",exist=true)
	java.lang.String testResult;
	
	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATE_STATE",exist=true)
	java.lang.String dateState;
	
	
	
	
	
	
	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.lang.String getUserName(){
		return this.userName;
	}
	
	public void setUserName(java.lang.String userName){
		this.userName=userName;
	}
	
	
	public java.lang.String getPhoneNum(){
		return this.phoneNum;
	}
	
	public void setPhoneNum(java.lang.String phoneNum){
		this.phoneNum=phoneNum;
	}
	
	
	public java.lang.String getUserEmail(){
		return this.userEmail;
	}
	
	public void setUserEmail(java.lang.String userEmail){
		this.userEmail=userEmail;
	}
	
	
	public java.util.Date getSebdTime(){
		return this.sebdTime;
	}
	
	public void setSebdTime(java.util.Date sebdTime){
		this.sebdTime=sebdTime;
	}
	
	
	public java.lang.String getSendState(){
		return this.sendState;
	}
	
	public void setSendState(java.lang.String sendState){
		this.sendState=sendState;
	}
	
	
	public java.lang.String getCompanyName(){
		return this.companyName;
	}
	
	public void setCompanyName(java.lang.String companyName){
		this.companyName=companyName;
	}
	
	
	public java.lang.String getTestResult(){
		return this.testResult;
	}
	
	public void setTestResult(java.lang.String testResult){
		this.testResult=testResult;
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
			sb.append(", userName=").append(userName);			
			sb.append(", phoneNum=").append(phoneNum);			
			sb.append(", userEmail=").append(userEmail);			
			sb.append(", sebdTime=").append(sebdTime);			
			sb.append(", sendState=").append(sendState);			
			sb.append(", companyName=").append(companyName);			
			sb.append(", testResult=").append(testResult);			
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
        ScaleEmailSend other = (ScaleEmailSend) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getUserName() == null ? other.getId() == null : this.getUserName().equals(other.getUserName()))		
				        		&&(this.getPhoneNum() == null ? other.getId() == null : this.getPhoneNum().equals(other.getPhoneNum()))		
				        		&&(this.getUserEmail() == null ? other.getId() == null : this.getUserEmail().equals(other.getUserEmail()))		
				        		&&(this.getSebdTime() == null ? other.getId() == null : this.getSebdTime().equals(other.getSebdTime()))		
				        		&&(this.getSendState() == null ? other.getId() == null : this.getSendState().equals(other.getSendState()))		
				        		&&(this.getCompanyName() == null ? other.getId() == null : this.getCompanyName().equals(other.getCompanyName()))		
				        		&&(this.getTestResult() == null ? other.getId() == null : this.getTestResult().equals(other.getTestResult()))		
				        		&&(this.getDateState() == null ? other.getId() == null : this.getDateState().equals(other.getDateState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());		
		        result = prime * result + ((getPhoneNum() == null) ? 0 : getPhoneNum().hashCode());		
		        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());		
		        result = prime * result + ((getSebdTime() == null) ? 0 : getSebdTime().hashCode());		
		        result = prime * result + ((getSendState() == null) ? 0 : getSendState().hashCode());		
		        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());		
		        result = prime * result + ((getTestResult() == null) ? 0 : getTestResult().hashCode());		
		        result = prime * result + ((getDateState() == null) ? 0 : getDateState().hashCode());		
		;
        return result;
    }

}
