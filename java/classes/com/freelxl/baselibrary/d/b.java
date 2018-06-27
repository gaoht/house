package com.freelxl.baselibrary.d;

import android.net.http.SslCertificate;
import android.os.Bundle;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public class b
{
  public static String a = "c407a116ef29bd6f75ad3a9e7012525e060d0cd19c8e1469f2f25f0c1d57302f";
  
  public static byte[] hexToBytes(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return null;
    }
    int j = paramString.length() / 2;
    paramString = paramString.toCharArray();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label97;
      }
      int m = i * 2;
      int k = "0123456789abcdef".indexOf(paramString[m]) << 4;
      m = "0123456789abcdef".indexOf(paramString[(m + 1)]);
      if ((k == -1) || (m == -1)) {
        break;
      }
      arrayOfByte[i] = ((byte)(m | k));
      i += 1;
    }
    label97:
    return arrayOfByte;
  }
  
  public static boolean isSSLCertOk(SslCertificate paramSslCertificate, String paramString)
  {
    paramString = hexToBytes(paramString);
    paramSslCertificate = SslCertificate.saveState(paramSslCertificate);
    if (paramSslCertificate != null)
    {
      paramSslCertificate = paramSslCertificate.getByteArray("x509-certificate");
      if (paramSslCertificate != null) {
        try
        {
          paramSslCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramSslCertificate));
          boolean bool = Arrays.equals(MessageDigest.getInstance("SHA-256").digest(((X509Certificate)paramSslCertificate).getEncoded()), paramString);
          return bool;
        }
        catch (Exception paramSslCertificate)
        {
          paramSslCertificate.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */