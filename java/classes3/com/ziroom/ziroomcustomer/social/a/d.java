package com.ziroom.ziroomcustomer.social.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.social.model.q;
import java.util.List;

public class d
  extends BaseAdapter
{
  private List<q> a;
  private Context b;
  private b c;
  
  public d(Context paramContext, List<q> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904539, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131695668));
      paramView.setTag(paramViewGroup);
      paramViewGroup.a.setText(((q)this.a.get(paramInt)).getDescription());
      if (!((q)this.a.get(paramInt)).isSelect()) {
        break label131;
      }
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = 0;
          if (i < d.a(d.this).size())
          {
            if (i == paramInt) {
              ((q)d.a(d.this).get(i)).setSelect(true);
            }
            for (;;)
            {
              i += 1;
              break;
              ((q)d.a(d.this).get(i)).setSelect(false);
            }
          }
          if (d.b(d.this) != null) {
            d.b(d.this).conplainInfo(paramInt);
          }
          d.this.notifyDataSetChanged();
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label131:
      paramViewGroup.b.setVisibility(8);
    }
  }
  
  public void setOnPosComplainListener(b paramb)
  {
    this.c = paramb;
  }
  
  public class a
  {
    public TextView a;
    public ImageView b;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void conplainInfo(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */