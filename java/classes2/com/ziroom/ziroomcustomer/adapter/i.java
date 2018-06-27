package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.model.payDetailEntity;
import com.ziroom.ziroomcustomer.util.m;
import java.util.List;

public class i
  extends BaseAdapter
{
  private Context a;
  private List<payDetailEntity> b;
  
  public i(Context paramContext, List<payDetailEntity> paramList)
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
      paramView = LayoutInflater.from(this.a).inflate(2130904271, null);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131689995));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689846));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131693265));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689822));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if ((this.b != null) && (paramInt < this.b.size()))
      {
        Object localObject = (payDetailEntity)this.b.get(paramInt);
        paramViewGroup.a.setText("第" + (paramInt + 1) + "次");
        paramViewGroup.b.setText(((payDetailEntity)localObject).getPayMoney() + "元");
        localObject = m.TimeL2S(m.TimeS2L(((payDetailEntity)localObject).getPayDate(), "yyyy-MM-dd"), "yyyy-MM-dd");
        paramViewGroup.c.setText((CharSequence)localObject);
        paramViewGroup.d.setText("支付成功");
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  private class a
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */