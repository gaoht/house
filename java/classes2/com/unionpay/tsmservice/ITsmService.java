package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
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
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.SetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.SetSamsungDefWalletRequestParams;

public abstract interface ITsmService
  extends IInterface
{
  public abstract int appDataUpdate(AppDataUpdateRequestParams paramAppDataUpdateRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
    throws RemoteException;
  
  public abstract int appDelete(AppDeleteRequestParams paramAppDeleteRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
    throws RemoteException;
  
  public abstract int appDownload(AppDownloadRequestParams paramAppDownloadRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
    throws RemoteException;
  
  public abstract int appDownloadApply(AppDownloadApplyRequestParams paramAppDownloadApplyRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int appLock(AppLockRequestParams paramAppLockRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int appUnlock(AppUnlockRequestParams paramAppUnlockRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int checkSSamsungPay(CheckSSamsungPayRequestParams paramCheckSSamsungPayRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int closeChannel(CloseChannelRequestParams paramCloseChannelRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int eCashTopUp(ECashTopUpRequestParams paramECashTopUpRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int encryptData(EncryptDataRequestParams paramEncryptDataRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int exchangeKey(String paramString, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract int executeCmd(ExecuteCmdRequestParams paramExecuteCmdRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
    throws RemoteException;
  
  public abstract int getAccountBalance(GetAccountBalanceRequestParams paramGetAccountBalanceRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getAccountInfo(GetAccountInfoRequestParams paramGetAccountInfoRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getAppDetail(GetAppDetailRequestParams paramGetAppDetailRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getAppList(GetAppListRequestParams paramGetAppListRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getAppStatus(GetAppStatusRequestParams paramGetAppStatusRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getAssociatedApp(GetAssociatedAppRequestParams paramGetAssociatedAppRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getCardInfo(GetCardInfoRequestParams paramGetCardInfoRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams paramGetCardInfoBySpayRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getDefaultCard(GetDefaultCardRequestParams paramGetDefaultCardRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getPubKey(int paramInt, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract int getSEAppList(GetSeAppListRequestParams paramGetSeAppListRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getSEId(GetSeIdRequestParams paramGetSeIdRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getSMSAuthCode(GetSMSAuthCodeRequestParams paramGetSMSAuthCodeRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getTransElements(GetTransElementsRequestParams paramGetTransElementsRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int getTransRecord(GetTransRecordRequestParams paramGetTransRecordRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int hideAppApply(HideAppApplyRequestParams paramHideAppApplyRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int init(InitRequestParams paramInitRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int openChannel(OpenChannelRequestParams paramOpenChannelRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int sendApdu(SendApduRequestParams paramSendApduRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int setDefaultCard(SetDefaultCardRequestParams paramSetDefaultCardRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public abstract int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams paramSetSamsungDefWalletRequestParams, ITsmCallback paramITsmCallback)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ITsmService
  {
    public Stub()
    {
      attachInterface(this, "com.unionpay.tsmservice.ITsmService");
    }
    
    public static ITsmService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.unionpay.tsmservice.ITsmService");
      if ((localIInterface != null) && ((localIInterface instanceof ITsmService))) {
        return (ITsmService)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject9 = null;
      Object localObject10 = null;
      Object localObject11 = null;
      Object localObject12 = null;
      Object localObject13 = null;
      Object localObject14 = null;
      Object localObject15 = null;
      Object localObject16 = null;
      Object localObject17 = null;
      Object localObject18 = null;
      Object localObject19 = null;
      Object localObject20 = null;
      Object localObject21 = null;
      Object localObject22 = null;
      Object localObject23 = null;
      Object localObject24 = null;
      Object localObject25 = null;
      Object localObject26 = null;
      Object localObject27 = null;
      Object localObject28 = null;
      Object localObject29 = null;
      Object localObject30 = null;
      Object localObject31 = null;
      Object localObject32 = null;
      String str = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.unionpay.tsmservice.ITsmService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = str;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (InitRequestParams)InitRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = init((InitRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        paramInt1 = paramParcel1.readInt();
        paramInt2 = paramParcel1.readInt();
        if (paramInt2 < 0) {}
        for (paramParcel1 = (Parcel)localObject2;; paramParcel1 = new String[paramInt2])
        {
          paramInt1 = getPubKey(paramInt1, paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          paramParcel2.writeStringArray(paramParcel1);
          return true;
        }
      case 3: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        str = paramParcel1.readString();
        paramInt1 = paramParcel1.readInt();
        if (paramInt1 < 0) {}
        for (paramParcel1 = (Parcel)localObject1;; paramParcel1 = new String[paramInt1])
        {
          paramInt1 = exchangeKey(str, paramParcel1);
          paramParcel2.writeNoException();
          paramParcel2.writeInt(paramInt1);
          paramParcel2.writeStringArray(paramParcel1);
          return true;
        }
      case 4: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject3;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (EncryptDataRequestParams)EncryptDataRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = encryptData((EncryptDataRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject4;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetSeIdRequestParams)GetSeIdRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getSEId((GetSeIdRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject5;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetAssociatedAppRequestParams)GetAssociatedAppRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getAssociatedApp((GetAssociatedAppRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject6;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetSeAppListRequestParams)GetSeAppListRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getSEAppList((GetSeAppListRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject7;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetAppListRequestParams)GetAppListRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getAppList((GetAppListRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject8;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetAppStatusRequestParams)GetAppStatusRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getAppStatus((GetAppStatusRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject9;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetAppDetailRequestParams)GetAppDetailRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getAppDetail((GetAppDetailRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject10;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetTransElementsRequestParams)GetTransElementsRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getTransElements((GetTransElementsRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject11;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (AppDownloadApplyRequestParams)AppDownloadApplyRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = appDownloadApply((AppDownloadApplyRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject12;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (AppDownloadRequestParams)AppDownloadRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = appDownload((AppDownloadRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject13;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (AppDeleteRequestParams)AppDeleteRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = appDelete((AppDeleteRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject14;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (AppDataUpdateRequestParams)AppDataUpdateRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = appDataUpdate((AppDataUpdateRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject15;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (AppLockRequestParams)AppLockRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = appLock((AppLockRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject16;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (AppUnlockRequestParams)AppUnlockRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = appUnlock((AppUnlockRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 18: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject17;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetSMSAuthCodeRequestParams)GetSMSAuthCodeRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getSMSAuthCode((GetSMSAuthCodeRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject18;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (ECashTopUpRequestParams)ECashTopUpRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = eCashTopUp((ECashTopUpRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject19;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetTransRecordRequestParams)GetTransRecordRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getTransRecord((GetTransRecordRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject20;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetAccountInfoRequestParams)GetAccountInfoRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getAccountInfo((GetAccountInfoRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject21;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetAccountBalanceRequestParams)GetAccountBalanceRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getAccountBalance((GetAccountBalanceRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject22;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetCardInfoRequestParams)GetCardInfoRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getCardInfo((GetCardInfoRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject23;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (SetDefaultCardRequestParams)SetDefaultCardRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = setDefaultCard((SetDefaultCardRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject24;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetDefaultCardRequestParams)GetDefaultCardRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getDefaultCard((GetDefaultCardRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject25;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (OpenChannelRequestParams)OpenChannelRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = openChannel((OpenChannelRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject26;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (SendApduRequestParams)SendApduRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = sendApdu((SendApduRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject27;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CloseChannelRequestParams)CloseChannelRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = closeChannel((CloseChannelRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject28;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (HideAppApplyRequestParams)HideAppApplyRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = hideAppApply((HideAppApplyRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject29;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (ExecuteCmdRequestParams)ExecuteCmdRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = executeCmd((ExecuteCmdRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject30;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GetCardInfoBySpayRequestParams)GetCardInfoBySpayRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = getCardInfoBySamsungPay((GetCardInfoBySpayRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 32: 
        paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
        localObject1 = localObject31;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (CheckSSamsungPayRequestParams)CheckSSamsungPayRequestParams.CREATOR.createFromParcel(paramParcel1);
        }
        paramInt1 = checkSSamsungPay((CheckSSamsungPayRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.unionpay.tsmservice.ITsmService");
      localObject1 = localObject32;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (SetSamsungDefWalletRequestParams)SetSamsungDefWalletRequestParams.CREATOR.createFromParcel(paramParcel1);
      }
      paramInt1 = setSamsungDefaultWallet((SetSamsungDefWalletRequestParams)localObject1, ITsmCallback.Stub.asInterface(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    private static final class a
      implements ITsmService
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public final int appDataUpdate(AppDataUpdateRequestParams paramAppDataUpdateRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramAppDataUpdateRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramAppDataUpdateRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramAppDataUpdateRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramAppDataUpdateRequestParams);
                paramAppDataUpdateRequestParams = (AppDataUpdateRequestParams)localObject;
                if (paramITsmProgressCallback != null) {
                  paramAppDataUpdateRequestParams = paramITsmProgressCallback.asBinder();
                }
                localParcel1.writeStrongBinder(paramAppDataUpdateRequestParams);
                this.a.transact(15, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAppDataUpdateRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int appDelete(AppDeleteRequestParams paramAppDeleteRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramAppDeleteRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramAppDeleteRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramAppDeleteRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramAppDeleteRequestParams);
                paramAppDeleteRequestParams = (AppDeleteRequestParams)localObject;
                if (paramITsmProgressCallback != null) {
                  paramAppDeleteRequestParams = paramITsmProgressCallback.asBinder();
                }
                localParcel1.writeStrongBinder(paramAppDeleteRequestParams);
                this.a.transact(14, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAppDeleteRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int appDownload(AppDownloadRequestParams paramAppDownloadRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramAppDownloadRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramAppDownloadRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramAppDownloadRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramAppDownloadRequestParams);
                paramAppDownloadRequestParams = (AppDownloadRequestParams)localObject;
                if (paramITsmProgressCallback != null) {
                  paramAppDownloadRequestParams = paramITsmProgressCallback.asBinder();
                }
                localParcel1.writeStrongBinder(paramAppDownloadRequestParams);
                this.a.transact(13, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAppDownloadRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int appDownloadApply(AppDownloadApplyRequestParams paramAppDownloadApplyRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramAppDownloadApplyRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramAppDownloadApplyRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramAppDownloadApplyRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramAppDownloadApplyRequestParams);
                this.a.transact(12, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAppDownloadApplyRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int appLock(AppLockRequestParams paramAppLockRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramAppLockRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramAppLockRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramAppLockRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramAppLockRequestParams);
                this.a.transact(16, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAppLockRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int appUnlock(AppUnlockRequestParams paramAppUnlockRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramAppUnlockRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramAppUnlockRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramAppUnlockRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramAppUnlockRequestParams);
                this.a.transact(17, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramAppUnlockRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final IBinder asBinder()
      {
        return this.a;
      }
      
      public final int checkSSamsungPay(CheckSSamsungPayRequestParams paramCheckSSamsungPayRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramCheckSSamsungPayRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramCheckSSamsungPayRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramCheckSSamsungPayRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramCheckSSamsungPayRequestParams);
                this.a.transact(32, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramCheckSSamsungPayRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int closeChannel(CloseChannelRequestParams paramCloseChannelRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramCloseChannelRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramCloseChannelRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramCloseChannelRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramCloseChannelRequestParams);
                this.a.transact(28, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramCloseChannelRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int eCashTopUp(ECashTopUpRequestParams paramECashTopUpRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramECashTopUpRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramECashTopUpRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramECashTopUpRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramECashTopUpRequestParams);
                this.a.transact(19, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramECashTopUpRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int encryptData(EncryptDataRequestParams paramEncryptDataRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramEncryptDataRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramEncryptDataRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramEncryptDataRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramEncryptDataRequestParams);
                this.a.transact(4, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramEncryptDataRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public final int exchangeKey(String paramString, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 31
        //   14: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: aload_1
        //   20: invokevirtual 124	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload_2
        //   24: ifnonnull +54 -> 78
        //   27: aload 4
        //   29: iconst_m1
        //   30: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   33: aload_0
        //   34: getfield 18	com/unionpay/tsmservice/ITsmService$Stub$a:a	Landroid/os/IBinder;
        //   37: iconst_3
        //   38: aload 4
        //   40: aload 5
        //   42: iconst_0
        //   43: invokeinterface 63 5 0
        //   48: pop
        //   49: aload 5
        //   51: invokevirtual 66	android/os/Parcel:readException	()V
        //   54: aload 5
        //   56: invokevirtual 70	android/os/Parcel:readInt	()I
        //   59: istore_3
        //   60: aload 5
        //   62: aload_2
        //   63: invokevirtual 128	android/os/Parcel:readStringArray	([Ljava/lang/String;)V
        //   66: aload 5
        //   68: invokevirtual 73	android/os/Parcel:recycle	()V
        //   71: aload 4
        //   73: invokevirtual 73	android/os/Parcel:recycle	()V
        //   76: iload_3
        //   77: ireturn
        //   78: aload 4
        //   80: aload_2
        //   81: arraylength
        //   82: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   85: goto -52 -> 33
        //   88: astore_1
        //   89: aload 5
        //   91: invokevirtual 73	android/os/Parcel:recycle	()V
        //   94: aload 4
        //   96: invokevirtual 73	android/os/Parcel:recycle	()V
        //   99: aload_1
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	a
        //   0	101	1	paramString	String
        //   0	101	2	paramArrayOfString	String[]
        //   59	18	3	i	int
        //   3	92	4	localParcel1	Parcel
        //   8	82	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	88	finally
        //   27	33	88	finally
        //   33	66	88	finally
        //   78	85	88	finally
      }
      
      public final int executeCmd(ExecuteCmdRequestParams paramExecuteCmdRequestParams, ITsmCallback paramITsmCallback, ITsmProgressCallback paramITsmProgressCallback)
        throws RemoteException
      {
        Object localObject = null;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramExecuteCmdRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramExecuteCmdRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramExecuteCmdRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramExecuteCmdRequestParams);
                paramExecuteCmdRequestParams = (ExecuteCmdRequestParams)localObject;
                if (paramITsmProgressCallback != null) {
                  paramExecuteCmdRequestParams = paramITsmProgressCallback.asBinder();
                }
                localParcel1.writeStrongBinder(paramExecuteCmdRequestParams);
                this.a.transact(30, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramExecuteCmdRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getAccountBalance(GetAccountBalanceRequestParams paramGetAccountBalanceRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetAccountBalanceRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetAccountBalanceRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetAccountBalanceRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetAccountBalanceRequestParams);
                this.a.transact(22, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetAccountBalanceRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getAccountInfo(GetAccountInfoRequestParams paramGetAccountInfoRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetAccountInfoRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetAccountInfoRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetAccountInfoRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetAccountInfoRequestParams);
                this.a.transact(21, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetAccountInfoRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getAppDetail(GetAppDetailRequestParams paramGetAppDetailRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetAppDetailRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetAppDetailRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetAppDetailRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetAppDetailRequestParams);
                this.a.transact(10, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetAppDetailRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getAppList(GetAppListRequestParams paramGetAppListRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetAppListRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetAppListRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetAppListRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetAppListRequestParams);
                this.a.transact(8, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetAppListRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getAppStatus(GetAppStatusRequestParams paramGetAppStatusRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetAppStatusRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetAppStatusRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetAppStatusRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetAppStatusRequestParams);
                this.a.transact(9, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetAppStatusRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getAssociatedApp(GetAssociatedAppRequestParams paramGetAssociatedAppRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetAssociatedAppRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetAssociatedAppRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetAssociatedAppRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetAssociatedAppRequestParams);
                this.a.transact(6, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetAssociatedAppRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getCardInfo(GetCardInfoRequestParams paramGetCardInfoRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetCardInfoRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetCardInfoRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetCardInfoRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetCardInfoRequestParams);
                this.a.transact(23, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetCardInfoRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams paramGetCardInfoBySpayRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetCardInfoBySpayRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetCardInfoBySpayRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetCardInfoBySpayRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetCardInfoBySpayRequestParams);
                this.a.transact(31, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetCardInfoBySpayRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getDefaultCard(GetDefaultCardRequestParams paramGetDefaultCardRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetDefaultCardRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetDefaultCardRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetDefaultCardRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetDefaultCardRequestParams);
                this.a.transact(25, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetDefaultCardRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public final int getPubKey(int paramInt, String[] paramArrayOfString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 29	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 31
        //   12: invokevirtual 35	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnonnull +51 -> 72
        //   24: aload_3
        //   25: iconst_m1
        //   26: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   29: aload_0
        //   30: getfield 18	com/unionpay/tsmservice/ITsmService$Stub$a:a	Landroid/os/IBinder;
        //   33: iconst_2
        //   34: aload_3
        //   35: aload 4
        //   37: iconst_0
        //   38: invokeinterface 63 5 0
        //   43: pop
        //   44: aload 4
        //   46: invokevirtual 66	android/os/Parcel:readException	()V
        //   49: aload 4
        //   51: invokevirtual 70	android/os/Parcel:readInt	()I
        //   54: istore_1
        //   55: aload 4
        //   57: aload_2
        //   58: invokevirtual 128	android/os/Parcel:readStringArray	([Ljava/lang/String;)V
        //   61: aload 4
        //   63: invokevirtual 73	android/os/Parcel:recycle	()V
        //   66: aload_3
        //   67: invokevirtual 73	android/os/Parcel:recycle	()V
        //   70: iload_1
        //   71: ireturn
        //   72: aload_3
        //   73: aload_2
        //   74: arraylength
        //   75: invokevirtual 39	android/os/Parcel:writeInt	(I)V
        //   78: goto -49 -> 29
        //   81: astore_2
        //   82: aload 4
        //   84: invokevirtual 73	android/os/Parcel:recycle	()V
        //   87: aload_3
        //   88: invokevirtual 73	android/os/Parcel:recycle	()V
        //   91: aload_2
        //   92: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	93	0	this	a
        //   0	93	1	paramInt	int
        //   0	93	2	paramArrayOfString	String[]
        //   3	85	3	localParcel1	Parcel
        //   7	76	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	81	finally
        //   24	29	81	finally
        //   29	61	81	finally
        //   72	78	81	finally
      }
      
      public final int getSEAppList(GetSeAppListRequestParams paramGetSeAppListRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetSeAppListRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetSeAppListRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetSeAppListRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetSeAppListRequestParams);
                this.a.transact(7, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetSeAppListRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getSEId(GetSeIdRequestParams paramGetSeIdRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetSeIdRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetSeIdRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetSeIdRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetSeIdRequestParams);
                this.a.transact(5, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetSeIdRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getSMSAuthCode(GetSMSAuthCodeRequestParams paramGetSMSAuthCodeRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetSMSAuthCodeRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetSMSAuthCodeRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetSMSAuthCodeRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetSMSAuthCodeRequestParams);
                this.a.transact(18, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetSMSAuthCodeRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getTransElements(GetTransElementsRequestParams paramGetTransElementsRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetTransElementsRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetTransElementsRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetTransElementsRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetTransElementsRequestParams);
                this.a.transact(11, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetTransElementsRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int getTransRecord(GetTransRecordRequestParams paramGetTransRecordRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramGetTransRecordRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramGetTransRecordRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramGetTransRecordRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramGetTransRecordRequestParams);
                this.a.transact(20, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramGetTransRecordRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int hideAppApply(HideAppApplyRequestParams paramHideAppApplyRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramHideAppApplyRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramHideAppApplyRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramHideAppApplyRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramHideAppApplyRequestParams);
                this.a.transact(29, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramHideAppApplyRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int init(InitRequestParams paramInitRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramInitRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramInitRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramInitRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramInitRequestParams);
                this.a.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramInitRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int openChannel(OpenChannelRequestParams paramOpenChannelRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramOpenChannelRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramOpenChannelRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramOpenChannelRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramOpenChannelRequestParams);
                this.a.transact(26, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramOpenChannelRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int sendApdu(SendApduRequestParams paramSendApduRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramSendApduRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramSendApduRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramSendApduRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramSendApduRequestParams);
                this.a.transact(27, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramSendApduRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int setDefaultCard(SetDefaultCardRequestParams paramSetDefaultCardRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramSetDefaultCardRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramSetDefaultCardRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramSetDefaultCardRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramSetDefaultCardRequestParams);
                this.a.transact(24, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramSetDefaultCardRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public final int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams paramSetSamsungDefWalletRequestParams, ITsmCallback paramITsmCallback)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
            if (paramSetSamsungDefWalletRequestParams != null)
            {
              localParcel1.writeInt(1);
              paramSetSamsungDefWalletRequestParams.writeToParcel(localParcel1, 0);
              if (paramITsmCallback != null)
              {
                paramSetSamsungDefWalletRequestParams = paramITsmCallback.asBinder();
                localParcel1.writeStrongBinder(paramSetSamsungDefWalletRequestParams);
                this.a.transact(33, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                return i;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramSetSamsungDefWalletRequestParams = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/tsmservice/ITsmService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */