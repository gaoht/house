package com.ziroom.ziroomcustomer.e.c;

import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.d;
import com.ziroom.ziroomcustomer.b.u;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;
import okhttp3.Response;

public class x
  extends com.freelxl.baselibrary.d.f.a<UserInfo>
{
  o a = new o();
  
  public static UserInfo parse(e parame)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (parame != null)
    {
      d.d("UserInfoParser", "====" + parame);
      UserInfo localUserInfo = new UserInfo();
      localObject1 = parame.getJSONObject("profile");
      if (localObject1 != null)
      {
        localUserInfo.setId(((e)localObject1).getString("id"));
        localUserInfo.setNickName(((e)localObject1).getString("nick_name"));
        localUserInfo.setGender(((e)localObject1).getIntValue("gender"));
        localUserInfo.setBirth(((e)localObject1).getString("birth"));
        localUserInfo.setNation(((e)localObject1).getString("nation"));
        localUserInfo.setInterest(com.alibaba.fastjson.a.parseArray(((e)localObject1).getString("interest"), String.class));
        localUserInfo.setHeadImg(((e)localObject1).getString("head_img"));
        localUserInfo.setNationality(((e)localObject1).getString("nationality"));
        localUserInfo.setLocation(((e)localObject1).getString("location"));
        localUserInfo.setMarriage(((e)localObject1).getIntValue("marriage"));
        localUserInfo.setJob(((e)localObject1).getString("job"));
        localUserInfo.setProfessional(((e)localObject1).getString("professional"));
        localUserInfo.setPosition(((e)localObject1).getString("position"));
        localUserInfo.setOrigin(((e)localObject1).getIntValue("origin"));
        localUserInfo.setCompany(((e)localObject1).getString("company"));
      }
      localObject1 = parame.getJSONObject("cert");
      if (localObject1 != null) {
        localUserInfo.setRealName(((e)localObject1).getString("real_name"));
      }
      e locale = parame.getJSONObject("SSO_info");
      localObject1 = localObject2;
      if (locale != null)
      {
        localObject1 = locale.getString("uid");
        localUserInfo.setUid((String)localObject1);
        localUserInfo.setCreateTime(locale.getLongValue("createTime"));
        localUserInfo.setUsername(locale.getString("username"));
        localUserInfo.setPhone(locale.getString("phone"));
        localUserInfo.setLastOnlineTime(locale.getLongValue("lastOnlineTime"));
        localUserInfo.setStatus(locale.getIntValue("status"));
        localUserInfo.setEmail(locale.getString("email"));
        localUserInfo.setEmailChecked(locale.getIntValue("emailChecked"));
        localUserInfo.setPhoneChecked(locale.getIntValue("phoneChecked"));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        u.saveUserInfo(ApplicationEx.c, (String)localObject1, parame.toJSONString());
      }
      localObject1 = localUserInfo;
    }
    return (UserInfo)localObject1;
  }
  
  protected UserInfo a(Response paramResponse)
    throws Exception
  {
    return parse(this.a.a(paramResponse));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/e/c/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */