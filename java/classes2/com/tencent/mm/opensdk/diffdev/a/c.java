package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c
  implements Runnable
{
  c(b paramb) {}
  
  public final void run()
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(a.a(this.g.f));
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OAuthListener)((Iterator)localObject).next()).onQrcodeScanned();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/mm/opensdk/diffdev/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */