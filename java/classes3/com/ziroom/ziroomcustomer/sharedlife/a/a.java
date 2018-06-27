package com.ziroom.ziroomcustomer.sharedlife.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.sharedlife.c.b.a;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<b.a> b;
  
  public a(Context paramContext, List<b.a> paramList)
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
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904519, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131691744));
      paramView.setTag(paramViewGroup);
    }
    b.a locala;
    for (;;)
    {
      locala = (b.a)this.b.get(paramInt);
      paramViewGroup.a.setText(locala.getOperationMarkedName());
      if (locala.getOperationWeight() != 1) {
        break;
      }
      paramViewGroup.a.setBackgroundResource(2130840009);
      paramViewGroup.a.setTextColor(-1);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    if (locala.getOperationWeight() == 2)
    {
      paramViewGroup.a.setBackgroundResource(2130840007);
      paramViewGroup.a.setTextColor(-6710887);
      return paramView;
    }
    if (locala.getOperationWeight() == 3)
    {
      paramViewGroup.a.setBackgroundResource(2130840006);
      paramViewGroup.a.setTextColor(-1);
      return paramView;
    }
    paramViewGroup.a.setBackgroundResource(2130840006);
    paramViewGroup.a.setTextColor(-1);
    return paramView;
  }
  
  public class a
  {
    public TextView a;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */