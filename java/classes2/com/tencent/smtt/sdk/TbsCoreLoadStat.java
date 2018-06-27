package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;

public class TbsCoreLoadStat
{
  private static TbsCoreLoadStat d = null;
  public static volatile int mLoadErrorCode = -1;
  private TbsSequenceQueue a = null;
  private boolean b = false;
  private final int c = 3;
  
  private void a(int paramInt)
  {
    this.b = true;
    if ((this.b == true) && (this.a != null) && (this.a.empty())) {
      this.b = false;
    }
  }
  
  public static TbsCoreLoadStat getInstance()
  {
    if (d == null) {
      d = new TbsCoreLoadStat();
    }
    return d;
  }
  
  void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
    this.b = false;
  }
  
  void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, null);
    TbsLog.e("loaderror", "" + paramInt);
  }
  
  void a(Context paramContext, int paramInt, Throwable paramThrowable)
  {
    if (mLoadErrorCode == -1) {
      mLoadErrorCode = paramInt;
    }
    TbsLog.addLog(998, "code=%d,desc=%s", new Object[] { Integer.valueOf(paramInt), String.valueOf(paramThrowable) });
    a(paramInt);
    if ((this.b) && (paramThrowable != null)) {
      TbsLogReport.a(paramContext).b(paramInt, paramThrowable);
    }
  }
  
  public class TbsSequenceQueue
  {
    private int b = 10;
    private int c;
    private int[] d;
    private int e = 0;
    private int f = 0;
    
    public TbsSequenceQueue()
    {
      this.c = this.b;
      this.d = new int[this.c];
    }
    
    public TbsSequenceQueue(int paramInt1, int paramInt2)
    {
      this.c = paramInt2;
      this.d = new int[this.c];
      this.d[0] = paramInt1;
      this.f += 1;
    }
    
    public void add(int paramInt)
    {
      if (this.f > this.c - 1) {
        throw new IndexOutOfBoundsException("sequeue is full");
      }
      int[] arrayOfInt = this.d;
      int i = this.f;
      this.f = (i + 1);
      arrayOfInt[i] = paramInt;
    }
    
    public void clear()
    {
      Arrays.fill(this.d, 0);
      this.e = 0;
      this.f = 0;
    }
    
    public int element()
    {
      if (empty()) {
        throw new IndexOutOfBoundsException("sequeue is null");
      }
      return this.d[this.e];
    }
    
    public boolean empty()
    {
      return this.f == this.e;
    }
    
    public int length()
    {
      return this.f - this.e;
    }
    
    public int remove()
    {
      if (empty()) {
        throw new IndexOutOfBoundsException("sequeue is null");
      }
      int i = this.d[this.e];
      int[] arrayOfInt = this.d;
      int j = this.e;
      this.e = (j + 1);
      arrayOfInt[j] = 0;
      return i;
    }
    
    public String toString()
    {
      if (empty()) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder("[");
      int i = this.e;
      while (i < this.f)
      {
        localStringBuilder.append(String.valueOf(this.d[i]) + ",");
        i += 1;
      }
      i = localStringBuilder.length();
      return "]";
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/TbsCoreLoadStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */