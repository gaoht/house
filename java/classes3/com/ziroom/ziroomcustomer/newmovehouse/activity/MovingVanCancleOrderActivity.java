package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingVanCancle;
import java.util.List;

public class MovingVanCancleOrderActivity
  extends BaseFluxActivity
{
  private static String b = "MovingVanCancleOrderActivity";
  private a c;
  private boolean d = true;
  private boolean e;
  @BindView(2131690002)
  EditText et_remark;
  private String f;
  @BindView(2131691812)
  FrameLayout fl_mark;
  private com.ziroom.ziroomcustomer.newmovehouse.d.c g;
  @BindView(2131691811)
  ListView lv_item;
  private com.ziroom.ziroomcustomer.newmovehouse.a.a r;
  private String s;
  private String t;
  @BindView(2131689956)
  TextView tv_commit;
  @BindView(2131690003)
  TextView tv_num;
  
  private void a()
  {
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MovingVanCancleOrderActivity.this.finish();
      }
    });
    findViewById(2131696483).setVisibility(8);
    findViewById(2131696484).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText("取消订单");
  }
  
  private void b()
  {
    this.s = getIntent().getStringExtra("orderCode");
    this.t = getIntent().getStringExtra("move_type");
    this.fl_mark.setVisibility(8);
    this.g = new com.ziroom.ziroomcustomer.newmovehouse.d.c(this);
    this.a.register(this.g);
    this.r = com.ziroom.ziroomcustomer.newmovehouse.a.a.getInstance(this.a);
    this.r.getMvCancleReason(this, "CustomerOrderCloseReasonTag");
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.t))
    {
      if (!"move_small".equals(this.t)) {
        break label49;
      }
      org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("move_small_button_refresh_cancle", null));
      g.textToast(this, "订单取消成功");
      finish();
    }
    label49:
    while (!"moving_van".equals(this.t)) {
      return;
    }
    Intent localIntent = new Intent("com.ziroom.ziroomcustomer.service.order.broadcast");
    localIntent.putExtra("service_order_type", "order_movingvan");
    localIntent.putExtra("mv_buttton_state", "mv_order_cancle");
    LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);
    g.textToast(this, "订单取消成功");
    finish();
  }
  
  private void f()
  {
    this.c = new a(this);
    this.lv_item.setAdapter(this.c);
  }
  
  private void g()
  {
    this.et_remark.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 0)
        {
          MovingVanCancleOrderActivity.b(MovingVanCancleOrderActivity.this, true);
          MovingVanCancleOrderActivity.this.tv_commit.setBackgroundResource(2130838044);
        }
        while (paramAnonymousCharSequence.length() > 140)
        {
          MovingVanCancleOrderActivity.this.tv_num.setText("140/140");
          g.textToast(MovingVanCancleOrderActivity.this, "字数超出限制！");
          MovingVanCancleOrderActivity.this.et_remark.setText(paramAnonymousCharSequence.subSequence(0, 140));
          MovingVanCancleOrderActivity.this.et_remark.setSelection(VdsAgent.trackEditTextSilent(MovingVanCancleOrderActivity.this.et_remark).toString().length());
          return;
          MovingVanCancleOrderActivity.b(MovingVanCancleOrderActivity.this, false);
          MovingVanCancleOrderActivity.this.tv_commit.setBackgroundColor(-2236963);
        }
        MovingVanCancleOrderActivity.this.tv_num.setText(paramAnonymousCharSequence.length() + "/140");
      }
    });
  }
  
  @OnClick({2131689956})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (!this.e)
    {
      g.textToast(this, "请先选择或者输入取消原因");
      return;
    }
    paramView = VdsAgent.trackEditTextSilent(this.et_remark).toString();
    this.r.submitMvCancleReason(this, this.f, paramView, this.s);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903359);
    ButterKnife.bind(this);
    a();
    b();
    g();
  }
  
  protected void onDestroy()
  {
    this.a.unregister(this.g);
    super.onDestroy();
  }
  
  public void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (parama.equals("service_mv_van_cancle_reason"))
        {
          i = 0;
          continue;
          if (parama.equals("submit_mv_van_canale_reason"))
          {
            i = 1;
            continue;
            if (parama.equals("service_mv_van_canale_updae")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    f();
    return;
    e();
    return;
    this.c.notifyDataSetChanged();
    this.f = this.g.getCancalTag();
    if (this.g.isOtherReason())
    {
      this.fl_mark.setVisibility(0);
      if (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.et_remark).toString()))
      {
        this.tv_commit.setBackgroundColor(-2236963);
        this.e = false;
      }
    }
    for (;;)
    {
      this.d = true;
      return;
      this.e = true;
      this.tv_commit.setBackgroundResource(2130838044);
      continue;
      this.fl_mark.setVisibility(8);
      this.e = true;
      this.tv_commit.setBackgroundResource(2130838044);
    }
  }
  
  class a
    extends BaseAdapter
  {
    private LayoutInflater b;
    
    public a(Context paramContext)
    {
      this.b = LayoutInflater.from(paramContext);
    }
    
    public int getCount()
    {
      if (MovingVanCancleOrderActivity.a(MovingVanCancleOrderActivity.this).getCancleList() == null) {
        return 0;
      }
      return MovingVanCancleOrderActivity.a(MovingVanCancleOrderActivity.this).getCancleList().size();
    }
    
    public Object getItem(int paramInt)
    {
      return MovingVanCancleOrderActivity.a(MovingVanCancleOrderActivity.this).getCancleList().get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      MovingVanCancle localMovingVanCancle;
      if (paramView == null)
      {
        paramView = this.b.inflate(2130904374, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693107));
        paramViewGroup.b = ((CheckBox)paramView.findViewById(2131694828));
        paramView.setTag(paramViewGroup);
        localMovingVanCancle = (MovingVanCancle)getItem(paramInt);
        if (paramInt != MovingVanCancleOrderActivity.a(MovingVanCancleOrderActivity.this).getSelectPosition()) {
          break label126;
        }
        paramViewGroup.b.setChecked(true);
      }
      for (;;)
      {
        paramViewGroup.a.setText(localMovingVanCancle.getReason());
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (MovingVanCancleOrderActivity.b(MovingVanCancleOrderActivity.this))
            {
              MovingVanCancleOrderActivity.a(MovingVanCancleOrderActivity.this, false);
              MovingVanCancleOrderActivity.c(MovingVanCancleOrderActivity.this).updateMvCancleReason(MovingVanCancleOrderActivity.this, paramInt);
            }
          }
        });
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label126:
        paramViewGroup.b.setChecked(false);
      }
    }
    
    public class a
    {
      public TextView a;
      public CheckBox b;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingVanCancleOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */