package com.ziroom.ziroomcustomer.newrepair.c;

import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.mato.sdk.instrumentation.OkHttp3Instrumentation;
import com.ziroom.ziroomcustomer.util.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

@Instrumented
public class b
{
  private OkHttpClient a = new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).writeTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).build();
  
  public static String httpUploadTo(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    Object localObject = null;
    u.e("pic: ", paramString1 + paramArrayOfByte + paramString2);
    try
    {
      paramString1 = new URL(paramString1);
      if (!(paramString1 instanceof URL))
      {
        paramString1 = paramString1.openConnection();
        localHttpURLConnection = (HttpURLConnection)paramString1;
        localHttpURLConnection.setDoOutput(true);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=---------------------------------0xKhTmLbOuNdArY");
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.connect();
        paramString1 = localHttpURLConnection.getOutputStream();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("-----------------------------------0xKhTmLbOuNdArY\r\n");
        localStringBuilder.append("Content-Disposition: form-data; name=\"iosImage\"; filename=\"" + paramString2 + "\"\r\n");
        localStringBuilder.append("Content-Type: image/jpeg\r\n\r\n");
        paramString1.write(localStringBuilder.toString().getBytes("utf-8"));
        paramString1.write(paramArrayOfByte);
        paramString1.write("\r\n-----------------------------------0xKhTmLbOuNdArY--\r\n".getBytes("utf-8"));
        paramString1.flush();
        paramString1.close();
        paramString2 = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
        paramString1 = (String)localObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        HttpURLConnection localHttpURLConnection;
        for (;;)
        {
          paramArrayOfByte = paramString2.readLine();
          if (paramArrayOfByte == null) {
            break;
          }
          if (paramString1 != null)
          {
            paramArrayOfByte = paramString1 + paramArrayOfByte;
            paramString1 = paramArrayOfByte;
            continue;
            paramString1 = HttpInstrumentation.openConnection((URL)paramString1);
          }
          else
          {
            paramString1 = paramArrayOfByte;
          }
        }
        localHttpURLConnection.disconnect();
        return paramString1;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;) {}
      }
      paramArrayOfByte = paramArrayOfByte;
      paramString1 = null;
    }
    paramArrayOfByte.printStackTrace();
    return paramString1;
  }
  
  public void uploadFile(String paramString, List<String> paramList, final a parama)
  {
    MultipartBody.Builder localBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      File localFile = new File((String)paramList.next());
      if ((localFile.exists()) && (!localFile.isDirectory()))
      {
        byte[] arrayOfByte = a.getScaledBitmap(localFile, 1024);
        localBuilder.addFormDataPart(localFile.getName(), localFile.getName(), RequestBody.create(MediaType.parse("image/png"), arrayOfByte));
      }
    }
    paramList = localBuilder.build();
    paramString = new Request.Builder().url(paramString).post(paramList).build();
    paramList = this.a;
    if (!(paramList instanceof OkHttpClient)) {}
    for (paramString = paramList.newCall(paramString);; paramString = OkHttp3Instrumentation.newCall((OkHttpClient)paramList, paramString))
    {
      paramString.enqueue(new Callback()
      {
        public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
        {
          parama.onFailure(paramAnonymousIOException);
        }
        
        public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
          throws IOException
        {
          parama.onResponse(paramAnonymousResponse);
        }
      });
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onFailure(IOException paramIOException);
    
    public abstract void onResponse(Response paramResponse);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */