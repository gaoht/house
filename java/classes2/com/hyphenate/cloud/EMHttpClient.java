package com.hyphenate.cloud;

import android.util.Pair;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.chat.core.EMChatConfigPrivate;
import com.hyphenate.exceptions.HyphenateException;
import com.hyphenate.util.EMLog;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

public class EMHttpClient
{
  public static String DELETE = "DELETE";
  public static String GET = "GET";
  public static String POST = "POST";
  public static String PUT = "PUT";
  private static final String TAG = "EMHttpClient";
  private static EMHttpClient instance = null;
  private EMChatConfigPrivate configPrivate = null;
  
  public static EMHttpClient getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new EMHttpClient();
      }
      EMHttpClient localEMHttpClient = instance;
      return localEMHttpClient;
    }
    finally {}
  }
  
  public EMChatConfigPrivate chatConfig()
  {
    return this.configPrivate;
  }
  
  public void downloadFile(final String paramString1, final String paramString2, final Map<String, String> paramMap, final EMCloudOperationCallback paramEMCloudOperationCallback)
  {
    new Thread()
    {
      public void run()
      {
        EMCloudOperationCallback localEMCloudOperationCallback;
        try
        {
          new b().a(paramString1, paramString2, paramMap, paramEMCloudOperationCallback);
          return;
        }
        catch (Exception localException)
        {
          while (paramEMCloudOperationCallback == null) {}
          localEMCloudOperationCallback = paramEMCloudOperationCallback;
          if (localException == null) {
            break label64;
          }
        }
        if (localException.getMessage() != null) {}
        label64:
        for (String str = localException.getMessage();; str = "failed to download the file : " + paramString1)
        {
          localEMCloudOperationCallback.onError(str);
          return;
        }
      }
    }.start();
  }
  
  public HttpResponse httpExecute(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
    throws KeyManagementException, UnrecoverableKeyException, ClientProtocolException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
  {
    return a.d(paramString1, paramMap, paramString2, paramString3);
  }
  
  public void onInit(EMChatConfigPrivate paramEMChatConfigPrivate)
  {
    this.configPrivate = paramEMChatConfigPrivate;
  }
  
  public Pair<Integer, String> sendRequest(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
    throws IOException, HyphenateException
  {
    return a.b(paramString1, paramMap, paramString2, paramString3);
  }
  
  public Pair<Integer, String> sendRequestWithToken(String paramString1, String paramString2, String paramString3)
    throws HyphenateException
  {
    return a.a(paramString1, paramString2, paramString3);
  }
  
  public void uploadFile(final String paramString1, final String paramString2, final Map<String, String> paramMap, final EMCloudOperationCallback paramEMCloudOperationCallback)
  {
    EMLog.d("EMHttpClient", "upload file :  localFilePath : " + paramString1 + " remoteUrl : " + paramString2);
    new Thread()
    {
      public void run()
      {
        EMCloudOperationCallback localEMCloudOperationCallback;
        try
        {
          EMLog.d("EMHttpClient", "run HttpFileManager().uploadFile");
          new b().a(paramString1, paramString2, EMClient.getInstance().getOptions().getAppKey(), EMClient.getInstance().getCurrentUser(), paramMap, paramEMCloudOperationCallback);
          return;
        }
        catch (Exception localException)
        {
          while (paramEMCloudOperationCallback == null) {}
          localEMCloudOperationCallback = paramEMCloudOperationCallback;
          if (localException == null) {
            break label86;
          }
        }
        if (localException.getMessage() != null) {}
        label86:
        for (String str = localException.getMessage();; str = "failed to upload the file : " + paramString2)
        {
          localEMCloudOperationCallback.onError(str);
          return;
        }
      }
    }.start();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/cloud/EMHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */