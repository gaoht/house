package com.a.a.a;

public class k
{
  private static boolean[] a;
  private static boolean[] b;
  
  static {}
  
  private static void a()
  {
    b = new boolean['Ā'];
    a = new boolean['Ā'];
    int i = 0;
    if (i < b.length)
    {
      boolean[] arrayOfBoolean = a;
      if ((i == 58) || ((65 <= i) && (i <= 90)) || (i == 95) || ((97 <= i) && (i <= 122)) || ((192 <= i) && (i <= 214)) || ((216 <= i) && (i <= 246)) || ((248 <= i) && (i <= 255)))
      {
        j = 1;
        label110:
        arrayOfBoolean[i] = j;
        arrayOfBoolean = b;
        if ((a[i] == 0) && (i != 45) && (i != 46) && ((48 > i) || (i > 57)) && (i != 183)) {
          break label176;
        }
      }
      label176:
      for (int j = 1;; j = 0)
      {
        arrayOfBoolean[i] = j;
        i = (char)(i + 1);
        break;
        j = 0;
        break label110;
      }
    }
  }
  
  static boolean a(char paramChar)
  {
    return ((paramChar <= '\037') || (paramChar == '')) && (paramChar != '\t') && (paramChar != '\n') && (paramChar != '\r');
  }
  
  static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ("http://purl.org/dc/elements/1.1/".equals(paramString1)) {
      if (!"dc:format".equals(paramString2))
      {
        bool1 = bool2;
        if (!"dc:language".equals(paramString2)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    label102:
    label160:
    label297:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    if (!"http://ns.adobe.com/xap/1.0/".equals(paramString1)) {
                      break label102;
                    }
                    if (("xmp:BaseURL".equals(paramString2)) || ("xmp:CreatorTool".equals(paramString2)) || ("xmp:Format".equals(paramString2)) || ("xmp:Locale".equals(paramString2)) || ("xmp:MetadataDate".equals(paramString2))) {
                      break;
                    }
                    bool1 = bool2;
                  } while (!"xmp:ModifyDate".equals(paramString2));
                  return true;
                  if (!"http://ns.adobe.com/pdf/1.3/".equals(paramString1)) {
                    break label160;
                  }
                  if (("pdf:BaseURL".equals(paramString2)) || ("pdf:Creator".equals(paramString2)) || ("pdf:ModDate".equals(paramString2)) || ("pdf:PDFVersion".equals(paramString2))) {
                    break;
                  }
                  bool1 = bool2;
                } while (!"pdf:Producer".equals(paramString2));
                return true;
                if (!"http://ns.adobe.com/tiff/1.0/".equals(paramString1)) {
                  break;
                }
                bool1 = bool2;
              } while ("tiff:ImageDescription".equals(paramString2));
              bool1 = bool2;
            } while ("tiff:Artist".equals(paramString2));
            bool1 = bool2;
          } while ("tiff:Copyright".equals(paramString2));
          do
          {
            return true;
            if (!"http://ns.adobe.com/exif/1.0/".equals(paramString1)) {
              break;
            }
          } while (!"exif:UserComment".equals(paramString2));
          return false;
          if ("http://ns.adobe.com/exif/1.0/aux/".equals(paramString1)) {
            return true;
          }
          if (!"http://ns.adobe.com/photoshop/1.0/".equals(paramString1)) {
            break;
          }
          bool1 = bool2;
        } while (!"photoshop:ICCProfile".equals(paramString2));
        return true;
        if (!"http://ns.adobe.com/camera-raw-settings/1.0/".equals(paramString1)) {
          break label297;
        }
        if (("crs:Version".equals(paramString2)) || ("crs:RawFileName".equals(paramString2))) {
          break;
        }
        bool1 = bool2;
      } while (!"crs:ToneCurveName".equals(paramString2));
      return true;
      if ("http://ns.adobe.com/StockPhoto/1.0/".equals(paramString1)) {
        return true;
      }
      if ("http://ns.adobe.com/xap/1.0/mm/".equals(paramString1)) {
        return true;
      }
      if ("http://ns.adobe.com/xap/1.0/t/".equals(paramString1)) {
        return true;
      }
      if ("http://ns.adobe.com/xap/1.0/t/pg/".equals(paramString1)) {
        return true;
      }
      if ("http://ns.adobe.com/xap/1.0/g/".equals(paramString1)) {
        return true;
      }
      if ("http://ns.adobe.com/xap/1.0/g/img/".equals(paramString1)) {
        return true;
      }
      bool1 = bool2;
    } while (!"http://ns.adobe.com/xap/1.0/sType/Font#".equals(paramString1));
    return true;
  }
  
  static String[] a(String paramString)
  {
    int j = paramString.indexOf('=');
    if (paramString.charAt(1) == '?') {}
    for (int i = 2;; i = 1)
    {
      String str = paramString.substring(i, j);
      i = j + 1;
      int k = paramString.charAt(i);
      i += 1;
      int m = paramString.length() - 2;
      StringBuffer localStringBuffer = new StringBuffer(m - j);
      while (i < m)
      {
        localStringBuffer.append(paramString.charAt(i));
        j = i + 1;
        i = j;
        if (paramString.charAt(j) == k) {
          i = j + 1;
        }
      }
      return new String[] { str, localStringBuffer.toString() };
    }
  }
  
  private static boolean b(char paramChar)
  {
    return ((paramChar <= 'ÿ') && (a[paramChar] != 0)) || ((paramChar >= 'Ā') && (paramChar <= '˿')) || ((paramChar >= 'Ͱ') && (paramChar <= 'ͽ')) || ((paramChar >= 'Ϳ') && (paramChar <= '῿')) || ((paramChar >= '‌') && (paramChar <= '‍')) || ((paramChar >= '⁰') && (paramChar <= '↏')) || ((paramChar >= 'Ⰰ') && (paramChar <= '⿯')) || ((paramChar >= '、') && (paramChar <= 55295)) || ((paramChar >= 63744) && (paramChar <= 64975)) || ((paramChar >= 65008) && (paramChar <= 65533)) || ((paramChar >= 65536) && (paramChar <= 983039));
  }
  
  static boolean b(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return false;
    }
    int j = 0;
    int k = 0;
    int i = 1;
    if (j < paramString.length())
    {
      int n = k;
      int m = i;
      if (paramString.charAt(j) == '-') {
        if ((i == 0) || ((j != 8) && (j != 13) && (j != 18) && (j != 23))) {
          break label90;
        }
      }
      label90:
      for (i = 1;; i = 0)
      {
        n = k + 1;
        m = i;
        j += 1;
        k = n;
        i = m;
        break;
      }
    }
    if ((i != 0) && (4 == k) && (36 == j)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  static String c(String paramString)
  {
    paramString = new StringBuffer(paramString);
    int i = 0;
    while (i < paramString.length())
    {
      if (a(paramString.charAt(i))) {
        paramString.setCharAt(i, ' ');
      }
      i += 1;
    }
    return paramString.toString();
  }
  
  private static boolean c(char paramChar)
  {
    return ((paramChar <= 'ÿ') && (b[paramChar] != 0)) || (b(paramChar)) || ((paramChar >= '̀') && (paramChar <= 'ͯ')) || ((paramChar >= '‿') && (paramChar <= '⁀'));
  }
  
  public static String escapeXML(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    int i = 0;
    if (i < paramString.length())
    {
      int k = paramString.charAt(i);
      if ((k != 60) && (k != 62) && (k != 38) && ((!paramBoolean2) || ((k != 9) && (k != 10) && (k != 13))) && ((!paramBoolean1) || (k != 34))) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        return paramString;
        i += 1;
        break;
      }
      StringBuffer localStringBuffer = new StringBuffer(paramString.length() * 4 / 3);
      i = j;
      if (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!paramBoolean2) || ((c != '\t') && (c != '\n') && (c != '\r'))) {
          switch (c)
          {
          default: 
            localStringBuffer.append(c);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuffer.append("&lt;");
          continue;
          localStringBuffer.append("&gt;");
          continue;
          localStringBuffer.append("&amp;");
          continue;
          if (paramBoolean1) {}
          for (String str = "&quot;";; str = "\"")
          {
            localStringBuffer.append(str);
            break;
          }
          localStringBuffer.append("&#x");
          localStringBuffer.append(Integer.toHexString(c).toUpperCase());
          localStringBuffer.append(';');
        }
      }
      return localStringBuffer.toString();
    }
  }
  
  public static boolean isXMLName(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString.length() > 0) && (!b(paramString.charAt(0))))
    {
      bool1 = false;
      return bool1;
    }
    int i = 1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramString.length()) {
        break;
      }
      if (!c(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
  }
  
  public static boolean isXMLNameNS(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString.length() > 0) && ((!b(paramString.charAt(0))) || (paramString.charAt(0) == ':')))
    {
      bool1 = false;
      return bool1;
    }
    int i = 1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramString.length()) {
        break;
      }
      if ((!c(paramString.charAt(i))) || (paramString.charAt(i) == ':')) {
        return false;
      }
      i += 1;
    }
  }
  
  public static String normalizeLangValue(String paramString)
  {
    if ("x-default".equals(paramString)) {
      return paramString;
    }
    int j = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      int k = j;
      switch (paramString.charAt(i))
      {
      default: 
        if (j != 2)
        {
          localStringBuffer.append(Character.toLowerCase(paramString.charAt(i)));
          k = j;
        }
        break;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        localStringBuffer.append('-');
        k = j + 1;
        continue;
        localStringBuffer.append(Character.toUpperCase(paramString.charAt(i)));
        k = j;
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */