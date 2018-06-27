package cn.testin.analysis;

public final class fq
{
  private final fp a;
  private gt b;
  
  public fq(fp paramfp)
  {
    if (paramfp == null) {
      throw new IllegalArgumentException("Binarizer must be non-null.");
    }
    this.a = paramfp;
  }
  
  public gt a()
  {
    if (this.b == null) {
      this.b = this.a.b();
    }
    return this.b;
  }
  
  public String toString()
  {
    try
    {
      String str = a().toString();
      return str;
    }
    catch (fw localfw) {}
    return "";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */