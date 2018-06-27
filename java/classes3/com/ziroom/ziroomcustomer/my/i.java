package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.model.Contract;
import java.util.List;

public class i
  extends BaseAdapter
{
  private Context a;
  private List<Contract> b;
  
  public i(Context paramContext, List<Contract> paramList)
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
      paramView = LayoutInflater.from(this.a).inflate(2130904956, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131696969));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131696970));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131696971));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131696973));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131695570));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131696972));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup = (Contract)this.b.get(paramInt);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public void setData(List<Contract> paramList)
  {
    this.b = paramList;
  }
  
  private class a
  {
    ImageView a;
    TextView b;
    TextView c;
    ImageView d;
    TextView e;
    TextView f;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */