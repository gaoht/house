package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.text.TextUtils;
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
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.o.a;
import java.util.List;

public class l
  extends BaseAdapter
{
  private Context a;
  private List<o.a> b;
  private float c;
  
  public l(Context paramContext, List<o.a> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = (j.getDisplayWidth(this.a) * 161.0F / 375.0F);
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
      paramView.setTag(paramViewGroup);
      locala = (o.a)this.b.get(paramInt);
      paramViewGroup.b.setVisibility(8);
      ViewGroup.LayoutParams localLayoutParams = paramViewGroup.a.getLayoutParams();
      float f = this.c * 60.0F / 161.0F;
      localLayoutParams.width = ((int)this.c);
      localLayoutParams.height = ((int)f);
      paramViewGroup.a.setLayoutParams(localLayoutParams);
      if (!TextUtils.isEmpty(locala.getPicUrl())) {
        break label180;
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
          paramAnonymousView = (o.a)l.a(l.this).get(paramInt);
          j.click2Clean(l.b(l.this), paramAnonymousView);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label180:
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
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */