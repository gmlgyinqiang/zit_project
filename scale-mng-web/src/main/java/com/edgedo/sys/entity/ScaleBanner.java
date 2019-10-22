package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_banner")
public class ScaleBanner implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:名称
	 */
	@TableField(value="IMAGE_NAME",exist=true)
	java.lang.String imageName;
	
	/**
	 * 属性描述:图片路径
	 */
	@TableField(value="IMAGE_URL",exist=true)
	java.lang.String imageUrl;
	
	/**
	 * 属性描述:排序号
	 */
	@TableField(value="ORDER_NUM",exist=true)
	java.math.BigDecimal orderNum;
	
	/**
	 * 属性描述:是否启用
	 */
	@TableField(value="IS_USE",exist=true)
	java.lang.String isUse;
	
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
	
	
	public java.lang.String getImageName(){
		return this.imageName;
	}
	
	public void setImageName(java.lang.String imageName){
		this.imageName=imageName;
	}
	
	
	public java.lang.String getImageUrl(){
		return this.imageUrl;
	}
	
	public void setImageUrl(java.lang.String imageUrl){
		this.imageUrl=imageUrl;
	}
	
	
	public java.math.BigDecimal getOrderNum(){
		return this.orderNum;
	}
	
	public void setOrderNum(java.math.BigDecimal orderNum){
		this.orderNum=orderNum;
	}
	
	
	public java.lang.String getIsUse(){
		return this.isUse;
	}
	
	public void setIsUse(java.lang.String isUse){
		this.isUse=isUse;
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
			sb.append(", imageName=").append(imageName);			
			sb.append(", imageUrl=").append(imageUrl);			
			sb.append(", orderNum=").append(orderNum);			
			sb.append(", isUse=").append(isUse);			
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
        ScaleBanner other = (ScaleBanner) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getImageName() == null ? other.getId() == null : this.getImageName().equals(other.getImageName()))		
				        		&&(this.getImageUrl() == null ? other.getId() == null : this.getImageUrl().equals(other.getImageUrl()))		
				        		&&(this.getOrderNum() == null ? other.getId() == null : this.getOrderNum().equals(other.getOrderNum()))		
				        		&&(this.getIsUse() == null ? other.getId() == null : this.getIsUse().equals(other.getIsUse()))		
				        		&&(this.getDateState() == null ? other.getId() == null : this.getDateState().equals(other.getDateState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getImageName() == null) ? 0 : getImageName().hashCode());		
		        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());		
		        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());		
		        result = prime * result + ((getIsUse() == null) ? 0 : getIsUse().hashCode());		
		        result = prime * result + ((getDateState() == null) ? 0 : getDateState().hashCode());		
		;
        return result;
    }

}
