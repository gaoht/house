package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;

public class SignerInfoView
  extends RelativeLayout
{
  Context a;
  String b;
  private TextView c;
  private TextView d;
  
  public SignerInfoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SignerInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SignerInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    paramContext = this.a.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.tradeDirectView, 0, 0);
    this.b = paramContext.getString(0);
    paramContext.recycle();
    a();
    this.d.setText(this.b);
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130904567, this, true);
    this.c = ((TextView)localView.findViewById(2131695778));
    this.d = ((TextView)localView.findViewById(2131695779));
  }
  
  public String getContent()
  {
    if ((this.c.getVisibility() != 8) && (!TextUtils.isEmpty(this.d.getText()))) {
      return this.d.getText().toString();
    }
    return "";
  }
  
  public SignerInfoView setContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.c.setVisibility(0);
      this.d.setText(paramString);
      this.c.setText(this.b);
      return this;
    }
    this.d.setText(this.b);
    this.c.setVisibility(8);
    return this;
  }
  
  public SignerInfoView setTitle(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b = paramString;
      if (this.c.getVisibility() == 8) {
        this.d.setText(paramString);
      }
    }
    else
    {
      return this;
    }
    this.c.setText(paramString);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/SignerInfoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */