package com.facebook.imagepipeline.producers;

public abstract interface Producer<T>
{
  public abstract void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/Producer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */