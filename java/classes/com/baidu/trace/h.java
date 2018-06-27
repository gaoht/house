package com.baidu.trace;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.trace.api.bos.BosGeneratePresignedUrlRequest;
import com.baidu.trace.api.bos.BosGeneratePresignedUrlResponse;
import com.baidu.trace.api.bos.BosGetObjectResponse;
import com.baidu.trace.api.bos.BosObjectRequest;
import com.baidu.trace.api.bos.BosObjectResponse;
import com.baidu.trace.api.bos.BosObjectType;
import com.baidu.trace.api.bos.BosPutObjectRequest;
import com.baidu.trace.api.bos.BosPutObjectResponse;
import com.baidu.trace.api.bos.FontFamily;
import com.baidu.trace.api.bos.FontStyle;
import com.baidu.trace.api.bos.ImageDisplay;
import com.baidu.trace.api.bos.ImageFormat;
import com.baidu.trace.api.bos.ImageProcessCommand;
import com.baidu.trace.api.bos.ImageWatermarkCommand;
import com.baidu.trace.api.bos.OnBosListener;
import com.baidu.trace.api.bos.TextWatermarkCommand;
import com.baidu.trace.c.e;
import com.baidu.trace.model.BaseRequest;
import com.baidubce.BceClientException;
import com.baidubce.BceServiceException;
import com.baidubce.Protocol;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.BosObject;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.services.bos.model.PutObjectResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  private static BosClient a = null;
  private static boolean b = false;
  
  protected static String a(BosGeneratePresignedUrlRequest paramBosGeneratePresignedUrlRequest)
  {
    int j = 0;
    StringBuffer localStringBuffer1 = new StringBuffer();
    ImageProcessCommand localImageProcessCommand = paramBosGeneratePresignedUrlRequest.getImageProcessCommand();
    ImageWatermarkCommand localImageWatermarkCommand = paramBosGeneratePresignedUrlRequest.getImageWatermarkCommand();
    paramBosGeneratePresignedUrlRequest = paramBosGeneratePresignedUrlRequest.getTextWatermarkCommand();
    StringBuffer localStringBuffer2;
    if (localImageProcessCommand != null)
    {
      if (e.a(localImageProcessCommand.getScale(), 0, 2)) {
        localStringBuffer1.append("s_" + localImageProcessCommand.getScale()).append(",");
      }
      if (e.a(localImageProcessCommand.getMaxWidth(), 1, 4096)) {
        localStringBuffer1.append("w_" + localImageProcessCommand.getMaxWidth()).append(",");
      }
      if (e.a(localImageProcessCommand.getMaxHeight(), 1, 4096)) {
        localStringBuffer1.append("h_" + localImageProcessCommand.getMaxHeight()).append(",");
      }
      if (e.a(localImageProcessCommand.getQuality(), 1, 100)) {
        localStringBuffer1.append("q_" + localImageProcessCommand.getQuality()).append(",");
      }
      if (localImageProcessCommand.getFormat() != null) {
        localStringBuffer1.append("f_" + localImageProcessCommand.getFormat().name()).append(",");
      }
      if (e.a(localImageProcessCommand.getAngle(), 65176, 360)) {
        localStringBuffer1.append("a_" + localImageProcessCommand.getAngle()).append(",");
      }
      if (localImageProcessCommand.getDisplay() != null) {
        localStringBuffer1.append("d_" + localImageProcessCommand.getDisplay().name()).append(",");
      }
      localStringBuffer2 = localStringBuffer1.append("l_");
      if (!localImageProcessCommand.isLimit()) {
        break label1102;
      }
    }
    label1102:
    for (int i = 1;; i = 0)
    {
      localStringBuffer2.append(i);
      localStringBuffer1.append("|");
      if (e.a(localImageProcessCommand.getOffsetX(), 0, 4096)) {
        localStringBuffer1.append("x_").append(localImageProcessCommand.getOffsetX()).append(",");
      }
      if (e.a(localImageProcessCommand.getOffsetY(), 0, 4096)) {
        localStringBuffer1.append("y_").append(localImageProcessCommand.getOffsetY()).append(",");
      }
      if (e.a(localImageProcessCommand.getCropWidth(), 1, 4096)) {
        localStringBuffer1.append("w_").append(localImageProcessCommand.getCropWidth()).append(",");
      }
      if (e.a(localImageProcessCommand.getCropHeight(), 1, 4096)) {
        localStringBuffer1.append("h_").append(localImageProcessCommand.getCropHeight()).append(",");
      }
      localStringBuffer2 = localStringBuffer1.append("c_");
      i = j;
      if (localImageProcessCommand.isCrop()) {
        i = 1;
      }
      localStringBuffer2.append(i);
      if (localImageWatermarkCommand != null)
      {
        if (!TextUtils.isEmpty(localStringBuffer1.toString())) {
          localStringBuffer1.append("|");
        }
        if (!TextUtils.isEmpty(localImageWatermarkCommand.getObjectKey())) {
          localStringBuffer1.append("k_").append(localImageWatermarkCommand.getObjectKey()).append(",");
        }
        if (e.a(localImageWatermarkCommand.getGravity(), 1, 9)) {
          localStringBuffer1.append("g_").append(localImageWatermarkCommand.getGravity()).append(",");
        }
        if (e.a(localImageWatermarkCommand.getGravityX(), 61440, 4096)) {
          localStringBuffer1.append("x_").append(localImageWatermarkCommand.getGravityX()).append(",");
        }
        if (e.a(localImageWatermarkCommand.getGravityY(), 61440, 4096)) {
          localStringBuffer1.append("y_").append(localImageWatermarkCommand.getGravityY()).append(",");
        }
        if (e.a(localImageWatermarkCommand.getAngle(), 65176, 360)) {
          localStringBuffer1.append("a_").append(localImageWatermarkCommand.getAngle()).append(",");
        }
        if (e.a(localImageWatermarkCommand.getOpacity(), 1, 100)) {
          localStringBuffer1.append("o_").append(localImageWatermarkCommand.getOpacity()).append(",");
        }
        localStringBuffer1.append("wm_1");
      }
      if (paramBosGeneratePresignedUrlRequest != null)
      {
        if (!TextUtils.isEmpty(localStringBuffer1.toString())) {
          localStringBuffer1.append("|");
        }
        if (!TextUtils.isEmpty(paramBosGeneratePresignedUrlRequest.getText())) {
          localStringBuffer1.append("t_").append(paramBosGeneratePresignedUrlRequest.getText()).append(",");
        }
        if (e.a(paramBosGeneratePresignedUrlRequest.getGravity(), 1, 9)) {
          localStringBuffer1.append("g_").append(paramBosGeneratePresignedUrlRequest.getGravity()).append(",");
        }
        if (e.a(paramBosGeneratePresignedUrlRequest.getGravityX(), 61440, 4096)) {
          localStringBuffer1.append("x_").append(paramBosGeneratePresignedUrlRequest.getGravityX()).append(",");
        }
        if (e.a(paramBosGeneratePresignedUrlRequest.getGravityY(), 61440, 4096)) {
          localStringBuffer1.append("y_").append(paramBosGeneratePresignedUrlRequest.getGravityY()).append(",");
        }
        if (e.a(paramBosGeneratePresignedUrlRequest.getAngle(), 65176, 360)) {
          localStringBuffer1.append("a_").append(paramBosGeneratePresignedUrlRequest.getAngle()).append(",");
        }
        if (e.a(paramBosGeneratePresignedUrlRequest.getFontSize(), 1, 1024)) {
          localStringBuffer1.append("sz_").append(paramBosGeneratePresignedUrlRequest.getFontSize()).append(",");
        }
        if (!TextUtils.isEmpty(paramBosGeneratePresignedUrlRequest.getFontColor())) {
          localStringBuffer1.append("fc_").append(paramBosGeneratePresignedUrlRequest.getFontColor()).append(",");
        }
        if (paramBosGeneratePresignedUrlRequest.getFontFamily() != null) {
          localStringBuffer1.append("ff_").append(Base64.encodeToString(paramBosGeneratePresignedUrlRequest.getFontFamily().name().getBytes(), 2)).append(",");
        }
        if (paramBosGeneratePresignedUrlRequest.getFontStyle() != null) {
          localStringBuffer1.append("fs_").append(paramBosGeneratePresignedUrlRequest.getFontStyle().name()).append(",");
        }
        localStringBuffer1.append("wm_2");
      }
      return localStringBuffer1.toString();
    }
  }
  
  protected static void a()
  {
    BosClientConfiguration localBosClientConfiguration = new BosClientConfiguration();
    localBosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(g.a, g.c, g.d));
    localBosClientConfiguration.setEndpoint("gz.bcebos.com");
    localBosClientConfiguration.setProtocol(Protocol.HTTPS);
    a = new BosClient(localBosClientConfiguration);
    b = true;
  }
  
  private static void a(int paramInt, BosObjectResponse paramBosObjectResponse, OnBosListener paramOnBosListener, Handler paramHandler)
  {
    paramHandler.post(new k(paramInt, paramOnBosListener, paramBosObjectResponse));
  }
  
  private static void a(int paramInt, String paramString, BosObjectRequest paramBosObjectRequest, BosObjectResponse paramBosObjectResponse, OnBosListener paramOnBosListener, Handler paramHandler)
  {
    int i = 14001;
    if (a == null)
    {
      paramBosObjectResponse.setStatus(16000);
      paramBosObjectResponse.setMessage("存储服务未初始化");
      a(paramInt, paramBosObjectResponse, paramOnBosListener, paramHandler);
      b = false;
      if (!bc.a().c()) {
        LBSTraceClient.a.a();
      }
      return;
    }
    if (!b)
    {
      paramBosObjectResponse.setStatus(14001);
      paramBosObjectResponse.setMessage("请求失败");
      a(paramInt, paramBosObjectResponse, paramOnBosListener, paramHandler);
      return;
    }
    long l1 = g.b;
    switch (paramInt)
    {
    default: 
      return;
    }
    try
    {
      localBosPutObjectRequest = (BosPutObjectRequest)paramBosObjectRequest;
      localBosPutObjectResponse = (BosPutObjectResponse)paramBosObjectResponse;
      localObjectMetadata = new ObjectMetadata();
      localObjectMetadata.setContentLength(localBosPutObjectRequest.getObjectSize());
      if (BosObjectType.image == localBosPutObjectRequest.getObjectType()) {
        localObjectMetadata.setContentType("image/jpeg");
      }
      l2 = localBosPutObjectRequest.getServiceId();
      paramBosObjectRequest = null;
      if (localBosPutObjectRequest.getFile() == null) {
        break label370;
      }
      paramBosObjectRequest = a.putObject(paramString, "/" + String.valueOf(l2) + "/" + localBosPutObjectRequest.getObjectKey(), localBosPutObjectRequest.getFile(), localObjectMetadata);
    }
    catch (BceServiceException paramBosObjectRequest)
    {
      for (;;)
      {
        BosPutObjectRequest localBosPutObjectRequest;
        BosPutObjectResponse localBosPutObjectResponse;
        ObjectMetadata localObjectMetadata;
        long l2;
        try
        {
          if ((400 == paramBosObjectRequest.getStatusCode()) && (b) && (l1 == g.b))
          {
            b = false;
            if (!bc.a().c()) {
              LBSTraceClient.a.a();
            }
          }
          paramString = "请求失败";
          if (404 == paramBosObjectRequest.getStatusCode())
          {
            i = 16001;
            paramString = "指定objectKey不存在";
          }
          paramBosObjectResponse.setStatus(i);
          paramBosObjectResponse.setMessage(paramString);
          a(paramInt, paramBosObjectResponse, paramOnBosListener, paramHandler);
          return;
        }
        finally {}
        if (localBosPutObjectRequest.getStreamData() != null) {
          paramBosObjectRequest = a.putObject(paramString, "/" + String.valueOf(l2) + "/" + localBosPutObjectRequest.getObjectKey(), localBosPutObjectRequest.getStreamData(), localObjectMetadata);
        } else if (localBosPutObjectRequest.getByteArray() != null) {
          paramBosObjectRequest = a.putObject(paramString, "/" + String.valueOf(l2) + "/" + localBosPutObjectRequest.getObjectKey(), localBosPutObjectRequest.getByteArray(), localObjectMetadata);
        } else if (localBosPutObjectRequest.getStringData() != null) {
          paramBosObjectRequest = a.putObject(paramString, "/" + String.valueOf(l2) + "/" + localBosPutObjectRequest.getObjectKey(), localBosPutObjectRequest.getStringData(), localObjectMetadata);
        }
      }
      a(paramString, paramBosObjectRequest, (BosGetObjectResponse)paramBosObjectResponse, paramOnBosListener, paramHandler);
      return;
    }
    catch (BceClientException paramString)
    {
      paramBosObjectResponse.setStatus(14001);
      paramBosObjectResponse.setMessage("请求失败");
      a(paramInt, paramBosObjectResponse, paramOnBosListener, paramHandler);
      return;
    }
    catch (IOException paramString)
    {
      paramBosObjectResponse.setStatus(14001);
      paramBosObjectResponse.setMessage("请求失败");
      a(paramInt, paramBosObjectResponse, paramOnBosListener, paramHandler);
    }
    if (paramBosObjectRequest != null)
    {
      localBosPutObjectResponse.setStatus(0);
      localBosPutObjectResponse.setMessage("成功");
      localBosPutObjectResponse.setETag(paramBosObjectRequest.getETag());
    }
    paramHandler.post(new l(paramOnBosListener, localBosPutObjectResponse));
    return;
    label370:
  }
  
  public static void a(BaseRequest paramBaseRequest, int paramInt1, boolean paramBoolean, int paramInt2, String paramString, OnBosListener paramOnBosListener, Handler paramHandler)
  {
    int i = paramBaseRequest.getTag();
    BosObjectRequest localBosObjectRequest = (BosObjectRequest)paramBaseRequest;
    StringBuffer localStringBuffer = new StringBuffer();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((paramBaseRequest instanceof BosPutObjectRequest))
      {
        paramBaseRequest = ((BosPutObjectRequest)paramBaseRequest).getStreamData();
        if (paramBaseRequest == null) {}
      }
      try
      {
        paramBaseRequest.close();
        return;
      }
      catch (Exception paramBaseRequest) {}
      Object localObject = new BosPutObjectResponse(i, paramInt2, paramString);
      if (paramBoolean)
      {
        ((BosPutObjectResponse)localObject).setObjectKey(localBosObjectRequest.getObjectKey());
        ((BosPutObjectResponse)localObject).setObjectType(localBosObjectRequest.getObjectType());
        if (a(paramString, localStringBuffer, (BosObjectResponse)localObject))
        {
          a(1, localStringBuffer.toString(), localBosObjectRequest, (BosObjectResponse)localObject, paramOnBosListener, paramHandler);
          return;
        }
      }
      paramHandler.post(new i(paramOnBosListener, (BosPutObjectResponse)localObject));
      continue;
      localObject = new BosGetObjectResponse(i, paramInt2, paramString);
      if (paramBoolean)
      {
        ((BosGetObjectResponse)localObject).setObjectKey(localBosObjectRequest.getObjectKey());
        ((BosGetObjectResponse)localObject).setObjectType(localBosObjectRequest.getObjectType());
        if (a(paramString, localStringBuffer, (BosObjectResponse)localObject))
        {
          a(2, localStringBuffer.toString(), localBosObjectRequest, (BosObjectResponse)localObject, paramOnBosListener, paramHandler);
          return;
        }
      }
      paramHandler.post(new j(paramOnBosListener, (BosGetObjectResponse)localObject));
      continue;
      paramHandler = new BosGeneratePresignedUrlResponse(i, paramInt2, paramString);
      if (paramBoolean)
      {
        paramHandler.setObjectKey(localBosObjectRequest.getObjectKey());
        paramHandler.setObjectType(localBosObjectRequest.getObjectType());
        if (a(paramString, localStringBuffer, paramHandler))
        {
          paramHandler.setStatus(0);
          paramHandler.setMessage("成功");
        }
      }
      paramOnBosListener.onGeneratePresignedUrlCallback(paramHandler);
    }
  }
  
  private static void a(String paramString, BosObjectRequest paramBosObjectRequest, BosGetObjectResponse paramBosGetObjectResponse, OnBosListener paramOnBosListener, Handler paramHandler)
    throws IOException
  {
    paramString = a.getObject(paramString, "/" + String.valueOf(paramBosObjectRequest.getServiceId()) + "/" + paramBosObjectRequest.getObjectKey());
    paramBosGetObjectResponse.setMetaData(paramString.getObjectMetadata());
    paramString = paramString.getObjectContent();
    paramBosObjectRequest = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    if (paramString != null)
    {
      for (;;)
      {
        int i = paramString.read(arrayOfByte, 0, 4096);
        if (i <= 0) {
          break;
        }
        paramBosObjectRequest.write(arrayOfByte, 0, i);
      }
      paramBosGetObjectResponse.setStatus(0);
      paramBosGetObjectResponse.setMessage("成功");
      paramBosGetObjectResponse.setObjectContent(paramBosObjectRequest);
    }
    paramHandler.post(new m(paramOnBosListener, paramBosGetObjectResponse));
    if (paramBosObjectRequest != null) {}
    try
    {
      paramBosObjectRequest.close();
      if (paramString != null) {
        paramString.close();
      }
      return;
    }
    catch (IOException paramString) {}
  }
  
  private static boolean a(String paramString, StringBuffer paramStringBuffer, BosObjectResponse paramBosObjectResponse)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramBosObjectResponse.setStatus(14001);
      paramBosObjectResponse.setMessage("请求失败");
      return false;
    }
    if ("响应解析失败".equals(paramString))
    {
      paramBosObjectResponse.setStatus(14000);
      paramBosObjectResponse.setMessage("响应解析失败");
      return false;
    }
    if ("请求失败".equals(paramString))
    {
      paramBosObjectResponse.setStatus(14001);
      paramBosObjectResponse.setMessage("请求失败");
      return false;
    }
    if (!a.b(paramString, paramBosObjectResponse)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString != null) && (paramString.has("status")) && (paramString.getInt("status") == 0))
      {
        if ((paramString.has("url")) && ((paramBosObjectResponse instanceof BosGeneratePresignedUrlResponse))) {
          ((BosGeneratePresignedUrlResponse)paramBosObjectResponse).setUrl(paramString.getString("url"));
        }
        if (paramString.has("bucket")) {
          paramStringBuffer.append(paramString.getString("bucket"));
        }
      }
      else
      {
        if (paramString.has("status"))
        {
          paramBosObjectResponse.setStatus(paramString.getInt("status"));
          if (!paramString.has("message")) {
            break label254;
          }
          paramBosObjectResponse.setMessage(paramString.getString("message"));
          break label254;
        }
        paramBosObjectResponse.setStatus(14000);
        paramBosObjectResponse.setMessage("响应解析失败");
        return false;
      }
    }
    catch (JSONException paramString)
    {
      paramBosObjectResponse.setStatus(14000);
      paramBosObjectResponse.setMessage("响应解析失败");
      return false;
    }
    return true;
    label254:
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/trace/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */