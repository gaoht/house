package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.DigitsKeyListener;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView.BufferType;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.i;
import java.math.BigDecimal;
import org.json.JSONObject;

public class bd
  extends aa
  implements u.a
{
  private static final String n = bd.class.getSimpleName();
  private String o = null;
  private String p = null;
  private String q = null;
  private String r = null;
  private String s = null;
  
  public bd(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramInt, paramJSONObject, paramString);
    this.r = i.a(paramJSONObject, "point");
    this.q = i.a(paramJSONObject, "max_use_point");
    this.p = i.a(paramJSONObject, "min_use_point");
    this.s = i.a(paramJSONObject, "ratio");
    this.o = i.a(paramJSONObject, "ordr_amnt");
    this.b.a(8194);
    this.b.a(DigitsKeyListener.getInstance("0123456789."));
    try
    {
      paramContext = new BigDecimal(this.p);
      paramContext = paramContext.setScale(2, 6);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        label146:
        paramContext = paramContext;
        paramContext = BigDecimal.ZERO;
        paramContext = paramContext.setScale(2, 6);
      }
    }
    finally {}
    try
    {
      paramJSONObject = new BigDecimal(this.q);
      paramJSONObject = paramJSONObject.setScale(2, 6);
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject = paramJSONObject;
      paramJSONObject = new BigDecimal(3.4028234663852886E38D);
      paramJSONObject = paramJSONObject.setScale(2, 6);
      break label146;
    }
    finally {}
    this.b.a(new a(this.b, paramContext, paramJSONObject));
    a(null, null);
    if ((t() == null) || (t().length() == 0))
    {
      x();
      c(String.format(c.bD.ay, new Object[] { this.r, this.s }));
    }
    this.b.a(this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((s() == null) || (s().length() == 0))
    {
      w();
      if (paramString1 != null) {
        break label87;
      }
      paramString2 = String.format(c.bD.aw, new Object[] { this.q });
      paramString1 = new SpannableString(paramString2);
      paramString1.setSpan(new ForegroundColorSpan(-15958150), 0, paramString2.length(), 0);
    }
    for (;;)
    {
      y();
      a(paramString1, TextView.BufferType.SPANNABLE);
      return;
      label87:
      String str = String.format(c.bD.aw + paramString1, new Object[] { this.q, paramString2 });
      paramString1 = new SpannableString(str);
      paramString1.setSpan(new ForegroundColorSpan(-15958150), 0, str.length() - (paramString2 + "元").length(), 0);
      paramString1.setSpan(new ForegroundColorSpan(-44462), str.length() - (paramString2 + "元").length(), str.length(), 0);
    }
  }
  
  public final String a()
  {
    Object localObject = super.a();
    if ((localObject == null) || (((String)localObject).length() == 0)) {}
    for (;;)
    {
      return null;
      try
      {
        localObject = new BigDecimal((String)localObject);
        ((BigDecimal)localObject).setScale(2, 6);
        if (((BigDecimal)localObject).compareTo(BigDecimal.ZERO) == 1)
        {
          localObject = ((BigDecimal)localObject).toString();
          return (String)localObject;
        }
      }
      catch (Exception localException) {}
    }
    return null;
  }
  
  public final void a(Editable paramEditable)
  {
    super.a(paramEditable);
    if ((s() == null) || (s().length() == 0)) {}
    try
    {
      paramEditable = new BigDecimal(this.s).setScale(2, 6);
      paramEditable = new BigDecimal(this.o).setScale(2, 6).subtract(new BigDecimal(a()).setScale(2, 6).multiply(paramEditable).setScale(2, 6));
      a(c.bD.ax, paramEditable.toString());
      return;
    }
    catch (Exception paramEditable)
    {
      a(null, null);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(this.k);
    }
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public final String h()
  {
    String str = a();
    if ((str == null) || (str.length() == 0)) {
      return null;
    }
    return super.h();
  }
  
  public final class a
    implements InputFilter
  {
    private u b = null;
    private BigDecimal c = null;
    private BigDecimal d = null;
    
    public a(u paramu, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
    {
      this.b = paramu;
      this.c = paramBigDecimal1;
      this.d = paramBigDecimal2;
      if (this.c.compareTo(BigDecimal.ZERO) == 1) {
        c(this.c.toString());
      }
    }
    
    private static int a(String paramString)
    {
      if ((paramString == null) || (!b(paramString))) {
        return 0;
      }
      return paramString.length() - paramString.indexOf(".") - 1;
    }
    
    private CharSequence a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      String str1 = this.d.toString();
      String str2 = this.c.toString();
      try
      {
        paramString = new BigDecimal(paramString);
        paramString.setScale(2, 6);
        if ((paramBoolean1) && (paramBoolean2) && (paramString.compareTo(this.c) == -1)) {
          c(str2);
        }
        if (paramString.compareTo(this.d) == 1) {
          c(str1);
        }
        return null;
      }
      catch (Exception paramString) {}
      return "";
    }
    
    private static boolean b(String paramString)
    {
      return (paramString != null) && (paramString.contains("."));
    }
    
    private void c(String paramString)
    {
      this.b.c(paramString);
      Selection.setSelection(this.b.c(), this.b.b().length());
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      boolean bool1 = true;
      boolean bool2 = false;
      if ((paramCharSequence != null) && (paramCharSequence.equals("")))
      {
        paramCharSequence = paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length());
        bool1 = bool2;
        if (paramInt4 - paramInt3 != 1) {
          bool1 = true;
        }
        return a(paramCharSequence, true, bool1);
      }
      int i = paramInt2 - paramInt1;
      bool2 = b(paramSpanned.toString());
      if (1 == i)
      {
        if ((!bool2) && (paramSpanned.length() == 1) && (paramSpanned.charAt(0) == '0')) {
          return ".";
        }
        if (('0' == paramCharSequence.charAt(0)) && (paramInt3 == 0) && (paramInt4 == 0) && (paramSpanned.length() != 0)) {
          return "";
        }
        if ('.' == paramCharSequence.charAt(0))
        {
          if (paramSpanned.length() == 0) {
            return "";
          }
          if ((paramSpanned.length() != 0) && (paramSpanned.length() - paramInt3 > 2)) {
            return "";
          }
        }
        if ((bool2) && (paramInt3 > paramSpanned.toString().indexOf(".")) && (a(paramSpanned.toString()) > 2 - i)) {
          return "";
        }
      }
      else
      {
        boolean bool3 = b(paramCharSequence.toString());
        if ((bool3) && (bool2)) {
          return "";
        }
        if ((bool3) && ((a(paramCharSequence.toString()) > 2) || (paramSpanned.toString().length() != paramInt4))) {
          return "";
        }
      }
      paramCharSequence = paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length());
      if (a(paramCharSequence) == 2) {}
      for (;;)
      {
        return a(paramCharSequence, false, bool1);
        bool1 = false;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */