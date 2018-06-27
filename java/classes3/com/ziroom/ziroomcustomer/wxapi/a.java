package com.ziroom.ziroomcustomer.wxapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.ApacheHttpClientInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import junit.framework.Assert;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

@Instrumented
public class a
{
  private static HttpClient a()
  {
    try
    {
      Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
      ((KeyStore)localObject).load(null, null);
      localObject = new a((KeyStore)localObject);
      ((org.apache.http.conn.ssl.SSLSocketFactory)localObject).setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
      localObject = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      return (HttpClient)localObject;
    }
    catch (Exception localException) {}
    return new DefaultHttpClient();
  }
  
  public static byte[] bmpToByteArray(Bitmap paramBitmap, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    if (paramBoolean) {
      paramBitmap.recycle();
    }
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramBitmap;
  }
  
  public static Bitmap extractThumbNail(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool;
    if ((paramString != null) && (!paramString.equals("")) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      localObject = new BitmapFactory.Options();
    }
    Bitmap localBitmap;
    double d2;
    double d3;
    double d1;
    for (;;)
    {
      try
      {
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        localBitmap = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        Log.d("SDK_Sample.Util", "extractThumbNail: round=" + paramInt2 + "x" + paramInt1 + ", crop=" + paramBoolean);
        d2 = ((BitmapFactory.Options)localObject).outHeight * 1.0D / paramInt1;
        d3 = ((BitmapFactory.Options)localObject).outWidth * 1.0D / paramInt2;
        Log.d("SDK_Sample.Util", "extractThumbNail: extract beX = " + d3 + ", beY = " + d2);
        if (!paramBoolean) {
          break label291;
        }
        if (d2 <= d3) {
          break label284;
        }
        d1 = d3;
        ((BitmapFactory.Options)localObject).inSampleSize = ((int)d1);
        if (((BitmapFactory.Options)localObject).inSampleSize <= 1) {
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
        }
        if (((BitmapFactory.Options)localObject).outHeight * ((BitmapFactory.Options)localObject).outWidth / ((BitmapFactory.Options)localObject).inSampleSize <= 2764800) {
          break label313;
        }
        ((BitmapFactory.Options)localObject).inSampleSize += 1;
        continue;
        return (Bitmap)localObject;
      }
      catch (OutOfMemoryError paramString)
      {
        Log.e("SDK_Sample.Util", "decode bitmap failed: " + paramString.getMessage());
        localObject = null;
      }
      bool = false;
      break;
      label284:
      d1 = d2;
      continue;
      label291:
      if (d2 < d3) {
        d1 = d3;
      } else {
        d1 = d2;
      }
    }
    label313:
    int j;
    int i;
    if (paramBoolean) {
      if (d2 > d3)
      {
        d1 = paramInt2;
        j = (int)(d1 * 1.0D * ((BitmapFactory.Options)localObject).outHeight / ((BitmapFactory.Options)localObject).outWidth);
        i = paramInt2;
      }
    }
    for (;;)
    {
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      Log.i("SDK_Sample.Util", "bitmap required size=" + i + "x" + j + ", orig=" + ((BitmapFactory.Options)localObject).outWidth + "x" + ((BitmapFactory.Options)localObject).outHeight + ", sample=" + ((BitmapFactory.Options)localObject).inSampleSize);
      paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      if (paramString != null) {
        break;
      }
      Log.e("SDK_Sample.Util", "bitmap decode failed");
      return null;
      i = (int)(paramInt1 * 1.0D * ((BitmapFactory.Options)localObject).outWidth / ((BitmapFactory.Options)localObject).outHeight);
      j = paramInt1;
      continue;
      if (d2 < d3)
      {
        j = (int)(paramInt2 * 1.0D * ((BitmapFactory.Options)localObject).outHeight / ((BitmapFactory.Options)localObject).outWidth);
        i = paramInt2;
      }
      else
      {
        i = (int)(paramInt1 * 1.0D * ((BitmapFactory.Options)localObject).outWidth / ((BitmapFactory.Options)localObject).outHeight);
        j = paramInt1;
      }
    }
    Log.i("SDK_Sample.Util", "bitmap decoded size=" + paramString.getWidth() + "x" + paramString.getHeight());
    Object localObject = Bitmap.createScaledBitmap(paramString, i, j, true);
    if (localObject != null)
    {
      paramString.recycle();
      paramString = (String)localObject;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localBitmap = Bitmap.createBitmap(paramString, paramString.getWidth() - paramInt2 >> 1, paramString.getHeight() - paramInt1 >> 1, paramInt2, paramInt1);
        localObject = paramString;
        if (localBitmap == null) {
          break;
        }
        paramString.recycle();
        Log.i("SDK_Sample.Util", "bitmap croped size=" + localBitmap.getWidth() + "x" + localBitmap.getHeight());
        paramString = localBitmap;
      }
      for (;;)
      {
        return paramString;
      }
    }
  }
  
  public static byte[] httpGet(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("SDK_Sample.Util", "httpGet, url is null");
      return null;
    }
    HttpClient localHttpClient = a();
    paramString = new HttpGet(paramString);
    try
    {
      if (!(localHttpClient instanceof HttpClient)) {}
      for (paramString = localHttpClient.execute(paramString); paramString.getStatusLine().getStatusCode() != 200; paramString = ApacheHttpClientInstrumentation.execute((HttpClient)localHttpClient, paramString))
      {
        Log.e("SDK_Sample.Util", "httpGet fail, status code = " + paramString.getStatusLine().getStatusCode());
        return null;
      }
      paramString = EntityUtils.toByteArray(paramString.getEntity());
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("SDK_Sample.Util", "httpGet exception, e = " + paramString.getMessage());
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static byte[] httpPost(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("SDK_Sample.Util", "httpPost, url is null");
      return null;
    }
    HttpClient localHttpClient = a();
    paramString1 = new HttpPost(paramString1);
    try
    {
      paramString1.setEntity(new StringEntity(paramString2));
      paramString1.setHeader("Accept", "application/json");
      paramString1.setHeader("Content-type", "application/json");
      if (!(localHttpClient instanceof HttpClient)) {}
      for (paramString1 = localHttpClient.execute(paramString1); paramString1.getStatusLine().getStatusCode() != 200; paramString1 = ApacheHttpClientInstrumentation.execute((HttpClient)localHttpClient, paramString1))
      {
        Log.e("SDK_Sample.Util", "httpGet fail, status code = " + paramString1.getStatusLine().getStatusCode());
        return null;
      }
      paramString1 = EntityUtils.toByteArray(paramString1.getEntity());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.e("SDK_Sample.Util", "httpPost exception, e = " + paramString1.getMessage());
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static byte[] readFromFile(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    if (paramString == null) {
      return null;
    }
    Object localObject1 = new File(paramString);
    if (!((File)localObject1).exists())
    {
      Log.i("SDK_Sample.Util", "readFromFile: file not found");
      return null;
    }
    int i = paramInt2;
    if (paramInt2 == -1) {
      i = (int)((File)localObject1).length();
    }
    Log.d("SDK_Sample.Util", "readFromFile : offset = " + paramInt1 + " len = " + i + " offset + len = " + (paramInt1 + i));
    if (paramInt1 < 0)
    {
      Log.e("SDK_Sample.Util", "readFromFile invalid offset:" + paramInt1);
      return null;
    }
    if (i <= 0)
    {
      Log.e("SDK_Sample.Util", "readFromFile invalid len:" + i);
      return null;
    }
    if (paramInt1 + i > (int)((File)localObject1).length())
    {
      Log.e("SDK_Sample.Util", "readFromFile invalid file len:" + ((File)localObject1).length());
      return null;
    }
    localObject1 = localObject2;
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramString, "r");
      localObject1 = localObject2;
      paramString = new byte[i];
      localObject1 = paramString;
      localRandomAccessFile.seek(paramInt1);
      localObject1 = paramString;
      localRandomAccessFile.readFully(paramString);
      localObject1 = paramString;
      localRandomAccessFile.close();
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("SDK_Sample.Util", "readFromFile : errMsg = " + paramString.getMessage());
      paramString.printStackTrace();
    }
    return (byte[])localObject1;
  }
  
  public static String sha1(String paramString)
  {
    int i = 0;
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[16];
    char[] tmp23_21 = arrayOfChar;
    tmp23_21[0] = 48;
    char[] tmp29_23 = tmp23_21;
    tmp29_23[1] = 49;
    char[] tmp35_29 = tmp29_23;
    tmp35_29[2] = 50;
    char[] tmp41_35 = tmp35_29;
    tmp41_35[3] = 51;
    char[] tmp47_41 = tmp41_35;
    tmp47_41[4] = 52;
    char[] tmp53_47 = tmp47_41;
    tmp53_47[5] = 53;
    char[] tmp59_53 = tmp53_47;
    tmp59_53[6] = 54;
    char[] tmp66_59 = tmp59_53;
    tmp66_59[7] = 55;
    char[] tmp73_66 = tmp66_59;
    tmp73_66[8] = 56;
    char[] tmp80_73 = tmp73_66;
    tmp80_73[9] = 57;
    char[] tmp87_80 = tmp80_73;
    tmp87_80[10] = 97;
    char[] tmp94_87 = tmp87_80;
    tmp94_87[11] = 98;
    char[] tmp101_94 = tmp94_87;
    tmp101_94[12] = 99;
    char[] tmp108_101 = tmp101_94;
    tmp108_101[13] = 100;
    char[] tmp115_108 = tmp108_101;
    tmp115_108[14] = 101;
    char[] tmp122_115 = tmp115_108;
    tmp122_115[15] = 102;
    tmp122_115;
    for (;;)
    {
      Object localObject;
      int k;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("SHA1");
        ((MessageDigest)localObject).update(paramString.getBytes());
        paramString = ((MessageDigest)localObject).digest();
        k = paramString.length;
        localObject = new char[k * 2];
        j = 0;
      }
      catch (Exception paramString)
      {
        return null;
      }
      paramString = new String((char[])localObject);
      return paramString;
      while (i < k)
      {
        int m = paramString[i];
        int n = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        j = n + 1;
        localObject[n] = arrayOfChar[(m & 0xF)];
        i += 1;
      }
    }
  }
  
  public static List<String> stringsToList(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localArrayList.add(paramArrayOfString[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  private static class a
    extends org.apache.http.conn.ssl.SSLSocketFactory
  {
    SSLContext a = SSLContext.getInstance("TLS");
    
    public a(KeyStore paramKeyStore)
      throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
      super();
      paramKeyStore = new X509TrustManager()
      {
        public void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
          throws CertificateException
        {}
        
        public void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
          throws CertificateException
        {}
        
        public X509Certificate[] getAcceptedIssuers()
        {
          return null;
        }
      };
      this.a.init(null, new TrustManager[] { paramKeyStore }, null);
    }
    
    public Socket createSocket()
      throws IOException
    {
      return this.a.getSocketFactory().createSocket();
    }
    
    public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
      throws IOException
    {
      return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/wxapi/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */