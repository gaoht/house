package com.ziroom.ziroomcustomer.widget.ziroompulltorefresh;

import in.srain.cube.views.ptr.a.a;

class c
  implements b
{
  private b a;
  private c b;
  
  private b a()
  {
    return this.a;
  }
  
  private boolean a(b paramb)
  {
    return (this.a != null) && (this.a == paramb);
  }
  
  public static void addHandler(c paramc, b paramb)
  {
    if (paramb == null) {
      break label4;
    }
    label4:
    while (paramc == null) {
      return;
    }
    c localc = paramc;
    if (paramc.a == null)
    {
      paramc.a = paramb;
      return;
    }
    do
    {
      localc = localc.b;
      if (localc.a(paramb)) {
        break;
      }
    } while (localc.b != null);
    paramc = new c();
    paramc.a = paramb;
    localc.b = paramc;
  }
  
  public static c create()
  {
    return new c();
  }
  
  public static c removeHandler(c paramc, b paramb)
  {
    if ((paramc == null) || (paramb == null) || (paramc.a == null)) {
      return paramc;
    }
    Object localObject3 = null;
    Object localObject2 = paramc;
    c localc = paramc;
    label25:
    Object localObject1;
    if (localc.a(paramb)) {
      if (localObject3 == null)
      {
        localObject1 = localc.b;
        localc.b = null;
        paramc = (c)localObject1;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      localc = paramc;
      if (paramc != null) {
        break label25;
      }
      paramc = (c)localObject1;
      if (localObject1 != null) {
        break;
      }
      return new c();
      ((c)localObject3).b = localc.b;
      localc.b = null;
      paramc = ((c)localObject3).b;
      localObject1 = localObject2;
      continue;
      paramc = localc.b;
      localObject3 = localc;
      localObject1 = localObject2;
    }
  }
  
  public boolean hasHandler()
  {
    return this.a != null;
  }
  
  public void onUIPositionChange(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, a parama)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((c)localObject1).a();
      if (localObject2 != null) {
        ((b)localObject2).onUIPositionChange(paramPtrFrameLayout, paramBoolean, paramByte, parama);
      }
      localObject2 = ((c)localObject1).b;
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
  
  public void onUIRefreshBegin(PtrFrameLayout paramPtrFrameLayout)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((c)localObject1).a();
      if (localObject2 != null) {
        ((b)localObject2).onUIRefreshBegin(paramPtrFrameLayout);
      }
      localObject2 = ((c)localObject1).b;
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
  
  public void onUIRefreshComplete(PtrFrameLayout paramPtrFrameLayout)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((c)localObject1).a();
      if (localObject2 != null) {
        ((b)localObject2).onUIRefreshComplete(paramPtrFrameLayout);
      }
      localObject2 = ((c)localObject1).b;
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
  
  public void onUIRefreshPrepare(PtrFrameLayout paramPtrFrameLayout)
  {
    Object localObject1 = this;
    if (!hasHandler()) {
      return;
    }
    Object localObject2;
    do
    {
      localObject2 = ((c)localObject1).a();
      if (localObject2 != null) {
        ((b)localObject2).onUIRefreshPrepare(paramPtrFrameLayout);
      }
      localObject2 = ((c)localObject1).b;
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
  
  public void onUIReset(PtrFrameLayout paramPtrFrameLayout)
  {
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = ((c)localObject1).a();
      if (localObject2 != null) {
        ((b)localObject2).onUIReset(paramPtrFrameLayout);
      }
      localObject2 = ((c)localObject1).b;
      localObject1 = localObject2;
    } while (localObject2 != null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ziroompulltorefresh/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */