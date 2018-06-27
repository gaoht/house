package com.superrtc.call;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@TargetApi(19)
public class m
{
  private static m a = null;
  private static b b = null;
  private static int c = 0;
  private static Set<String> d = new HashSet();
  private static final String[] f = { "OMX.qcom.", "OMX.Intel." };
  private static final String[] g = { "OMX.qcom." };
  private static final String[] h = { "OMX.qcom.", "OMX.hisi." };
  private static final String[] i = { "SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4" };
  private static final int[] j = { 19, 21, 2141391872, 2141391876 };
  private static final int[] k = { 2130708361 };
  private Thread e;
  private ByteBuffer l = null;
  
  private static a a(String paramString, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return null;
    }
    if ((paramString.equals("video/avc")) && (Arrays.asList(i).contains(Build.MODEL)))
    {
      Logging.w("MediaCodecVideoEncoder", "Model: " + Build.MODEL + " has black listed H.264 encoder.");
      return null;
    }
    int m = 0;
    Object localObject2;
    if (m < MediaCodecList.getCodecCount())
    {
      localObject2 = MediaCodecList.getCodecInfoAt(m);
      if (((MediaCodecInfo)localObject2).isEncoder()) {}
    }
    label177:
    label466:
    for (;;)
    {
      m += 1;
      break;
      Object localObject1 = ((MediaCodecInfo)localObject2).getSupportedTypes();
      int i1 = localObject1.length;
      int n = 0;
      if (n < i1) {
        if (!localObject1[n].equals(paramString)) {}
      }
      for (localObject1 = ((MediaCodecInfo)localObject2).getName();; localObject1 = null)
      {
        if (localObject1 == null) {
          break label466;
        }
        Logging.v("MediaCodecVideoEncoder", "Found candidate encoder " + (String)localObject1);
        i1 = paramArrayOfString.length;
        n = 0;
        if (n < i1) {
          if (!((String)localObject1).startsWith(paramArrayOfString[n])) {}
        }
        for (boolean bool = true;; bool = false)
        {
          Logging.d("MediaCodecVideoEncoder", "hw encoder supportedCodec  = " + bool);
          if (!bool) {
            break;
          }
          localObject2 = ((MediaCodecInfo)localObject2).getCapabilitiesForType(paramString);
          int[] arrayOfInt = ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats;
          i1 = arrayOfInt.length;
          n = 0;
          for (;;)
          {
            if (n < i1)
            {
              i2 = arrayOfInt[n];
              Logging.v("MediaCodecVideoEncoder", "   Color: 0x" + Integer.toHexString(i2));
              n += 1;
              continue;
              n += 1;
              break;
              n += 1;
              break label177;
            }
          }
          int i2 = paramArrayOfInt.length;
          n = 0;
          while (n < i2)
          {
            int i3 = paramArrayOfInt[n];
            arrayOfInt = ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats;
            int i4 = arrayOfInt.length;
            i1 = 0;
            while (i1 < i4)
            {
              int i5 = arrayOfInt[i1];
              if (i5 == i3)
              {
                Logging.d("MediaCodecVideoEncoder", "Found target encoder for mime " + paramString + " : " + (String)localObject1 + ". Color: 0x" + Integer.toHexString(i5));
                return new a((String)localObject1, i5);
              }
              i1 += 1;
            }
            n += 1;
          }
          break;
          return null;
        }
      }
    }
  }
  
  public static void disableH264HwCodec()
  {
    Logging.w("MediaCodecVideoEncoder", "H.264 encoding is disabled by application.");
    d.add("video/avc");
  }
  
  public static void disableVp8HwCodec()
  {
    Logging.w("MediaCodecVideoEncoder", "VP8 encoding is disabled by application.");
    d.add("video/x-vnd.on2.vp8");
  }
  
  public static void disableVp9HwCodec()
  {
    Logging.w("MediaCodecVideoEncoder", "VP9 encoding is disabled by application.");
    d.add("video/x-vnd.on2.vp9");
  }
  
  public static boolean isH264HwSupported()
  {
    return (!d.contains("video/avc")) && (a("video/avc", h, j) != null);
  }
  
  public static boolean isH264HwSupportedUsingTextures()
  {
    return (!d.contains("video/avc")) && (a("video/avc", h, k) != null);
  }
  
  public static boolean isVp8HwSupported()
  {
    return (!d.contains("video/x-vnd.on2.vp8")) && (a("video/x-vnd.on2.vp8", f, j) != null);
  }
  
  public static boolean isVp8HwSupportedUsingTextures()
  {
    return (!d.contains("video/x-vnd.on2.vp8")) && (a("video/x-vnd.on2.vp8", f, k) != null);
  }
  
  public static boolean isVp9HwSupported()
  {
    return (!d.contains("video/x-vnd.on2.vp9")) && (a("video/x-vnd.on2.vp9", g, j) != null);
  }
  
  public static boolean isVp9HwSupportedUsingTextures()
  {
    return (!d.contains("video/x-vnd.on2.vp9")) && (a("video/x-vnd.on2.vp9", g, k) != null);
  }
  
  public static void printStackTrace()
  {
    if ((a != null) && (a.e != null))
    {
      StackTraceElement[] arrayOfStackTraceElement = a.e.getStackTrace();
      if (arrayOfStackTraceElement.length > 0)
      {
        Logging.d("MediaCodecVideoEncoder", "MediaCodecVideoEncoder stacks trace:");
        int n = arrayOfStackTraceElement.length;
        int m = 0;
        while (m < n)
        {
          Logging.d("MediaCodecVideoEncoder", arrayOfStackTraceElement[m].toString());
          m += 1;
        }
      }
    }
  }
  
  public static void setErrorCallback(b paramb)
  {
    Logging.d("MediaCodecVideoEncoder", "Set error callback");
    b = paramb;
  }
  
  private static class a
  {
    public final String a;
    public final int b;
    
    public a(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onMediaCodecVideoEncoderCriticalError(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */