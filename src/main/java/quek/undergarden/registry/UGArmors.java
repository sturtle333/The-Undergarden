package quek.undergarden.registry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum UGArmors implements ArmorMaterial {
    CLOGGRUM("cloggrum", 20, new int[]{2, 5, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(UGItems.CLOGGRUM_INGOT.get())),
    FROSTSTEEL("froststeel", 25, new int[]{2, 5, 6, 2}, 15, SoundEvents.ARMOR_EQUIP_GOLD, 4.0F, 0.5F, () -> Ingredient.of(UGItems.FROSTSTEEL_INGOT.get())),
    UTHERIUM("utherium", 30, new int[]{3, 6, 8, 3}, 13, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.0F, () -> Ingredient.of(UGItems.UTHERIUM_CRYSTAL.get())),
    MASTICATED("masticated", 17, new int[]{6, 6, 6, 6}, 5, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> Ingredient.of(UGItems.MASTICATOR_SCALES.get()))
    ;

    private static final int[] DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    UGArmors(String name, int durability, int[] protection, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durability;
        this.slotProtections = protection;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return DURABILITY[slotIn.getIndex()] * durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return slotProtections[slotIn.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}