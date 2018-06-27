package cn.jiguang.c.c;

import java.net.SocketTimeoutException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

class a
{
  protected long a;
  protected SelectionKey b;
  
  protected a(SelectableChannel paramSelectableChannel, long paramLong)
  {
    Object localObject1 = null;
    this.a = paramLong;
    try
    {
      Selector localSelector = Selector.open();
      localObject1 = localSelector;
      paramSelectableChannel.configureBlocking(false);
      localObject1 = localSelector;
      this.b = paramSelectableChannel.register(localSelector, 1);
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((Selector)localObject1).close();
      }
      paramSelectableChannel.close();
    }
  }
  
  protected static void a(SelectionKey paramSelectionKey, long paramLong)
  {
    paramLong -= System.currentTimeMillis();
    int i = 0;
    if (paramLong > 0L) {
      i = paramSelectionKey.selector().select(paramLong);
    }
    while (i == 0)
    {
      throw new SocketTimeoutException();
      if (paramLong == 0L) {
        i = paramSelectionKey.selector().selectNow();
      }
    }
  }
  
  final void a()
  {
    this.b.selector().close();
    this.b.channel().close();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/c/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */