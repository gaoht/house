package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.model.LabelMo;
import com.ziroom.ziroomcustomer.newServiceList.view.a;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpecialNeedActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private List<LabelMo> a;
  private ArrayList<LabelMo> b = new ArrayList();
  private FlowLayout c;
  private EditText d;
  private View e;
  private View f;
  private String g;
  private String r;
  private TextView s;
  private TextView t;
  private TextView u;
  private int v;
  private boolean w;
  private boolean x;
  private int y = 200;
  private a z;
  
  private long a(CharSequence paramCharSequence)
  {
    double d1 = 0.0D;
    int i = 0;
    while (i < paramCharSequence.length())
    {
      d1 += 1.0D;
      i += 1;
    }
    return Math.round(d1);
  }
  
  private void a()
  {
    if (this.w)
    {
      if ((TextUtils.isEmpty(this.g)) && (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.d).toString()))) {
        a(false);
      }
    }
    else {
      return;
    }
    a(true);
  }
  
  private void a(List<LabelMo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        d(((LabelMo)paramList.next()).getTagName());
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
    if (paramBoolean)
    {
      this.f.setBackgroundResource(2130838025);
      this.f.setClickable(true);
      this.f.setEnabled(true);
      this.f.setTag(Boolean.valueOf(paramBoolean));
      return;
    }
    this.f.setBackgroundColor(getResources().getColor(2131624046));
    this.f.setClickable(false);
    this.f.setEnabled(false);
    this.f.setTag(Boolean.valueOf(paramBoolean));
  }
  
  private void b()
  {
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.d.addTextChangedListener(this.z);
  }
  
  private void d(String paramString)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(getResources().getColor(2131624516));
    localButton.setTextSize(12.0F);
    localButton.setPadding(10, 0, 10, 0);
    localButton.setBackgroundResource(2130839371);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(10, 10, 10, 0);
    localButton.setLayoutParams(paramString);
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
          paramAnonymousView.setBackgroundResource(2130839376);
          paramAnonymousView.setTextColor(SpecialNeedActivity.this.getResources().getColor(2131624583));
          paramAnonymousView.setTag(Boolean.valueOf(true));
          SpecialNeedActivity.a(SpecialNeedActivity.this, str);
          return;
        }
        paramAnonymousView.setBackgroundResource(2130839371);
        paramAnonymousView.setTextColor(SpecialNeedActivity.this.getResources().getColor(2131624516));
        paramAnonymousView.setTag(Boolean.valueOf(false));
        SpecialNeedActivity.b(SpecialNeedActivity.this, str);
      }
    });
    this.c.addView(localButton);
  }
  
  private void e()
  {
    this.c = ((FlowLayout)findViewById(2131690332));
    this.d = ((EditText)findViewById(2131690333));
    this.z = new a(this.d, this);
    this.e = findViewById(2131689492);
    this.f = findViewById(2131690330);
    this.s = ((TextView)findViewById(2131690334));
    this.t = ((TextView)findViewById(2131691766));
    this.u = ((TextView)findViewById(2131689541));
    this.t.setText(this.y + "");
  }
  
  private void e(String paramString)
  {
    String str = this.g;
    if (ae.isNull(str)) {}
    for (;;)
    {
      this.g = paramString;
      if (!this.x) {
        a();
      }
      return;
      paramString = str + "," + paramString;
    }
  }
  
  private void f()
  {
    a(this.a);
    if ((this.g != null) && (this.g.length() > 0)) {
      g();
    }
  }
  
  private void f(String paramString)
  {
    String str2 = this.g;
    String str1 = str2;
    if (ae.notNull(str2))
    {
      str1 = str2.replace(paramString, "").replace(",,", ",");
      paramString = str1;
      if (str1.indexOf(",") == 0)
      {
        paramString = str1;
        if (str1.length() > 1) {
          paramString = str1.substring(1);
        }
      }
      int i = paramString.lastIndexOf(",");
      str1 = paramString;
      if (i > 0)
      {
        str1 = paramString;
        if (i == paramString.length() - 1) {
          str1 = paramString.substring(0, i);
        }
      }
    }
    this.g = str1;
    if (this.x) {
      a();
    }
  }
  
  private String g(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return "";
      } while (paramString.length() < 1);
      paramString = paramString.split(",");
    } while ((paramString == null) || (paramString.length <= 0));
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      LabelMo localLabelMo = h(paramString[i]);
      this.b.add(localLabelMo);
      localStringBuilder1.append(localLabelMo.toString()).append(",");
      localStringBuilder2.append(localLabelMo.getTagName()).append(",");
      i += 1;
    }
    localStringBuilder1.deleteCharAt(localStringBuilder1.length() - 1);
    localStringBuilder2.deleteCharAt(localStringBuilder2.length() - 1);
    this.r = localStringBuilder2.toString();
    return localStringBuilder1.toString();
  }
  
  private void g()
  {
    String[] arrayOfString = this.g.split(",");
    int i = 0;
    while (i < this.c.getChildCount())
    {
      Button localButton = (Button)this.c.getChildAt(i);
      int j = 0;
      while (j < arrayOfString.length)
      {
        if (arrayOfString[j].equals(localButton.getText()))
        {
          localButton.setBackgroundResource(2131624516);
          localButton.setTextColor(getResources().getColor(2131624583));
          localButton.setTag(Boolean.valueOf(true));
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  private LabelMo h(String paramString)
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        LabelMo localLabelMo = (LabelMo)localIterator.next();
        if (localLabelMo.getTagName().equals(paramString)) {
          return localLabelMo;
        }
      }
    }
    return null;
  }
  
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
    paramView = getIntent();
    String str = g(this.g);
    paramView.putExtra("TagStr", this.g);
    paramView.putExtra("NeedTag", str);
    paramView.putExtra("NeedTagId", this.r);
    paramView.putExtra("position", this.v);
    paramView.putExtra("Remark", VdsAgent.trackEditTextSilent(this.d).toString());
    paramView.putParcelableArrayListExtra("TagList", this.b);
    setResult(-1, paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903453);
    paramBundle = getIntent();
    String str1 = paramBundle.getExtras().getString("lastInput");
    String str2 = paramBundle.getExtras().getString("lastTag");
    String str3 = paramBundle.getExtras().getString("title");
    String str4 = paramBundle.getExtras().getString("hint");
    this.w = paramBundle.getBooleanExtra("isRequired", false);
    this.a = paramBundle.getParcelableArrayListExtra("taglist");
    this.v = paramBundle.getIntExtra("position", -1);
    this.y = paramBundle.getIntExtra("num", 200);
    e();
    if (!TextUtils.isEmpty(str3)) {
      this.u.setText(str3);
    }
    if (!TextUtils.isEmpty(str4)) {
      this.d.setHint(str4);
    }
    if (!TextUtils.isEmpty(str1))
    {
      this.d.setText(str1);
      this.s.setText(str1.length() + "/");
      this.d.setSelection(str1.length());
    }
    if (str2 != null) {
      this.g = str2;
    }
    if (this.w)
    {
      if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) {
        break label269;
      }
      a(false);
    }
    for (;;)
    {
      b();
      if ((this.a != null) && (this.a.size() > 0)) {
        f();
      }
      return;
      label269:
      a(true);
    }
  }
  
  class a
    extends a
  {
    private int b;
    private int c;
    
    public a(EditText paramEditText, Context paramContext)
    {
      super(paramContext);
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      super.afterTextChanged(paramEditable);
      this.b = SpecialNeedActivity.c(SpecialNeedActivity.this).getSelectionStart();
      this.c = SpecialNeedActivity.c(SpecialNeedActivity.this).getSelectionEnd();
      SpecialNeedActivity.c(SpecialNeedActivity.this).removeTextChangedListener(SpecialNeedActivity.d(SpecialNeedActivity.this));
      while (SpecialNeedActivity.a(SpecialNeedActivity.this, paramEditable.toString()) > SpecialNeedActivity.a(SpecialNeedActivity.this))
      {
        paramEditable.delete(this.b - 1, this.c);
        this.b -= 1;
        this.c -= 1;
      }
      if ((paramEditable != null) && (paramEditable.toString().length() > 0) && (!SpecialNeedActivity.e(SpecialNeedActivity.this))) {
        SpecialNeedActivity.f(SpecialNeedActivity.this);
      }
      for (;;)
      {
        SpecialNeedActivity.c(SpecialNeedActivity.this).setSelection(this.b);
        SpecialNeedActivity.c(SpecialNeedActivity.this).addTextChangedListener(SpecialNeedActivity.d(SpecialNeedActivity.this));
        return;
        if ((SpecialNeedActivity.e(SpecialNeedActivity.this)) && ((paramEditable == null) || (paramEditable.toString().length() == 0))) {
          SpecialNeedActivity.f(SpecialNeedActivity.this);
        }
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if (paramCharSequence.length() > SpecialNeedActivity.a(SpecialNeedActivity.this))
      {
        SpecialNeedActivity.b(SpecialNeedActivity.this).setText(SpecialNeedActivity.a(SpecialNeedActivity.this) + "/");
        SpecialNeedActivity.this.showToast("字数超出限制！");
        return;
      }
      SpecialNeedActivity.b(SpecialNeedActivity.this).setText(paramCharSequence.length() + "/");
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/SpecialNeedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */