package io.github.faecraft.guillotine.guillotine;

import io.github.faecraft.guillotine.MixinHandler;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class PlayerDeathMixin {
    @Inject(method = "onDeath", at = @At("RETURN"))
    public void onDeath(DamageSource source, CallbackInfo ci) {
        MixinHandler.INSTANCE.onDeath((ServerPlayerEntity) (Object) this, source, ci);
    }
}
