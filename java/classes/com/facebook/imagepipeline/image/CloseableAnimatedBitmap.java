package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CloseableAnimatedBitmap
  extends CloseableBitmap
{
  @GuardedBy("this")
  private List<CloseableReference<Bitmap>> mBitmapReferences;
  private volatile List<Bitmap> mBitmaps;
  private volatile List<Integer> mDurations;
  
  public CloseableAnimatedBitmap(List<CloseableReference<Bitmap>> paramList, List<Integer> paramList1)
  {
    Preconditions.checkNotNull(paramList);
    if (paramList.size() >= 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Preconditions.checkState(bool1, "Need at least 1 frame!");
      this.mBitmapReferences = new ArrayList(paramList.size());
      this.mBitmaps = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CloseableReference localCloseableReference = (CloseableReference)paramList.next();
        this.mBitmapReferences.add(localCloseableReference.clone());
        this.mBitmaps.add(localCloseableReference.get());
      }
    }
    this.mDurations = ((List)Preconditions.checkNotNull(paramList1));
    if (this.mDurations.size() == this.mBitmaps.size()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1, "Arrays length mismatch!");
      return;
    }
  }
  
  public CloseableAnimatedBitmap(List<Bitmap> paramList, List<Integer> paramList1, ResourceReleaser<Bitmap> paramResourceReleaser)
  {
    Preconditions.checkNotNull(paramList);
    if (paramList.size() >= 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Preconditions.checkState(bool1, "Need at least 1 frame!");
      this.mBitmaps = new ArrayList(paramList.size());
      this.mBitmapReferences = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Bitmap localBitmap = (Bitmap)paramList.next();
        this.mBitmapReferences.add(CloseableReference.of(localBitmap, paramResourceReleaser));
        this.mBitmaps.add(localBitmap);
      }
    }
    this.mDurations = ((List)Preconditions.checkNotNull(paramList1));
    if (this.mDurations.size() == this.mBitmaps.size()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkState(bool1, "Arrays length mismatch!");
      return;
    }
  }
  
  public void close()
  {
    try
    {
      if (this.mBitmapReferences == null) {
        return;
      }
      List localList = this.mBitmapReferences;
      this.mBitmapReferences = null;
      this.mBitmaps = null;
      this.mDurations = null;
      CloseableReference.closeSafely(localList);
      return;
    }
    finally {}
  }
  
  public List<Bitmap> getBitmaps()
  {
    return this.mBitmaps;
  }
  
  public List<Integer> getDurations()
  {
    return this.mDurations;
  }
  
  public int getHeight()
  {
    List localList = this.mBitmaps;
    if (localList == null) {
      return 0;
    }
    return ((Bitmap)localList.get(0)).getHeight();
  }
  
  public int getSizeInBytes()
  {
    List localList = this.mBitmaps;
    if ((localList == null) || (localList.size() == 0)) {
      return 0;
    }
    return BitmapUtil.getSizeInBytes((Bitmap)localList.get(0)) * localList.size();
  }
  
  public Bitmap getUnderlyingBitmap()
  {
    List localList = this.mBitmaps;
    if (localList != null) {
      return (Bitmap)localList.get(0);
    }
    return null;
  }
  
  public int getWidth()
  {
    List localList = this.mBitmaps;
    if (localList == null) {
      return 0;
    }
    return ((Bitmap)localList.get(0)).getWidth();
  }
  
  /* Error */
  public boolean isClosed()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/facebook/imagepipeline/image/CloseableAnimatedBitmap:mBitmaps	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	CloseableAnimatedBitmap
    //   12	7	1	bool	boolean
    //   6	2	2	localList	List
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/image/CloseableAnimatedBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */