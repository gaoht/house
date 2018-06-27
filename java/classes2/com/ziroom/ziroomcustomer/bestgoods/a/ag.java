package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.activity.GoodsDetailAc;
import com.ziroom.ziroomcustomer.bestgoods.model.al.e;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.Iterator;
import java.util.List;

public class ag
  extends BaseAdapter
{
  private List<al.e> a;
  private Context b;
  
  public ag(Context paramContext, List<al.e> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  private void a(String paramString, FlowLayout paramFlowLayout)
  {
    Button localButton = new Button(this.b);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(-6710887);
    localButton.setTextSize(11.0F);
    int i = n.dip2px(this.b, 7.0F);
    int j = n.dip2px(this.b, 2.0F);
    localButton.setPadding(i, j, i, j);
    localButton.setBackgroundResource(2130840001);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(0, 0, n.dip2px(this.b, 4.0F), 0);
    localButton.setLayoutParams(paramString);
    paramFlowLayout.addView(localButton);
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final al.e locale;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904595, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695838));
      paramViewGroup.b = paramView.findViewById(2131695839);
      paramViewGroup.c = ((TextView)paramView.findViewById(2131693914));
      paramViewGroup.d = ((FlowLayout)paramView.findViewById(2131690332));
      paramViewGroup.e = ((RelativeLayout)paramView.findViewById(2131695840));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131693913));
      paramViewGroup.g = ((RelativeLayout)paramView.findViewById(2131695842));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131695844));
      paramViewGroup.i = ((SimpleDraweeView)paramView.findViewById(2131695845));
      a.a(paramViewGroup, (TextView)paramView.findViewById(2131695841));
      paramView.setTag(paramViewGroup);
      locale = (al.e)this.a.get(paramInt);
      paramViewGroup.a.setText(locale.getActivityName());
      paramViewGroup.c.setText(locale.getActivityDesc());
      if (!TextUtils.isEmpty(locale.getActivityDesc())) {
        break label292;
      }
      paramViewGroup.b.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.i.setController(c.frescoController(locale.getUrl()));
      paramViewGroup.d.removeAllViews();
      Iterator localIterator = locale.getTagNames().iterator();
      while (localIterator.hasNext()) {
        a((String)localIterator.next(), paramViewGroup.d);
      }
      paramViewGroup = (a)paramView.getTag();
      break;
      label292:
      paramViewGroup.b.setVisibility(0);
    }
    paramViewGroup.f.setText(locale.getActivityPrice());
    a.a(paramViewGroup).setText(locale.getActivityTypeName());
    if (!TextUtils.isEmpty(locale.getActivityType()))
    {
      if ((!"1".equals(locale.getActivityType())) && (!"3".equals(locale.getActivityType()))) {
        break label389;
      }
      a.a(paramViewGroup).setBackgroundResource(2130840012);
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!TextUtils.isEmpty(locale.getJumpUrl()))
          {
            paramAnonymousView = locale.getJumpTitle();
            String str1 = locale.getJumpUrl();
            String str2 = locale.getUrl();
            JsBridgeWebActivity.start(ag.a(ag.this), paramAnonymousView, str1, true, "", str2, false);
            return;
          }
          paramAnonymousView = new Intent(ag.a(ag.this), GoodsDetailAc.class);
          paramAnonymousView.putExtra("productCode", locale.getJumpProductCode());
          paramAnonymousView.putExtra("skuCode", locale.getJumpSkuCode());
          ag.a(ag.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      label389:
      a.a(paramViewGroup).setBackgroundResource(2130840011);
    }
  }
  
  public class a
  {
    public TextView a;
    public View b;
    public TextView c;
    public FlowLayout d;
    public RelativeLayout e;
    public TextView f;
    public RelativeLayout g;
    public TextView h;
    public SimpleDraweeView i;
    private TextView k;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */