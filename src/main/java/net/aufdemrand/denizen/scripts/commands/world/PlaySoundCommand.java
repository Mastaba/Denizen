package net.aufdemrand.denizen.scripts.commands.world;

import org.bukkit.Sound;

import net.aufdemrand.denizen.exceptions.CommandExecutionException;
import net.aufdemrand.denizen.exceptions.InvalidArgumentsException;
import net.aufdemrand.denizen.scripts.ScriptEntry;
import net.aufdemrand.denizen.scripts.commands.AbstractCommand;
import net.aufdemrand.denizen.objects.Element;
import net.aufdemrand.denizen.objects.aH;
import net.aufdemrand.denizen.objects.dLocation;
import net.aufdemrand.denizen.utilities.debugging.dB;

/* PLAYSOUND [LOCATION:x,y,z,world] [SOUND:NAME] (VOLUME:#) (PITCH:#)*/

/*
 * Arguments: [] - Required, () - Optional
 * [LOCATION:x,y,z,world] specifies location of the sound
 * [SOUND:NAME] name of sound to be played
 * (VOLUME:#) adjusts the volume of the sound
 * (PITCH:#) adjusts the pitch of the sound
 *
 * Example Usage:
 * PLAYSOUND LOCATION:123,65,765,world SOUND:SPLASH VOLUME:1 PITCH:2
 * PLAYSOUND LOCATION:123,65,765,world S:SPLASH V:2 P:1
 *
 */

public class PlaySoundCommand extends AbstractCommand {

    @Override
    public void parseArgs(ScriptEntry scriptEntry) throws InvalidArgumentsException {

        // Iterate through arguments
        for (aH.Argument arg : aH.interpret(scriptEntry.getArguments())) {

            if (!scriptEntry.hasObject("location")
                    && arg.matchesArgumentType(dLocation.class))
                scriptEntry.addObject("location", arg.asType(dLocation.class));

            else if (!scriptEntry.hasObject("volume")
                    && arg.matchesPrimitive(aH.PrimitiveType.Double)
                    && arg.matchesPrefix("volume, v"))
                scriptEntry.addObject("volume", arg.asElement());

            else if (!scriptEntry.hasObject("pitch")
                    && arg.matchesPrimitive(aH.PrimitiveType.Double)
                    && arg.matchesPrefix("pitch, p"))
                scriptEntry.addObject("pitch", arg.asElement());

            else if (!scriptEntry.hasObject("sound")
                    && arg.matchesPrimitive(aH.PrimitiveType.String)) {
                    scriptEntry.addObject("sound", arg.asElement());
            }

            else
                arg.reportUnhandled();

        }

        if (!scriptEntry.hasObject("sound"))
            throw new InvalidArgumentsException("Missing sound argument!");
        if (!scriptEntry.hasObject("location"))
            throw new InvalidArgumentsException("Missing location argument!");

        scriptEntry.defaultObject("volume", new Element(1));
        scriptEntry.defaultObject("pitch", new Element(1));

    }

    @Override
    public void execute(ScriptEntry scriptEntry) throws CommandExecutionException {

        dLocation location = (dLocation) scriptEntry.getObject("location");
        Element sound = scriptEntry.getElement("sound");
        Element volume = scriptEntry.getElement("volume");
        Element pitch = scriptEntry.getElement("pitch");

        dB.report(scriptEntry, getName(),
                location.debug() +
                sound.debug() +
                volume.debug() +
                pitch.debug());

        try {
            location.getWorld().playSound(location, Sound.valueOf(sound.asString().toUpperCase()), volume.asFloat(), pitch.asFloat());
        } catch (Exception e) {
            dB.echoError("Invalid sound!");
        }
    }

}
