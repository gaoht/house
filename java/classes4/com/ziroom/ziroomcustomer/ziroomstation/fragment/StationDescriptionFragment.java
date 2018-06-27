package com.ziroom.ziroomcustomer.ziroomstation.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import com.ziroom.ziroomcustomer.ziroomstation.ProjectDetailActivity;
import com.ziroom.ziroomcustomer.ziroomstation.b.c;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationDescription;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StationDescriptionFragment
  extends BaseFragment
  implements XListView.a, com.ziroom.ziroomcustomer.ziroomstation.adapter.i.a
{
  public boolean a = false;
  private XListView b;
  private com.ziroom.ziroomcustomer.ziroomstation.adapter.i c;
  private List<StationDescription> d = new ArrayList();
  private String e;
  private int f = 1;
  private int g = 1;
  private boolean h = false;
  
  private void a(List<StationDescription> paramList)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    d.e("StationDescFragment", "refreshUI datalist--" + paramList);
    if (this.h)
    {
      this.d.addAll(paramList);
      setHasImageSign();
      paramList = this.c;
      localList = this.d;
      if (1 == this.f) {}
      for (;;)
      {
        paramList.setData(localList, bool1);
        this.g += 1;
        return;
        bool1 = false;
      }
    }
    this.g = 1;
    this.d.clear();
    this.d.addAll(paramList);
    setHasImageSign();
    paramList = this.c;
    List localList = this.d;
    if (1 == this.f) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramList.setData(localList, bool1);
      break;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.e = ((ProjectDetailActivity)getActivity()).a;
    c.getZraEvaluate(getActivity(), this.e, this.g, 5, paramInt, new com.freelxl.baselibrary.e.i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk)
      {
        d.d("StationDescFragment", paramAnonymousString);
        String str = h.getJsonString(paramAnonymousString, "status");
        paramAnonymousk.setCode(str);
        if ("success".equals(str))
        {
          paramAnonymousk.setMessage(h.getJsonString(paramAnonymousString, "message"));
          paramAnonymousString = h.getJsonString(paramAnonymousString, "data");
          paramAnonymousk.setObject(StationDescriptionFragment.a(StationDescriptionFragment.this, paramAnonymousString));
        }
        for (;;)
        {
          paramAnonymousk.setSuccess(Boolean.valueOf(true));
          return;
          paramAnonymousk.setMessage(h.getJsonString(paramAnonymousString, "message"));
        }
      }
      
      public void onSuccess(k paramAnonymousk)
      {
        if (paramAnonymousk.getSuccess().booleanValue()) {
          if ("success".equals(paramAnonymousk.getCode()))
          {
            if (paramAnonymousk.getObject() == null)
            {
              af.showToast(StationDescriptionFragment.this.getActivity(), "数据解析失败!");
              return;
            }
            List localList = (List)paramAnonymousk.getObject();
            if ((localList == null) || (localList.size() <= 0)) {
              af.showToast(StationDescriptionFragment.this.getActivity(), paramAnonymousk.getMessage());
            }
            StationDescriptionFragment.a(StationDescriptionFragment.this, localList);
          }
        }
        for (;;)
        {
          StationDescriptionFragment.a(StationDescriptionFragment.this);
          StationDescriptionFragment.a(StationDescriptionFragment.this, false);
          return;
          af.showToast(StationDescriptionFragment.this.getActivity(), "服务器开小差了，请稍后再试");
          continue;
          af.showToast(StationDescriptionFragment.this.getActivity(), paramAnonymousk.getMessage());
        }
      }
    }, paramBoolean);
  }
  
  private List<StationDescription> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramString);
      d.i("Http evaluate items nums:", "array.length()" + localJSONArray1.length());
      int m = 0;
      if (m < localJSONArray1.length())
      {
        StationDescription localStationDescription = new StationDescription();
        JSONArray localJSONArray2 = (JSONArray)localJSONArray1.opt(m);
        int i = 0;
        int j = 0;
        int n = 0;
        label97:
        JSONObject localJSONObject;
        int k;
        label344:
        Object localObject1;
        int i1;
        if (n < localJSONArray2.length())
        {
          localJSONObject = (JSONObject)localJSONArray2.opt(n);
          if (TextUtils.isEmpty(localStationDescription.text_date)) {
            localStationDescription.text_date = localJSONObject.optString("evaluateDate");
          }
          if (TextUtils.isEmpty(localStationDescription.evaluatorId)) {
            localStationDescription.text_phone = localJSONObject.optString("evaluatorId");
          }
          if (TextUtils.isEmpty(localStationDescription.orderCode)) {
            localStationDescription.orderCode = localJSONObject.optString("orderCode");
          }
          if (TextUtils.isEmpty(localStationDescription.ext)) {
            localStationDescription.ext = localJSONObject.optString("ext");
          }
          paramString = new JSONArray(localJSONObject.optString("answers")).toString();
          d.d("StationDescFragment", "answerString " + paramString);
          paramString = paramString.substring(1, paramString.length() - 1);
          d.d("StationDescFragment", "answerSubStr " + paramString);
          if (com.ziroom.ziroomcustomer.ziroomstation.utils.i.TextisEmpty(paramString))
          {
            k = i;
            i = j;
            j = k;
            break label699;
          }
          if ((!"5".equals(localJSONObject.optString("optionType"))) && (!"2".equals(localJSONObject.optString("optionType"))))
          {
            paramString = paramString.split(",");
            localObject1 = new ArrayList();
            i1 = paramString.length;
            k = 0;
          }
        }
        for (;;)
        {
          Object localObject2;
          if (k < i1)
          {
            CharSequence localCharSequence = paramString[k];
            localObject2 = localObject1;
            if (com.ziroom.ziroomcustomer.ziroomstation.utils.i.TextisEmpty(localCharSequence)) {
              break label716;
            }
            d.d("StationDescFragment", "answer--" + localCharSequence);
            localObject2 = localCharSequence.substring(localCharSequence.indexOf("\"") + 1, localCharSequence.lastIndexOf("\""));
            if ("5".equals(localJSONObject.optString("optionType")))
            {
              localObject2 = Arrays.asList(((String)localObject2).replace("\\", "").split(","));
              break label716;
              paramString = new String[] { paramString };
              break label344;
            }
            ((List)localObject1).add(localObject2);
            localObject2 = localObject1;
            break label716;
          }
          if ("2".equals(localJSONObject.optString("optionType"))) {
            localStationDescription.text_desc = com.ziroom.ziroomcustomer.ziroomstation.utils.i.listToString((List)localObject1);
          }
          if ("4".equals(localJSONObject.optString("optionType"))) {
            localStationDescription.tags = ((List)localObject1);
          }
          if ("5".equals(localJSONObject.optString("optionType"))) {
            localStationDescription.imgUrls = ((List)localObject1);
          }
          if ("6".equals(localJSONObject.optString("optionType"))) {
            localStationDescription.room_types = ((List)localObject1);
          }
          if ("7".equals(localJSONObject.optString("optionType")))
          {
            paramString = ((List)localObject1).iterator();
            k = i;
            for (;;)
            {
              if (paramString.hasNext())
              {
                k += Integer.valueOf((String)paramString.next()).intValue();
                continue;
                localStationDescription.count_star = Math.round(i / j);
                localArrayList.add(localStationDescription);
                m += 1;
                break;
              }
            }
            i = j + 1;
            j = k;
          }
          else
          {
            k = j;
            j = i;
            i = k;
          }
          label699:
          n += 1;
          k = j;
          j = i;
          i = k;
          break label97;
          label716:
          k += 1;
          localObject1 = localObject2;
        }
      }
      return localArrayList;
    }
    catch (JSONException paramString) {}
  }
  
  private void c()
  {
    setHasImageSign();
    FragmentActivity localFragmentActivity = getActivity();
    List localList = this.d;
    if (1 == this.f) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = new com.ziroom.ziroomcustomer.ziroomstation.adapter.i(localFragmentActivity, localList, bool);
      this.c.setOnHasImgClickListener(this);
      this.b.setAdapter(this.c);
      this.b.setPullLoadEnable(true);
      this.b.setPullRefreshEnable(false);
      this.b.setXListViewListener(this);
      return;
    }
  }
  
  private void d()
  {
    this.b.stopRefresh();
    this.b.stopLoadMore();
    this.b.setRefreshTime(new Date().toLocaleString());
  }
  
  public void onAllClick()
  {
    this.f = 0;
    this.g = 1;
    a(true, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903991, paramViewGroup, false);
    this.b = ((XListView)paramLayoutInflater.findViewById(2131693954));
    c();
    return paramLayoutInflater;
  }
  
  public void onHasImgClick()
  {
    this.f = 1;
    this.g = 1;
    a(true, 1);
  }
  
  public void onLoadMore()
  {
    this.h = true;
    a(false, this.f);
  }
  
  public void onRefresh()
  {
    d();
  }
  
  public void onResume()
  {
    a("zinn_detail_eva_duration");
    super.onResume();
  }
  
  public void setHasImageSign()
  {
    boolean bool = true;
    StationDescription localStationDescription;
    if ((this.d != null) && (this.d.size() > 0) && (this.d.get(0) != null))
    {
      localStationDescription = (StationDescription)this.d.get(0);
      if (1 != this.f) {
        break label103;
      }
    }
    for (;;)
    {
      localStationDescription.hasImg = bool;
      d.i("Http image:", "set value:" + ((StationDescription)this.d.get(0)).hasImg);
      return;
      label103:
      bool = false;
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    Log.d("StationDescFragment", "isVisibleToUser " + paramBoolean);
    this.a = paramBoolean;
    if (paramBoolean)
    {
      this.g = 1;
      this.d.clear();
      if (checkNet(getActivity())) {
        a(true, this.f);
      }
    }
    else
    {
      return;
    }
    af.showToast(getActivity(), "网络不佳，请稍后再试");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/fragment/StationDescriptionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */