package cn.testin.analysis;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

class fi
  extends OutputStream
{
  private StringBuffer b = new StringBuffer();
  
  private fi(fd paramfd) {}
  
  public void close()
  {
    this.b.reverse();
    try
    {
      fd.d(this.a).a(ep.b, fd.d(), true);
      return;
    }
    catch (ek localek)
    {
      throw new di(localek);
    }
    catch (ej localej)
    {
      throw new di(localej);
    }
  }
  
  public void write(int paramInt)
  {
    write(new byte[] { (byte)paramInt }, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
    try
    {
      this.b.append(new String(paramArrayOfByte.array(), "utf-8").trim());
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        try
        {
          fd.d(this.a).a(ep.b, paramArrayOfByte, false);
          return;
        }
        catch (ek paramArrayOfByte)
        {
          throw new di(paramArrayOfByte);
        }
        catch (ej paramArrayOfByte)
        {
          throw new di(paramArrayOfByte);
        }
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/fi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */