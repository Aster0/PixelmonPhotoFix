package me.astero.pixelmonphotofix;

import net.minecraftforge.fml.common.Mod;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PixelmonPhotoFix.MODID)
public class PixelmonPhotoFix {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "pixelmonphotofix";


    public PixelmonPhotoFix() {

        MixinBootstrap.init();
        Mixins.addConfiguration("mixins." + MODID + ".json");

    }


}
