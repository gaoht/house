package com.baidu.mapapi.search.poi;

public abstract interface OnGetPoiSearchResultListener
{
  public abstract void onGetPoiDetailResult(PoiDetailResult paramPoiDetailResult);
  
  public abstract void onGetPoiIndoorResult(PoiIndoorResult paramPoiIndoorResult);
  
  public abstract void onGetPoiResult(PoiResult paramPoiResult);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/search/poi/OnGetPoiSearchResultListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */