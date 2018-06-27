package com.facebook.cache.disk;

import com.facebook.common.internal.VisibleForTesting;

public class ScoreBasedEvictionComparatorSupplier
  implements EntryEvictionComparatorSupplier
{
  private final float mAgeWeight;
  private final float mSizeWeight;
  
  public ScoreBasedEvictionComparatorSupplier(float paramFloat1, float paramFloat2)
  {
    this.mAgeWeight = paramFloat1;
    this.mSizeWeight = paramFloat2;
  }
  
  @VisibleForTesting
  float calculateScore(DiskStorage.Entry paramEntry, long paramLong)
  {
    long l1 = paramEntry.getTimestamp();
    long l2 = paramEntry.getSize();
    float f = this.mAgeWeight;
    return (float)(paramLong - l1) * f + this.mSizeWeight * (float)l2;
  }
  
  public EntryEvictionComparator get()
  {
    new EntryEvictionComparator()
    {
      long now = System.currentTimeMillis();
      
      public int compare(DiskStorage.Entry paramAnonymousEntry1, DiskStorage.Entry paramAnonymousEntry2)
      {
        float f1 = ScoreBasedEvictionComparatorSupplier.this.calculateScore(paramAnonymousEntry1, this.now);
        float f2 = ScoreBasedEvictionComparatorSupplier.this.calculateScore(paramAnonymousEntry2, this.now);
        if (f1 < f2) {
          return 1;
        }
        if (f2 == f1) {
          return 0;
        }
        return -1;
      }
    };
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/cache/disk/ScoreBasedEvictionComparatorSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */