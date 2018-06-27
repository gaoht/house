package com.ziroom.ziroomcustomer.minsu.landlordrelease.model;

import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import java.io.Serializable;
import java.util.List;

public class Step3InitDealPolicyBean
  extends MinsuBaseJson
{
  public DataBean data;
  
  public static class DataBean
    implements Serializable
  {
    public CancellationPolicyBean cancellationPolicy;
    public String cancellationPolicyTips;
    public int depositMax;
    public int depositMin;
    public DepositMoneyBean depositMoney;
    public HouseRulesBean houseRules;
    public HouseRulesSelectBean houseRulesSelect;
    public OrderTypeBean orderType;
    public int orderTypeValue;
    public List<UnSelectcancellationPolicyBean> unSelectcancellationPolicy;
    
    public static class CancellationPolicyBean
    {
      public boolean isEdit;
      public List<ListBeanXX> list;
      
      public static class ListBeanXX
      {
        public String explain;
        public boolean isSelect;
        public String text;
        public String value;
      }
    }
    
    public static class DepositMoneyBean
    {
      public boolean isEdit;
      public int value;
    }
    
    public static class HouseRulesBean
      implements Serializable
    {
      public String auditMsg;
      public String explain;
      public boolean isEdit;
      public String text;
      public String value;
    }
    
    public static class HouseRulesSelectBean
      implements Serializable
    {
      public boolean isEdit;
      public List<ListBeanX> list;
      
      public static class ListBeanX
        implements Serializable
      {
        public String explain;
        public boolean isSelect;
        public String text;
        public int value;
        
        public ListBeanX copy()
        {
          ListBeanX localListBeanX = new ListBeanX();
          localListBeanX.text = this.text;
          localListBeanX.value = this.value;
          localListBeanX.explain = this.explain;
          localListBeanX.isSelect = this.isSelect;
          return localListBeanX;
        }
        
        public boolean equals(Object paramObject)
        {
          boolean bool2 = true;
          boolean bool3 = false;
          boolean bool1;
          if (this == paramObject) {
            bool1 = true;
          }
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    bool1 = bool3;
                  } while (paramObject == null);
                  bool1 = bool3;
                } while (getClass() != paramObject.getClass());
                paramObject = (ListBeanX)paramObject;
                bool1 = bool3;
              } while (this.value != ((ListBeanX)paramObject).value);
              bool1 = bool3;
            } while (this.isSelect != ((ListBeanX)paramObject).isSelect);
            if (this.text == null) {
              break;
            }
            bool1 = bool3;
          } while (!this.text.equals(((ListBeanX)paramObject).text));
          if (this.explain != null) {
            bool1 = this.explain.equals(((ListBeanX)paramObject).explain);
          }
          for (;;)
          {
            return bool1;
            if (((ListBeanX)paramObject).text == null) {
              break;
            }
            return false;
            bool1 = bool2;
            if (((ListBeanX)paramObject).explain != null) {
              bool1 = false;
            }
          }
        }
        
        public int hashCode()
        {
          int k = 0;
          int i;
          int m;
          if (this.text != null)
          {
            i = this.text.hashCode();
            m = this.value;
            if (this.explain == null) {
              break label70;
            }
          }
          label70:
          for (int j = this.explain.hashCode();; j = 0)
          {
            if (this.isSelect) {
              k = 1;
            }
            return (j + (i * 31 + m) * 31) * 31 + k;
            i = 0;
            break;
          }
        }
      }
    }
    
    public static class OrderTypeBean
    {
      public boolean isEdit;
      public List<ListBean> list;
      
      public static class ListBean
      {
        public String explain;
        public boolean isSelect;
        public String text;
        public int value;
      }
    }
    
    public static class UnSelectcancellationPolicyBean
    {
      public String explain;
      public String text;
      public String value;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/model/Step3InitDealPolicyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */