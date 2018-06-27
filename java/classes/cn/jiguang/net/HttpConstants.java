package cn.jiguang.net;

public class HttpConstants
{
  public static final String CACHE_CONTROL;
  public static final String EXPIRES;
  public static final int NET_ERROR_CODE = 2998;
  public static final int NET_MALTFORMED_ERROR = 3004;
  public static final int NET_SSL_EXECPTION = 3005;
  public static final int NET_TIMEOUT_CODE = 3001;
  public static final int NET_UNKNOW_HOST = 3003;
  public static final int STACK_OVER_EXECPTION = 3007;
  public static final int UNKNOW_EXECPTION = 3006;
  
  static
  {
    Object localObject1 = "PU1*\006P^";
    int k = -1;
    localObject1 = ((String)localObject1).toCharArray();
    int j = localObject1.length;
    int i;
    int n;
    label27:
    int m;
    Object localObject2;
    int i1;
    if (j <= 1)
    {
      i = 0;
      n = k;
      m = i;
      for (k = i;; k = j)
      {
        localObject2 = localObject1;
        i1 = localObject2[k];
        switch (m % 5)
        {
        default: 
          i = 116;
          label79:
          localObject2[k] = ((char)(i ^ i1));
          m += 1;
          if (j != 0) {
            break label101;
          }
        }
      }
      label101:
      k = j;
      localObject2 = localObject1;
      i1 = n;
    }
    for (;;)
    {
      n = i1;
      localObject1 = localObject2;
      j = k;
      i = m;
      if (k > m) {
        break label27;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i1)
      {
      default: 
        EXPIRES = (String)localObject1;
        localObject1 = "VL\"+\021\030N.-\000GB-";
        k = 0;
        break;
      case 0: 
        CACHE_CONTROL = (String)localObject1;
        return;
        i = 53;
        break label79;
        i = 45;
        break label79;
        i = 65;
        break label79;
        i = 67;
        break label79;
        m = 0;
        i1 = k;
        localObject2 = localObject1;
        k = j;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/net/HttpConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */