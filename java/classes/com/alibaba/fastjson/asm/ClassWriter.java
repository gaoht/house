package com.alibaba.fastjson.asm;

public class ClassWriter
{
  private int access;
  FieldWriter firstField;
  MethodWriter firstMethod;
  int index = 1;
  private int interfaceCount;
  private int[] interfaces;
  Item[] items = new Item['Ā'];
  final Item key = new Item();
  final Item key2 = new Item();
  final Item key3 = new Item();
  FieldWriter lastField;
  MethodWriter lastMethod;
  private int name;
  final ByteVector pool = new ByteVector();
  private int superName;
  String thisName;
  int threshold = (int)(0.75D * this.items.length);
  Item[] typeTable;
  int version;
  
  public ClassWriter()
  {
    this(0);
  }
  
  private ClassWriter(int paramInt) {}
  
  private Item get(Item paramItem)
  {
    for (Item localItem = this.items[(paramItem.hashCode % this.items.length)]; (localItem != null) && ((localItem.type != paramItem.type) || (!paramItem.isEqualTo(localItem))); localItem = localItem.next) {}
    return localItem;
  }
  
  private Item newString(String paramString)
  {
    this.key2.set(8, paramString, null, null);
    Item localItem2 = get(this.key2);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      this.pool.put12(8, newUTF8(paramString));
      int i = this.index;
      this.index = (i + 1);
      localItem1 = new Item(i, this.key2);
      put(localItem1);
    }
    return localItem1;
  }
  
  private void put(Item paramItem)
  {
    if (this.index > this.threshold)
    {
      i = this.items.length;
      int j = i * 2 + 1;
      Item[] arrayOfItem = new Item[j];
      i -= 1;
      while (i >= 0)
      {
        Item localItem;
        for (Object localObject = this.items[i]; localObject != null; localObject = localItem)
        {
          int k = ((Item)localObject).hashCode % arrayOfItem.length;
          localItem = ((Item)localObject).next;
          ((Item)localObject).next = arrayOfItem[k];
          arrayOfItem[k] = localObject;
        }
        i -= 1;
      }
      this.items = arrayOfItem;
      this.threshold = ((int)(j * 0.75D));
    }
    int i = paramItem.hashCode % this.items.length;
    paramItem.next = this.items[i];
    this.items[i] = paramItem;
  }
  
  public Item newClassItem(String paramString)
  {
    this.key2.set(7, paramString, null, null);
    Item localItem2 = get(this.key2);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      this.pool.put12(7, newUTF8(paramString));
      int i = this.index;
      this.index = (i + 1);
      localItem1 = new Item(i, this.key2);
      put(localItem1);
    }
    return localItem1;
  }
  
  Item newConstItem(Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      int i = ((Integer)paramObject).intValue();
      this.key.set(i);
      Item localItem = get(this.key);
      paramObject = localItem;
      if (localItem == null)
      {
        this.pool.putByte(3).putInt(i);
        i = this.index;
        this.index = (i + 1);
        paramObject = new Item(i, this.key);
        put((Item)paramObject);
      }
      return (Item)paramObject;
    }
    if ((paramObject instanceof String)) {
      return newString((String)paramObject);
    }
    if ((paramObject instanceof Type))
    {
      paramObject = (Type)paramObject;
      if (((Type)paramObject).sort == 10) {}
      for (paramObject = ((Type)paramObject).getInternalName();; paramObject = ((Type)paramObject).getDescriptor()) {
        return newClassItem((String)paramObject);
      }
    }
    throw new IllegalArgumentException("value " + paramObject);
  }
  
  Item newFieldItem(String paramString1, String paramString2, String paramString3)
  {
    this.key3.set(9, paramString1, paramString2, paramString3);
    Item localItem2 = get(this.key3);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      int i = newClassItem(paramString1).index;
      int j = newNameTypeItem(paramString2, paramString3).index;
      this.pool.put12(9, i).putShort(j);
      i = this.index;
      this.index = (i + 1);
      localItem1 = new Item(i, this.key3);
      put(localItem1);
    }
    return localItem1;
  }
  
  Item newMethodItem(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramBoolean) {}
    Item localItem;
    for (int i = 11;; i = 10)
    {
      this.key3.set(i, paramString1, paramString2, paramString3);
      localItem = get(this.key3);
      if (localItem != null) {
        break;
      }
      int j = newClassItem(paramString1).index;
      int k = newNameTypeItem(paramString2, paramString3).index;
      this.pool.put12(i, j).putShort(k);
      i = this.index;
      this.index = (i + 1);
      paramString1 = new Item(i, this.key3);
      put(paramString1);
      return paramString1;
    }
    return localItem;
  }
  
  public Item newNameTypeItem(String paramString1, String paramString2)
  {
    this.key2.set(12, paramString1, paramString2, null);
    Item localItem2 = get(this.key2);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      int i = newUTF8(paramString1);
      int j = newUTF8(paramString2);
      this.pool.put12(12, i).putShort(j);
      i = this.index;
      this.index = (i + 1);
      localItem1 = new Item(i, this.key2);
      put(localItem1);
    }
    return localItem1;
  }
  
  public int newUTF8(String paramString)
  {
    this.key.set(1, paramString, null, null);
    Item localItem2 = get(this.key);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      this.pool.putByte(1).putUTF8(paramString);
      int i = this.index;
      this.index = (i + 1);
      localItem1 = new Item(i, this.key);
      put(localItem1);
    }
    return localItem1.index;
  }
  
  public byte[] toByteArray()
  {
    int i = this.interfaceCount * 2 + 24;
    Object localObject = this.firstField;
    int j = 0;
    while (localObject != null)
    {
      i += ((FieldWriter)localObject).getSize();
      localObject = ((FieldWriter)localObject).next;
      j += 1;
    }
    localObject = this.firstMethod;
    int m = 0;
    int k = i;
    i = m;
    while (localObject != null)
    {
      i += 1;
      k += ((MethodWriter)localObject).getSize();
      localObject = ((MethodWriter)localObject).next;
    }
    ByteVector localByteVector = new ByteVector(this.pool.length + k);
    localByteVector.putInt(-889275714).putInt(this.version);
    localByteVector.putShort(this.index).putByteArray(this.pool.data, 0, this.pool.length);
    localByteVector.putShort(this.access & 0xFFF9FFFF).putShort(this.name).putShort(this.superName);
    localByteVector.putShort(this.interfaceCount);
    k = 0;
    while (k < this.interfaceCount)
    {
      localByteVector.putShort(this.interfaces[k]);
      k += 1;
    }
    localByteVector.putShort(j);
    for (localObject = this.firstField; localObject != null; localObject = ((FieldWriter)localObject).next) {
      ((FieldWriter)localObject).put(localByteVector);
    }
    localByteVector.putShort(i);
    for (localObject = this.firstMethod; localObject != null; localObject = ((MethodWriter)localObject).next) {
      ((MethodWriter)localObject).put(localByteVector);
    }
    localByteVector.putShort(0);
    return localByteVector.data;
  }
  
  public void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    this.version = paramInt1;
    this.access = paramInt2;
    this.name = newClassItem(paramString1).index;
    this.thisName = paramString1;
    if (paramString2 == null) {}
    for (paramInt1 = 0;; paramInt1 = newClassItem(paramString2).index)
    {
      this.superName = paramInt1;
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
        break;
      }
      this.interfaceCount = paramArrayOfString.length;
      this.interfaces = new int[this.interfaceCount];
      paramInt1 = i;
      while (paramInt1 < this.interfaceCount)
      {
        this.interfaces[paramInt1] = newClassItem(paramArrayOfString[paramInt1]).index;
        paramInt1 += 1;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/asm/ClassWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */