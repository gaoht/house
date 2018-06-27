package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.f.f;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.model.MoneyItem;
import com.ziroom.ziroomcustomer.minsu.landlord.model.OtherMoneyBean;
import com.ziroom.ziroomcustomer.minsu.landlord.model.OtherMoneyBean.DetailBean;

public class LandlordOtherConsumerActivity
  extends BaseActivity
  implements TextWatcher
{
  OtherMoneyBean.DetailBean a;
  private Boolean b = Boolean.valueOf(true);
  @BindView(2131691547)
  EditText edDetail;
  @BindView(2131691545)
  EditText editText;
  @BindView(2131690002)
  EditText etRemark;
  @BindView(2131691548)
  FrameLayout flDescInfo;
  @BindView(2131691452)
  ImageView imgClose;
  @BindView(2131690403)
  TextView tvCurrentNum;
  @BindView(2131690404)
  TextView tvMaxNum;
  @BindView(2131690049)
  TextView tvName;
  @BindView(2131690953)
  TextView tvSave;
  @BindView(2131691544)
  TextView tvSymble;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131691546)
  TextView tvValue;
  
  private void a()
  {
    int i = 0;
    Object localObject1 = (OtherMoneyBean)a.parseObject(getIntent().getStringExtra("data"), OtherMoneyBean.class);
    if ((localObject1 == null) || (((OtherMoneyBean)localObject1).getDetail() == null)) {
      return;
    }
    this.a = ((OtherMoneyBean)localObject1).getDetail();
    this.tvTitle.setText(((OtherMoneyBean)localObject1).getName());
    this.tvName.setText(this.a.getMoney().getName());
    this.editText.setHint(this.a.getMoney().getDesc());
    this.tvValue.setText(this.a.getReason().getName());
    this.etRemark.setHint(this.a.getReason().getDesc());
    this.b = Boolean.valueOf(f.isNull(this.a.getMoney().getValue()));
    if (this.b.booleanValue())
    {
      i = getIntent().getIntExtra("money", 0);
      localObject2 = getIntent().getStringExtra("moneyStr");
      localObject1 = getIntent().getStringExtra("money_detail");
      if (i != 0)
      {
        this.editText.setText((CharSequence)localObject2);
        this.tvSymble.setText(this.a.getMoney().getFeeUnit());
        this.tvSave.setTextColor(getResources().getColor(2131624516));
        this.tvSave.setEnabled(true);
      }
      this.etRemark.setText((CharSequence)localObject1);
      localObject2 = this.tvCurrentNum;
      StringBuilder localStringBuilder = new StringBuilder().append("");
      if (localObject1 == null) {}
      for (i = 0;; i = ((String)localObject1).length())
      {
        ((TextView)localObject2).setText(i);
        this.flDescInfo.setVisibility(0);
        this.tvSave.setVisibility(0);
        this.editText.setEnabled(this.b.booleanValue());
        this.etRemark.setEnabled(this.b.booleanValue());
        return;
      }
    }
    this.editText.setText(this.a.getMoney().getValue());
    this.edDetail.setText(this.a.getReason().getValue());
    this.etRemark.setText(this.a.getReason().getValue());
    localObject1 = this.tvCurrentNum;
    Object localObject2 = new StringBuilder().append("");
    if (this.a.getReason().getValue() == null) {}
    for (;;)
    {
      ((TextView)localObject1).setText(i);
      this.tvSymble.setText(this.a.getMoney().getFeeUnit());
      this.tvSave.setVisibility(8);
      break;
      i = this.a.getReason().getValue().length();
    }
  }
  
  private void b()
  {
    this.editText.addTextChangedListener(this);
    this.etRemark.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        LandlordOtherConsumerActivity.this.tvCurrentNum.setText("" + paramAnonymousEditable.length());
        this.c = LandlordOtherConsumerActivity.this.etRemark.getSelectionStart();
        this.d = LandlordOtherConsumerActivity.this.etRemark.getSelectionEnd();
        if (this.b.length() > 150)
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          int i = this.d;
          LandlordOtherConsumerActivity.this.etRemark.setText(paramAnonymousEditable);
          LandlordOtherConsumerActivity.this.etRemark.setSelection(i);
        }
        LandlordOtherConsumerActivity.a(LandlordOtherConsumerActivity.this);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
      }
    });
  }
  
  private void e()
  {
    if ((f.notNull(VdsAgent.trackEditTextSilent(this.editText).toString())) && (f.notNull(VdsAgent.trackEditTextSilent(this.etRemark).toString())))
    {
      this.tvSave.setTextColor(getResources().getColor(2131624516));
      this.tvSave.setEnabled(true);
      return;
    }
    this.tvSave.setTextColor(getResources().getColor(2131624042));
    this.tvSave.setEnabled(false);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    if (i <= 0)
    {
      if (str.length() > 6) {
        paramEditable.delete(6, 7);
      }
      if (str.length() <= 0) {
        break label93;
      }
      this.tvSymble.setText(this.a.getMoney().getFeeUnit());
    }
    for (;;)
    {
      e();
      return;
      if (str.length() - i - 1 <= 2) {
        break;
      }
      paramEditable.delete(i + 3, i + 4);
      break;
      label93:
      this.tvSymble.setText("");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903300);
    ButterKnife.bind(this);
    a();
    b();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @OnClick({2131691452, 2131690953})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691452: 
      finish();
      return;
    }
    Object localObject = new StringBuilder();
    if (this.a.getMoney().getSymbol() == null) {}
    for (paramView = "";; paramView = this.a.getMoney().getSymbol())
    {
      paramView = paramView + this.a.getMoney().getFeeUnit();
      localObject = new Intent();
      ((Intent)localObject).putExtra("feeUnit", paramView);
      ((Intent)localObject).putExtra("money", VdsAgent.trackEditTextSilent(this.editText).toString());
      ((Intent)localObject).putExtra("money_value", (int)(Float.parseFloat(VdsAgent.trackEditTextSilent(this.editText).toString()) * 100.0F));
      ((Intent)localObject).putExtra("money_detail", VdsAgent.trackEditTextSilent(this.etRemark).toString());
      setResult(16, (Intent)localObject);
      finish();
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/LandlordOtherConsumerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */