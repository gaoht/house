package com.megvii.licensemanager;

import android.content.Context;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Instrumented
public class Manager
{
  private static final String AUTHURL = "http://api.faceid.com/faceid/v1/sdk/authm";
  private static List<ILicenseManager> managers = new ArrayList();
  private Context mContext;
  
  public Manager(Context paramContext)
  {
    if (paramContext == null) {
      throw new InvalidParameterException("context can not be null");
    }
    this.mContext = paramContext.getApplicationContext();
  }
  
  private static String doPost(String paramString)
  {
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject1 = new URL("http://api.faceid.com/faceid/v1/sdk/authm");
        if (!(localObject1 instanceof URL))
        {
          localObject1 = ((URL)localObject1).openConnection();
          localObject1 = (HttpURLConnection)localObject1;
          ((HttpURLConnection)localObject1).setConnectTimeout(5000);
          ((HttpURLConnection)localObject1).setReadTimeout(5000);
          ((HttpURLConnection)localObject1).setRequestMethod("POST");
          ((HttpURLConnection)localObject1).setRequestProperty("Content-type", "text/plain");
          localObject2 = new BufferedOutputStream(((HttpURLConnection)localObject1).getOutputStream());
          ((BufferedOutputStream)localObject2).write(paramString.getBytes());
          ((BufferedOutputStream)localObject2).close();
          paramString = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject1).getInputStream()));
          localObject2 = new StringBuilder();
          String str = paramString.readLine();
          if (str == null) {
            break;
          }
          ((StringBuilder)localObject2).append(str);
          continue;
        }
        localObject1 = HttpInstrumentation.openConnection((URL)localObject1);
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    paramString.close();
    ((HttpURLConnection)localObject1).disconnect();
    paramString = ((StringBuilder)localObject2).toString();
    return paramString;
  }
  
  private void findAllManager() {}
  
  public HashMap<String, Long> checkCachedLicense()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = managers.iterator();
    while (localIterator.hasNext())
    {
      ILicenseManager localILicenseManager = (ILicenseManager)localIterator.next();
      localHashMap.put(localILicenseManager.getVersion(), Long.valueOf(localILicenseManager.checkCachedLicense()));
    }
    return localHashMap;
  }
  
  public String getContext(String paramString)
  {
    if (this.mContext == null) {}
    while (managers.size() == 0) {
      return null;
    }
    this.mContext = this.mContext.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = managers.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((ILicenseManager)localIterator.next()).getContext(paramString));
      localStringBuilder.append('$');
    }
    paramString = localStringBuilder.toString();
    return paramString.substring(0, paramString.length() - 1);
  }
  
  public boolean registerLicenseManager(ILicenseManager paramILicenseManager)
  {
    boolean bool = true;
    try
    {
      Iterator localIterator = managers.iterator();
      int i = 0;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          if (((ILicenseManager)localIterator.next()).getVersion().equals(paramILicenseManager.getVersion())) {
            i = 1;
          }
        }
        else
        {
          if (i == 0) {
            managers.add(paramILicenseManager);
          }
          if (i == 0) {}
          for (;;)
          {
            return bool;
            bool = false;
          }
        }
      }
    }
    finally {}
  }
  
  public Map<String, Long> setLicense(String paramString)
  {
    if ((paramString == null) || (this.mContext == null)) {}
    do
    {
      return null;
      paramString = paramString.split("\\$");
    } while (paramString.length != managers.size());
    this.mContext = this.mContext.getApplicationContext();
    HashMap localHashMap = new HashMap(paramString.length);
    int i = 0;
    while (i < managers.size())
    {
      localHashMap.put(((ILicenseManager)managers.get(i)).getVersion(), Long.valueOf(((ILicenseManager)managers.get(i)).setLicense(paramString[i])));
      i += 1;
    }
    return localHashMap;
  }
  
  public Map<String, Long> takeLicenseFromNetwork(String paramString)
  {
    try
    {
      paramString = setLicense(doPost(getContext(paramString)));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/licensemanager/Manager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */