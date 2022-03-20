package quek.undergarden.item.tool.slingshot;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import quek.undergarden.entity.projectile.slingshot.DepthrockPebbleEntity;
import quek.undergarden.entity.projectile.slingshot.SlingshotProjectile;

import javax.annotation.Nullable;
import java.util.List;

public class DepthrockPebbleItem extends Item implements SlingshotAmmo {

    public DepthrockPebbleItem(Properties properties) {
        super(properties);
    }

    @Override
    public SlingshotProjectile createProjectile(Level level, LivingEntity shooter) {
        return new DepthrockPebbleEntity(level, shooter);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        SlingshotAmmo.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}
