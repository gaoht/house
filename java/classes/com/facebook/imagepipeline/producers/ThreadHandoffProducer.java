package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;

public class ThreadHandoffProducer<T>
  implements Producer<T>
{
  public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
  private final Producer<T> mInputProducer;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
  
  public ThreadHandoffProducer(Producer<T> paramProducer, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue)
  {
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
  }
  
  public void produceResults(final Consumer<T> paramConsumer, final ProducerContext paramProducerContext)
  {
    final ProducerListener localProducerListener = paramProducerContext.getListener();
    final String str = paramProducerContext.getId();
    paramConsumer = new StatefulProducerRunnable(paramConsumer, localProducerListener, "BackgroundThreadHandoffProducer", str)
    {
      protected void disposeResult(T paramAnonymousT) {}
      
      protected T getResult()
        throws Exception
      {
        return null;
      }
      
      protected void onSuccess(T paramAnonymousT)
      {
        localProducerListener.onProducerFinishWithSuccess(str, "BackgroundThreadHandoffProducer", null);
        ThreadHandoffProducer.this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        paramConsumer.cancel();
        ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(paramConsumer);
      }
    });
    this.mThreadHandoffProducerQueue.addToQueueOrExecute(paramConsumer);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/ThreadHandoffProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */