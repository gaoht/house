package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import java.util.List;

public abstract class SingedLeaseItem
  extends LinearLayout
{
  public SingedLeaseItem(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public SingedLeaseItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public SingedLeaseItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  public abstract CheckBox getCheckBox();
  
  public abstract int getIsBlank();
  
  public abstract int getIsShort();
  
  public abstract String getIsZWhite();
  
  public abstract List<Integer> getPayments();
  
  public abstract b getPaymentsTags();
  
  public abstract String getPrice();
  
  public abstract String getPriceUnit();
  
  public abstract boolean getSelectStatus();
  
  public abstract int getShorRentMaxDays();
  
  public abstract int getShortRentMinDays();
  
  public abstract String getSign_Date();
  
  public abstract String getStop_Date();
  
  public abstract String getTenancyChoice();
  
  public abstract String getTenancy_Type();
  
  public abstract e getzWhiteModel();
  
  public abstract void initView(Context paramContext);
  
  public abstract void setBottomLineGone(boolean paramBoolean);
  
  public abstract void setSelectStatus(boolean paramBoolean);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/SingedLeaseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */