package com.baidu.trace.api.track;

public abstract class OnTrackListener
{
  public void onAddPointCallback(AddPointResponse paramAddPointResponse) {}
  
  public void onAddPointsCallback(AddPointsResponse paramAddPointsResponse) {}
  
  public void onClearCacheTrackCallback(ClearCacheTrackResponse paramClearCacheTrackResponse) {}
  
  public void onDistanceCallback(DistanceResponse paramDistanceResponse) {}
  
  public void onHistoryTrackCallback(HistoryTrackResponse paramHistoryTrackResponse) {}
  
  public void onLatestPointCallback(LatestPointResponse paramLatestPointResponse) {}
  
  public void onQueryCacheTrackCallback(QueryCacheTrackResponse paramQueryCacheTrackResponse) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/track/OnTrackListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */