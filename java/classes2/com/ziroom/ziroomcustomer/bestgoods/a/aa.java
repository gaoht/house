package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
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
import com.ziroom.ziroomcustomer.bestgoods.model.ay;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.n;
import java.text.DecimalFormat;
import java.util.List;

public class aa
  extends BaseAdapter
{
  private Context a;
  private List<ay> b;
  private float c;
  
  public aa(Context paramContext, List<ay> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = ((j.getDisplayWidth(paramContext) - n.dip2px(paramContext, 32.0F) - n.dip2px(paramContext, 4.0F) * 3) / 3.0F);
  }
  
  public int getCount()
  {
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
      paramView = LayoutInflater.from(this.a).inflate(2130904588, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131689846));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = paramViewGroup.a.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)this.c);
      ((ViewGroup.LayoutParams)localObject).height = ((int)this.c);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramViewGroup.a.setController(c.frescoController(((ay)this.b.get(paramInt)).getPicUrl()));
      paramViewGroup.b.setText(((ay)this.b.get(paramInt)).getTitle());
      localObject = new DecimalFormat("0.00");
      paramViewGroup.c.setText("￥" + ((DecimalFormat)localObject).format(((ay)this.b.get(paramInt)).getPrice()) + "*" + ((ay)this.b.get(paramInt)).getAmount());
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */