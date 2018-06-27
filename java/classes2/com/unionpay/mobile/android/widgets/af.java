package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import com.unionpay.mobile.android.utils.i;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class af
  extends aa
{
  private TextWatcher n = new ag(this);
  private ArrayList<a> o = null;
  
  public af(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString)
  {
    super(paramContext, paramInt, paramJSONObject, paramString, (byte)0);
    this.b.a(this.n);
    this.b.a(new InputFilter.LengthFilter(23));
    this.b.a(2);
    if (this.h) {
      this.b.setEnabled(false);
    }
    paramContext = i.d(paramJSONObject, "regex");
    if (paramContext != null)
    {
      paramInt = i;
      if (this.o == null)
      {
        this.o = new ArrayList();
        paramInt = i;
      }
      while (paramInt < paramContext.length())
      {
        paramJSONObject = (JSONObject)i.b(paramContext, paramInt);
        if (paramJSONObject != null) {
          this.o.add(new a(paramJSONObject));
        }
        paramInt += 1;
      }
    }
  }
  
  private static boolean b(String paramString)
  {
    int i2 = paramString.length();
    int i = 0;
    int j = i2 - 2;
    int k = 0;
    while (j >= 0)
    {
      int i1 = paramString.charAt(j) - '0';
      int m = i1;
      if (i % 2 == 0)
      {
        m = i1 * 2;
        m = m % 10 + m / 10;
      }
      k += m;
      j -= 1;
      i += 1;
    }
    if (k % 10 == 0) {}
    for (i = 48; i == paramString.charAt(i2 - 1); i = (char)(10 - k % 10 + 48)) {
      return true;
    }
    return false;
  }
  
  public final String a()
  {
    if (this.h) {}
    for (String str = i();; str = this.b.b()) {
      return str.replace(" ", "");
    }
  }
  
  public final boolean b()
  {
    if (this.h) {}
    String str;
    do
    {
      return true;
      str = a();
      if ((this.o != null) && (this.o.size() > 0))
      {
        int i = 0;
        boolean bool = false;
        while (i < this.o.size())
        {
          a locala = (a)this.o.get(i);
          if (locala.a() != null) {
            bool = str.matches(locala.a());
          }
          if (bool)
          {
            if (locala.c()) {
              bool = b(locala.b() + str);
            }
            for (;;)
            {
              return bool;
              if ((13 <= str.length()) && (19 >= str.length())) {
                bool = true;
              } else {
                bool = false;
              }
            }
          }
          i += 1;
        }
      }
    } while ((13 <= str.length()) && (19 >= str.length()) && (b(str)));
    return false;
  }
  
  protected final String d()
  {
    return "_input_cardNO";
  }
  
  final class a
  {
    private String b = null;
    private String c = null;
    private String d = null;
    
    public a(JSONObject paramJSONObject)
    {
      this.b = i.a(paramJSONObject, "pattern");
      this.c = i.a(paramJSONObject, "prefix");
      this.d = i.a(paramJSONObject, "isCheck");
    }
    
    public final String a()
    {
      return this.b;
    }
    
    public final String b()
    {
      return this.c;
    }
    
    public final boolean c()
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (this.d != null)
      {
        bool1 = bool2;
        if ("false".equalsIgnoreCase(this.d)) {
          bool1 = false;
        }
      }
      return bool1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/widgets/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */