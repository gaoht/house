package cn.testin.analysis;

import android.util.Pair;
import java.math.BigDecimal;

public class av
{
  public static double a(double paramDouble1, double paramDouble2)
  {
    try
    {
      double d = new BigDecimal(Double.toString(paramDouble1)).add(new BigDecimal(Double.toString(paramDouble2))).doubleValue();
      return d;
    }
    catch (Exception localException) {}
    return paramDouble1 + paramDouble2;
  }
  
  public static Pair<String, String> a(String paramString1, String paramString2)
  {
    return new Pair(paramString2, paramString1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */