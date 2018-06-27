package com.alibaba.fastjson.asm;

public final class FieldWriter
{
  private final int access;
  private final int desc;
  private final int name;
  FieldWriter next;
  
  public FieldWriter(ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2)
  {
    if (paramClassWriter.firstField == null) {
      paramClassWriter.firstField = this;
    }
    for (;;)
    {
      paramClassWriter.lastField = this;
      this.access = paramInt;
      this.name = paramClassWriter.newUTF8(paramString1);
      this.desc = paramClassWriter.newUTF8(paramString2);
      return;
      paramClassWriter.lastField.next = this;
    }
  }
  
  int getSize()
  {
    return 8;
  }
  
  void put(ByteVector paramByteVector)
  {
    paramByteVector.putShort(this.access & 0xFFF9FFFF).putShort(this.name).putShort(this.desc);
    paramByteVector.putShort(0);
  }
  
  public void visitEnd() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/alibaba/fastjson/asm/FieldWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */