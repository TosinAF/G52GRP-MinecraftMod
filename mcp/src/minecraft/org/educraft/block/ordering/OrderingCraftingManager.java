package org.educraft.block.ordering;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

import org.educraft.EduCraft;
import org.educraft.item.BaseNumber;


public class OrderingCraftingManager {
	/** The static instance of this class */
	private static final OrderingCraftingManager INSTANCE = new OrderingCraftingManager();

	/**
	 * Returns the static instance of this class
	 */
	public static final OrderingCraftingManager getInstance() {
		return INSTANCE;
	}

	public ItemStack findMatchingRecipe(InventoryCrafting inventory) {

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			if ((inventory.getStackInSlot(i) == null)
					|| !(inventory.getStackInSlot(i).getItem() instanceof BaseNumber)) {
				return null;
			}
		}
		for (int i = 0; i < inventory.getSizeInventory() - 1; i++) {
			if (inventory.getStackInSlot(i).getItemDamage() >= inventory
					.getStackInSlot(i + 1).getItemDamage()) {
				return null;
			}
		}

		return new ItemStack(EduCraft.KEY);
	}
}
