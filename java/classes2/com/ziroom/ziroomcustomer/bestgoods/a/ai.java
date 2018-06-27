package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.bestgoods.model.ao.a;
import java.util.List;

public class ai
  extends BaseAdapter
{
  private Context a;
  private List<ao.a> b;
  
  public ai(Context paramContext, List<ao.a> paramList)
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
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130904596, null);
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131689999));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695846));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695847));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689991));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setController(c.frescoController(((ao.a)this.b.get(paramInt)).getSkuImg()));
      paramViewGroup.b.setText(((ao.a)this.b.get(paramInt)).getSkuName());
      paramViewGroup.c.setText(((ao.a)this.b.get(paramInt)).getSpecificationName() + " x" + ((ao.a)this.b.get(paramInt)).getAmount());
      paramViewGroup.d.setText("￥" + ((ao.a)this.b.get(paramInt)).getPrice());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */