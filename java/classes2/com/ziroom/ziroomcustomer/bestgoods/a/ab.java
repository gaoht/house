package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.bestgoods.model.ai.a.a;
import java.text.DecimalFormat;
import java.util.List;

public class ab
  extends BaseAdapter
{
  private Context a;
  private List<ai.a.a> b;
  
  public ab(Context paramContext, List<ai.a.a> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904589, null);
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131695833));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695834));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695835));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695836));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setController(c.frescoController(((ai.a.a)this.b.get(paramInt)).getSkuImg()));
      paramViewGroup.b.setText(((ai.a.a)this.b.get(paramInt)).getSkuName());
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
      paramViewGroup.c.setText("￥" + localDecimalFormat.format(((ai.a.a)this.b.get(paramInt)).getPrice()) + "");
      paramViewGroup.d.setText("x" + ((ai.a.a)this.b.get(paramInt)).getAmount());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public static class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */