package net.aufdemrand.denizen.tags.core;

import net.aufdemrand.denizen.Denizen;
import net.aufdemrand.denizen.events.ReplaceableTagEvent;
import net.aufdemrand.denizen.objects.Element;
import net.aufdemrand.denizen.tags.Attribute;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TextTags implements Listener {

    public TextTags(Denizen denizen) {
        denizen.getServer().getPluginManager().registerEvents(this, denizen);
    }

    @EventHandler
    public void foreignCharacterTags(ReplaceableTagEvent event) {

        if (!event.getName().startsWith("&")) return;
        Attribute attribute =
                new Attribute(event.raw_tag, event.getScriptEntry());

        // <--[tag]
        // @attribute <&auml>
        // @returns Element
        // @description
        // Returns an umlaut-a symbol: ä
        // -->
        if (event.getName().equals("&auml"))
            event.setReplaced(new Element("ä").getAttribute(attribute.fulfill(1)));

            // <--[tag]
            // @attribute <&Auml>
            // @returns Element
            // @description
            // Returns a capital umlaut-A symbol: Ä
            // -->
        else if (event.getName().equals("&Auml"))
            event.setReplaced(new Element("Ä").getAttribute(attribute.fulfill(1)));

            // <--[tag]
            // @attribute <&ouml>
            // @returns Element
            // @description
            // Returns an umlaut-o symbol: ö
            // -->
        else if (event.getName().equals("&ouml"))
            event.setReplaced(new Element("ö").getAttribute(attribute.fulfill(1)));

            // <--[tag]
            // @attribute <&Iuml>
            // @returns Element
            // @description
            // Returns a capital umlaut-O symbol: Ö
            // -->
        else if (event.getName().equals("&Ouml"))
            event.setReplaced(new Element("Ö").getAttribute(attribute.fulfill(1)));

            // <--[tag]
            // @attribute <&uuml>
            // @returns Element
            // @description
            // Returns an umlaut-u symbol: ü
            // -->
        else if (event.getName().equals("&uuml"))
            event.setReplaced(new Element("ü").getAttribute(attribute.fulfill(1)));

            // <--[tag]
            // @attribute <&Uuml>
            // @returns Element
            // @description
            // Returns a capital umlaut-U symbol: Ü
            // -->
        else if (event.getName().equals("&Uuml"))
            event.setReplaced(new Element("Ü").getAttribute(attribute.fulfill(1)));

    }

    // Thanks geckon :)
    final String[] code = {"0","1","2","3","4","5","6","7","8","9"
            ,"a","b","c","d","e","f","k","l","m","n","o","r"};

    // <--[tag]
    // @attribute <&0>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Black.
    // -->

    // <--[tag]
    // @attribute <&1>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Blue.
    // -->

    // <--[tag]
    // @attribute <&2>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Green.
    // -->

    // <--[tag]
    // @attribute <&3>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Cyan.
    // -->

    // <--[tag]
    // @attribute <&4>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Red.
    // -->

    // <--[tag]
    // @attribute <&5>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Magenta.
    // -->

    // <--[tag]
    // @attribute <&6>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Gold.
    // -->

    // <--[tag]
    // @attribute <&7>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Light Gray.
    // -->

    // <--[tag]
    // @attribute <&8>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Gray.
    // -->

    // <--[tag]
    // @attribute <&9>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Light Blue.
    // -->

    // <--[tag]
    // @attribute <&a>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Light Green.
    // -->

    // <--[tag]
    // @attribute <&b>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Cyan.
    // -->

    // <--[tag]
    // @attribute <&c>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Light Red.
    // -->

    // <--[tag]
    // @attribute <&d>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Magenta.
    // -->

    // <--[tag]
    // @attribute <&e>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Yellow.
    // -->

    // <--[tag]
    // @attribute <&f>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters White.
    // -->

    // <--[tag]
    // @attribute <&k>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters obfuscated.
    // -->

    // <--[tag]
    // @attribute <&l>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters bold.
    // -->

    // <--[tag]
    // @attribute <&m>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters have a strike-through.
    // -->

    // <--[tag]
    // @attribute <&n>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters have an underline.
    // -->

    // <--[tag]
    // @attribute <&o>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters italicized.
    // -->

    // <--[tag]
    // @attribute <&r>
    // @returns Element
    // @description
    // Returns the ChatColor that resets the following characters to normal.
    // -->

    // <--[tag]
    // @attribute <black>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Black.
    // -->

    // <--[tag]
    // @attribute <dark_red>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Blue.
    // -->

    // <--[tag]
    // @attribute <dark_green>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Green.
    // -->

    // <--[tag]
    // @attribute <dark_aqua>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Cyan.
    // -->

    // <--[tag]
    // @attribute <dark_red>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Red.
    // -->

    // <--[tag]
    // @attribute <dark_purple>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Magenta.
    // -->

    // <--[tag]
    // @attribute <gold>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Gold.
    // -->

    // <--[tag]
    // @attribute <gray>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Light Gray.
    // -->

    // <--[tag]
    // @attribute <dark_gray>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Dark Gray.
    // -->

    // <--[tag]
    // @attribute <blue>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Light Blue.
    // -->

    // <--[tag]
    // @attribute <green>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Light Green.
    // -->

    // <--[tag]
    // @attribute <aqua>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Cyan.
    // -->

    // <--[tag]
    // @attribute <red>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Light Red.
    // -->

    // <--[tag]
    // @attribute <light_purple>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Magenta.
    // -->

    // <--[tag]
    // @attribute <yellow>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters Yellow.
    // -->

    // <--[tag]
    // @attribute <white>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters White.
    // -->

    // <--[tag]
    // @attribute <magic>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters obfuscated.
    // -->

    // <--[tag]
    // @attribute <bold>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters bold.
    // -->

    // <--[tag]
    // @attribute <strikethrough>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters have a strike-through.
    // -->

    // <--[tag]
    // @attribute <underline>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters have an underline.
    // -->

    // <--[tag]
    // @attribute <italic>
    // @returns Element
    // @description
    // Returns the ChatColor that makes the following characters italicized.
    // -->

    // <--[tag]
    // @attribute <reset>
    // @returns Element
    // @description
    // Returns the ChatColor that resets the following characters to normal.
    // -->

    @EventHandler
    public void colorTags(ReplaceableTagEvent event) {
        Attribute attribute =
                new Attribute(event.raw_tag, event.getScriptEntry());
        int i = 0;
        for (ChatColor color : ChatColor.values()) {
            if (i > 22) break;
            if (event.matches(color.name()))
                event.setReplaced(new Element(color.toString()).getAttribute(attribute.fulfill(1)));
            else if (event.matches("&" + code[i]))
                event.setReplaced(new Element(ChatColor.getByChar(code[i]).toString()).getAttribute(attribute.fulfill(1)));
            i++;
        }
    }

}
