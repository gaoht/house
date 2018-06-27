package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newrepair.b.l;
import java.util.List;

public class h
  extends BaseAdapter
{
  private Context a;
  private List<l> b;
  
  public h(Context paramContext, List<l> paramList)
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
      paramView = LayoutInflater.from(this.a).inflate(2130904476, null);
      paramViewGroup = new a(null);
      paramViewGroup.e = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695579));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695580));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695585));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695587));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.e.setText("报修项" + (paramInt + 1));
      paramViewGroup.a.setText(((l)this.b.get(paramInt)).getKongjianName());
      paramViewGroup.b.setText(((l)this.b.get(paramInt)).getZhutiName() + "  " + ((l)this.b.get(paramInt)).getXiangmuName());
      paramViewGroup.c.setText(((l)this.b.get(paramInt)).getFaultType());
      paramViewGroup.d.setText(((l)this.b.get(paramInt)).getFaultReason());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  private static class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */