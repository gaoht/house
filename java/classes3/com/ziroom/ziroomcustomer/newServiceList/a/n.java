package com.ziroom.ziroomcustomer.newServiceList.a;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newServiceList.model.aw;
import com.ziroom.ziroomcustomer.newServiceList.utils.g;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.x;
import java.util.List;

public class n
  extends PagerAdapter
{
  private LayoutInflater a;
  private List<aw> b;
  private Context c;
  
  public n(Context paramContext, List<aw> paramList)
  {
    this.c = paramContext;
    this.a = LayoutInflater.from(paramContext);
    this.b = paramList;
    this.c = paramContext;
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.findViewById(2131694449).getLayoutParams();
    float f1 = j.getDisplayWidth(this.c) * 339.0F / 375.0F;
    float f2 = 9.0F * f1 / 16.0F;
    localLayoutParams.width = ((int)f1);
    localLayoutParams.height = ((int)f2);
    paramView.findViewById(2131694449).setLayoutParams(localLayoutParams);
  }
  
  public void convert(final int paramInt, View paramView)
  {
    paramView = (SimpleDraweeView)paramView.findViewById(2131694449);
    String str = x.makeUrl(((aw)this.b.get(paramInt)).getNetIcon());
    if (paramView.getTag() == null)
    {
      paramView.setTag(str);
      paramView.setController(c.frescoController(str));
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = (aw)n.a(n.this).get(paramInt);
          g.startActivityByPageBean(n.b(n.this), paramAnonymousView);
        }
      });
      return;
      if ((!TextUtils.isEmpty(str)) && (!str.equals(paramView.getTag())))
      {
        paramView.setTag(str);
        paramView.setController(c.frescoController(str));
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.b == null) {
      return paramViewGroup;
    }
    View localView = this.a.inflate(2130904509, paramViewGroup, false);
    a(localView);
    convert(paramInt, localView);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView.equals(paramObject);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */