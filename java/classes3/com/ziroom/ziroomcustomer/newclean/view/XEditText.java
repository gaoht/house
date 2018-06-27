package com.ziroom.ziroomcustomer.newclean.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

@SuppressLint({"AppCompatCustomView"})
public class XEditText
  extends EditText
{
  final int a = 0;
  final int b = 1;
  final int c = 2;
  final int d = 3;
  private a e;
  private b f;
  private Drawable g = getCompoundDrawables()[2];
  private Drawable h = getCompoundDrawables()[0];
  private Drawable i = getCompoundDrawables()[1];
  private Drawable j = getCompoundDrawables()[3];
  
  public XEditText(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public XEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public XEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public XEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
  }
  
  private void a()
  {
    this.g = getCompoundDrawables()[2];
    this.h = getCompoundDrawables()[0];
    this.i = getCompoundDrawables()[1];
    this.j = getCompoundDrawables()[3];
    a(getText().toString());
    addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        XEditText.a(XEditText.this, paramAnonymousEditable.toString());
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.length() > 0)
    {
      setCompoundDrawables(this.h, this.i, this.g, this.j);
      return;
    }
    setCompoundDrawables(this.h, this.i, null, this.j);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    Drawable localDrawable;
    do
    {
      return super.onTouchEvent(paramMotionEvent);
      localDrawable = getCompoundDrawables()[2];
    } while ((localDrawable == null) || (paramMotionEvent.getRawX() < getRight() - localDrawable.getBounds().width()));
    setText("");
    return true;
  }
  
  public void setDrawableLeftListener(a parama)
  {
    this.e = parama;
  }
  
  public void setDrawableRightListener(b paramb)
  {
    this.f = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void onDrawableLeftClick(View paramView);
  }
  
  public static abstract interface b
  {
    public abstract void onDrawableRightClick(View paramView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/view/XEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */