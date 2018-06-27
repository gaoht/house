package com.xiaomi.channel.commonutils.android;

import android.content.pm.Signature;
import java.util.HashSet;

public class d
{
  public static int a(Signature[] paramArrayOfSignature1, Signature[] paramArrayOfSignature2)
  {
    int j = 0;
    int i;
    if (paramArrayOfSignature1 == null) {
      if (paramArrayOfSignature2 == null) {
        i = 1;
      }
    }
    HashSet localHashSet;
    do
    {
      return i;
      return -1;
      if (paramArrayOfSignature2 == null) {
        return -2;
      }
      localHashSet = new HashSet();
      int k = paramArrayOfSignature1.length;
      i = 0;
      while (i < k)
      {
        localHashSet.add(paramArrayOfSignature1[i]);
        i += 1;
      }
      paramArrayOfSignature1 = new HashSet();
      k = paramArrayOfSignature2.length;
      i = 0;
      while (i < k)
      {
        paramArrayOfSignature1.add(paramArrayOfSignature2[i]);
        i += 1;
      }
      i = j;
    } while (localHashSet.equals(paramArrayOfSignature1));
    return -3;
  }
  
  public static boolean a(Signature[] paramArrayOfSignature)
  {
    try
    {
      int i = a(paramArrayOfSignature, new Signature[] { new Signature("3082028b308201f4a00302010202044baf2eea300d06092a864886f70d0101050500308189310b300906035504061302434e310f300d06035504080c06e58c97e4baac3112301006035504070c09e58c97e4baace5b882312d302b060355040a0c24e58c97e4baace5b08fe7b1b3e7a791e68a80e69c89e99990e8b4a3e4bbbbe585ace58fb831123010060355040b0c09e8bdafe4bbb6e983a83112301006035504030c09e7aea1e79086e59198301e170d3130303332383130323635305a170d3335303332323130323635305a308189310b300906035504061302434e310f300d06035504080c06e58c97e4baac3112301006035504070c09e58c97e4baace5b882312d302b060355040a0c24e58c97e4baace5b08fe7b1b3e7a791e68a80e69c89e99990e8b4a3e4bbbbe585ace58fb831123010060355040b0c09e8bdafe4bbb6e983a83112301006035504030c09e7aea1e79086e5919830819f300d06092a864886f70d010101050003818d00308189028181008b0a35791ef2ed5107f6e8cbe3b74ee308a98b4f777b1c7dd7f63578f0bf788bff1c4e3900a8eed13b5b4763c22bbf6f9404e7bf91c555171756cce2cced01b99e265d74ffa77bd58a6a87f442c766758953282d6868a700f34bfc07c4389d6da3ab4cb2b8219c7f7d65837f69559dec82981472b9c57560edf693a510ebfcbf0203010001300d06092a864886f70d0101050500038181008b0562dee241538b22b53e12e5a0adcf5ade76470591256a41bde1bf6d5bcf3ed125114cb509df6d747a291a73093bd7068dc3640d2ab18a9b44626484a7b10020e0a59df1535983b582b3230d422cdea1feeedb16e9c838e2e1957ffc72e84bc83febbb97706ae2e190dab9d6483a353abcedd531398742ebdac12661f447ab") });
      return i == 0;
    }
    catch (Exception paramArrayOfSignature) {}
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/channel/commonutils/android/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */