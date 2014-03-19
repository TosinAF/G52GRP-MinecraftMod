package org.educraft.block.ordering;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.educraft.EduCraft;
import org.educraft.block.CraftingTileEntity;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class OrderingGui extends GuiContainer {
	
	private ResourceLocation orderingBench = new ResourceLocation(EduCraft.GuiTexturePrefix
			+ "ordering_table.png");
	private Boolean flag;
	
	public OrderingGui(InventoryPlayer inventory, World world,
			CraftingTileEntity tileEntity, Boolean numberFlag) {
		super(new OrderingContainer(inventory, tileEntity, world, numberFlag));
		this.flag = numberFlag;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		
		String name;
		
		if(this.flag == null) {
			name = "Ordering";
		} else if (this.flag == true) {
			name = "Ordering Odd";
		} else {
			name = "Ordering Even";
		} 
		
		this.fontRenderer.drawString(name, 28, 6, 4210752);
		this.fontRenderer.drawString(I18n.getString("container.inventory"), 8,
				this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(orderingBench);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}
