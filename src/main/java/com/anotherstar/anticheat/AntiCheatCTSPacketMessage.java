/*    */ package com.anotherstar.anticheat;
/*    */ 
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.nbt.NBTTagByteArray;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ 
/*    */ public class AntiCheatCTSPacketMessage implements IMessage
/*    */ {
/*    */   public byte[][] md5s;
/*    */
/*    */   public AntiCheatCTSPacketMessage(){}
/*    */   public AntiCheatCTSPacketMessage(byte[][] md5s)
/*    */   {
/* 18 */     this.md5s = md5s;
/*    */   }
    /*    */   public void fromBytes(ByteBuf buf)
    /*    */   {
        /* 23 */     NBTTagCompound nbt = ByteBufUtils.readTag(buf);
        /* 24 */     NBTTagList md5List = nbt.getTagList("md5s", 7);
        /* 25 */     this.md5s = new byte[md5List.tagCount()][];
        /* 26 */     for (int i = this.md5s.length - 1; i >= 0; i--) {
            /* 27 */       this.md5s[i] = ((NBTTagByteArray)md5List.removeTag(i)).func_150292_c();
            /*    */     }
        /*    */   }

/*    */   public void toBytes(ByteBuf buf)
/*    */   {
/* 33 */     NBTTagCompound nbt = new NBTTagCompound();
/* 34 */     NBTTagList strList = new NBTTagList();
/* 35 */     for (byte[] md5 : this.md5s) {
/* 36 */       strList.appendTag(new NBTTagByteArray(md5));
/*    */     }
/* 38 */     nbt.setTag("md5s", strList);
/* 39 */     ByteBufUtils.writeTag(buf, nbt);
/*    */   }
/*    */ }


/* Location:              D:\pro\java\AnotherStarAntiCheat.jar!\com\anotherstar\anticheat\AntiCheatCTSPacketMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */