package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newServiceList.model.ad;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import java.util.List;

public class q
  extends BaseAdapter
{
  private Context a;
  private List<ad> b;
  private ad c;
  
  public q(Context paramContext, List<ad> paramList)
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
      paramView = View.inflate(this.a, 2130904207, null);
      paramViewGroup = new a();
      paramViewGroup.a = paramView.findViewById(2131695036);
      paramViewGroup.b = paramView.findViewById(2131695037);
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690371));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690388));
      paramView.setTag(paramViewGroup);
      this.c = ((ad)this.b.get(paramInt));
      paramViewGroup.c.setText(this.c.getDescribe());
      paramViewGroup.d.setText(i.getSysData(this.c.getTime()));
      if (paramInt == 0)
      {
        if (this.b.size() != 1) {
          break label213;
        }
        paramViewGroup.a.setVisibility(4);
        paramViewGroup.b.setVisibility(4);
      }
    }
    for (;;)
    {
      if ((paramInt == this.b.size() - 1) && (this.b.size() > 1))
      {
        paramViewGroup.a.setVisibility(0);
        paramViewGroup.b.setVisibility(4);
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label213:
      paramViewGroup.a.setVisibility(4);
      paramViewGroup.b.setVisibility(0);
    }
  }
  
  public class a
  {
    public View a;
    public View b;
    public TextView c;
    public TextView d;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */