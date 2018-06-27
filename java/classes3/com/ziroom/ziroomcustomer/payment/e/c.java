package com.ziroom.ziroomcustomer.payment.e;

import com.ziroom.ziroomcustomer.util.ae;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c
{
  private static void a(Object paramObject, Iterator paramIterator)
  {
    if ((paramObject instanceof String)) {
      if (ae.isNull((String)paramObject)) {
        paramIterator.remove();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramObject instanceof Collection)) {
              break;
            }
            paramObject = (Collection)paramObject;
          } while ((paramObject != null) && (!((Collection)paramObject).isEmpty()));
          paramIterator.remove();
          return;
          if (!(paramObject instanceof Map)) {
            break;
          }
          paramObject = (Map)paramObject;
        } while ((paramObject != null) && (!((Map)paramObject).isEmpty()));
        paramIterator.remove();
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
      } while ((paramObject != null) && (paramObject.length > 0));
      paramIterator.remove();
      return;
    } while (paramObject != null);
    paramIterator.remove();
  }
  
  public static void removeNullEntry(Map paramMap)
  {
    removeNullKey(paramMap);
    removeNullValue(paramMap);
  }
  
  public static void removeNullKey(Map paramMap)
  {
    paramMap = paramMap.keySet().iterator();
    while (paramMap.hasNext()) {
      a(paramMap.next(), paramMap);
    }
  }
  
  public static void removeNullValue(Map paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      a(paramMap.get(localIterator.next()), localIterator);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */