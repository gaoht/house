package com.ziroom.ziroomcustomer.newclean.periodclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import butterknife.Unbinder;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.newServiceList.model.b;
import com.ziroom.ziroomcustomer.newclean.periodclean.bean.PeriodGeneralCancleTagBean;
import com.ziroom.ziroomcustomer.util.af;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeriodCleanCancleActivity
  extends BaseActivity
{
  private Unbinder a;
  private String b;
  private List<b> c = new ArrayList();
  private boolean d;
  private String e;
  @BindView(2131690002)
  EditText et_remark;
  private PeriodCleanCancleActivity f;
  @BindView(2131691812)
  FrameLayout fl_mark;
  @BindView(2131691811)
  ListView lv_item;
  @BindView(2131689956)
  TextView tv_commit;
  @BindView(2131690003)
  TextView tv_num;
  
  private void a()
  {
    this.fl_mark.setVisibility(8);
    this.b = getIntent().getStringExtra("orderCode");
    d("CleanCancelEnum");
    this.et_remark.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 0)
        {
          PeriodCleanCancleActivity.a(PeriodCleanCancleActivity.this, true);
          PeriodCleanCancleActivity.this.tv_commit.setBackgroundResource(2130838044);
        }
        while (paramAnonymousCharSequence.length() > 140)
        {
          PeriodCleanCancleActivity.this.tv_num.setText("140/140");
          g.textToast(PeriodCleanCancleActivity.a(PeriodCleanCancleActivity.this), "字数超出限制！");
          PeriodCleanCancleActivity.this.et_remark.setText(paramAnonymousCharSequence.subSequence(0, 140));
          PeriodCleanCancleActivity.this.et_remark.setSelection(VdsAgent.trackEditTextSilent(PeriodCleanCancleActivity.this.et_remark).toString().length());
          return;
          PeriodCleanCancleActivity.a(PeriodCleanCancleActivity.this, false);
          PeriodCleanCancleActivity.this.tv_commit.setBackgroundColor(-2236963);
        }
        PeriodCleanCancleActivity.this.tv_num.setText(paramAnonymousCharSequence.length() + "/140");
      }
    });
  }
  
  private void a(String paramString1, String paramString2)
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.submitPeriodGeneralCancleTag(this.f, this.b, paramString2, new d(this.f, new com.ziroom.ziroomcustomer.newServiceList.utils.a(Object.class))
    {
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("period_general_button_refresh_cancle", null));
        PeriodCleanCancleActivity.this.finish();
      }
    });
  }
  
  private void b()
  {
    ((ImageView)findViewById(2131691493)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        PeriodCleanCancleActivity.this.finish();
      }
    });
    findViewById(2131696483).setVisibility(8);
    findViewById(2131696484).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText("取消订单");
  }
  
  private void d(String paramString)
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.getPeriodGeneralCancleTag(this.f, this.b, new d(this.f, new e(PeriodGeneralCancleTagBean.class))
    {
      public void onSuccess(int paramAnonymousInt, List<PeriodGeneralCancleTagBean> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            PeriodGeneralCancleTagBean localPeriodGeneralCancleTagBean = (PeriodGeneralCancleTagBean)paramAnonymousList.next();
            b localb = new b();
            localb.setSelect(false);
            localb.setReason(localPeriodGeneralCancleTagBean.getTagName());
            PeriodCleanCancleActivity.b(PeriodCleanCancleActivity.this).add(localb);
          }
          paramAnonymousList = new PeriodCleanCancleActivity.a(PeriodCleanCancleActivity.this, PeriodCleanCancleActivity.this, PeriodCleanCancleActivity.b(PeriodCleanCancleActivity.this));
          PeriodCleanCancleActivity.this.lv_item.setAdapter(paramAnonymousList);
        }
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
    if (!this.d)
    {
      af.showToast(this, "请先选择或者输入取消原因");
      return;
    }
    paramView = VdsAgent.trackEditTextSilent(this.et_remark).toString();
    if ("其他原因".equals(this.e)) {
      if (TextUtils.isEmpty(paramView)) {
        paramView = this.e;
      }
    }
    for (;;)
    {
      a(this.b, paramView);
      return;
      paramView = this.e + "," + paramView;
      continue;
      paramView = this.e;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903359);
    this.f = this;
    this.a = ButterKnife.bind(this);
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.unbind();
  }
  
  class a
    extends BaseAdapter
  {
    private Context b;
    private List<b> c;
    
    public a(List<b> paramList)
    {
      this.b = paramList;
      List localList;
      this.c = localList;
    }
    
    public int getCount()
    {
      return this.c.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.b, 2130904208, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693107));
        paramViewGroup.b = ((CheckBox)paramView.findViewById(2131694828));
        paramView.setTag(paramViewGroup);
        b localb = (b)this.c.get(paramInt);
        paramViewGroup.a.setText(localb.getReason());
        if (!localb.isSelect()) {
          break label125;
        }
        paramViewGroup.b.setChecked(true);
      }
      for (;;)
      {
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (b)PeriodCleanCancleActivity.a.a(PeriodCleanCancleActivity.a.this).get(paramInt);
            if (!paramAnonymousView.isSelect())
            {
              PeriodCleanCancleActivity.a(PeriodCleanCancleActivity.this, paramAnonymousView.getReason());
              int i = 0;
              if (i < PeriodCleanCancleActivity.a.a(PeriodCleanCancleActivity.a.this).size())
              {
                if (i == paramInt)
                {
                  paramAnonymousView.setSelect(true);
                  label78:
                  if (!"其他原因".equals(paramAnonymousView.getReason())) {
                    break label213;
                  }
                  PeriodCleanCancleActivity.this.fl_mark.setVisibility(0);
                  if (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(PeriodCleanCancleActivity.this.et_remark).toString())) {
                    break label183;
                  }
                  PeriodCleanCancleActivity.this.tv_commit.setBackgroundColor(-2236963);
                  PeriodCleanCancleActivity.a(PeriodCleanCancleActivity.this, false);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  ((b)PeriodCleanCancleActivity.a.a(PeriodCleanCancleActivity.a.this).get(i)).setSelect(false);
                  break label78;
                  label183:
                  PeriodCleanCancleActivity.a(PeriodCleanCancleActivity.this, true);
                  PeriodCleanCancleActivity.this.tv_commit.setBackgroundResource(2130838044);
                  continue;
                  label213:
                  PeriodCleanCancleActivity.this.fl_mark.setVisibility(8);
                  PeriodCleanCancleActivity.a(PeriodCleanCancleActivity.this, true);
                  PeriodCleanCancleActivity.this.tv_commit.setBackgroundResource(2130838044);
                }
              }
              paramViewGroup.b.setChecked(true);
            }
            for (;;)
            {
              PeriodCleanCancleActivity.a.this.notifyDataSetChanged();
              return;
              PeriodCleanCancleActivity.a(PeriodCleanCancleActivity.this, "");
              paramAnonymousView.setSelect(false);
              PeriodCleanCancleActivity.a(PeriodCleanCancleActivity.this, false);
              PeriodCleanCancleActivity.this.tv_commit.setBackgroundColor(-2236963);
              if ("其他原因".equals(paramAnonymousView.getReason())) {
                PeriodCleanCancleActivity.this.fl_mark.setVisibility(8);
              }
              paramViewGroup.b.setChecked(false);
            }
          }
        });
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label125:
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/periodclean/activity/PeriodCleanCancleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */