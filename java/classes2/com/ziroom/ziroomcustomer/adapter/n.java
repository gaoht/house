package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.c.b;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.List;

public class n
  extends BaseAdapter
{
  private Context a;
  private List<b> b;
  private int c = 0;
  private b d = null;
  
  public n(Context paramContext, List<b> paramList, int paramInt)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramInt;
  }
  
  public int getCount()
  {
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
    b localb;
    TextView localTextView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904565, paramViewGroup, false);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((RelativeLayout)paramView.findViewById(2131695770));
      paramViewGroup.b = ((RelativeLayout)paramView.findViewById(2131695771));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690084));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131690724));
      paramViewGroup.f = ((LinearLayout)paramView.findViewById(2131695776));
      paramViewGroup.g = paramView.findViewById(2131695775);
      paramView.setTag(paramViewGroup);
      localObject = new LinearLayout.LayoutParams(-1, -1);
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(this.c, -1);
      paramViewGroup.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localb = (b)this.b.get(paramInt);
      localTextView = paramViewGroup.c;
      if (!ae.isNull(localb.e)) {
        break label378;
      }
      localObject = "自如消息";
      label201:
      localTextView.setText((CharSequence)localObject);
      localTextView = paramViewGroup.d;
      if (!ae.isNull(localb.d)) {
        break label388;
      }
    }
    label378:
    label388:
    for (Object localObject = "消息内容为空";; localObject = localb.d)
    {
      localTextView.setText((CharSequence)localObject);
      paramViewGroup.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (n.a(n.this) != null) {
            n.a(n.this).onRightItemClick(paramAnonymousView, paramInt);
          }
        }
      });
      if (((b)this.b.get(paramInt)).m == 0) {
        com.ziroom.ziroomcustomer.service.e.sendMessageDeal(this.a, localb);
      }
      if ((ae.isNull(localb.f)) || (ae.isNull(a.parseObject(localb.f).getString("msg_has_response"))) || (!ae.isOrderNumeric(a.parseObject(localb.f).getString("msg_has_response")))) {
        break label418;
      }
      if (1 != Integer.parseInt(a.parseObject(localb.f).getString("msg_has_response"))) {
        break label398;
      }
      paramViewGroup.f.setVisibility(0);
      paramViewGroup.g.setVisibility(0);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      localObject = localb.e;
      break label201;
    }
    label398:
    paramViewGroup.f.setVisibility(8);
    paramViewGroup.g.setVisibility(8);
    return paramView;
    label418:
    paramViewGroup.f.setVisibility(8);
    paramViewGroup.g.setVisibility(8);
    return paramView;
  }
  
  public void setOnRightItemClickListener(b paramb)
  {
    this.d = paramb;
  }
  
  private class a
  {
    RelativeLayout a;
    RelativeLayout b;
    TextView c;
    TextView d;
    ImageView e;
    LinearLayout f;
    View g;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onRightItemClick(View paramView, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */