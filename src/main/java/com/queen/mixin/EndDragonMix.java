package com.queen.mixin;

import java.util.List;

import com.queen.LastSword;
import com.queen.ModItems;
import com.queen.utils.DropMetrics;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonFight;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mixin(EnderDragonFight.class)
public class EndDragonMix {

    @Shadow
    public boolean dragonKilled;


    @Inject(method = "dragonKilled", at = @At("RETURN"))
    public void dragonKilled_inject_tlsywen(EnderDragonEntity dragon, CallbackInfo callback) {
        /* original method
        if (dragon.getUuid().equals(this.dragonUuid)) {
            this.bossBar.setPercent(0.0f);
            this.bossBar.setVisible(false);
            this.generateEndPortal(true);
            this.generateNewEndGateway();
            if (!this.previouslyKilled) {
                this.world.setBlockState(this.world.getTopPosition(Heightmap.Type.MOTION_BLOCKING, EndPortalFeature.ORIGIN), Blocks.DRAGON_EGG.getDefaultState());
            }
            this.previouslyKilled = true;
            this.dragonKilled = true;
        }
        */
        // injection starts here bc we are using "RETURN"
        if (dragonKilled){
            // the shadowed boolean should match the source files "dragonKilled" var
            // this method call is valid because dragonKilled = true?

            World world = dragon.getWorld();
            if (!world.isClient){
                LastSword.LOGGER.info("Dragon Killed & Valid :D. Giving out loot");
                List<? extends PlayerEntity> worldPlayers = world.getPlayers();
                for (PlayerEntity pe : worldPlayers){
                    ;
                    // This should iterate through all players in the end and give them the loot.
                    // custom accessor is used here to get the dimension type instance (normally protected)
                    if (pe.world.getDimension().equals(DimensionTypeAccess.getTHE_END())){

                        int amount = DropMetrics.getDrop(world.random, DropMetrics.END_DRAGON_DROP_RATE);
                        pe.getInventory().insertStack(new ItemStack(ModItems.DRAGON_CRYSTAL, amount));
                    }
                }
            }
        }
    }
}
