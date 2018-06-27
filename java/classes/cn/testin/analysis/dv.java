package cn.testin.analysis;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;

class dv
  implements Runnable
{
  private dv(dt paramdt) {}
  
  public void run()
  {
    Thread.currentThread().setName("WebsocketWriteThread");
    try
    {
      while (!Thread.interrupted())
      {
        ByteBuffer localByteBuffer = (ByteBuffer)dt.a(this.a).f.take();
        dt.b(this.a).write(localByteBuffer.array(), 0, localByteBuffer.limit());
        dt.b(this.a).flush();
      }
      return;
    }
    catch (IOException localIOException)
    {
      dt.a(this.a).b();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */