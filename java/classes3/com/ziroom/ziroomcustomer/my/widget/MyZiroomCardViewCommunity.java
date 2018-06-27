package com.ziroom.ziroomcustomer.my.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.my.model.RecommendActivitiesModel;
import com.ziroom.ziroomcustomer.my.model.RecommendActivitiesModel.ContentBean;
import com.ziroom.ziroomcustomer.social.activity.ac.AcMainActivity;
import com.ziroom.ziroomcustomer.social.b.d;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class MyZiroomCardViewCommunity
  extends LinearLayout
  implements View.OnClickListener
{
  private Context a;
  private TextView b;
  private TextView c;
  private SimpleDraweeView d;
  private LinearLayout e;
  
  public MyZiroomCardViewCommunity(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MyZiroomCardViewCommunity(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MyZiroomCardViewCommunity(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    inflate(this.a, 2130904751, this);
    this.b = ((TextView)findViewById(2131694638));
    this.c = ((TextView)findViewById(2131696341));
    this.d = ((SimpleDraweeView)findViewById(2131696342));
    this.e = ((LinearLayout)findViewById(2131696343));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    Object localObject = (RecommendActivitiesModel.ContentBean)paramView.getTag();
    if (localObject == null) {
      return;
    }
    if ("0".equals(((RecommendActivitiesModel.ContentBean)localObject).getApp()))
    {
      JsBridgeWebActivity.start(this.a, ((RecommendActivitiesModel.ContentBean)localObject).getTitle(), ((RecommendActivitiesModel.ContentBean)localObject).getTarget());
      return;
    }
    paramView = new Intent();
    localObject = ((RecommendActivitiesModel.ContentBean)localObject).getTarget();
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
      case 0: 
        d.toZzSocialChat(this.a);
        return;
        if (((String)localObject).equals("liaotian"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("huodong")) {
            i = 1;
          }
        }
        break;
      }
    }
    paramView.setClass(this.a, AcMainActivity.class);
    this.a.startActivity(paramView);
  }
  
  public void setContent(RecommendActivitiesModel paramRecommendActivitiesModel)
  {
    if ((paramRecommendActivitiesModel == null) || (paramRecommendActivitiesModel.getContent() == null) || (paramRecommendActivitiesModel.getContent().size() < 1)) {
      setVisibility(8);
    }
    for (;;)
    {
      return;
      setVisibility(0);
      this.b.setText(paramRecommendActivitiesModel.getTitle());
      this.c.setText(paramRecommendActivitiesModel.getSubtitle());
      paramRecommendActivitiesModel = paramRecommendActivitiesModel.getContent();
      if (paramRecommendActivitiesModel.size() == 1)
      {
        paramRecommendActivitiesModel = (RecommendActivitiesModel.ContentBean)paramRecommendActivitiesModel.get(0);
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        this.d.setController(c.frescoController(paramRecommendActivitiesModel.getImg()));
        this.d.setTag(paramRecommendActivitiesModel);
        this.d.setOnClickListener(this);
        return;
      }
      this.d.setVisibility(8);
      this.e.setVisibility(0);
      int i = 0;
      while (i < this.e.getChildCount())
      {
        RecommendActivitiesModel.ContentBean localContentBean = (RecommendActivitiesModel.ContentBean)paramRecommendActivitiesModel.get(i);
        SimpleDraweeView localSimpleDraweeView = (SimpleDraweeView)this.e.getChildAt(i);
        localSimpleDraweeView.setController(c.frescoController(localContentBean.getImg()));
        localSimpleDraweeView.setTag(localContentBean);
        localSimpleDraweeView.setOnClickListener(this);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/MyZiroomCardViewCommunity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */