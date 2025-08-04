package com.bi.keystrokesmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = KeystrokesMod.MODID, name = KeystrokesMod.NAME, version = KeystrokesMod.VERSION, clientSideOnly = true)
public class KeystrokesMod {
    public static final String MODID = "keystrokesmod";
    public static final String NAME = "Keystrokes Mod";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // No code here
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // No code here
    }
}
