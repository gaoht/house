package com.ziroom.ziroomcustomer.newmovehouse.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.newmovehouse.model.MovingEvalInfo;

public class MovingEvalActivity
  extends BaseFluxActivity
{
  Unbinder b;
  com.ziroom.ziroomcustomer.newmovehouse.d.a c;
  com.ziroom.ziroomcustomer.newmovehouse.a.a d;
  private TextWatcher e = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      int i = 140;
      int j = paramAnonymousEditable.length();
      if (j > 140)
      {
        MovingEvalActivity.this.mEtEval.setText(paramAnonymousEditable.subSequence(0, 140).toString());
        MovingEvalActivity.this.mEtEval.setSelection(140);
      }
      paramAnonymousEditable = MovingEvalActivity.this.mTvEvalNum;
      StringBuilder localStringBuilder = new StringBuilder();
      if (j > 140) {}
      for (;;)
      {
        paramAnonymousEditable.setText(i + "/140");
        return;
        i = j;
      }
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  @BindView(2131689816)
  Button mBtnSubmit;
  @BindView(2131690075)
  EditText mEtEval;
  @BindView(2131690072)
  RatingBar mRbRating;
  @BindView(2131690070)
  SimpleDraweeView mSdvAvatar;
  @BindView(2131690073)
  TextView mTvDesc;
  @BindView(2131690076)
  TextView mTvEvalNum;
  @BindView(2131690049)
  TextView mTvName;
  @BindView(2131690071)
  TextView mTvSubtitle;
  
  private void a()
  {
    b();
    this.mRbRating.setVisibility(0);
    this.mRbRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
    {
      @Instrumented
      public void onRatingChanged(RatingBar paramAnonymousRatingBar, float paramAnonymousFloat, boolean paramAnonymousBoolean)
      {
        VdsAgent.onRatingChanged(this, paramAnonymousRatingBar, paramAnonymousFloat, paramAnonymousBoolean);
        MovingEvalActivity.this.mBtnSubmit.setEnabled(true);
        MovingEvalActivity.this.mTvDesc.setVisibility(0);
        if (paramAnonymousFloat > 4.0F) {
          MovingEvalActivity.this.mTvDesc.setText("特别满意");
        }
        do
        {
          return;
          if (paramAnonymousFloat > 3.0F)
          {
            MovingEvalActivity.this.mTvDesc.setText("满意");
            return;
          }
          if (paramAnonymousFloat > 2.0F)
          {
            MovingEvalActivity.this.mTvDesc.setText("一般");
            return;
          }
          if (paramAnonymousFloat > 1.0F)
          {
            MovingEvalActivity.this.mTvDesc.setText("不满意");
            return;
          }
        } while (paramAnonymousFloat <= 0.0F);
        MovingEvalActivity.this.mTvDesc.setText("特别不满意");
      }
    });
    this.mEtEval.addTextChangedListener(this.e);
  }
  
  private void b()
  {
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MovingEvalActivity.this.finish();
      }
    });
    findViewById(2131696483).setVisibility(8);
    findViewById(2131696484).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText("服务评价");
  }
  
  private void e()
  {
    this.c = new com.ziroom.ziroomcustomer.newmovehouse.d.a(this);
    this.a.register(this.c);
    this.d = com.ziroom.ziroomcustomer.newmovehouse.a.a.getInstance(this.a);
    this.d.initMovingEval(this, getIntent().getStringExtra("orderId"));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903356);
    this.b = ButterKnife.bind(this);
    a();
    e();
  }
  
  protected void onDestroy()
  {
    this.b.unbind();
    this.a.unregister(this.c);
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
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
        if (parama.equals("service_mv_eval_init"))
        {
          i = 0;
          continue;
          if (parama.equals("service_mv_eval_submit")) {
            i = 1;
          }
        }
        break;
      }
    }
    parama = this.c.getMovingEvalInfo();
    if (parama != null)
    {
      this.mSdvAvatar.setController(c.frescoController(parama.getHeadPicture()));
      this.mTvName.setText(parama.getTrueName());
    }
    this.mBtnSubmit.setEnabled(true);
    return;
    g.textToast(this, "评价提交成功！");
    parama = new Intent("com.ziroom.ziroomcustomer.service.order.broadcast");
    parama.putExtra("service_order_type", "order_movingvan");
    parama.putExtra("mv_buttton_state", "mv_order_eval");
    LocalBroadcastManager.getInstance(this).sendBroadcast(parama);
    finish();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    int i = (int)this.mRbRating.getRating();
    paramView = VdsAgent.trackEditTextSilent(this.mEtEval).toString();
    if (i < 1)
    {
      g.textToast(this, "请选择星级！");
      return;
    }
    if ((i < 4) && (TextUtils.isEmpty(paramView)))
    {
      g.textToast(this, "请写下您的建议，让我们更好地改进我们的服务");
      return;
    }
    this.d.submitMovingEval(this, getIntent().getStringExtra("orderId"), i, paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newmovehouse/activity/MovingEvalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */