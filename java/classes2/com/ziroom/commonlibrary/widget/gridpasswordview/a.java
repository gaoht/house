package com.ziroom.commonlibrary.widget.gridpasswordview;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

public class a
  extends PasswordTransformationMethod
{
  String a;
  
  public a(String paramString)
  {
    this.a = paramString;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    return new a(paramCharSequence);
  }
  
  private class a
    implements CharSequence
  {
    private CharSequence b;
    
    public a(CharSequence paramCharSequence)
    {
      this.b = paramCharSequence;
    }
    
    public char charAt(int paramInt)
    {
      return a.this.a.charAt(0);
    }
    
    public int length()
    {
      return this.b.length();
    }
    
    public CharSequence subSequence(int paramInt1, int paramInt2)
    {
      return this.b.subSequence(paramInt1, paramInt2);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/gridpasswordview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */