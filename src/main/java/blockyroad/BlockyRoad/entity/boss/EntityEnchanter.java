package blockyroad.BlockyRoad.entity.boss;

import blockyroad.BlockyRoad.BlockyRoad;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityEnchanter extends EntityMob implements IRangedAttackMob {

	public static final ResourceLocation LOOT_TABLE = new ResourceLocation(BlockyRoad.MODID + "loot_tables/entities/enchanter/enchanter");

	private EntityAIAttackRanged aiEnchantedBlast;

	public EntityEnchanter(World world) {
		super(world);
		this.setSize(2.8F, 4.0F);
		this.experienceValue = 262;
	}

	@Override
	public void initEntityAI(){
		aiEnchantedBlast = new EntityAIAttackRanged(this, 1.0D, 20, 60, 15.0F);

		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, this.aiEnchantedBlast);
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
	}

	@Override
	public ResourceLocation getLootTable() {
		return LOOT_TABLE;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {

	}

	@Override
	public void setSwingingArms(boolean swingingArms) {}
}
