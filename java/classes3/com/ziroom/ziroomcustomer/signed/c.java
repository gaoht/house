package com.ziroom.ziroomcustomer.signed;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{
  private static Hashtable a()
  {
    Hashtable localHashtable = new Hashtable();
    localHashtable.put("11", "北京");
    localHashtable.put("12", "天津");
    localHashtable.put("13", "河北");
    localHashtable.put("14", "山西");
    localHashtable.put("15", "内蒙古");
    localHashtable.put("21", "辽宁");
    localHashtable.put("22", "吉林");
    localHashtable.put("23", "黑龙江");
    localHashtable.put("31", "上海");
    localHashtable.put("32", "江苏");
    localHashtable.put("33", "浙江");
    localHashtable.put("34", "安徽");
    localHashtable.put("35", "福建");
    localHashtable.put("36", "江西");
    localHashtable.put("37", "山东");
    localHashtable.put("41", "河南");
    localHashtable.put("42", "湖北");
    localHashtable.put("43", "湖南");
    localHashtable.put("44", "广东");
    localHashtable.put("45", "广西");
    localHashtable.put("46", "海南");
    localHashtable.put("50", "重庆");
    localHashtable.put("51", "四川");
    localHashtable.put("52", "贵州");
    localHashtable.put("53", "云南");
    localHashtable.put("54", "西藏");
    localHashtable.put("61", "陕西");
    localHashtable.put("62", "甘肃");
    localHashtable.put("63", "青海");
    localHashtable.put("64", "宁夏");
    localHashtable.put("65", "新疆");
    localHashtable.put("71", "台湾");
    localHashtable.put("81", "香港");
    localHashtable.put("82", "澳门");
    localHashtable.put("91", "国外");
    return localHashtable;
  }
  
  public static boolean checkId(String paramString)
  {
    boolean bool = false;
    if (Pattern.compile(".*[a-zA-Z].*[0-9]|.*[0-9].*[a-zA-Z]").matcher(paramString).matches()) {}
    for (int i = 1;; i = 0)
    {
      if (Pattern.compile("[0-9]*").matcher(paramString).matches()) {}
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          bool = true;
        }
        return bool;
      }
    }
  }
  
  public static boolean checkTaiwanId(String paramString)
  {
    return (Pattern.compile("[0-9]*").matcher(paramString).matches()) && (paramString.length() == 8);
  }
  
  public static boolean isNumeric(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public String IDCardValidate(String paramString)
  {
    int j = 0;
    String str1 = paramString.replace("X", "x");
    paramString = "";
    if ((str1.length() != 15) && (str1.length() != 18)) {
      return "身份证号码长度应该为15位或18位。";
    }
    if (str1.length() == 18) {
      paramString = str1.substring(0, 17);
    }
    while (!isNumeric(paramString))
    {
      return "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
      if (str1.length() == 15) {
        paramString = str1.substring(0, 6) + "19" + str1.substring(6, 15);
      }
    }
    String str4 = paramString.substring(6, 10);
    String str2 = paramString.substring(10, 12);
    String str3 = paramString.substring(12, 14);
    if (!isDataFormat(str4 + "-" + str2 + "-" + str3)) {
      return "身份证生日无效。";
    }
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      if ((localGregorianCalendar.get(1) - Integer.parseInt(str4) > 150) || (localGregorianCalendar.getTime().getTime() - localSimpleDateFormat.parse(str4 + "-" + str2 + "-" + str3).getTime() < 0L)) {
        return "身份证生日不在有效范围。";
      }
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
      if ((Integer.parseInt(str2) > 12) || (Integer.parseInt(str2) == 0)) {
        return "身份证月份无效";
      }
      if ((Integer.parseInt(str3) > 31) || (Integer.parseInt(str3) == 0)) {
        return "身份证日期无效";
      }
      if (a().get(paramString.substring(0, 2)) == null) {
        return "身份证地区编码错误。";
      }
      int i = 0;
      while (i < 17)
      {
        j += Integer.parseInt(String.valueOf(paramString.charAt(i))) * Integer.parseInt(new String[] { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2" }[i]);
        i += 1;
      }
      str2 = new String[] { "1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2" }[(j % 11)];
      paramString = paramString + str2;
      if (str1.length() == 18)
      {
        if (!paramString.equals(str1)) {
          return "身份证无效，不是合法的身份证号码";
        }
      }
      else {
        return "";
      }
    }
    return "";
  }
  
  public boolean isDataFormat(String paramString)
  {
    boolean bool = false;
    if (Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$").matcher(paramString).matches()) {
      bool = true;
    }
    return bool;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */