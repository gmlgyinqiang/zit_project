package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_user_message")
public class ScaleUserMessage implements Serializable{
	
		
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
	 * 属性描述:所属用户ID
	 */
	@TableField(value="OWNER_USER_ID",exist=true)
	java.lang.String ownerUserId;
	
	/**
	 * 属性描述:消息标题
	 */
	@TableField(value="MESSAGE_TITLE",exist=true)
	java.lang.String messageTitle;
	
	/**
	 * 属性描述:消息内容
	 */
	@TableField(value="MESSAGE_TEXT",exist=true)
	java.lang.String messageText;
	
	/**
	 * 属性描述:消息类型
	 */
	@TableField(value="MESSAGE_TYPE",exist=true)
	java.lang.String messageType;
	
	/**
	 * 属性描述:备注
	 */
	@TableField(value="REMARK",exist=true)
	java.lang.String remark;
	
	/**
	 * 属性描述:是否已读
	 */
	@TableField(value="IS_READ",exist=true)
	java.lang.String isRead;
	
	/**
	 * 属性描述:发送时间
	 */
	@TableField(value="SEND_TIME",exist=true)
	java.util.Date sendTime;
	
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
	
	
	public java.lang.String getOwnerUserId(){
		return this.ownerUserId;
	}
	
	public void setOwnerUserId(java.lang.String ownerUserId){
		this.ownerUserId=ownerUserId;
	}
	
	
	public java.lang.String getMessageTitle(){
		return this.messageTitle;
	}
	
	public void setMessageTitle(java.lang.String messageTitle){
		this.messageTitle=messageTitle;
	}
	
	
	public java.lang.String getMessageText(){
		return this.messageText;
	}
	
	public void setMessageText(java.lang.String messageText){
		this.messageText=messageText;
	}
	
	
	public java.lang.String getMessageType(){
		return this.messageType;
	}
	
	public void setMessageType(java.lang.String messageType){
		this.messageType=messageType;
	}
	
	
	public java.lang.String getRemark(){
		return this.remark;
	}
	
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	
	
	public java.lang.String getIsRead(){
		return this.isRead;
	}
	
	public void setIsRead(java.lang.String isRead){
		this.isRead=isRead;
	}
	
	
	public java.util.Date getSendTime(){
		return this.sendTime;
	}
	
	public void setSendTime(java.util.Date sendTime){
		this.sendTime=sendTime;
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
			sb.append(", ownerUserId=").append(ownerUserId);			
			sb.append(", messageTitle=").append(messageTitle);			
			sb.append(", messageText=").append(messageText);			
			sb.append(", messageType=").append(messageType);			
			sb.append(", remark=").append(remark);			
			sb.append(", isRead=").append(isRead);			
			sb.append(", sendTime=").append(sendTime);			
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
        ScaleUserMessage other = (ScaleUserMessage) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getOwnerUserId() == null ? other.getId() == null : this.getOwnerUserId().equals(other.getOwnerUserId()))		
				        		&&(this.getMessageTitle() == null ? other.getId() == null : this.getMessageTitle().equals(other.getMessageTitle()))		
				        		&&(this.getMessageText() == null ? other.getId() == null : this.getMessageText().equals(other.getMessageText()))		
				        		&&(this.getMessageType() == null ? other.getId() == null : this.getMessageType().equals(other.getMessageType()))		
				        		&&(this.getRemark() == null ? other.getId() == null : this.getRemark().equals(other.getRemark()))		
				        		&&(this.getIsRead() == null ? other.getId() == null : this.getIsRead().equals(other.getIsRead()))		
				        		&&(this.getSendTime() == null ? other.getId() == null : this.getSendTime().equals(other.getSendTime()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getOwnerUserId() == null) ? 0 : getOwnerUserId().hashCode());		
		        result = prime * result + ((getMessageTitle() == null) ? 0 : getMessageTitle().hashCode());		
		        result = prime * result + ((getMessageText() == null) ? 0 : getMessageText().hashCode());		
		        result = prime * result + ((getMessageType() == null) ? 0 : getMessageType().hashCode());		
		        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());		
		        result = prime * result + ((getIsRead() == null) ? 0 : getIsRead().hashCode());		
		        result = prime * result + ((getSendTime() == null) ? 0 : getSendTime().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
