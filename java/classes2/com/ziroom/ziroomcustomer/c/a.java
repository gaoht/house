package com.ziroom.ziroomcustomer.c;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.itrus.raapi.implement.CACertInfo;
import com.itrus.raapi.implement.ClientForAndroid;
import com.itrus.raapi.implement.UserInfo;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import java.util.HashMap;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class a
{
  private String a = "";
  private String b = "";
  private SoapSerializationEnvelope c = null;
  private HttpTransportSE d = null;
  private Context e;
  
  public a(Context paramContext, String paramString1, String paramString2)
  {
    this.e = paramContext;
    if (!TextUtils.isEmpty(paramString1)) {
      this.a = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.b = paramString2;
    }
    this.c = new SoapSerializationEnvelope(110);
    this.c.encodingStyle = "UTF-8";
    this.d = new HttpTransportSE(paramString1);
  }
  
  public a(String paramString1, String paramString2, Activity paramActivity)
  {
    this.e = paramActivity;
    if (!TextUtils.isEmpty(paramString1)) {
      this.a = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.b = paramString2;
    }
    this.c = new SoapSerializationEnvelope(110);
    this.c.encodingStyle = "UTF-8";
    this.d = new HttpTransportSE(paramString1);
  }
  
  public String enrollCert(String paramString1, UserInfo paramUserInfo, String paramString2, String paramString3, String paramString4)
  {
    int i;
    if (("1".equalsIgnoreCase(paramString4)) || ("passCodeMode".equalsIgnoreCase(paramString2)))
    {
      paramString4 = this.a + "/" + "enrollCertAA";
      paramString2 = "365";
      localObject = new StringBuilder().append("{'certValidity':'");
      if ("365" == null) {
        paramString2 = "";
      }
      paramString2 = paramString2 + "'}";
      localObject = new SoapObject(this.a, "enrollCertAA");
      PropertyInfo localPropertyInfo = new PropertyInfo();
      localPropertyInfo.setName("userInfo");
      localPropertyInfo.setType(UserInfo.class);
      localPropertyInfo.setValue(paramUserInfo);
      ((SoapObject)localObject).addProperty(localPropertyInfo);
      ((SoapObject)localObject).addProperty("certReqBuf", paramString1);
      ((SoapObject)localObject).addProperty("accountHash", this.b);
      ((SoapObject)localObject).addProperty("aaCheckPoint", paramString3);
      ((SoapObject)localObject).addProperty("json", paramString2);
      this.c.bodyOut = localObject;
      this.c.setOutputSoapObject(localObject);
      try
      {
        this.d.call(paramString4, this.c);
        paramUserInfo = (SoapObject)this.c.getResponse();
        paramString1 = "";
        i = 0;
        if (i < paramUserInfo.getPropertyCount())
        {
          paramString2 = new PropertyInfo();
          paramUserInfo.getPropertyInfo(i, paramString2);
          if (!paramString2.getName().equalsIgnoreCase("certSignBuf")) {
            break label603;
          }
          paramString1 = paramString2.getValue().toString();
          break label603;
        }
        paramString1 = "$OKOKOK$" + paramString1;
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return "申请证书失败，原因:" + paramString1.getMessage();
      }
    }
    paramString2 = "365";
    paramString4 = this.a + "/" + "enrollCert";
    Object localObject = new StringBuilder().append("{'certValidity':'");
    if ("365" == null) {
      paramString2 = "";
    }
    paramString2 = paramString2 + "'}";
    localObject = new SoapObject(this.a, "enrollCert");
    ((SoapObject)localObject).addProperty("userInfo", paramUserInfo);
    ((SoapObject)localObject).addProperty("certReqBuf", paramString1);
    ((SoapObject)localObject).addProperty("certReqChallenge", paramString3);
    ((SoapObject)localObject).addProperty("accountHash", this.b);
    ((SoapObject)localObject).addProperty("json", paramString2);
    this.c.bodyOut = localObject;
    this.c.setOutputSoapObject(localObject);
    for (;;)
    {
      try
      {
        this.d.call(paramString4, this.c);
        paramUserInfo = (SoapObject)this.c.getResponse();
        paramString1 = "";
        i = 0;
        if (i < paramUserInfo.getPropertyCount())
        {
          paramString2 = new PropertyInfo();
          paramUserInfo.getPropertyInfo(i, paramString2);
          if (!paramString2.getName().equalsIgnoreCase("certSignBuf")) {
            break label612;
          }
          paramString1 = paramString2.getValue().toString();
          break label612;
        }
        paramString1 = "$OKOKOK$" + paramString1;
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return "申请证书失败，原因:" + paramString1.getMessage();
      }
      label603:
      i += 1;
      break;
      label612:
      i += 1;
    }
  }
  
  public String pickupCert(String paramString1, String paramString2)
  {
    Object localObject = this.a + "/" + "pickupCert";
    SoapObject localSoapObject = new SoapObject(this.a, "pickupCert");
    localSoapObject.addProperty("certPin", paramString2);
    localSoapObject.addProperty("certReqChallenge", paramString1);
    localSoapObject.addProperty("accountHash", this.b);
    localSoapObject.addProperty("json", null);
    this.c.bodyOut = localSoapObject;
    this.c.setOutputSoapObject(localSoapObject);
    for (;;)
    {
      int i;
      try
      {
        this.d.call((String)localObject, this.c);
        paramString2 = (SoapObject)this.c.getResponse();
        paramString1 = "";
        i = 0;
        if (i < paramString2.getPropertyCount())
        {
          localObject = new PropertyInfo();
          paramString2.getPropertyInfo(i, (PropertyInfo)localObject);
          if (((PropertyInfo)localObject).getName().equalsIgnoreCase("certSignBuf")) {
            paramString1 = ((PropertyInfo)localObject).getValue().toString();
          }
        }
        else
        {
          paramString1 = "$OKOKOK$" + paramString1;
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return paramString1.getMessage();
      }
      i += 1;
    }
  }
  
  public String renewCert(String paramString)
  {
    Object localObject1 = this.a + "/" + "renewCertAA";
    Object localObject2 = ClientForAndroid.getInstance(this.e).GetCertBuf(paramString).replaceAll("\r\n", "");
    CACertInfo localCACertInfo = new CACertInfo();
    localCACertInfo.setProperty(25, localObject2);
    localObject2 = ClientForAndroid.getInstance(this.e).GenCSRWithCertID(Build.MODEL, (String)ApplicationEx.c.getUserMap().get("name"), "", "", "", paramString).replaceAll("\r\n", "");
    paramString = ClientForAndroid.getInstance(this.e).SignMessage("LOGONDATA:" + (String)localObject2, paramString, "SHA1", 1).replaceAll("\r\n", "");
    for (;;)
    {
      int i;
      try
      {
        paramString = "{\"PKCSINFORMATION\":\"" + paramString + "\",\"CERT_REQ_BUF\":\"" + (String)localObject2 + "\",\"certValidity\":\"" + "365" + "\"}";
        localObject2 = new SoapObject(this.a, "renewCertAA");
        ((SoapObject)localObject2).addProperty("userInfo", null);
        ((SoapObject)localObject2).addProperty("origin", localCACertInfo);
        ((SoapObject)localObject2).addProperty("accountHash", this.b);
        ((SoapObject)localObject2).addProperty("aaCheckPoint", null);
        ((SoapObject)localObject2).addProperty("passCode", "password");
        ((SoapObject)localObject2).addProperty("json", paramString);
        this.c.bodyOut = localObject2;
        this.c.setOutputSoapObject(localObject2);
        this.d.call((String)localObject1, this.c);
        paramString = (SoapObject)this.c.getResponse();
        i = 0;
        if (i < paramString.getPropertyCount())
        {
          localObject1 = new PropertyInfo();
          paramString.getPropertyInfo(i, (PropertyInfo)localObject1);
          if (((PropertyInfo)localObject1).getName().equalsIgnoreCase("certSignBuf")) {
            ((PropertyInfo)localObject1).getValue().toString();
          }
        }
        else
        {
          paramString = "$OKOKOK$" + "";
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return paramString.getMessage();
      }
      i += 1;
    }
  }
  
  public String revokeCert(String paramString1, String paramString2, String paramString3)
  {
    String str = this.a + "/" + "revokeCert";
    SoapObject localSoapObject = new SoapObject(this.a, "revokeCert");
    localSoapObject.addProperty("serialNumber", paramString1);
    localSoapObject.addProperty("certReqChallenge", paramString3);
    localSoapObject.addProperty("certRevokeReason", paramString2);
    localSoapObject.addProperty("accountHash", this.b);
    localSoapObject.addProperty("json", null);
    this.c.bodyOut = localSoapObject;
    this.c.setOutputSoapObject(localSoapObject);
    for (;;)
    {
      int i;
      try
      {
        this.d.call(str, this.c);
        paramString2 = (SoapObject)this.c.getResponse();
        paramString1 = "";
        i = 0;
        if (i < paramString2.getPropertyCount())
        {
          paramString3 = new PropertyInfo();
          paramString2.getPropertyInfo(i, paramString3);
          if (paramString3.getName().equalsIgnoreCase("certSignBuf")) {
            paramString1 = paramString3.getValue().toString();
          }
        }
        else
        {
          paramString1 = "$OKOKOK$" + paramString1;
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return paramString1.getMessage();
      }
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */