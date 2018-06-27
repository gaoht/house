package com.ziroom.ziroomcustomer.sharedlife.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.List;

public class d
  extends BaseAdapter
{
  private Context a;
  private List<com.ziroom.ziroomcustomer.sharedlife.c.d> b;
  
  public d(Context paramContext, List<com.ziroom.ziroomcustomer.sharedlife.c.d> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
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
    View localView;
    label180:
    com.ziroom.ziroomcustomer.sharedlife.c.d locald;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a).inflate(2130904522, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)localView.findViewById(2131695665));
      paramViewGroup.b = ((TextView)localView.findViewById(2131695666));
      paramViewGroup.c = ((TextView)localView.findViewById(2131694886));
      paramViewGroup.d = ((TextView)localView.findViewById(2131694887));
      paramViewGroup.e = ((TextView)localView.findViewById(2131695667));
      paramViewGroup.f = ((TextView)localView.findViewById(2131692375));
      paramViewGroup.g = ((RelativeLayout)localView.findViewById(2131692614));
      paramViewGroup.h = ((TextView)localView.findViewById(2131689956));
      paramViewGroup.i = localView.findViewById(2131692133);
      localView.setTag(paramViewGroup);
      if (this.b.size() != 1) {
        break label345;
      }
      paramViewGroup.i.setVisibility(8);
      locald = (com.ziroom.ziroomcustomer.sharedlife.c.d)this.b.get(paramInt);
      paramViewGroup.a.setText(locald.getDeviceTypeName());
      paramView = "";
      paramInt = locald.getOrderState();
      if (paramInt != 0) {
        break label383;
      }
      paramView = "进行中";
    }
    for (;;)
    {
      paramViewGroup.b.setText(paramView);
      paramViewGroup.c.setText(locald.getOrderStartTime());
      paramViewGroup.d.setText(locald.getOrderEndTime());
      paramView = new DecimalFormat("######0.00");
      paramViewGroup.e.setText(paramView.format(locald.getOrderMoney() / 100) + "");
      paramViewGroup.f.setText(locald.getOrderCode());
      if (paramInt != 3) {
        break label427;
      }
      paramViewGroup.g.setVisibility(0);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label345:
      if (paramInt == this.b.size() - 1)
      {
        paramViewGroup.i.setVisibility(0);
        break label180;
      }
      paramViewGroup.i.setVisibility(8);
      break label180;
      label383:
      if (paramInt == 1) {
        paramView = "已完成";
      } else if (paramInt == 2) {
        paramView = "已取消";
      } else if (paramInt == 3) {
        paramView = "代付款";
      } else if (paramInt == 4) {
        paramView = "已退款";
      }
    }
    label427:
    paramViewGroup.g.setVisibility(8);
    return localView;
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public RelativeLayout g;
    public TextView h;
    public View i;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */