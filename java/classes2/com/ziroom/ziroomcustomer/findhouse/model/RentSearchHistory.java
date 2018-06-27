package com.ziroom.ziroomcustomer.findhouse.model;

import android.text.TextUtils;
import com.ziroom.ziroomcustomer.model.SearchCondition;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RentSearchHistory
  implements Comparable
{
  private Filter filter = new Filter();
  private Location location = new Location();
  private SearchCondition searchCondition;
  private boolean shouldOverWirte = false;
  private long timeStamp;
  private Type type = new Type();
  
  public RentSearchHistory() {}
  
  public RentSearchHistory(SearchCondition paramSearchCondition)
  {
    if (paramSearchCondition == null) {
      return;
    }
    this.type.setType(paramSearchCondition.getType());
    this.type.setTypeSet(paramSearchCondition.getTypeSet());
    this.location.clng = paramSearchCondition.getClng();
    this.location.clat = paramSearchCondition.getClat();
    this.location.bizcircleCode = paramSearchCondition.getBizcircle_code();
    this.location.bizcircleName = paramSearchCondition.getBizcircle_name();
    this.location.subwayName = paramSearchCondition.getSubwayName();
    this.location.subwayCode = paramSearchCondition.getSubway();
    this.location.subwayLine = paramSearchCondition.getSubway_line();
    this.location.suggestType = paramSearchCondition.getSuggestion_type();
    this.location.suggestValue = paramSearchCondition.getSuggestion_value();
    this.filter.minPrice = paramSearchCondition.getMinPrice();
    this.filter.maxPrice = paramSearchCondition.getMaxPrice();
    Filter.access$002(this.filter, paramSearchCondition.getFaceBeanList());
    Filter.access$102(this.filter, paramSearchCondition.gethFaceBeanList());
    Filter.access$202(this.filter, paramSearchCondition.getrFaceBeanList());
    Filter.access$302(this.filter, paramSearchCondition.getAreaBeanList());
    Filter.access$402(this.filter, paramSearchCondition.getVersionBeanList());
    Filter.access$502(this.filter, paramSearchCondition.getStyleBeanList());
    Filter.access$602(this.filter, paramSearchCondition.getAroundBeanList());
    Filter.access$702(this.filter, paramSearchCondition.getFeatureBeanList());
    Filter.access$802(this.filter, paramSearchCondition.getLeaseTypeBeanList());
    Filter.access$902(this.filter, paramSearchCondition.getTagsBeanList());
    Filter.access$1002(this.filter, paramSearchCondition.getRapidBeanList());
    this.searchCondition = paramSearchCondition;
    this.timeStamp = System.currentTimeMillis();
  }
  
  private void checkFilter(RentSearchHistory paramRentSearchHistory)
  {
    if ((this.filter == null) || (this.filter.isNull()) || (this.filter.equals(paramRentSearchHistory.filter)))
    {
      this.shouldOverWirte = true;
      return;
    }
    this.shouldOverWirte = false;
  }
  
  private void checkLocation(RentSearchHistory paramRentSearchHistory)
  {
    if ((this.location == null) || (this.location.isNull()) || (this.location.equals(paramRentSearchHistory.location)))
    {
      checkFilter(paramRentSearchHistory);
      return;
    }
    this.shouldOverWirte = false;
  }
  
  private void checkType(RentSearchHistory paramRentSearchHistory)
  {
    if ((this.type == null) || (this.type.isNull()) || (this.type.equals(paramRentSearchHistory.type)))
    {
      checkLocation(paramRentSearchHistory);
      return;
    }
    this.shouldOverWirte = false;
  }
  
  public int compareTo(Object paramObject)
  {
    if (!(paramObject instanceof RentSearchHistory)) {}
    do
    {
      return 0;
      paramObject = (RentSearchHistory)paramObject;
      if (this.timeStamp > ((RentSearchHistory)paramObject).timeStamp) {
        return -1;
      }
    } while (this.timeStamp >= ((RentSearchHistory)paramObject).timeStamp);
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof RentSearchHistory)) {
        return false;
      }
      paramObject = (RentSearchHistory)paramObject;
      try
      {
        if ((((RentSearchHistory)paramObject).type.equals(this.type)) && (((RentSearchHistory)paramObject).location.equals(this.location)))
        {
          boolean bool = ((RentSearchHistory)paramObject).filter.equals(this.filter);
          if (bool) {}
        }
        else
        {
          return false;
        }
      }
      catch (NullPointerException paramObject) {}
    }
    return false;
  }
  
  public Filter getFilter()
  {
    return this.filter;
  }
  
  public Location getLocation()
  {
    return this.location;
  }
  
  public SearchCondition getSearchCondition()
  {
    return this.searchCondition;
  }
  
  public long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public Type getType()
  {
    return this.type;
  }
  
  public boolean isShouldOverWirte()
  {
    return this.shouldOverWirte;
  }
  
  public void setFilter(Filter paramFilter)
  {
    this.filter = paramFilter;
  }
  
  public void setLocation(Location paramLocation)
  {
    this.location = paramLocation;
  }
  
  public void setSearchCondition(SearchCondition paramSearchCondition)
  {
    this.searchCondition = paramSearchCondition;
  }
  
  public void setShouldOverWirte(boolean paramBoolean)
  {
    this.shouldOverWirte = paramBoolean;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }
  
  public void setType(Type paramType)
  {
    this.type = paramType;
  }
  
  public boolean shouldOverWrite(RentSearchHistory paramRentSearchHistory)
  {
    if (paramRentSearchHistory == null) {}
    while (paramRentSearchHistory.equals(this)) {
      return true;
    }
    checkType(paramRentSearchHistory);
    return this.shouldOverWirte;
  }
  
  public static class Filter
  {
    private List<SelectBean> areaBeanList;
    private List<SelectBean> aroundBeanList;
    private List<SelectBean> faceBeanList;
    private List<SelectBean> featureBeanList;
    private List<SelectBean> hFaceBeanList;
    private List<SelectBean> leaseTypeBeanList;
    int maxPrice;
    int minPrice;
    private List<SelectBean> rFaceBeanList;
    private List<SelectBean> rapidBeanList;
    private List<SelectBean> styleBeanList;
    private List<SelectBean> tagsBeanList;
    private List<SelectBean> versionBeanList;
    
    private boolean isListEquals(List<SelectBean> paramList1, List<SelectBean> paramList2)
    {
      if (paramList1 == paramList2) {}
      while ((paramList1 == null) && (paramList2 == null)) {
        return true;
      }
      if (paramList1 == null) {
        return false;
      }
      return paramList1.equals(paramList2);
    }
    
    private boolean isListNull(List<SelectBean>... paramVarArgs)
    {
      int j = paramVarArgs.length;
      int i = 0;
      if (i < j)
      {
        List<SelectBean> localList = paramVarArgs[i];
        if ((localList == null) || (localList.size() < 1)) {}
        while (localList.size() <= 0)
        {
          i += 1;
          break;
        }
        return false;
      }
      return true;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof Filter)) {
          return false;
        }
        paramObject = (Filter)paramObject;
        try
        {
          if ((((Filter)paramObject).minPrice == this.minPrice) && (((Filter)paramObject).maxPrice == this.maxPrice) && (isListEquals(((Filter)paramObject).areaBeanList, this.areaBeanList)) && (isListEquals(((Filter)paramObject).aroundBeanList, this.aroundBeanList)) && (isListEquals(((Filter)paramObject).faceBeanList, this.faceBeanList)) && (isListEquals(((Filter)paramObject).featureBeanList, this.featureBeanList)) && (isListEquals(((Filter)paramObject).styleBeanList, this.styleBeanList)) && (isListEquals(((Filter)paramObject).tagsBeanList, this.tagsBeanList)) && (isListEquals(((Filter)paramObject).versionBeanList, this.versionBeanList)) && (isListEquals(((Filter)paramObject).hFaceBeanList, this.hFaceBeanList)) && (isListEquals(((Filter)paramObject).leaseTypeBeanList, this.leaseTypeBeanList)) && (isListEquals(((Filter)paramObject).rFaceBeanList, this.rFaceBeanList)))
          {
            boolean bool = isListEquals(((Filter)paramObject).rapidBeanList, this.rapidBeanList);
            if (bool) {}
          }
          else
          {
            return false;
          }
        }
        catch (NullPointerException paramObject) {}
      }
      return false;
    }
    
    public List<SelectBean> getAreaBeanList()
    {
      return this.areaBeanList;
    }
    
    public List<SelectBean> getAroundBeanList()
    {
      return this.aroundBeanList;
    }
    
    public List<SelectBean> getFaceBeanList()
    {
      return this.faceBeanList;
    }
    
    public List<SelectBean> getFeatureBeanList()
    {
      return this.featureBeanList;
    }
    
    public List<SelectBean> getLeaseTypeBeanList()
    {
      return this.leaseTypeBeanList;
    }
    
    public int getMaxPrice()
    {
      return this.maxPrice;
    }
    
    public int getMinPrice()
    {
      return this.minPrice;
    }
    
    public List<SelectBean> getRapidBeanList()
    {
      return this.rapidBeanList;
    }
    
    public List<SelectBean> getStyleBeanList()
    {
      return this.styleBeanList;
    }
    
    public List<SelectBean> getTagsBeanList()
    {
      return this.tagsBeanList;
    }
    
    public List<SelectBean> getVersionBeanList()
    {
      return this.versionBeanList;
    }
    
    public List<SelectBean> gethFaceBeanList()
    {
      return this.hFaceBeanList;
    }
    
    public List<SelectBean> getrFaceBeanList()
    {
      return this.rFaceBeanList;
    }
    
    public boolean isNull()
    {
      if ((this.minPrice != 0) || (this.maxPrice != 0)) {
        return false;
      }
      return isListNull(new List[] { this.faceBeanList, this.hFaceBeanList, this.rFaceBeanList, this.areaBeanList, this.versionBeanList, this.styleBeanList, this.aroundBeanList, this.featureBeanList, this.leaseTypeBeanList, this.tagsBeanList });
    }
    
    public void setAreaBeanList(List<SelectBean> paramList)
    {
      this.areaBeanList = paramList;
    }
    
    public void setAroundBeanList(List<SelectBean> paramList)
    {
      this.aroundBeanList = paramList;
    }
    
    public void setFaceBeanList(List<SelectBean> paramList)
    {
      this.faceBeanList = paramList;
    }
    
    public void setFeatureBeanList(List<SelectBean> paramList)
    {
      this.featureBeanList = paramList;
    }
    
    public void setLeaseTypeBeanList(List<SelectBean> paramList)
    {
      this.leaseTypeBeanList = paramList;
    }
    
    public void setMaxPrice(int paramInt)
    {
      this.maxPrice = paramInt;
    }
    
    public void setMinPrice(int paramInt)
    {
      this.minPrice = paramInt;
    }
    
    public void setRapidBeanList(List<SelectBean> paramList)
    {
      this.rapidBeanList = paramList;
    }
    
    public void setStyleBeanList(List<SelectBean> paramList)
    {
      this.styleBeanList = paramList;
    }
    
    public void setTagsBeanList(List<SelectBean> paramList)
    {
      this.tagsBeanList = paramList;
    }
    
    public void setVersionBeanList(List<SelectBean> paramList)
    {
      this.versionBeanList = paramList;
    }
    
    public void sethFaceBeanList(List<SelectBean> paramList)
    {
      this.hFaceBeanList = paramList;
    }
    
    public void setrFaceBeanList(List<SelectBean> paramList)
    {
      this.rFaceBeanList = paramList;
    }
  }
  
  public static class Location
  {
    String bizcircleCode = "";
    String bizcircleName = "";
    String clat = "";
    String clng = "";
    String districtName = "";
    String districtValue = "";
    String keyword = "";
    String subwayCode = "";
    String subwayLine = "";
    String subwayName = "";
    String suggestType = "";
    String suggestValue = "";
    
    private boolean isLocationNull(String... paramVarArgs)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof Location)) {
          return false;
        }
        paramObject = (Location)paramObject;
        try
        {
          if ((((Location)paramObject).clat.equals(this.clat)) && (((Location)paramObject).clng.equals(this.clng)) && (((Location)paramObject).keyword.equals(this.keyword)) && (((Location)paramObject).bizcircleName.equals(this.bizcircleName)) && (((Location)paramObject).bizcircleCode.equals(this.bizcircleCode)) && (((Location)paramObject).districtName.equals(this.districtName)) && (((Location)paramObject).districtValue.equals(this.districtValue)) && (((Location)paramObject).subwayName.equals(this.subwayName)) && (((Location)paramObject).subwayCode.equals(this.subwayCode)) && (((Location)paramObject).subwayLine.equals(this.subwayLine)) && (((Location)paramObject).suggestType.equals(this.suggestType)))
          {
            boolean bool = ((Location)paramObject).suggestValue.equals(this.suggestValue);
            if (bool) {}
          }
          else
          {
            return false;
          }
        }
        catch (NullPointerException paramObject) {}
      }
      return false;
    }
    
    public String getBizcircleCode()
    {
      return this.bizcircleCode;
    }
    
    public String getBizcircleName()
    {
      return this.bizcircleName;
    }
    
    public String getClat()
    {
      return this.clat;
    }
    
    public String getClng()
    {
      return this.clng;
    }
    
    public String getDistrictName()
    {
      return this.districtName;
    }
    
    public String getDistrictValue()
    {
      return this.districtValue;
    }
    
    public String getKeyword()
    {
      return this.keyword;
    }
    
    public String getSubwayCode()
    {
      return this.subwayCode;
    }
    
    public String getSubwayLine()
    {
      return this.subwayLine;
    }
    
    public String getSubwayName()
    {
      return this.subwayName;
    }
    
    public String getSubwayStationCode()
    {
      return this.subwayLine;
    }
    
    public String getSuggestType()
    {
      return this.suggestType;
    }
    
    public String getSuggestValue()
    {
      return this.suggestValue;
    }
    
    public boolean isNull()
    {
      return isLocationNull(new String[] { this.clng, this.clat, this.keyword, this.bizcircleName, this.bizcircleCode, this.districtName, this.districtValue, this.subwayName, this.subwayCode, this.subwayLine, this.suggestType, this.suggestValue });
    }
    
    public void setBizcircleCode(String paramString)
    {
      this.bizcircleCode = paramString;
    }
    
    public void setBizcircleName(String paramString)
    {
      this.bizcircleName = paramString;
    }
    
    public void setClat(String paramString)
    {
      this.clat = paramString;
    }
    
    public void setClng(String paramString)
    {
      this.clng = paramString;
    }
    
    public void setDistrictName(String paramString)
    {
      this.districtName = paramString;
    }
    
    public void setDistrictValue(String paramString)
    {
      this.districtValue = paramString;
    }
    
    public void setKeyword(String paramString)
    {
      this.keyword = paramString;
    }
    
    public void setSubwayCode(String paramString)
    {
      this.subwayCode = paramString;
    }
    
    public void setSubwayLine(String paramString)
    {
      this.subwayLine = paramString;
    }
    
    public void setSubwayName(String paramString)
    {
      this.subwayName = paramString;
    }
    
    public void setSubwayStationCode(String paramString)
    {
      this.subwayLine = paramString;
    }
    
    public void setSuggestType(String paramString)
    {
      this.suggestType = paramString;
    }
    
    public void setSuggestValue(String paramString)
    {
      this.suggestValue = paramString;
    }
  }
  
  public static class Type
  {
    String type = "";
    HashSet<Integer> typeSet = new HashSet();
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof Type)) {
          return false;
        }
        paramObject = (Type)paramObject;
        try
        {
          if (((Type)paramObject).type.equals(this.type))
          {
            boolean bool = ((Type)paramObject).typeSet.equals(this.typeSet);
            if (bool) {}
          }
          else
          {
            return false;
          }
        }
        catch (NullPointerException paramObject) {}
      }
      return false;
    }
    
    public String getType()
    {
      return this.type;
    }
    
    public HashSet<Integer> getTypeSet()
    {
      return this.typeSet;
    }
    
    public boolean isNull()
    {
      return (TextUtils.isEmpty(this.type)) && ((this.typeSet == null) || (this.typeSet.size() < 1));
    }
    
    public void setType(String paramString)
    {
      if (paramString == null) {
        this.type = "";
      }
      do
      {
        return;
        if (!paramString.contains("|"))
        {
          this.type = paramString;
          return;
        }
        paramString = paramString.split("\\|");
      } while ((paramString == null) || (paramString.length < 1));
      Object localObject = Arrays.asList(paramString);
      Collections.sort((List)localObject);
      paramString = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.append((String)((Iterator)localObject).next()).append("|");
      }
      paramString.deleteCharAt(paramString.length() - 1);
      this.type = paramString.toString();
    }
    
    public void setTypeSet(HashSet<Integer> paramHashSet)
    {
      if (paramHashSet == null)
      {
        new HashSet();
        return;
      }
      this.typeSet = paramHashSet;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/model/RentSearchHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */