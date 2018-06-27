package cn.testin.analysis;

import android.content.Context;
import android.graphics.Rect;

public class gs
  extends gn
{
  private fv h;
  
  public gs(Context paramContext)
  {
    super(paramContext);
    j();
  }
  
  private void j()
  {
    this.h = new fv();
    this.h.a(gm.a);
  }
  
  public String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Rect localRect = this.c.a(paramInt2);
        if (localRect == null) {
          continue;
        }
        paramArrayOfByte = new fx(paramArrayOfByte, paramInt1, paramInt2, localRect.left, localRect.top, localRect.width(), localRect.height(), false);
        paramArrayOfByte = this.h.a(new fq(new hb(paramArrayOfByte)));
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        this.h.a();
        paramArrayOfByte = null;
        continue;
      }
      finally
      {
        this.h.a();
      }
      if (paramArrayOfByte == null) {
        break;
      }
      return paramArrayOfByte.a();
      paramArrayOfByte = new fx(paramArrayOfByte, paramInt1, paramInt2, 0, 0, paramInt1, paramInt2, false);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */