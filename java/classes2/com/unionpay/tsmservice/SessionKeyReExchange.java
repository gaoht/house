package com.unionpay.tsmservice;

import android.content.Context;
import android.os.RemoteException;
import com.unionpay.tsmservice.request.AppDataUpdateRequestParams;
import com.unionpay.tsmservice.request.AppDeleteRequestParams;
import com.unionpay.tsmservice.request.AppDownloadApplyRequestParams;
import com.unionpay.tsmservice.request.AppDownloadRequestParams;
import com.unionpay.tsmservice.request.AppLockRequestParams;
import com.unionpay.tsmservice.request.AppUnlockRequestParams;
import com.unionpay.tsmservice.request.CheckSSamsungPayRequestParams;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.ECashTopUpRequestParams;
import com.unionpay.tsmservice.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.request.ExecuteCmdRequestParams;
import com.unionpay.tsmservice.request.GetAccountBalanceRequestParams;
import com.unionpay.tsmservice.request.GetAccountInfoRequestParams;
import com.unionpay.tsmservice.request.GetAppDetailRequestParams;
import com.unionpay.tsmservice.request.GetAppListRequestParams;
import com.unionpay.tsmservice.request.GetAppStatusRequestParams;
import com.unionpay.tsmservice.request.GetAssociatedAppRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoRequestParams;
import com.unionpay.tsmservice.request.GetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.GetSMSAuthCodeRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import com.unionpay.tsmservice.request.GetTransRecordRequestParams;
import com.unionpay.tsmservice.request.HideAppApplyRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.RequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.SetDefaultCardRequestParams;
import com.unionpay.tsmservice.utils.IUPJniInterface;

public class SessionKeyReExchange
{
  private UPTsmAddon a;
  private int b = -1;
  private RequestParams c;
  private ITsmCallback d;
  private ITsmProgressCallback e;
  private int f = 1000;
  
  public SessionKeyReExchange(UPTsmAddon paramUPTsmAddon, int paramInt, ITsmCallback paramITsmCallback)
  {
    this(paramUPTsmAddon, paramInt, null, paramITsmCallback);
  }
  
  public SessionKeyReExchange(UPTsmAddon paramUPTsmAddon, int paramInt, RequestParams paramRequestParams, ITsmCallback paramITsmCallback)
  {
    this(paramUPTsmAddon, paramInt, paramRequestParams, paramITsmCallback, null);
  }
  
  public SessionKeyReExchange(UPTsmAddon paramUPTsmAddon, int paramInt, RequestParams paramRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
  {
    this(paramUPTsmAddon, paramInt, paramRequestParams, paramITsmCallback, null, 1000);
  }
  
  public SessionKeyReExchange(UPTsmAddon paramUPTsmAddon, int paramInt1, RequestParams paramRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback, int paramInt2)
  {
    this.a = paramUPTsmAddon;
    this.b = paramInt1;
    this.c = paramRequestParams;
    this.d = paramITsmCallback;
    this.e = paramITsmProgressCallback;
    this.f = paramInt2;
  }
  
  public int reExchangeKey()
    throws RemoteException
  {
    Object localObject1 = new String[1];
    int i = this.a.getPubKey(1000, (String[])localObject1);
    if (i != 0) {
      return i;
    }
    Object localObject2 = IUPJniInterface.rER(localObject1[0], IUPJniInterface.mSK());
    i = this.a.exchangeKey((String)localObject2, (String[])localObject1);
    if (i != 0) {
      return i;
    }
    localObject1 = IUPJniInterface.dMG(localObject1[0]);
    IUPJniInterface.sSK((String)localObject1);
    localObject2 = this.a.getContext();
    if (localObject2 != null) {
      IUPJniInterface.uSKT(((Context)localObject2).getPackageName(), (String)localObject1);
    }
    switch (this.b)
    {
    default: 
      return 0;
    case 0: 
      localObject1 = (InitRequestParams)this.c;
      return this.a.init((InitRequestParams)localObject1, this.d);
    case 1: 
      localObject1 = (GetAssociatedAppRequestParams)this.c;
      return this.a.getAssociatedApp((GetAssociatedAppRequestParams)localObject1, this.d);
    case 15: 
      localObject1 = (AppDownloadApplyRequestParams)this.c;
      return this.a.appDownloadApply((AppDownloadApplyRequestParams)localObject1, this.d);
    case 17: 
      localObject1 = (AppDeleteRequestParams)this.c;
      return this.a.appDelete((AppDeleteRequestParams)localObject1, this.d, this.e);
    case 11: 
      localObject1 = (GetSMSAuthCodeRequestParams)this.c;
      return this.a.getSMSAuthCode((GetSMSAuthCodeRequestParams)localObject1, this.d);
    case 4: 
      localObject1 = (GetAppDetailRequestParams)this.c;
      return this.a.getAppDetail((GetAppDetailRequestParams)localObject1, this.d);
    case 9: 
      localObject1 = (GetTransElementsRequestParams)this.c;
      return this.a.getTransElements((GetTransElementsRequestParams)localObject1, this.d);
    case 16: 
      localObject1 = (AppDownloadRequestParams)this.c;
      return this.a.appDownload((AppDownloadRequestParams)localObject1, this.d, this.e);
    case 18: 
      localObject1 = (AppDataUpdateRequestParams)this.c;
      return this.a.appDataUpdate((AppDataUpdateRequestParams)localObject1, this.d, this.e);
    case 19: 
      localObject1 = (ECashTopUpRequestParams)this.c;
      return this.a.eCashTopUp((ECashTopUpRequestParams)localObject1, this.d);
    case 10: 
      localObject1 = (GetTransRecordRequestParams)this.c;
      return this.a.getTransRecord((GetTransRecordRequestParams)localObject1, this.d);
    case 7: 
      localObject1 = (GetAccountInfoRequestParams)this.c;
      return this.a.getAccountInfo((GetAccountInfoRequestParams)localObject1, this.d);
    case 8: 
      localObject1 = (GetAccountBalanceRequestParams)this.c;
      return this.a.getAccountBalance((GetAccountBalanceRequestParams)localObject1, this.d);
    case 6: 
      localObject1 = (GetCardInfoRequestParams)this.c;
      return this.a.getCardInfo((GetCardInfoRequestParams)localObject1, this.d);
    case 14: 
      localObject1 = (SetDefaultCardRequestParams)this.c;
      return this.a.setDefaultCard((SetDefaultCardRequestParams)localObject1, this.d);
    case 20: 
      localObject1 = (OpenChannelRequestParams)this.c;
      return this.a.openChannel((OpenChannelRequestParams)localObject1, this.d);
    case 22: 
      localObject1 = (SendApduRequestParams)this.c;
      return this.a.sendApdu((SendApduRequestParams)localObject1, this.d);
    case 21: 
      localObject1 = (CloseChannelRequestParams)this.c;
      return this.a.closeChannel((CloseChannelRequestParams)localObject1, this.d);
    case 24: 
      localObject1 = (HideAppApplyRequestParams)this.c;
      return this.a.hideAppApply((HideAppApplyRequestParams)localObject1, this.d);
    case 12: 
      localObject1 = (GetSeIdRequestParams)this.c;
      return this.a.getSeId((GetSeIdRequestParams)localObject1, this.d);
    case 13: 
      localObject1 = (GetDefaultCardRequestParams)this.c;
      return this.a.getDefaultCard((GetDefaultCardRequestParams)localObject1, this.d);
    case 3: 
      localObject1 = (GetSeAppListRequestParams)this.c;
      return this.a.getSEAppList((GetSeAppListRequestParams)localObject1, this.d);
    case 2: 
      localObject1 = (GetAppListRequestParams)this.c;
      return this.a.getAppList((GetAppListRequestParams)localObject1, this.d);
    case 5: 
      localObject1 = (GetAppStatusRequestParams)this.c;
      return this.a.getAppStatus((GetAppStatusRequestParams)localObject1, this.d);
    case 26: 
      localObject1 = (AppLockRequestParams)this.c;
      return this.a.appLock((AppLockRequestParams)localObject1, this.d);
    case 27: 
      localObject1 = (AppUnlockRequestParams)this.c;
      return this.a.appUnlock((AppUnlockRequestParams)localObject1, this.d);
    case 23: 
      localObject1 = (EncryptDataRequestParams)this.c;
      return this.a.encryptData((EncryptDataRequestParams)localObject1, this.d);
    case 25: 
      localObject1 = (ExecuteCmdRequestParams)this.c;
      return this.a.executeCmd((ExecuteCmdRequestParams)localObject1, this.d, this.e);
    case 28: 
      localObject1 = (GetCardInfoBySpayRequestParams)this.c;
      return this.a.getCardInfoBySamsungPay((GetCardInfoBySpayRequestParams)localObject1, this.d);
    }
    localObject1 = (CheckSSamsungPayRequestParams)this.c;
    return this.a.checkSSamsungPay((CheckSSamsungPayRequestParams)localObject1, this.d);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/SessionKeyReExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */