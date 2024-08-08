package dev.aucorg.armourstandmodeler.eventlistener;

import dev.aucorg.armourstandmodeler.ArmourStandInteractionMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.DragType;
import org.bukkit.event.inventory.InventoryDragEvent;

import java.util.Arrays;


public class InventoryDragEventListener implements Listener {
    private static final int[] UNLOCKED_SLOTS = new int[] {1, 10, 19, 28, 37, 39};

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        Player player = (Player) event.getWhoClicked();


        if (ArmourStandInteractionMap.isPlayerInteracting(player)) {
            int inventorySize = event.getInventory().getSize();
            // check if any of the dragged slots are in the gui inventory
            if (event.getRawSlots().stream().anyMatch(i -> i < inventorySize)) {
                if (event.getRawSlots().size() > 1) {
                    event.setCancelled(true);
                } else {
                    // if the drag click only effected one slot it gets cancelled
                    // only if the slot is not one of the unlocked slots in the gui
                    if (Arrays.stream(UNLOCKED_SLOTS).noneMatch(i -> event.getRawSlots().contains(i))) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
