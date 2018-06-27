package com.ziroom.ziroomcustomer.newclean.activity;

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
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.b;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHDicTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneralCleanCancleActivity
  extends BaseActivity
{
  private Unbinder a;
  private String b;
  private List<b> c = new ArrayList();
  private boolean d;
  private String e;
  @BindView(2131690002)
  EditText et_remark;
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
          GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this, true);
          GeneralCleanCancleActivity.this.tv_commit.setBackgroundResource(2130838044);
        }
        while (paramAnonymousCharSequence.length() > 140)
        {
          GeneralCleanCancleActivity.this.tv_num.setText("140/140");
          g.textToast(GeneralCleanCancleActivity.this, "字数超出限制！");
          GeneralCleanCancleActivity.this.et_remark.setText(paramAnonymousCharSequence.subSequence(0, 140));
          GeneralCleanCancleActivity.this.et_remark.setSelection(VdsAgent.trackEditTextSilent(GeneralCleanCancleActivity.this.et_remark).toString().length());
          return;
          GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this, false);
          GeneralCleanCancleActivity.this.tv_commit.setBackgroundColor(-2236963);
        }
        GeneralCleanCancleActivity.this.tv_num.setText(paramAnonymousCharSequence.length() + "/140");
      }
    });
  }
  
  private void a(String paramString1, String paramString2)
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo == null)
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this);
      return;
    }
    n.getGeneralOrderCancle(this, paramString1, localUserInfo.getUid(), paramString2, new com.ziroom.ziroomcustomer.e.a.a(this, new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if (paramAnonymousString != null)
        {
          org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("general_button_refresh_cancle", null));
          GeneralCleanCancleActivity.this.finish();
        }
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
        GeneralCleanCancleActivity.this.finish();
      }
    });
    findViewById(2131696483).setVisibility(8);
    findViewById(2131696484).setVisibility(8);
    ((TextView)findViewById(2131689541)).setText("取消订单");
  }
  
  private void d(final String paramString)
  {
    n.getCommonDicTag(this, paramString, new com.ziroom.ziroomcustomer.e.a.a(this, new l(MHDicTag.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, List<MHDicTag> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0) && ("CleanCancelEnum".equals(paramString)))
        {
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            MHDicTag localMHDicTag = (MHDicTag)paramAnonymousList.next();
            b localb = new b();
            localb.setSelect(false);
            localb.setReason(localMHDicTag.getTagValue());
            GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this).add(localb);
          }
          paramAnonymousList = new GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this, GeneralCleanCancleActivity.this, GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this));
          GeneralCleanCancleActivity.this.lv_item.setAdapter(paramAnonymousList);
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
      g.textToast(this, "请先选择或者输入取消原因");
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
            paramAnonymousView = (b)GeneralCleanCancleActivity.a.a(GeneralCleanCancleActivity.a.this).get(paramInt);
            if (!paramAnonymousView.isSelect())
            {
              GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this, paramAnonymousView.getReason());
              int i = 0;
              if (i < GeneralCleanCancleActivity.a.a(GeneralCleanCancleActivity.a.this).size())
              {
                if (i == paramInt)
                {
                  paramAnonymousView.setSelect(true);
                  label78:
                  if (!"其他原因".equals(paramAnonymousView.getReason())) {
                    break label213;
                  }
                  GeneralCleanCancleActivity.this.fl_mark.setVisibility(0);
                  if (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(GeneralCleanCancleActivity.this.et_remark).toString())) {
                    break label183;
                  }
                  GeneralCleanCancleActivity.this.tv_commit.setBackgroundColor(-2236963);
                  GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this, false);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  ((b)GeneralCleanCancleActivity.a.a(GeneralCleanCancleActivity.a.this).get(i)).setSelect(false);
                  break label78;
                  label183:
                  GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this, true);
                  GeneralCleanCancleActivity.this.tv_commit.setBackgroundResource(2130838044);
                  continue;
                  label213:
                  GeneralCleanCancleActivity.this.fl_mark.setVisibility(8);
                  GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this, true);
                  GeneralCleanCancleActivity.this.tv_commit.setBackgroundResource(2130838044);
                }
              }
              paramViewGroup.b.setChecked(true);
            }
            for (;;)
            {
              GeneralCleanCancleActivity.a.this.notifyDataSetChanged();
              return;
              GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this, "");
              paramAnonymousView.setSelect(false);
              GeneralCleanCancleActivity.a(GeneralCleanCancleActivity.this, false);
              GeneralCleanCancleActivity.this.tv_commit.setBackgroundColor(-2236963);
              if ("其他原因".equals(paramAnonymousView.getReason())) {
                GeneralCleanCancleActivity.this.fl_mark.setVisibility(8);
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/GeneralCleanCancleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */