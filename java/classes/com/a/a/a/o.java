package com.a.a.a;

import com.a.a.c;
import com.a.a.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class o
{
  private static final Object a = new Object();
  private static DocumentBuilderFactory b = a();
  
  private static DocumentBuilderFactory a()
  {
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    localDocumentBuilderFactory.setNamespaceAware(true);
    localDocumentBuilderFactory.setIgnoringComments(true);
    try
    {
      localDocumentBuilderFactory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
      return localDocumentBuilderFactory;
    }
    catch (Exception localException) {}
    return localDocumentBuilderFactory;
  }
  
  private static Document a(b paramb, com.a.a.b.d paramd)
    throws c
  {
    Object localObject = new InputSource(paramb.getByteStream());
    try
    {
      localObject = a((InputSource)localObject);
      return (Document)localObject;
    }
    catch (c localc)
    {
      if ((localc.getErrorCode() == 201) || (localc.getErrorCode() == 204))
      {
        localObject = paramb;
        if (paramd.getAcceptLatin1()) {
          localObject = f.convert(paramb);
        }
        if (paramd.getFixControlChars()) {
          try
          {
            paramb = ((b)localObject).getEncoding();
            paramb = a(new InputSource(new d(new InputStreamReader(((b)localObject).getByteStream(), paramb))));
            return paramb;
          }
          catch (UnsupportedEncodingException paramb)
          {
            throw new c("Unsupported Encoding", 9, localc);
          }
        }
        return a(new InputSource(((b)localObject).getByteStream()));
      }
      throw localc;
    }
  }
  
  private static Document a(InputStream paramInputStream, com.a.a.b.d paramd)
    throws c
  {
    if ((!paramd.getAcceptLatin1()) && (!paramd.getFixControlChars())) {
      return a(new InputSource(paramInputStream));
    }
    try
    {
      paramInputStream = a(new b(paramInputStream), paramd);
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw new c("Error reading the XML-file", 204, paramInputStream);
    }
  }
  
  private static Document a(Object paramObject, com.a.a.b.d paramd)
    throws c
  {
    if ((paramObject instanceof InputStream)) {
      return a((InputStream)paramObject, paramd);
    }
    if ((paramObject instanceof byte[])) {
      return a(new b((byte[])paramObject), paramd);
    }
    return a((String)paramObject, paramd);
  }
  
  private static Document a(String paramString, com.a.a.b.d paramd)
    throws c
  {
    Object localObject = new InputSource(new StringReader(paramString));
    try
    {
      localObject = a((InputSource)localObject);
      return (Document)localObject;
    }
    catch (c localc)
    {
      if ((localc.getErrorCode() == 201) && (paramd.getFixControlChars())) {
        return a(new InputSource(new d(new StringReader(paramString))));
      }
      throw localc;
    }
  }
  
  private static Document a(InputSource paramInputSource)
    throws c
  {
    try
    {
      DocumentBuilder localDocumentBuilder = b.newDocumentBuilder();
      localDocumentBuilder.setErrorHandler(null);
      paramInputSource = localDocumentBuilder.parse(paramInputSource);
      return paramInputSource;
    }
    catch (SAXException paramInputSource)
    {
      throw new c("XML parsing failure", 201, paramInputSource);
    }
    catch (ParserConfigurationException paramInputSource)
    {
      throw new c("XML Parser not correctly configured", 0, paramInputSource);
    }
    catch (IOException paramInputSource)
    {
      throw new c("Error reading the XML-file", 204, paramInputSource);
    }
  }
  
  private static Object[] a(Node paramNode, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    paramNode = paramNode.getChildNodes();
    int i = 0;
    if (i < paramNode.getLength())
    {
      Object localObject = paramNode.item(i);
      if ((7 == ((Node)localObject).getNodeType()) && ("xpacket".equals(((ProcessingInstruction)localObject).getTarget()))) {
        if (paramArrayOfObject != null) {
          paramArrayOfObject[2] = ((ProcessingInstruction)localObject).getData();
        }
      }
      do
      {
        do
        {
          i += 1;
          break;
        } while ((3 == ((Node)localObject).getNodeType()) || (7 == ((Node)localObject).getNodeType()));
        String str1 = ((Node)localObject).getNamespaceURI();
        String str2 = ((Node)localObject).getLocalName();
        if ((("xmpmeta".equals(str2)) || ("xapmeta".equals(str2))) && ("adobe:ns:meta/".equals(str1))) {
          paramNode = a((Node)localObject, false, paramArrayOfObject);
        }
        do
        {
          return paramNode;
          if ((paramBoolean) || (!"RDF".equals(str2)) || (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(str1))) {
            break;
          }
          paramNode = paramArrayOfObject;
        } while (paramArrayOfObject == null);
        paramArrayOfObject[0] = localObject;
        paramArrayOfObject[1] = a;
        return paramArrayOfObject;
        localObject = a((Node)localObject, paramBoolean, paramArrayOfObject);
      } while (localObject == null);
      return (Object[])localObject;
    }
    return null;
  }
  
  public static e parse(Object paramObject, com.a.a.b.d paramd)
    throws c
  {
    g.assertNotNull(paramObject);
    if (paramd != null) {}
    n localn;
    for (;;)
    {
      paramObject = a(a(paramObject, paramd), paramd.getRequireXMPMeta(), new Object[3]);
      if ((paramObject == null) || (paramObject[1] != a)) {
        break label84;
      }
      localn = h.a((Node)paramObject[0]);
      localn.setPacketHeader((String)paramObject[2]);
      if (paramd.getOmitNormalization()) {
        break;
      }
      return r.a(localn, paramd);
      paramd = new com.a.a.b.d();
    }
    return localn;
    label84:
    return new n();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */