package com.ziroom.ziroomcustomer.minsu.searchlist.base;

import android.text.TextUtils;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityItemBean;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class c
  implements Cloneable
{
  public static final String a = c.class.getSimpleName();
  public static int b = 0;
  private static c e;
  private static final Object f = new Object();
  private static final Stack<c> g = new Stack();
  private Map<String, Object> A;
  private String B;
  private String C;
  private Integer D;
  private String E;
  private String F;
  private String G;
  private String H;
  private Integer I;
  private String J;
  private MinsuCityItemBean K;
  private String L;
  private int M = 0;
  private String N;
  private String O;
  private Map<String, String> P;
  private String Q;
  private Double R;
  private Double S;
  private Integer T;
  private Integer U;
  private Integer V;
  public int c = -1;
  public String d;
  private boolean h = true;
  private boolean i = true;
  private boolean j = true;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private String n;
  private String o;
  private String p;
  private String q;
  private Integer r;
  private String s;
  private String t;
  private Integer u;
  private Integer v;
  private Integer w;
  private Integer x;
  private String y;
  private Set<String> z;
  
  private boolean b()
  {
    boolean bool = false;
    if (this.h)
    {
      this.h = false;
      bool = true;
    }
    return bool;
  }
  
  private boolean c()
  {
    boolean bool = false;
    if (this.i)
    {
      this.i = false;
      bool = true;
    }
    return bool;
  }
  
  private boolean d()
  {
    boolean bool = false;
    if (this.j)
    {
      this.j = false;
      bool = true;
    }
    return bool;
  }
  
  private boolean e()
  {
    boolean bool = false;
    if (this.k)
    {
      this.k = false;
      bool = true;
    }
    return bool;
  }
  
  private boolean f()
  {
    boolean bool = false;
    if (this.l)
    {
      this.l = false;
      bool = true;
    }
    return bool;
  }
  
  private boolean g()
  {
    boolean bool = false;
    if (this.m)
    {
      this.m = false;
      bool = true;
    }
    return bool;
  }
  
  public static c getInstance()
  {
    if (e == null) {}
    synchronized (f)
    {
      if (g.size() > 0) {
        e = (c)g.pop();
      }
      if (e == null) {
        e = new c();
      }
      return e;
    }
  }
  
  protected c a()
  {
    try
    {
      c localc = (c)super.clone();
      return localc;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void addSearchListCount()
  {
    b += 1;
  }
  
  public void addSupplementElement(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (this.P == null) {
      this.P = new HashMap();
    }
    this.P.put(paramString1, paramString2);
    this.h = true;
  }
  
  public void clearGlobalCondition()
  {
    this.h = true;
    this.i = true;
    this.j = true;
    this.o = null;
    this.J = null;
    this.p = null;
    this.q = null;
    this.r = null;
    setLocationCache(-1, -1, -1);
    this.Q = null;
    this.P = null;
    clearMinsuMapSearch();
  }
  
  public void clearMinsuCondition()
  {
    this.h = true;
    this.s = null;
    this.t = null;
    this.L = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.C = null;
    this.D = null;
    this.E = null;
    this.F = null;
    this.G = null;
    this.H = null;
    this.I = null;
    this.P = null;
    this.Q = null;
    this.c = -1;
  }
  
  public void clearMinsuConditionCondition()
  {
    this.h = true;
    this.L = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.x = null;
    this.z = null;
    this.D = null;
    this.F = null;
    this.G = null;
    this.H = null;
    this.I = null;
  }
  
  public void clearMinsuLocationCondition()
  {
    this.h = true;
    this.y = null;
    this.s = null;
    this.t = null;
    this.B = null;
    this.E = null;
    this.P = null;
    this.Q = null;
    setLocationCache(-1, -1, -1);
    setLocLatLon(null, null);
  }
  
  public void clearMinsuMapFilter()
  {
    this.h = true;
    this.L = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.F = null;
    this.G = null;
    this.H = null;
    this.I = null;
  }
  
  public void clearMinsuMapSearch()
  {
    setMapZoomType(0);
    setLongitude(null);
    setLatitude(null);
  }
  
  public void clearMinsuSortCondition()
  {
    this.h = true;
    this.A = null;
    this.C = null;
    this.c = -1;
  }
  
  public void clearStack()
  {
    g.clear();
    b = 0;
  }
  
  public void clearSupplementMap()
  {
    this.P = null;
    this.Q = null;
    this.h = true;
  }
  
  public Map<String, String> generateRequestMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit", String.valueOf(10));
    if (!TextUtils.isEmpty(this.n)) {
      localHashMap.put("q", this.n);
    }
    if (!TextUtils.isEmpty(this.o)) {
      localHashMap.put("cityCode", this.o);
    }
    if (!TextUtils.isEmpty(this.p)) {
      localHashMap.put("startTime", this.p);
    }
    if (!TextUtils.isEmpty(this.q)) {
      localHashMap.put("endTime", this.q);
    }
    if (this.r != null) {
      localHashMap.put("personCount", this.r.toString());
    }
    if (!TextUtils.isEmpty(this.s)) {
      localHashMap.put("hotReginScenic", this.s);
    }
    if (!TextUtils.isEmpty(this.t)) {
      localHashMap.put("hotReginBusiness", this.t);
    }
    if (this.L != null) {
      localHashMap.put("multiRentWay", this.L.toString());
    }
    if (this.u != null) {
      localHashMap.put("orderType", this.u.toString());
    }
    if (this.v != null) {
      localHashMap.put("priceStart", this.v.toString());
    }
    if (this.w != null) {
      localHashMap.put("priceEnd", this.w.toString());
    }
    if (this.x != null) {
      localHashMap.put("roomCount", this.x.toString());
    }
    if (!TextUtils.isEmpty(this.y)) {
      localHashMap.put("loc", this.y);
    }
    if ((this.z != null) && (this.z.size() > 0)) {
      localHashMap.put("services", this.z.toString());
    }
    if ((this.A != null) && (this.A.size() > 0)) {
      localHashMap.put("sorts", this.A.toString());
    }
    if (!TextUtils.isEmpty(this.B)) {
      localHashMap.put("areaCode", this.B);
    }
    if (!TextUtils.isEmpty(this.C)) {
      localHashMap.put("sortType", this.C);
    }
    if (this.D != null) {
      localHashMap.put("iconType", this.D.toString());
    }
    if (!TextUtils.isEmpty(this.E)) {
      localHashMap.put("lineFid", this.E);
    }
    if (!TextUtils.isEmpty(this.F)) {
      localHashMap.put("houseType", this.F);
    }
    if (!TextUtils.isEmpty(this.G)) {
      localHashMap.put("longTermDiscount", this.G);
    }
    if (!TextUtils.isEmpty(this.H)) {
      localHashMap.put("jiaxinDiscount", this.H);
    }
    if (this.I != null) {
      localHashMap.put("isLandTogether", this.I.toString());
    }
    if ((this.P != null) && (this.P.size() > 0)) {
      localHashMap.putAll(this.P);
    }
    if (!TextUtils.isEmpty(this.N)) {
      localHashMap.put("longitude", this.N);
    }
    if (!TextUtils.isEmpty(this.O)) {
      localHashMap.put("latitude", this.O);
    }
    return localHashMap;
  }
  
  public String getAreaCode()
  {
    return this.B;
  }
  
  public MinsuCityItemBean getCityBean()
  {
    return this.K;
  }
  
  public String getCityCode()
  {
    return this.o;
  }
  
  public String getCityName()
  {
    return this.J;
  }
  
  public String getEndTime()
  {
    return this.q;
  }
  
  public String getHotReginBusiness()
  {
    return this.t;
  }
  
  public String getHotReginScenic()
  {
    return this.s;
  }
  
  public String getHouseType()
  {
    return this.F;
  }
  
  public Integer getIconType()
  {
    return this.D;
  }
  
  public Integer getIsLandTogether()
  {
    return this.I;
  }
  
  public String getJiaxinDiscount()
  {
    return this.H;
  }
  
  public String getKeyword()
  {
    return this.n;
  }
  
  public String getLatitude()
  {
    return this.O;
  }
  
  public String getLineFid()
  {
    return this.E;
  }
  
  public String getLoc()
  {
    return this.y;
  }
  
  public Double getLocLat()
  {
    return this.R;
  }
  
  public Double getLocLon()
  {
    return this.S;
  }
  
  public String getLocationName()
  {
    return this.Q;
  }
  
  public Integer getLocationPosition1()
  {
    return this.T;
  }
  
  public Integer getLocationPosition2()
  {
    return this.U;
  }
  
  public Integer getLocationPosition3()
  {
    return this.V;
  }
  
  public String getLongTermDiscount()
  {
    return this.G;
  }
  
  public String getLongitude()
  {
    return this.N;
  }
  
  public int getMapZoomType()
  {
    return this.M;
  }
  
  public int getMinsuConditionCount()
  {
    int i2 = 0;
    int i1 = i2;
    if (!TextUtils.isEmpty(getMultiRentWay())) {
      if ((!"0,1".equals(getMultiRentWay())) && (!"1,0".equals(getMultiRentWay())) && (!"1".equals(getMultiRentWay())))
      {
        i1 = i2;
        if (!"0".equals(getMultiRentWay())) {}
      }
      else
      {
        i1 = 1;
      }
    }
    i2 = i1;
    if (getIsLandTogether() != null)
    {
      i2 = i1;
      if (getIsLandTogether().intValue() == 1) {
        i2 = i1 + 1;
      }
    }
    i1 = i2;
    if (getOrderType() != null)
    {
      i1 = i2;
      if (getOrderType().intValue() != -1) {
        i1 = i2 + 1;
      }
    }
    i2 = i1;
    if (getRoomCount() != null)
    {
      i2 = i1;
      if (getRoomCount().intValue() > 0) {
        i2 = i1 + 1;
      }
    }
    if ((getPriceEnd() == null) || (getPriceEnd().intValue() >= 120000))
    {
      i1 = i2;
      if (getPriceStart() != null)
      {
        i1 = i2;
        if (getPriceStart().intValue() <= 0) {}
      }
    }
    else
    {
      i1 = i2 + 1;
    }
    i2 = i1;
    if (!TextUtils.isEmpty(getHouseType())) {
      i2 = i1 + 1;
    }
    if (TextUtils.isEmpty(getLongTermDiscount()))
    {
      i1 = i2;
      if (TextUtils.isEmpty(getJiaxinDiscount())) {}
    }
    else
    {
      i1 = i2 + 1;
    }
    return i1;
  }
  
  public String getMultiRentWay()
  {
    return this.L;
  }
  
  public Integer getOrderType()
  {
    return this.u;
  }
  
  public Integer getPersonCount()
  {
    return this.r;
  }
  
  public Integer getPriceEnd()
  {
    return this.w;
  }
  
  public Integer getPriceStart()
  {
    return this.v;
  }
  
  public Integer getRoomCount()
  {
    return this.x;
  }
  
  public Set<String> getServices()
  {
    return this.z;
  }
  
  public int getSortPosition()
  {
    return this.c;
  }
  
  public String getSortPositionName()
  {
    return this.d;
  }
  
  public String getSortType()
  {
    return this.C;
  }
  
  public Map<String, Object> getSorts()
  {
    return this.A;
  }
  
  public String getStartTime()
  {
    return this.p;
  }
  
  public Map<String, String> getSupplementMap()
  {
    if (this.P == null) {
      this.P = new HashMap();
    }
    return this.P;
  }
  
  public boolean isMinsuNeedRequest()
  {
    return e() | b();
  }
  
  public boolean isStationNeedRequest()
  {
    return f() | c();
  }
  
  public boolean isStrategyNeedRequest()
  {
    return g() | d();
  }
  
  public void pop()
  {
    a.i(a, "pop");
    if (g.size() > 0)
    {
      c localc = (c)g.pop();
      if (localc != null) {
        e = localc;
      }
    }
    if (b > 0) {
      b -= 1;
    }
  }
  
  public void push()
  {
    a.i(a, "push");
    if ((e != null) && (b > 0))
    {
      c localc = e.a();
      g.push(e);
      e = localc;
    }
  }
  
  public void reset()
  {
    this.h = true;
    this.i = true;
    this.j = true;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
    this.r = null;
    this.s = null;
    this.t = null;
    this.L = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.C = null;
    this.D = null;
    this.E = null;
    this.F = null;
    this.G = null;
    this.H = null;
    this.I = null;
    this.J = null;
    this.P = null;
    this.Q = null;
    this.c = -1;
    this.d = null;
    clearMinsuMapSearch();
  }
  
  public void setAreaCode(String paramString)
  {
    this.B = paramString;
    this.h = true;
  }
  
  public void setCityBean(MinsuCityItemBean paramMinsuCityItemBean)
  {
    this.K = paramMinsuCityItemBean;
  }
  
  public void setCityCode(String paramString)
  {
    this.o = paramString;
    this.h = true;
    this.i = true;
    this.j = true;
    this.t = null;
    this.s = null;
    this.E = null;
    this.F = null;
    this.B = null;
    this.P = null;
    if ((this.K != null) && (!this.o.equals(this.K.code))) {
      this.K = null;
    }
    setLocLatLon(null, null);
    clearMinsuMapSearch();
  }
  
  public void setCityName(String paramString)
  {
    this.J = paramString;
  }
  
  public void setEndTime(String paramString)
  {
    this.q = paramString;
    this.h = true;
    this.i = true;
    this.j = true;
  }
  
  public void setHotReginBusiness(String paramString)
  {
    this.t = paramString;
    this.h = true;
  }
  
  public void setHotReginScenic(String paramString)
  {
    this.s = paramString;
    this.h = true;
  }
  
  public void setHouseType(String paramString)
  {
    this.F = paramString;
    this.h = true;
  }
  
  public void setIconType(Integer paramInteger)
  {
    this.D = paramInteger;
    this.h = true;
  }
  
  public void setInit(boolean paramBoolean)
  {
    this.k = paramBoolean;
    this.l = paramBoolean;
    this.m = paramBoolean;
  }
  
  public void setInitMinsu(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setInitStation(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setInitStrategy(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setIsLandTogether(Integer paramInteger)
  {
    this.I = paramInteger;
    this.h = true;
  }
  
  public void setJiaxinDiscount(String paramString)
  {
    this.H = paramString;
    this.h = true;
  }
  
  public void setKeyword(String paramString)
  {
    this.n = paramString;
    this.h = true;
    this.i = true;
    this.j = true;
  }
  
  public void setLatitude(String paramString)
  {
    this.O = paramString;
  }
  
  public void setLineFid(String paramString)
  {
    this.E = paramString;
    this.h = true;
  }
  
  public void setLoc(String paramString)
  {
    this.y = paramString;
    this.h = true;
  }
  
  public void setLocLatLon(Double paramDouble1, Double paramDouble2)
  {
    this.R = paramDouble1;
    this.S = paramDouble2;
  }
  
  public void setLocationCache(int paramInt1, int paramInt2, int paramInt3)
  {
    this.T = null;
    this.U = null;
    this.V = null;
    if (paramInt1 >= 0) {
      this.T = Integer.valueOf(paramInt1);
    }
    if (paramInt2 >= 0) {
      this.U = Integer.valueOf(paramInt2);
    }
    if (paramInt3 >= 0) {
      this.V = Integer.valueOf(paramInt3);
    }
  }
  
  public void setLocationName(String paramString)
  {
    this.Q = paramString;
  }
  
  public void setLongTermDiscount(String paramString)
  {
    this.G = paramString;
    this.h = true;
  }
  
  public void setLongitude(String paramString)
  {
    this.N = paramString;
  }
  
  public void setMapZoomType(int paramInt)
  {
    this.M = paramInt;
  }
  
  public void setMultiRentWay(String paramString)
  {
    this.L = paramString;
  }
  
  public void setOrderType(Integer paramInteger)
  {
    this.u = paramInteger;
    this.h = true;
  }
  
  public void setPersonCount(Integer paramInteger)
  {
    this.r = paramInteger;
    this.h = true;
    this.i = true;
    this.j = true;
  }
  
  public void setPriceEnd(Integer paramInteger)
  {
    this.w = paramInteger;
    this.h = true;
  }
  
  public void setPriceStart(Integer paramInteger)
  {
    this.v = paramInteger;
    this.h = true;
  }
  
  public void setRoomCount(Integer paramInteger)
  {
    this.x = paramInteger;
    this.h = true;
  }
  
  public void setServices(Set<String> paramSet)
  {
    this.z = paramSet;
    this.h = true;
  }
  
  public void setSortPosition(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setSortPositionName(String paramString)
  {
    this.d = paramString;
  }
  
  public void setSortType(String paramString)
  {
    this.C = paramString;
    this.h = true;
  }
  
  public void setSorts(Map<String, Object> paramMap)
  {
    this.A = paramMap;
    this.h = true;
  }
  
  public void setStartTime(String paramString)
  {
    this.p = paramString;
    this.h = true;
    this.i = true;
    this.j = true;
  }
  
  public boolean testRequest()
  {
    return (this.k) || (this.l) || (this.m) || (this.h) || (this.i) || (this.j);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/base/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */