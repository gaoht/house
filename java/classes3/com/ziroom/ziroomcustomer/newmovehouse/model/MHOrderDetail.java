package com.ziroom.ziroomcustomer.newmovehouse.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MHOrderDetail
  implements Serializable
{
  private double distancePrice;
  private String empId;
  private String empName;
  private String empPhone;
  private String empSchedulePhone;
  private String employeeOrderCode;
  private String endArea;
  private String endAreaPoint;
  private Map<String, String> evaluateNegativeTagMap;
  private Map<String, String> evaluatePositiveTagMap;
  private int explainNum;
  private List<OrderGoods> goods;
  private double goodsPrice;
  private int gradeSum;
  private int gradeTime;
  private String headPhonePath;
  private int isEvaluate;
  private int isPay;
  private double moveBasePrice;
  private String moveDate;
  private String moveEndTime;
  private String moveTime;
  private String operateOrderStatus;
  private String orderCode;
  private String orderId;
  private List<OrderLogs> orderLogs;
  private int orderStatus;
  private double payAmount;
  private String payType;
  private double promoPrice;
  private String serviceInfoId;
  private String serviceName;
  private String startArea;
  private String startAreaPoint;
  private int timeBucket;
  private double totalPrice;
  
  public double getDistancePrice()
  {
    return this.distancePrice;
  }
  
  public String getEmpId()
  {
    return this.empId;
  }
  
  public String getEmpName()
  {
    return this.empName;
  }
  
  public String getEmpPhone()
  {
    return this.empPhone;
  }
  
  public String getEmpSchedulePhone()
  {
    return this.empSchedulePhone;
  }
  
  public String getEmployeeOrderCode()
  {
    return this.employeeOrderCode;
  }
  
  public String getEndArea()
  {
    return this.endArea;
  }
  
  public String getEndAreaPoint()
  {
    return this.endAreaPoint;
  }
  
  public Map<String, String> getEvaluateNegativeTagMap()
  {
    return this.evaluateNegativeTagMap;
  }
  
  public Map<String, String> getEvaluatePositiveTagMap()
  {
    return this.evaluatePositiveTagMap;
  }
  
  public int getExplainNum()
  {
    return this.explainNum;
  }
  
  public List<OrderGoods> getGoods()
  {
    return this.goods;
  }
  
  public double getGoodsPrice()
  {
    return this.goodsPrice;
  }
  
  public int getGradeSum()
  {
    return this.gradeSum;
  }
  
  public int getGradeTime()
  {
    return this.gradeTime;
  }
  
  public String getHeadPhonePath()
  {
    return this.headPhonePath;
  }
  
  public int getIsEvaluate()
  {
    return this.isEvaluate;
  }
  
  public int getIsPay()
  {
    return this.isPay;
  }
  
  public double getMoveBasePrice()
  {
    return this.moveBasePrice;
  }
  
  public String getMoveDate()
  {
    return this.moveDate;
  }
  
  public String getMoveEndTime()
  {
    return this.moveEndTime;
  }
  
  public String getMoveTime()
  {
    return this.moveTime;
  }
  
  public String getOperateOrderStatus()
  {
    return this.operateOrderStatus;
  }
  
  public String getOrderCode()
  {
    return this.orderCode;
  }
  
  public String getOrderId()
  {
    return this.orderId;
  }
  
  public List<OrderLogs> getOrderLogs()
  {
    return this.orderLogs;
  }
  
  public int getOrderStatus()
  {
    return this.orderStatus;
  }
  
  public double getPayAmount()
  {
    return this.payAmount;
  }
  
  public String getPayType()
  {
    return this.payType;
  }
  
  public double getPromoPrice()
  {
    return this.promoPrice;
  }
  
  public String getServiceInfoId()
  {
    return this.serviceInfoId;
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public String getStartArea()
  {
    return this.startArea;
  }
  
  public String getStartAreaPoint()
  {
    return this.startAreaPoint;
  }
  
  public int getTimeBucket()
  {
    return this.timeBucket;
  }
  
  public double getTotalPrice()
  {
    return this.totalPrice;
  }
  
  public void setDistancePrice(double paramDouble)
  {
    this.distancePrice = paramDouble;
  }
  
  public void setEmpId(String paramString)
  {
    this.empId = paramString;
  }
  
  public void setEmpName(String paramString)
  {
    this.empName = paramString;
  }
  
  public void setEmpPhone(String paramString)
  {
    this.empPhone = paramString;
  }
  
  public void setEmpSchedulePhone(String paramString)
  {
    this.empSchedulePhone = paramString;
  }
  
  public void setEmployeeOrderCode(String paramString)
  {
    this.employeeOrderCode = paramString;
  }
  
  public void setEndArea(String paramString)
  {
    this.endArea = paramString;
  }
  
  public void setEndAreaPoint(String paramString)
  {
    this.endAreaPoint = paramString;
  }
  
  public void setEvaluateNegativeTagMap(Map<String, String> paramMap)
  {
    this.evaluateNegativeTagMap = paramMap;
  }
  
  public void setEvaluatePositiveTagMap(Map<String, String> paramMap)
  {
    this.evaluatePositiveTagMap = paramMap;
  }
  
  public void setExplainNum(int paramInt)
  {
    this.explainNum = paramInt;
  }
  
  public void setGoods(List<OrderGoods> paramList)
  {
    this.goods = paramList;
  }
  
  public void setGoodsPrice(double paramDouble)
  {
    this.goodsPrice = paramDouble;
  }
  
  public void setGradeSum(int paramInt)
  {
    this.gradeSum = paramInt;
  }
  
  public void setGradeTime(int paramInt)
  {
    this.gradeTime = paramInt;
  }
  
  public void setHeadPhonePath(String paramString)
  {
    this.headPhonePath = paramString;
  }
  
  public void setIsEvaluate(int paramInt)
  {
    this.isEvaluate = paramInt;
  }
  
  public void setIsPay(int paramInt)
  {
    this.isPay = paramInt;
  }
  
  public void setMoveBasePrice(double paramDouble)
  {
    this.moveBasePrice = paramDouble;
  }
  
  public void setMoveDate(String paramString)
  {
    this.moveDate = paramString;
  }
  
  public void setMoveEndTime(String paramString)
  {
    this.moveEndTime = paramString;
  }
  
  public void setMoveTime(String paramString)
  {
    this.moveTime = paramString;
  }
  
  public void setOperateOrderStatus(String paramString)
  {
    this.operateOrderStatus = paramString;
  }
  
  public void setOrderCode(String paramString)
  {
    this.orderCode = paramString;
  }
  
  public void setOrderId(String paramString)
  {
    this.orderId = paramString;
  }
  
  public void setOrderLogs(List<OrderLogs> paramList)
  {
    this.orderLogs = paramList;
  }
  
  public void setOrderStatus(int paramInt)
  {
    this.orderStatus = paramInt;
  }
  
  public void setPayAmount(double paramDouble)
  {
    this.payAmount = paramDouble;
  }
  
  public void setPayType(String paramString)
  {
    this.payType = paramString;
  }
  
  public void setPromoPrice(double paramDouble)
  {
    this.promoPrice = paramDouble;
  }
  
  public void setServiceInfoId(String paramString)
  {
    this.serviceInfoId = paramString;
  }
  
  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public void setStartArea(String paramString)
  {
    this.startArea = paramString;
  }
  
  public void setStartAreaPoint(String paramString)
  {
    this.startAreaPoint = paramString;
  }
  
  public void setTimeBucket(int paramInt)
  {
    this.timeBucket = paramInt;
  }
  
  public void setTotalPrice(double paramDouble)
  {
    this.totalPrice = paramDouble;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/model/MHOrderDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */