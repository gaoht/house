package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PeriodcleanMoveSpecialActivity
  extends BaseActivity
{
  private Unbinder a;
  private Context b;
  private List<String> c = new ArrayList();
  private List<String> d = new ArrayList();
  private List<String> e = new LinkedList();
  @BindView(2131690002)
  EditText et_remark;
  private int f;
  @BindView(2131690332)
  FlowLayout fl_like;
  private int g;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131692098)
  TextView tvHotLabel;
  @BindView(2131692099)
  TextView tvOtherRemark;
  @BindView(2131691766)
  TextView tvTotalCount;
  @BindView(2131689956)
  TextView tv_commit;
  @BindView(2131691765)
  TextView tv_wordnum;
  @BindView(2131690147)
  View view;
  
  private void a()
  {
    int j = 0;
    Object localObject2 = getIntent().getStringExtra("hotLabel");
    Object localObject1 = getIntent().getStringExtra("hotLabelSelect");
    String str1 = getIntent().getStringExtra("inputText");
    String str2 = getIntent().getStringExtra("inputHintText");
    this.f = getIntent().getIntExtra("maxNum", 140);
    this.g = getIntent().getIntExtra("minNum", 0);
    this.et_remark.setHint(str2);
    if (!TextUtils.isEmpty(str1))
    {
      this.et_remark.setText(str1);
      this.tv_wordnum.setText(str1.length() + "/");
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      this.tvHotLabel.setVisibility(8);
      this.fl_like.setVisibility(8);
      this.tvOtherRemark.setVisibility(8);
      this.view.setVisibility(8);
    }
    for (;;)
    {
      b();
      this.et_remark.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          if (paramAnonymousEditable.length() > PeriodcleanMoveSpecialActivity.a(PeriodcleanMoveSpecialActivity.this))
          {
            PeriodcleanMoveSpecialActivity.this.tv_wordnum.setText(PeriodcleanMoveSpecialActivity.a(PeriodcleanMoveSpecialActivity.this) + "/");
            g.textToast(PeriodcleanMoveSpecialActivity.b(PeriodcleanMoveSpecialActivity.this), "字数超出限制！");
            PeriodcleanMoveSpecialActivity.this.et_remark.setText(paramAnonymousEditable.subSequence(0, PeriodcleanMoveSpecialActivity.a(PeriodcleanMoveSpecialActivity.this)));
            PeriodcleanMoveSpecialActivity.this.et_remark.setSelection(PeriodcleanMoveSpecialActivity.this.et_remark.length());
          }
          for (;;)
          {
            PeriodcleanMoveSpecialActivity.c(PeriodcleanMoveSpecialActivity.this);
            return;
            PeriodcleanMoveSpecialActivity.this.tv_wordnum.setText(paramAnonymousEditable.length() + "/");
          }
        }
        
        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      return;
      localObject2 = ((String)localObject2).split(",");
      int i = 0;
      while (i < localObject2.length)
      {
        this.c.add(localObject2[i]);
        i += 1;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        i = j;
        while (i < localObject1.length)
        {
          this.d.add(localObject1[i]);
          i += 1;
        }
      }
      a(this.c, this.d);
    }
  }
  
  private void a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        Button localButton = new Button(this);
        localButton.setText(str);
        localButton.setTag(Boolean.valueOf(false));
        localButton.setTextColor(-6710887);
        localButton.setTextSize(12.0F);
        localButton.setPadding(n.dip2px(this.b, 8.0F), n.dip2px(this.b, 6.0F), n.dip2px(this.b, 8.0F), n.dip2px(this.b, 6.0F));
        localButton.setBackgroundResource(2130838210);
        Object localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, n.dip2px(this.b, 12.0F), n.dip2px(this.b, 12.0F), 0);
        localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = paramList2.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (str.equals((String)((Iterator)localObject).next()))
          {
            localButton.setBackgroundResource(2130838211);
            localButton.setTextColor(-1);
            localButton.setTag(Boolean.valueOf(true));
            this.e.add(str);
          }
        }
        localButton.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (Button)paramAnonymousView;
            String str = paramAnonymousView.getText().toString();
            if (!((Boolean)paramAnonymousView.getTag()).booleanValue())
            {
              paramAnonymousView.setBackgroundResource(2130838211);
              paramAnonymousView.setTextColor(-1);
              paramAnonymousView.setTag(Boolean.valueOf(true));
              PeriodcleanMoveSpecialActivity.d(PeriodcleanMoveSpecialActivity.this).add(str);
              return;
            }
            paramAnonymousView.setBackgroundResource(2130838210);
            paramAnonymousView.setTextColor(-6710887);
            paramAnonymousView.setTag(Boolean.valueOf(false));
            PeriodcleanMoveSpecialActivity.d(PeriodcleanMoveSpecialActivity.this).remove(str);
          }
        });
        this.fl_like.addView(localButton);
      }
    }
  }
  
  private void b()
  {
    if (VdsAgent.trackEditTextSilent(this.et_remark).toString().length() >= this.g) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.tv_commit.setTextColor(40960);
      this.tv_commit.setEnabled(true);
      return;
    }
    this.tv_commit.setTextColor(-6710887);
    this.tv_commit.setEnabled(false);
  }
  
  public String listToString(List paramList, char paramChar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(paramList.get(i));
      if (i < paramList.size() - 1) {
        localStringBuilder.append(paramChar);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  @OnClick({2131689492, 2131689956})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    paramView = new Intent();
    paramView.putExtra("hotLabel", listToString(this.e, ','));
    paramView.putExtra("otherLabel", VdsAgent.trackEditTextSilent(this.et_remark).toString());
    setResult(17, paramView);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903430);
    this.b = this;
    this.a = ButterKnife.bind(this);
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.unbind();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodcleanMoveSpecialActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */