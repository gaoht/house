package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class k
  extends BaseAdapter
{
  private Context a;
  private int b = 0;
  private List<String> c;
  
  public k(Context paramContext, List<String> paramList)
  {
    this.a = paramContext;
    this.c = paramList;
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getSelectItem()
  {
    return this.b;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new a();
      localView = View.inflate(this.a, 2130904260, null);
      a.a(paramView, (TextView)localView.findViewById(2131695040));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      if (paramInt != this.b) {
        break label109;
      }
      a.a(paramViewGroup).setBackgroundColor(-1);
      a.a(paramViewGroup).setTextColor(-12303292);
    }
    for (;;)
    {
      a.a(paramViewGroup).setText((CharSequence)this.c.get(paramInt));
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label109:
      a.a(paramViewGroup).setBackgroundColor(-394759);
      a.a(paramViewGroup).setTextColor(-6710887);
    }
  }
  
  public void setSelectItem(int paramInt)
  {
    this.b = paramInt;
  }
  
  static class a
  {
    private TextView a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */