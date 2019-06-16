/*    */ package com.anotherstar.anticheat;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;

import java.io.File;
import java.io.FileOutputStream;

/*    */
/*    */ public class AntiCheatCTSPacketMessageHandler implements IMessageHandler<AntiCheatCTSPacketMessage, IMessage>
/*    */ {
/*    */   public IMessage onMessage(AntiCheatCTSPacketMessage message, MessageContext ctx)
/*    */   {
            try{
                if (!AntiCheat.fout.exists()) AntiCheat.fout.createNewFile();
                FileOutputStream fout = new FileOutputStream("D:\\out.txt");
                int n = message.md5s.length;
                fout.write(n / 256);
                fout.write(n % 256);
                for (int i  = 0; i < n; ++i)
                {
                    int len = message.md5s[i].length;
                    fout.write(len / 256);
                    fout.write(len % 256);
                    fout.write(message.md5s[i]);
                }
                fout.close();
                AntiCheat.fin.delete();
            }catch(Exception e){
            }
/* 93 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\pro\java\AnotherStarAntiCheat.jar!\com\anotherstar\anticheat\AntiCheatCTSPacketMessageHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */