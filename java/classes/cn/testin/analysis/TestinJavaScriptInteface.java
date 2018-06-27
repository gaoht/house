package cn.testin.analysis;

import android.webkit.JavascriptInterface;

public class TestinJavaScriptInteface
{
  @JavascriptInterface
  public boolean getBooleanFlag(String paramString, boolean paramBoolean)
  {
    return TestinApi.getBooleanFlag(paramString, paramBoolean);
  }
  
  @JavascriptInterface
  public double getNumberFlag(String paramString, double paramDouble)
  {
    return TestinApi.getDoubleFlag(paramString, paramDouble);
  }
  
  @JavascriptInterface
  public String getStringFlag(String paramString1, String paramString2)
  {
    return TestinApi.getStringFlag(paramString1, paramString2);
  }
  
  @JavascriptInterface
  public void track(String paramString)
  {
    track(paramString, 1.0D);
  }
  
  @JavascriptInterface
  public void track(String paramString, double paramDouble)
  {
    TestinApi.track(paramString, paramDouble);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/TestinJavaScriptInteface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */