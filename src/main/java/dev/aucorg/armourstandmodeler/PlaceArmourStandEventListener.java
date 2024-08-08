package dev.aucorg.armourstandmodeler;


import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityPlaceEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.EulerAngle;

public class PlaceArmourStandEventListener implements Listener {
    @EventHandler
    public void onPlaceArmourStand(EntityPlaceEvent event) {
        if (!event.getEntityType().equals(EntityType.ARMOR_STAND)) {
            return;
        }

        ArmorStand armourStand = (ArmorStand) event.getEntity();

        armourStand.setArms(true);
        EulerAngle zeroAngle = new EulerAngle(0, 0, 0);
        armourStand.setHeadPose(zeroAngle);
        armourStand.setBodyPose(zeroAngle);
        armourStand.setLeftArmPose(zeroAngle);
        armourStand.setRightArmPose(zeroAngle);
        armourStand.setLeftLegPose(zeroAngle);
        armourStand.setRightLegPose(zeroAngle);
    }
}

