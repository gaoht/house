package com.mato.sdk.f;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public final class b
{
  private static String A = "POST";
  private static String B = "PUT";
  private static String C = "TRACE";
  private static String D = "charset";
  private static final String E = "00content0boundary00";
  private static final String F = "multipart/form-data; boundary=00content0boundary00";
  private static final String G = "\r\n";
  private static final String[] H = new String[0];
  private static SSLSocketFactory I;
  private static HostnameVerifier J;
  private static c K = c.a;
  private static String a = "UTF-8";
  private static String b = "application/x-www-form-urlencoded";
  private static String c = "application/json";
  private static String d = "gzip";
  private static String e = "Accept";
  private static String f = "Accept-Charset";
  private static String g = "Accept-Encoding";
  private static String h = "Authorization";
  private static String i = "Cache-Control";
  private static String j = "Content-Encoding";
  private static String k = "Content-Length";
  private static String l = "Content-Type";
  private static String m = "Date";
  private static String n = "ETag";
  private static String o = "Expires";
  private static String p = "If-None-Match";
  private static String q = "Last-Modified";
  private static String r = "Location";
  private static String s = "Proxy-Authorization";
  private static String t = "Referer";
  private static String u = "Server";
  private static String v = "User-Agent";
  private static String w = "DELETE";
  private static String x = "GET";
  private static String y = "HEAD";
  private static String z = "OPTIONS";
  private HttpURLConnection L = null;
  private final URL M;
  private final String N;
  private g O;
  private boolean P;
  private boolean Q;
  private boolean R = true;
  private boolean S = false;
  private int T = 8192;
  private long U = -1L;
  private long V = 0L;
  private String W;
  private int X;
  private h Y = h.a;
  
  private b(CharSequence paramCharSequence, String paramString)
    throws b.e
  {
    try
    {
      this.M = new URL(paramCharSequence.toString());
      this.N = paramString;
      return;
    }
    catch (MalformedURLException paramCharSequence)
    {
      throw new e(paramCharSequence);
    }
  }
  
  private b(URL paramURL, String paramString)
    throws b.e
  {
    this.M = paramURL;
    this.N = paramString;
  }
  
  private InputStreamReader A()
    throws b.e
  {
    return e(C());
  }
  
  private BufferedReader B()
    throws b.e
  {
    return new BufferedReader(e(C()), this.T);
  }
  
  private String C()
  {
    return e(g("Content-Type"), "charset");
  }
  
  private b D()
  {
    return c("Accept-Encoding", "gzip");
  }
  
  private String E()
  {
    return g("Content-Encoding");
  }
  
  private String F()
  {
    return g("Server");
  }
  
  private long G()
  {
    return h("Date");
  }
  
  private String H()
  {
    return g("Cache-Control");
  }
  
  private String I()
  {
    return g("ETag");
  }
  
  private long J()
  {
    return h("Expires");
  }
  
  private long K()
  {
    return h("Last-Modified");
  }
  
  private String L()
  {
    return g("Location");
  }
  
  private String M()
  {
    return g("Content-Type");
  }
  
  private int N()
  {
    Q();
    return a().getHeaderFieldInt("Content-Length", -1);
  }
  
  private b O()
  {
    return c("Accept", "application/json");
  }
  
  private b P()
    throws IOException
  {
    this.Y = h.a;
    if (this.O == null) {
      return this;
    }
    if (this.P) {
      this.O.a("\r\n--00content0boundary00--\r\n");
    }
    if (this.R) {}
    try
    {
      this.O.close();
      for (;;)
      {
        this.O = null;
        return this;
        this.O.close();
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  private b Q()
    throws b.e
  {
    try
    {
      b localb = P();
      return localb;
    }
    catch (IOException localIOException)
    {
      throw new e(localIOException);
    }
  }
  
  private b R()
    throws IOException
  {
    if (this.O != null) {
      return this;
    }
    a().setDoOutput(true);
    String str = e(a().getRequestProperty("Content-Type"), "charset");
    this.O = new g(a().getOutputStream(), str, this.T);
    return this;
  }
  
  private b S()
    throws IOException
  {
    if (!this.P)
    {
      this.P = true;
      h("multipart/form-data; boundary=00content0boundary00", null).R();
      this.O.a("--00content0boundary00\r\n");
      return this;
    }
    this.O.a("\r\n--00content0boundary00\r\n");
    return this;
  }
  
  private OutputStreamWriter T()
    throws b.e
  {
    try
    {
      R();
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(this.O, g.a(this.O).charset());
      return localOutputStreamWriter;
    }
    catch (IOException localIOException)
    {
      throw new e(localIOException);
    }
  }
  
  private b U()
    throws b.e
  {
    HttpURLConnection localHttpURLConnection = a();
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(g());
    }
    return this;
  }
  
  private b V()
  {
    HttpURLConnection localHttpURLConnection = a();
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      ((HttpsURLConnection)localHttpURLConnection).setHostnameVerifier(h());
    }
    return this;
  }
  
  private long a(String paramString, long paramLong)
    throws b.e
  {
    Q();
    return a().getHeaderFieldDate(paramString, -1L);
  }
  
  private b a(long paramLong)
  {
    a().setIfModifiedSince(paramLong);
    return this;
  }
  
  private b a(h paramh)
  {
    this.Y = h.a;
    return this;
  }
  
  private b a(final File paramFile)
    throws b.e
  {
    try
    {
      paramFile = new BufferedOutputStream(new FileOutputStream(paramFile), this.T);
      (b)new b(paramFile, this.R)
      {
        private b c()
          throws b.e, IOException
        {
          return b.this.a(paramFile);
        }
      }.call();
    }
    catch (FileNotFoundException paramFile)
    {
      throw new e(paramFile);
    }
  }
  
  private b a(InputStream paramInputStream)
    throws b.e
  {
    try
    {
      R();
      a(paramInputStream, this.O);
      return this;
    }
    catch (IOException paramInputStream)
    {
      throw new e(paramInputStream);
    }
  }
  
  private b a(final InputStream paramInputStream, final OutputStream paramOutputStream)
    throws IOException
  {
    (b)new b(paramInputStream, this.R)
    {
      private b c()
        throws IOException
      {
        byte[] arrayOfByte = new byte[b.a(b.this)];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
          b.a(b.this, i);
          b.h localh = b.d(b.this);
          b.b(b.this);
          b.c(b.this);
          localh.a();
        }
        return b.this;
      }
    }.call();
  }
  
  private b a(PrintStream paramPrintStream)
    throws b.e
  {
    return a(paramPrintStream);
  }
  
  private b a(final Reader paramReader)
    throws b.e
  {
    try
    {
      R();
      final OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(this.O, g.a(this.O).charset());
      (b)new d(localOutputStreamWriter)
      {
        private b c()
          throws IOException
        {
          return b.this.a(paramReader, localOutputStreamWriter);
        }
      }.call();
    }
    catch (IOException paramReader)
    {
      throw new e(paramReader);
    }
  }
  
  private b a(final Writer paramWriter)
    throws b.e
  {
    final BufferedReader localBufferedReader = B();
    (b)new b(localBufferedReader, this.R)
    {
      private b c()
        throws IOException
      {
        return b.this.a(localBufferedReader, paramWriter);
      }
    }.call();
  }
  
  private b a(final Appendable paramAppendable)
    throws b.e
  {
    final BufferedReader localBufferedReader = B();
    (b)new b(localBufferedReader, this.R)
    {
      private b c()
        throws IOException
      {
        CharBuffer localCharBuffer = CharBuffer.allocate(b.a(b.this));
        for (;;)
        {
          int i = localBufferedReader.read(localCharBuffer);
          if (i == -1) {
            break;
          }
          localCharBuffer.rewind();
          paramAppendable.append(localCharBuffer, 0, i);
          localCharBuffer.rewind();
        }
        return b.this;
      }
    }.call();
  }
  
  public static b a(CharSequence paramCharSequence)
    throws b.e
  {
    return new b(paramCharSequence, "GET");
  }
  
  private static b a(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    paramMap = a(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = c(paramMap);
    }
    return a(paramCharSequence);
  }
  
  private static b a(CharSequence paramCharSequence, boolean paramBoolean, Object... paramVarArgs)
  {
    paramVarArgs = a(paramCharSequence, paramVarArgs);
    paramCharSequence = paramVarArgs;
    if (paramBoolean) {
      paramCharSequence = c(paramVarArgs);
    }
    return a(paramCharSequence);
  }
  
  private b a(Object paramObject1, Object paramObject2)
    throws b.e
  {
    return a(paramObject1, paramObject2, "UTF-8");
  }
  
  private b a(Object paramObject1, Object paramObject2, String paramString)
    throws b.e
  {
    if (!this.Q) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        h("application/x-www-form-urlencoded", paramString);
        this.Q = true;
      }
      paramString = b(paramString);
      try
      {
        R();
        if (i1 == 0) {
          this.O.write(38);
        }
        this.O.a(URLEncoder.encode(paramObject1.toString(), paramString));
        this.O.write(61);
        if (paramObject2 != null) {
          this.O.a(URLEncoder.encode(paramObject2.toString(), paramString));
        }
        return this;
      }
      catch (IOException paramObject1)
      {
        throw new e((IOException)paramObject1);
      }
    }
  }
  
  private b a(String paramString, File paramFile)
    throws b.e
  {
    return a(paramString, null, null, paramFile);
  }
  
  private b a(String paramString, InputStream paramInputStream)
    throws b.e
  {
    return a(paramString, null, null, paramInputStream);
  }
  
  private b a(String paramString, Number paramNumber)
  {
    if (paramNumber != null) {}
    for (paramNumber = paramNumber.toString();; paramNumber = null) {
      return c(paramString, paramNumber);
    }
  }
  
  private b a(String paramString1, String paramString2, File paramFile)
    throws b.e
  {
    return a(paramString1, null, null, paramFile);
  }
  
  private b a(String paramString1, String paramString2, Number paramNumber)
    throws b.e
  {
    if (paramNumber != null) {}
    for (paramString2 = paramNumber.toString();; paramString2 = null) {
      return a(paramString1, null, paramString2);
    }
  }
  
  private b a(String paramString1, String paramString2, String paramString3, File paramFile)
    throws b.e
  {
    try
    {
      paramString3 = new BufferedInputStream(new FileInputStream(paramFile));
      b(paramFile.length());
      return a(paramString1, paramString2, null, paramString3);
    }
    catch (IOException paramString1)
    {
      throw new e(paramString1);
    }
  }
  
  private b a(String paramString1, String paramString2, String paramString3, String paramString4)
    throws b.e
  {
    try
    {
      S();
      b(paramString1, paramString2, null);
      this.O.a(paramString4);
      return this;
    }
    catch (IOException paramString1)
    {
      throw new e(paramString1);
    }
  }
  
  private static b a(URL paramURL)
    throws b.e
  {
    return new b(paramURL, "GET");
  }
  
  private b a(Map.Entry<String, String> paramEntry)
  {
    return c((String)paramEntry.getKey(), (String)paramEntry.getValue());
  }
  
  private b a(Map.Entry<?, ?> paramEntry, String paramString)
    throws b.e
  {
    return a(paramEntry.getKey(), paramEntry.getValue(), paramString);
  }
  
  private b a(Map<?, ?> paramMap, String paramString)
    throws b.e
  {
    if (!paramMap.isEmpty())
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext()) {
        a((Map.Entry)paramMap.next(), paramString);
      }
    }
    return this;
  }
  
  private b a(AtomicInteger paramAtomicInteger)
    throws b.e
  {
    paramAtomicInteger.set(b());
    return this;
  }
  
  private b a(AtomicReference<String> paramAtomicReference)
    throws b.e
  {
    paramAtomicReference.set(c());
    return this;
  }
  
  private b a(AtomicReference<String> paramAtomicReference, String paramString)
    throws b.e
  {
    paramAtomicReference.set(d(paramString));
    return this;
  }
  
  private static String a(CharSequence paramCharSequence, Map<?, ?> paramMap)
  {
    Object localObject = paramCharSequence.toString();
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return (String)localObject;
    }
    paramCharSequence = new StringBuilder((String)localObject);
    a((String)localObject, paramCharSequence);
    b((String)localObject, paramCharSequence);
    paramMap = paramMap.entrySet().iterator();
    localObject = (Map.Entry)paramMap.next();
    a(((Map.Entry)localObject).getKey().toString(), ((Map.Entry)localObject).getValue(), paramCharSequence);
    while (paramMap.hasNext())
    {
      paramCharSequence.append('&');
      localObject = (Map.Entry)paramMap.next();
      a(((Map.Entry)localObject).getKey().toString(), ((Map.Entry)localObject).getValue(), paramCharSequence);
    }
    return paramCharSequence.toString();
  }
  
  private static String a(CharSequence paramCharSequence, Object... paramVarArgs)
  {
    paramCharSequence = paramCharSequence.toString();
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return paramCharSequence;
    }
    if (paramVarArgs.length % 2 != 0) {
      throw new IllegalArgumentException("Must specify an even number of parameter names/values");
    }
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence);
    a(paramCharSequence, localStringBuilder);
    b(paramCharSequence, localStringBuilder);
    a(paramVarArgs[0], paramVarArgs[1], localStringBuilder);
    int i1 = 2;
    while (i1 < paramVarArgs.length)
    {
      localStringBuilder.append('&');
      a(paramVarArgs[i1], paramVarArgs[(i1 + 1)], localStringBuilder);
      i1 += 2;
    }
    return localStringBuilder.toString();
  }
  
  private static StringBuilder a(Object paramObject1, Object paramObject2, StringBuilder paramStringBuilder)
  {
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i1 = 0;
    Object localObject;
    if ((paramObject2 != null) && (paramObject2.getClass().isArray())) {
      if ((paramObject2 instanceof Object[])) {
        localObject = Arrays.asList((Object[])paramObject2);
      }
    }
    for (;;)
    {
      if ((localObject instanceof Iterable))
      {
        paramObject2 = ((Iterable)localObject).iterator();
        while (((Iterator)paramObject2).hasNext())
        {
          paramStringBuilder.append(paramObject1);
          paramStringBuilder.append("[]=");
          localObject = ((Iterator)paramObject2).next();
          if (localObject != null) {
            paramStringBuilder.append(localObject);
          }
          if (((Iterator)paramObject2).hasNext()) {
            paramStringBuilder.append("&");
          }
        }
        ArrayList localArrayList = new ArrayList();
        if ((paramObject2 instanceof int[]))
        {
          paramObject2 = (int[])paramObject2;
          i2 = paramObject2.length;
          for (;;)
          {
            localObject = localArrayList;
            if (i1 >= i2) {
              break;
            }
            localArrayList.add(Integer.valueOf(paramObject2[i1]));
            i1 += 1;
          }
        }
        if ((paramObject2 instanceof boolean[]))
        {
          paramObject2 = (boolean[])paramObject2;
          i3 = paramObject2.length;
          i1 = i2;
          for (;;)
          {
            localObject = localArrayList;
            if (i1 >= i3) {
              break;
            }
            localArrayList.add(Boolean.valueOf(paramObject2[i1]));
            i1 += 1;
          }
        }
        if ((paramObject2 instanceof long[]))
        {
          paramObject2 = (long[])paramObject2;
          i2 = paramObject2.length;
          i1 = i3;
          for (;;)
          {
            localObject = localArrayList;
            if (i1 >= i2) {
              break;
            }
            localArrayList.add(Long.valueOf(paramObject2[i1]));
            i1 += 1;
          }
        }
        if ((paramObject2 instanceof float[]))
        {
          paramObject2 = (float[])paramObject2;
          i2 = paramObject2.length;
          i1 = i4;
          for (;;)
          {
            localObject = localArrayList;
            if (i1 >= i2) {
              break;
            }
            localArrayList.add(Float.valueOf(paramObject2[i1]));
            i1 += 1;
          }
        }
        if ((paramObject2 instanceof double[]))
        {
          paramObject2 = (double[])paramObject2;
          i2 = paramObject2.length;
          i1 = i5;
          for (;;)
          {
            localObject = localArrayList;
            if (i1 >= i2) {
              break;
            }
            localArrayList.add(Double.valueOf(paramObject2[i1]));
            i1 += 1;
          }
        }
        if ((paramObject2 instanceof short[]))
        {
          paramObject2 = (short[])paramObject2;
          i2 = paramObject2.length;
          i1 = i6;
          for (;;)
          {
            localObject = localArrayList;
            if (i1 >= i2) {
              break;
            }
            localArrayList.add(Short.valueOf(paramObject2[i1]));
            i1 += 1;
          }
        }
        if ((paramObject2 instanceof byte[]))
        {
          paramObject2 = (byte[])paramObject2;
          i2 = paramObject2.length;
          i1 = i7;
          for (;;)
          {
            localObject = localArrayList;
            if (i1 >= i2) {
              break;
            }
            localArrayList.add(Byte.valueOf(paramObject2[i1]));
            i1 += 1;
          }
        }
        localObject = localArrayList;
        if ((paramObject2 instanceof char[]))
        {
          paramObject2 = (char[])paramObject2;
          i2 = paramObject2.length;
          i1 = i8;
          for (;;)
          {
            localObject = localArrayList;
            if (i1 >= i2) {
              break;
            }
            localArrayList.add(Character.valueOf(paramObject2[i1]));
            i1 += 1;
          }
        }
      }
      else
      {
        paramStringBuilder.append(paramObject1);
        paramStringBuilder.append("=");
        if (localObject != null) {
          paramStringBuilder.append(localObject);
        }
        return paramStringBuilder;
        localObject = paramObject2;
      }
    }
  }
  
  private static StringBuilder a(String paramString, StringBuilder paramStringBuilder)
  {
    if (paramString.indexOf(':') + 2 == paramString.lastIndexOf('/')) {
      paramStringBuilder.append('/');
    }
    return paramStringBuilder;
  }
  
  private static List<Object> a(Object paramObject)
  {
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i1 = 0;
    Object localObject;
    if ((paramObject instanceof Object[])) {
      localObject = Arrays.asList((Object[])paramObject);
    }
    ArrayList localArrayList;
    do
    {
      return (List<Object>)localObject;
      localArrayList = new ArrayList();
      if ((paramObject instanceof int[]))
      {
        paramObject = (int[])paramObject;
        i2 = paramObject.length;
        for (;;)
        {
          localObject = localArrayList;
          if (i1 >= i2) {
            break;
          }
          localArrayList.add(Integer.valueOf(paramObject[i1]));
          i1 += 1;
        }
      }
      if ((paramObject instanceof boolean[]))
      {
        paramObject = (boolean[])paramObject;
        i3 = paramObject.length;
        i1 = i2;
        for (;;)
        {
          localObject = localArrayList;
          if (i1 >= i3) {
            break;
          }
          localArrayList.add(Boolean.valueOf(paramObject[i1]));
          i1 += 1;
        }
      }
      if ((paramObject instanceof long[]))
      {
        paramObject = (long[])paramObject;
        i2 = paramObject.length;
        i1 = i3;
        for (;;)
        {
          localObject = localArrayList;
          if (i1 >= i2) {
            break;
          }
          localArrayList.add(Long.valueOf(paramObject[i1]));
          i1 += 1;
        }
      }
      if ((paramObject instanceof float[]))
      {
        paramObject = (float[])paramObject;
        i2 = paramObject.length;
        i1 = i4;
        for (;;)
        {
          localObject = localArrayList;
          if (i1 >= i2) {
            break;
          }
          localArrayList.add(Float.valueOf(paramObject[i1]));
          i1 += 1;
        }
      }
      if ((paramObject instanceof double[]))
      {
        paramObject = (double[])paramObject;
        i2 = paramObject.length;
        i1 = i5;
        for (;;)
        {
          localObject = localArrayList;
          if (i1 >= i2) {
            break;
          }
          localArrayList.add(Double.valueOf(paramObject[i1]));
          i1 += 1;
        }
      }
      if ((paramObject instanceof short[]))
      {
        paramObject = (short[])paramObject;
        i2 = paramObject.length;
        i1 = i6;
        for (;;)
        {
          localObject = localArrayList;
          if (i1 >= i2) {
            break;
          }
          localArrayList.add(Short.valueOf(paramObject[i1]));
          i1 += 1;
        }
      }
      if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        i2 = paramObject.length;
        i1 = i7;
        for (;;)
        {
          localObject = localArrayList;
          if (i1 >= i2) {
            break;
          }
          localArrayList.add(Byte.valueOf(paramObject[i1]));
          i1 += 1;
        }
      }
      localObject = localArrayList;
    } while (!(paramObject instanceof char[]));
    paramObject = (char[])paramObject;
    i2 = paramObject.length;
    i1 = i8;
    for (;;)
    {
      localObject = localArrayList;
      if (i1 >= i2) {
        break;
      }
      localArrayList.add(Character.valueOf(paramObject[i1]));
      i1 += 1;
    }
  }
  
  private static void a(c paramc)
  {
    if (paramc == null)
    {
      K = c.a;
      return;
    }
    K = paramc;
  }
  
  private static void a(boolean paramBoolean)
  {
    b("http.keepAlive", Boolean.toString(paramBoolean));
  }
  
  private static void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i2 = paramVarArgs.length - 1;
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder.append(paramVarArgs[i1]).append('|');
        i1 += 1;
      }
      localStringBuilder.append(paramVarArgs[i2]);
      b("http.nonProxyHosts", localStringBuilder.toString());
      return;
    }
    b("http.nonProxyHosts", null);
  }
  
  private int b(String paramString, int paramInt)
    throws b.e
  {
    Q();
    return a().getHeaderFieldInt(paramString, -1);
  }
  
  private b b(long paramLong)
  {
    if (this.U == -1L) {
      this.U = 0L;
    }
    this.U += paramLong;
    return this;
  }
  
  private b b(File paramFile)
    throws b.e
  {
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile));
      b(paramFile.length());
      return a(localBufferedInputStream);
    }
    catch (FileNotFoundException paramFile)
    {
      throw new e(paramFile);
    }
  }
  
  public static b b(CharSequence paramCharSequence)
    throws b.e
  {
    return new b(paramCharSequence, "POST");
  }
  
  private static b b(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    paramMap = a(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = c(paramMap);
    }
    return b(paramCharSequence);
  }
  
  private static b b(CharSequence paramCharSequence, boolean paramBoolean, Object... paramVarArgs)
  {
    paramVarArgs = a(paramCharSequence, paramVarArgs);
    paramCharSequence = paramVarArgs;
    if (paramBoolean) {
      paramCharSequence = c(paramVarArgs);
    }
    return b(paramCharSequence);
  }
  
  private b b(String paramString, Number paramNumber)
    throws b.e
  {
    if (paramNumber != null) {}
    for (paramNumber = paramNumber.toString();; paramNumber = null) {
      return a(paramString, null, paramNumber);
    }
  }
  
  private b b(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"").append(paramString1);
    if (paramString2 != null) {
      localStringBuilder.append("\"; filename=\"").append(paramString2);
    }
    localStringBuilder.append('"');
    j("Content-Disposition", localStringBuilder.toString());
    if (paramString3 != null) {
      j("Content-Type", paramString3);
    }
    return i("\r\n");
  }
  
  private static b b(URL paramURL)
    throws b.e
  {
    return new b(paramURL, "POST");
  }
  
  private b b(Map.Entry<?, ?> paramEntry)
    throws b.e
  {
    return a(paramEntry, "UTF-8");
  }
  
  private b b(Map<?, ?> paramMap)
    throws b.e
  {
    if (!paramMap.isEmpty())
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext()) {
        a((Map.Entry)paramMap.next(), "UTF-8");
      }
    }
    return this;
  }
  
  private b b(boolean paramBoolean)
  {
    this.R = paramBoolean;
    return this;
  }
  
  private static String b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return "UTF-8";
  }
  
  private static String b(String paramString1, final String paramString2)
  {
    if (paramString2 != null) {}
    for (paramString1 = new PrivilegedAction()
        {
          private String a()
          {
            return System.setProperty(this.a, paramString2);
          }
        };; paramString1 = new PrivilegedAction()
        {
          private String a()
          {
            return System.clearProperty(this.a);
          }
        }) {
      return (String)AccessController.doPrivileged(paramString1);
    }
  }
  
  private static StringBuilder b(String paramString, StringBuilder paramStringBuilder)
  {
    int i1 = paramString.indexOf('?');
    int i2 = paramStringBuilder.length() - 1;
    if (i1 == -1) {
      paramStringBuilder.append('?');
    }
    while ((i1 >= i2) || (paramString.charAt(i2) == '&')) {
      return paramStringBuilder;
    }
    paramStringBuilder.append('&');
    return paramStringBuilder;
  }
  
  private static b c(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    paramMap = a(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = c(paramMap);
    }
    return d(paramCharSequence);
  }
  
  private static b c(CharSequence paramCharSequence, boolean paramBoolean, Object... paramVarArgs)
  {
    paramVarArgs = a(paramCharSequence, paramVarArgs);
    paramCharSequence = paramVarArgs;
    if (paramBoolean) {
      paramCharSequence = c(paramVarArgs);
    }
    return d(paramCharSequence);
  }
  
  private b c(String paramString1, String paramString2)
  {
    a().setRequestProperty(paramString1, paramString2);
    return this;
  }
  
  private static b c(URL paramURL)
    throws b.e
  {
    return new b(paramURL, "PUT");
  }
  
  private b c(boolean paramBoolean)
  {
    this.S = paramBoolean;
    return this;
  }
  
  /* Error */
  private static String c(CharSequence paramCharSequence)
    throws b.e
  {
    // Byte code:
    //   0: new 208	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokeinterface 214 1 0
    //   10: invokespecial 217	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 714	java/net/URL:getHost	()Ljava/lang/String;
    //   18: astore_2
    //   19: aload_3
    //   20: invokevirtual 717	java/net/URL:getPort	()I
    //   23: istore_1
    //   24: aload_2
    //   25: astore_0
    //   26: iload_1
    //   27: iconst_m1
    //   28: if_icmpeq +30 -> 58
    //   31: new 529	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 666	java/lang/StringBuilder:<init>	()V
    //   38: aload_2
    //   39: invokevirtual 577	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: bipush 58
    //   44: invokevirtual 542	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   47: iload_1
    //   48: invokestatic 720	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   51: invokevirtual 577	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_0
    //   58: new 722	java/net/URI
    //   61: dup
    //   62: aload_3
    //   63: invokevirtual 725	java/net/URL:getProtocol	()Ljava/lang/String;
    //   66: aload_0
    //   67: aload_3
    //   68: invokevirtual 728	java/net/URL:getPath	()Ljava/lang/String;
    //   71: aload_3
    //   72: invokevirtual 731	java/net/URL:getQuery	()Ljava/lang/String;
    //   75: aconst_null
    //   76: invokespecial 734	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   79: invokevirtual 737	java/net/URI:toASCIIString	()Ljava/lang/String;
    //   82: astore_2
    //   83: aload_2
    //   84: bipush 63
    //   86: invokevirtual 651	java/lang/String:indexOf	(I)I
    //   89: istore_1
    //   90: aload_2
    //   91: astore_0
    //   92: iload_1
    //   93: ifle +56 -> 149
    //   96: aload_2
    //   97: astore_0
    //   98: iload_1
    //   99: iconst_1
    //   100: iadd
    //   101: aload_2
    //   102: invokevirtual 689	java/lang/String:length	()I
    //   105: if_icmpge +44 -> 149
    //   108: new 529	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 666	java/lang/StringBuilder:<init>	()V
    //   115: aload_2
    //   116: iconst_0
    //   117: iload_1
    //   118: iconst_1
    //   119: iadd
    //   120: invokevirtual 741	java/lang/String:substring	(II)Ljava/lang/String;
    //   123: invokevirtual 577	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_2
    //   127: iload_1
    //   128: iconst_1
    //   129: iadd
    //   130: invokevirtual 743	java/lang/String:substring	(I)Ljava/lang/String;
    //   133: ldc_w 745
    //   136: ldc_w 747
    //   139: invokevirtual 751	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   142: invokevirtual 577	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 543	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore_0
    //   149: aload_0
    //   150: areturn
    //   151: astore_0
    //   152: new 40	com/mato/sdk/f/b$e
    //   155: dup
    //   156: aload_0
    //   157: invokespecial 224	com/mato/sdk/f/b$e:<init>	(Ljava/io/IOException;)V
    //   160: athrow
    //   161: astore_0
    //   162: new 266	java/io/IOException
    //   165: dup
    //   166: ldc_w 753
    //   169: invokespecial 754	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   172: astore_2
    //   173: aload_2
    //   174: aload_0
    //   175: invokevirtual 758	java/io/IOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   178: pop
    //   179: new 40	com/mato/sdk/f/b$e
    //   182: dup
    //   183: aload_2
    //   184: invokespecial 224	com/mato/sdk/f/b$e:<init>	(Ljava/io/IOException;)V
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramCharSequence	CharSequence
    //   23	107	1	i1	int
    //   18	166	2	localObject	Object
    //   13	59	3	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   0	14	151	java/io/IOException
    //   58	90	161	java/net/URISyntaxException
    //   98	149	161	java/net/URISyntaxException
  }
  
  private static void c(int paramInt)
  {
    b("http.maxConnections", Integer.toString(paramInt));
  }
  
  private static void c(String paramString)
  {
    b("http.proxyHost", paramString);
    b("https.proxyHost", paramString);
  }
  
  private static b d(CharSequence paramCharSequence)
    throws b.e
  {
    return new b(paramCharSequence, "PUT");
  }
  
  private static b d(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    paramMap = a(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = c(paramMap);
    }
    return e(paramCharSequence);
  }
  
  private static b d(CharSequence paramCharSequence, boolean paramBoolean, Object... paramVarArgs)
  {
    paramVarArgs = a(paramCharSequence, paramVarArgs);
    paramCharSequence = paramVarArgs;
    if (paramBoolean) {
      paramCharSequence = c(paramVarArgs);
    }
    return e(paramCharSequence);
  }
  
  private static b d(URL paramURL)
    throws b.e
  {
    return new b(paramURL, "DELETE");
  }
  
  private b d(boolean paramBoolean)
  {
    a().setUseCaches(paramBoolean);
    return this;
  }
  
  private String d(String paramString)
    throws b.e
  {
    ByteArrayOutputStream localByteArrayOutputStream = v();
    try
    {
      a(y(), localByteArrayOutputStream);
      paramString = localByteArrayOutputStream.toString(b(paramString));
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new e(paramString);
    }
  }
  
  private String d(String paramString1, String paramString2)
  {
    return e(g(paramString1), paramString2);
  }
  
  private static void d(int paramInt)
  {
    String str = Integer.toString(paramInt);
    b("http.proxyPort", str);
    b("https.proxyPort", str);
  }
  
  private b e(int paramInt)
  {
    a().setChunkedStreamingMode(paramInt);
    return this;
  }
  
  private static b e(CharSequence paramCharSequence)
    throws b.e
  {
    return new b(paramCharSequence, "DELETE");
  }
  
  private static b e(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean)
  {
    paramMap = a(paramCharSequence, paramMap);
    paramCharSequence = paramMap;
    if (paramBoolean) {
      paramCharSequence = c(paramMap);
    }
    return f(paramCharSequence);
  }
  
  private static b e(CharSequence paramCharSequence, boolean paramBoolean, Object... paramVarArgs)
  {
    paramVarArgs = a(paramCharSequence, paramVarArgs);
    paramCharSequence = paramVarArgs;
    if (paramBoolean) {
      paramCharSequence = c(paramVarArgs);
    }
    return f(paramCharSequence);
  }
  
  private static b e(URL paramURL)
    throws b.e
  {
    return new b(paramURL, "HEAD");
  }
  
  private b e(boolean paramBoolean)
  {
    a().setInstanceFollowRedirects(paramBoolean);
    return this;
  }
  
  private InputStreamReader e(String paramString)
    throws b.e
  {
    try
    {
      paramString = new InputStreamReader(z(), b(paramString));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new e(paramString);
    }
  }
  
  private static String e(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      paramString1 = null;
      return paramString1;
    }
    int i3 = paramString1.length();
    int i1 = paramString1.indexOf(';') + 1;
    if ((i1 == 0) || (i1 == i3)) {
      return null;
    }
    int i2 = paramString1.indexOf(';', i1);
    if (i2 == -1) {
      i2 = i3;
    }
    for (;;)
    {
      if (i1 < i2)
      {
        int i4 = paramString1.indexOf('=', i1);
        if ((i4 != -1) && (i4 < i2) && (paramString2.equals(paramString1.substring(i1, i4).trim())))
        {
          String str = paramString1.substring(i4 + 1, i2).trim();
          i1 = str.length();
          if (i1 != 0)
          {
            paramString1 = str;
            if (i1 <= 2) {
              break;
            }
            paramString1 = str;
            if ('"' != str.charAt(0)) {
              break;
            }
            paramString1 = str;
            if ('"' != str.charAt(i1 - 1)) {
              break;
            }
            return str.substring(1, i1 - 1);
          }
        }
        i2 += 1;
        i4 = paramString1.indexOf(';', i2);
        i1 = i4;
        if (i4 == -1) {
          i1 = i3;
        }
        i4 = i1;
        i1 = i2;
        i2 = i4;
        continue;
      }
      return null;
    }
  }
  
  private b f(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Size must be greater than zero");
    }
    this.T = paramInt;
    return this;
  }
  
  private static b f(CharSequence paramCharSequence)
    throws b.e
  {
    return new b(paramCharSequence, "HEAD");
  }
  
  private b f(String paramString1, String paramString2)
  {
    return c("Authorization", "Basic " + a.a(new StringBuilder().append(paramString1).append(':').append(paramString2).toString()));
  }
  
  private static b f(URL paramURL)
    throws b.e
  {
    return new b(paramURL, "OPTIONS");
  }
  
  private BufferedReader f(String paramString)
    throws b.e
  {
    return new BufferedReader(e(paramString), this.T);
  }
  
  private b g(int paramInt)
  {
    a().setFixedLengthStreamingMode(paramInt);
    return this;
  }
  
  private static b g(CharSequence paramCharSequence)
    throws b.e
  {
    return new b(paramCharSequence, "OPTIONS");
  }
  
  private b g(String paramString1, String paramString2)
  {
    return c("Proxy-Authorization", "Basic " + a.a(new StringBuilder().append(paramString1).append(':').append(paramString2).toString()));
  }
  
  private static b g(URL paramURL)
    throws b.e
  {
    return new b(paramURL, "TRACE");
  }
  
  private String g(String paramString)
    throws b.e
  {
    Q();
    return a().getHeaderField(paramString);
  }
  
  /* Error */
  private static SSLSocketFactory g()
    throws b.e
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 829	com/mato/sdk/f/b:I	Ljavax/net/ssl/SSLSocketFactory;
    //   6: ifnonnull +47 -> 53
    //   9: new 6	com/mato/sdk/f/b$1
    //   12: dup
    //   13: invokespecial 830	com/mato/sdk/f/b$1:<init>	()V
    //   16: astore_0
    //   17: ldc_w 832
    //   20: invokestatic 838	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   23: astore_1
    //   24: new 840	java/security/SecureRandom
    //   27: dup
    //   28: invokespecial 841	java/security/SecureRandom:<init>	()V
    //   31: astore_2
    //   32: aload_1
    //   33: aconst_null
    //   34: iconst_1
    //   35: anewarray 843	javax/net/ssl/TrustManager
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: aastore
    //   42: aload_2
    //   43: invokevirtual 847	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   46: aload_1
    //   47: invokevirtual 850	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   50: putstatic 829	com/mato/sdk/f/b:I	Ljavax/net/ssl/SSLSocketFactory;
    //   53: getstatic 829	com/mato/sdk/f/b:I	Ljavax/net/ssl/SSLSocketFactory;
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: areturn
    //   62: astore_0
    //   63: new 266	java/io/IOException
    //   66: dup
    //   67: ldc_w 852
    //   70: invokespecial 754	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   73: astore_1
    //   74: aload_1
    //   75: aload_0
    //   76: invokevirtual 758	java/io/IOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   79: pop
    //   80: new 40	com/mato/sdk/f/b$e
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 224	com/mato/sdk/f/b$e:<init>	(Ljava/io/IOException;)V
    //   88: athrow
    //   89: astore_0
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	45	0	localObject1	Object
    //   62	14	0	localGeneralSecurityException	java.security.GeneralSecurityException
    //   89	5	0	localObject2	Object
    //   23	62	1	localObject3	Object
    //   31	12	2	localSecureRandom	java.security.SecureRandom
    // Exception table:
    //   from	to	target	type
    //   17	53	62	java/security/GeneralSecurityException
    //   3	17	89	finally
    //   17	53	89	finally
    //   53	57	89	finally
    //   63	89	89	finally
  }
  
  private long h(String paramString)
    throws b.e
  {
    Q();
    return a().getHeaderFieldDate(paramString, -1L);
  }
  
  private static b h(CharSequence paramCharSequence)
    throws b.e
  {
    return new b(paramCharSequence, "TRACE");
  }
  
  private b h(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      return c("Content-Type", paramString1 + "; charset=" + paramString2);
    }
    return c("Content-Type", paramString1);
  }
  
  private static HostnameVerifier h()
  {
    try
    {
      if (J == null) {
        J = new HostnameVerifier()
        {
          public final boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
          {
            return true;
          }
        };
      }
      HostnameVerifier localHostnameVerifier = J;
      return localHostnameVerifier;
    }
    finally {}
  }
  
  private int i(String paramString)
    throws b.e
  {
    Q();
    return a().getHeaderFieldInt(paramString, -1);
  }
  
  private b i(CharSequence paramCharSequence)
    throws b.e
  {
    try
    {
      R();
      this.O.a(paramCharSequence.toString());
      return this;
    }
    catch (IOException paramCharSequence)
    {
      throw new e(paramCharSequence);
    }
  }
  
  private b i(String paramString1, String paramString2)
    throws IOException
  {
    return b(paramString1, paramString2, null);
  }
  
  private Proxy i()
  {
    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.W, this.X));
  }
  
  private b j(String paramString1, String paramString2)
    throws b.e
  {
    return i(paramString1).i(": ").i(paramString2).i("\r\n");
  }
  
  /* Error */
  private HttpURLConnection j()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 871	com/mato/sdk/f/b:W	Ljava/lang/String;
    //   4: ifnull +51 -> 55
    //   7: getstatic 181	com/mato/sdk/f/b:K	Lcom/mato/sdk/f/b$c;
    //   10: aload_0
    //   11: getfield 219	com/mato/sdk/f/b:M	Ljava/net/URL;
    //   14: new 861	java/net/Proxy
    //   17: dup
    //   18: getstatic 867	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   21: new 869	java/net/InetSocketAddress
    //   24: dup
    //   25: aload_0
    //   26: getfield 871	com/mato/sdk/f/b:W	Ljava/lang/String;
    //   29: aload_0
    //   30: getfield 873	com/mato/sdk/f/b:X	I
    //   33: invokespecial 876	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   36: invokespecial 879	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   39: invokeinterface 884 3 0
    //   44: astore_1
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 221	com/mato/sdk/f/b:N	Ljava/lang/String;
    //   50: invokevirtual 887	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   53: aload_1
    //   54: areturn
    //   55: getstatic 181	com/mato/sdk/f/b:K	Lcom/mato/sdk/f/b$c;
    //   58: aload_0
    //   59: getfield 219	com/mato/sdk/f/b:M	Ljava/net/URL;
    //   62: invokeinterface 890 2 0
    //   67: astore_1
    //   68: goto -23 -> 45
    //   71: astore_1
    //   72: new 40	com/mato/sdk/f/b$e
    //   75: dup
    //   76: aload_1
    //   77: invokespecial 224	com/mato/sdk/f/b$e:<init>	(Ljava/io/IOException;)V
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	b
    //   44	24	1	localHttpURLConnection	HttpURLConnection
    //   71	6	1	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	45	71	java/io/IOException
    //   45	53	71	java/io/IOException
    //   55	68	71	java/io/IOException
  }
  
  private String[] j(String paramString)
  {
    Map localMap = d();
    if ((localMap == null) || (localMap.isEmpty())) {
      return H;
    }
    paramString = (List)localMap.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (String[])paramString.toArray(new String[paramString.size()]);
    }
    return H;
  }
  
  private Map<String, String> k(String paramString)
  {
    paramString = g(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return Collections.emptyMap();
    }
    int i2 = paramString.length();
    int i3 = paramString.indexOf(';') + 1;
    if ((i3 == 0) || (i3 == i2)) {
      return Collections.emptyMap();
    }
    int i4 = paramString.indexOf(';', i3);
    int i1 = i4;
    if (i4 == -1) {
      i1 = i2;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (i3 < i1)
    {
      i4 = paramString.indexOf('=', i3);
      String str1;
      String str2;
      if ((i4 != -1) && (i4 < i1))
      {
        str1 = paramString.substring(i3, i4).trim();
        if (str1.length() > 0)
        {
          str2 = paramString.substring(i4 + 1, i1).trim();
          i3 = str2.length();
          if (i3 != 0)
          {
            if ((i3 <= 2) || ('"' != str2.charAt(0)) || ('"' != str2.charAt(i3 - 1))) {
              break label244;
            }
            localLinkedHashMap.put(str1, str2.substring(1, i3 - 1));
          }
        }
      }
      for (;;)
      {
        i4 = i1 + 1;
        int i5 = paramString.indexOf(';', i4);
        i1 = i5;
        i3 = i4;
        if (i5 != -1) {
          break;
        }
        i1 = i2;
        i3 = i4;
        break;
        label244:
        localLinkedHashMap.put(str1, str2);
      }
    }
    return localLinkedHashMap;
  }
  
  private boolean k()
  {
    return this.R;
  }
  
  private static Map<String, String> l(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return Collections.emptyMap();
    }
    int i2 = paramString.length();
    int i3 = paramString.indexOf(';') + 1;
    if ((i3 == 0) || (i3 == i2)) {
      return Collections.emptyMap();
    }
    int i4 = paramString.indexOf(';', i3);
    int i1 = i4;
    if (i4 == -1) {
      i1 = i2;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (i3 < i1)
    {
      i4 = paramString.indexOf('=', i3);
      String str1;
      String str2;
      if ((i4 != -1) && (i4 < i1))
      {
        str1 = paramString.substring(i3, i4).trim();
        if (str1.length() > 0)
        {
          str2 = paramString.substring(i4 + 1, i1).trim();
          i3 = str2.length();
          if (i3 != 0)
          {
            if ((i3 <= 2) || ('"' != str2.charAt(0)) || ('"' != str2.charAt(i3 - 1))) {
              break label224;
            }
            localLinkedHashMap.put(str1, str2.substring(1, i3 - 1));
          }
        }
      }
      for (;;)
      {
        i4 = i1 + 1;
        int i5 = paramString.indexOf(';', i4);
        i1 = i5;
        i3 = i4;
        if (i5 != -1) {
          break;
        }
        i1 = i2;
        i3 = i4;
        break;
        label224:
        localLinkedHashMap.put(str1, str2);
      }
    }
    return localLinkedHashMap;
  }
  
  private boolean l()
    throws b.e
  {
    return 200 == b();
  }
  
  private b m(String paramString)
  {
    return c("User-Agent", paramString);
  }
  
  private boolean m()
    throws b.e
  {
    return 201 == b();
  }
  
  private b n(String paramString)
  {
    return c("Referer", paramString);
  }
  
  private boolean n()
    throws b.e
  {
    return 204 == b();
  }
  
  private b o(String paramString)
  {
    return c("Accept-Encoding", paramString);
  }
  
  private boolean o()
    throws b.e
  {
    return 500 == b();
  }
  
  private b p(String paramString)
  {
    return c("Accept-Charset", paramString);
  }
  
  private boolean p()
    throws b.e
  {
    return 400 == b();
  }
  
  private b q(String paramString)
  {
    return c("Authorization", paramString);
  }
  
  private boolean q()
    throws b.e
  {
    return 404 == b();
  }
  
  private b r(String paramString)
  {
    return c("Proxy-Authorization", paramString);
  }
  
  private boolean r()
    throws b.e
  {
    return 304 == b();
  }
  
  private b s(String paramString)
  {
    return c("If-None-Match", paramString);
  }
  
  private String s()
    throws b.e
  {
    try
    {
      P();
      String str = a().getResponseMessage();
      return str;
    }
    catch (IOException localIOException)
    {
      throw new e(localIOException);
    }
  }
  
  private b t()
  {
    a().disconnect();
    return this;
  }
  
  private b t(String paramString)
  {
    return h(paramString, null);
  }
  
  private int u()
  {
    return this.T;
  }
  
  private b u(String paramString)
  {
    int i1 = Integer.parseInt(paramString);
    a().setFixedLengthStreamingMode(i1);
    return this;
  }
  
  private b v(String paramString)
  {
    return c("Accept", paramString);
  }
  
  private ByteArrayOutputStream v()
  {
    int i1 = N();
    if (i1 > 0) {
      return new ByteArrayOutputStream(i1);
    }
    return new ByteArrayOutputStream();
  }
  
  private boolean w()
    throws b.e
  {
    return N() == 0;
  }
  
  private byte[] x()
    throws b.e
  {
    ByteArrayOutputStream localByteArrayOutputStream = v();
    try
    {
      a(y(), localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      throw new e(localIOException);
    }
  }
  
  private BufferedInputStream y()
    throws b.e
  {
    return new BufferedInputStream(z(), this.T);
  }
  
  private InputStream z()
    throws b.e
  {
    if (b() < 400) {}
    Object localObject2;
    for (;;)
    {
      try
      {
        InputStream localInputStream1 = a().getInputStream();
        if ((this.S) && ("gzip".equals(g("Content-Encoding")))) {
          break;
        }
        return localInputStream1;
      }
      catch (IOException localIOException1)
      {
        throw new e(localIOException1);
      }
      InputStream localInputStream2 = a().getErrorStream();
      Object localObject1 = localInputStream2;
      if (localInputStream2 == null) {
        try
        {
          localObject1 = a().getInputStream();
        }
        catch (IOException localIOException2)
        {
          if (N() > 0) {
            throw new e(localIOException2);
          }
          localObject2 = new ByteArrayInputStream(new byte[0]);
        }
      }
    }
    try
    {
      localObject2 = new GZIPInputStream((InputStream)localObject2);
      return (InputStream)localObject2;
    }
    catch (IOException localIOException3)
    {
      throw new e(localIOException3);
    }
  }
  
  public final b a(int paramInt)
  {
    a().setReadTimeout(paramInt);
    return this;
  }
  
  public final b a(OutputStream paramOutputStream)
    throws b.e
  {
    try
    {
      paramOutputStream = a(y(), paramOutputStream);
      return paramOutputStream;
    }
    catch (IOException paramOutputStream)
    {
      throw new e(paramOutputStream);
    }
  }
  
  protected final b a(final Reader paramReader, final Writer paramWriter)
    throws IOException
  {
    (b)new b(paramReader, this.R)
    {
      private b c()
        throws IOException
      {
        char[] arrayOfChar = new char[b.a(b.this)];
        for (;;)
        {
          int i = paramReader.read(arrayOfChar);
          if (i == -1) {
            break;
          }
          paramWriter.write(arrayOfChar, 0, i);
          b.a(b.this, i);
          b.h localh = b.d(b.this);
          b.b(b.this);
          localh.a();
        }
        return b.this;
      }
    }.call();
  }
  
  public final b a(String paramString, int paramInt)
  {
    if (this.L != null) {
      throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
    }
    this.W = paramString;
    this.X = paramInt;
    return this;
  }
  
  public final b a(String paramString1, String paramString2)
  {
    return a(paramString1, null, paramString2);
  }
  
  public final b a(String paramString1, String paramString2, String paramString3)
    throws b.e
  {
    return a(paramString1, paramString2, null, paramString3);
  }
  
  public final b a(String paramString1, String paramString2, String paramString3, InputStream paramInputStream)
    throws b.e
  {
    try
    {
      S();
      b(paramString1, paramString2, paramString3);
      a(paramInputStream, this.O);
      return this;
    }
    catch (IOException paramString1)
    {
      throw new e(paramString1);
    }
  }
  
  public final b a(Map<String, String> paramMap)
  {
    if (!paramMap.isEmpty())
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        c((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return this;
  }
  
  public final b a(SSLSocketFactory paramSSLSocketFactory)
  {
    HttpURLConnection localHttpURLConnection = a();
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(paramSSLSocketFactory);
    }
    return this;
  }
  
  public final b a(byte[] paramArrayOfByte)
    throws b.e
  {
    if (paramArrayOfByte != null) {
      b(paramArrayOfByte.length);
    }
    return a(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public final HttpURLConnection a()
  {
    if (this.L == null) {
      this.L = j();
    }
    return this.L;
  }
  
  public final int b()
    throws b.e
  {
    try
    {
      P();
      int i1 = a().getResponseCode();
      return i1;
    }
    catch (IOException localIOException)
    {
      throw new e(localIOException);
    }
  }
  
  public final b b(int paramInt)
  {
    a().setConnectTimeout(paramInt);
    return this;
  }
  
  public final String c()
    throws b.e
  {
    return d(C());
  }
  
  public final Map<String, List<String>> d()
    throws b.e
  {
    Q();
    return a().getHeaderFields();
  }
  
  public final URL e()
  {
    return a().getURL();
  }
  
  public final String f()
  {
    return a().getRequestMethod();
  }
  
  public final String toString()
  {
    return a().getRequestMethod() + ' ' + a().getURL();
  }
  
  public static final class a
  {
    private static final byte a = 61;
    private static final String b = "US-ASCII";
    private static final byte[] c = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
    
    public static String a(String paramString)
    {
      try
      {
        byte[] arrayOfByte = paramString.getBytes("US-ASCII");
        paramString = arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          paramString = paramString.getBytes();
        }
      }
      return a(paramString, 0, paramString.length);
    }
    
    private static String a(byte[] paramArrayOfByte)
    {
      return a(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (paramArrayOfByte == null) {
        throw new NullPointerException("Cannot serialize a null array.");
      }
      if (paramInt2 < 0) {
        throw new IllegalArgumentException("Cannot have length offset: " + paramInt2);
      }
      if (0 + paramInt2 > paramArrayOfByte.length) {
        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) }));
      }
      int i = paramInt2 / 3;
      if (paramInt2 % 3 > 0) {}
      Object localObject;
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        localObject = new byte[paramInt1 + (i << 2)];
        paramInt1 = 0;
        i = 0;
        while (i < paramInt2 - 2)
        {
          a(paramArrayOfByte, i + 0, 3, (byte[])localObject, paramInt1);
          i += 3;
          paramInt1 += 4;
        }
      }
      int j = paramInt1;
      if (i < paramInt2)
      {
        a(paramArrayOfByte, i + 0, paramInt2 - i, (byte[])localObject, paramInt1);
        j = paramInt1 + 4;
      }
      if (j <= localObject.length - 1)
      {
        paramArrayOfByte = new byte[j];
        System.arraycopy(localObject, 0, paramArrayOfByte, 0, j);
      }
      for (;;)
      {
        try
        {
          localObject = new String(paramArrayOfByte, "US-ASCII");
          return (String)localObject;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
        paramArrayOfByte = (byte[])localObject;
      }
      return new String(paramArrayOfByte);
    }
    
    private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    {
      int k = 0;
      byte[] arrayOfByte = c;
      int i;
      if (paramInt2 > 0)
      {
        i = paramArrayOfByte1[paramInt1] << 24 >>> 8;
        label23:
        if (paramInt2 <= 1) {
          break label104;
        }
      }
      label104:
      for (int j = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; j = 0)
      {
        if (paramInt2 > 2) {
          k = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
        }
        paramInt1 = k | j | i;
        switch (paramInt2)
        {
        default: 
          return paramArrayOfByte2;
          i = 0;
          break label23;
        }
      }
      paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
      paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(paramInt1 & 0x3F)];
      return paramArrayOfByte2;
      paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
      paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(paramInt1 >>> 6 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 3)] = 61;
      return paramArrayOfByte2;
      paramArrayOfByte2[paramInt3] = arrayOfByte[(paramInt1 >>> 18)];
      paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(paramInt1 >>> 12 & 0x3F)];
      paramArrayOfByte2[(paramInt3 + 2)] = 61;
      paramArrayOfByte2[(paramInt3 + 3)] = 61;
      return paramArrayOfByte2;
    }
    
    private static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (paramArrayOfByte == null) {
        throw new NullPointerException("Cannot serialize a null array.");
      }
      if (paramInt1 < 0) {
        throw new IllegalArgumentException("Cannot have negative offset: " + paramInt1);
      }
      if (paramInt2 < 0) {
        throw new IllegalArgumentException("Cannot have length offset: " + paramInt2);
      }
      if (paramInt1 + paramInt2 > paramArrayOfByte.length) {
        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) }));
      }
      int j = paramInt2 / 3;
      if (paramInt2 % 3 > 0) {}
      byte[] arrayOfByte;
      for (int i = 4;; i = 0)
      {
        arrayOfByte = new byte[i + (j << 2)];
        i = 0;
        j = 0;
        while (j < paramInt2 - 2)
        {
          a(paramArrayOfByte, j + paramInt1, 3, arrayOfByte, i);
          j += 3;
          i += 4;
        }
      }
      int k = i;
      if (j < paramInt2)
      {
        a(paramArrayOfByte, j + paramInt1, paramInt2 - j, arrayOfByte, i);
        k = i + 4;
      }
      if (k <= arrayOfByte.length - 1)
      {
        paramArrayOfByte = new byte[k];
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, k);
        return paramArrayOfByte;
      }
      return arrayOfByte;
    }
  }
  
  public static abstract class b<V>
    extends b.f<V>
  {
    private final Closeable a;
    private final boolean b;
    
    protected b(Closeable paramCloseable, boolean paramBoolean)
    {
      this.a = paramCloseable;
      this.b = paramBoolean;
    }
    
    protected final void b()
      throws IOException
    {
      if ((this.a instanceof Flushable)) {
        ((Flushable)this.a).flush();
      }
      if (this.b) {}
      try
      {
        this.a.close();
        return;
      }
      catch (IOException localIOException) {}
      this.a.close();
      return;
    }
  }
  
  public static abstract interface c
  {
    public static final c a = new c()
    {
      public final HttpURLConnection a(URL paramAnonymousURL)
        throws IOException
      {
        return (HttpURLConnection)paramAnonymousURL.openConnection();
      }
      
      public final HttpURLConnection a(URL paramAnonymousURL, Proxy paramAnonymousProxy)
        throws IOException
      {
        return (HttpURLConnection)paramAnonymousURL.openConnection(paramAnonymousProxy);
      }
    };
    
    public abstract HttpURLConnection a(URL paramURL)
      throws IOException;
    
    public abstract HttpURLConnection a(URL paramURL, Proxy paramProxy)
      throws IOException;
  }
  
  public static abstract class d<V>
    extends b.f<V>
  {
    private final Flushable a;
    
    protected d(Flushable paramFlushable)
    {
      this.a = paramFlushable;
    }
    
    protected final void b()
      throws IOException
    {
      this.a.flush();
    }
  }
  
  public static final class e
    extends RuntimeException
  {
    private static final long serialVersionUID = -1170466989781746231L;
    
    public e(IOException paramIOException)
    {
      super();
    }
    
    public final IOException a()
    {
      return (IOException)super.getCause();
    }
  }
  
  public static abstract class f<V>
    implements Callable<V>
  {
    protected abstract V a()
      throws b.e, IOException;
    
    protected abstract void b()
      throws IOException;
    
    /* Error */
    public V call()
      throws b.e
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: invokevirtual 25	com/mato/sdk/f/b$f:a	()Ljava/lang/Object;
      //   6: astore_2
      //   7: aload_0
      //   8: invokevirtual 27	com/mato/sdk/f/b$f:b	()V
      //   11: aload_2
      //   12: areturn
      //   13: astore_2
      //   14: new 19	com/mato/sdk/f/b$e
      //   17: dup
      //   18: aload_2
      //   19: invokespecial 30	com/mato/sdk/f/b$e:<init>	(Ljava/io/IOException;)V
      //   22: athrow
      //   23: astore_2
      //   24: aload_2
      //   25: athrow
      //   26: astore_2
      //   27: aload_0
      //   28: invokevirtual 27	com/mato/sdk/f/b$f:b	()V
      //   31: aload_2
      //   32: athrow
      //   33: astore_2
      //   34: new 19	com/mato/sdk/f/b$e
      //   37: dup
      //   38: aload_2
      //   39: invokespecial 30	com/mato/sdk/f/b$e:<init>	(Ljava/io/IOException;)V
      //   42: athrow
      //   43: astore_3
      //   44: iload_1
      //   45: ifne -14 -> 31
      //   48: new 19	com/mato/sdk/f/b$e
      //   51: dup
      //   52: aload_3
      //   53: invokespecial 30	com/mato/sdk/f/b$e:<init>	(Ljava/io/IOException;)V
      //   56: athrow
      //   57: astore_2
      //   58: iconst_0
      //   59: istore_1
      //   60: goto -33 -> 27
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	f
      //   1	59	1	i	int
      //   6	6	2	localObject1	Object
      //   13	6	2	localIOException1	IOException
      //   23	2	2	locale	b.e
      //   26	6	2	localObject2	Object
      //   33	6	2	localIOException2	IOException
      //   57	1	2	localObject3	Object
      //   43	10	3	localIOException3	IOException
      // Exception table:
      //   from	to	target	type
      //   7	11	13	java/io/IOException
      //   2	7	23	com/mato/sdk/f/b$e
      //   24	26	26	finally
      //   34	43	26	finally
      //   2	7	33	java/io/IOException
      //   27	31	43	java/io/IOException
      //   2	7	57	finally
    }
  }
  
  public static final class g
    extends BufferedOutputStream
  {
    private final CharsetEncoder a;
    
    public g(OutputStream paramOutputStream, String paramString, int paramInt)
    {
      super(paramInt);
      this.a = Charset.forName(b.a(paramString)).newEncoder();
    }
    
    public final g a(String paramString)
      throws IOException
    {
      paramString = this.a.encode(CharBuffer.wrap(paramString));
      super.write(paramString.array(), 0, paramString.limit());
      return this;
    }
  }
  
  public static abstract interface h
  {
    public static final h a = new h()
    {
      public final void a() {}
    };
    
    public abstract void a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */