/*    */ package com.anotherstar.anticheat;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
/*    */ import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
/*    */ import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;


/*    */
/*    */ 
/*    */ 
/*    */ @Mod(modid="AnotherStarAntiCheat", name="AnotherStarAntiCheat Mod", version="beta-1.0.6", acceptedMinecraftVersions="1.7.10")
/*    */ public class AntiCheat
/*    */ {
/*    */   public static final String MODID = "AnotherStarAntiCheat";
/*    */   public static final String NAME = "AnotherStarAntiCheat Mod";
/*    */   public static final String VERSION = "beta-1.0.6";
           public static final File fin = new File("D:\\in.txt");
           public static final File fout = new File("D:\\out.txt");
            public static TickEventHandler tickEventHandler = new TickEventHandler();
/*    */   @Mod.Instance("AnotherStarAntiCheat")
/*    */   public static AntiCheat instance;
/*    */   public static SimpleNetworkWrapper antiCheatNetwork;
/*    */   @Mod.EventHandler
/*    */   public void preInit(FMLPreInitializationEvent event)
/*    */   {
/* 30 */     antiCheatNetwork = NetworkRegistry.INSTANCE.newSimpleChannel("AnotherStarAntiCheat");
    /* 50 */ antiCheatNetwork.registerMessage(new AntiCheatSTCPacketMessageHandler(), AntiCheatSTCPacketMessage.class, 0, Side.CLIENT);
    /* 52 */ antiCheatNetwork.registerMessage(new AntiCheatCTSPacketMessageHandler(), AntiCheatCTSPacketMessage.class, 1, Side.SERVER);
             FMLCommonHandler.instance().bus().register(tickEventHandler);
/*    */   }
            @Mod.EventHandler
            public void init(FMLInitializationEvent event)
            {
            }
/*    */
/*    */ }


/* Location:              D:\pro\java\AnotherStarAntiCheat.jar!\com\anotherstar\anticheat\AntiCheat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */