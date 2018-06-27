package com.ziroom.ziroomcustomer.sharedlife.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class b
  extends BaseAdapter
{
  private List<String> a;
  private Context b;
  
  public b(Context paramContext, List<String> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    return this.a.size();
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
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.b, 2130904523, null);
      paramView = new a();
      paramView.a = ((TextView)localView.findViewById(2131694990));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText((CharSequence)this.a.get(paramInt));
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public class a
  {
    public TextView a;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */