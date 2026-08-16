package survivalblock.atmosphere.doing_it_myself.mixin.tourmaline;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pet.cyan.tourmaline.registry.TourmalineAttributes;
import survivalblock.atmosphere.doing_it_myself.tourmaline.ClientFoodLimiter;

@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerMixin extends Player {
    public AbstractClientPlayerMixin(Level level, GameProfile gameProfile) {
        super(level, gameProfile);
    }

    @Inject(method = "tick", at = @At("RETURN"))
    private void tickFoodData(CallbackInfo ci) {
        ((ClientFoodLimiter) this.foodData).doing_it_myself$setMaxFood(
                Mth.ceil(this.getAttributeValue(TourmalineAttributes.MAX_FOOD))
        );
    }
}
