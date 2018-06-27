package com.ziroom.ziroomcustomer.sharedlife.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.sharedlife.c.b.a;
import java.util.List;

public class f
  extends BaseAdapter
{
  private Context a;
  private List<b.a> b;
  private int c = -1;
  
  public f(Context paramContext, List<b.a> paramList)
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
    label130:
    label153:
    b.a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904520, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((LinearLayout)paramView.findViewById(2131695222));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690073));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689912));
      paramViewGroup.e = paramView.findViewById(2131690379);
      paramViewGroup.f = paramView.findViewById(2131692133);
      paramView.setTag(paramViewGroup);
      if (this.b.size() <= 1) {
        break label281;
      }
      if (paramInt != 0) {
        break label257;
      }
      paramViewGroup.e.setVisibility(0);
      if (paramInt != this.b.size() - 1) {
        break label269;
      }
      paramViewGroup.f.setVisibility(0);
      locala = (b.a)this.b.get(paramInt);
      if (this.c != paramInt) {
        break label302;
      }
      paramViewGroup.a.setBackgroundResource(2130840419);
    }
    for (;;)
    {
      paramViewGroup.b.setText(locala.getOperationMarkedName());
      paramViewGroup.c.setText(locala.getOperationContent());
      paramInt = locala.getOrderMoney() / 100;
      paramViewGroup.d.setText("￥" + paramInt);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label257:
      paramViewGroup.e.setVisibility(8);
      break label130;
      label269:
      paramViewGroup.f.setVisibility(8);
      break label153;
      label281:
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.f.setVisibility(8);
      break label153;
      label302:
      paramViewGroup.a.setBackgroundResource(2130840415);
    }
  }
  
  public void setSelectPosition(int paramInt)
  {
    this.c = paramInt;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public LinearLayout a;
    public TextView b;
    public TextView c;
    public TextView d;
    public View e;
    public View f;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */