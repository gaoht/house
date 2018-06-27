package d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class l
{
  static final Logger a = Logger.getLogger(l.class.getName());
  
  private static a a(Socket paramSocket)
  {
    new a()
    {
      protected IOException newTimeoutException(@Nullable IOException paramAnonymousIOException)
      {
        SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
        if (paramAnonymousIOException != null) {
          localSocketTimeoutException.initCause(paramAnonymousIOException);
        }
        return localSocketTimeoutException;
      }
      
      protected void timedOut()
      {
        try
        {
          l.this.close();
          return;
        }
        catch (Exception localException)
        {
          l.a.log(Level.WARNING, "Failed to close timed out socket " + l.this, localException);
          return;
        }
        catch (AssertionError localAssertionError)
        {
          if (l.a(localAssertionError))
          {
            l.a.log(Level.WARNING, "Failed to close timed out socket " + l.this, localAssertionError);
            return;
          }
          throw localAssertionError;
        }
      }
    };
  }
  
  private static s a(final OutputStream paramOutputStream, u paramu)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("out == null");
    }
    if (paramu == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    new s()
    {
      public void close()
        throws IOException
      {
        paramOutputStream.close();
      }
      
      public void flush()
        throws IOException
      {
        paramOutputStream.flush();
      }
      
      public u timeout()
      {
        return l.this;
      }
      
      public String toString()
      {
        return "sink(" + paramOutputStream + ")";
      }
      
      public void write(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        v.checkOffsetAndCount(paramAnonymousc.b, 0L, paramAnonymousLong);
        while (paramAnonymousLong > 0L)
        {
          l.this.throwIfReached();
          p localp = paramAnonymousc.a;
          int i = (int)Math.min(paramAnonymousLong, localp.c - localp.b);
          paramOutputStream.write(localp.a, localp.b, i);
          localp.b += i;
          long l = paramAnonymousLong - i;
          paramAnonymousc.b -= i;
          paramAnonymousLong = l;
          if (localp.b == localp.c)
          {
            paramAnonymousc.a = localp.pop();
            q.a(localp);
            paramAnonymousLong = l;
          }
        }
      }
    };
  }
  
  private static t a(final InputStream paramInputStream, u paramu)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("in == null");
    }
    if (paramu == null) {
      throw new IllegalArgumentException("timeout == null");
    }
    new t()
    {
      public void close()
        throws IOException
      {
        paramInputStream.close();
      }
      
      public long read(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        if (paramAnonymousLong < 0L) {
          throw new IllegalArgumentException("byteCount < 0: " + paramAnonymousLong);
        }
        if (paramAnonymousLong == 0L) {
          return 0L;
        }
        try
        {
          l.this.throwIfReached();
          p localp = paramAnonymousc.a(1);
          int i = (int)Math.min(paramAnonymousLong, 8192 - localp.c);
          i = paramInputStream.read(localp.a, localp.c, i);
          if (i == -1) {
            return -1L;
          }
          localp.c += i;
          paramAnonymousc.b += i;
          return i;
        }
        catch (AssertionError paramAnonymousc)
        {
          if (l.a(paramAnonymousc)) {
            throw new IOException(paramAnonymousc);
          }
          throw paramAnonymousc;
        }
      }
      
      public u timeout()
      {
        return l.this;
      }
      
      public String toString()
      {
        return "source(" + paramInputStream + ")";
      }
    };
  }
  
  static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static s appendingSink(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return sink(new FileOutputStream(paramFile, true));
  }
  
  public static s blackhole()
  {
    new s()
    {
      public void close()
        throws IOException
      {}
      
      public void flush()
        throws IOException
      {}
      
      public u timeout()
      {
        return u.NONE;
      }
      
      public void write(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        paramAnonymousc.skip(paramAnonymousLong);
      }
    };
  }
  
  public static d buffer(s params)
  {
    return new n(params);
  }
  
  public static e buffer(t paramt)
  {
    return new o(paramt);
  }
  
  public static s sink(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return sink(new FileOutputStream(paramFile));
  }
  
  public static s sink(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, new u());
  }
  
  public static s sink(Socket paramSocket)
    throws IOException
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    if (paramSocket.getOutputStream() == null) {
      throw new IOException("socket's output stream == null");
    }
    a locala = a(paramSocket);
    return locala.sink(a(paramSocket.getOutputStream(), locala));
  }
  
  @IgnoreJRERequirement
  public static s sink(Path paramPath, OpenOption... paramVarArgs)
    throws IOException
  {
    if (paramPath == null) {
      throw new IllegalArgumentException("path == null");
    }
    return sink(Files.newOutputStream(paramPath, paramVarArgs));
  }
  
  public static t source(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("file == null");
    }
    return source(new FileInputStream(paramFile));
  }
  
  public static t source(InputStream paramInputStream)
  {
    return a(paramInputStream, new u());
  }
  
  public static t source(Socket paramSocket)
    throws IOException
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("socket == null");
    }
    if (paramSocket.getInputStream() == null) {
      throw new IOException("socket's input stream == null");
    }
    a locala = a(paramSocket);
    return locala.source(a(paramSocket.getInputStream(), locala));
  }
  
  @IgnoreJRERequirement
  public static t source(Path paramPath, OpenOption... paramVarArgs)
    throws IOException
  {
    if (paramPath == null) {
      throw new IllegalArgumentException("path == null");
    }
    return source(Files.newInputStream(paramPath, paramVarArgs));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */