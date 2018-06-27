package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.d.al;
import java.util.List;

public class c
  extends BaseAdapter
{
  private Context a;
  private List<al> b;
  
  public c(Context paramContext, List<al> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904399, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131689846));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689848));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695448));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689832));
      paramViewGroup.e = ((LinearLayout)paramView.findViewById(2131695444));
      paramViewGroup.f = ((ImageView)paramView.findViewById(2131695445));
      paramViewGroup.g = ((ImageView)paramView.findViewById(2131695446));
      paramView.setTag(paramViewGroup);
    }
    al localal;
    for (;;)
    {
      localal = (al)this.b.get(paramInt);
      if (localal.getState() != 2) {
        break;
      }
      paramViewGroup.f.setImageResource(2130838508);
      paramViewGroup.g.setBackgroundResource(2130838509);
      paramViewGroup.a.setTextColor(-3026479);
      paramViewGroup.b.setTextColor(-3026479);
      paramViewGroup.c.setTextColor(-3026479);
      paramViewGroup.c.setText("已过期");
      paramViewGroup.a.setText((int)localal.getPromoPrice() + "");
      paramViewGroup.b.setText(localal.getPromoName());
      paramViewGroup.d.setVisibility(4);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    if (localal.getState() == 1)
    {
      paramViewGroup.f.setImageResource(2130838508);
      paramViewGroup.g.setBackgroundResource(2130838509);
      paramViewGroup.a.setTextColor(-3026479);
      paramViewGroup.b.setTextColor(-3026479);
      paramViewGroup.c.setTextColor(-3026479);
      paramViewGroup.c.setText("已使用");
      paramViewGroup.a.setText((int)localal.getPromoPrice() + "");
      paramViewGroup.b.setText(localal.getPromoName());
      paramViewGroup.d.setVisibility(4);
      return paramView;
    }
    paramViewGroup.f.setImageResource(2130839087);
    paramViewGroup.g.setBackgroundResource(2130837922);
    paramViewGroup.a.setTextColor(33792);
    paramViewGroup.b.setTextColor(-8665533);
    paramViewGroup.c.setTextColor(-15658735);
    paramViewGroup.a.setText((int)localal.getPromoPrice() + "");
    paramViewGroup.b.setText(localal.getPromoName());
    paramViewGroup.c.setText(localal.getStartDate() + "到");
    paramViewGroup.d.setText(localal.getEndDate());
    paramViewGroup.d.setVisibility(0);
    return paramView;
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public LinearLayout e;
    public ImageView f;
    public ImageView g;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */