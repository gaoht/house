package com.ziroom.router.activityrouter;

import android.content.Context;
import android.os.Bundle;
import com.ziroom.credit.b.b;
import com.ziroom.credit.b.c;
import com.ziroom.credit.main.CreditEducationInfoActivity;
import com.ziroom.credit.main.CreditEquityActivity;
import com.ziroom.credit.main.CreditIdentifyInfoActivity;
import com.ziroom.credit.main.CreditMangerActivity;
import com.ziroom.credit.main.CreditMedalDetailActivity;
import com.ziroom.credit.main.CreditMyMedalActivity;
import com.ziroom.credit.main.CreditNegativeRecordActivity;
import com.ziroom.credit.main.CreditScoreActivity;
import com.ziroom.credit.main.CreditScoreAnalysisActivity;
import com.ziroom.credit.main.CreditScoreAuthorizationActivity;
import com.ziroom.credit.main.CreditScorePromoteActivity;
import com.ziroom.credit.main.CreditThirdAuthorizationActivity;
import com.ziroom.credit.main.CreditWebViewActivity;
import com.ziroom.credit.main.CreditWorkInfoActivity;

public final class RouterMapping_credit
{
  public static final void map()
  {
    ExtraTypes localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/educationView", CreditEducationInfoActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/benefitListView", CreditEquityActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/identifyInfoView", CreditIdentifyInfoActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/managerListView", CreditMangerActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    localExtraTypes.setIntExtra("isGet".split(","));
    Routers.map("zrCreditModule/medalDetailView", CreditMedalDetailActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/medalListView", CreditMyMedalActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/negativeListView", CreditNegativeRecordActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/homeView", CreditScoreActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/scoreInterpretationView", CreditScoreAnalysisActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    localExtraTypes.setIntExtra("CreditStatic".split(","));
    Routers.map("zrCreditModule/impowerView", CreditScoreAuthorizationActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/scorePromoteView", CreditScorePromoteActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/authorizationView", CreditThirdAuthorizationActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/zmAuthorizationView", CreditWebViewActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/workView", CreditWorkInfoActivity.class, null, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    localExtraTypes.setIntExtra("requestCode,resultCode".split(","));
    Routers.map("zrCreditModule/zmAuthenticationResult", null, new MethodInvoker()
    {
      public void invoke(Context paramAnonymousContext, Bundle paramAnonymousBundle)
      {
        b.onActivityResult(paramAnonymousContext, paramAnonymousBundle);
      }
    }, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    localExtraTypes.setIntExtra("certType,userSex,source,isEnterprise".split(","));
    Routers.map("zrCreditModule/zmAuthentication", null, new MethodInvoker()
    {
      public void invoke(Context paramAnonymousContext, Bundle paramAnonymousBundle)
      {
        b.getUserCreditStatus(paramAnonymousContext, paramAnonymousBundle);
      }
    }, localExtraTypes);
    localExtraTypes = new ExtraTypes();
    localExtraTypes.setTransfer(null);
    Routers.map("zrCreditModule/home", null, new MethodInvoker()
    {
      public void invoke(Context paramAnonymousContext, Bundle paramAnonymousBundle)
      {
        c.GotoCreditMainActivity(paramAnonymousContext, paramAnonymousBundle);
      }
    }, localExtraTypes);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/router/activityrouter/RouterMapping_credit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */