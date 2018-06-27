package com.ziroom.ziroomcustomer.newmovehouse.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newmovehouse.model.LatPoint;
import java.util.List;

public class a
  extends BaseAdapter
{
  private List<LatPoint> a;
  private Context b;
  
  public a(List<LatPoint> paramList, Context paramContext)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
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
    View localView = LayoutInflater.from(this.b).inflate(2130904370, paramViewGroup, false);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = new a(null);
      paramView.a = ((TextView)localView.findViewById(2131695366));
      paramView.b = ((TextView)localView.findViewById(2131695367));
      localView.setTag(paramView);
      paramViewGroup = localView;
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.a.setText(((LatPoint)this.a.get(paramInt)).getName());
    paramView.b.setText(((LatPoint)this.a.get(paramInt)).getAddress());
    return paramViewGroup;
  }
  
  private class a
  {
    TextView a;
    TextView b;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */