package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ah;

public class MinsuOrderSuccessfulActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private TextView c;
  private String d = null;
  private CommonTitle e;
  private String f;
  private String g;
  private int r;
  private String s;
  private String t;
  private String u;
  
  public void initTitle()
  {
    this.e = ((CommonTitle)findViewById(2131691272));
    this.e.showRightText(false, null);
    CommonTitle localCommonTitle = this.e;
    if (this.r == 0) {}
    for (String str = "预订" + this.f + "的房间";; str = "提示")
    {
      localCommonTitle.setMiddleText(str);
      this.e.setLeftButtonType(0);
      this.e.setOnLeftButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuOrderSuccessfulActivity.this.finish();
        }
      });
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903320);
    this.b = ((TextView)findViewById(2131691632));
    this.a = ((TextView)findViewById(2131691631));
    this.c = ((TextView)findViewById(2131689921));
    this.t = getIntent().getStringExtra("from");
    this.u = getIntent().getStringExtra("phone");
    this.d = getIntent().getStringExtra("orderSn");
    this.f = getIntent().getStringExtra("lName");
    this.g = getIntent().getStringExtra("msg");
    this.s = getIntent().getStringExtra("btnText");
    this.r = getIntent().getIntExtra("type", 0);
    initTitle();
    if ((!TextUtils.isEmpty(this.t)) && ("Apply".equals(this.t)) && (!TextUtils.isEmpty(this.u)))
    {
      paramBundle = new a(this.u);
      SpannableString localSpannableString = new SpannableString(this.g + this.u);
      localSpannableString.setSpan(paramBundle, this.g.length(), (this.g + this.u).length(), 17);
      this.a.setMovementMethod(LinkMovementMethod.getInstance());
      this.a.setHighlightColor(0);
      this.a.setText(localSpannableString);
    }
    for (;;)
    {
      if (this.r == 1)
      {
        this.b.setText(this.s);
        this.c.setText(this.f);
        paramBundle = getResources().getDrawable(2130838523);
        paramBundle.setBounds(0, 0, paramBundle.getMinimumWidth(), paramBundle.getMinimumHeight());
        this.c.setCompoundDrawables(paramBundle, null, null, null);
      }
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (MinsuOrderSuccessfulActivity.a(MinsuOrderSuccessfulActivity.this) == 0)
          {
            paramAnonymousView = new Intent(MinsuOrderSuccessfulActivity.this, MinsuSignedActivity.class);
            paramAnonymousView.putExtra("orderSn", MinsuOrderSuccessfulActivity.b(MinsuOrderSuccessfulActivity.this));
            MinsuOrderSuccessfulActivity.this.startActivity(paramAnonymousView);
          }
          MinsuOrderSuccessfulActivity.this.finish();
        }
      });
      return;
      this.a.setText(this.g);
    }
  }
  
  class a
    extends ClickableSpan
  {
    private String b;
    
    public a(String paramString)
    {
      this.b = paramString;
    }
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
      ah.callPhone(MinsuOrderSuccessfulActivity.this, this.b);
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.setColor(Color.parseColor("#FFC743"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuOrderSuccessfulActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */