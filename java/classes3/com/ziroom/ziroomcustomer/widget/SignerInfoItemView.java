package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.util.ae;

public class SignerInfoItemView
  extends RelativeLayout
{
  Context a;
  String b;
  String c;
  String d;
  private TextView e;
  private EditText f;
  
  public SignerInfoItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignerInfoItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SignerInfoItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    paramContext = this.a.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.tradeDirectView, 0, 0);
    this.d = paramContext.getString(1);
    this.c = paramContext.getString(0);
    this.b = paramContext.getString(2);
    paramContext.recycle();
    a();
    this.e.setText(this.d);
    this.f.setHint(this.b);
    if (ae.notNull(this.c)) {
      this.f.setText(this.c);
    }
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130904529, this, true);
    this.e = ((TextView)localView.findViewById(2131689541));
    this.f = ((EditText)localView.findViewById(2131690099));
  }
  
  public String getContent()
  {
    if (this.f != null) {
      return VdsAgent.trackEditTextSilent(this.f).toString().trim();
    }
    return "";
  }
  
  public void setContent(String paramString)
  {
    if (ae.notNull(paramString)) {
      this.f.setText(paramString);
    }
  }
  
  public void setEditable(boolean paramBoolean)
  {
    if (this.f != null)
    {
      this.f.setFocusable(paramBoolean);
      if (!paramBoolean) {
        this.f.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return false;
          }
        });
      }
    }
  }
  
  public void setHint(String paramString)
  {
    if (ae.notNull(paramString)) {
      this.f.setHint(paramString);
    }
  }
  
  public SignerInfoItemView setTitle(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.e.setText(paramString);
    }
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/SignerInfoItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */