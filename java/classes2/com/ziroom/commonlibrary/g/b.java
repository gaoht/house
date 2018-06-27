package com.ziroom.commonlibrary.g;

import com.freelxl.baselibrary.f.h;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
{
  public static String buildRequestId()
  {
    String str1 = UUID.randomUUID().toString();
    String str2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    return str1.substring(0, 8) + ":" + str2;
  }
  
  public static boolean verifyAccountName(String paramString)
  {
    if (paramString == null) {}
    while ((!h.isMobile(paramString)) && (!h.isEmail(paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean verifyPass(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.compile("^\\S{6,16}$").matcher(paramString).matches();
  }
  
  public static boolean verifyUsername(String paramString)
  {
    return Pattern.compile("[a-zA-Z][a-zA-Z0-9]{5,29}").matcher(paramString).matches();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */