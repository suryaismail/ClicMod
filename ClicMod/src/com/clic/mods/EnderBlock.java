package com.clic.mods;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class EnderBlock extends Block {

	public EnderBlock() {
		super(Material.IRON);
		this.setUnlocalizedName("enderBlock");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setResistance(5.0F);
		this.setHardness(10.0F);
		this.setLightLevel(1.0F);
	}
	
	/*@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		IBlockState block = world.getBlockState(pos.add(0, -1, 0));
		world.setBlockState(pos, block);
		EntityLightningBolt lightning = new EntityLightningBolt(world,
						pos.getX(), pos.getY(), pos.getZ(),false);
		world.addWeatherEffect(lightning);
	}*/
	
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state,
                                    EntityPlayer player, EnumHand hand, EnumFacing heldItem,
                                    float side, float hitX, float hitY) {
        if (!world.isRemote)
            return false;

        player.addChatMessage(new TextComponentString(
				TextFormatting.DARK_PURPLE + "You have clicked on the majestic ENDERIUM BLOCK!!!!!"));
        EntityEnderEye eye = new EntityEnderEye(world,
        pos.getX() + 0.5,
        pos.getY() + 1.5,
        pos.getZ() + 0.5);
        eye.motionY = 0.1;
        world.spawnEntityInWorld(eye);
        return true;
    }
}