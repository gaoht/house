package com.ziroom.ziroomcustomer.ziroomapartment.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;

public class ExpandableByLineTextView
  extends TextView
{
  private int a = 0;
  private int b = 3;
  private int c;
  private a d;
  
  public ExpandableByLineTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public ExpandableByLineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ExpandableByLineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  public ExpandableByLineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    if (((paramInt != 0) && (paramInt != 1)) || (this.a == paramInt)) {}
    for (;;)
    {
      return;
      this.a = paramInt;
      if (this.a == 0) {
        setMaxLines(this.b);
      }
      while (this.d != null)
      {
        this.d.onStatusChange(this, this.a);
        return;
        setMaxLines(Integer.MAX_VALUE);
      }
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ExpandableByLineTextView);
      if (paramContext != null)
      {
        int j = paramContext.getIndexCount();
        int i = 0;
        if (i < j)
        {
          int k = paramContext.getIndex(i);
          if (k == 0) {
            this.b = paramContext.getInteger(k, 3);
          }
          for (;;)
          {
            i += 1;
            break;
            if (k == 1) {
              this.a = paramContext.getInteger(k, 0);
            }
          }
        }
        paramContext.recycle();
      }
    }
    if (this.a == 0) {
      setMaxLines(this.b);
    }
    for (;;)
    {
      paramContext = getLayout();
      if (paramContext != null)
      {
        this.c = paramContext.getLineCount();
        if (this.c < this.b) {
          this.a = 1;
        }
      }
      if (this.d != null) {
        this.d.onStatusChange(this, this.a);
      }
      return;
      setMaxLines(Integer.MAX_VALUE);
    }
  }
  
  public int getStatus()
  {
    return this.a;
  }
  
  public void setExpandableText(CharSequence paramCharSequence)
  {
    super.setText(paramCharSequence);
    paramCharSequence = getLayout();
    if (paramCharSequence != null)
    {
      this.c = paramCharSequence.getLineCount();
      if (this.c < this.b) {
        this.a = 1;
      }
    }
    if (this.d != null) {
      this.d.onStatusChange(this, this.a);
    }
  }
  
  public void setOnStatusChangeListener(a parama)
  {
    this.d = parama;
  }
  
  public void setStatus(int paramInt)
  {
    a(paramInt);
  }
  
  public void toggleStatus()
  {
    a(Math.abs(this.a - 1));
  }
  
  public static abstract interface a
  {
    public abstract void onStatusChange(View paramView, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/widget/ExpandableByLineTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */