package net.aufdemrand.denizen.scripts.commands.world;

import java.util.Arrays;

import net.aufdemrand.denizen.exceptions.CommandExecutionException;
import net.aufdemrand.denizen.exceptions.InvalidArgumentsException;
import net.aufdemrand.denizen.objects.Element;
import net.aufdemrand.denizen.objects.aH;
import net.aufdemrand.denizen.objects.dEntity;
import net.aufdemrand.denizen.objects.dLocation;
import net.aufdemrand.denizen.scripts.ScriptEntry;
import net.aufdemrand.denizen.scripts.commands.AbstractCommand;
import net.aufdemrand.denizen.utilities.debugging.dB;
import net.citizensnpcs.npc.ai.BlockBreaker;

/**
 * Breaks a block using Citizens' BlockBreaker
 *
 * @author Jeremy Schroeder
 */

public class BreakCommand extends AbstractCommand {

    @Override
    public void parseArgs(ScriptEntry scriptEntry) throws InvalidArgumentsException {

        for (aH.Argument arg : aH.interpret(scriptEntry.getArguments())) {

            if (!scriptEntry.hasObject("location")
                    && arg.matchesArgumentType(dLocation.class))
                scriptEntry.addObject("location", arg.asType(dLocation.class));

            else if (!scriptEntry.hasObject("entity")
                    && arg.matchesArgumentType(dEntity.class))
                scriptEntry.addObject("entity", arg.asType(dEntity.class));

            else if (!scriptEntry.hasObject("radius")
                    && arg.matchesPrimitive(aH.PrimitiveType.Double))
                scriptEntry.addObject("radius", arg.asElement());

            else
                arg.reportUnhandled();
        }

        // Make sure location and entity were fulfilled
        if (!scriptEntry.hasObject("location"))
            throw new InvalidArgumentsException("Must specify a location!");

        // Use the NPC or the Player as the default entity
        scriptEntry.defaultObject("entities",
                (scriptEntry.hasPlayer() ? Arrays.asList(scriptEntry.getPlayer().getDenizenEntity()) : null),
                (scriptEntry.hasNPC() ? Arrays.asList(scriptEntry.getNPC().getDenizenEntity()) : null));

        scriptEntry.defaultObject("radius", new Element(1));

    }

    @Override
    public void execute(ScriptEntry scriptEntry) throws CommandExecutionException {

        final dLocation location = (dLocation) scriptEntry.getObject("location");
        final dEntity entity = (dEntity) scriptEntry.getObject("entity");
        Element radius = scriptEntry.getElement("radius");

        dB.report(scriptEntry, getName(), location.debug() + entity.debug() + radius.debug());

        final ScriptEntry se = scriptEntry;
        BlockBreaker.Configuration config = new BlockBreaker.Configuration()
                .item(entity.getLivingEntity().getEquipment().getItemInHand())
                .radius(radius.asDouble())
                .callback(new Runnable() {
                    @Override
                    public void run() {
                        dB.echoDebug(se, entity.debug() + " dug " + location.debug());
                    }
                });

        BlockBreaker breaker = BlockBreaker.createWithConfiguration(entity.getLivingEntity(), location.getBlock(), config);
        breaker.run();
    }

}
