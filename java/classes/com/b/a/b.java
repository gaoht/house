package com.b.a;

import com.b.b.d;
import java.io.BufferedInputStream;
import java.io.IOException;

public class b
{
  private static final d<a> a = new d();
  
  static
  {
    a.setDefaultValue(a.a);
    a.addPath(a.b, new byte[][] { { -1, -40 } });
    a.addPath(a.c, new byte[][] { "II".getBytes(), { 42, 0 } });
    a.addPath(a.c, new byte[][] { "MM".getBytes(), { 0, 42 } });
    a.addPath(a.d, new byte[][] { "8BPS".getBytes() });
    a.addPath(a.e, new byte[][] { { -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82 } });
    a.addPath(a.f, new byte[][] { "BM".getBytes() });
    a.addPath(a.g, new byte[][] { "GIF87a".getBytes() });
    a.addPath(a.g, new byte[][] { "GIF89a".getBytes() });
    a.addPath(a.h, new byte[][] { { 0, 0, 1, 0 } });
    a.addPath(a.i, new byte[][] { { 10, 0, 1 } });
    a.addPath(a.i, new byte[][] { { 10, 2, 1 } });
    a.addPath(a.i, new byte[][] { { 10, 3, 1 } });
    a.addPath(a.i, new byte[][] { { 10, 5, 1 } });
    a.addPath(a.j, new byte[][] { "RIFF".getBytes() });
    a.addPath(a.k, new byte[][] { "II".getBytes(), { 42, 0, 8, 0 } });
    d locald = a;
    a locala = a.l;
    byte[] arrayOfByte1 = "II".getBytes();
    byte[] arrayOfByte2 = "HEAPCCDR".getBytes();
    locald.addPath(locala, new byte[][] { arrayOfByte1, { 26, 0, 0, 0 }, arrayOfByte2 });
    a.addPath(a.m, new byte[][] { "II".getBytes(), { 42, 0, 16, 0, 0, 0, 67, 82 } });
    a.addPath(a.n, new byte[][] { "MM".getBytes(), { 0, 42, 0, 0, 0, -128, 0 } });
    a.addPath(a.o, new byte[][] { "IIRO".getBytes(), { 8, 0 } });
    a.addPath(a.o, new byte[][] { "IIRS".getBytes(), { 8, 0 } });
    a.addPath(a.p, new byte[][] { "FUJIFILMCCD-RAW".getBytes() });
    a.addPath(a.q, new byte[][] { "II".getBytes(), { 85, 0 } });
  }
  
  public static a detectFileType(BufferedInputStream paramBufferedInputStream)
    throws IOException
  {
    if (!paramBufferedInputStream.markSupported()) {
      throw new IOException("Stream must support mark/reset");
    }
    int i = a.getMaxDepth();
    paramBufferedInputStream.mark(i);
    byte[] arrayOfByte = new byte[i];
    if (paramBufferedInputStream.read(arrayOfByte) == -1) {
      throw new IOException("Stream ended before file's magic number could be determined.");
    }
    paramBufferedInputStream.reset();
    return (a)a.find(arrayOfByte);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */