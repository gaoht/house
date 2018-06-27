package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<String> b;
  private int c = 0;
  
  public a(Context paramContext, List<String> paramList, int paramInt)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramInt;
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
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130903679, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131693239));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setText((CharSequence)this.b.get(paramInt));
      if (this.c != paramInt) {
        break;
      }
      paramViewGroup.a.setBackgroundResource(2130839378);
      paramViewGroup.a.setTextColor(this.a.getResources().getColor(2131624583));
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.a.setBackgroundResource(2130839375);
    paramViewGroup.a.setTextColor(this.a.getResources().getColor(2131624516));
    return paramView;
  }
  
  public void setCurrentPosition(int paramInt)
  {
    this.c = paramInt;
  }
  
  public class a
  {
    public TextView a;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */