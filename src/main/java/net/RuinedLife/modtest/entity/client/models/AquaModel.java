package net.RuinedLife.modtest.entity.client.models;// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class AquaModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart scarf;
	private final ModelPart hair;
	private final ModelPart bangs;
	private final ModelPart bangs_left;
	private final ModelPart bangs_right;
	private final ModelPart top_hair;
	private final ModelPart bottom_hair;
	private final ModelPart side_hair_left;
	private final ModelPart side_twirl;
	private final ModelPart side_twirl2;
	private final ModelPart side_twirl3;
	private final ModelPart side_twirl4;
	private final ModelPart side_hair_right;
	private final ModelPart side_twirl5;
	private final ModelPart side_twirl6;
	private final ModelPart side_twirl7;
	private final ModelPart side_twirl8;
	private final ModelPart headtie;
	private final ModelPart body;
	private final ModelPart bottom_clothing;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart bb_main;

	public AquaModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
		this.scarf = this.head.getChild("scarf");
		this.hair = root.getChild("hair");
		this.bangs = this.hair.getChild("bangs");
		this.bangs_left = this.bangs.getChild("bangs_left");
		this.bangs_right = this.bangs.getChild("bangs_right");
		this.top_hair = this.hair.getChild("top_hair");
		this.bottom_hair = this.hair.getChild("bottom_hair");
		this.side_hair_left = this.bottom_hair.getChild("side_hair_left");
		this.side_twirl = this.side_hair_left.getChild("side_twirl");
		this.side_twirl2 = this.side_twirl.getChild("side_twirl2");
		this.side_twirl3 = this.side_twirl.getChild("side_twirl3");
		this.side_twirl4 = this.side_twirl.getChild("side_twirl4");
		this.side_hair_right = this.bottom_hair.getChild("side_hair_right");
		this.side_twirl5 = this.side_hair_right.getChild("side_twirl5");
		this.side_twirl6 = this.side_twirl5.getChild("side_twirl6");
		this.side_twirl7 = this.side_twirl5.getChild("side_twirl7");
		this.side_twirl8 = this.side_twirl5.getChild("side_twirl8");
		this.headtie = this.hair.getChild("headtie");
		this.body = root.getChild("body");
		this.bottom_clothing = this.body.getChild("bottom_clothing");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 43).addBox(-6.0F, -19.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(54, 98).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition scarf = head.addOrReplaceChild("scarf", CubeListBuilder.create().texOffs(0, 67).addBox(-5.0F, -2.0F, -4.0F, 9.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(52, 35).addBox(-4.0F, -3.0F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(34, 67).addBox(4.0F, 0.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(88, 98).addBox(4.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(58, 17).addBox(1.0F, -3.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 17).addBox(1.0F, -3.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 77).addBox(4.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition hair = partdefinition.addOrReplaceChild("hair", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition bangs = hair.addOrReplaceChild("bangs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bangs_left = bangs.addOrReplaceChild("bangs_left", CubeListBuilder.create().texOffs(0, 90).addBox(-1.0F, -3.0F, -7.0F, 2.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(98, 46).addBox(-1.0F, 5.0F, -7.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bangs_right = bangs.addOrReplaceChild("bangs_right", CubeListBuilder.create().texOffs(94, 0).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(98, 53).addBox(-1.0F, 5.0F, 1.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition top_hair = hair.addOrReplaceChild("top_hair", CubeListBuilder.create().texOffs(0, 19).addBox(-6.0F, -13.0F, -7.0F, 12.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -3.0F, 0.0F));

		PartDefinition bottom_hair = hair.addOrReplaceChild("bottom_hair", CubeListBuilder.create(), PartPose.offset(-6.0F, 7.0F, 0.0F));

		PartDefinition side_hair_corner_right_r1 = bottom_hair.addOrReplaceChild("side_hair_corner_right_r1", CubeListBuilder.create().texOffs(78, 102).addBox(-1.356F, -2.17F, -0.566F, 1.956F, 10.2F, 1.956F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 6.0F, 0.1745F, 0.0F, 0.1745F));

		PartDefinition side_hair_corner_left_r1 = bottom_hair.addOrReplaceChild("side_hair_corner_left_r1", CubeListBuilder.create().texOffs(70, 102).addBox(-1.356F, -2.17F, -1.39F, 1.956F, 10.2F, 1.956F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, -6.0F, -0.1745F, 0.0F, 0.1745F));

		PartDefinition back_hair_r1 = bottom_hair.addOrReplaceChild("back_hair_r1", CubeListBuilder.create().texOffs(48, 61).addBox(-1.35F, -3.0F, -6.99F, 2.0F, 11.0F, 13.98F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition side_hair_left = bottom_hair.addOrReplaceChild("side_hair_left", CubeListBuilder.create().texOffs(18, 98).addBox(-3.0F, -1.9F, -13.5F, 7.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 104).addBox(4.0F, 1.1F, -13.5F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -9.0F, 6.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition side_twirl = side_hair_left.addOrReplaceChild("side_twirl", CubeListBuilder.create().texOffs(74, 35).addBox(-3.0F, 3.1F, -2.5F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 98).addBox(-3.0F, 5.1F, -3.5F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 90).addBox(-3.0F, 6.1F, -4.5F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -13.0F));

		PartDefinition side_twirl2 = side_twirl.addOrReplaceChild("side_twirl2", CubeListBuilder.create().texOffs(106, 60).addBox(-3.25F, 3.577F, -2.5F, 0.8F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 110).addBox(-3.25F, 5.577F, -3.5F, 0.8F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 110).addBox(-3.25F, 6.577F, -4.5F, 0.8F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1763F));

		PartDefinition side_twirl3 = side_twirl.addOrReplaceChild("side_twirl3", CubeListBuilder.create().texOffs(6, 105).addBox(-3.25F, 3.31F, -2.5F, 0.8F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(94, 39).addBox(-3.25F, 5.31F, -3.5F, 0.8F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(104, 83).addBox(-3.25F, 6.31F, -4.5F, 0.8F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.082F));

		PartDefinition side_twirl4 = side_twirl.addOrReplaceChild("side_twirl4", CubeListBuilder.create().texOffs(86, 105).addBox(-3.25F, 3.282F, -2.5F, 0.8F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 109).addBox(-3.25F, 5.282F, -3.5F, 0.8F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 110).addBox(-3.25F, 6.282F, -4.5F, 0.8F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0661F));

		PartDefinition side_hair_right = bottom_hair.addOrReplaceChild("side_hair_right", CubeListBuilder.create().texOffs(36, 98).addBox(-3.0F, -1.9F, 11.5F, 7.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(104, 74).addBox(4.0F, 1.1F, 11.5F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -9.0F, -6.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition side_twirl5 = side_hair_right.addOrReplaceChild("side_twirl5", CubeListBuilder.create().texOffs(98, 39).addBox(-3.0F, 3.1F, 0.5F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 86).addBox(-3.0F, 5.1F, 2.5F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 93).addBox(-3.0F, 6.1F, 3.5F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 13.0F));

		PartDefinition side_twirl6 = side_twirl5.addOrReplaceChild("side_twirl6", CubeListBuilder.create().texOffs(106, 67).addBox(-3.25F, 3.577F, 0.5F, 0.8F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 110).addBox(-3.25F, 5.577F, 2.5F, 0.8F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(110, 74).addBox(-3.25F, 6.577F, 3.5F, 0.8F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1763F));

		PartDefinition side_twirl7 = side_twirl5.addOrReplaceChild("side_twirl7", CubeListBuilder.create().texOffs(12, 105).addBox(-3.25F, 3.31F, 0.5F, 0.8F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 105).addBox(-3.25F, 5.31F, 2.5F, 0.8F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(108, 83).addBox(-3.25F, 6.31F, 3.5F, 0.8F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.082F));

		PartDefinition side_twirl8 = side_twirl5.addOrReplaceChild("side_twirl8", CubeListBuilder.create().texOffs(92, 105).addBox(-3.25F, 3.282F, 0.5F, 0.8F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 110).addBox(-3.25F, 5.282F, 2.5F, 0.8F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 110).addBox(-3.25F, 6.282F, 3.5F, 0.8F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0661F));

		PartDefinition headtie = hair.addOrReplaceChild("headtie", CubeListBuilder.create().texOffs(0, 105).addBox(0.0F, -21.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 74).addBox(0.0F, -18.0F, -3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 77).addBox(0.0F, -22.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 81).addBox(0.0F, -22.0F, 4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 74).addBox(0.0F, -18.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 90).addBox(0.0F, -23.0F, 1.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(54, 104).addBox(0.0F, -23.0F, -4.0F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(58, 0).addBox(0.0F, 6.0F, -12.0F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -7.0F, 7.0F));

		PartDefinition bottom_clothing = body.addOrReplaceChild("bottom_clothing", CubeListBuilder.create().texOffs(52, 19).addBox(-5.0F, -3.0F, -6.0F, 10.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(48, 43).addBox(-6.0F, 1.0F, -7.0F, 11.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-7.0F, 5.0F, -8.0F, 13.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 16.0F, -7.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, -7.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition wrist_right_r1 = right_arm.addOrReplaceChild("wrist_right_r1", CubeListBuilder.create().texOffs(26, 86).addBox(-5.0F, -4.0F, 0.0F, 9.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition bottom_arm_right_r1 = right_arm.addOrReplaceChild("bottom_arm_right_r1", CubeListBuilder.create().texOffs(0, 77).addBox(-4.0F, -3.0F, 0.0F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition upper_arm_right_r1 = right_arm.addOrReplaceChild("upper_arm_right_r1", CubeListBuilder.create().texOffs(80, 74).addBox(-3.0F, -2.0F, -2.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 7.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition wrist_left_right_r1 = left_arm.addOrReplaceChild("wrist_left_right_r1", CubeListBuilder.create().texOffs(74, 86).addBox(-5.0F, -4.0F, -3.0F, 9.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition bottom_left_arm_right_r1 = left_arm.addOrReplaceChild("bottom_left_arm_right_r1", CubeListBuilder.create().texOffs(80, 61).addBox(-4.0F, -3.0F, -6.0F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition upper_left_arm_right_r1 = left_arm.addOrReplaceChild("upper_left_arm_right_r1", CubeListBuilder.create().texOffs(50, 86).addBox(-3.0F, -2.0F, -5.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(96, 15).addBox(-2.0F, -1.0F, -4.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(102, 96).addBox(3.0F, 4.0F, -4.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 18.0F, -2.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(96, 27).addBox(-2.0F, -1.0F, -4.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(102, 103).addBox(3.0F, 4.0F, -4.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 18.0F, 5.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 110).addBox(7.0F, -33.0F, -7.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 110).addBox(7.0F, -33.0F, 4.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

//	@Override
//	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		hair.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
//	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}