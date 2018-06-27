package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.R.styleable;
import com.ziroom.ziroomcustomer.base.ApplicationEx;

public class MinsuHouseDeatailFolderTextView
  extends TextView
{
  private static int b = ApplicationEx.c.getResources().getColor(2131624475);
  ClickableSpan a = new ClickableSpan()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      paramAnonymousView = MinsuHouseDeatailFolderTextView.this;
      if (!MinsuHouseDeatailFolderTextView.a(MinsuHouseDeatailFolderTextView.this)) {}
      for (boolean bool = true;; bool = false)
      {
        MinsuHouseDeatailFolderTextView.a(paramAnonymousView, bool);
        MinsuHouseDeatailFolderTextView.b(MinsuHouseDeatailFolderTextView.this, false);
        if (MinsuHouseDeatailFolderTextView.b(MinsuHouseDeatailFolderTextView.this) != null) {
          MinsuHouseDeatailFolderTextView.b(MinsuHouseDeatailFolderTextView.this).onClick();
        }
        MinsuHouseDeatailFolderTextView.this.invalidate();
        return;
      }
    }
    
    public void updateDrawState(TextPaint paramAnonymousTextPaint)
    {
      paramAnonymousTextPaint.setColor(MinsuHouseDeatailFolderTextView.a());
    }
  };
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private int f;
  private boolean g = true;
  private b h;
  private a i;
  private String j;
  private float k = 1.0F;
  private float l = 0.0F;
  
  public MinsuHouseDeatailFolderTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MinsuHouseDeatailFolderTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MinsuHouseDeatailFolderTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(R.styleable.MinsuHouseDeatailFolderTextView);
    this.f = paramContext.getInt(0, 3);
    paramContext.recycle();
  }
  
  private Layout a(String paramString)
  {
    return new StaticLayout(paramString, getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.k, this.l, false);
  }
  
  private SpannableString b(String paramString)
  {
    paramString = c(paramString);
    int m = paramString.length();
    int n = "查看更多".length();
    int i1 = paramString.length();
    paramString = new SpannableString(paramString);
    paramString.setSpan(this.a, m - n, i1, 33);
    return paramString;
  }
  
  private void b()
  {
    if (!this.g) {
      setText(this.j);
    }
    String str;
    do
    {
      return;
      str = this.j;
      if (!this.c) {
        break;
      }
    } while (this.i == null);
    this.i.onFold(str);
    return;
    setUpdateText(b(str));
    setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private String c(String paramString)
  {
    String str = paramString + "... " + "查看更多";
    Layout localLayout = a(str);
    int m;
    if (localLayout.getLineCount() > getFoldLine())
    {
      int n = localLayout.getLineEnd(getFoldLine());
      m = n;
      if (paramString.length() < n) {
        m = paramString.length();
      }
      if (m != 0) {}
    }
    else
    {
      return str;
    }
    return c(paramString.substring(0, m - 1));
  }
  
  public static void setColor(int paramInt)
  {
    b = paramInt;
  }
  
  private void setUpdateText(CharSequence paramCharSequence)
  {
    this.e = true;
    setText(paramCharSequence);
  }
  
  public int getFoldLine()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.d) {
      b();
    }
    super.onDraw(paramCanvas);
    this.d = true;
    this.e = false;
  }
  
  public void setClickSpan(b paramb)
  {
    this.h = paramb;
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setFoldLine(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setIsUseFold(boolean paramBoolean)
  {
    this.g = paramBoolean;
    b();
  }
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    this.l = paramFloat1;
    this.k = paramFloat2;
    super.setLineSpacing(paramFloat1, paramFloat2);
  }
  
  public void setOnChangeListener(a parama)
  {
    this.i = parama;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((TextUtils.isEmpty(this.j)) || (!this.e))
    {
      this.d = false;
      this.j = String.valueOf(paramCharSequence);
    }
    super.setText(paramCharSequence, paramBufferType);
  }
  
  public static abstract interface a
  {
    public abstract void onFold(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/MinsuHouseDeatailFolderTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */