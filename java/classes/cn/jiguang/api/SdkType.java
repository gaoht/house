package cn.jiguang.api;

public enum SdkType
{
  private static final String[] z;
  
  static
  {
    String[] arrayOfString = new String[5];
    int j = 0;
    Object localObject2 = "}\030S/t";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label67:
      n = m;
      label70:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 49;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label70;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label67;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "}\bT<cr";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "}\013I.y";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "}\026Y.bv\034Y";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "}\032R<}n\017U>b";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        JCORE = new SdkType(z[0], 0);
        JPUSH = new SdkType(z[2], 1);
        JANALYTICS = new SdkType(z[4], 2);
        JSHARE = new SdkType(z[1], 3);
        JMESSAGE = new SdkType(z[3], 4);
        $VALUES = new SdkType[] { JCORE, JPUSH, JANALYTICS, JSHARE, JMESSAGE };
        return;
        i = 55;
        continue;
        i = 91;
        continue;
        i = 28;
        continue;
        i = 125;
      }
    }
  }
  
  private SdkType() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/api/SdkType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */