package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.cardpay.adapter.d;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanCard;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CleanCancleCardActivity
  extends BaseActivity
  implements XListView.a
{
  private ImageView a;
  private XListView b;
  private d c;
  private RelativeLayout d;
  private Context e;
  private List<CleanCard> f = new ArrayList();
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((XListView)findViewById(2131690240));
    this.d = ((RelativeLayout)findViewById(2131690202));
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanCancleCardActivity.this.finish();
      }
    });
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      n.getCleanCardList(this.e, localUserInfo.getUid(), new a(), false);
    }
    this.b.setPullLoadEnable(false);
    this.b.setPullRefreshEnable(true);
    this.b.setXListViewListener(this);
    this.b.setRefreshTime("刚刚");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903141);
    this.e = this;
    a();
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    this.b.setRefreshTime("刚刚");
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      n.getCleanCardList(this.e, localUserInfo.getUid(), new a(), false);
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.e("dsgdsgh:", com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject(a.parseArray(paramString.get("data").toString(), CleanCard.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (List)paramk.getObject();
        if ((paramk != null) && (paramk.size() > 0))
        {
          CleanCancleCardActivity.a(CleanCancleCardActivity.this).clear();
          paramk = paramk.iterator();
          while (paramk.hasNext())
          {
            CleanCard localCleanCard = (CleanCard)paramk.next();
            if (localCleanCard.getCardState() != 2) {
              CleanCancleCardActivity.a(CleanCancleCardActivity.this).add(localCleanCard);
            }
          }
          if ((CleanCancleCardActivity.a(CleanCancleCardActivity.this) != null) && (CleanCancleCardActivity.a(CleanCancleCardActivity.this).size() > 0))
          {
            CleanCancleCardActivity.b(CleanCancleCardActivity.this).setVisibility(8);
            CleanCancleCardActivity.a(CleanCancleCardActivity.this, new d(CleanCancleCardActivity.this, CleanCancleCardActivity.a(CleanCancleCardActivity.this)));
            CleanCancleCardActivity.d(CleanCancleCardActivity.this).setAdapter(CleanCancleCardActivity.c(CleanCancleCardActivity.this));
          }
        }
      }
      for (;;)
      {
        CleanCancleCardActivity.d(CleanCancleCardActivity.this).stopRefresh();
        return;
        CleanCancleCardActivity.b(CleanCancleCardActivity.this).setVisibility(0);
        continue;
        CleanCancleCardActivity.b(CleanCancleCardActivity.this).setVisibility(0);
        continue;
        CleanCancleCardActivity.b(CleanCancleCardActivity.this).setVisibility(0);
        if (!TextUtils.isEmpty(paramk.getMessage())) {
          g.textToast(CleanCancleCardActivity.e(CleanCancleCardActivity.this), paramk.getMessage());
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanCancleCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */