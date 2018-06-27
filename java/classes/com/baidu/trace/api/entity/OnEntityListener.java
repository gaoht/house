package com.baidu.trace.api.entity;

import com.baidu.trace.model.TraceLocation;

public abstract class OnEntityListener
{
  public void onAddEntityCallback(AddEntityResponse paramAddEntityResponse) {}
  
  public void onAroundSearchCallback(AroundSearchResponse paramAroundSearchResponse) {}
  
  public void onBoundSearchCallback(BoundSearchResponse paramBoundSearchResponse) {}
  
  public void onDeleteEntityCallback(DeleteEntityResponse paramDeleteEntityResponse) {}
  
  public void onDistrictSearchCallback(DistrictSearchResponse paramDistrictSearchResponse) {}
  
  public void onEntityListCallback(EntityListResponse paramEntityListResponse) {}
  
  public void onPolygonSearchCallback(PolygonSearchResponse paramPolygonSearchResponse) {}
  
  public void onReceiveLocation(TraceLocation paramTraceLocation) {}
  
  public void onSearchEntityCallback(SearchResponse paramSearchResponse) {}
  
  public void onUpdateEntityCallback(UpdateEntityResponse paramUpdateEntityResponse) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/api/entity/OnEntityListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */