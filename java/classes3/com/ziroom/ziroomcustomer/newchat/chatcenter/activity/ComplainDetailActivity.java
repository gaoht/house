package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.h;
import com.ziroom.ziroomcustomer.e.c.v;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newchat.chatcenter.a.f;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;

public class ComplainDetailActivity
  extends BaseActivity
{
  private SimpleDraweeView A;
  private RelativeLayout B;
  private View C;
  private LinearLayout D;
  private final String a = "ComplainDetailActivity";
  private ImageView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private LinearLayout g;
  private TextView r;
  private TextView s;
  private TextView t;
  private RelativeLayout u;
  private ListViewForScrollView v;
  private com.ziroom.ziroomcustomer.newchat.chatcenter.b.c w;
  private f x;
  private SimpleDraweeView y;
  private SimpleDraweeView z;
  
  private void a()
  {
    View localView = findViewById(2131689541);
    localView.setFocusable(true);
    localView.setFocusableInTouchMode(true);
    localView.requestFocus();
    localView.requestFocusFromTouch();
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131689852));
    this.d = ((TextView)findViewById(2131690407));
    this.e = ((TextView)findViewById(2131690409));
    this.f = ((TextView)findViewById(2131690084));
    this.g = ((LinearLayout)findViewById(2131690414));
    this.r = ((TextView)findViewById(2131690415));
    this.s = ((TextView)findViewById(2131690416));
    this.t = ((TextView)findViewById(2131690418));
    this.u = ((RelativeLayout)findViewById(2131690419));
    this.v = ((ListViewForScrollView)findViewById(2131690176));
    this.y = ((SimpleDraweeView)findViewById(2131690411));
    this.z = ((SimpleDraweeView)findViewById(2131690412));
    this.A = ((SimpleDraweeView)findViewById(2131690413));
    this.B = ((RelativeLayout)findViewById(2131690410));
    this.C = findViewById(2131690417);
    this.D = ((LinearLayout)findViewById(2131690420));
  }
  
  private void b()
  {
    n.getSuggestDetail(this, getIntent().getStringExtra("consultId"), new h(this, new v(com.ziroom.ziroomcustomer.newchat.chatcenter.b.c.class))
    {
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.newchat.chatcenter.b.c paramAnonymousc)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousc);
        u.d("ComplainDetailActivity", com.alibaba.fastjson.a.toJSONString(paramAnonymousc));
        ComplainDetailActivity.a(ComplainDetailActivity.this, paramAnonymousc);
        if (paramAnonymousc != null) {
          ComplainDetailActivity.a(ComplainDetailActivity.this);
        }
      }
    });
  }
  
  private void e()
  {
    this.c.setText(this.w.getTelDate());
    this.d.setText(this.w.getQuesUpgState());
    this.e.setText(this.w.getBykhType() + "  " + this.w.getComplainType());
    this.f.setText(this.w.getQuesMark());
    int i = this.w.getQuesUpgStateInt();
    label172:
    label235:
    List localList;
    if (2 == i)
    {
      this.g.setVisibility(0);
      this.C.setVisibility(0);
      this.r.setText("受理倒计时预计:");
      this.s.setText(this.w.getLittleTime());
      this.t.setText(this.w.getHandleMan());
      if (!TextUtils.isEmpty(this.w.getHandleMan())) {
        break label392;
      }
      this.u.setVisibility(8);
      if ((this.w.getFollowList() == null) || (this.w.getFollowList().size() <= 0)) {
        break label418;
      }
      this.D.setVisibility(0);
      this.x = new f(this, this.w.getFollowList());
      this.v.setAdapter(this.x);
      localList = this.w.getPicPathList();
      if ((localList == null) || (localList.size() <= 0)) {
        break label565;
      }
      this.B.setVisibility(0);
      if (localList.size() != 1) {
        break label430;
      }
      this.y.setController(com.freelxl.baselibrary.f.c.frescoController((String)localList.get(0)));
      this.z.setController(com.freelxl.baselibrary.f.c.frescoController(""));
      this.A.setController(com.freelxl.baselibrary.f.c.frescoController(""));
    }
    label392:
    label418:
    label430:
    do
    {
      return;
      if ((5 == i) || (6 == i))
      {
        this.g.setVisibility(8);
        this.C.setVisibility(8);
        this.r.setText("完成倒计时预计:");
        break;
      }
      this.g.setVisibility(0);
      this.C.setVisibility(0);
      this.r.setText("处理倒计时预计:");
      break;
      this.u.setVisibility(0);
      this.u.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ah.callPhone(ComplainDetailActivity.this, ComplainDetailActivity.b(ComplainDetailActivity.this).getHandleManTel());
        }
      });
      break label172;
      this.D.setVisibility(8);
      break label235;
      if (localList.size() == 2)
      {
        this.y.setController(com.freelxl.baselibrary.f.c.frescoController((String)localList.get(0)));
        this.z.setController(com.freelxl.baselibrary.f.c.frescoController((String)localList.get(1)));
        this.A.setController(com.freelxl.baselibrary.f.c.frescoController(""));
        return;
      }
    } while (localList.size() != 3);
    this.y.setController(com.freelxl.baselibrary.f.c.frescoController((String)localList.get(0)));
    this.z.setController(com.freelxl.baselibrary.f.c.frescoController((String)localList.get(1)));
    this.A.setController(com.freelxl.baselibrary.f.c.frescoController((String)localList.get(2)));
    return;
    label565:
    this.B.setVisibility(8);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903160);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/ComplainDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */