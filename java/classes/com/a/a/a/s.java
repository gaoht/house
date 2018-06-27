package com.a.a.a;

import com.a.a.b.e;
import com.a.a.c;
import com.a.a.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class s
  implements h
{
  private Map a = new HashMap();
  private Map b = new HashMap();
  private Map c = new HashMap();
  private Pattern d = Pattern.compile("[/*?\\[\\]]");
  
  public s()
  {
    try
    {
      a();
      b();
      return;
    }
    catch (c localc)
    {
      throw new RuntimeException("The XMPSchemaRegistry cannot be initialized!");
    }
  }
  
  private void a()
    throws c
  {
    registerNamespace("http://www.w3.org/XML/1998/namespace", "xml");
    registerNamespace("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
    registerNamespace("http://purl.org/dc/elements/1.1/", "dc");
    registerNamespace("http://iptc.org/std/Iptc4xmpCore/1.0/xmlns/", "Iptc4xmpCore");
    registerNamespace("http://iptc.org/std/Iptc4xmpExt/2008-02-29/", "Iptc4xmpExt");
    registerNamespace("http://ns.adobe.com/DICOM/", "DICOM");
    registerNamespace("http://ns.useplus.org/ldf/xmp/1.0/", "plus");
    registerNamespace("adobe:ns:meta/", "x");
    registerNamespace("http://ns.adobe.com/iX/1.0/", "iX");
    registerNamespace("http://ns.adobe.com/xap/1.0/", "xmp");
    registerNamespace("http://ns.adobe.com/xap/1.0/rights/", "xmpRights");
    registerNamespace("http://ns.adobe.com/xap/1.0/mm/", "xmpMM");
    registerNamespace("http://ns.adobe.com/xap/1.0/bj/", "xmpBJ");
    registerNamespace("http://ns.adobe.com/xmp/note/", "xmpNote");
    registerNamespace("http://ns.adobe.com/pdf/1.3/", "pdf");
    registerNamespace("http://ns.adobe.com/pdfx/1.3/", "pdfx");
    registerNamespace("http://www.npes.org/pdfx/ns/id/", "pdfxid");
    registerNamespace("http://www.aiim.org/pdfa/ns/schema#", "pdfaSchema");
    registerNamespace("http://www.aiim.org/pdfa/ns/property#", "pdfaProperty");
    registerNamespace("http://www.aiim.org/pdfa/ns/type#", "pdfaType");
    registerNamespace("http://www.aiim.org/pdfa/ns/field#", "pdfaField");
    registerNamespace("http://www.aiim.org/pdfa/ns/id/", "pdfaid");
    registerNamespace("http://www.aiim.org/pdfa/ns/extension/", "pdfaExtension");
    registerNamespace("http://ns.adobe.com/photoshop/1.0/", "photoshop");
    registerNamespace("http://ns.adobe.com/album/1.0/", "album");
    registerNamespace("http://ns.adobe.com/exif/1.0/", "exif");
    registerNamespace("http://cipa.jp/exif/1.0/", "exifEX");
    registerNamespace("http://ns.adobe.com/exif/1.0/aux/", "aux");
    registerNamespace("http://ns.adobe.com/tiff/1.0/", "tiff");
    registerNamespace("http://ns.adobe.com/png/1.0/", "png");
    registerNamespace("http://ns.adobe.com/jpeg/1.0/", "jpeg");
    registerNamespace("http://ns.adobe.com/jp2k/1.0/", "jp2k");
    registerNamespace("http://ns.adobe.com/camera-raw-settings/1.0/", "crs");
    registerNamespace("http://ns.adobe.com/StockPhoto/1.0/", "bmsp");
    registerNamespace("http://ns.adobe.com/creatorAtom/1.0/", "creatorAtom");
    registerNamespace("http://ns.adobe.com/asf/1.0/", "asf");
    registerNamespace("http://ns.adobe.com/xmp/wav/1.0/", "wav");
    registerNamespace("http://ns.adobe.com/bwf/bext/1.0/", "bext");
    registerNamespace("http://ns.adobe.com/riff/info/", "riffinfo");
    registerNamespace("http://ns.adobe.com/xmp/1.0/Script/", "xmpScript");
    registerNamespace("http://ns.adobe.com/TransformXMP/", "txmp");
    registerNamespace("http://ns.adobe.com/swf/1.0/", "swf");
    registerNamespace("http://ns.adobe.com/xmp/1.0/DynamicMedia/", "xmpDM");
    registerNamespace("http://ns.adobe.com/xmp/transient/1.0/", "xmpx");
    registerNamespace("http://ns.adobe.com/xap/1.0/t/", "xmpT");
    registerNamespace("http://ns.adobe.com/xap/1.0/t/pg/", "xmpTPg");
    registerNamespace("http://ns.adobe.com/xap/1.0/g/", "xmpG");
    registerNamespace("http://ns.adobe.com/xap/1.0/g/img/", "xmpGImg");
    registerNamespace("http://ns.adobe.com/xap/1.0/sType/Font#", "stFnt");
    registerNamespace("http://ns.adobe.com/xap/1.0/sType/Dimensions#", "stDim");
    registerNamespace("http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "stEvt");
    registerNamespace("http://ns.adobe.com/xap/1.0/sType/ResourceRef#", "stRef");
    registerNamespace("http://ns.adobe.com/xap/1.0/sType/Version#", "stVer");
    registerNamespace("http://ns.adobe.com/xap/1.0/sType/Job#", "stJob");
    registerNamespace("http://ns.adobe.com/xap/1.0/sType/ManifestItem#", "stMfs");
    registerNamespace("http://ns.adobe.com/xmp/Identifier/qual/1.0/", "xmpidq");
  }
  
  private void b()
    throws c
  {
    com.a.a.b.a locala1 = new com.a.a.b.a().setArrayOrdered(true);
    com.a.a.b.a locala2 = new com.a.a.b.a().setArrayAltText(true);
    a("http://ns.adobe.com/xap/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", locala1);
    a("http://ns.adobe.com/xap/1.0/", "Authors", "http://purl.org/dc/elements/1.1/", "creator", null);
    a("http://ns.adobe.com/xap/1.0/", "Description", "http://purl.org/dc/elements/1.1/", "description", null);
    a("http://ns.adobe.com/xap/1.0/", "Format", "http://purl.org/dc/elements/1.1/", "format", null);
    a("http://ns.adobe.com/xap/1.0/", "Keywords", "http://purl.org/dc/elements/1.1/", "subject", null);
    a("http://ns.adobe.com/xap/1.0/", "Locale", "http://purl.org/dc/elements/1.1/", "language", null);
    a("http://ns.adobe.com/xap/1.0/", "Title", "http://purl.org/dc/elements/1.1/", "title", null);
    a("http://ns.adobe.com/xap/1.0/rights/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", null);
    a("http://ns.adobe.com/pdf/1.3/", "Author", "http://purl.org/dc/elements/1.1/", "creator", locala1);
    a("http://ns.adobe.com/pdf/1.3/", "BaseURL", "http://ns.adobe.com/xap/1.0/", "BaseURL", null);
    a("http://ns.adobe.com/pdf/1.3/", "CreationDate", "http://ns.adobe.com/xap/1.0/", "CreateDate", null);
    a("http://ns.adobe.com/pdf/1.3/", "Creator", "http://ns.adobe.com/xap/1.0/", "CreatorTool", null);
    a("http://ns.adobe.com/pdf/1.3/", "ModDate", "http://ns.adobe.com/xap/1.0/", "ModifyDate", null);
    a("http://ns.adobe.com/pdf/1.3/", "Subject", "http://purl.org/dc/elements/1.1/", "description", locala2);
    a("http://ns.adobe.com/pdf/1.3/", "Title", "http://purl.org/dc/elements/1.1/", "title", locala2);
    a("http://ns.adobe.com/photoshop/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", locala1);
    a("http://ns.adobe.com/photoshop/1.0/", "Caption", "http://purl.org/dc/elements/1.1/", "description", locala2);
    a("http://ns.adobe.com/photoshop/1.0/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", locala2);
    a("http://ns.adobe.com/photoshop/1.0/", "Keywords", "http://purl.org/dc/elements/1.1/", "subject", null);
    a("http://ns.adobe.com/photoshop/1.0/", "Marked", "http://ns.adobe.com/xap/1.0/rights/", "Marked", null);
    a("http://ns.adobe.com/photoshop/1.0/", "Title", "http://purl.org/dc/elements/1.1/", "title", locala2);
    a("http://ns.adobe.com/photoshop/1.0/", "WebStatement", "http://ns.adobe.com/xap/1.0/rights/", "WebStatement", null);
    a("http://ns.adobe.com/tiff/1.0/", "Artist", "http://purl.org/dc/elements/1.1/", "creator", locala1);
    a("http://ns.adobe.com/tiff/1.0/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", null);
    a("http://ns.adobe.com/tiff/1.0/", "DateTime", "http://ns.adobe.com/xap/1.0/", "ModifyDate", null);
    a("http://ns.adobe.com/tiff/1.0/", "ImageDescription", "http://purl.org/dc/elements/1.1/", "description", null);
    a("http://ns.adobe.com/tiff/1.0/", "Software", "http://ns.adobe.com/xap/1.0/", "CreatorTool", null);
    a("http://ns.adobe.com/png/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", locala1);
    a("http://ns.adobe.com/png/1.0/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", locala2);
    a("http://ns.adobe.com/png/1.0/", "CreationTime", "http://ns.adobe.com/xap/1.0/", "CreateDate", null);
    a("http://ns.adobe.com/png/1.0/", "Description", "http://purl.org/dc/elements/1.1/", "description", locala2);
    a("http://ns.adobe.com/png/1.0/", "ModificationTime", "http://ns.adobe.com/xap/1.0/", "ModifyDate", null);
    a("http://ns.adobe.com/png/1.0/", "Software", "http://ns.adobe.com/xap/1.0/", "CreatorTool", null);
    a("http://ns.adobe.com/png/1.0/", "Title", "http://purl.org/dc/elements/1.1/", "title", locala2);
  }
  
  void a(final String paramString1, String paramString2, final String paramString3, final String paramString4, final com.a.a.b.a parama)
    throws c
  {
    for (;;)
    {
      try
      {
        g.assertSchemaNS(paramString1);
        g.assertPropName(paramString2);
        g.assertSchemaNS(paramString3);
        g.assertPropName(paramString4);
        if (parama != null)
        {
          parama = new com.a.a.b.a(q.a(parama.toPropertyOptions(), null).getOptions());
          if ((!this.d.matcher(paramString2).find()) && (!this.d.matcher(paramString4).find())) {
            break;
          }
          throw new c("Alias and actual property names must be simple", 102);
        }
      }
      finally {}
      parama = new com.a.a.b.a();
    }
    String str = getNamespacePrefix(paramString1);
    paramString1 = getNamespacePrefix(paramString3);
    if (str == null) {
      throw new c("Alias namespace is not registered", 101);
    }
    if (paramString1 == null) {
      throw new c("Actual namespace is not registered", 101);
    }
    paramString2 = str + paramString2;
    if (this.c.containsKey(paramString2)) {
      throw new c("Alias is already existing", 4);
    }
    if (this.c.containsKey(paramString1 + paramString4)) {
      throw new c("Actual property is already an alias, use the base property", 4);
    }
    paramString1 = new com.a.a.c.a()
    {
      public com.a.a.b.a getAliasForm()
      {
        return parama;
      }
      
      public String getNamespace()
      {
        return paramString3;
      }
      
      public String getPrefix()
      {
        return paramString1;
      }
      
      public String getPropName()
      {
        return paramString4;
      }
      
      public String toString()
      {
        return paramString1 + paramString4 + " NS(" + paramString3 + "), FORM (" + getAliasForm() + ")";
      }
    };
    this.c.put(paramString2, paramString1);
  }
  
  public void deleteNamespace(String paramString)
  {
    try
    {
      String str = getNamespacePrefix(paramString);
      if (str != null)
      {
        this.a.remove(paramString);
        this.b.remove(str);
      }
      return;
    }
    finally {}
  }
  
  public com.a.a.c.a findAlias(String paramString)
  {
    try
    {
      paramString = (com.a.a.c.a)this.c.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public com.a.a.c.a[] findAliases(String paramString)
  {
    try
    {
      paramString = getNamespacePrefix(paramString);
      ArrayList localArrayList = new ArrayList();
      if (paramString != null)
      {
        Iterator localIterator = this.c.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.startsWith(paramString)) {
            localArrayList.add(findAlias(str));
          }
        }
      }
      paramString = (com.a.a.c.a[])localArrayList.toArray(new com.a.a.c.a[localArrayList.size()]);
    }
    finally {}
    return paramString;
  }
  
  public Map getAliases()
  {
    try
    {
      Map localMap = Collections.unmodifiableMap(new TreeMap(this.c));
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getNamespacePrefix(String paramString)
  {
    try
    {
      paramString = (String)this.a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String getNamespaceURI(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
    }
    try
    {
      if (!paramString.endsWith(":")) {
        str = paramString + ":";
      }
      paramString = (String)this.b.get(str);
      return paramString;
    }
    finally {}
  }
  
  public Map getNamespaces()
  {
    try
    {
      Map localMap = Collections.unmodifiableMap(new TreeMap(this.a));
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Map getPrefixes()
  {
    try
    {
      Map localMap = Collections.unmodifiableMap(new TreeMap(this.b));
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String registerNamespace(String paramString1, String paramString2)
    throws c
  {
    try
    {
      g.assertSchemaNS(paramString1);
      g.assertPrefix(paramString2);
      if (paramString2.charAt(paramString2.length() - 1) == ':') {
        break label227;
      }
      paramString2 = paramString2 + ':';
      if (!k.isXMLNameNS(paramString2.substring(0, paramString2.length() - 1))) {
        throw new c("The prefix is a bad XML name", 201);
      }
    }
    finally {}
    Object localObject = (String)this.a.get(paramString1);
    String str = (String)this.b.get(paramString2);
    if (localObject != null) {
      label116:
      return (String)localObject;
    }
    if (str != null)
    {
      int i = 1;
      str = paramString2;
      for (;;)
      {
        localObject = str;
        if (!this.b.containsKey(str)) {
          break;
        }
        str = paramString2.substring(0, paramString2.length() - 1) + "_" + i + "_:";
        i += 1;
      }
    }
    for (;;)
    {
      this.b.put(localObject, paramString1);
      this.a.put(paramString1, localObject);
      break label116;
      label227:
      break;
      localObject = paramString2;
    }
  }
  
  /* Error */
  public com.a.a.c.a resolveAlias(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 402	com/a/a/a/s:getNamespacePrefix	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnonnull +9 -> 18
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: getfield 29	com/a/a/a/s:c	Ljava/util/Map;
    //   22: new 408	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   29: aload_1
    //   30: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 413	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 417	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokeinterface 444 2 0
    //   45: checkcast 446	com/a/a/c/a
    //   48: astore_1
    //   49: goto -35 -> 14
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	s
    //   0	57	1	paramString1	String
    //   0	57	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	8	52	finally
    //   18	49	52	finally
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */