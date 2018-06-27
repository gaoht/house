package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import com.ziroom.ziroomcustomer.ziroomstation.model.IntoLabelListModel;
import com.ziroom.ziroomcustomer.ziroomstation.utils.i;
import com.ziroom.ziroomcustomer.ziroomstation.widget.FlowLayout;
import com.ziroom.ziroomcustomer.ziroomstation.widget.IntoTagTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IntoFillBedInfoActivity
  extends BaseActivity
{
  Unbinder a;
  List<String> b = new ArrayList();
  @BindView(2131690078)
  ImageView btnBack;
  private String c;
  private String d;
  private String e;
  @BindView(2131692807)
  EditText etTagAddIntroYourself;
  private String f;
  @BindView(2131692806)
  FlowLayout flTagGroupIntroYourself;
  private String g;
  private String r;
  private String s;
  private String[] t;
  @BindView(2131692803)
  TextView tvCompleted;
  @BindView(2131689541)
  TextView tvTitle;
  private int u;
  private String v;
  private List<String> w;
  private IntoLabelListModel x;
  @BindView(2131692804)
  LabeledEditText ziIntoFillBedName;
  @BindView(2131692805)
  LabeledEditText ziIntoFillBedSex;
  
  private void a()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.c = localIntent.getStringExtra("orderBid");
      this.d = localIntent.getStringExtra("houseTypeBid");
      this.e = localIntent.getStringExtra("startDate");
      this.f = localIntent.getStringExtra("endDate");
      this.g = localIntent.getStringExtra("areaBedBid");
      this.r = localIntent.getStringExtra("areaBid");
      this.s = localIntent.getStringExtra("roomName");
    }
    this.tvTitle.setText(this.s);
    this.ziIntoFillBedName.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if ((!ae.isNull(IntoFillBedInfoActivity.this.ziIntoFillBedSex.getText().toString().trim())) && (!ae.isNull(paramAnonymousEditable.toString().trim())))
        {
          IntoFillBedInfoActivity.this.tvCompleted.setTextColor(IntoFillBedInfoActivity.this.getResources().getColor(2131624609));
          return;
        }
        IntoFillBedInfoActivity.this.tvCompleted.setTextColor(IntoFillBedInfoActivity.this.getResources().getColor(2131624599));
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void a(List<String> paramList)
  {
    if (!i.isLegal(paramList)) {}
    for (;;)
    {
      return;
      this.flTagGroupIntroYourself.removeAllViews();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          IntoTagTextView localIntoTagTextView = new IntoTagTextView(this);
          localIntoTagTextView.setTagBean((String)localObject);
          localIntoTagTextView.setGravity(16);
          localIntoTagTextView.setTag(Integer.valueOf(2));
          localIntoTagTextView.setTextAppearance(this, 2131427970);
          localIntoTagTextView.setBackgroundResource(2130837905);
          localObject = new ViewGroup.MarginLayoutParams(-2, n.dip2px(this, 26.0F));
          int i = n.dip2px(this, 6.0F);
          ((ViewGroup.MarginLayoutParams)localObject).setMargins(0, 0, i, i);
          localIntoTagTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          i = n.dip2px(this, 6.0F);
          localIntoTagTextView.setPadding(i, 0, i, 0);
          localIntoTagTextView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              if (((Integer)paramAnonymousView.getTag()).intValue() == 2)
              {
                w.onEventToZiroomAndUmeng("zinn_ol_bq_y");
                paramAnonymousView.setTag(Integer.valueOf(1));
                if (IntoFillBedInfoActivity.d(IntoFillBedInfoActivity.this))
                {
                  ((TextView)paramAnonymousView).setTextAppearance(IntoFillBedInfoActivity.this, 2131427969);
                  paramAnonymousView.setBackgroundResource(2130837906);
                }
              }
              while (((Integer)paramAnonymousView.getTag()).intValue() != 1)
              {
                return;
                af.showToast(IntoFillBedInfoActivity.this, "最多只能选3个标签哟");
                paramAnonymousView.setTag(Integer.valueOf(2));
                return;
              }
              w.onEventToZiroomAndUmeng("zinn_ol_bq_n");
              paramAnonymousView.setTag(Integer.valueOf(2));
              IntoFillBedInfoActivity.d(IntoFillBedInfoActivity.this);
              ((TextView)paramAnonymousView).setTextAppearance(IntoFillBedInfoActivity.this, 2131427970);
              paramAnonymousView.setBackgroundResource(2130837905);
            }
          });
          this.flTagGroupIntroYourself.addView(localIntoTagTextView);
          this.flTagGroupIntroYourself.requestLayout();
        }
      }
    }
  }
  
  private void b()
  {
    if (checkNet(this))
    {
      Map localMap = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildIntoLabelList(this);
      com.ziroom.ziroomcustomer.ziroomstation.b.c.intoGetLabelList(this, new a(null), localMap, true);
    }
  }
  
  private void e()
  {
    this.b = Arrays.asList(this.x.data);
    a(this.b);
  }
  
  private boolean f()
  {
    String str = this.ziIntoFillBedName.getText();
    if (!ae.isNull(str))
    {
      this.v = str;
      str = this.ziIntoFillBedSex.getText();
      if (ae.isNull(str)) {
        break label68;
      }
      if ("男".equals(str))
      {
        this.u = 1;
        return true;
      }
    }
    else
    {
      af.showToast(this, "请输入姓名");
      return false;
    }
    this.u = 2;
    return true;
    label68:
    af.showToast(this, "请选择性别");
    return false;
  }
  
  private void g()
  {
    int j;
    int i;
    label61:
    Object localObject;
    if ((this.w != null) && (this.w.size() > 0))
    {
      j = this.w.size();
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.etTagAddIntroYourself).toString()))
      {
        i = 0;
        this.t = new String[i + j];
        j = 0;
        i = 0;
        if (j >= this.flTagGroupIntroYourself.getChildCount()) {
          break label135;
        }
        localObject = (IntoTagTextView)this.flTagGroupIntroYourself.getChildAt(j);
        if (((Integer)((IntoTagTextView)localObject).getTag()).intValue() != 1) {
          break label233;
        }
        this.t[i] = ((IntoTagTextView)localObject).getText().toString().trim();
        i += 1;
      }
    }
    label135:
    label233:
    for (;;)
    {
      j += 1;
      break label61;
      i = 1;
      break;
      if (!ae.isNull(VdsAgent.trackEditTextSilent(this.etTagAddIntroYourself).toString())) {
        this.t[(this.t.length - 1)] = VdsAgent.trackEditTextSilent(this.etTagAddIntroYourself).toString().trim();
      }
      localObject = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildIntoLockingBed(this, this.c, this.d, this.e, this.f, this.g, this.r, this.t, this.u, this.v);
      com.ziroom.ziroomcustomer.ziroomstation.b.c.intoLockingBed(this, new b(null), (Map)localObject, true);
      return;
    }
  }
  
  private void h()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
  }
  
  private boolean i()
  {
    boolean bool = false;
    if (this.w != null) {
      this.w.removeAll(this.w);
    }
    int i;
    while (this.flTagGroupIntroYourself != null)
    {
      i = 0;
      while (i < this.flTagGroupIntroYourself.getChildCount())
      {
        IntoTagTextView localIntoTagTextView = (IntoTagTextView)this.flTagGroupIntroYourself.getChildAt(i);
        if (((Integer)localIntoTagTextView.getTag()).intValue() == 1) {
          this.w.add(localIntoTagTextView.getText().toString().trim());
        }
        i += 1;
      }
      this.w = new ArrayList();
    }
    int j = this.w.size();
    if (ae.isNull(VdsAgent.trackEditTextSilent(this.etTagAddIntroYourself).toString()))
    {
      i = 0;
      if (j > 3 - i) {
        break label246;
      }
      if (ae.isNull(VdsAgent.trackEditTextSilent(this.etTagAddIntroYourself).toString()))
      {
        if (this.w.size() != 3) {
          break label217;
        }
        this.etTagAddIntroYourself.setClickable(false);
        this.etTagAddIntroYourself.setEnabled(false);
        this.etTagAddIntroYourself.setHint("最多只能设置3个标签哟");
      }
      label208:
      bool = true;
    }
    label217:
    label246:
    do
    {
      return bool;
      i = 1;
      break;
      this.etTagAddIntroYourself.setClickable(true);
      this.etTagAddIntroYourself.setEnabled(true);
      this.etTagAddIntroYourself.setHint("请自定义标签,限制在5个字以内");
      break label208;
      i = this.w.size() - 1;
      while (i > 2)
      {
        this.w.remove(i);
        i -= 1;
      }
    } while (!ae.isNull(VdsAgent.trackEditTextSilent(this.etTagAddIntroYourself).toString()));
    this.etTagAddIntroYourself.setClickable(false);
    this.etTagAddIntroYourself.setEnabled(false);
    this.etTagAddIntroYourself.setHint("最多只能设置3个标签哟");
    return false;
  }
  
  private void j()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("提示").setContent(getResources().getString(2131297558)).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          w.onEventToZiroomAndUmeng("zinn_ol_tc_y");
          IntoFillBedInfoActivity.e(IntoFillBedInfoActivity.this);
          return;
        }
        w.onEventToZiroomAndUmeng("zinn_ol_tc_n");
      }
    }).build().show();
  }
  
  @OnClick({2131690078, 2131692803, 2131692804, 2131692805, 2131692807})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131690078: 
    case 2131692803: 
      do
      {
        return;
        finish();
        return;
      } while (!f());
      j();
      return;
    case 2131692804: 
      w.onEventToZiroomAndUmeng("zinn_ol_name");
      return;
    case 2131692805: 
      h();
      new c(this, this.ziIntoFillBedSex);
      return;
    }
    w.onEventToZiroomAndUmeng("zinn_ol_bq_bj");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903575);
    this.a = ButterKnife.bind(this);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    this.a.unbind();
    super.onDestroy();
  }
  
  private class a
    implements i.a
  {
    private a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        IntoFillBedInfoActivity.a(IntoFillBedInfoActivity.this, (IntoLabelListModel)paramk.getObject());
        if (IntoFillBedInfoActivity.a(IntoFillBedInfoActivity.this) != null)
        {
          if (200 == IntoFillBedInfoActivity.a(IntoFillBedInfoActivity.this).error_code)
          {
            IntoFillBedInfoActivity.b(IntoFillBedInfoActivity.this);
            return;
          }
          af.showToast(IntoFillBedInfoActivity.this, IntoFillBedInfoActivity.a(IntoFillBedInfoActivity.this).error_message);
          return;
        }
        af.showToast(IntoFillBedInfoActivity.this, paramk.getMessage());
        return;
      }
      af.showToast(IntoFillBedInfoActivity.this, paramk.getMessage());
    }
  }
  
  private class b
    implements i.a
  {
    private b() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        com.freelxl.baselibrary.b.b localb = (com.freelxl.baselibrary.b.b)paramk.getObject();
        if (localb != null)
        {
          if (200 == localb.error_code)
          {
            paramk = new Intent();
            paramk.putExtra("name", IntoFillBedInfoActivity.c(IntoFillBedInfoActivity.this));
            IntoFillBedInfoActivity.this.setResult(8, paramk);
            IntoFillBedInfoActivity.this.finish();
            return;
          }
          af.showToast(IntoFillBedInfoActivity.this, localb.error_message);
          return;
        }
        af.showToast(IntoFillBedInfoActivity.this, paramk.getMessage());
        return;
      }
      af.showToast(IntoFillBedInfoActivity.this, paramk.getMessage());
    }
  }
  
  public class c
    extends PopupWindow
  {
    public c(Context paramContext, View paramView)
    {
      Object localObject = View.inflate(paramContext, 2130904443, null);
      ((View)localObject).startAnimation(AnimationUtils.loadAnimation(paramContext, 2130968651));
      ((LinearLayout)((View)localObject).findViewById(2131695549)).startAnimation(AnimationUtils.loadAnimation(paramContext, 2130968674));
      setWidth(-1);
      setHeight(-1);
      setFocusable(true);
      setOutsideTouchable(true);
      setContentView((View)localObject);
      if (!(this instanceof PopupWindow)) {
        showAtLocation(paramView, 80, 0, 0);
      }
      for (;;)
      {
        update();
        paramContext = (Button)((View)localObject).findViewById(2131695550);
        paramView = (Button)((View)localObject).findViewById(2131695551);
        localObject = (Button)((View)localObject).findViewById(2131695552);
        paramContext.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            w.onEventToZiroomAndUmeng("zinn_ol_sex_m");
            IntoFillBedInfoActivity.this.ziIntoFillBedSex.setText("男");
            if (!ae.isNull(IntoFillBedInfoActivity.this.ziIntoFillBedName.getText())) {
              IntoFillBedInfoActivity.this.tvCompleted.setTextColor(IntoFillBedInfoActivity.this.getResources().getColor(2131624609));
            }
            for (;;)
            {
              IntoFillBedInfoActivity.c.this.dismiss();
              return;
              IntoFillBedInfoActivity.this.tvCompleted.setTextColor(IntoFillBedInfoActivity.this.getResources().getColor(2131624599));
            }
          }
        });
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            w.onEventToZiroomAndUmeng("zinn_ol_sex_f");
            IntoFillBedInfoActivity.this.ziIntoFillBedSex.setText("女");
            if (!ae.isNull(IntoFillBedInfoActivity.this.ziIntoFillBedName.getText())) {
              IntoFillBedInfoActivity.this.tvCompleted.setTextColor(IntoFillBedInfoActivity.this.getResources().getColor(2131624609));
            }
            for (;;)
            {
              IntoFillBedInfoActivity.c.this.dismiss();
              return;
              IntoFillBedInfoActivity.this.tvCompleted.setTextColor(IntoFillBedInfoActivity.this.getResources().getColor(2131624599));
            }
          }
        });
        ((Button)localObject).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            IntoFillBedInfoActivity.c.this.dismiss();
          }
        });
        return;
        VdsAgent.showAtLocation((PopupWindow)this, paramView, 80, 0, 0);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/IntoFillBedInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */