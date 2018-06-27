package com.ziroom.ziroomcustomer.signed.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.signed.a.d;
import com.ziroom.ziroomcustomer.util.s;
import java.util.List;

public class a
  extends BaseAdapter
{
  Context a;
  List<d> b;
  
  public a(Context paramContext, List<d> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (s.isEmpty(this.b)) {
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
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    d locald = (d)this.b.get(paramInt);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = new a();
      paramViewGroup = View.inflate(this.a, 2130904531, null);
      paramView.b = ((TextView)paramViewGroup.findViewById(2131695674));
      paramView.a = ((TextView)paramViewGroup.findViewById(2131692477));
      paramViewGroup.setTag(paramView);
    }
    ((a)paramViewGroup.getTag()).a.setText(locald.getName());
    return paramViewGroup;
  }
  
  public void setmList(List<d> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  static class a
  {
    TextView a;
    TextView b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */