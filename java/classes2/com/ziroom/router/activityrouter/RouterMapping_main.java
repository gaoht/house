package com.ziroom.router.activityrouter;

import android.content.Context;
import android.os.Bundle;
import com.ziroom.ziroomcustomer.c;
import com.ziroom.ziroomcustomer.living.LeaseAllBillActivity;
import com.ziroom.ziroomcustomer.my.MyCouponActivity;
import com.ziroom.ziroomcustomer.signed.SignerAptitudeActivity;
import com.ziroom.ziroomcustomer.signed.SignerCareerInfoActivity;
import com.ziroom.ziroomcustomer.signed.education.EducationActivity;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;

public final class RouterMapping_main
{
  public static final void map()
  {
    ExtraTypes localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrRentModule/costOfLivingBill", LeaseAllBillActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrRentModule/userCardCoupon", MyCouponActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrRentModule/educationalInfo", EducationActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrRentModule/qualificationInfo", SignerAptitudeActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrRentModule/OccupationBinding", SignerCareerInfoActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrRentModule/nameAuthenticationMethod", null, new MethodInvoker()
    {
      public void invoke(Context paramAnonymousContext, Bundle paramAnonymousBundle)
      {
        o.toCertificate(paramAnonymousContext, paramAnonymousBundle);
      }
    }, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("test/demoWithNoParams", null, new MethodInvoker()
    {
      public void invoke(Context paramAnonymousContext, Bundle paramAnonymousBundle)
      {
        c.demoWithNoParams(paramAnonymousContext, paramAnonymousBundle);
      }
    }, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    localExtraTypes.setIntExtra("id".split(","));
    localExtraTypes.setLongExtra("updatetime".split(","));
    Routers.map("test/demoWithParams", null, new MethodInvoker()
    {
      public void invoke(Context paramAnonymousContext, Bundle paramAnonymousBundle)
      {
        c.demoWithParams(paramAnonymousContext, paramAnonymousBundle);
      }
    }, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    localExtraTypes.setIntExtra("isUniCode".split(","));
    Routers.map("zrRentModule/h5WJFunction", JsBridgeWebActivity.class, null, localExtraTypes);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/RouterMapping_main.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */