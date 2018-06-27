package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.my.adapter.OCContractItemAdapter;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmContractBean;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmContractBean.DataBean;
import com.ziroom.ziroomcustomer.my.model.OwnerConfirmContractBean.Protocol;
import com.ziroom.ziroomcustomer.my.widget.OwnerVerifyPop;
import com.ziroom.ziroomcustomer.my.widget.OwnerVerifyPop.b;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.List;

public class OwnerLoanContractConfirmActivity
  extends BaseActivity
  implements f.b
{
  private Unbinder a;
  private f.a b;
  private OCContractItemAdapter c;
  @BindView(2131692016)
  CheckBox cb_agree_contract_items;
  private String d;
  private String e;
  @BindView(2131689492)
  ImageView iv_back;
  @BindView(2131692015)
  ListViewForScrollView mListView;
  @BindView(2131690620)
  ViewStub mVsError;
  @BindView(2131692017)
  TextView tv_agree_contract_items;
  @BindView(2131691990)
  TextView tv_contact_keeper;
  
  public Context getViewContext()
  {
    return this;
  }
  
  public void initView(OwnerConfirmContractBean paramOwnerConfirmContractBean)
  {
    int j = 0;
    label81:
    Object localObject2;
    final Object localObject3;
    int i;
    label118:
    Object localObject1;
    if (paramOwnerConfirmContractBean != null)
    {
      OwnerConfirmContractBean.DataBean localDataBean;
      if (ae.notNull(paramOwnerConfirmContractBean.hireCommissionerPhone))
      {
        this.tv_contact_keeper.setVisibility(0);
        if ((paramOwnerConfirmContractBean.contractInfo == null) || (paramOwnerConfirmContractBean.contractInfo.size() <= 0)) {
          break label213;
        }
        this.mListView.setVisibility(0);
        this.c = new OCContractItemAdapter(getViewContext(), paramOwnerConfirmContractBean.contractInfo);
        this.mListView.setAdapter(this.c);
        if (paramOwnerConfirmContractBean.protocol == null) {
          break label490;
        }
        localObject2 = paramOwnerConfirmContractBean.protocol.getProtocolText();
        localObject3 = paramOwnerConfirmContractBean.protocol.getProtocolText();
        if (paramOwnerConfirmContractBean.protocol.getData() == null) {
          break label490;
        }
        i = 0;
        if (i >= paramOwnerConfirmContractBean.protocol.getData().size()) {
          break label256;
        }
        localDataBean = (OwnerConfirmContractBean.DataBean)paramOwnerConfirmContractBean.protocol.getData().get(i);
        localObject1 = localObject2;
        if (localDataBean != null) {
          if (i != 0) {
            break label223;
          }
        }
      }
      label213:
      label223:
      for (localObject1 = (String)localObject2 + localDataBean.getTitle();; localObject1 = (String)localObject2 + "、" + localDataBean.getTitle())
      {
        i += 1;
        localObject2 = localObject1;
        break label118;
        this.tv_contact_keeper.setVisibility(8);
        break;
        showError(false, "暂无贷款信息");
        break label81;
      }
      label256:
      localObject2 = new SpannableString((CharSequence)localObject2);
      localObject1 = localObject3;
      i = j;
      if (i < paramOwnerConfirmContractBean.protocol.getData().size())
      {
        localObject3 = (OwnerConfirmContractBean.DataBean)paramOwnerConfirmContractBean.protocol.getData().get(i);
        if (localObject3 == null) {
          break label508;
        }
        if (i == 0)
        {
          ((SpannableString)localObject2).setSpan(new a(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              JsBridgeWebActivity.start(OwnerLoanContractConfirmActivity.this.getViewContext(), "", localObject3.getValue());
            }
          }), ((String)localObject1).length(), ((String)localObject1).length() + ((OwnerConfirmContractBean.DataBean)localObject3).getTitle().length(), 33);
          localObject1 = (String)localObject1 + ((OwnerConfirmContractBean.DataBean)localObject3).getTitle();
        }
      }
    }
    label490:
    label508:
    for (;;)
    {
      i += 1;
      break;
      ((SpannableString)localObject2).setSpan(new a(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          JsBridgeWebActivity.start(OwnerLoanContractConfirmActivity.this.getViewContext(), "", localObject3.getValue());
        }
      }), ((String)localObject1).length(), ((String)localObject1).length() + ((OwnerConfirmContractBean.DataBean)localObject3).getTitle().length() + 1, 33);
      localObject1 = (String)localObject1 + "、" + ((OwnerConfirmContractBean.DataBean)localObject3).getTitle();
      continue;
      this.tv_agree_contract_items.setText((CharSequence)localObject2);
      this.tv_agree_contract_items.setMovementMethod(LinkMovementMethod.getInstance());
      return;
      this.tv_contact_keeper.setVisibility(8);
      showError(false, "数据解析失败");
      return;
    }
  }
  
  public void intent() {}
  
  public boolean isActive()
  {
    return !isFinishing();
  }
  
  @OnClick({2131689492, 2131691990, 2131691101})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691101: 
      if (!this.cb_agree_contract_items.isChecked())
      {
        showToast("请阅读并同意相关条款");
        return;
      }
      c.newBuilder(getViewContext()).setContent("您确认合同信息无误？ 一旦确认后立即生效且无法修改").setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("确定").setOnConfirmClickListener(new c.b()
      {
        public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            OwnerLoanContractConfirmActivity.a(OwnerLoanContractConfirmActivity.this).submitContract();
          }
        }
      }).build().show();
      return;
    case 2131689492: 
      finish();
      return;
    }
    paramView = this.b.getPhone();
    if (ae.notNull(paramView))
    {
      ah.callPhone(this, paramView);
      return;
    }
    showToast("管家手机号获取失败");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903413);
    this.a = ButterKnife.bind(this);
    new g(this);
    this.d = getIntent().getStringExtra("loanContractCode");
    this.e = getIntent().getStringExtra("contractCode");
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.b != null) {
      this.b.getData(this.d, this.e);
    }
  }
  
  public void setPresenter(f.a parama)
  {
    this.b = parama;
  }
  
  public void showError(boolean paramBoolean, String paramString)
  {
    if (!isFinishing())
    {
      if (paramBoolean)
      {
        this.mListView.setVisibility(8);
        this.mVsError.setVisibility(0);
        ImageView localImageView = (ImageView)findViewById(2131690082);
        localImageView.setImageResource(2130840088);
        ((TextView)findViewById(2131690822)).setText(paramString);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (OwnerLoanContractConfirmActivity.a(OwnerLoanContractConfirmActivity.this) != null) {
              OwnerLoanContractConfirmActivity.a(OwnerLoanContractConfirmActivity.this).getData(OwnerLoanContractConfirmActivity.b(OwnerLoanContractConfirmActivity.this), OwnerLoanContractConfirmActivity.c(OwnerLoanContractConfirmActivity.this));
            }
          }
        });
      }
    }
    else {
      return;
    }
    this.mListView.setVisibility(0);
    this.mVsError.setVisibility(8);
  }
  
  public void showPop(String paramString1, String paramString2, String paramString3)
  {
    OwnerVerifyPop localOwnerVerifyPop = new OwnerVerifyPop(getViewContext());
    localOwnerVerifyPop.setOnFinishListener(new OwnerVerifyPop.b()
    {
      public void onFinish()
      {
        OwnerLoanContractConfirmActivity.this.finish();
      }
    });
    localOwnerVerifyPop.show(this.iv_back, paramString1, paramString2, paramString3);
  }
  
  class a
    extends ClickableSpan
  {
    View.OnClickListener a;
    
    public a(View.OnClickListener paramOnClickListener)
    {
      this.a = paramOnClickListener;
    }
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      this.a.onClick(paramView);
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(Color.parseColor("#ffa000"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerLoanContractConfirmActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */