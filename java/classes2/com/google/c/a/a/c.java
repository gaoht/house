package com.google.c.a.a;

import java.util.ArrayList;
import java.util.List;

public final class c
{
  private final a a;
  private final List<b> b;
  
  public c(a parama)
  {
    if (!a.e.equals(parama)) {
      throw new IllegalArgumentException("Only QR Code is supported at this time");
    }
    this.a = parama;
    this.b = new ArrayList();
    this.b.add(new b(parama, new int[] { 1 }));
  }
  
  private b a(int paramInt)
  {
    if (paramInt >= this.b.size())
    {
      b localb = (b)this.b.get(this.b.size() - 1);
      int i = this.b.size();
      while (i <= paramInt)
      {
        localb = localb.b(new b(this.a, new int[] { 1, this.a.a(i - 1) }));
        this.b.add(localb);
        i += 1;
      }
    }
    return (b)this.b.get(paramInt);
  }
  
  public void encode(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("No error correction bytes");
    }
    int i = paramArrayOfInt.length - paramInt;
    if (i <= 0) {
      throw new IllegalArgumentException("No data bytes provided");
    }
    Object localObject = a(paramInt);
    int[] arrayOfInt = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    localObject = new b(this.a, arrayOfInt).a(paramInt, 1).c(localObject)[1].a();
    int j = paramInt - localObject.length;
    paramInt = 0;
    while (paramInt < j)
    {
      paramArrayOfInt[(i + paramInt)] = 0;
      paramInt += 1;
    }
    System.arraycopy(localObject, 0, paramArrayOfInt, i + j, localObject.length);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/google/c/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */