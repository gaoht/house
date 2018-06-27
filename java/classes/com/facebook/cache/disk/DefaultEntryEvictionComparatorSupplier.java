package com.facebook.cache.disk;

public class DefaultEntryEvictionComparatorSupplier
  implements EntryEvictionComparatorSupplier
{
  public EntryEvictionComparator get()
  {
    new EntryEvictionComparator()
    {
      public int compare(DiskStorage.Entry paramAnonymousEntry1, DiskStorage.Entry paramAnonymousEntry2)
      {
        long l1 = paramAnonymousEntry1.getTimestamp();
        long l2 = paramAnonymousEntry2.getTimestamp();
        if (l1 < l2) {
          return -1;
        }
        if (l2 == l1) {
          return 0;
        }
        return 1;
      }
    };
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/cache/disk/DefaultEntryEvictionComparatorSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */