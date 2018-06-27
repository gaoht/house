package com.ziroom.ziroomcustomer.minsu.d;

import android.app.Activity;
import android.util.Log;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityBean.DataBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityItemBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityKeyBean;
import com.ziroom.ziroomcustomer.minsu.f.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class b
{
  private static b b;
  private static final Object h = new Object();
  private Activity a;
  private Map<String, MinsuCityItemBean> c;
  private List<String> d;
  private List<MinsuCityKeyBean> e;
  private List<MinsuCityItemBean> f;
  private Map<String, String> g;
  
  private b(Activity paramActivity)
  {
    this.a = paramActivity;
    this.g = new LinkedHashMap();
    this.c = new LinkedHashMap();
    this.d = new ArrayList();
    this.e = new ArrayList();
    this.f = new ArrayList();
  }
  
  private void a()
  {
    getData(null);
  }
  
  private void a(List<MinsuCityBean.DataBean.ListBean> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        boolean bool = paramList.isEmpty();
        if (bool) {
          return;
        }
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          MinsuCityBean.DataBean.ListBean localListBean = (MinsuCityBean.DataBean.ListBean)paramList.next();
          if ((localListBean.cityList != null) && (!localListBean.cityList.isEmpty()))
          {
            Iterator localIterator = localListBean.cityList.iterator();
            if (localIterator.hasNext())
            {
              MinsuCityItemBean localMinsuCityItemBean = (MinsuCityItemBean)localIterator.next();
              this.c.put(localMinsuCityItemBean.code, localMinsuCityItemBean);
              this.g.put(localMinsuCityItemBean.name, localMinsuCityItemBean.code);
              MinsuCityKeyBean localMinsuCityKeyBean = new MinsuCityKeyBean();
              localMinsuCityKeyBean.key = localListBean.key;
              localMinsuCityKeyBean.name = localMinsuCityItemBean.name;
              this.e.add(localMinsuCityKeyBean);
            }
            else
            {
              this.d.add(localListBean.key);
            }
          }
        }
      }
      finally {}
    }
  }
  
  public static b getIntance(Activity paramActivity)
  {
    if (b == null) {}
    synchronized (h)
    {
      b = new b(paramActivity);
      b.a();
      return b;
    }
  }
  
  public MinsuCityItemBean getCityBean(String paramString)
  {
    if ((this.c.size() == 0) || (this.g.size() == 0))
    {
      a();
      return null;
    }
    return (MinsuCityItemBean)this.c.get(paramString);
  }
  
  public List<String> getCityKeyList()
  {
    if (this.d.size() == 0) {
      return null;
    }
    return this.d;
  }
  
  public List<MinsuCityKeyBean> getCityKeyNameMapList()
  {
    if (this.e.size() == 0) {
      return null;
    }
    return this.e;
  }
  
  public List<String> getCityNameList()
  {
    if ((this.c.size() == 0) || (this.g.size() == 0))
    {
      a();
      return null;
    }
    return new ArrayList(this.g.keySet());
  }
  
  public List<String> getCityNameList(x paramx)
  {
    Object localObject;
    if ((this.c.size() == 0) || (this.g.size() == 0))
    {
      getData(paramx);
      localObject = null;
    }
    ArrayList localArrayList;
    do
    {
      return (List<String>)localObject;
      localArrayList = new ArrayList(this.g.keySet());
      localObject = localArrayList;
    } while (paramx == null);
    paramx.onSuccess(localArrayList);
    return localArrayList;
  }
  
  public String getCode(String paramString)
  {
    if ((this.c.size() == 0) || (this.g.size() == 0))
    {
      a();
      return null;
    }
    return (String)this.g.get(paramString);
  }
  
  public String getCode(String paramString, x paramx)
  {
    if ((this.c.size() == 0) || (this.g.size() == 0))
    {
      getData(paramx);
      return null;
    }
    return (String)this.g.get(paramString);
  }
  
  public void getData(final x paramx)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.cityListHot(this.a, true, new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.d(MinsuCityBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        com.freelxl.baselibrary.f.d.d("lanzhihong", Log.getStackTraceString(paramAnonymousThrowable.getCause()));
        if (paramx != null) {
          paramx.onError(paramAnonymousThrowable);
        }
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuCityBean paramAnonymousMinsuCityBean)
      {
        if ((paramAnonymousMinsuCityBean != null) && (paramAnonymousMinsuCityBean.checkSuccess(b.a(b.this))))
        {
          com.freelxl.baselibrary.f.d.e("lanzhihong", "ro======" + paramAnonymousMinsuCityBean.toString());
          if ((paramAnonymousMinsuCityBean != null) && (paramAnonymousMinsuCityBean.data != null)) {
            break label57;
          }
        }
        label57:
        do
        {
          return;
          b.a(b.this, paramAnonymousMinsuCityBean.data.list);
          b.b(b.this, paramAnonymousMinsuCityBean.data.hot);
        } while (paramx == null);
        paramx.onSuccess(paramAnonymousMinsuCityBean);
      }
    });
  }
  
  public List<MinsuCityItemBean> getHotCityList()
  {
    if (this.f.size() == 0) {
      return null;
    }
    return this.f;
  }
  
  public String getName(String paramString)
  {
    if ((this.c.size() == 0) || (this.g.size() == 0))
    {
      a();
      return null;
    }
    return ((MinsuCityItemBean)this.c.get(paramString)).name;
  }
  
  public String getName(String paramString, x paramx)
  {
    if ((this.c.size() == 0) || (this.g.size() == 0))
    {
      getData(paramx);
      return null;
    }
    return ((MinsuCityItemBean)this.c.get(paramString)).name;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */