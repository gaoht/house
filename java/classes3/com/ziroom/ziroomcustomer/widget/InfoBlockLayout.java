package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.InfoItem;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class InfoBlockLayout
  extends LinearLayout
{
  private Context a;
  private TextView b;
  private LinearLayout c;
  
  public InfoBlockLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InfoBlockLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2130904109, null);
    paramAttributeSet = new LinearLayout.LayoutParams(-1, -2);
    paramAttributeSet.setLayoutDirection(1);
    this.b = ((TextView)paramContext.findViewById(2131694782));
    this.c = ((LinearLayout)paramContext.findViewById(2131694783));
    addView(paramContext, paramAttributeSet);
  }
  
  public void initData(String paramString, List<InfoItem> paramList)
  {
    int i;
    label46:
    final Object localObject1;
    View localView;
    Object localObject2;
    TextView localTextView;
    ImageView localImageView;
    if (ae.isNull(paramString))
    {
      this.b.setVisibility(8);
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label402;
      }
      this.c.removeAllViews();
      paramString = LayoutInflater.from(this.a);
      i = 0;
      if (i >= paramList.size()) {
        return;
      }
      localObject1 = (InfoItem)paramList.get(i);
      localView = paramString.inflate(2130904247, this.c, false);
      localObject2 = (TextView)localView.findViewById(2131689541);
      localTextView = (TextView)localView.findViewById(2131691546);
      localImageView = (ImageView)localView.findViewById(2131690408);
      ((TextView)localObject2).setText(((InfoItem)localObject1).title);
      localTextView.setText(((InfoItem)localObject1).value);
      if (!((InfoItem)localObject1).isValueLight) {
        break label362;
      }
      localTextView.setTextColor(getResources().getColor(2131624609));
      label159:
      if (((InfoItem)localObject1).isTitle444444)
      {
        ((TextView)localObject2).setTextColor(getResources().getColor(2131624597));
        localTextView.setTextColor(getResources().getColor(2131624599));
      }
      if ((ae.isNull(((InfoItem)localObject1).url)) && (((InfoItem)localObject1).listener == null)) {
        break label392;
      }
      localImageView.setVisibility(0);
      if (ae.isNull(((InfoItem)localObject1).url)) {
        break label379;
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = "";
          if (!localObject1.useH5Title) {
            paramAnonymousView = localObject1.title;
          }
          JsBridgeWebActivity.start(InfoBlockLayout.a(InfoBlockLayout.this), paramAnonymousView, localObject1.url);
        }
      });
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = new View(this.a);
        localObject2 = new LinearLayout.LayoutParams(-1, n.dip2px(this.a, 1.0F) / 2);
        ((LinearLayout.LayoutParams)localObject2).leftMargin = n.dip2px(this.a, 18.0F);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setBackgroundColor(getResources().getColor(2131624604));
        this.c.addView((View)localObject1);
      }
      this.c.addView(localView);
      i += 1;
      break label46;
      this.b.setVisibility(0);
      this.b.setText(paramString);
      break;
      label362:
      localTextView.setTextColor(getResources().getColor(2131624597));
      break label159;
      label379:
      localView.setOnClickListener(((InfoItem)localObject1).listener);
      continue;
      label392:
      localImageView.setVisibility(8);
    }
    label402:
    this.c.setVisibility(8);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/InfoBlockLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */