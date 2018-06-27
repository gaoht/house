package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.ziroom.ziroomcustomer.util.n;
import java.text.DecimalFormat;
import java.util.List;

public class a
  extends BaseAdapter
{
  private Context a;
  private List<com.ziroom.ziroomcustomer.bestgoods.model.a> b;
  
  public a(Context paramContext, List<com.ziroom.ziroomcustomer.bestgoods.model.a> paramList)
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
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.a, 2130904134, null);
      paramViewGroup.a = ((RelativeLayout)paramView.findViewById(2131694863));
      paramViewGroup.b = ((SimpleDraweeView)paramView.findViewById(2131694864));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690720));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131689991));
      paramView.setTag(paramViewGroup);
      localObject = (LinearLayout.LayoutParams)paramViewGroup.a.getLayoutParams();
      if ((paramInt - (this.b.size() - 1) != 0) && (paramInt - (this.b.size() - 1) != 1)) {
        break label269;
      }
      ((LinearLayout.LayoutParams)localObject).bottomMargin = n.dip2px(this.a, 32.0F);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramViewGroup.b.setController(c.frescoController(((com.ziroom.ziroomcustomer.bestgoods.model.a)this.b.get(paramInt)).getImgUrl()));
      paramViewGroup.c.setText(((com.ziroom.ziroomcustomer.bestgoods.model.a)this.b.get(paramInt)).getSkuName());
      localObject = new DecimalFormat("0.00");
      if (((com.ziroom.ziroomcustomer.bestgoods.model.a)this.b.get(paramInt)).getActiveType() != null) {
        break label295;
      }
      paramViewGroup.d.setText(((DecimalFormat)localObject).format(((com.ziroom.ziroomcustomer.bestgoods.model.a)this.b.get(paramInt)).getPrice()));
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label269:
      ((LinearLayout.LayoutParams)localObject).bottomMargin = n.dip2px(this.a, 8.0F);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label295:
    paramViewGroup.d.setText(((DecimalFormat)localObject).format(((com.ziroom.ziroomcustomer.bestgoods.model.a)this.b.get(paramInt)).getActivePrice()));
    return paramView;
  }
  
  class a
  {
    RelativeLayout a;
    SimpleDraweeView b;
    TextView c;
    TextView d;
    
    a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */