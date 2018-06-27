package com.baidu.trace.api.track;

import com.baidu.trace.model.BaseRequest;
import com.baidu.trace.model.CoordType;
import com.baidu.trace.model.ProcessOption;
import com.baidu.trace.model.SortType;

public final class HistoryTrackRequest
  extends BaseRequest
{
  private String a;
  private long b;
  private long c;
  private boolean d = false;
  private ProcessOption e;
  private SupplementMode f = SupplementMode.no_supplement;
  private SortType g = SortType.asc;
  private CoordType h = CoordType.bd09ll;
  private int i;
  private int j;
  
  public HistoryTrackRequest() {}
  
  public HistoryTrackRequest(int paramInt, long paramLong)
  {
    super(paramInt, paramLong);
  }
  
  public HistoryTrackRequest(int paramInt, long paramLong, String paramString)
  {
    this(paramInt, paramLong);
    this.a = paramString;
  }
  
  public HistoryTrackRequest(int paramInt1, long paramLong1, String paramString, long paramLong2, long paramLong3, boolean paramBoolean, ProcessOption paramProcessOption, SupplementMode paramSupplementMode, SortType paramSortType, CoordType paramCoordType, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramLong1, paramString);
    this.b = paramLong2;
    this.c = paramLong3;
    this.e = paramProcessOption;
    this.i = paramInt2;
    this.j = paramInt3;
  }
  
  public final CoordType getCoordTypeOutput()
  {
    return this.h;
  }
  
  public final long getEndTime()
  {
    return this.c;
  }
  
  public final String getEntityName()
  {
    return this.a;
  }
  
  public final int getPageIndex()
  {
    return this.i;
  }
  
  public final int getPageSize()
  {
    return this.j;
  }
  
  public final ProcessOption getProcessOption()
  {
    return this.e;
  }
  
  public final SortType getSortType()
  {
    return this.g;
  }
  
  public final long getStartTime()
  {
    return this.b;
  }
  
  public final SupplementMode getSupplementMode()
  {
    return this.f;
  }
  
  public final boolean isProcessed()
  {
    return this.d;
  }
  
  public final void setCoordTypeOutput(CoordType paramCoordType)
  {
    this.h = paramCoordType;
  }
  
  public final void setEndTime(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final void setEntityName(String paramString)
  {
    this.a = paramString;
  }
  
  public final void setPageIndex(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void setPageSize(int paramInt)
  {
    this.j = paramInt;
  }
  
  public final void setProcessOption(ProcessOption paramProcessOption)
  {
    this.e = paramProcessOption;
  }
  
  public final void setProcessed(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void setSortType(SortType paramSortType)
  {
    this.g = paramSortType;
  }
  
  public final void setStartTime(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void setSupplementMode(SupplementMode paramSupplementMode)
  {
    this.f = paramSupplementMode;
  }
  
  public final String toString()
  {
    return "HistoryTrackRequest [tag=" + this.tag + ", serviceId=" + this.serviceId + ", entityName=" + this.a + ", startTime=" + this.b + ", endTime=" + this.c + ", isProcessed=" + this.d + ", processOption=" + this.e + ", supplementMode=" + this.f + ", sortType=" + this.g + ", coordTypeOutput=" + this.h + ", pageIndex=" + this.i + ", pageSize=" + this.j + "]";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/HistoryTrackRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */