package com.ziroom.ziroomcustomer.newclean.periodclean.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.f;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.OrderListStatus;
import java.util.List;

public class b
  extends BaseAdapter
{
  private Context a;
  private List<OrderListStatus> b;
  
  public b(Context paramContext, List<OrderListStatus> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public OrderListStatus getItem(int paramInt)
  {
    return (OrderListStatus)this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    OrderListStatus localOrderListStatus;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904436, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131694874));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695535));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695039));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695536));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131695537));
      paramViewGroup.f = paramView.findViewById(2131690678);
      paramView.setTag(paramViewGroup);
      localOrderListStatus = (OrderListStatus)this.b.get(paramInt);
      paramViewGroup.b.setText(localOrderListStatus.getAppointmentTime() + "·");
      paramViewGroup.c.setText(localOrderListStatus.getOrderStatusName());
      paramViewGroup.e.setText("¥" + localOrderListStatus.getAllAmount());
      if (paramInt != 0) {
        break label271;
      }
      paramViewGroup.a.setBackgroundResource(2130839520);
      label204:
      if (!f.isNull(localOrderListStatus.getEmployeeName())) {
        break label283;
      }
      paramViewGroup.d.setVisibility(8);
    }
    for (;;)
    {
      if (this.b.size() > 0)
      {
        if (this.b.size() != 1) {
          break label324;
        }
        paramViewGroup.f.setVisibility(8);
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label271:
      paramViewGroup.a.setBackgroundResource(2130839519);
      break label204;
      label283:
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setText("保洁员·" + localOrderListStatus.getEmployeeName());
    }
    label324:
    if (paramInt == this.b.size() - 1)
    {
      paramViewGroup.f.setVisibility(8);
      return paramView;
    }
    paramViewGroup.f.setVisibility(0);
    return paramView;
  }
  
  public class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public View f;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */