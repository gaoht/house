package cn.jpush.android.api;

import java.util.Set;

public final class a
{
  private static final String[] z;
  public String a;
  public Set<String> b;
  public TagAliasCallback c;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "\025\0322\023W7\0305/t$\0323\f5{[?\023|7\bd";
    int k = -1;
    int m = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int j = localObject2.length;
    int i;
    Object localObject3;
    int n;
    int i1;
    label50:
    int i2;
    label99:
    label121:
    Object localObject4;
    int i3;
    if (j <= 1)
    {
      i = 0;
      localObject3 = localObject1;
      n = m;
      localObject1 = localObject2;
      i1 = k;
      m = i;
      for (k = i;; k = j)
      {
        localObject2 = localObject1;
        i2 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 21;
          localObject2[k] = ((char)(i ^ i2));
          m += 1;
          if (j != 0) {
            break label121;
          }
        }
      }
      k = j;
      localObject4 = localObject3;
      i3 = n;
      localObject2 = localObject1;
      i2 = i1;
    }
    for (;;)
    {
      i1 = i2;
      localObject1 = localObject2;
      n = i3;
      localObject3 = localObject4;
      j = k;
      i = m;
      if (k > m) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i2)
      {
      default: 
        localObject4[i3] = localObject1;
        localObject2 = "z[*\036r%A";
        m = 1;
        k = 0;
        break;
      case 0: 
        localObject4[i3] = localObject1;
        z = arrayOfString;
        return;
        i = 86;
        break label99;
        i = 123;
        break label99;
        i = 94;
        break label99;
        i = 127;
        break label99;
        i = 0;
        i2 = k;
        i3 = m;
        localObject4 = localObject1;
        k = j;
        m = i;
      }
    }
  }
  
  public a(String paramString, Set<String> paramSet, TagAliasCallback paramTagAliasCallback)
  {
    this.a = paramString;
    this.b = paramSet;
    this.c = paramTagAliasCallback;
  }
  
  public final String toString()
  {
    return z[0] + this.a + z[1] + this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jpush/android/api/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */