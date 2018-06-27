package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.c;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.minsu.f.aa;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvoiceAc
  extends BaseActivity
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener
{
  String a;
  private Context b;
  private ImageView c;
  private TextView d;
  private RadioGroup e;
  private RadioButton f;
  private RadioButton g;
  private EditText r;
  private RelativeLayout s;
  private TextView t;
  private Intent u;
  private int v = -1;
  private boolean w = false;
  private boolean x = false;
  private EditText y;
  private String z = "";
  
  private void a()
  {
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((TextView)findViewById(2131690004));
    this.d.setVisibility(0);
    this.d.setText("不开具发票");
    this.e = ((RadioGroup)findViewById(2131690005));
    this.f = ((RadioButton)findViewById(2131690006));
    this.g = ((RadioButton)findViewById(2131690007));
    this.r = ((EditText)findViewById(2131690008));
    this.y = ((EditText)findViewById(2131690009));
    this.s = ((RelativeLayout)findViewById(2131689986));
    this.t = ((TextView)findViewById(2131689997));
  }
  
  private static boolean a(char paramChar)
  {
    return (paramChar != '©') && (paramChar != '®') && (paramChar != '™') && ((paramChar < '↖') || (paramChar > '↙')) && (paramChar != '⏩') && (paramChar != '⏪') && (paramChar != '▶') && (paramChar != '◀') && (paramChar != '◼') && (paramChar != '◻') && (paramChar != '☀') && (paramChar != '☁') && (paramChar != '☎') && (paramChar != '☔') && (paramChar != '☕') && (paramChar != '☝') && (paramChar != '✋') && (paramChar != '☺') && ((paramChar < '♈') || (paramChar > '♓')) && (paramChar != '♠') && (paramChar != '♣') && (paramChar != '♥') && (paramChar != '♦') && (paramChar != '♨') && (paramChar != '♿') && (paramChar != '⚠') && (paramChar != '⚽') && (paramChar != '⚾') && (paramChar != '⛄') && (paramChar != '⛎') && (paramChar != '⛪') && (paramChar != '⛲') && (paramChar != '⛳') && (paramChar != '⛵') && (paramChar != '⛺') && (paramChar != '⛽') && (paramChar != '✂') && (paramChar != '⚡') && (paramChar != '✈') && (paramChar != '✊') && (paramChar != '✌') && (paramChar != '✨') && (paramChar != '✳') && (paramChar != '✴') && (paramChar != '❄') && (paramChar != '❌') && ((paramChar < '❓') || (paramChar > '❕')) && (paramChar != '❗') && (paramChar != '❤') && (paramChar != '➡') && (paramChar != '➿') && ((paramChar < '⬅') || (paramChar > '⬇')) && (paramChar != '⬜') && (paramChar != '⭕') && (paramChar != '〽') && (paramChar != '㊗') && (paramChar != '㊙');
  }
  
  private boolean a(char paramChar, int paramInt)
  {
    if (paramInt == 0) {
      if (((paramChar >= '0') && (paramChar <= '9')) || (paramChar == '#') || (paramChar == '⛪'))
      {
        this.w = true;
        if ((!this.w) || (!this.x)) {
          break label115;
        }
      }
    }
    label115:
    while ((paramChar != 0) && (paramChar != '\t') && (paramChar != '\n') && (paramChar != '\r') && ((paramChar < ' ') || (paramChar > 55295)) && ((paramChar < 57344) || (paramChar > 65533)) && ((paramChar < 65536) || (paramChar > 1114111)))
    {
      return false;
      this.w = false;
      break;
      if (paramInt != 1) {
        break;
      }
      if (this.w)
      {
        if (paramChar == '⃣')
        {
          this.x = true;
          break;
        }
        if (paramChar == 65039)
        {
          this.x = true;
          break;
        }
        this.x = false;
        break;
      }
      this.x = false;
      break;
    }
    return true;
  }
  
  private void b()
  {
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.e.setOnCheckedChangeListener(this);
  }
  
  public static boolean containsEmojiLost(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (!a(paramString.charAt(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void e()
  {
    this.u = getIntent();
    this.a = this.u.getStringExtra("companyName");
    this.z = this.u.getStringExtra("companyNum");
    this.v = this.u.getIntExtra("payerType", -1);
    if (this.v == 0) {
      this.f.setChecked(true);
    }
    while (this.v != 1) {
      return;
    }
    this.g.setChecked(true);
  }
  
  public boolean containsEmoji(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (!a(paramString.charAt(i), i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  @Instrumented
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    VdsAgent.onCheckedChanged(this, paramRadioGroup, paramInt);
    switch (paramRadioGroup.getCheckedRadioButtonId())
    {
    default: 
      return;
    case 2131690006: 
      this.v = 0;
      this.r.setText("");
      this.r.setHint("请输入个人名称");
      this.r.setVisibility(0);
      this.y.setVisibility(8);
      return;
    }
    this.v = 1;
    this.r.setVisibility(0);
    this.y.setVisibility(0);
    this.r.setHint("请输入单位名称");
    String str;
    EditText localEditText;
    if (TextUtils.isEmpty(this.a))
    {
      str = aa.getString(this.b, "companyName", "");
      localEditText = this.r;
      paramRadioGroup = str;
      if (TextUtils.isEmpty(str)) {
        paramRadioGroup = "";
      }
      localEditText.setText(paramRadioGroup);
    }
    while (TextUtils.isEmpty(this.z))
    {
      str = aa.getString(this.b, "companyNum", "");
      localEditText = this.y;
      paramRadioGroup = str;
      if (TextUtils.isEmpty(str)) {
        paramRadioGroup = "";
      }
      localEditText.setText(paramRadioGroup);
      return;
      this.r.setText(this.a);
    }
    this.y.setText(this.z);
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
      finish();
      return;
    case 2131690004: 
      this.u = new Intent();
      this.u.putExtra("needInvoice", false);
      setResult(-1, this.u);
      finish();
      return;
    }
    this.u = new Intent();
    if (this.v == -1)
    {
      g.textToast(this.b, "请选择发票抬头类型");
      return;
    }
    if (this.v == 1)
    {
      paramView = VdsAgent.trackEditTextSilent(this.r).toString();
      if (TextUtils.isEmpty(paramView))
      {
        g.textToast(this.b, "请填写公司名称");
        return;
      }
      String str = VdsAgent.trackEditTextSilent(this.y).toString();
      if (TextUtils.isEmpty(str))
      {
        c.newBuilder(this.b).setButtonText("确定").setContent("国税新规：7月1日起开具公司发票需标明纳税人识别号").setOnButtonClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
          }
        }).build().show();
        return;
      }
      if (Pattern.compile("[a-zA-Z]+").matcher(str).matches())
      {
        c.newBuilder(this.b).setButtonText("确定").setContent("根据国税规定纳税人识别号不能为纯字母组合").setOnButtonClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
          }
        }).build().show();
        return;
      }
      if ((str.length() == 15) || (str.length() == 18) || (str.length() == 20))
      {
        this.u.putExtra("companyName", paramView);
        this.u.putExtra("companyNum", str);
      }
    }
    for (;;)
    {
      this.u.putExtra("needInvoice", true);
      this.u.putExtra("payerType", this.v);
      setResult(-1, this.u);
      finish();
      return;
      c.newBuilder(this.b).setButtonText("确定").setContent("根据国税规定纳税人识别号只能为15、18、20位").setOnButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      }).build().show();
      return;
      if (this.v == 0)
      {
        paramView = VdsAgent.trackEditTextSilent(this.r).toString();
        if (TextUtils.isEmpty(paramView))
        {
          g.textToast(this.b, "请填写个人名称");
          return;
        }
        this.u.putExtra("companyName", paramView);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(35);
    setContentView(2130903108);
    this.b = this;
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/InvoiceAc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */