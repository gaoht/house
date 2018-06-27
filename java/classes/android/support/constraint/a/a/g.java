package android.support.constraint.a.a;

import java.util.ArrayList;

public class g
{
  private int a;
  private int b;
  private int c;
  private int d;
  private ArrayList<a> e = new ArrayList();
  
  public g(b paramb)
  {
    this.a = paramb.getX();
    this.b = paramb.getY();
    this.c = paramb.getWidth();
    this.d = paramb.getHeight();
    paramb = paramb.getAnchors();
    int j = paramb.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)paramb.get(i);
      this.e.add(new a(locala));
      i += 1;
    }
  }
  
  public void applyTo(b paramb)
  {
    paramb.setX(this.a);
    paramb.setY(this.b);
    paramb.setWidth(this.c);
    paramb.setHeight(this.d);
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((a)this.e.get(i)).applyTo(paramb);
      i += 1;
    }
  }
  
  public void updateFrom(b paramb)
  {
    this.a = paramb.getX();
    this.b = paramb.getY();
    this.c = paramb.getWidth();
    this.d = paramb.getHeight();
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      ((a)this.e.get(i)).updateFrom(paramb);
      i += 1;
    }
  }
  
  static class a
  {
    private a a;
    private a b;
    private int c;
    private a.b d;
    private int e;
    
    public a(a parama)
    {
      this.a = parama;
      this.b = parama.getTarget();
      this.c = parama.getMargin();
      this.d = parama.getStrength();
      this.e = parama.getConnectionCreator();
    }
    
    public void applyTo(b paramb)
    {
      paramb.getAnchor(this.a.getType()).connect(this.b, this.c, this.d, this.e);
    }
    
    public void updateFrom(b paramb)
    {
      this.a = paramb.getAnchor(this.a.getType());
      if (this.a != null)
      {
        this.b = this.a.getTarget();
        this.c = this.a.getMargin();
        this.d = this.a.getStrength();
        this.e = this.a.getConnectionCreator();
        return;
      }
      this.b = null;
      this.c = 0;
      this.d = a.b.b;
      this.e = 0;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/constraint/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */