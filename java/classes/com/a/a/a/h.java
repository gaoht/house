package com.a.a.a;

import com.a.a.b.e;
import com.a.a.c;
import com.a.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class h
{
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  static n a(Node paramNode)
    throws c
  {
    n localn = new n();
    a(localn, paramNode);
    return localn;
  }
  
  private static p a(n paramn, p paramp, Node paramNode, String paramString, boolean paramBoolean)
    throws c
  {
    com.a.a.h localh = f.getSchemaRegistry();
    Object localObject2 = paramNode.getNamespaceURI();
    Object localObject3;
    boolean bool1;
    if (localObject2 != null)
    {
      Object localObject1 = localObject2;
      if ("http://purl.org/dc/1.1/".equals(localObject2)) {
        localObject1 = "http://purl.org/dc/elements/1.1/";
      }
      localObject3 = localh.getNamespacePrefix((String)localObject1);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        if (paramNode.getPrefix() != null)
        {
          localObject2 = paramNode.getPrefix();
          localObject2 = localh.registerNamespace((String)localObject1, (String)localObject2);
        }
      }
      else
      {
        localObject2 = (String)localObject2 + paramNode.getLocalName();
        localObject3 = new e();
        if (!paramBoolean) {
          break label326;
        }
        paramNode = q.a(paramn.getRoot(), (String)localObject1, "_dflt", true);
        paramNode.setImplicit(false);
        paramp = paramNode;
        if (localh.findAlias((String)localObject2) == null) {
          break label326;
        }
        paramn.getRoot().setHasAliases(true);
        paramNode.setHasAliases(true);
        bool1 = true;
        paramp = paramNode;
      }
    }
    for (;;)
    {
      boolean bool2 = "rdf:li".equals(localObject2);
      boolean bool3 = "rdf:value".equals(localObject2);
      paramn = new p((String)localObject2, paramString, (e)localObject3);
      paramn.setAlias(bool1);
      if (!bool3) {
        paramp.addChild(paramn);
      }
      for (;;)
      {
        if (bool3)
        {
          if ((paramBoolean) || (!paramp.getOptions().isStruct()))
          {
            throw new c("Misplaced rdf:value element", 202);
            localObject2 = "_dflt";
            break;
            throw new c("XML namespace required for all elements and attributes", 202);
            paramp.addChild(1, paramn);
            continue;
          }
          paramp.setHasValueChild(true);
        }
      }
      if (bool2)
      {
        if (!paramp.getOptions().isArray()) {
          throw new c("Misplaced rdf:li element", 202);
        }
        paramn.setName("[]");
      }
      return paramn;
      label326:
      bool1 = false;
    }
  }
  
  private static p a(p paramp, String paramString1, String paramString2)
    throws c
  {
    String str = paramString2;
    if ("xml:lang".equals(paramString1)) {
      str = k.normalizeLangValue(paramString2);
    }
    paramString1 = new p(paramString1, str, null);
    paramp.addQualifier(paramString1);
    return paramString1;
  }
  
  private static void a()
    throws c
  {
    throw new c("ParseTypeLiteral property element not allowed", 203);
  }
  
  private static void a(n paramn, p paramp, Node paramNode)
    throws c
  {
    int i = 0;
    while (i < paramNode.getChildNodes().getLength())
    {
      Node localNode = paramNode.getChildNodes().item(i);
      if (!b(localNode)) {
        a(paramn, paramp, localNode, true);
      }
      i += 1;
    }
  }
  
  private static void a(n paramn, p paramp, Node paramNode, boolean paramBoolean)
    throws c
  {
    int i = c(paramNode);
    if ((i != 8) && (i != 0)) {
      throw new c("Node element must be rdf:Description or typed node", 202);
    }
    if ((paramBoolean) && (i == 0)) {
      throw new c("Top level typed node not allowed", 203);
    }
    b(paramn, paramp, paramNode, paramBoolean);
    c(paramn, paramp, paramNode, paramBoolean);
  }
  
  static void a(n paramn, Node paramNode)
    throws c
  {
    if (paramNode.hasAttributes())
    {
      a(paramn, paramn.getRoot(), paramNode);
      return;
    }
    throw new c("Invalid attributes of rdf:RDF element", 202);
  }
  
  private static void a(p paramp)
    throws c
  {
    int j = 1;
    if ((!a) && ((!paramp.getOptions().isStruct()) || (!paramp.hasChildren()))) {
      throw new AssertionError();
    }
    Object localObject = paramp.getChild(1);
    if ((!a) && (!"rdf:value".equals(((p)localObject).getName()))) {
      throw new AssertionError();
    }
    int i = j;
    if (((p)localObject).getOptions().getHasLanguage())
    {
      if (paramp.getOptions().getHasLanguage()) {
        throw new c("Redundant xml:lang for rdf:value element", 203);
      }
      p localp = ((p)localObject).getQualifier(1);
      ((p)localObject).removeQualifier(localp);
      paramp.addQualifier(localp);
      i = j;
    }
    while (i <= ((p)localObject).getQualifierLength())
    {
      paramp.addQualifier(((p)localObject).getQualifier(i));
      i += 1;
    }
    i = 2;
    while (i <= paramp.getChildrenLength())
    {
      paramp.addQualifier(paramp.getChild(i));
      i += 1;
    }
    if ((!a) && (!paramp.getOptions().isStruct()) && (!paramp.getHasValueChild())) {
      throw new AssertionError();
    }
    paramp.setHasValueChild(false);
    paramp.getOptions().setStruct(false);
    paramp.getOptions().mergeWith(((p)localObject).getOptions());
    paramp.setValue(((p)localObject).getValue());
    paramp.removeChildren();
    localObject = ((p)localObject).iterateChildren();
    while (((Iterator)localObject).hasNext()) {
      paramp.addChild((p)((Iterator)localObject).next());
    }
  }
  
  private static boolean a(int paramInt)
  {
    if ((paramInt == 8) || (b(paramInt))) {}
    while (c(paramInt)) {
      return false;
    }
    return true;
  }
  
  private static void b()
    throws c
  {
    throw new c("ParseTypeCollection property element not allowed", 203);
  }
  
  private static void b(n paramn, p paramp, Node paramNode, boolean paramBoolean)
    throws c
  {
    int j = 0;
    int k = 0;
    if (j < paramNode.getAttributes().getLength())
    {
      Node localNode = paramNode.getAttributes().item(j);
      int i = k;
      if (!"xmlns".equals(localNode.getPrefix()))
      {
        if ((localNode.getPrefix() != null) || (!"xmlns".equals(localNode.getNodeName()))) {
          break label100;
        }
        i = k;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        label100:
        int m = c(localNode);
        switch (m)
        {
        case 1: 
        case 4: 
        case 5: 
        default: 
          throw new c("Invalid nodeElement attribute", 202);
        case 2: 
        case 3: 
        case 6: 
          if (k > 0) {
            throw new c("Mutally exclusive about, ID, nodeID attributes", 202);
          }
          k += 1;
          i = k;
          if (paramBoolean)
          {
            i = k;
            if (m == 3) {
              if ((paramp.getName() != null) && (paramp.getName().length() > 0))
              {
                i = k;
                if (!paramp.getName().equals(localNode.getNodeValue())) {
                  throw new c("Mismatched top level rdf:about values", 203);
                }
              }
              else
              {
                paramp.setName(localNode.getNodeValue());
                i = k;
              }
            }
          }
          break;
        case 0: 
          a(paramn, paramp, localNode, localNode.getNodeValue(), paramBoolean);
          i = k;
        }
      }
    }
  }
  
  private static boolean b(int paramInt)
  {
    return (10 <= paramInt) && (paramInt <= 12);
  }
  
  private static boolean b(Node paramNode)
  {
    if (paramNode.getNodeType() != 3) {
      return false;
    }
    paramNode = paramNode.getNodeValue();
    int i = 0;
    for (;;)
    {
      if (i >= paramNode.length()) {
        break label47;
      }
      if (!Character.isWhitespace(paramNode.charAt(i))) {
        break;
      }
      i += 1;
    }
    label47:
    return true;
  }
  
  private static int c(Node paramNode)
  {
    String str3 = paramNode.getLocalName();
    String str2 = paramNode.getNamespaceURI();
    String str1 = str2;
    if (str2 == null) {
      if (!"about".equals(str3))
      {
        str1 = str2;
        if (!"ID".equals(str3)) {}
      }
      else
      {
        str1 = str2;
        if ((paramNode instanceof Attr))
        {
          str1 = str2;
          if ("http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(((Attr)paramNode).getOwnerElement().getNamespaceURI())) {
            str1 = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
          }
        }
      }
    }
    if ("http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(str1))
    {
      if ("li".equals(str3)) {
        return 9;
      }
      if ("parseType".equals(str3)) {
        return 4;
      }
      if ("Description".equals(str3)) {
        return 8;
      }
      if ("about".equals(str3)) {
        return 3;
      }
      if ("resource".equals(str3)) {
        return 5;
      }
      if ("RDF".equals(str3)) {
        return 1;
      }
      if ("ID".equals(str3)) {
        return 2;
      }
      if ("nodeID".equals(str3)) {
        return 6;
      }
      if ("datatype".equals(str3)) {
        return 7;
      }
      if ("aboutEach".equals(str3)) {
        return 10;
      }
      if ("aboutEachPrefix".equals(str3)) {
        return 11;
      }
      if ("bagID".equals(str3)) {
        return 12;
      }
    }
    return 0;
  }
  
  private static void c()
    throws c
  {
    throw new c("ParseTypeOther property element not allowed", 203);
  }
  
  private static void c(n paramn, p paramp, Node paramNode, boolean paramBoolean)
    throws c
  {
    int i = 0;
    if (i < paramNode.getChildNodes().getLength())
    {
      Node localNode = paramNode.getChildNodes().item(i);
      if (b(localNode)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localNode.getNodeType() != 1) {
          throw new c("Expected property element node not found", 202);
        }
        d(paramn, paramp, localNode, paramBoolean);
      }
    }
  }
  
  private static boolean c(int paramInt)
  {
    return (1 <= paramInt) && (paramInt <= 7);
  }
  
  private static void d(n paramn, p paramp, Node paramNode, boolean paramBoolean)
    throws c
  {
    int j = 0;
    if (!a(c(paramNode))) {
      throw new c("Invalid property element name", 202);
    }
    NamedNodeMap localNamedNodeMap = paramNode.getAttributes();
    Object localObject1 = null;
    int i = 0;
    Object localObject3;
    Object localObject2;
    while (i < localNamedNodeMap.getLength())
    {
      localObject3 = localNamedNodeMap.item(i);
      if (!"xmlns".equals(((Node)localObject3).getPrefix()))
      {
        localObject2 = localObject1;
        if (((Node)localObject3).getPrefix() == null)
        {
          localObject2 = localObject1;
          if (!"xmlns".equals(((Node)localObject3).getNodeName())) {}
        }
      }
      else
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).add(((Node)localObject3).getNodeName());
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localNamedNodeMap.removeNamedItem((String)((Iterator)localObject1).next());
      }
    }
    if (localNamedNodeMap.getLength() > 3)
    {
      h(paramn, paramp, paramNode, paramBoolean);
      return;
    }
    i = 0;
    while (i < localNamedNodeMap.getLength())
    {
      localObject1 = localNamedNodeMap.item(i);
      localObject2 = ((Node)localObject1).getLocalName();
      localObject3 = ((Node)localObject1).getNamespaceURI();
      String str = ((Node)localObject1).getNodeValue();
      if ((!"xml:lang".equals(((Node)localObject1).getNodeName())) || (("ID".equals(localObject2)) && ("http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(localObject3))))
      {
        if (("datatype".equals(localObject2)) && ("http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(localObject3)))
        {
          f(paramn, paramp, paramNode, paramBoolean);
          return;
        }
        if ((!"parseType".equals(localObject2)) || (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(localObject3)))
        {
          h(paramn, paramp, paramNode, paramBoolean);
          return;
        }
        if ("Literal".equals(str))
        {
          a();
          return;
        }
        if ("Resource".equals(str))
        {
          g(paramn, paramp, paramNode, paramBoolean);
          return;
        }
        if ("Collection".equals(str))
        {
          b();
          return;
        }
        c();
        return;
      }
      i += 1;
    }
    if (paramNode.hasChildNodes())
    {
      i = j;
      while (i < paramNode.getChildNodes().getLength())
      {
        if (paramNode.getChildNodes().item(i).getNodeType() != 3)
        {
          e(paramn, paramp, paramNode, paramBoolean);
          return;
        }
        i += 1;
      }
      f(paramn, paramp, paramNode, paramBoolean);
      return;
    }
    h(paramn, paramp, paramNode, paramBoolean);
  }
  
  private static void e(n paramn, p paramp, Node paramNode, boolean paramBoolean)
    throws c
  {
    if ((paramBoolean) && ("iX:changes".equals(paramNode.getNodeName()))) {}
    label166:
    int j;
    label314:
    label349:
    label503:
    label520:
    do
    {
      return;
      paramp = a(paramn, paramp, paramNode, "", paramBoolean);
      int i = 0;
      Node localNode;
      String str1;
      String str2;
      if (i < paramNode.getAttributes().getLength())
      {
        localNode = paramNode.getAttributes().item(i);
        if (("xmlns".equals(localNode.getPrefix())) || ((localNode.getPrefix() == null) && ("xmlns".equals(localNode.getNodeName())))) {}
        do
        {
          for (;;)
          {
            i += 1;
            break;
            str1 = localNode.getLocalName();
            str2 = localNode.getNamespaceURI();
            if (!"xml:lang".equals(localNode.getNodeName())) {
              break label166;
            }
            a(paramp, "xml:lang", localNode.getNodeValue());
          }
        } while (("ID".equals(str1)) && ("http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(str2)));
        throw new c("Invalid attribute for resource property element", 202);
      }
      i = 0;
      j = 0;
      if (i < paramNode.getChildNodes().getLength())
      {
        localNode = paramNode.getChildNodes().item(i);
        int k = j;
        if (!b(localNode))
        {
          if ((localNode.getNodeType() != 1) || (j != 0)) {
            break label520;
          }
          paramBoolean = "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(localNode.getNamespaceURI());
          str1 = localNode.getLocalName();
          if ((!paramBoolean) || (!"Bag".equals(str1))) {
            break label349;
          }
          paramp.getOptions().setArray(true);
          a(paramn, paramp, localNode, false);
          if (!paramp.getHasValueChild()) {
            break label503;
          }
          a(paramp);
        }
        for (;;)
        {
          k = 1;
          i += 1;
          j = k;
          break;
          if ((paramBoolean) && ("Seq".equals(str1)))
          {
            paramp.getOptions().setArray(true).setArrayOrdered(true);
            break label314;
          }
          if ((paramBoolean) && ("Alt".equals(str1)))
          {
            paramp.getOptions().setArray(true).setArrayOrdered(true).setArrayAlternate(true);
            break label314;
          }
          paramp.getOptions().setStruct(true);
          if ((paramBoolean) || ("Description".equals(str1))) {
            break label314;
          }
          str2 = localNode.getNamespaceURI();
          if (str2 == null) {
            throw new c("All XML elements must be in a namespace", 203);
          }
          a(paramp, "rdf:type", str2 + ':' + str1);
          break label314;
          if (paramp.getOptions().isArrayAlternate()) {
            q.c(paramp);
          }
        }
        if (j != 0) {
          throw new c("Invalid child of resource property element", 202);
        }
        throw new c("Children of resource property element must be XML elements", 202);
      }
    } while (j != 0);
    throw new c("Missing child of resource property element", 202);
  }
  
  private static void f(n paramn, p paramp, Node paramNode, boolean paramBoolean)
    throws c
  {
    int j = 0;
    paramp = a(paramn, paramp, paramNode, null, paramBoolean);
    int i = 0;
    Object localObject;
    if (i < paramNode.getAttributes().getLength())
    {
      paramn = paramNode.getAttributes().item(i);
      if (("xmlns".equals(paramn.getPrefix())) || ((paramn.getPrefix() == null) && ("xmlns".equals(paramn.getNodeName())))) {}
      String str;
      label139:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          localObject = paramn.getNamespaceURI();
          str = paramn.getLocalName();
          if (!"xml:lang".equals(paramn.getNodeName())) {
            break label139;
          }
          a(paramp, "xml:lang", paramn.getNodeValue());
        }
      } while (("http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(localObject)) && (("ID".equals(str)) || ("datatype".equals(str))));
      throw new c("Invalid attribute for literal property element", 202);
    }
    paramn = "";
    i = j;
    while (i < paramNode.getChildNodes().getLength())
    {
      localObject = paramNode.getChildNodes().item(i);
      if (((Node)localObject).getNodeType() == 3)
      {
        paramn = paramn + ((Node)localObject).getNodeValue();
        i += 1;
      }
      else
      {
        throw new c("Invalid child of literal property element", 202);
      }
    }
    paramp.setValue(paramn);
  }
  
  private static void g(n paramn, p paramp, Node paramNode, boolean paramBoolean)
    throws c
  {
    paramp = a(paramn, paramp, paramNode, "", paramBoolean);
    paramp.getOptions().setStruct(true);
    int i = 0;
    if (i < paramNode.getAttributes().getLength())
    {
      Node localNode = paramNode.getAttributes().item(i);
      if (("xmlns".equals(localNode.getPrefix())) || ((localNode.getPrefix() == null) && ("xmlns".equals(localNode.getNodeName())))) {}
      String str1;
      String str2;
      label155:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          str1 = localNode.getLocalName();
          str2 = localNode.getNamespaceURI();
          if (!"xml:lang".equals(localNode.getNodeName())) {
            break label155;
          }
          a(paramp, "xml:lang", localNode.getNodeValue());
        }
      } while (("http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(str2)) && (("ID".equals(str1)) || ("parseType".equals(str1))));
      throw new c("Invalid attribute for ParseTypeResource property element", 202);
    }
    c(paramn, paramp, paramNode, false);
    if (paramp.getHasValueChild()) {
      a(paramp);
    }
  }
  
  private static void h(n paramn, p paramp, Node paramNode, boolean paramBoolean)
    throws c
  {
    int i = 0;
    int k = 0;
    int m = 0;
    int j = 0;
    if (paramNode.hasChildNodes()) {
      throw new c("Nested content not allowed with rdf:resource or property attributes", 202);
    }
    int i1 = 0;
    Object localObject1 = null;
    Object localObject2;
    int n;
    if (i1 < paramNode.getAttributes().getLength())
    {
      localObject2 = paramNode.getAttributes().item(i1);
      n = k;
      if ("xmlns".equals(((Node)localObject2).getPrefix())) {
        break label794;
      }
      if ((((Node)localObject2).getPrefix() == null) && ("xmlns".equals(((Node)localObject2).getNodeName())))
      {
        n = j;
        j = m;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      i1 += 1;
      n = m;
      m = j;
      j = i;
      i = n;
      break;
      switch (c((Node)localObject2))
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        throw new c("Unrecognized attribute of empty property element", 202);
      case 2: 
        n = i;
        i = j;
        j = m;
        m = n;
        break;
      case 5: 
        if (m != 0) {
          throw new c("Empty property element can't have both rdf:resource and rdf:nodeID", 202);
        }
        if (j != 0) {
          throw new c("Empty property element can't have both rdf:value and rdf:resource", 203);
        }
        n = 1;
        if (j == 0)
        {
          localObject1 = localObject2;
          k = m;
          n = 1;
          m = i;
          i = j;
          j = k;
          k = n;
        }
        break;
      case 6: 
        if (k != 0) {
          throw new c("Empty property element can't have both rdf:resource and rdf:nodeID", 202);
        }
        m = i;
        n = 1;
        i = j;
        j = n;
        break;
      case 0: 
        if (("value".equals(((Node)localObject2).getLocalName())) && ("http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(((Node)localObject2).getNamespaceURI())))
        {
          if (k != 0) {
            throw new c("Empty property element can't have both rdf:value and rdf:resource", 203);
          }
          j = m;
          m = i;
          localObject1 = localObject2;
          i = 1;
        }
        else
        {
          n = k;
          if (!"xml:lang".equals(((Node)localObject2).getNodeName()))
          {
            n = 1;
            i = j;
            j = m;
            m = n;
            continue;
            localObject2 = a(paramn, paramp, paramNode, "", paramBoolean);
            if ((j != 0) || (k != 0)) {
              if (localObject1 != null)
              {
                paramp = ((Node)localObject1).getNodeValue();
                ((p)localObject2).setValue(paramp);
                if (j != 0) {
                  break label788;
                }
                ((p)localObject2).getOptions().setURI(true);
                i = 0;
              }
            }
            for (;;)
            {
              label519:
              j = 0;
              label522:
              if (j < paramNode.getAttributes().getLength())
              {
                paramp = paramNode.getAttributes().item(j);
                if ((paramp == localObject1) || ("xmlns".equals(paramp.getPrefix())) || ((paramp.getPrefix() == null) && ("xmlns".equals(paramp.getNodeName())))) {}
                for (;;)
                {
                  j += 1;
                  break label522;
                  paramp = "";
                  break;
                  if (i == 0) {
                    break label788;
                  }
                  ((p)localObject2).getOptions().setStruct(true);
                  i = 1;
                  break label519;
                  switch (c(paramp))
                  {
                  case 2: 
                  case 6: 
                  case 1: 
                  case 3: 
                  case 4: 
                  default: 
                    throw new c("Unrecognized attribute of empty property element", 202);
                  case 5: 
                    a((p)localObject2, "rdf:resource", paramp.getNodeValue());
                    break;
                  case 0: 
                    if (i == 0) {
                      a((p)localObject2, paramp.getNodeName(), paramp.getNodeValue());
                    } else if ("xml:lang".equals(paramp.getNodeName())) {
                      a((p)localObject2, "xml:lang", paramp.getNodeValue());
                    } else {
                      a(paramn, (p)localObject2, paramp, paramp.getNodeValue(), false);
                    }
                    break;
                  }
                }
              }
              return;
              label788:
              i = 0;
            }
          }
          else
          {
            label794:
            k = n;
            n = i;
            i = j;
            j = m;
            m = n;
          }
        }
        break;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */