package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newclean.d.ay;
import com.ziroom.ziroomcustomer.newmovehouse.b.k;
import java.util.List;

public class o
  extends k
{
  private List<ay> c;
  private Context d;
  
  public o(int paramInt, List<ay> paramList, Context paramContext)
  {
    a(paramInt);
    this.c = paramList;
    this.d = paramContext;
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
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.d).inflate(2130904373, paramViewGroup, false);
      paramView = new a(null);
      paramView.a = localView.findViewById(2131693682);
      paramView.c = localView.findViewById(2131693683);
      paramView.b = localView.findViewById(2131695115);
      paramView.d = localView.findViewById(2131691738);
      paramView.f = ((TextView)localView.findViewById(2131695377));
      paramView.e = ((TextView)localView.findViewById(2131689852));
      localView.setTag(paramView);
    }
    paramView = (a)localView.getTag();
    a(paramView.a, paramView.b, paramView.c, paramView.d, Color.parseColor("#eeeeee"), Color.parseColor("#ffa000"), b(paramInt));
    if ("0".equals(((ay)this.c.get(paramInt)).getFlag()))
    {
      paramView.f.setVisibility(8);
      paramView.e.setTextColor(Color.parseColor("#444444"));
      if (this.b == paramInt) {
        paramView.e.setTextColor(40960);
      }
    }
    for (;;)
    {
      paramView.e.setText(((ay)this.c.get(paramInt)).getTimePoint());
      return localView;
      paramView.e.setTextColor(-12303292);
      continue;
      paramView.f.setVisibility(0);
      paramView.e.setTextColor(Color.parseColor("#dddddd"));
    }
  }
  
  public void setData(List<ay> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public void setSelectPosition(int paramInt)
  {
    this.b = paramInt;
    notifyDataSetChanged();
  }
  
  private class a
  {
    View a;
    View b;
    View c;
    View d;
    TextView e;
    TextView f;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */