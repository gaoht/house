package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCustomerBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCustomerBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ae;

public class c
{
  public static String getUserName(Activity paramActivity, String paramString, final CommonTitle paramCommonTitle)
  {
    if (ae.isNull(paramString)) {
      return "";
    }
    String str = j.removeEMPrefix(paramString);
    if (ApplicationEx.c.getData(str) == null)
    {
      paramString = "";
      if (!ae.isNull(paramString)) {
        break label81;
      }
      com.ziroom.ziroomcustomer.minsu.e.a.getCustomerVo(paramActivity, str, new com.freelxl.baselibrary.d.c.a(new r(MinsuCustomerBean.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, MinsuCustomerBean paramAnonymousMinsuCustomerBean)
        {
          if ((paramAnonymousMinsuCustomerBean == null) || (!paramAnonymousMinsuCustomerBean.checkSuccessNoLogin()) || (paramAnonymousMinsuCustomerBean.data == null)) {}
          do
          {
            return;
            ApplicationEx.c.putData(paramAnonymousMinsuCustomerBean.data.uid, com.alibaba.fastjson.a.toJSONString(paramAnonymousMinsuCustomerBean));
          } while (paramCommonTitle == null);
          CommonTitle localCommonTitle = paramCommonTitle;
          if (ae.isNull(paramAnonymousMinsuCustomerBean.data.nickName)) {}
          for (paramAnonymousMinsuCustomerBean = "房客";; paramAnonymousMinsuCustomerBean = paramAnonymousMinsuCustomerBean.data.nickName)
          {
            localCommonTitle.setMiddleText(paramAnonymousMinsuCustomerBean);
            return;
          }
        }
      });
    }
    for (;;)
    {
      if (ae.isNull(paramString))
      {
        return "房客";
        paramString = ApplicationEx.c.getData(str).toString();
        break;
        label81:
        paramActivity = (MinsuCustomerBean)com.alibaba.fastjson.a.parseObject(paramString, MinsuCustomerBean.class);
        if (paramCommonTitle != null)
        {
          if (ae.isNull(paramActivity.data.nickName)) {}
          for (paramActivity = "房客";; paramActivity = paramActivity.data.nickName)
          {
            paramCommonTitle.setMiddleText(paramActivity);
            break;
          }
        }
      }
    }
    paramActivity = (MinsuCustomerBean)com.alibaba.fastjson.a.parseObject(paramString, MinsuCustomerBean.class);
    if (ae.isNull(paramActivity.data.nickName)) {
      return "房客";
    }
    return paramActivity.data.nickName;
  }
  
  public static String getUserName(String paramString)
  {
    if (ae.isNull(paramString)) {
      return "";
    }
    paramString = j.removeEMPrefix(paramString);
    if (ApplicationEx.c.getData(paramString) == null) {}
    for (paramString = ""; ae.isNull(paramString); paramString = ApplicationEx.c.getData(paramString).toString()) {
      return "房客";
    }
    paramString = (MinsuCustomerBean)com.alibaba.fastjson.a.parseObject(paramString, MinsuCustomerBean.class);
    if (ae.isNull(paramString.data.nickName)) {
      return "房客";
    }
    return paramString.data.nickName;
  }
  
  public static String getUserName4N(String paramString)
  {
    if (ae.isNull(paramString)) {
      return "";
    }
    paramString = j.removeEMPrefix(paramString);
    if (ApplicationEx.c.getData(paramString) == null) {}
    for (paramString = ""; ae.isNull(paramString); paramString = ApplicationEx.c.getData(paramString).toString()) {
      return "";
    }
    paramString = (MinsuCustomerBean)com.alibaba.fastjson.a.parseObject(paramString, MinsuCustomerBean.class);
    if (ae.isNull(paramString.data.nickName)) {
      return "";
    }
    return paramString.data.nickName;
  }
  
  public static String getUserPic4N(String paramString)
  {
    if (ae.isNull(paramString)) {
      return "";
    }
    paramString = j.removeEMPrefix(paramString);
    if (ApplicationEx.c.getData(paramString) == null) {}
    for (paramString = ""; ae.isNull(paramString); paramString = ApplicationEx.c.getData(paramString).toString()) {
      return "";
    }
    paramString = (MinsuCustomerBean)com.alibaba.fastjson.a.parseObject(paramString, MinsuCustomerBean.class);
    if (ae.isNull(paramString.data.userPicUrl)) {
      return "";
    }
    return paramString.data.userPicUrl;
  }
  
  public static void setUserAvatar(SimpleDraweeView paramSimpleDraweeView, String paramString)
  {
    if ((paramString == null) || (paramSimpleDraweeView == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramSimpleDraweeView.getTag(2131689523);
    } while ((localObject != null) && (paramString.equals(localObject)));
    paramSimpleDraweeView.setHierarchy(com.ziroom.ziroomcustomer.minsu.f.d.getRoundingHierarchy(ApplicationEx.c));
    paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoController(paramString));
    paramSimpleDraweeView.setTag(2131689523, paramString);
  }
  
  public static void setUserInfo(Activity paramActivity, final String paramString, final SimpleDraweeView paramSimpleDraweeView, final TextView paramTextView)
  {
    if (ae.isNull(paramString)) {
      return;
    }
    String str2 = j.removeEMPrefix(paramString);
    if (ApplicationEx.c.getData(str2) == null) {}
    for (String str1 = ""; ae.isNull(str1); str1 = ApplicationEx.c.getData(str2).toString())
    {
      com.ziroom.ziroomcustomer.minsu.e.a.getCustomerVo(paramActivity, str2, new com.freelxl.baselibrary.d.c.a(new r(MinsuCustomerBean.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable) {}
        
        public void onSuccess(int paramAnonymousInt, MinsuCustomerBean paramAnonymousMinsuCustomerBean)
        {
          if ((paramAnonymousMinsuCustomerBean == null) || (!paramAnonymousMinsuCustomerBean.checkSuccessNoLogin()) || (paramAnonymousMinsuCustomerBean.data == null)) {
            return;
          }
          ApplicationEx.c.putData(paramAnonymousMinsuCustomerBean.data.uid, com.alibaba.fastjson.a.toJSONString(paramAnonymousMinsuCustomerBean));
          c.setUserInfo(paramString, paramAnonymousMinsuCustomerBean, paramSimpleDraweeView, paramTextView);
        }
      });
      return;
    }
    setUserInfo(paramString, (MinsuCustomerBean)com.alibaba.fastjson.a.parseObject(str1, MinsuCustomerBean.class), paramSimpleDraweeView, paramTextView);
  }
  
  public static void setUserInfo(String paramString, MinsuCustomerBean paramMinsuCustomerBean, SimpleDraweeView paramSimpleDraweeView, TextView paramTextView)
  {
    if (paramMinsuCustomerBean != null)
    {
      Object localObject = paramSimpleDraweeView.getTag(2131689528);
      if ((localObject != null) && (String.valueOf(localObject).equals(paramString))) {
        if (!ae.isNull(paramMinsuCustomerBean.data.nickName)) {
          break label62;
        }
      }
    }
    label62:
    for (paramString = "房客";; paramString = paramMinsuCustomerBean.data.nickName)
    {
      setUserName(paramTextView, paramString);
      setUserAvatar(paramSimpleDraweeView, paramMinsuCustomerBean.data.userPicUrl);
      return;
    }
  }
  
  public static void setUserName(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (paramString == null)) {
      return;
    }
    paramTextView.setText(paramString);
  }
  
  public static void toCustomerPage(Activity paramActivity, String paramString)
  {
    if (ApplicationEx.c.isLoginState())
    {
      k.goWeb(paramActivity, com.ziroom.ziroomcustomer.minsu.b.d.g + "/orderland/43e881/bookingDetail", paramString);
      return;
    }
    com.ziroom.commonlibrary.login.a.startLoginActivity(paramActivity);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */