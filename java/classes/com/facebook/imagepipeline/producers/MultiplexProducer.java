package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.Priority;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class MultiplexProducer<K, T extends Closeable>
  implements Producer<T>
{
  private final Producer<T> mInputProducer;
  @VisibleForTesting
  @GuardedBy("this")
  final Map<K, MultiplexProducer<K, T>.Multiplexer> mMultiplexers;
  
  protected MultiplexProducer(Producer<T> paramProducer)
  {
    this.mInputProducer = paramProducer;
    this.mMultiplexers = new HashMap();
  }
  
  private MultiplexProducer<K, T>.Multiplexer createAndPutNewMultiplexer(K paramK)
  {
    try
    {
      Multiplexer localMultiplexer = new Multiplexer(paramK);
      this.mMultiplexers.put(paramK, localMultiplexer);
      return localMultiplexer;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  private MultiplexProducer<K, T>.Multiplexer getExistingMultiplexer(K paramK)
  {
    try
    {
      paramK = (Multiplexer)this.mMultiplexers.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  private void removeMultiplexer(K paramK, MultiplexProducer<K, T>.Multiplexer paramMultiplexProducer)
  {
    try
    {
      if (this.mMultiplexers.get(paramK) == paramMultiplexProducer) {
        this.mMultiplexers.remove(paramK);
      }
      return;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  protected abstract T cloneOrNull(T paramT);
  
  protected abstract K getKey(ProducerContext paramProducerContext);
  
  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    Object localObject = getKey(paramProducerContext);
    for (;;)
    {
      int i = 0;
      try
      {
        Multiplexer localMultiplexer2 = getExistingMultiplexer(localObject);
        Multiplexer localMultiplexer1 = localMultiplexer2;
        if (localMultiplexer2 == null)
        {
          localMultiplexer1 = createAndPutNewMultiplexer(localObject);
          i = 1;
        }
        if (!localMultiplexer1.addNewConsumer(paramConsumer, paramProducerContext)) {
          continue;
        }
        if (i != 0) {
          localMultiplexer1.startInputProducerIfHasAttachedConsumers();
        }
        return;
      }
      finally {}
    }
  }
  
  @VisibleForTesting
  class Multiplexer
  {
    private final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> mConsumerContextPairs = Sets.newCopyOnWriteArraySet();
    @Nullable
    @GuardedBy("Multiplexer.this")
    private MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer mForwardingConsumer;
    private final K mKey;
    @Nullable
    @GuardedBy("Multiplexer.this")
    private T mLastIntermediateResult;
    @GuardedBy("Multiplexer.this")
    private float mLastProgress;
    @Nullable
    @GuardedBy("Multiplexer.this")
    private BaseProducerContext mMultiplexProducerContext;
    
    public Multiplexer()
    {
      Object localObject;
      this.mKey = localObject;
    }
    
    private void addCallbacks(final Pair<Consumer<T>, ProducerContext> paramPair, ProducerContext paramProducerContext)
    {
      paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          List localList3 = null;
          for (;;)
          {
            synchronized (MultiplexProducer.Multiplexer.this)
            {
              boolean bool = MultiplexProducer.Multiplexer.this.mConsumerContextPairs.remove(paramPair);
              if (bool)
              {
                if (MultiplexProducer.Multiplexer.this.mConsumerContextPairs.isEmpty())
                {
                  localBaseProducerContext = MultiplexProducer.Multiplexer.this.mMultiplexProducerContext;
                  localList2 = null;
                  localList1 = null;
                  BaseProducerContext.callOnIsPrefetchChanged(localList2);
                  BaseProducerContext.callOnPriorityChanged(localList1);
                  BaseProducerContext.callOnIsIntermediateResultExpectedChanged(localList3);
                  if (localBaseProducerContext != null) {
                    localBaseProducerContext.cancel();
                  }
                  if (bool) {
                    ((Consumer)paramPair.first).onCancellation();
                  }
                  return;
                }
                localList2 = MultiplexProducer.Multiplexer.this.updateIsPrefetch();
                List localList1 = MultiplexProducer.Multiplexer.this.updatePriority();
                localList3 = MultiplexProducer.Multiplexer.this.updateIsIntermediateResultExpected();
                localBaseProducerContext = null;
              }
            }
            Object localObject2 = null;
            List localList2 = null;
            BaseProducerContext localBaseProducerContext = null;
          }
        }
        
        public void onIsIntermediateResultExpectedChanged()
        {
          BaseProducerContext.callOnIsIntermediateResultExpectedChanged(MultiplexProducer.Multiplexer.this.updateIsIntermediateResultExpected());
        }
        
        public void onIsPrefetchChanged()
        {
          BaseProducerContext.callOnIsPrefetchChanged(MultiplexProducer.Multiplexer.this.updateIsPrefetch());
        }
        
        public void onPriorityChanged()
        {
          BaseProducerContext.callOnPriorityChanged(MultiplexProducer.Multiplexer.this.updatePriority());
        }
      });
    }
    
    private void closeSafely(Closeable paramCloseable)
    {
      if (paramCloseable != null) {}
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        throw new RuntimeException(paramCloseable);
      }
    }
    
    /* Error */
    private boolean computeIsIntermediateResultExpected()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 50	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mConsumerContextPairs	Ljava/util/concurrent/CopyOnWriteArraySet;
      //   6: invokevirtual 113	java/util/concurrent/CopyOnWriteArraySet:iterator	()Ljava/util/Iterator;
      //   9: astore_2
      //   10: aload_2
      //   11: invokeinterface 118 1 0
      //   16: ifeq +34 -> 50
      //   19: aload_2
      //   20: invokeinterface 122 1 0
      //   25: checkcast 124	android/util/Pair
      //   28: getfield 127	android/util/Pair:second	Ljava/lang/Object;
      //   31: checkcast 87	com/facebook/imagepipeline/producers/ProducerContext
      //   34: invokeinterface 130 1 0
      //   39: istore_1
      //   40: iload_1
      //   41: ifeq -31 -> 10
      //   44: iconst_1
      //   45: istore_1
      //   46: aload_0
      //   47: monitorexit
      //   48: iload_1
      //   49: ireturn
      //   50: iconst_0
      //   51: istore_1
      //   52: goto -6 -> 46
      //   55: astore_2
      //   56: aload_0
      //   57: monitorexit
      //   58: aload_2
      //   59: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	Multiplexer
      //   39	13	1	bool	boolean
      //   9	11	2	localIterator	Iterator
      //   55	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	10	55	finally
      //   10	40	55	finally
    }
    
    /* Error */
    private boolean computeIsPrefetch()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 50	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mConsumerContextPairs	Ljava/util/concurrent/CopyOnWriteArraySet;
      //   6: invokevirtual 113	java/util/concurrent/CopyOnWriteArraySet:iterator	()Ljava/util/Iterator;
      //   9: astore_2
      //   10: aload_2
      //   11: invokeinterface 118 1 0
      //   16: ifeq +34 -> 50
      //   19: aload_2
      //   20: invokeinterface 122 1 0
      //   25: checkcast 124	android/util/Pair
      //   28: getfield 127	android/util/Pair:second	Ljava/lang/Object;
      //   31: checkcast 87	com/facebook/imagepipeline/producers/ProducerContext
      //   34: invokeinterface 134 1 0
      //   39: istore_1
      //   40: iload_1
      //   41: ifne -31 -> 10
      //   44: iconst_0
      //   45: istore_1
      //   46: aload_0
      //   47: monitorexit
      //   48: iload_1
      //   49: ireturn
      //   50: iconst_1
      //   51: istore_1
      //   52: goto -6 -> 46
      //   55: astore_2
      //   56: aload_0
      //   57: monitorexit
      //   58: aload_2
      //   59: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	Multiplexer
      //   39	13	1	bool	boolean
      //   9	11	2	localIterator	Iterator
      //   55	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	10	55	finally
      //   10	40	55	finally
    }
    
    private Priority computePriority()
    {
      try
      {
        Priority localPriority = Priority.LOW;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        while (localIterator.hasNext()) {
          localPriority = Priority.getHigherPriority(localPriority, ((ProducerContext)((Pair)localIterator.next()).second).getPriority());
        }
        return localPriority;
      }
      finally {}
    }
    
    private void startInputProducerIfHasAttachedConsumers()
    {
      boolean bool2 = true;
      for (;;)
      {
        try
        {
          if (this.mMultiplexProducerContext == null)
          {
            bool1 = true;
            Preconditions.checkArgument(bool1);
            if (this.mForwardingConsumer != null) {
              break label182;
            }
            bool1 = bool2;
            Preconditions.checkArgument(bool1);
            if (this.mConsumerContextPairs.isEmpty())
            {
              MultiplexProducer.this.removeMultiplexer(this.mKey, this);
              return;
            }
            Object localObject1 = (ProducerContext)((Pair)this.mConsumerContextPairs.iterator().next()).second;
            this.mMultiplexProducerContext = new BaseProducerContext(((ProducerContext)localObject1).getImageRequest(), ((ProducerContext)localObject1).getId(), ((ProducerContext)localObject1).getListener(), ((ProducerContext)localObject1).getCallerContext(), ((ProducerContext)localObject1).getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority());
            this.mForwardingConsumer = new ForwardingConsumer(null);
            localObject1 = this.mMultiplexProducerContext;
            ForwardingConsumer localForwardingConsumer = this.mForwardingConsumer;
            MultiplexProducer.this.mInputProducer.produceResults(localForwardingConsumer, (ProducerContext)localObject1);
            return;
          }
        }
        finally {}
        boolean bool1 = false;
        continue;
        label182:
        bool1 = false;
      }
    }
    
    /* Error */
    @Nullable
    private List<ProducerContextCallbacks> updateIsIntermediateResultExpected()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 66	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mMultiplexProducerContext	Lcom/facebook/imagepipeline/producers/BaseProducerContext;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull +9 -> 17
      //   11: aconst_null
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: areturn
      //   17: aload_0
      //   18: getfield 66	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mMultiplexProducerContext	Lcom/facebook/imagepipeline/producers/BaseProducerContext;
      //   21: aload_0
      //   22: invokespecial 189	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:computeIsIntermediateResultExpected	()Z
      //   25: invokevirtual 211	com/facebook/imagepipeline/producers/BaseProducerContext:setIsIntermediateResultExpectedNoCallbacks	(Z)Ljava/util/List;
      //   28: astore_1
      //   29: goto -16 -> 13
      //   32: astore_1
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_1
      //   36: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	37	0	this	Multiplexer
      //   6	23	1	localObject1	Object
      //   32	4	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	32	finally
      //   17	29	32	finally
    }
    
    /* Error */
    @Nullable
    private List<ProducerContextCallbacks> updateIsPrefetch()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 66	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mMultiplexProducerContext	Lcom/facebook/imagepipeline/producers/BaseProducerContext;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull +9 -> 17
      //   11: aconst_null
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: areturn
      //   17: aload_0
      //   18: getfield 66	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mMultiplexProducerContext	Lcom/facebook/imagepipeline/producers/BaseProducerContext;
      //   21: aload_0
      //   22: invokespecial 187	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:computeIsPrefetch	()Z
      //   25: invokevirtual 216	com/facebook/imagepipeline/producers/BaseProducerContext:setIsPrefetchNoCallbacks	(Z)Ljava/util/List;
      //   28: astore_1
      //   29: goto -16 -> 13
      //   32: astore_1
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_1
      //   36: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	37	0	this	Multiplexer
      //   6	23	1	localObject1	Object
      //   32	4	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	32	finally
      //   17	29	32	finally
    }
    
    /* Error */
    @Nullable
    private List<ProducerContextCallbacks> updatePriority()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 66	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mMultiplexProducerContext	Lcom/facebook/imagepipeline/producers/BaseProducerContext;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull +9 -> 17
      //   11: aconst_null
      //   12: astore_1
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_1
      //   16: areturn
      //   17: aload_0
      //   18: getfield 66	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mMultiplexProducerContext	Lcom/facebook/imagepipeline/producers/BaseProducerContext;
      //   21: aload_0
      //   22: invokespecial 191	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:computePriority	()Lcom/facebook/imagepipeline/common/Priority;
      //   25: invokevirtual 220	com/facebook/imagepipeline/producers/BaseProducerContext:setPriorityNoCallbacks	(Lcom/facebook/imagepipeline/common/Priority;)Ljava/util/List;
      //   28: astore_1
      //   29: goto -16 -> 13
      //   32: astore_1
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_1
      //   36: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	37	0	this	Multiplexer
      //   6	23	1	localObject1	Object
      //   32	4	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	32	finally
      //   17	29	32	finally
    }
    
    /* Error */
    public boolean addNewConsumer(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
    {
      // Byte code:
      //   0: aload_1
      //   1: aload_2
      //   2: invokestatic 226	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
      //   5: astore 6
      //   7: aload_0
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield 39	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:this$0	Lcom/facebook/imagepipeline/producers/MultiplexProducer;
      //   13: aload_0
      //   14: getfield 52	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mKey	Ljava/lang/Object;
      //   17: invokestatic 230	com/facebook/imagepipeline/producers/MultiplexProducer:access$100	(Lcom/facebook/imagepipeline/producers/MultiplexProducer;Ljava/lang/Object;)Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;
      //   20: aload_0
      //   21: if_acmpeq +7 -> 28
      //   24: aload_0
      //   25: monitorexit
      //   26: iconst_0
      //   27: ireturn
      //   28: aload_0
      //   29: getfield 50	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mConsumerContextPairs	Ljava/util/concurrent/CopyOnWriteArraySet;
      //   32: aload 6
      //   34: invokevirtual 234	java/util/concurrent/CopyOnWriteArraySet:add	(Ljava/lang/Object;)Z
      //   37: pop
      //   38: aload_0
      //   39: invokespecial 72	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updateIsPrefetch	()Ljava/util/List;
      //   42: astore 4
      //   44: aload_0
      //   45: invokespecial 76	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updatePriority	()Ljava/util/List;
      //   48: astore 7
      //   50: aload_0
      //   51: invokespecial 80	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updateIsIntermediateResultExpected	()Ljava/util/List;
      //   54: astore 8
      //   56: aload_0
      //   57: getfield 236	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastIntermediateResult	Ljava/io/Closeable;
      //   60: astore 5
      //   62: aload_0
      //   63: getfield 238	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastProgress	F
      //   66: fstore_3
      //   67: aload_0
      //   68: monitorexit
      //   69: aload 4
      //   71: invokestatic 242	com/facebook/imagepipeline/producers/BaseProducerContext:callOnIsPrefetchChanged	(Ljava/util/List;)V
      //   74: aload 7
      //   76: invokestatic 245	com/facebook/imagepipeline/producers/BaseProducerContext:callOnPriorityChanged	(Ljava/util/List;)V
      //   79: aload 8
      //   81: invokestatic 248	com/facebook/imagepipeline/producers/BaseProducerContext:callOnIsIntermediateResultExpectedChanged	(Ljava/util/List;)V
      //   84: aload 6
      //   86: monitorenter
      //   87: aload_0
      //   88: monitorenter
      //   89: aload 5
      //   91: aload_0
      //   92: getfield 236	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastIntermediateResult	Ljava/io/Closeable;
      //   95: if_acmpeq +58 -> 153
      //   98: aconst_null
      //   99: astore 4
      //   101: aload_0
      //   102: monitorexit
      //   103: aload 4
      //   105: ifnull +31 -> 136
      //   108: fload_3
      //   109: fconst_0
      //   110: fcmpl
      //   111: ifle +10 -> 121
      //   114: aload_1
      //   115: fload_3
      //   116: invokeinterface 254 2 0
      //   121: aload_1
      //   122: aload 4
      //   124: iconst_0
      //   125: invokeinterface 258 3 0
      //   130: aload_0
      //   131: aload 4
      //   133: invokespecial 260	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:closeSafely	(Ljava/io/Closeable;)V
      //   136: aload 6
      //   138: monitorexit
      //   139: aload_0
      //   140: aload 6
      //   142: aload_2
      //   143: invokespecial 262	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:addCallbacks	(Landroid/util/Pair;Lcom/facebook/imagepipeline/producers/ProducerContext;)V
      //   146: iconst_1
      //   147: ireturn
      //   148: astore_1
      //   149: aload_0
      //   150: monitorexit
      //   151: aload_1
      //   152: athrow
      //   153: aload 5
      //   155: astore 4
      //   157: aload 5
      //   159: ifnull -58 -> 101
      //   162: aload_0
      //   163: getfield 39	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:this$0	Lcom/facebook/imagepipeline/producers/MultiplexProducer;
      //   166: aload 5
      //   168: invokevirtual 266	com/facebook/imagepipeline/producers/MultiplexProducer:cloneOrNull	(Ljava/io/Closeable;)Ljava/io/Closeable;
      //   171: astore 4
      //   173: goto -72 -> 101
      //   176: astore_1
      //   177: aload_0
      //   178: monitorexit
      //   179: aload_1
      //   180: athrow
      //   181: astore_1
      //   182: aload 6
      //   184: monitorexit
      //   185: aload_1
      //   186: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	187	0	this	Multiplexer
      //   0	187	1	paramConsumer	Consumer<T>
      //   0	187	2	paramProducerContext	ProducerContext
      //   66	50	3	f	float
      //   42	130	4	localObject	Object
      //   60	107	5	localCloseable	Closeable
      //   5	178	6	localPair	Pair
      //   48	27	7	localList1	List
      //   54	26	8	localList2	List
      // Exception table:
      //   from	to	target	type
      //   9	26	148	finally
      //   28	69	148	finally
      //   149	151	148	finally
      //   89	98	176	finally
      //   101	103	176	finally
      //   162	173	176	finally
      //   177	179	176	finally
      //   87	89	181	finally
      //   114	121	181	finally
      //   121	136	181	finally
      //   136	139	181	finally
      //   179	181	181	finally
      //   182	185	181	finally
    }
    
    public void onCancelled(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer paramMultiplexProducer)
    {
      try
      {
        if (this.mForwardingConsumer != paramMultiplexProducer) {
          return;
        }
        this.mForwardingConsumer = null;
        this.mMultiplexProducerContext = null;
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        startInputProducerIfHasAttachedConsumers();
        return;
      }
      finally {}
    }
    
    public void onFailure(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer arg1, Throwable paramThrowable)
    {
      try
      {
        if (this.mForwardingConsumer != ???) {
          return;
        }
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        this.mConsumerContextPairs.clear();
        MultiplexProducer.this.removeMultiplexer(this.mKey, this);
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        while (localIterator.hasNext()) {
          synchronized ((Pair)localIterator.next())
          {
            ((Consumer)???.first).onFailure(paramThrowable);
          }
        }
        return;
      }
      finally {}
    }
    
    public void onNextResult(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer arg1, T paramT, boolean paramBoolean)
    {
      try
      {
        if (this.mForwardingConsumer != ???) {
          return;
        }
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        if (!paramBoolean) {
          this.mLastIntermediateResult = MultiplexProducer.this.cloneOrNull(paramT);
        }
        for (;;)
        {
          while (localIterator.hasNext()) {
            synchronized ((Pair)localIterator.next())
            {
              ((Consumer)???.first).onNewResult(paramT, paramBoolean);
            }
          }
          this.mConsumerContextPairs.clear();
          MultiplexProducer.this.removeMultiplexer(this.mKey, this);
        }
        return;
      }
      finally {}
    }
    
    public void onProgressUpdate(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer arg1, float paramFloat)
    {
      try
      {
        if (this.mForwardingConsumer != ???) {
          return;
        }
        this.mLastProgress = paramFloat;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        while (localIterator.hasNext()) {
          synchronized ((Pair)localIterator.next())
          {
            ((Consumer)???.first).onProgressUpdate(paramFloat);
          }
        }
        return;
      }
      finally {}
    }
    
    private class ForwardingConsumer
      extends BaseConsumer<T>
    {
      private ForwardingConsumer() {}
      
      protected void onCancellationImpl()
      {
        MultiplexProducer.Multiplexer.this.onCancelled(this);
      }
      
      protected void onFailureImpl(Throwable paramThrowable)
      {
        MultiplexProducer.Multiplexer.this.onFailure(this, paramThrowable);
      }
      
      protected void onNewResultImpl(T paramT, boolean paramBoolean)
      {
        MultiplexProducer.Multiplexer.this.onNextResult(this, paramT, paramBoolean);
      }
      
      protected void onProgressUpdateImpl(float paramFloat)
      {
        MultiplexProducer.Multiplexer.this.onProgressUpdate(this, paramFloat);
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/MultiplexProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */