package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import java.util.ArrayList;
import java.util.List;

public class ac
  extends BaseAdapter
{
  private List<String> a = new ArrayList();
  private Context b;
  
  public ac(Context paramContext, List<String> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
  }
  
  public int getCount()
  {
    if (this.a.size() == 4) {
      return 4;
    }
    return this.a.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130904160, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694918));
      paramViewGroup.b = paramView.findViewById(2131694917);
      paramView.setTag(paramViewGroup);
    }
    while (paramInt >= this.a.size())
    {
      paramViewGroup.a.setController(c.frescoFromResourceController(2130840096));
      paramViewGroup.b.setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    if (paramViewGroup.a.getTag() == null)
    {
      paramViewGroup.a.setController(c.frescoController((String)this.a.get(paramInt)));
      paramViewGroup.a.setTag(this.a.get(paramInt));
    }
    for (;;)
    {
      paramViewGroup.b.setVisibility(8);
      return paramView;
      if (!((String)this.a.get(paramInt)).equals(paramViewGroup.a.getTag()))
      {
        paramViewGroup.a.setController(c.frescoController((String)this.a.get(paramInt)));
        paramViewGroup.a.setTag(this.a.get(paramInt));
      }
    }
  }
  
  public void setData(List<String> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public View b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */