package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("scale_order_census")
public class ScaleOrderCensus implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:未付款订单数量
	 */
	@TableField(value="WFK_COUNT",exist=true)
	java.lang.Integer wfkCount;
	
	/**
	 * 属性描述:已支付订单数量
	 */
	@TableField(value="YZF_COUNT",exist=true)
	java.lang.Integer yzfCount;
	
	/**
	 * 属性描述:测评中订单数量
	 */
	@TableField(value="CPZ_COUNT",exist=true)
	java.lang.Integer cpzCount;
	
	/**
	 * 属性描述:已完成订单数量
	 */
	@TableField(value="YWC_COUNT",exist=true)
	java.lang.Integer ywcCount;
	
	/**
	 * 属性描述:订单总金额
	 */
	@TableField(value="ALL_PRICE",exist=true)
	java.math.BigDecimal allPrice;
	
	
	
	
	
	
	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.lang.Integer getWfkCount(){
		return this.wfkCount;
	}
	
	public void setWfkCount(java.lang.Integer wfkCount){
		this.wfkCount=wfkCount;
	}
	
	
	public java.lang.Integer getYzfCount(){
		return this.yzfCount;
	}
	
	public void setYzfCount(java.lang.Integer yzfCount){
		this.yzfCount=yzfCount;
	}
	
	
	public java.lang.Integer getCpzCount(){
		return this.cpzCount;
	}
	
	public void setCpzCount(java.lang.Integer cpzCount){
		this.cpzCount=cpzCount;
	}
	
	
	public java.lang.Integer getYwcCount(){
		return this.ywcCount;
	}
	
	public void setYwcCount(java.lang.Integer ywcCount){
		this.ywcCount=ywcCount;
	}
	
	
	public java.math.BigDecimal getAllPrice(){
		return this.allPrice;
	}
	
	public void setAllPrice(java.math.BigDecimal allPrice){
		this.allPrice=allPrice;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", wfkCount=").append(wfkCount);			
			sb.append(", yzfCount=").append(yzfCount);			
			sb.append(", cpzCount=").append(cpzCount);			
			sb.append(", ywcCount=").append(ywcCount);			
			sb.append(", allPrice=").append(allPrice);			
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
        ScaleOrderCensus other = (ScaleOrderCensus) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getWfkCount() == null ? other.getId() == null : this.getWfkCount().equals(other.getWfkCount()))		
				        		&&(this.getYzfCount() == null ? other.getId() == null : this.getYzfCount().equals(other.getYzfCount()))		
				        		&&(this.getCpzCount() == null ? other.getId() == null : this.getCpzCount().equals(other.getCpzCount()))		
				        		&&(this.getYwcCount() == null ? other.getId() == null : this.getYwcCount().equals(other.getYwcCount()))		
				        		&&(this.getAllPrice() == null ? other.getId() == null : this.getAllPrice().equals(other.getAllPrice()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getWfkCount() == null) ? 0 : getWfkCount().hashCode());		
		        result = prime * result + ((getYzfCount() == null) ? 0 : getYzfCount().hashCode());		
		        result = prime * result + ((getCpzCount() == null) ? 0 : getCpzCount().hashCode());		
		        result = prime * result + ((getYwcCount() == null) ? 0 : getYwcCount().hashCode());		
		        result = prime * result + ((getAllPrice() == null) ? 0 : getAllPrice().hashCode());		
		;
        return result;
    }

}
