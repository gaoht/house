package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newrepair.b.k;
import java.util.List;

public class g
  extends BaseAdapter
{
  private Context a;
  private List<k> b;
  private boolean c;
  private boolean d;
  
  public g(Context paramContext, List<k> paramList, boolean paramBoolean)
  {
    this(paramContext, paramList, paramBoolean, false);
  }
  
  public g(Context paramContext, List<k> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
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
    String str;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904254, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690084));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689912));
      paramView.setTag(paramViewGroup);
      paramViewGroup.a.setText(((k)this.b.get(paramInt)).getSchemeName() + "x" + ((k)this.b.get(paramInt)).getUsedNum());
      if (!this.c) {
        break label350;
      }
      if (!this.d) {
        break label250;
      }
      str = String.format("%.2f", new Object[] { Double.valueOf(((k)this.b.get(paramInt)).getTotalPrice() * ((k)this.b.get(paramInt)).getUsedNum()) });
      paramViewGroup.b.setText(str + "元");
      paramViewGroup.b.setTextColor(this.a.getResources().getColor(2131624516));
    }
    for (;;)
    {
      paramViewGroup.b.setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label250:
      str = String.format("%.2f", new Object[] { Double.valueOf(((k)this.b.get(paramInt)).getTotalPrice() * ((k)this.b.get(paramInt)).getUsedNum()) });
      paramViewGroup.b.setText(str + "元");
      paramViewGroup.b.setTextColor(this.a.getResources().getColor(2131624097));
    }
    label350:
    paramViewGroup.b.setVisibility(8);
    return paramView;
  }
  
  private static class a
  {
    public TextView a;
    public TextView b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */