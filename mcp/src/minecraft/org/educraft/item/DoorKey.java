package org.educraft.item;

import net.minecraft.item.Item;

import org.educraft.EduCraft;

public class DoorKey extends Item {
		
		public DoorKey (int itemId) {
			super(itemId);
			setUnlocalizedName("doorKey");
			setMaxStackSize(4);
			setCreativeTab(EduCraft.tabEduCraft);
			setTextureName("educraft:doorkey");
		}	
}
