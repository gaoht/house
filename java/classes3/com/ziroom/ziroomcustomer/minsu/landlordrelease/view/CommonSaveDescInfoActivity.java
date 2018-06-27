package com.ziroom.ziroomcustomer.minsu.landlordrelease.view;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.flux.a.a;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.MinsuReleaseActivity;
import java.util.Timer;
import java.util.TimerTask;

public class CommonSaveDescInfoActivity
  extends BaseFluxActivity
  implements View.OnClickListener
{
  private ImageView b;
  private TextView c;
  private FrameLayout d;
  private EditText e;
  private TextView f;
  private TextView g;
  private TextView r;
  private int s = 1000;
  private int t = 100;
  private boolean u = false;
  private boolean v = false;
  
  private void a()
  {
    this.e.requestFocus();
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)CommonSaveDescInfoActivity.this.getSystemService("input_method");
        localInputMethodManager.showSoftInput(CommonSaveDescInfoActivity.a(CommonSaveDescInfoActivity.this), 2);
        localInputMethodManager.toggleSoftInput(2, 1);
      }
    }, 250L);
  }
  
  private void b()
  {
    int i = b.getScreenWidth(this);
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131690401));
    this.r = ((TextView)findViewById(2131690400));
    this.d = ((FrameLayout)findViewById(2131690402));
    this.e = ((EditText)findViewById(2131690002));
    this.f = ((TextView)findViewById(2131690403));
    this.g = ((TextView)findViewById(2131690404));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i - b.dip2px(this, 36.0F), i * 2 / 3);
    localLayoutParams.gravity = 1;
    this.e.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    g();
  }
  
  private void f()
  {
    Object localObject = getIntent().getStringExtra("titleName");
    String str1 = getIntent().getStringExtra("editTextHint");
    String str2 = getIntent().getStringExtra("saveDescText");
    this.s = getIntent().getIntExtra("editMaxNum", 1000);
    this.t = getIntent().getIntExtra("editMinNum", 100);
    this.v = getIntent().getBooleanExtra("nullable", false);
    this.r.setText((CharSequence)localObject);
    this.e.setHint(str1);
    if (!TextUtils.isEmpty(str2))
    {
      this.e.setText(str2);
      this.f.setText("" + str2.length());
      localObject = VdsAgent.trackEditTextSilent(this.e);
      if ((localObject instanceof Spannable)) {
        Selection.setSelection((Spannable)localObject, ((CharSequence)localObject).length());
      }
    }
    this.g.setText("/" + this.s);
    if (this.v)
    {
      this.c.setEnabled(true);
      this.c.setTextColor(Color.parseColor("#444444"));
    }
  }
  
  private void g()
  {
    this.e.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        CommonSaveDescInfoActivity.b(CommonSaveDescInfoActivity.this).setText("" + paramAnonymousEditable.length());
        this.c = CommonSaveDescInfoActivity.a(CommonSaveDescInfoActivity.this).getSelectionStart();
        this.d = CommonSaveDescInfoActivity.a(CommonSaveDescInfoActivity.this).getSelectionEnd();
        if (this.b.length() > CommonSaveDescInfoActivity.c(CommonSaveDescInfoActivity.this))
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          int i = this.d;
          CommonSaveDescInfoActivity.a(CommonSaveDescInfoActivity.this).setText(paramAnonymousEditable);
          CommonSaveDescInfoActivity.a(CommonSaveDescInfoActivity.this).setSelection(i);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
        CommonSaveDescInfoActivity.a(CommonSaveDescInfoActivity.this, true);
        CommonSaveDescInfoActivity.this.validateInput();
      }
    });
  }
  
  private void h()
  {
    if ((getWindow().getAttributes().softInputMode != 2) && (getCurrentFocus() != null)) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
  }
  
  public void finish()
  {
    super.finish();
    h();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      if ((this.u) && (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.e).toString())))
      {
        d.newBuilder(this).setOnConfirmClickListener(new d.b()
        {
          public void onLeftClick(View paramAnonymousView) {}
          
          public void onRightClick(View paramAnonymousView)
          {
            CommonSaveDescInfoActivity.this.finish();
          }
        }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
        return;
      }
      finish();
      return;
    }
    paramView = VdsAgent.trackEditTextSilent(this.e).toString();
    if ((this.v) && (paramView.length() == 0)) {}
    while (paramView.length() >= this.t)
    {
      Intent localIntent = new Intent(this, MinsuReleaseActivity.class);
      localIntent.putExtra("saveDesc", paramView);
      setResult(4096, localIntent);
      finish();
      return;
    }
    g.textToast(this, "输入信息不可少于" + this.t + "字");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903159);
    b();
    e();
    f();
    a();
  }
  
  protected void onEventHandle(a parama) {}
  
  public void validateInput()
  {
    if (TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.e).toString()))
    {
      if (this.v)
      {
        this.c.setEnabled(true);
        this.c.setTextColor(Color.parseColor("#444444"));
        return;
      }
      this.c.setEnabled(false);
      this.c.setTextColor(Color.parseColor("#999999"));
      return;
    }
    this.c.setEnabled(true);
    this.c.setTextColor(Color.parseColor("#444444"));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/view/CommonSaveDescInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */