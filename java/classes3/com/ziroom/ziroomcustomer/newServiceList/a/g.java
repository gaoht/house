package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newServiceList.model.ah.d;
import java.util.List;

public class g
  extends BaseAdapter
{
  List<ah.d> a;
  private Context b;
  private ah.d c;
  
  public g(Context paramContext, List<ah.d> paramList)
  {
    this.b = paramContext;
    this.a = paramList;
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
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904207, null);
      paramViewGroup = new a();
      paramViewGroup.a = paramView.findViewById(2131695036);
      paramViewGroup.b = paramView.findViewById(2131695037);
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690371));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690388));
      paramView.setTag(paramViewGroup);
      this.c = ((ah.d)this.a.get(paramInt));
      if ((this.a.size() > 0) && (this.c != null))
      {
        paramViewGroup.c.setText(this.c.getContent());
        paramViewGroup.d.setText(this.c.getCreateTime());
      }
      if (paramInt == 0)
      {
        if (this.a.size() != 1) {
          break label229;
        }
        paramViewGroup.a.setVisibility(4);
        paramViewGroup.b.setVisibility(4);
      }
    }
    for (;;)
    {
      if ((paramInt == this.a.size() - 1) && (this.a.size() > 1))
      {
        paramViewGroup.a.setVisibility(0);
        paramViewGroup.b.setVisibility(4);
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label229:
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */