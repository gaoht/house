package com.ziroom.ziroomcustomer.newmovehouse.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanDetail.UserOrderItemVOsBean;
import com.ziroom.ziroomcustomer.util.n;
import java.text.DecimalFormat;
import java.util.List;

public class i
  extends BaseAdapter
{
  private Context a;
  private List<MovingVanDetail.UserOrderItemVOsBean> b;
  private boolean c;
  
  public i(Context paramContext, List<MovingVanDetail.UserOrderItemVOsBean> paramList)
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
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904375, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690084));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689912));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131690724));
      paramView.setTag(paramViewGroup);
      MovingVanDetail.UserOrderItemVOsBean localUserOrderItemVOsBean = (MovingVanDetail.UserOrderItemVOsBean)this.b.get(paramInt);
      paramViewGroup.a.setText(localUserOrderItemVOsBean.getItemName());
      localObject = new DecimalFormat("######0.00");
      paramViewGroup.b.setText(((DecimalFormat)localObject).format(localUserOrderItemVOsBean.getItemAmount() / 100.0D) + "元");
      localObject = (RelativeLayout.LayoutParams)paramViewGroup.b.getLayoutParams();
      if (!"优惠金额".equals(localUserOrderItemVOsBean.getItemName())) {
        break label248;
      }
      if (!this.c) {
        break label222;
      }
      paramViewGroup.c.setVisibility(0);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = n.dip2px(this.a, 30.0F);
    }
    for (;;)
    {
      paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label222:
      paramViewGroup.c.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = n.dip2px(this.a, 16.0F);
      continue;
      label248:
      paramViewGroup.c.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = n.dip2px(this.a, 16.0F);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */