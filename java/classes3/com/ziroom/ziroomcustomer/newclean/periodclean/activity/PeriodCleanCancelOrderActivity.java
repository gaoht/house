package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.content.Context;
import android.content.Intent;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.freelxl.baselibrary.a.b;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.minsu.landlord.views.MyListView;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.CancelOrderBean;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import java.util.List;

public class PeriodCleanCancelOrderActivity
  extends BaseActivity
{
  com.freelxl.baselibrary.a.a a;
  private List<CancelOrderBean> b;
  private CancelOrderBean c;
  private String d;
  private String e;
  @BindView(2131690002)
  EditText etRemark;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131691550)
  MyListView listReason;
  @BindView(2131690402)
  FrameLayout rlDescInfo;
  @BindView(2131689808)
  RelativeLayout rlTitle;
  @BindView(2131690150)
  ObservableScrollView svContent;
  @BindView(2131690403)
  TextView tvCurrentNum;
  @BindView(2131690404)
  TextView tvMaxNum;
  @BindView(2131689850)
  TextView tvMessage;
  @BindView(2131690953)
  TextView tvSave;
  @BindView(2131689541)
  TextView tvTitle;
  @BindView(2131691453)
  View vBottomLine;
  
  private void a()
  {
    this.e = getIntent().getStringExtra("orderCode");
    this.etRemark.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        PeriodCleanCancelOrderActivity.this.tvCurrentNum.setText("" + paramAnonymousEditable.length());
        this.c = PeriodCleanCancelOrderActivity.this.etRemark.getSelectionStart();
        this.d = PeriodCleanCancelOrderActivity.this.etRemark.getSelectionEnd();
        if (this.b.length() > 140)
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          int i = this.d;
          PeriodCleanCancelOrderActivity.this.etRemark.setText(paramAnonymousEditable);
          PeriodCleanCancelOrderActivity.this.etRemark.setSelection(i);
        }
        PeriodCleanCancelOrderActivity.a(PeriodCleanCancelOrderActivity.this, VdsAgent.trackEditTextSilent(PeriodCleanCancelOrderActivity.this.etRemark).toString());
        if (PeriodCleanCancelOrderActivity.a(PeriodCleanCancelOrderActivity.this).length() > 0)
        {
          PeriodCleanCancelOrderActivity.this.tvSave.setEnabled(true);
          return;
        }
        PeriodCleanCancelOrderActivity.this.tvSave.setEnabled(false);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
      }
    });
    this.a = new com.freelxl.baselibrary.a.a(this, this.b, 2130904434)
    {
      public void convert(b paramAnonymousb, CancelOrderBean paramAnonymousCancelOrderBean)
      {
        paramAnonymousb.setText(2131690084, paramAnonymousCancelOrderBean.getTagName());
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
        PeriodCleanCancelOrderActivity.a(PeriodCleanCancelOrderActivity.this, (CancelOrderBean)PeriodCleanCancelOrderActivity.this.a.getItem(paramAnonymousInt));
        if ("其他原因".equals(PeriodCleanCancelOrderActivity.b(PeriodCleanCancelOrderActivity.this).getTagName()))
        {
          PeriodCleanCancelOrderActivity.this.rlDescInfo.setVisibility(0);
          PeriodCleanCancelOrderActivity.a(PeriodCleanCancelOrderActivity.this, VdsAgent.trackEditTextSilent(PeriodCleanCancelOrderActivity.this.etRemark).toString());
          if (PeriodCleanCancelOrderActivity.a(PeriodCleanCancelOrderActivity.this).length() > 0)
          {
            PeriodCleanCancelOrderActivity.this.tvSave.setEnabled(true);
            return;
          }
          PeriodCleanCancelOrderActivity.this.tvSave.setEnabled(false);
          return;
        }
        PeriodCleanCancelOrderActivity.this.rlDescInfo.setVisibility(4);
        PeriodCleanCancelOrderActivity.a(PeriodCleanCancelOrderActivity.this, "");
        PeriodCleanCancelOrderActivity.this.tvSave.setEnabled(true);
      }
    });
    this.listReason.setAdapter(this.a);
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodCleanCancelOrderList(this, new d(this, new e(CancelOrderBean.class))
    {
      public void onSuccess(int paramAnonymousInt, List<CancelOrderBean> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        PeriodCleanCancelOrderActivity.a(PeriodCleanCancelOrderActivity.this, paramAnonymousList);
        PeriodCleanCancelOrderActivity.this.a.setDatas(PeriodCleanCancelOrderActivity.c(PeriodCleanCancelOrderActivity.this));
        PeriodCleanCancelOrderActivity.this.a.notifyDataSetChanged();
      }
    });
  }
  
  private void e()
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodCleanCancelOrder(this, this.e, this.d, this.c, new d(this, new f(Object.class))
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        PeriodCleanCancelOrderActivity.this.setResult(17);
        PeriodCleanCancelOrderActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903428);
    ButterKnife.bind(this);
    a();
    b();
  }
  
  @OnClick({2131689492, 2131690953})
  public void onViewClicked(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanCancelOrderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */