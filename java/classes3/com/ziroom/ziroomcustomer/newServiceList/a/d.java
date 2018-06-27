package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newServiceList.model.aw;
import com.ziroom.ziroomcustomer.newServiceList.utils.g;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.util.x;
import java.util.List;

public class d
  extends BaseAdapter
{
  private Context a;
  private List<aw> b;
  
  public d(Context paramContext, List<aw> paramList)
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904490, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
      paramView.setTag(paramViewGroup);
      paramViewGroup.b.setVisibility(8);
      localObject = paramViewGroup.a.getLayoutParams();
      float f1 = (j.getDisplayWidth(this.a) - n.dip2px(this.a, 10.0F) - n.dip2px(this.a, 18.0F) * 2) / 2.0F;
      float f2 = 76.0F * f1 / 166.0F;
      ((ViewGroup.LayoutParams)localObject).width = ((int)f1);
      ((ViewGroup.LayoutParams)localObject).height = ((int)f2);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (!TextUtils.isEmpty(((aw)this.b.get(paramInt)).getNetIcon())) {
        break label220;
      }
      paramViewGroup.a.setController(c.frescoFromResourceController(((aw)this.b.get(paramInt)).getResIcon()));
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          u.d("sdjgklj", "=======  " + a.toJSONString(d.a(d.this).get(paramInt)));
          g.startActivityByPageBean(d.b(d.this), (aw)d.a(d.this).get(paramInt));
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label220:
      localObject = x.makeUrl(((aw)this.b.get(paramInt)).getNetIcon(), 0.5F);
      if (paramViewGroup.a.getTag() == null)
      {
        paramViewGroup.a.setTag(localObject);
        paramViewGroup.a.setController(c.frescoController((String)localObject));
      }
      else if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(paramViewGroup.a.getTag())))
      {
        paramViewGroup.a.setTag(localObject);
        paramViewGroup.a.setController(c.frescoController((String)localObject));
      }
    }
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */