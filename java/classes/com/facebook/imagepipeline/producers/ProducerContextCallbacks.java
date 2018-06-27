package com.facebook.imagepipeline.producers;

public abstract interface ProducerContextCallbacks
{
  public abstract void onCancellationRequested();
  
  public abstract void onIsIntermediateResultExpectedChanged();
  
  public abstract void onIsPrefetchChanged();
  
  public abstract void onPriorityChanged();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/imagepipeline/producers/ProducerContextCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */