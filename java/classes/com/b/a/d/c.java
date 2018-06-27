package com.b.a.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c
{
  private final HashMap<Byte, List<byte[]>> a = new HashMap(10);
  
  private List<byte[]> a(byte paramByte)
  {
    return (List)this.a.get(Byte.valueOf(paramByte));
  }
  
  private List<byte[]> b(byte paramByte)
  {
    if (this.a.containsKey(Byte.valueOf(paramByte))) {
      return (List)this.a.get(Byte.valueOf(paramByte));
    }
    ArrayList localArrayList = new ArrayList();
    this.a.put(Byte.valueOf(paramByte), localArrayList);
    return localArrayList;
  }
  
  public void addSegment(byte paramByte, byte[] paramArrayOfByte)
  {
    b(paramByte).add(paramArrayOfByte);
  }
  
  public boolean containsSegment(byte paramByte)
  {
    return this.a.containsKey(Byte.valueOf(paramByte));
  }
  
  public boolean containsSegment(f paramf)
  {
    return containsSegment(paramf.J);
  }
  
  public byte[] getSegment(byte paramByte)
  {
    return getSegment(paramByte, 0);
  }
  
  public byte[] getSegment(byte paramByte, int paramInt)
  {
    List localList = a(paramByte);
    if ((localList != null) && (localList.size() > paramInt)) {
      return (byte[])localList.get(paramInt);
    }
    return null;
  }
  
  public byte[] getSegment(f paramf)
  {
    return getSegment(paramf.J, 0);
  }
  
  public byte[] getSegment(f paramf, int paramInt)
  {
    return getSegment(paramf.J, paramInt);
  }
  
  public int getSegmentCount(byte paramByte)
  {
    List localList = a(paramByte);
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getSegmentCount(f paramf)
  {
    return getSegmentCount(paramf.J);
  }
  
  public Iterable<f> getSegmentTypes()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Byte localByte = (Byte)localIterator.next();
      f localf = f.fromByte(localByte.byteValue());
      if (localf == null) {
        throw new IllegalStateException("Should not have a segmentTypeByte that is not in the enum: " + Integer.toHexString(localByte.byteValue()));
      }
      localHashSet.add(localf);
    }
    return localHashSet;
  }
  
  public Iterable<byte[]> getSegments(byte paramByte)
  {
    List localList = a(paramByte);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    return (Iterable<byte[]>)localObject;
  }
  
  public Iterable<byte[]> getSegments(f paramf)
  {
    return getSegments(paramf.J);
  }
  
  public void removeSegment(byte paramByte)
  {
    this.a.remove(Byte.valueOf(paramByte));
  }
  
  public void removeSegment(f paramf)
  {
    removeSegment(paramf.J);
  }
  
  public void removeSegmentOccurrence(byte paramByte, int paramInt)
  {
    ((List)this.a.get(Byte.valueOf(paramByte))).remove(paramInt);
  }
  
  public void removeSegmentOccurrence(f paramf, int paramInt)
  {
    removeSegmentOccurrence(paramf.J, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */