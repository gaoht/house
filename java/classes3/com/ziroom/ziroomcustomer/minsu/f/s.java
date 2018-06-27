package com.ziroom.ziroomcustomer.minsu.f;

import android.app.Activity;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.a.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;

public class s<T>
  extends com.ziroom.commonlibrary.a.a<T>
{
  private final String c = getClass().getSimpleName();
  
  public s(Activity paramActivity, com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(paramActivity, parama);
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    super.onFailure(paramThrowable);
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a))
    {
      d.e(this.c, "=======http" + ((com.freelxl.baselibrary.d.d.a)paramThrowable).getStatusCode());
      if (this.b != null) {
        g.textToast(this.b, ApplicationEx.c.getString(2131297278));
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramThrowable instanceof b)) {
          break;
        }
        paramThrowable = (b)paramThrowable;
        d.i(this.c, "=======ServiceException:" + paramThrowable.getMessage());
        if (paramThrowable.getCode() == -1)
        {
          com.ziroom.commonlibrary.g.a.a.handleMessage(this.b, "40005");
          return;
        }
      } while (this.b == null);
      g.textToast(this.b, paramThrowable.getMessage());
      return;
      d.e(this.c, "=======e:" + paramThrowable);
      paramThrowable.printStackTrace();
    } while (this.b == null);
    g.textToast(this.b, ApplicationEx.c.getString(2131297278));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */