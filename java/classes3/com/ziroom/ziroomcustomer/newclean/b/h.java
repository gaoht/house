package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.d.k.a;
import java.util.List;

public class h
  extends BaseAdapter
{
  private Context a;
  private List<k.a> b;
  
  public h(Context paramContext, List<k.a> paramList)
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
      paramView = View.inflate(this.a, 2130904137, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690084));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      k.a locala = (k.a)this.b.get(paramInt);
      paramViewGroup.b.setText(locala.getEvaluateContent());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */