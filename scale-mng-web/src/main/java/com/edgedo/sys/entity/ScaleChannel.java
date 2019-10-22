package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_channel")
public class ScaleChannel implements Serializable{
	
		
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
	 * 属性描述:渠道名
	 */
	@TableField(value="CHANNEL_NAME",exist=true)
	java.lang.String channelName;
	
	/**
	 * 属性描述:渠道链接
	 */
	@TableField(value="CHANNEL_URL",exist=true)
	java.lang.String channelUrl;
	
	/**
	 * 属性描述:渠道描述
	 */
	@TableField(value="CHANNEL_DESC",exist=true)
	java.lang.String channelDesc;
	
	
	
	
	
	
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
	
	
	public java.lang.String getChannelName(){
		return this.channelName;
	}
	
	public void setChannelName(java.lang.String channelName){
		this.channelName=channelName;
	}
	
	
	public java.lang.String getChannelUrl(){
		return this.channelUrl;
	}
	
	public void setChannelUrl(java.lang.String channelUrl){
		this.channelUrl=channelUrl;
	}
	
	
	public java.lang.String getChannelDesc(){
		return this.channelDesc;
	}
	
	public void setChannelDesc(java.lang.String channelDesc){
		this.channelDesc=channelDesc;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", channelName=").append(channelName);			
			sb.append(", channelUrl=").append(channelUrl);			
			sb.append(", channelDesc=").append(channelDesc);			
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
        ScaleChannel other = (ScaleChannel) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getChannelName() == null ? other.getId() == null : this.getChannelName().equals(other.getChannelName()))		
				        		&&(this.getChannelUrl() == null ? other.getId() == null : this.getChannelUrl().equals(other.getChannelUrl()))		
				        		&&(this.getChannelDesc() == null ? other.getId() == null : this.getChannelDesc().equals(other.getChannelDesc()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getChannelName() == null) ? 0 : getChannelName().hashCode());		
		        result = prime * result + ((getChannelUrl() == null) ? 0 : getChannelUrl().hashCode());		
		        result = prime * result + ((getChannelDesc() == null) ? 0 : getChannelDesc().hashCode());		
		;
        return result;
    }

}
