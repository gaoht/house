package com.baidu.mapapi.model.inner;

import java.io.Serializable;

public class MapBound
  implements Serializable
{
  public Point ptLB;
  public Point ptRT;
  
  public MapBound()
  {
    if (this.ptLB == null) {
      this.ptLB = new Point();
    }
    if (this.ptRT == null) {
      this.ptRT = new Point();
    }
  }
  
  public Point getPtLB()
  {
    return this.ptLB;
  }
  
  public Point getPtRT()
  {
    return this.ptRT;
  }
  
  public void setPtLB(Point paramPoint)
  {
    this.ptLB = paramPoint;
  }
  
  public void setPtRT(Point paramPoint)
  {
    this.ptRT = paramPoint;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/model/inner/MapBound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */