package com.megvii.a.a;

import com.megvii.livenessdetection.Detector.DetectionFailedType;
import com.megvii.livenessdetection.Detector.DetectionType;

public final class a
{
  private StringBuilder a = new StringBuilder();
  private long b = -1L;
  
  private void b()
  {
    if (this.b == -1L)
    {
      this.b = System.currentTimeMillis();
      this.a.append(System.currentTimeMillis() / 1000L);
      this.a.append("\n");
    }
    this.a.append(System.currentTimeMillis() - this.b);
    this.a.append(":");
  }
  
  public final void a()
  {
    try
    {
      this.a = new StringBuilder();
      this.b = -1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(Detector.DetectionFailedType paramDetectionFailedType)
  {
    if (paramDetectionFailedType == null) {
      label6:
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        b();
        StringBuilder localStringBuilder = this.a;
        str = "";
        switch (1.a[paramDetectionFailedType.ordinal()])
        {
        case 1: 
          localStringBuilder.append(paramDetectionFailedType);
          this.a.append("\n");
          break label6;
        }
      }
      finally {}
      paramDetectionFailedType = "n";
      continue;
      paramDetectionFailedType = "c";
      continue;
      paramDetectionFailedType = str;
      continue;
      paramDetectionFailedType = "b";
      continue;
      paramDetectionFailedType = "t";
      continue;
      paramDetectionFailedType = "m";
      continue;
      paramDetectionFailedType = "o";
      continue;
      paramDetectionFailedType = "l";
    }
  }
  
  public final void a(Detector.DetectionType paramDetectionType)
  {
    if (paramDetectionType == null) {
      label6:
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        b();
        StringBuilder localStringBuilder = this.a;
        str = "";
        switch (1.b[paramDetectionType.ordinal()])
        {
        case 1: 
          localStringBuilder.append(paramDetectionType);
          this.a.append("\n");
          break label6;
        }
      }
      finally {}
      paramDetectionType = "N";
      continue;
      paramDetectionType = "A";
      continue;
      paramDetectionType = str;
      continue;
      paramDetectionType = "O";
      continue;
      paramDetectionType = "E";
      continue;
      paramDetectionType = "M";
      continue;
      paramDetectionType = "Y";
      continue;
      paramDetectionType = "L";
      continue;
      paramDetectionType = "R";
      continue;
      paramDetectionType = "P";
      continue;
      paramDetectionType = "U";
      continue;
      paramDetectionType = "D";
    }
  }
  
  public final String toString()
  {
    try
    {
      String str = this.a.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */