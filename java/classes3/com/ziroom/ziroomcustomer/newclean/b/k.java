package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.o.a;
import java.util.List;

public class k
  extends BaseAdapter
{
  private Context a;
  private List<o.a> b;
  private float c;
  private float d;
  
  public k(Context paramContext, List<o.a> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = (j.getDisplayWidth(this.a) * 46.0F / 375.0F);
    this.d = (j.getDisplayWidth(this.a) * 54.0F / 375.0F);
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
    o.a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904170, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.c = ((RelativeLayout)paramView.findViewById(2131690425));
      paramView.setTag(paramViewGroup);
      locala = (o.a)this.b.get(paramInt);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.b.setText(locala.getServiceInfoName());
      ViewGroup.LayoutParams localLayoutParams = paramViewGroup.a.getLayoutParams();
      localLayoutParams.width = ((int)this.c);
      localLayoutParams.height = ((int)this.c);
      paramViewGroup.a.setLayoutParams(localLayoutParams);
      localLayoutParams = paramViewGroup.b.getLayoutParams();
      localLayoutParams.width = ((int)this.d);
      paramViewGroup.b.setLayoutParams(localLayoutParams);
      if (!TextUtils.isEmpty(locala.getPicUrl())) {
        break label222;
      }
      paramViewGroup.a.setController(c.frescoController(""));
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = (o.a)k.a(k.this).get(paramInt);
          j.click2Clean(k.b(k.this), paramAnonymousView);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label222:
      if (paramViewGroup.a.getTag() == null)
      {
        paramViewGroup.a.setController(c.frescoController(locala.getPicUrl()));
        paramViewGroup.a.setTag(locala.getPicUrl());
      }
      else if (!locala.getPicUrl().equals(paramViewGroup.a.getTag()))
      {
        paramViewGroup.a.setController(c.frescoController(locala.getPicUrl()));
        paramViewGroup.a.setTag(locala.getPicUrl());
      }
    }
  }
  
  public void setData(List<o.a> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public RelativeLayout c;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */