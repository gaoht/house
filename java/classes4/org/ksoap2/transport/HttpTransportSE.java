package org.ksoap2.transport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.ksoap2.SoapEnvelope;
import org.xmlpull.v1.XmlPullParserException;

public class HttpTransportSE
  extends Transport
{
  public HttpTransportSE(String paramString)
  {
    super(null, paramString);
  }
  
  public HttpTransportSE(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public HttpTransportSE(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1);
  }
  
  public HttpTransportSE(Proxy paramProxy, String paramString)
  {
    super(paramProxy, paramString);
  }
  
  public HttpTransportSE(Proxy paramProxy, String paramString, int paramInt)
  {
    super(paramProxy, paramString, paramInt);
  }
  
  public HttpTransportSE(Proxy paramProxy, String paramString, int paramInt1, int paramInt2)
  {
    super(paramProxy, paramString, paramInt1);
  }
  
  private InputStream getUnZippedInputStream(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      GZIPInputStream localGZIPInputStream = (GZIPInputStream)paramInputStream;
      return localGZIPInputStream;
    }
    catch (ClassCastException localClassCastException) {}
    return new GZIPInputStream(paramInputStream);
  }
  
  private InputStream readDebug(InputStream paramInputStream, int paramInt, File paramFile)
    throws IOException
  {
    byte[] arrayOfByte;
    if (paramFile != null)
    {
      localObject = new FileOutputStream(paramFile);
      arrayOfByte = new byte['Ā'];
      label21:
      paramInt = paramInputStream.read(arrayOfByte, 0, 256);
      if (paramInt != -1) {
        break label113;
      }
      ((OutputStream)localObject).flush();
      if (!(localObject instanceof ByteArrayOutputStream)) {
        break label135;
      }
    }
    label113:
    label135:
    for (Object localObject = ((ByteArrayOutputStream)localObject).toByteArray();; localObject = arrayOfByte)
    {
      this.responseDump = new String((byte[])localObject);
      paramInputStream.close();
      if (paramFile != null)
      {
        return new FileInputStream(paramFile);
        if (paramInt > 0) {}
        for (;;)
        {
          localObject = new ByteArrayOutputStream(paramInt);
          break;
          paramInt = 262144;
        }
        ((OutputStream)localObject).write(arrayOfByte, 0, paramInt);
        break label21;
      }
      return new ByteArrayInputStream((byte[])localObject);
    }
  }
  
  public List call(String paramString, SoapEnvelope paramSoapEnvelope, List paramList)
    throws HttpResponseException, IOException, XmlPullParserException
  {
    return call(paramString, paramSoapEnvelope, paramList, null);
  }
  
  /* Error */
  public List call(String paramString, SoapEnvelope paramSoapEnvelope, List paramList, File paramFile)
    throws HttpResponseException, IOException, XmlPullParserException
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 13
    //   3: aload_1
    //   4: ifnonnull +7 -> 11
    //   7: ldc 94
    //   9: astore 13
    //   11: aload_0
    //   12: aload_2
    //   13: ldc 96
    //   15: invokevirtual 100	org/ksoap2/transport/HttpTransportSE:createRequestData	(Lorg/ksoap2/SoapEnvelope;Ljava/lang/String;)[B
    //   18: astore 14
    //   20: aload_0
    //   21: getfield 104	org/ksoap2/transport/HttpTransportSE:debug	Z
    //   24: ifeq +185 -> 209
    //   27: new 57	java/lang/String
    //   30: dup
    //   31: aload 14
    //   33: invokespecial 60	java/lang/String:<init>	([B)V
    //   36: astore_1
    //   37: aload_0
    //   38: aload_1
    //   39: putfield 107	org/ksoap2/transport/HttpTransportSE:requestDump	Ljava/lang/String;
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 64	org/ksoap2/transport/HttpTransportSE:responseDump	Ljava/lang/String;
    //   47: aload_0
    //   48: invokevirtual 111	org/ksoap2/transport/HttpTransportSE:getServiceConnection	()Lorg/ksoap2/transport/ServiceConnection;
    //   51: astore 16
    //   53: aload 16
    //   55: ldc 113
    //   57: ldc 115
    //   59: invokeinterface 121 3 0
    //   64: aload_2
    //   65: getfield 127	org/ksoap2/SoapEnvelope:version	I
    //   68: bipush 120
    //   70: if_icmpeq +14 -> 84
    //   73: aload 16
    //   75: ldc -127
    //   77: aload 13
    //   79: invokeinterface 121 3 0
    //   84: aload_2
    //   85: getfield 127	org/ksoap2/SoapEnvelope:version	I
    //   88: bipush 120
    //   90: if_icmpne +124 -> 214
    //   93: aload 16
    //   95: ldc -125
    //   97: ldc -123
    //   99: invokeinterface 121 3 0
    //   104: aload 16
    //   106: ldc -121
    //   108: ldc -119
    //   110: invokeinterface 121 3 0
    //   115: aload 16
    //   117: ldc -117
    //   119: new 141	java/lang/StringBuffer
    //   122: dup
    //   123: invokespecial 143	java/lang/StringBuffer:<init>	()V
    //   126: ldc -111
    //   128: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   131: aload 14
    //   133: arraylength
    //   134: invokevirtual 152	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   137: invokevirtual 156	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   140: invokeinterface 121 3 0
    //   145: aload 16
    //   147: aload 14
    //   149: arraylength
    //   150: invokeinterface 159 2 0
    //   155: aload_3
    //   156: ifnull +72 -> 228
    //   159: iconst_0
    //   160: istore 5
    //   162: iload 5
    //   164: aload_3
    //   165: invokeinterface 165 1 0
    //   170: if_icmpge +58 -> 228
    //   173: aload_3
    //   174: iload 5
    //   176: invokeinterface 169 2 0
    //   181: checkcast 171	org/ksoap2/HeaderProperty
    //   184: astore_1
    //   185: aload 16
    //   187: aload_1
    //   188: invokevirtual 174	org/ksoap2/HeaderProperty:getKey	()Ljava/lang/String;
    //   191: aload_1
    //   192: invokevirtual 177	org/ksoap2/HeaderProperty:getValue	()Ljava/lang/String;
    //   195: invokeinterface 121 3 0
    //   200: iload 5
    //   202: iconst_1
    //   203: iadd
    //   204: istore 5
    //   206: goto -44 -> 162
    //   209: aconst_null
    //   210: astore_1
    //   211: goto -174 -> 37
    //   214: aload 16
    //   216: ldc -125
    //   218: ldc -77
    //   220: invokeinterface 121 3 0
    //   225: goto -121 -> 104
    //   228: aload 16
    //   230: ldc -75
    //   232: invokeinterface 184 2 0
    //   237: aload 16
    //   239: invokeinterface 188 1 0
    //   244: astore_1
    //   245: aload_1
    //   246: aload 14
    //   248: iconst_0
    //   249: aload 14
    //   251: arraylength
    //   252: invokevirtual 78	java/io/OutputStream:write	([BII)V
    //   255: aload_1
    //   256: invokevirtual 49	java/io/OutputStream:flush	()V
    //   259: aload_1
    //   260: invokevirtual 189	java/io/OutputStream:close	()V
    //   263: aconst_null
    //   264: astore_1
    //   265: sipush 8192
    //   268: istore 5
    //   270: iconst_0
    //   271: istore 7
    //   273: iconst_0
    //   274: istore 8
    //   276: aload 16
    //   278: invokeinterface 192 1 0
    //   283: istore 12
    //   285: aload 16
    //   287: invokeinterface 196 1 0
    //   292: astore_3
    //   293: iconst_0
    //   294: istore 11
    //   296: iload 8
    //   298: istore 10
    //   300: iload 5
    //   302: istore 9
    //   304: iload 11
    //   306: aload_3
    //   307: invokeinterface 165 1 0
    //   312: if_icmpge +227 -> 539
    //   315: iload 8
    //   317: istore 10
    //   319: iload 5
    //   321: istore 9
    //   323: aload_3
    //   324: iload 11
    //   326: invokeinterface 169 2 0
    //   331: checkcast 171	org/ksoap2/HeaderProperty
    //   334: astore 13
    //   336: iload 8
    //   338: istore 10
    //   340: iload 5
    //   342: istore 9
    //   344: aload 13
    //   346: invokevirtual 174	org/ksoap2/HeaderProperty:getKey	()Ljava/lang/String;
    //   349: ifnonnull +18 -> 367
    //   352: iload 7
    //   354: istore 6
    //   356: iload 5
    //   358: istore 7
    //   360: iload 8
    //   362: istore 5
    //   364: goto +507 -> 871
    //   367: iload 5
    //   369: istore 6
    //   371: iload 8
    //   373: istore 10
    //   375: iload 5
    //   377: istore 9
    //   379: aload 13
    //   381: invokevirtual 174	org/ksoap2/HeaderProperty:getKey	()Ljava/lang/String;
    //   384: ldc -58
    //   386: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   389: ifeq +45 -> 434
    //   392: iload 8
    //   394: istore 10
    //   396: iload 5
    //   398: istore 9
    //   400: aload 13
    //   402: invokevirtual 177	org/ksoap2/HeaderProperty:getValue	()Ljava/lang/String;
    //   405: astore 14
    //   407: iload 5
    //   409: istore 6
    //   411: aload 14
    //   413: ifnull +21 -> 434
    //   416: iload 8
    //   418: istore 10
    //   420: iload 5
    //   422: istore 9
    //   424: aload 13
    //   426: invokevirtual 177	org/ksoap2/HeaderProperty:getValue	()Ljava/lang/String;
    //   429: invokestatic 208	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   432: istore 6
    //   434: iload 8
    //   436: istore 5
    //   438: iload 8
    //   440: istore 10
    //   442: iload 6
    //   444: istore 9
    //   446: aload 13
    //   448: invokevirtual 174	org/ksoap2/HeaderProperty:getKey	()Ljava/lang/String;
    //   451: ldc -125
    //   453: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   456: ifeq +31 -> 487
    //   459: iload 8
    //   461: istore 5
    //   463: iload 8
    //   465: istore 10
    //   467: iload 6
    //   469: istore 9
    //   471: aload 13
    //   473: invokevirtual 177	org/ksoap2/HeaderProperty:getValue	()Ljava/lang/String;
    //   476: ldc -46
    //   478: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   481: ifeq +6 -> 487
    //   484: iconst_1
    //   485: istore 5
    //   487: iload 5
    //   489: istore 10
    //   491: iload 6
    //   493: istore 9
    //   495: aload 13
    //   497: invokevirtual 174	org/ksoap2/HeaderProperty:getKey	()Ljava/lang/String;
    //   500: ldc -40
    //   502: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   505: ifeq +354 -> 859
    //   508: iload 5
    //   510: istore 10
    //   512: iload 6
    //   514: istore 9
    //   516: aload 13
    //   518: invokevirtual 177	org/ksoap2/HeaderProperty:getValue	()Ljava/lang/String;
    //   521: ldc -119
    //   523: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   526: ifeq +333 -> 859
    //   529: iload 6
    //   531: istore 7
    //   533: iconst_1
    //   534: istore 6
    //   536: goto +335 -> 871
    //   539: iload 12
    //   541: sipush 200
    //   544: if_icmpeq +151 -> 695
    //   547: iload 8
    //   549: istore 10
    //   551: iload 5
    //   553: istore 9
    //   555: new 85	org/ksoap2/transport/HttpResponseException
    //   558: dup
    //   559: new 141	java/lang/StringBuffer
    //   562: dup
    //   563: invokespecial 143	java/lang/StringBuffer:<init>	()V
    //   566: ldc -38
    //   568: invokevirtual 149	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   571: iload 12
    //   573: invokevirtual 152	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   576: invokevirtual 156	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   579: iload 12
    //   581: invokespecial 219	org/ksoap2/transport/HttpResponseException:<init>	(Ljava/lang/String;I)V
    //   584: athrow
    //   585: astore 14
    //   587: iload 7
    //   589: istore 5
    //   591: iload 10
    //   593: istore 6
    //   595: iload 9
    //   597: ifle +34 -> 631
    //   600: iload 5
    //   602: ifeq +211 -> 813
    //   605: iload 9
    //   607: ifle +206 -> 813
    //   610: aload_0
    //   611: new 221	java/io/BufferedInputStream
    //   614: dup
    //   615: aload 16
    //   617: invokeinterface 225 1 0
    //   622: iload 9
    //   624: invokespecial 228	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   627: invokespecial 230	org/ksoap2/transport/HttpTransportSE:getUnZippedInputStream	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   630: astore_1
    //   631: aload_3
    //   632: astore 15
    //   634: iload 9
    //   636: istore 5
    //   638: aload_1
    //   639: astore 13
    //   641: aload 14
    //   643: instanceof 85
    //   646: ifeq +98 -> 744
    //   649: aload_3
    //   650: astore 15
    //   652: iload 9
    //   654: istore 5
    //   656: aload_1
    //   657: astore 13
    //   659: iload 6
    //   661: ifne +83 -> 744
    //   664: aload_0
    //   665: getfield 104	org/ksoap2/transport/HttpTransportSE:debug	Z
    //   668: ifeq +17 -> 685
    //   671: aload_1
    //   672: ifnull +13 -> 685
    //   675: aload_0
    //   676: aload_1
    //   677: iload 9
    //   679: aload 4
    //   681: invokespecial 232	org/ksoap2/transport/HttpTransportSE:readDebug	(Ljava/io/InputStream;ILjava/io/File;)Ljava/io/InputStream;
    //   684: pop
    //   685: aload 16
    //   687: invokeinterface 235 1 0
    //   692: aload 14
    //   694: athrow
    //   695: iload 5
    //   697: ifle +157 -> 854
    //   700: iload 7
    //   702: ifeq +79 -> 781
    //   705: iload 8
    //   707: istore 10
    //   709: iload 5
    //   711: istore 9
    //   713: aload_0
    //   714: new 221	java/io/BufferedInputStream
    //   717: dup
    //   718: aload 16
    //   720: invokeinterface 238 1 0
    //   725: iload 5
    //   727: invokespecial 228	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   730: invokespecial 230	org/ksoap2/transport/HttpTransportSE:getUnZippedInputStream	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   733: astore 13
    //   735: aload 13
    //   737: astore_1
    //   738: aload_1
    //   739: astore 13
    //   741: aload_3
    //   742: astore 15
    //   744: aload 13
    //   746: astore_1
    //   747: aload_0
    //   748: getfield 104	org/ksoap2/transport/HttpTransportSE:debug	Z
    //   751: ifeq +14 -> 765
    //   754: aload_0
    //   755: aload 13
    //   757: iload 5
    //   759: aload 4
    //   761: invokespecial 232	org/ksoap2/transport/HttpTransportSE:readDebug	(Ljava/io/InputStream;ILjava/io/File;)Ljava/io/InputStream;
    //   764: astore_1
    //   765: aload_0
    //   766: aload_2
    //   767: aload_1
    //   768: invokevirtual 242	org/ksoap2/transport/HttpTransportSE:parseResponse	(Lorg/ksoap2/SoapEnvelope;Ljava/io/InputStream;)V
    //   771: aload 16
    //   773: invokeinterface 235 1 0
    //   778: aload 15
    //   780: areturn
    //   781: iload 8
    //   783: istore 10
    //   785: iload 5
    //   787: istore 9
    //   789: new 221	java/io/BufferedInputStream
    //   792: dup
    //   793: aload 16
    //   795: invokeinterface 238 1 0
    //   800: iload 5
    //   802: invokespecial 228	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   805: astore 13
    //   807: aload 13
    //   809: astore_1
    //   810: goto -72 -> 738
    //   813: new 221	java/io/BufferedInputStream
    //   816: dup
    //   817: aload 16
    //   819: invokeinterface 225 1 0
    //   824: iload 9
    //   826: invokespecial 228	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   829: astore_1
    //   830: goto -199 -> 631
    //   833: astore 14
    //   835: aconst_null
    //   836: astore_3
    //   837: iconst_0
    //   838: istore 7
    //   840: iconst_0
    //   841: istore 6
    //   843: iload 5
    //   845: istore 9
    //   847: iload 7
    //   849: istore 5
    //   851: goto -256 -> 595
    //   854: aconst_null
    //   855: astore_1
    //   856: goto -118 -> 738
    //   859: iload 7
    //   861: istore 8
    //   863: iload 6
    //   865: istore 7
    //   867: iload 8
    //   869: istore 6
    //   871: iload 11
    //   873: iconst_1
    //   874: iadd
    //   875: istore 11
    //   877: iload 7
    //   879: istore 9
    //   881: iload 5
    //   883: istore 8
    //   885: iload 6
    //   887: istore 7
    //   889: iload 9
    //   891: istore 5
    //   893: goto -597 -> 296
    //   896: astore 14
    //   898: sipush 8192
    //   901: istore 6
    //   903: goto -469 -> 434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	906	0	this	HttpTransportSE
    //   0	906	1	paramString	String
    //   0	906	2	paramSoapEnvelope	SoapEnvelope
    //   0	906	3	paramList	List
    //   0	906	4	paramFile	File
    //   160	732	5	i	int
    //   354	548	6	j	int
    //   271	617	7	k	int
    //   274	610	8	m	int
    //   302	588	9	n	int
    //   298	486	10	i1	int
    //   294	582	11	i2	int
    //   283	297	12	i3	int
    //   1	807	13	localObject1	Object
    //   18	394	14	localObject2	Object
    //   585	108	14	localIOException1	IOException
    //   833	1	14	localIOException2	IOException
    //   896	1	14	localNumberFormatException	NumberFormatException
    //   632	147	15	localList	List
    //   51	767	16	localServiceConnection	ServiceConnection
    // Exception table:
    //   from	to	target	type
    //   304	315	585	java/io/IOException
    //   323	336	585	java/io/IOException
    //   344	352	585	java/io/IOException
    //   379	392	585	java/io/IOException
    //   400	407	585	java/io/IOException
    //   424	434	585	java/io/IOException
    //   446	459	585	java/io/IOException
    //   471	484	585	java/io/IOException
    //   495	508	585	java/io/IOException
    //   516	529	585	java/io/IOException
    //   555	585	585	java/io/IOException
    //   713	735	585	java/io/IOException
    //   789	807	585	java/io/IOException
    //   285	293	833	java/io/IOException
    //   424	434	896	java/lang/NumberFormatException
  }
  
  public void call(String paramString, SoapEnvelope paramSoapEnvelope)
    throws HttpResponseException, IOException, XmlPullParserException
  {
    call(paramString, paramSoapEnvelope, null);
  }
  
  public ServiceConnection getServiceConnection()
    throws IOException
  {
    return new ServiceConnectionSE(this.proxy, this.url, this.timeout);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/ksoap2/transport/HttpTransportSE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */