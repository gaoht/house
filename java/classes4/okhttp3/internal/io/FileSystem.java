package okhttp3.internal.io;

import d.l;
import d.s;
import d.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract interface FileSystem
{
  public static final FileSystem SYSTEM = new FileSystem()
  {
    public s appendingSink(File paramAnonymousFile)
      throws FileNotFoundException
    {
      try
      {
        s locals = l.appendingSink(paramAnonymousFile);
        return locals;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramAnonymousFile.getParentFile().mkdirs();
      }
      return l.appendingSink(paramAnonymousFile);
    }
    
    public void delete(File paramAnonymousFile)
      throws IOException
    {
      if ((!paramAnonymousFile.delete()) && (paramAnonymousFile.exists())) {
        throw new IOException("failed to delete " + paramAnonymousFile);
      }
    }
    
    public void deleteContents(File paramAnonymousFile)
      throws IOException
    {
      File[] arrayOfFile = paramAnonymousFile.listFiles();
      if (arrayOfFile == null) {
        throw new IOException("not a readable directory: " + paramAnonymousFile);
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        paramAnonymousFile = arrayOfFile[i];
        if (paramAnonymousFile.isDirectory()) {
          deleteContents(paramAnonymousFile);
        }
        if (!paramAnonymousFile.delete()) {
          throw new IOException("failed to delete " + paramAnonymousFile);
        }
        i += 1;
      }
    }
    
    public boolean exists(File paramAnonymousFile)
    {
      return paramAnonymousFile.exists();
    }
    
    public void rename(File paramAnonymousFile1, File paramAnonymousFile2)
      throws IOException
    {
      delete(paramAnonymousFile2);
      if (!paramAnonymousFile1.renameTo(paramAnonymousFile2)) {
        throw new IOException("failed to rename " + paramAnonymousFile1 + " to " + paramAnonymousFile2);
      }
    }
    
    public s sink(File paramAnonymousFile)
      throws FileNotFoundException
    {
      try
      {
        s locals = l.sink(paramAnonymousFile);
        return locals;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramAnonymousFile.getParentFile().mkdirs();
      }
      return l.sink(paramAnonymousFile);
    }
    
    public long size(File paramAnonymousFile)
    {
      return paramAnonymousFile.length();
    }
    
    public t source(File paramAnonymousFile)
      throws FileNotFoundException
    {
      return l.source(paramAnonymousFile);
    }
  };
  
  public abstract s appendingSink(File paramFile)
    throws FileNotFoundException;
  
  public abstract void delete(File paramFile)
    throws IOException;
  
  public abstract void deleteContents(File paramFile)
    throws IOException;
  
  public abstract boolean exists(File paramFile);
  
  public abstract void rename(File paramFile1, File paramFile2)
    throws IOException;
  
  public abstract s sink(File paramFile)
    throws FileNotFoundException;
  
  public abstract long size(File paramFile);
  
  public abstract t source(File paramFile)
    throws FileNotFoundException;
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/okhttp3/internal/io/FileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */