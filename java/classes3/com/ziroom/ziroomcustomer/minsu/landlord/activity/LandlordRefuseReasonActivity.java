package com.ziroom.ziroomcustomer.minsu.landlord.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuWebActivity;
import com.ziroom.ziroomcustomer.minsu.landlord.model.BaseItem;
import com.ziroom.ziroomcustomer.minsu.landlord.model.RefuseReasonBean;
import com.ziroom.ziroomcustomer.minsu.landlord.views.MyListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.List;

public class LandlordRefuseReasonActivity
  extends BaseFluxActivity
  implements TextWatcher
{
  private com.ziroom.ziroomcustomer.minsu.landlord.c.a b;
  private com.ziroom.ziroomcustomer.minsu.landlord.a.a c;
  private String d;
  private com.freelxl.baselibrary.a.a<BaseItem> e;
  @BindView(2131690002)
  EditText etRemark;
  private List<BaseItem> f;
  private BaseItem g;
  @BindView(2131691452)
  ImageView imgClose;
  @BindView(2131691550)
  MyListView listReason;
  private String r;
  @BindView(2131690402)
  FrameLayout rlDescInfo;
  private RefuseReasonBean s;
  @BindView(2131690150)
  ObservableScrollView svContent;
  @BindView(2131690403)
  TextView tvCurrentNum;
  @BindView(2131690404)
  TextView tvMaxNum;
  @BindView(2131690953)
  TextView tvSave;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131691453)
  View vBottomLine;
  
  private void a()
  {
    this.etRemark.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        LandlordRefuseReasonActivity.this.tvCurrentNum.setText("" + paramAnonymousEditable.length());
        this.c = LandlordRefuseReasonActivity.this.etRemark.getSelectionStart();
        this.d = LandlordRefuseReasonActivity.this.etRemark.getSelectionEnd();
        if (this.b.length() > 100)
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          int i = this.d;
          LandlordRefuseReasonActivity.this.etRemark.setText(paramAnonymousEditable);
          LandlordRefuseReasonActivity.this.etRemark.setSelection(i);
        }
        LandlordRefuseReasonActivity.a(LandlordRefuseReasonActivity.this, VdsAgent.trackEditTextSilent(LandlordRefuseReasonActivity.this.etRemark).toString());
        if (LandlordRefuseReasonActivity.a(LandlordRefuseReasonActivity.this).length() > 0)
        {
          LandlordRefuseReasonActivity.this.tvSave.setTextColor(LandlordRefuseReasonActivity.this.getResources().getColor(2131624516));
          LandlordRefuseReasonActivity.this.tvSave.setEnabled(true);
          return;
        }
        LandlordRefuseReasonActivity.this.tvSave.setTextColor(LandlordRefuseReasonActivity.this.getResources().getColor(2131624042));
        LandlordRefuseReasonActivity.this.tvSave.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
      }
    });
    this.e = new com.freelxl.baselibrary.a.a(this, this.f, 2130904324)
    {
      public void convert(com.freelxl.baselibrary.a.b paramAnonymousb, BaseItem paramAnonymousBaseItem)
      {
        paramAnonymousb.setText(2131690084, paramAnonymousBaseItem.getName());
      }
    };
    this.listReason.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      private CheckBox b;
      
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (CheckBox)paramAnonymousView.findViewById(2131695282);
        if (paramAnonymousAdapterView == this.b) {
          return;
        }
        if (this.b != null) {
          this.b.setChecked(false);
        }
        this.b = paramAnonymousAdapterView;
        paramAnonymousAdapterView.setChecked(true);
        LandlordRefuseReasonActivity.a(LandlordRefuseReasonActivity.this, (BaseItem)LandlordRefuseReasonActivity.b(LandlordRefuseReasonActivity.this).getItem(paramAnonymousInt));
        if ("50".equals(LandlordRefuseReasonActivity.c(LandlordRefuseReasonActivity.this).getValue()))
        {
          LandlordRefuseReasonActivity.this.rlDescInfo.setVisibility(0);
          LandlordRefuseReasonActivity.a(LandlordRefuseReasonActivity.this, VdsAgent.trackEditTextSilent(LandlordRefuseReasonActivity.this.etRemark).toString());
          if (LandlordRefuseReasonActivity.a(LandlordRefuseReasonActivity.this).length() > 0)
          {
            LandlordRefuseReasonActivity.this.tvSave.setTextColor(LandlordRefuseReasonActivity.this.getResources().getColor(2131624516));
            LandlordRefuseReasonActivity.this.tvSave.setEnabled(true);
            return;
          }
          LandlordRefuseReasonActivity.this.tvSave.setTextColor(LandlordRefuseReasonActivity.this.getResources().getColor(2131624042));
          LandlordRefuseReasonActivity.this.tvSave.setEnabled(false);
          return;
        }
        LandlordRefuseReasonActivity.this.rlDescInfo.setVisibility(4);
        LandlordRefuseReasonActivity.a(LandlordRefuseReasonActivity.this, "");
        LandlordRefuseReasonActivity.this.tvSave.setTextColor(LandlordRefuseReasonActivity.this.getResources().getColor(2131624516));
        LandlordRefuseReasonActivity.this.tvSave.setEnabled(true);
      }
    });
    this.listReason.setAdapter(this.e);
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    setResult(18);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903302);
    ButterKnife.bind(this);
    this.b = new com.ziroom.ziroomcustomer.minsu.landlord.c.a(this);
    this.a.register(this.b);
    this.c = new com.ziroom.ziroomcustomer.minsu.landlord.a.a(this.a);
    this.d = getIntent().getStringExtra("orderSn");
    this.s = ((RefuseReasonBean)com.alibaba.fastjson.a.parseObject(getIntent().getStringExtra("data"), RefuseReasonBean.class));
    this.tvTitle.setText(this.s.getTitle());
    this.etRemark.setHint(this.s.getReasonDesc());
    this.f = this.s.getReasonList();
    a();
    this.svContent.smoothScrollTo(0, 0);
    this.svContent.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LandlordRefuseReasonActivity.this.vBottomLine.setAlpha(f);
      }
    });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.unregister(this.b);
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
        if (parama.equals("refused_order")) {
          i = 0;
        }
        break;
      }
    }
    if ("1".equals(this.g.getValue()))
    {
      parama = new Intent();
      parama.setClass(this, MinsuWebActivity.class);
      parama.putExtra("isLoadTitle", false);
      parama.putExtra("url", this.s.getCalendarUrl());
      startActivityForResult(parama, 32);
      return;
    }
    setResult(18);
    finish();
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
    if ("1".equals(this.g.getValue())) {}
    for (paramView = this.s.getCalendarConfirmMsg();; paramView = this.s.getConfirmMsg())
    {
      c.newBuilder(this).setTitle("提示").setBtnConfirmText("确定").setContent(paramView).setOnConfirmClickListener(new c.b()
      {
        public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            LandlordRefuseReasonActivity.e(LandlordRefuseReasonActivity.this).setLandlordRefuseOrder(LandlordRefuseReasonActivity.this, LandlordRefuseReasonActivity.this, LandlordRefuseReasonActivity.d(LandlordRefuseReasonActivity.this), LandlordRefuseReasonActivity.c(LandlordRefuseReasonActivity.this).getValue(), LandlordRefuseReasonActivity.a(LandlordRefuseReasonActivity.this));
          }
        }
      }).build().show();
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlord/activity/LandlordRefuseReasonActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */