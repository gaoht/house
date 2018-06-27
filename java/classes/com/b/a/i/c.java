package com.b.a.i;

import com.b.b.n;
import java.io.IOException;

public class c
{
  public void processRiff(n paramn, a parama)
    throws b, IOException
  {
    paramn.setMotorolaByteOrder(false);
    String str = paramn.getString(4);
    if (!str.equals("RIFF")) {
      throw new b("Invalid RIFF header: " + str);
    }
    int i = paramn.getInt32();
    str = paramn.getString(4);
    i -= 4;
    label78:
    int k;
    if (!parama.shouldAcceptRiffIdentifier(str))
    {
      return;
      if (!parama.shouldAcceptChunk(str)) {
        break label173;
      }
      parama.processChunk(str, paramn.getBytes(k));
    }
    for (;;)
    {
      int j = i - k;
      i = j;
      if (k % 2 == 1)
      {
        paramn.getInt8();
        i = j - 1;
      }
      if (i == 0) {
        break;
      }
      str = paramn.getString(4);
      k = paramn.getInt32();
      i -= 8;
      if ((k >= 0) && (i >= k)) {
        break label78;
      }
      throw new b("Invalid RIFF chunk size");
      label173:
      paramn.skip(k);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */