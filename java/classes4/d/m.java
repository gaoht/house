package d;

import java.util.AbstractList;
import java.util.RandomAccess;

public final class m
  extends AbstractList<f>
  implements RandomAccess
{
  final f[] a;
  
  private m(f[] paramArrayOff)
  {
    this.a = paramArrayOff;
  }
  
  public static m of(f... paramVarArgs)
  {
    return new m((f[])paramVarArgs.clone());
  }
  
  public f get(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public int size()
  {
    return this.a.length;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */