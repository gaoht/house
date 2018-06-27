package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class SerializeFilterable
{
  protected List<AfterFilter> afterFilters = null;
  protected List<BeforeFilter> beforeFilters = null;
  protected List<ContextValueFilter> contextValueFilters = null;
  protected List<LabelFilter> labelFilters = null;
  protected List<NameFilter> nameFilters = null;
  protected List<PropertyFilter> propertyFilters = null;
  protected List<PropertyPreFilter> propertyPreFilters = null;
  protected List<ValueFilter> valueFilters = null;
  protected boolean writeDirect = true;
  
  public void addFilter(SerializeFilter paramSerializeFilter)
  {
    if (paramSerializeFilter == null) {}
    do
    {
      return;
      if ((paramSerializeFilter instanceof PropertyPreFilter)) {
        getPropertyPreFilters().add((PropertyPreFilter)paramSerializeFilter);
      }
      if ((paramSerializeFilter instanceof NameFilter)) {
        getNameFilters().add((NameFilter)paramSerializeFilter);
      }
      if ((paramSerializeFilter instanceof ValueFilter)) {
        getValueFilters().add((ValueFilter)paramSerializeFilter);
      }
      if ((paramSerializeFilter instanceof ContextValueFilter)) {
        getContextValueFilters().add((ContextValueFilter)paramSerializeFilter);
      }
      if ((paramSerializeFilter instanceof PropertyFilter)) {
        getPropertyFilters().add((PropertyFilter)paramSerializeFilter);
      }
      if ((paramSerializeFilter instanceof BeforeFilter)) {
        getBeforeFilters().add((BeforeFilter)paramSerializeFilter);
      }
      if ((paramSerializeFilter instanceof AfterFilter)) {
        getAfterFilters().add((AfterFilter)paramSerializeFilter);
      }
    } while (!(paramSerializeFilter instanceof LabelFilter));
    getLabelFilters().add((LabelFilter)paramSerializeFilter);
  }
  
  public boolean apply(JSONSerializer paramJSONSerializer, Object paramObject1, String paramString, Object paramObject2)
  {
    if (paramJSONSerializer.propertyFilters != null)
    {
      paramJSONSerializer = paramJSONSerializer.propertyFilters.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((PropertyFilter)paramJSONSerializer.next()).apply(paramObject1, paramString, paramObject2)) {
          return false;
        }
      }
    }
    if (this.propertyFilters != null)
    {
      paramJSONSerializer = this.propertyFilters.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((PropertyFilter)paramJSONSerializer.next()).apply(paramObject1, paramString, paramObject2)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean applyName(JSONSerializer paramJSONSerializer, Object paramObject, String paramString)
  {
    Iterator localIterator;
    if (paramJSONSerializer.propertyPreFilters != null)
    {
      localIterator = paramJSONSerializer.propertyPreFilters.iterator();
      while (localIterator.hasNext()) {
        if (!((PropertyPreFilter)localIterator.next()).apply(paramJSONSerializer, paramObject, paramString)) {
          return false;
        }
      }
    }
    if (this.propertyPreFilters != null)
    {
      localIterator = this.propertyPreFilters.iterator();
      while (localIterator.hasNext()) {
        if (!((PropertyPreFilter)localIterator.next()).apply(paramJSONSerializer, paramObject, paramString)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public List<AfterFilter> getAfterFilters()
  {
    if (this.afterFilters == null)
    {
      this.afterFilters = new ArrayList();
      this.writeDirect = false;
    }
    return this.afterFilters;
  }
  
  public List<BeforeFilter> getBeforeFilters()
  {
    if (this.beforeFilters == null)
    {
      this.beforeFilters = new ArrayList();
      this.writeDirect = false;
    }
    return this.beforeFilters;
  }
  
  public List<ContextValueFilter> getContextValueFilters()
  {
    if (this.contextValueFilters == null)
    {
      this.contextValueFilters = new ArrayList();
      this.writeDirect = false;
    }
    return this.contextValueFilters;
  }
  
  public List<LabelFilter> getLabelFilters()
  {
    if (this.labelFilters == null)
    {
      this.labelFilters = new ArrayList();
      this.writeDirect = false;
    }
    return this.labelFilters;
  }
  
  public List<NameFilter> getNameFilters()
  {
    if (this.nameFilters == null)
    {
      this.nameFilters = new ArrayList();
      this.writeDirect = false;
    }
    return this.nameFilters;
  }
  
  public List<PropertyFilter> getPropertyFilters()
  {
    if (this.propertyFilters == null)
    {
      this.propertyFilters = new ArrayList();
      this.writeDirect = false;
    }
    return this.propertyFilters;
  }
  
  public List<PropertyPreFilter> getPropertyPreFilters()
  {
    if (this.propertyPreFilters == null)
    {
      this.propertyPreFilters = new ArrayList();
      this.writeDirect = false;
    }
    return this.propertyPreFilters;
  }
  
  public List<ValueFilter> getValueFilters()
  {
    if (this.valueFilters == null)
    {
      this.valueFilters = new ArrayList();
      this.writeDirect = false;
    }
    return this.valueFilters;
  }
  
  protected String processKey(JSONSerializer paramJSONSerializer, Object paramObject1, String paramString, Object paramObject2)
  {
    String str = paramString;
    if (paramJSONSerializer.nameFilters != null)
    {
      paramJSONSerializer = paramJSONSerializer.nameFilters.iterator();
      for (;;)
      {
        str = paramString;
        if (!paramJSONSerializer.hasNext()) {
          break;
        }
        paramString = ((NameFilter)paramJSONSerializer.next()).process(paramObject1, paramString, paramObject2);
      }
    }
    paramJSONSerializer = str;
    if (this.nameFilters != null)
    {
      paramString = this.nameFilters.iterator();
      for (;;)
      {
        paramJSONSerializer = str;
        if (!paramString.hasNext()) {
          break;
        }
        str = ((NameFilter)paramString.next()).process(paramObject1, str, paramObject2);
      }
    }
    return paramJSONSerializer;
  }
  
  protected Object processValue(JSONSerializer paramJSONSerializer, BeanContext paramBeanContext, Object paramObject1, String paramString, Object paramObject2)
  {
    Object localObject1 = paramObject2;
    if (paramObject2 != null)
    {
      if ((!paramJSONSerializer.out.writeNonStringValueAsString) || ((!(paramObject2 instanceof Number)) && (!(paramObject2 instanceof Boolean)))) {
        break label103;
      }
      localObject1 = paramObject2.toString();
    }
    for (;;)
    {
      paramObject2 = localObject1;
      if (paramJSONSerializer.valueFilters == null) {
        break;
      }
      localObject2 = paramJSONSerializer.valueFilters.iterator();
      for (;;)
      {
        paramObject2 = localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((ValueFilter)((Iterator)localObject2).next()).process(paramObject1, paramString, localObject1);
      }
      label103:
      localObject1 = paramObject2;
      if (paramBeanContext != null)
      {
        localObject1 = paramObject2;
        if (paramBeanContext.isJsonDirect()) {
          localObject1 = a.parse((String)paramObject2);
        }
      }
    }
    Object localObject2 = this.valueFilters;
    localObject1 = paramObject2;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        localObject1 = paramObject2;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramObject2 = ((ValueFilter)((Iterator)localObject2).next()).process(paramObject1, paramString, paramObject2);
      }
    }
    paramObject2 = localObject1;
    if (paramJSONSerializer.contextValueFilters != null)
    {
      paramJSONSerializer = paramJSONSerializer.contextValueFilters.iterator();
      for (;;)
      {
        paramObject2 = localObject1;
        if (!paramJSONSerializer.hasNext()) {
          break;
        }
        localObject1 = ((ContextValueFilter)paramJSONSerializer.next()).process(paramBeanContext, paramObject1, paramString, localObject1);
      }
    }
    paramJSONSerializer = (JSONSerializer)paramObject2;
    if (this.contextValueFilters != null)
    {
      localObject1 = this.contextValueFilters.iterator();
      for (;;)
      {
        paramJSONSerializer = (JSONSerializer)paramObject2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        paramObject2 = ((ContextValueFilter)((Iterator)localObject1).next()).process(paramBeanContext, paramObject1, paramString, paramObject2);
      }
    }
    return paramJSONSerializer;
  }
  
  protected boolean writeDirect(JSONSerializer paramJSONSerializer)
  {
    return (paramJSONSerializer.out.writeDirect) && (this.writeDirect) && (paramJSONSerializer.writeDirect);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/serializer/SerializeFilterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */