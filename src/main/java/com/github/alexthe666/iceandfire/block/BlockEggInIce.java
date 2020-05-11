package com.github.alexthe666.iceandfire.block;

import com.github.alexthe666.iceandfire.IceAndFire;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityEggInIce;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import javax.annotation.Nullable;
import java.util.Random;

public class BlockEggInIce extends ContainerBlock {
    public Item itemBlock;

    @SuppressWarnings("deprecation")
    public BlockEggInIce() {
        super(Properties.create(Material.ICE).hardnessAndResistance(0.5F).variableOpacity().sound(SoundType.GLASS));
        setRegistryName(IceAndFire.MODID, "egginice");
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityEggInIce();
    }

    public Item getItem(World worldIn, BlockPos pos) {
        return Item.getItemFromBlock(Blocks.ICE);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te, ItemStack stack) {
        if (worldIn.getTileEntity(pos) != null) {
            if (worldIn.getTileEntity(pos) instanceof TileEntityEggInIce) {
                TileEntityEggInIce tile = (TileEntityEggInIce) worldIn.getTileEntity(pos);
                tile.spawnEgg();
            }
        }
        player.addStat(Stats.BLOCK_MINED.get(this));
        player.addExhaustion(0.005F);
    }

    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(BlockState blockstate) {
        return false;
    }

    @SuppressWarnings("deprecation")
    public boolean isFullCube(BlockState blockstate) {
        return false;
    }
}
