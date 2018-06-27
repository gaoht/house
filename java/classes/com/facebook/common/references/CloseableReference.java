package com.facebook.common.references;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public abstract class CloseableReference<T>
  implements Closeable, Cloneable
{
  private static final ResourceReleaser<Closeable> DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser()
  {
    public void release(Closeable paramAnonymousCloseable)
    {
      try
      {
        Closeables.close(paramAnonymousCloseable, true);
        return;
      }
      catch (IOException paramAnonymousCloseable) {}
    }
  };
  private static Class<CloseableReference> TAG = CloseableReference.class;
  @Nullable
  private static volatile UnclosedReferenceListener sUnclosedReferenceListener;
  private static volatile boolean sUseFinalizers = true;
  @GuardedBy("this")
  protected boolean mIsClosed = false;
  @Nullable
  protected Throwable mRelevantTrace;
  protected final SharedReference<T> mSharedReference;
  
  private CloseableReference(SharedReference<T> paramSharedReference)
  {
    this.mSharedReference = ((SharedReference)Preconditions.checkNotNull(paramSharedReference));
    paramSharedReference.addReference();
    this.mRelevantTrace = getTraceOrNull();
  }
  
  private CloseableReference(T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    this.mSharedReference = new SharedReference(paramT, paramResourceReleaser);
    this.mRelevantTrace = getTraceOrNull();
  }
  
  @Nullable
  public static <T> CloseableReference<T> cloneOrNull(@Nullable CloseableReference<T> paramCloseableReference)
  {
    if (paramCloseableReference != null) {
      return paramCloseableReference.cloneOrNull();
    }
    return null;
  }
  
  public static <T> List<CloseableReference<T>> cloneOrNull(Collection<CloseableReference<T>> paramCollection)
  {
    if (paramCollection == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(cloneOrNull((CloseableReference)paramCollection.next()));
    }
    return localArrayList;
  }
  
  public static void closeSafely(@Nullable CloseableReference<?> paramCloseableReference)
  {
    if (paramCloseableReference != null) {
      paramCloseableReference.close();
    }
  }
  
  public static void closeSafely(@Nullable Iterable<? extends CloseableReference<?>> paramIterable)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        closeSafely((CloseableReference)paramIterable.next());
      }
    }
  }
  
  @Nullable
  private static Throwable getTraceOrNull()
  {
    if (sUnclosedReferenceListener != null) {
      return new Throwable();
    }
    return null;
  }
  
  public static boolean isUnclosedTrackingEnabled()
  {
    return sUnclosedReferenceListener != null;
  }
  
  public static boolean isValid(@Nullable CloseableReference<?> paramCloseableReference)
  {
    return (paramCloseableReference != null) && (paramCloseableReference.isValid());
  }
  
  private CloseableReference<T> makeCloseableReference()
  {
    if (sUseFinalizers) {
      return new CloseableReferenceWithFinalizer(this.mSharedReference, null);
    }
    return new CloseableReferenceWithoutFinalizer(this.mSharedReference, null);
  }
  
  private static <T> CloseableReference<T> makeCloseableReference(@Nullable T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    if (sUseFinalizers) {
      return new CloseableReferenceWithFinalizer(paramT, paramResourceReleaser, null);
    }
    return new CloseableReferenceWithoutFinalizer(paramT, paramResourceReleaser, null);
  }
  
  @Nullable
  public static <T extends Closeable> CloseableReference<T> of(@Nullable T paramT)
  {
    if (paramT == null) {
      return null;
    }
    return makeCloseableReference(paramT, DEFAULT_CLOSEABLE_RELEASER);
  }
  
  @Nullable
  public static <T> CloseableReference<T> of(@Nullable T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    if (paramT == null) {
      return null;
    }
    return makeCloseableReference(paramT, paramResourceReleaser);
  }
  
  public static void setUnclosedReferenceListener(UnclosedReferenceListener paramUnclosedReferenceListener)
  {
    sUnclosedReferenceListener = paramUnclosedReferenceListener;
  }
  
  public static void setUseFinalizers(boolean paramBoolean)
  {
    sUseFinalizers = paramBoolean;
  }
  
  public CloseableReference<T> clone()
  {
    try
    {
      this.mRelevantTrace = getTraceOrNull();
      Preconditions.checkState(isValid());
      CloseableReference localCloseableReference = makeCloseableReference();
      return localCloseableReference;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public CloseableReference<T> cloneOrNull()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 78	com/facebook/common/references/CloseableReference:getTraceOrNull	()Ljava/lang/Throwable;
    //   6: putfield 80	com/facebook/common/references/CloseableReference:mRelevantTrace	Ljava/lang/Throwable;
    //   9: aload_0
    //   10: invokevirtual 161	com/facebook/common/references/CloseableReference:isValid	()Z
    //   13: ifeq +12 -> 25
    //   16: aload_0
    //   17: invokespecial 187	com/facebook/common/references/CloseableReference:makeCloseableReference	()Lcom/facebook/common/references/CloseableReference;
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aconst_null
    //   26: astore_1
    //   27: goto -6 -> 21
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	CloseableReference
    //   20	7	1	localCloseableReference	CloseableReference
    //   30	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  public void close()
  {
    try
    {
      if (this.mIsClosed) {
        return;
      }
      this.mIsClosed = true;
      this.mSharedReference.deleteReference();
      return;
    }
    finally {}
  }
  
  /* Error */
  public T get()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/facebook/common/references/CloseableReference:mIsClosed	Z
    //   6: ifne +21 -> 27
    //   9: iconst_1
    //   10: istore_1
    //   11: iload_1
    //   12: invokestatic 185	com/facebook/common/internal/Preconditions:checkState	(Z)V
    //   15: aload_0
    //   16: getfield 71	com/facebook/common/references/CloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   19: invokevirtual 198	com/facebook/common/references/SharedReference:get	()Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: areturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -18 -> 11
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	CloseableReference
    //   10	19	1	bool	boolean
    //   22	4	2	localObject1	Object
    //   32	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	32	finally
    //   11	23	32	finally
  }
  
  @VisibleForTesting
  public SharedReference<T> getUnderlyingReferenceTestOnly()
  {
    try
    {
      SharedReference localSharedReference = this.mSharedReference;
      return localSharedReference;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int getValueHash()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 161	com/facebook/common/references/CloseableReference:isValid	()Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 71	com/facebook/common/references/CloseableReference:mSharedReference	Lcom/facebook/common/references/SharedReference;
    //   13: invokevirtual 198	com/facebook/common/references/SharedReference:get	()Ljava/lang/Object;
    //   16: invokestatic 211	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_1
    //   26: goto -6 -> 20
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	CloseableReference
    //   19	7	1	i	int
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	29	finally
  }
  
  /* Error */
  public boolean isValid()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/facebook/common/references/CloseableReference:mIsClosed	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
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
    //   0	27	0	this	CloseableReference
    //   6	13	1	bool	boolean
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public void setUnclosedRelevantTrance(Throwable paramThrowable)
  {
    this.mRelevantTrace = paramThrowable;
  }
  
  private static class CloseableReferenceWithFinalizer<T>
    extends CloseableReference<T>
  {
    private CloseableReferenceWithFinalizer(SharedReference<T> paramSharedReference)
    {
      super(null);
    }
    
    private CloseableReferenceWithFinalizer(T paramT, ResourceReleaser<T> paramResourceReleaser)
    {
      super(paramResourceReleaser, null);
    }
    
    protected void finalize()
      throws Throwable
    {
      for (;;)
      {
        try
        {
          try
          {
            if (this.mIsClosed) {
              return;
            }
            CloseableReference.UnclosedReferenceListener localUnclosedReferenceListener = CloseableReference.sUnclosedReferenceListener;
            if (localUnclosedReferenceListener != null)
            {
              localUnclosedReferenceListener.onUnclosedReferenceFinalized(this, this.mRelevantTrace);
              close();
              return;
            }
          }
          finally {}
        }
        finally
        {
          super.finalize();
        }
        tmp67_64[0] = Integer.valueOf(System.identityHashCode(this));
        Object[] tmp77_67 = tmp67_64;
        tmp77_67[1] = Integer.valueOf(System.identityHashCode(this.mSharedReference));
        Object[] tmp90_77 = tmp77_67;
        tmp90_77[2] = this.mSharedReference.get().getClass().getSimpleName();
        FLog.w(CloseableReference.TAG, "Finalized without closing: %x %x (type = %s)", tmp90_77);
      }
    }
  }
  
  private static class CloseableReferenceWithoutFinalizer<T>
    extends CloseableReference<T>
  {
    private static final ReferenceQueue<CloseableReference> REF_QUEUE = new ReferenceQueue();
    private final Destructor mDestructor = new Destructor(this, REF_QUEUE);
    
    static
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            for (;;)
            {
              ((CloseableReference.CloseableReferenceWithoutFinalizer.Destructor)CloseableReference.CloseableReferenceWithoutFinalizer.REF_QUEUE.remove()).destroy(false);
            }
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }, "CloseableReferenceDestructorThread").start();
    }
    
    private CloseableReferenceWithoutFinalizer(SharedReference<T> paramSharedReference)
    {
      super(null);
    }
    
    private CloseableReferenceWithoutFinalizer(T paramT, ResourceReleaser<T> paramResourceReleaser)
    {
      super(paramResourceReleaser, null);
    }
    
    public void close()
    {
      this.mDestructor.destroy(true);
    }
    
    private static class Destructor
      extends PhantomReference<CloseableReference>
    {
      @GuardedBy("Destructor.class")
      private static Destructor sHead;
      @GuardedBy("this")
      private boolean closed;
      private final SharedReference mSharedReference;
      @GuardedBy("Destructor.class")
      private Destructor next;
      @GuardedBy("Destructor.class")
      private Destructor previous;
      
      public Destructor(CloseableReference paramCloseableReference, ReferenceQueue<? super CloseableReference> paramReferenceQueue)
      {
        super(paramReferenceQueue);
        this.mSharedReference = paramCloseableReference.mSharedReference;
        if (sHead != null)
        {
          sHead.next = this;
          this.previous = sHead;
        }
        sHead = this;
      }
      
      /* Error */
      public void destroy(boolean paramBoolean)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 44	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:closed	Z
        //   6: ifeq +6 -> 12
        //   9: aload_0
        //   10: monitorexit
        //   11: return
        //   12: aload_0
        //   13: iconst_1
        //   14: putfield 44	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:closed	Z
        //   17: aload_0
        //   18: monitorexit
        //   19: ldc 2
        //   21: monitorenter
        //   22: aload_0
        //   23: getfield 37	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:previous	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   26: ifnull +14 -> 40
        //   29: aload_0
        //   30: getfield 37	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:previous	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   33: aload_0
        //   34: getfield 35	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:next	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   37: putfield 35	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:next	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   40: aload_0
        //   41: getfield 35	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:next	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   44: ifnull +85 -> 129
        //   47: aload_0
        //   48: getfield 35	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:next	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   51: aload_0
        //   52: getfield 37	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:previous	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   55: putfield 37	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:previous	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   58: ldc 2
        //   60: monitorexit
        //   61: iload_1
        //   62: ifne +54 -> 116
        //   65: invokestatic 48	com/facebook/common/references/CloseableReference:access$400	()Ljava/lang/Class;
        //   68: ldc 50
        //   70: iconst_3
        //   71: anewarray 52	java/lang/Object
        //   74: dup
        //   75: iconst_0
        //   76: aload_0
        //   77: invokestatic 58	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
        //   80: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   83: aastore
        //   84: dup
        //   85: iconst_1
        //   86: aload_0
        //   87: getfield 31	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:mSharedReference	Lcom/facebook/common/references/SharedReference;
        //   90: invokestatic 58	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
        //   93: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   96: aastore
        //   97: dup
        //   98: iconst_2
        //   99: aload_0
        //   100: getfield 31	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:mSharedReference	Lcom/facebook/common/references/SharedReference;
        //   103: invokevirtual 70	com/facebook/common/references/SharedReference:get	()Ljava/lang/Object;
        //   106: invokevirtual 73	java/lang/Object:getClass	()Ljava/lang/Class;
        //   109: invokevirtual 79	java/lang/Class:getSimpleName	()Ljava/lang/String;
        //   112: aastore
        //   113: invokestatic 85	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
        //   116: aload_0
        //   117: getfield 31	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:mSharedReference	Lcom/facebook/common/references/SharedReference;
        //   120: invokevirtual 89	com/facebook/common/references/SharedReference:deleteReference	()V
        //   123: return
        //   124: astore_2
        //   125: aload_0
        //   126: monitorexit
        //   127: aload_2
        //   128: athrow
        //   129: aload_0
        //   130: getfield 37	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:previous	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   133: putstatic 33	com/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor:sHead	Lcom/facebook/common/references/CloseableReference$CloseableReferenceWithoutFinalizer$Destructor;
        //   136: goto -78 -> 58
        //   139: astore_2
        //   140: ldc 2
        //   142: monitorexit
        //   143: aload_2
        //   144: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	145	0	this	Destructor
        //   0	145	1	paramBoolean	boolean
        //   124	4	2	localObject1	Object
        //   139	5	2	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   2	11	124	finally
        //   12	19	124	finally
        //   125	127	124	finally
        //   22	40	139	finally
        //   40	58	139	finally
        //   58	61	139	finally
        //   129	136	139	finally
        //   140	143	139	finally
      }
    }
  }
  
  public static abstract interface UnclosedReferenceListener
  {
    public abstract void onUnclosedReferenceFinalized(CloseableReference<?> paramCloseableReference, Throwable paramThrowable);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/references/CloseableReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */