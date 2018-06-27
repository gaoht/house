package cn.testin.analysis;

import android.view.View;

abstract class cr
  extends cm
{
  private String a;
  private String b;
  private final cs c;
  private final String d;
  private final boolean e;
  
  public cr(String paramString1, String paramString2, String paramString3, cs paramcs, boolean paramBoolean)
  {
    this.c = paramcs;
    this.d = paramString1;
    this.e = paramBoolean;
    this.a = paramString3;
    this.b = paramString2;
  }
  
  public void a(View paramView) {}
  
  protected void b(View paramView)
  {
    if (this.c != null) {
      this.c.a(paramView, this.d, this.b, this.a);
    }
  }
  
  protected String c()
  {
    return this.d;
  }
  
  protected void c(View paramView)
  {
    if (this.c != null) {
      this.c.b(paramView, this.d, this.b, this.a);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */