package com.ziroom.ziroomcustomer.minsu.landlordrelease.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.UsageTipsBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.UsageTipsBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.UsageTipsBean.DataBean.TipMsgBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.UsageTipsBean.DataBean.TipMsgBean.SubTitleContentsBean;
import java.util.HashMap;
import java.util.List;

public class ReleaseUsageAndTipsView
  extends RelativeLayout
{
  private Context a;
  private TextView b;
  private String c;
  private String d;
  private ReleaseUsageTipsPop e;
  private List<UsageTipsBean.DataBean.TipMsgBean.SubTitleContentsBean> f;
  private HashMap<String, String> g = new HashMap();
  
  public ReleaseUsageAndTipsView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReleaseUsageAndTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReleaseUsageAndTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    if (this.e == null)
    {
      this.e = new ReleaseUsageTipsPop(this.a);
      this.e.setFocusable(true);
    }
    if (this.e.isShowing()) {
      this.e.dismiss();
    }
  }
  
  private void a(final Context paramContext)
  {
    this.a = paramContext;
    paramContext = View.inflate(paramContext, 2130905086, this);
    this.b = ((TextView)paramContext.findViewById(2131697380));
    a();
    paramContext.findViewById(2131696874).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (!com.ziroom.ziroomcustomer.util.s.isEmpty(ReleaseUsageAndTipsView.a(ReleaseUsageAndTipsView.this))) {
          ReleaseUsageAndTipsView.c(ReleaseUsageAndTipsView.this).show(paramContext, ReleaseUsageAndTipsView.a(ReleaseUsageAndTipsView.this), ReleaseUsageAndTipsView.b(ReleaseUsageAndTipsView.this));
        }
      }
    });
  }
  
  private void getData()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.showMsgByCode((Activity)this.a, this.c, new com.ziroom.ziroomcustomer.minsu.f.s((Activity)this.a, new r(UsageTipsBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        if (!((UsageTipsBean)paramAnonymousObject).checkSuccess((Activity)this.b)) {}
        while ((paramAnonymousObject == null) || (((UsageTipsBean)paramAnonymousObject).getData() == null) || (((UsageTipsBean)paramAnonymousObject).getData().getTipMsg() == null)) {
          return;
        }
        ReleaseUsageAndTipsView.a(ReleaseUsageAndTipsView.this, ((UsageTipsBean)paramAnonymousObject).getData().getTipMsg().getSubTitleContents());
        ReleaseUsageAndTipsView.a(ReleaseUsageAndTipsView.this, ((UsageTipsBean)paramAnonymousObject).getData().getTipMsg().getTitle());
      }
    });
  }
  
  public void setCode(String paramString)
  {
    this.c = paramString;
    String str = "";
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        paramString = str;
      }
      break;
    }
    for (;;)
    {
      this.b.setText(paramString);
      getData();
      return;
      if (!paramString.equals("TIP_WHY_AUTH")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("TIP_HOW_CHOOSE_RENT_WAY")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("TIP_HOW_WRITE_LOCATION")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("TIP_HOW_WRITE_DESC")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("TIP_WRITE_ROOM_MSG")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("TIP_ORDER_TYPE_EFFECT")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("TIP_HOW_UPLOAD_HOUSE_PIC")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("TIP_HOW_PUBLISH_MULTI_ROOM")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("TIP_HOW_WRITE_MANAGE_ROOM_MSG")) {
        break;
      }
      i = 8;
      break;
      if (!paramString.equals("TIP_HOW_WRITE_RENT_WAY_LOCATION")) {
        break;
      }
      i = 9;
      break;
      paramString = "资质认证信息是否可以修改？";
      continue;
      paramString = "如何选择出租方式？";
      continue;
      paramString = "位置信息可以修改么？";
      continue;
      paramString = "如何撰写描述信息让您的房子更有吸引力";
      continue;
      paramString = "如何填写户型和房间信息？";
      continue;
      paramString = "点击了解立即预订和退订政策";
      continue;
      paramString = "点击查看房源照片要求";
      continue;
      paramString = "如何选择您准备出租的房间数量？";
      continue;
      paramString = "如何填写户型和房间信息？";
      continue;
      paramString = "如何填写类型和位置信息？";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/view/ReleaseUsageAndTipsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */