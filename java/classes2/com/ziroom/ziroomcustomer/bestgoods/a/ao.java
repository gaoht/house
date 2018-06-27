package com.ziroom.ziroomcustomer.bestgoods.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGroupListActivity_New;
import com.ziroom.ziroomcustomer.bestgoods.model.u.a.a;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.n;
import java.text.DecimalFormat;
import java.util.List;

class ao
  extends BaseAdapter
{
  private final float a;
  private YouPinGroupListActivity_New b;
  private List<u.a.a> c;
  
  public ao(YouPinGroupListActivity_New paramYouPinGroupListActivity_New, List<u.a.a> paramList)
  {
    this.b = paramYouPinGroupListActivity_New;
    this.c = paramList;
    this.a = ((j.getDisplayWidth(paramYouPinGroupListActivity_New) - n.dip2px(paramYouPinGroupListActivity_New, 68.0F) - n.dip2px(paramYouPinGroupListActivity_New, 4.0F) * 8) / 3.0F);
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
      paramView = LayoutInflater.from(this.b).inflate(2130904590, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131689846));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = paramViewGroup.a.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)this.a);
      ((ViewGroup.LayoutParams)localObject).height = ((int)this.a);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramViewGroup.a.setController(c.frescoController(((u.a.a)this.c.get(paramInt)).getSkuImg()));
      paramViewGroup.b.setText(((u.a.a)this.c.get(paramInt)).getSkuName());
      localObject = new DecimalFormat("0.00");
      paramViewGroup.c.setText("￥" + ((DecimalFormat)localObject).format(((u.a.a)this.c.get(paramInt)).getPrice()) + "*" + ((u.a.a)this.c.get(paramInt)).getAmount());
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */