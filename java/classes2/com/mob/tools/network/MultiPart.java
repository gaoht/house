package com.mob.tools.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiPart
  extends HTTPPart
{
  private ArrayList<HTTPPart> parts = new ArrayList();
  
  public MultiPart append(HTTPPart paramHTTPPart)
    throws Throwable
  {
    this.parts.add(paramHTTPPart);
    return this;
  }
  
  protected InputStream getInputStream()
    throws Throwable
  {
    MultiPartInputStream localMultiPartInputStream = new MultiPartInputStream();
    Iterator localIterator = this.parts.iterator();
    while (localIterator.hasNext()) {
      localMultiPartInputStream.addInputStream(((HTTPPart)localIterator.next()).getInputStream());
    }
    return localMultiPartInputStream;
  }
  
  protected long length()
    throws Throwable
  {
    Iterator localIterator = this.parts.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((HTTPPart)localIterator.next()).length() + l) {}
    return l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.parts.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((HTTPPart)localIterator.next()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/network/MultiPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */