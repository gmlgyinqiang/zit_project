package com.edgedo.sys.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import org.springframework.format.annotation.DateTimeFormat;

@TableName("scale_user_order")
public class ScaleUserOrder implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	java.util.Date createTime;
	
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
	 * 属性描述:量表描述
	 */
	@TableField(value="SCALE_DESC",exist=true)
	java.lang.String scaleDesc;

	/**
	 * 属性描述:量表小图
	 */
	@TableField(value="SMALL_IMG_URL",exist=true)
	java.lang.String smallImgUrl;

	/**
	 * 属性描述:售价
	 */
	@TableField(value="PRICE",exist=true)
	java.math.BigDecimal price;
	
	/**
	 * 属性描述:原价
	 */
	@TableField(value="ORA_PRICE",exist=true)
	java.math.BigDecimal oraPrice;
	
	/**
	 * 属性描述:订单状态
	 */
	@TableField(value="ORDER_STATE",exist=true)
	java.lang.String orderState;
	
	/**
	 * 属性描述:支付时间
	 */
	@TableField(value="PAY_TIME",exist=true)
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	java.util.Date payTime;

//	@TableField(value="PAY_TIME",exist=true)
//	java.util.Date searchTime;

	/**
	 * 属性描述:所属用户ID
	 */
	@TableField(value="OWNER_USER_ID",exist=true)
	java.lang.String ownerUserId;
	
	/**
	 * 属性描述:所属用户名
	 */
	@TableField(value="OWNER_USER_NAME",exist=true)
	java.lang.String ownerUserName;
	
	/**
	 * 属性描述:用户类型
	 */
	@TableField(value="OWNER_USER_TYPE",exist=true)
	java.lang.String ownerUserType;
	
	/**
	 * 属性描述:所属企业ID
	 */
	@TableField(value="OWNER_COM_ID",exist=true)
	java.lang.String ownerComId;
	
	/**
	 * 属性描述:所属企业名
	 */
	@TableField(value="OWNER_COM_NAME",exist=true)
	java.lang.String ownerComName;

	/**
	 * 属性描述:所属企业订单id
	 */
	@TableField(value="COMPANY_ORDER_ID",exist=true)
	java.lang.String companyOrderId;
	
	/**
	 * 属性描述:订单编号
	 */
	@TableField(value="ORDER_CODE",exist=true)
	java.lang.String orderCode;
	
	/**
	 * 属性描述:预支付ID
	 */
	@TableField(value="PREPAY_ID",exist=true)
	java.lang.String prepayId;
	
	/**
	 * 属性描述:手续费
	 */
	@TableField(value="FEE",exist=true)
	java.math.BigDecimal fee;
	
	/**
	 * 属性描述:实际收钱
	 */
	@TableField(value="REAL_GET_MONEY",exist=true)
	java.math.BigDecimal realGetMoney;
	
	/**
	 * 属性描述:数据状态
	 */
	@TableField(value="DATA_STATE",exist=true)
	java.lang.String dataState;



	@TableField(value="IS_REMIND",exist=true)
	java.lang.String isRemind;

	@TableField(value="CHANNEL_ID",exist=true)
	java.lang.String channelId;

	/**
	 * 属性描述:开始时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	java.util.Date startTime;

	/**
	 * 属性描述:结束时间
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	java.util.Date endTime;

	public Date getStartTime() {
		return startTime;
	}

	public ScaleUserOrder setStartTime(Date startTime) {
		this.startTime = startTime;
		return this;
	}

	public Date getEndTime() {
		return endTime;
	}

	public ScaleUserOrder setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public java.lang.String getChannelId() {
		return channelId;
	}

	public void setChannelId(java.lang.String channelId) {
		this.channelId = channelId;
	}




	@TableField(value="CHANNEL_NAME",exist=true)
	java.lang.String channelName;

	public java.lang.String getChannelName() {
		return channelName;
	}

	public void setChannelName(java.lang.String channelName) {
		this.channelName = channelName;
	}

	public java.lang.String getIsRemind() {
		return isRemind;
	}

	public void setIsRemind(java.lang.String isRemind) {
		this.isRemind = isRemind;
	}

	public String getScaleDesc() {
		return scaleDesc;
	}

	public void setScaleDesc(String scaleDesc) {
		this.scaleDesc = scaleDesc;
	}

	public String getSmallImgUrl() {
		return smallImgUrl;
	}

	public void setSmallImgUrl(String smallImgUrl) {
		this.smallImgUrl = smallImgUrl;
	}

	public String getCompanyOrderId() {
		return companyOrderId;
	}

	public void setCompanyOrderId(String companyOrderId) {
		this.companyOrderId = companyOrderId;
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
	
	
	public java.math.BigDecimal getPrice(){
		return this.price;
	}
	
	public void setPrice(java.math.BigDecimal price){
		this.price=price;
	}
	
	
	public java.math.BigDecimal getOraPrice(){
		return this.oraPrice;
	}
	
	public void setOraPrice(java.math.BigDecimal oraPrice){
		this.oraPrice=oraPrice;
	}
	
	
	public java.lang.String getOrderState(){
		return this.orderState;
	}
	
	public void setOrderState(java.lang.String orderState){
		this.orderState=orderState;
	}
	
	
	public java.util.Date getPayTime(){
		return this.payTime;
	}
	
	public void setPayTime(java.util.Date payTime){
		this.payTime=payTime;
	}
	
	
	public java.lang.String getOwnerUserId(){
		return this.ownerUserId;
	}
	
	public void setOwnerUserId(java.lang.String ownerUserId){
		this.ownerUserId=ownerUserId;
	}
	
	
	public java.lang.String getOwnerUserName(){
		return this.ownerUserName;
	}
	
	public void setOwnerUserName(java.lang.String ownerUserName){
		this.ownerUserName=ownerUserName;
	}
	
	
	public java.lang.String getOwnerUserType(){
		return this.ownerUserType;
	}
	
	public void setOwnerUserType(java.lang.String ownerUserType){
		this.ownerUserType=ownerUserType;
	}
	
	
	public java.lang.String getOwnerComId(){
		return this.ownerComId;
	}
	
	public void setOwnerComId(java.lang.String ownerComId){
		this.ownerComId=ownerComId;
	}
	
	
	public java.lang.String getOwnerComName(){
		return this.ownerComName;
	}
	
	public void setOwnerComName(java.lang.String ownerComName){
		this.ownerComName=ownerComName;
	}
	
	
	public java.lang.String getOrderCode(){
		return this.orderCode;
	}
	
	public void setOrderCode(java.lang.String orderCode){
		this.orderCode=orderCode;
	}
	
	
	public java.lang.String getPrepayId(){
		return this.prepayId;
	}
	
	public void setPrepayId(java.lang.String prepayId){
		this.prepayId=prepayId;
	}
	
	
	public java.math.BigDecimal getFee(){
		return this.fee;
	}
	
	public void setFee(java.math.BigDecimal fee){
		this.fee=fee;
	}
	
	
	public java.math.BigDecimal getRealGetMoney(){
		return this.realGetMoney;
	}
	
	public void setRealGetMoney(java.math.BigDecimal realGetMoney){
		this.realGetMoney=realGetMoney;
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
			sb.append(", scaleId=").append(scaleId);			
			sb.append(", scaleName=").append(scaleName);			
			sb.append(", price=").append(price);			
			sb.append(", oraPrice=").append(oraPrice);			
			sb.append(", orderState=").append(orderState);			
			sb.append(", payTime=").append(payTime);			
			sb.append(", ownerUserId=").append(ownerUserId);			
			sb.append(", ownerUserName=").append(ownerUserName);			
			sb.append(", ownerUserType=").append(ownerUserType);			
			sb.append(", ownerComId=").append(ownerComId);			
			sb.append(", ownerComName=").append(ownerComName);			
			sb.append(", orderCode=").append(orderCode);			
			sb.append(", prepayId=").append(prepayId);			
			sb.append(", fee=").append(fee);			
			sb.append(", realGetMoney=").append(realGetMoney);			
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
        ScaleUserOrder other = (ScaleUserOrder) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getScaleId() == null ? other.getId() == null : this.getScaleId().equals(other.getScaleId()))		
				        		&&(this.getScaleName() == null ? other.getId() == null : this.getScaleName().equals(other.getScaleName()))		
				        		&&(this.getPrice() == null ? other.getId() == null : this.getPrice().equals(other.getPrice()))		
				        		&&(this.getOraPrice() == null ? other.getId() == null : this.getOraPrice().equals(other.getOraPrice()))		
				        		&&(this.getOrderState() == null ? other.getId() == null : this.getOrderState().equals(other.getOrderState()))		
				        		&&(this.getPayTime() == null ? other.getId() == null : this.getPayTime().equals(other.getPayTime()))		
				        		&&(this.getOwnerUserId() == null ? other.getId() == null : this.getOwnerUserId().equals(other.getOwnerUserId()))		
				        		&&(this.getOwnerUserName() == null ? other.getId() == null : this.getOwnerUserName().equals(other.getOwnerUserName()))		
				        		&&(this.getOwnerUserType() == null ? other.getId() == null : this.getOwnerUserType().equals(other.getOwnerUserType()))		
				        		&&(this.getOwnerComId() == null ? other.getId() == null : this.getOwnerComId().equals(other.getOwnerComId()))		
				        		&&(this.getOwnerComName() == null ? other.getId() == null : this.getOwnerComName().equals(other.getOwnerComName()))		
				        		&&(this.getOrderCode() == null ? other.getId() == null : this.getOrderCode().equals(other.getOrderCode()))		
				        		&&(this.getPrepayId() == null ? other.getId() == null : this.getPrepayId().equals(other.getPrepayId()))		
				        		&&(this.getFee() == null ? other.getId() == null : this.getFee().equals(other.getFee()))		
				        		&&(this.getRealGetMoney() == null ? other.getId() == null : this.getRealGetMoney().equals(other.getRealGetMoney()))		
				        		&&(this.getDataState() == null ? other.getId() == null : this.getDataState().equals(other.getDataState()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getScaleId() == null) ? 0 : getScaleId().hashCode());		
		        result = prime * result + ((getScaleName() == null) ? 0 : getScaleName().hashCode());		
		        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());		
		        result = prime * result + ((getOraPrice() == null) ? 0 : getOraPrice().hashCode());		
		        result = prime * result + ((getOrderState() == null) ? 0 : getOrderState().hashCode());		
		        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());		
		        result = prime * result + ((getOwnerUserId() == null) ? 0 : getOwnerUserId().hashCode());		
		        result = prime * result + ((getOwnerUserName() == null) ? 0 : getOwnerUserName().hashCode());		
		        result = prime * result + ((getOwnerUserType() == null) ? 0 : getOwnerUserType().hashCode());		
		        result = prime * result + ((getOwnerComId() == null) ? 0 : getOwnerComId().hashCode());		
		        result = prime * result + ((getOwnerComName() == null) ? 0 : getOwnerComName().hashCode());		
		        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());		
		        result = prime * result + ((getPrepayId() == null) ? 0 : getPrepayId().hashCode());		
		        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());		
		        result = prime * result + ((getRealGetMoney() == null) ? 0 : getRealGetMoney().hashCode());		
		        result = prime * result + ((getDataState() == null) ? 0 : getDataState().hashCode());		
		;
        return result;
    }

}
