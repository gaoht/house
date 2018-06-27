package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comjni.map.basemap.a;
import java.util.Iterator;
import java.util.List;

class j
  extends Handler
{
  j(i parami) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (i.a(this.a) == null)
    {
      break label15;
      break label15;
      break label15;
    }
    for (;;)
    {
      label15:
      return;
      if (((Long)paramMessage.obj).longValue() == i.a(this.a).h)
      {
        Object localObject2;
        Object localObject1;
        if (paramMessage.what == 4000)
        {
          localObject2 = i.a(this.a).f.iterator();
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label320;
            }
            k localk = (k)((Iterator)localObject2).next();
            localObject1 = null;
            if (paramMessage.arg2 == 1)
            {
              int[] arrayOfInt = new int[i.b(this.a) * i.c(this.a)];
              localObject1 = new int[i.b(this.a) * i.c(this.a)];
              if (i.a(this.a).g == null) {
                break;
              }
              arrayOfInt = i.a(this.a).g.a(arrayOfInt, i.b(this.a), i.c(this.a));
              int i = 0;
              while (i < i.c(this.a))
              {
                int j = 0;
                while (j < i.b(this.a))
                {
                  int k = arrayOfInt[(i.b(this.a) * i + j)];
                  localObject1[((i.c(this.a) - i - 1) * i.b(this.a) + j)] = (k & 0xFF00FF00 | k << 16 & 0xFF0000 | k >> 16 & 0xFF);
                  j += 1;
                }
                i += 1;
              }
              localObject1 = Bitmap.createBitmap((int[])localObject1, i.b(this.a), i.c(this.a), Bitmap.Config.ARGB_8888);
            }
            localk.a((Bitmap)localObject1);
          }
        }
        else
        {
          label320:
          if (paramMessage.what == 39)
          {
            if (i.a(this.a) == null) {
              break;
            }
            if (paramMessage.arg1 == 100) {
              i.a(this.a).A();
            }
            while ((!i.a(this.a).i) && (i.c(this.a) > 0) && (i.b(this.a) > 0) && (i.a(this.a).b(0, 0) != null))
            {
              i.a(this.a).i = true;
              paramMessage = i.a(this.a).f.iterator();
              while (paramMessage.hasNext()) {
                ((k)paramMessage.next()).b();
              }
              if (paramMessage.arg1 == 200)
              {
                i.a(this.a).K();
              }
              else if (paramMessage.arg1 == 1)
              {
                this.a.requestRender();
              }
              else if (paramMessage.arg1 == 0)
              {
                this.a.requestRender();
                if ((!i.a(this.a).c()) && (this.a.getRenderMode() != 0)) {
                  this.a.setRenderMode(0);
                }
              }
            }
            paramMessage = i.a(this.a).f.iterator();
            while (paramMessage.hasNext()) {
              ((k)paramMessage.next()).a();
            }
            continue;
          }
          if (paramMessage.what == 41)
          {
            if ((i.a(this.a) == null) || ((!i.a(this.a).l) && (!i.a(this.a).m))) {
              break;
            }
            paramMessage = i.a(this.a).f.iterator();
            while (paramMessage.hasNext()) {
              ((k)paramMessage.next()).b(i.a(this.a).D());
            }
            continue;
          }
          if (paramMessage.what == 999)
          {
            paramMessage = i.a(this.a).f.iterator();
            while (paramMessage.hasNext()) {
              ((k)paramMessage.next()).d();
            }
          }
          else
          {
            if (paramMessage.what != 50) {
              break;
            }
            localObject1 = i.a(this.a).f.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (k)((Iterator)localObject1).next();
              if (paramMessage.arg1 == 0) {
                ((k)localObject2).a(false);
              } else if (paramMessage.arg1 == 1) {
                ((k)localObject2).a(true);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/map/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */