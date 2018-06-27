package cn.testin.analysis;

public class fl
  extends Exception
{
  private final int a;
  
  public fl(String paramString1, String paramString2)
  {
    super(paramString1);
    try
    {
      i = Integer.parseInt(paramString2);
      this.a = i;
      return;
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */