package com.ziroom.ziroomcustomer.sharedlife.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.sharedlife.c.b.a;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SharedLifeEquipmentDetailActivity
  extends BaseActivity
{
  private String A;
  private String B;
  private com.ziroom.ziroomcustomer.sharedlife.c.b C;
  private String D;
  private String E;
  private int F = 0;
  private Timer G;
  private TimerTask H;
  private boolean I = false;
  Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1) {
        SharedLifeEquipmentDetailActivity.c(SharedLifeEquipmentDetailActivity.this).setText(com.ziroom.ziroomcustomer.sharedlife.d.a.getFormatTime(SharedLifeEquipmentDetailActivity.b(SharedLifeEquipmentDetailActivity.this)));
      }
      super.handleMessage(paramAnonymousMessage);
    }
  };
  private Context b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private SimpleDraweeView f;
  private RelativeLayout g;
  private ImageView r;
  private TextView s;
  private TextView t;
  private ListView u;
  private ListView v;
  private RelativeLayout w;
  private TextView x;
  private LottieAnimationView y;
  private int z;
  
  private void a()
  {
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((TextView)findViewById(2131689541));
    this.e = ((TextView)findViewById(2131692348));
    this.g = ((RelativeLayout)findViewById(2131692344));
    this.f = ((SimpleDraweeView)findViewById(2131692346));
    this.y = ((LottieAnimationView)findViewById(2131692347));
    this.r = ((ImageView)findViewById(2131692345));
    this.s = ((TextView)findViewById(2131692349));
    this.t = ((TextView)findViewById(2131692350));
    this.u = ((ListView)findViewById(2131692351));
    this.w = ((RelativeLayout)findViewById(2131692352));
    this.v = ((ListView)findViewById(2131692355));
    this.x = ((TextView)findViewById(2131692354));
  }
  
  private void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.f.setVisibility(4);
      this.y.setVisibility(0);
      this.r.setVisibility(0);
      this.y.setImageAssetsFolder("lsj/");
      this.y.setAnimation(paramString);
      this.y.loop(true);
      this.y.playAnimation();
    }
    while (paramInt != 1) {
      return;
    }
    this.f.setVisibility(0);
    this.y.setVisibility(4);
    this.r.setVisibility(8);
    this.f.setController(c.frescoController(this.C.getImageUrl()));
  }
  
  private void b()
  {
    this.z = com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b.getScreenHeight(this.b);
    this.A = getIntent().getStringExtra("deviceUuid");
    this.B = getIntent().getStringExtra("rentContractCode");
    this.E = getIntent().getStringExtra("deviceType");
    String str = getIntent().getStringExtra("deviceTypeName");
    this.d.setText(str);
    this.G = new Timer();
    f();
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    UserInfo localUserInfo;
    do
    {
      return;
      localUserInfo = ApplicationEx.c.getUser();
    } while (localUserInfo == null);
    com.ziroom.ziroomcustomer.sharedlife.a.setSharedLifeEqInstruction(this, localUserInfo.getUid(), this.A, this.B, paramString, new d(this, new com.ziroom.ziroomcustomer.e.c.f(com.ziroom.ziroomcustomer.sharedlife.c.f.class))
    {
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.sharedlife.c.f paramAnonymousf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousf);
        if (paramAnonymousf != null)
        {
          if (paramAnonymousf.getIsJump() != 1) {
            break label84;
          }
          SharedLifeEquipmentDetailActivity.a(SharedLifeEquipmentDetailActivity.this);
        }
        for (;;)
        {
          Object localObject;
          if (!TextUtils.isEmpty(paramAnonymousf.getTitle()))
          {
            localObject = paramAnonymousf.getContent();
            e.newBuilder(SharedLifeEquipmentDetailActivity.h(SharedLifeEquipmentDetailActivity.this)).setTitle(paramAnonymousf.getTitle()).setContent((String)localObject).setButtonText("我知道了").setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
              }
            }).build().show();
          }
          return;
          label84:
          if (paramAnonymousf.getIsJump() == 2)
          {
            if (SharedLifeEquipmentDetailActivity.g(SharedLifeEquipmentDetailActivity.this))
            {
              SharedLifeEquipmentDetailActivity.a(SharedLifeEquipmentDetailActivity.this, false);
              SharedLifeEquipmentDetailActivity.a(SharedLifeEquipmentDetailActivity.this);
            }
            localObject = new Intent(SharedLifeEquipmentDetailActivity.h(SharedLifeEquipmentDetailActivity.this), SharedLifeOrderDetailActivity.class);
            ((Intent)localObject).putExtra("rentContractCode", SharedLifeEquipmentDetailActivity.i(SharedLifeEquipmentDetailActivity.this));
            ((Intent)localObject).putExtra("orderCode", paramAnonymousf.getParOrderCode());
            SharedLifeEquipmentDetailActivity.this.startActivityForResult((Intent)localObject, 1111);
          }
        }
      }
    });
  }
  
  private void e()
  {
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SharedLifeEquipmentDetailActivity.this.finish();
      }
    });
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SharedLifeEquipmentDetailActivity.a(SharedLifeEquipmentDetailActivity.this);
      }
    });
  }
  
  private void f()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      com.ziroom.ziroomcustomer.sharedlife.a.getSharedLifeEqDetail(this, localUserInfo.getUid(), this.A, this.D, new d(this, new com.ziroom.ziroomcustomer.e.c.f(com.ziroom.ziroomcustomer.sharedlife.c.b.class))
      {
        public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.sharedlife.c.b paramAnonymousb)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousb);
          if (paramAnonymousb != null)
          {
            SharedLifeEquipmentDetailActivity.a(SharedLifeEquipmentDetailActivity.this, paramAnonymousb);
            SharedLifeEquipmentDetailActivity.d(SharedLifeEquipmentDetailActivity.this);
          }
        }
      });
    }
  }
  
  private void g()
  {
    int i = this.z * 251 / 667;
    final Object localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.y.getLayoutParams();
    localLayoutParams1.height = i;
    localLayoutParams2.height = i;
    int j = this.C.getDeviceStatus();
    String str = com.ziroom.ziroomcustomer.sharedlife.d.a.getEqStatusName(j);
    if ("ZR0204".equals(this.E))
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = (this.z * 165 / 667);
      localLayoutParams1.width = (i * 215 / 251);
      localLayoutParams2.width = (i * 215 / 251);
      this.e.setTextSize(1, 14.0F);
      if ((j == 1) || (j == 3))
      {
        this.y.setScaleType(ImageView.ScaleType.FIT_CENTER);
        a(0, "zrk_lottie_hoter.json");
        i = 0;
        this.f.setLayoutParams(localLayoutParams1);
        this.y.setLayoutParams(localLayoutParams2);
        this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (i != 0) {
          this.e.setText(str);
        }
        if (!TextUtils.isEmpty(this.C.getPageContent())) {
          break label805;
        }
        this.s.setVisibility(8);
        label233:
        if (!TextUtils.isEmpty(this.C.getPromptContent())) {
          break label830;
        }
        this.t.setVisibility(8);
        label255:
        if ((this.C.getInterval() == null) || (this.C.getInterval().longValue() <= 0L)) {
          break label855;
        }
        this.F = ((int)this.C.getInterval().longValue());
        if (this.G != null)
        {
          if (this.H != null) {
            this.H.cancel();
          }
          this.H = new TimerTask()
          {
            public void run()
            {
              Message localMessage = new Message();
              localMessage.what = 1;
              SharedLifeEquipmentDetailActivity.this.a.sendMessage(localMessage);
            }
          };
          this.G.schedule(this.H, 1000L, 1000L);
        }
      }
    }
    for (;;)
    {
      this.D = "";
      if (this.C.getOperationType() != 1) {
        break label909;
      }
      this.w.setVisibility(8);
      if ((this.C.getOperationResponseList() == null) || (this.C.getOperationResponseList().size() <= 0)) {
        break label899;
      }
      this.u.setVisibility(0);
      localObject = new com.ziroom.ziroomcustomer.sharedlife.a.a(this.b, this.C.getOperationResponseList());
      this.u.setAdapter((ListAdapter)localObject);
      this.u.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          SharedLifeEquipmentDetailActivity.a(SharedLifeEquipmentDetailActivity.this, ((b.a)SharedLifeEquipmentDetailActivity.e(SharedLifeEquipmentDetailActivity.this).getOperationResponseList().get(paramAnonymousInt)).getOperation());
          SharedLifeEquipmentDetailActivity.b(SharedLifeEquipmentDetailActivity.this, SharedLifeEquipmentDetailActivity.f(SharedLifeEquipmentDetailActivity.this));
        }
      });
      return;
      a(1, "");
      i = 1;
      break;
      if ("ZR0203".equals(this.E))
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = (this.z * 165 / 667);
        localLayoutParams1.width = (i * 215 / 251);
        localLayoutParams2.width = (i * 215 / 251);
        this.e.setTextSize(1, 14.0F);
        if ((j == 1) || (j == 3))
        {
          this.y.setScaleType(ImageView.ScaleType.FIT_XY);
          a(0, "zrk_lottie_cleaner.json");
          i = 0;
          break;
        }
        a(1, "");
        i = 1;
        break;
      }
      if ("ZR0202".equals(this.E))
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = (this.z * 140 / 667);
        localLayoutParams1.width = (i * 204 / 269);
        localLayoutParams2.width = (i * 204 / 269);
        this.e.setTextSize(1, 20.0F);
        a(1, "");
        i = 0;
        break;
      }
      if ("ZR0201".equals(this.E))
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = (this.z * 111 / 667);
        localLayoutParams1.width = (i * 248 / 250);
        localLayoutParams2.width = (i * 248 / 250);
        this.e.setTextSize(1, 20.0F);
        a(1, "");
        i = 0;
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (this.z * 170 / 667);
      localLayoutParams1.width = (i * 190 / 251);
      localLayoutParams2.width = (i * 190 / 251);
      this.e.setTextSize(1, 14.0F);
      a(1, "");
      i = 0;
      break;
      label805:
      this.s.setVisibility(0);
      this.s.setText(this.C.getPageContent());
      break label233;
      label830:
      this.t.setVisibility(0);
      this.t.setText(this.C.getPromptContent());
      break label255;
      label855:
      this.F = 0;
      if (i == 0) {
        this.e.setText("");
      }
      if ((this.G != null) && (this.H != null)) {
        this.H.cancel();
      }
    }
    label899:
    this.u.setVisibility(8);
    return;
    label909:
    if (this.C.getOperationType() == 2)
    {
      this.u.setVisibility(8);
      if ((this.C.getOperationResponseList() != null) && (this.C.getOperationResponseList().size() > 0))
      {
        this.w.setVisibility(0);
        localObject = new com.ziroom.ziroomcustomer.sharedlife.a.f(this.b, this.C.getOperationResponseList());
        this.v.setAdapter((ListAdapter)localObject);
        this.v.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            localObject.setSelectPosition(paramAnonymousInt);
            SharedLifeEquipmentDetailActivity.a(SharedLifeEquipmentDetailActivity.this, ((b.a)SharedLifeEquipmentDetailActivity.e(SharedLifeEquipmentDetailActivity.this).getOperationResponseList().get(paramAnonymousInt)).getOperation());
          }
        });
        this.x.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            SharedLifeEquipmentDetailActivity.a(SharedLifeEquipmentDetailActivity.this, true);
            SharedLifeEquipmentDetailActivity.b(SharedLifeEquipmentDetailActivity.this, SharedLifeEquipmentDetailActivity.f(SharedLifeEquipmentDetailActivity.this));
          }
        });
        return;
      }
      this.w.setVisibility(8);
      return;
    }
    this.u.setVisibility(8);
    this.w.setVisibility(8);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1111) && (paramInt2 == -1)) {
      f();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903483);
    this.b = this;
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.G != null) {
      this.G.cancel();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    com.ziroom.ziroomcustomer.sharedlife.d.a.setEqStaticLayoutParam(this.g, this.f, this.y, this.r, this.z);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/activity/SharedLifeEquipmentDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */