package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.ziroom.commonlibrary.a.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;

public abstract class t<T>
  extends com.freelxl.baselibrary.d.c.a<T>
{
  private final String b = getClass().getSimpleName();
  protected Context d;
  
  public t(Context paramContext, com.freelxl.baselibrary.d.f.a<T> parama)
  {
    super(parama);
    this.d = paramContext;
  }
  
  public void onFailure(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof com.freelxl.baselibrary.d.d.a))
    {
      d.d(this.b, "MinsuOkNoLoadingCallback=======http" + ((com.freelxl.baselibrary.d.d.a)paramThrowable).getStatusCode());
      if (this.d != null) {
        g.textToast(this.d, ApplicationEx.c.getString(2131297278));
      }
    }
    do
    {
      return;
      if (!(paramThrowable instanceof b)) {
        break;
      }
      paramThrowable = (b)paramThrowable;
      d.d(this.b, "MinsuOkNoLoadingCallback=======ServiceException:" + paramThrowable.getMessage());
      if (this.d != null) {
        g.textToast(this.d.getApplicationContext(), paramThrowable.getMessage());
      }
      if (paramThrowable.getCode() == -1)
      {
        com.ziroom.commonlibrary.g.a.a.handleMessage(this.d, "40005");
        return;
      }
    } while (this.d == null);
    g.textToast(this.d, paramThrowable.getMessage());
    return;
    d.d(this.b, "MinsuOkNoLoadingCallback=======e:" + paramThrowable);
    paramThrowable.printStackTrace();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */