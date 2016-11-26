package mcjty.lib.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;

public class InventoryTools {

    public static boolean isUsable(EntityPlayer player, IInventory inventory) {
        return inventory.isUsableByPlayer(player);
    }

    public static ItemStack onPickup(Slot slot, EntityPlayer player, ItemStack stack) {
        return slot.onTake(player, stack);
    }

    public static EnumActionResult onItemUseWithStack(Item item, @Nonnull ItemStack stack, EntityPlayer player,
                                                      World world, BlockPos pos, EnumHand hand, EnumFacing facing,
                                                      float hitX, float hitY, float hitZ) {
        player.setHeldItem(hand, stack);
        return item.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    public static List<ItemStack> getRemainingItems(IRecipe recipe, InventoryCrafting inventoryCrafting) {
        return recipe.getRemainingItems(inventoryCrafting);
    }

    public static List<ItemStack> getRemainingItems(InventoryCrafting workInventory, World world) {
        return CraftingManager.getInstance().getRemainingItems(workInventory, world);
    }

    public static List<ItemStack> getContainerItemStacks(Container container) {
        return container.inventoryItemStacks;
    }
}