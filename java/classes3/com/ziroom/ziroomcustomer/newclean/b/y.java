package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralDetailBean.ItemBean;
import com.ziroom.ziroomcustomer.util.n;
import java.text.DecimalFormat;
import java.util.List;

public class y
  extends BaseAdapter
{
  private Context a;
  private List<PeriodGeneralDetailBean.ItemBean> b;
  private boolean c;
  
  public y(Context paramContext, List<PeriodGeneralDetailBean.ItemBean> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = this.c;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PeriodGeneralDetailBean.ItemBean localItemBean;
    DecimalFormat localDecimalFormat;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904375, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690084));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689912));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131690724));
      paramView.setTag(paramViewGroup);
      localItemBean = (PeriodGeneralDetailBean.ItemBean)this.b.get(paramInt);
      paramViewGroup.a.setText(localItemBean.getItemName());
      localDecimalFormat = new DecimalFormat("######0.00");
      localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.b.getLayoutParams();
      paramViewGroup.c.setVisibility(8);
      if (!"优惠金额".equals(localItemBean.getItemName())) {
        break label258;
      }
      paramViewGroup.b.setText("-" + localDecimalFormat.format(localItemBean.getItemAmount()) + "元");
      if (!localItemBean.isCanShowCoupon()) {
        break label232;
      }
      paramViewGroup.c.setVisibility(0);
      localLayoutParams.rightMargin = n.dip2px(this.a, 30.0F);
    }
    for (;;)
    {
      paramViewGroup.b.setLayoutParams(localLayoutParams);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label232:
      paramViewGroup.c.setVisibility(8);
      localLayoutParams.rightMargin = n.dip2px(this.a, 16.0F);
      continue;
      label258:
      paramViewGroup.b.setText(localDecimalFormat.format(localItemBean.getItemAmount()) + "元");
      paramViewGroup.c.setVisibility(8);
      localLayoutParams.rightMargin = n.dip2px(this.a, 16.0F);
    }
  }
  
  public void setMoveFeeArrow(boolean paramBoolean)
  {
    this.c = paramBoolean;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public ImageView c;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */