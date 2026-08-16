package survivalblock.atmosphere.doing_it_myself.mixin.tourmaline;

import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import survivalblock.atmosphere.doing_it_myself.tourmaline.ClientFoodLimiter;

@Mixin(FoodData.class)
public class FoodDataMixin implements ClientFoodLimiter {
    @SuppressWarnings("MixinAnnotationTarget")
    @Shadow
    int tourmaline$maxFood;

    @Override
    public void doing_it_myself$setMaxFood(int maxFood) {
        this.tourmaline$maxFood = maxFood;
    }
}
