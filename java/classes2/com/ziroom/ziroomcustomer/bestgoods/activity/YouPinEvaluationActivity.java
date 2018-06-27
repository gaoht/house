package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.newrepair.utils.b;
import com.ziroom.ziroomcustomer.newrepair.widget.StarBar;
import com.ziroom.ziroomcustomer.newrepair.widget.StarBar.a;
import java.util.HashMap;
import java.util.Map;

public class YouPinEvaluationActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Context a;
  private Button b;
  private int c = 0;
  private ImageView d;
  private SimpleDraweeView e;
  private RelativeLayout f;
  private StarBar g;
  private EditText r;
  private int s = 200;
  private TextView t;
  private String u = "";
  private String v = "";
  
  private void a()
  {
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.g.setOnStarChangeListener(new StarBar.a()
    {
      public void onStarChange(float paramAnonymousFloat)
      {
        if (paramAnonymousFloat != YouPinEvaluationActivity.a(YouPinEvaluationActivity.this)) {
          YouPinEvaluationActivity.a(YouPinEvaluationActivity.this, (int)paramAnonymousFloat);
        }
      }
    });
    f();
  }
  
  private void b()
  {
    String str = getIntent().getStringExtra("imgUrl");
    this.u = getIntent().getStringExtra("productCode");
    this.v = getIntent().getStringExtra("maintainOrderCode");
    if (!TextUtils.isEmpty(str)) {
      this.e.setController(com.freelxl.baselibrary.f.c.frescoController(str));
    }
  }
  
  private void e()
  {
    this.d = ((ImageView)findViewById(2131689492));
    this.r = ((EditText)findViewById(2131690002));
    this.t = ((TextView)findViewById(2131690003));
    this.f = ((RelativeLayout)findViewById(2131690001));
    this.g = ((StarBar)findViewById(2131690000));
    this.b = ((Button)findViewById(2131689843));
    this.e = ((SimpleDraweeView)findViewById(2131689999));
    this.c = 0;
  }
  
  private void f()
  {
    this.r.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = paramAnonymousEditable.length();
        YouPinEvaluationActivity.b(YouPinEvaluationActivity.this).setText("" + i);
        this.c = YouPinEvaluationActivity.c(YouPinEvaluationActivity.this).getSelectionStart();
        this.d = YouPinEvaluationActivity.c(YouPinEvaluationActivity.this).getSelectionEnd();
        if (this.b.length() > YouPinEvaluationActivity.d(YouPinEvaluationActivity.this))
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          i = this.d;
          YouPinEvaluationActivity.c(YouPinEvaluationActivity.this).setText(paramAnonymousEditable);
          YouPinEvaluationActivity.c(YouPinEvaluationActivity.this).setSelection(i);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
      }
    });
  }
  
  private void g()
  {
    if (this.c == 0)
    {
      g.textToast(this.a, "请对订单进行评分");
      return;
    }
    showProgressNoCancel("", 30000L);
    String str = VdsAgent.trackEditTextSilent(this.r).toString();
    HashMap localHashMap = new HashMap();
    localHashMap.put("maintainOrderCode", this.v);
    localHashMap.put("evaluateScore", this.c + "");
    localHashMap.put("evaluateContent", str);
    localHashMap.put("evaluateProjectCode", this.u + "_01");
    j.saveGoodsEval(this, localHashMap, new a(new b(null)));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689843: 
      g();
      return;
    }
    paramView = getIntent();
    paramView.putExtra("eval", false);
    setResult(-1, paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(35);
    setContentView(2130903107);
    this.a = this;
    e();
    a();
    b();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = getIntent();
      localIntent.putExtra("eval", false);
      setResult(-1, localIntent);
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      YouPinEvaluationActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      YouPinEvaluationActivity.this.dismissProgress();
      if (paraml.getSuccess().booleanValue())
      {
        g.textToast(YouPinEvaluationActivity.e(YouPinEvaluationActivity.this), "评价订单成功！");
        paraml = YouPinEvaluationActivity.this.getIntent();
        paraml.putExtra("eval", true);
        YouPinEvaluationActivity.this.setResult(-1, paraml);
        YouPinEvaluationActivity.this.finish();
        return;
      }
      paraml = paraml.getMessage();
      YouPinEvaluationActivity.this.showToast(paraml);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinEvaluationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */