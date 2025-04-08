package top.theillusivec4.curios.mixin.core;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.theillusivec4.curios.mixin.CuriosUtilMixinHooks;

@Mixin(Inventory.class)
public class MixinInventory {

  @Shadow
  @Final
  public Player player;

  @Inject(
      at = @At("TAIL"),
      method = "contains(Lnet/minecraft/world/item/ItemStack;)Z",
      cancellable = true
  )
  private void curios$containsStack(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {

    if (CuriosUtilMixinHooks.containsStack(this.player, stack)) {
      cir.setReturnValue(true);
    }
  }

  @Inject(
      at = @At("TAIL"),
      method = "contains(Lnet/minecraft/tags/TagKey;)Z",
      cancellable = true
  )
  private void curios$containsTag(TagKey<Item> tagKey, CallbackInfoReturnable<Boolean> cir) {

    if (CuriosUtilMixinHooks.containsTag(this.player, tagKey)) {
      cir.setReturnValue(true);
    }
  }
}
