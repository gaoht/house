package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.model.LeaseListEntity;
import java.util.List;

public class a
  extends BaseAdapter
{
  private List<LeaseListEntity> a;
  private Context b;
  
  public a(Context paramContext, List<LeaseListEntity> paramList)
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
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.b, 2130904180, null);
      paramView = new a();
      paramView.a = ((TextView)localView.findViewById(2131694963));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.a.setText(((LeaseListEntity)this.a.get(paramInt)).getAddress());
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */