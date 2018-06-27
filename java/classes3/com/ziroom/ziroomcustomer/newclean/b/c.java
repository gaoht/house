package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.newclean.d.i;
import java.util.List;

public class c
  extends BaseAdapter
{
  private Context a;
  private List<i> b;
  
  public c(Context paramContext, List<i> paramList)
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
      paramView = View.inflate(this.a, 2130904140, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131690941));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690049));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      i locali = (i)this.b.get(paramInt);
      paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController(locali.getAuthenticatMedalUrl()));
      paramViewGroup.b.setText(locali.getAuthenticatName());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */