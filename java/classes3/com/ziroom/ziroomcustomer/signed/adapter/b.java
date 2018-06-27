package com.ziroom.ziroomcustomer.signed.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.signed.TradeDirectActivity.a;
import com.ziroom.ziroomcustomer.signed.a.p;
import com.ziroom.ziroomcustomer.util.s;
import java.util.List;

public class b
  extends BaseAdapter
{
  public int a;
  public TradeDirectActivity.a b;
  List<p> c;
  Context d;
  int e = -1;
  
  public b(Context paramContext, int paramInt, List<p> paramList)
  {
    this.d = paramContext;
    this.a = paramInt;
    this.c = paramList;
  }
  
  public int getCount()
  {
    if (!s.isEmpty(this.c)) {
      return this.c.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    p localp = (p)this.c.get(paramInt);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramView = new a();
      paramViewGroup = View.inflate(this.d, 2130904566, null);
      paramView.a = ((TextView)paramViewGroup.findViewById(2131695777));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.a.setText(localp.getName());
    if (paramInt == this.e) {
      paramView.a.setTextColor(Color.parseColor("#FFA000"));
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ((b.a)paramAnonymousView.getTag()).a.setTextColor(Color.parseColor("#FFA000"));
          b.this.b.onClick(paramInt, paramInt);
          b.this.e = paramInt;
          b.this.notifyDataSetChanged();
        }
      });
      return paramViewGroup;
      paramView.a.setTextColor(Color.parseColor("#444444"));
    }
  }
  
  public void setCurrentPos(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setList(List<p> paramList)
  {
    this.c = paramList;
  }
  
  public void setListener(TradeDirectActivity.a parama)
  {
    this.b = parama;
  }
  
  static class a
  {
    TextView a;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */