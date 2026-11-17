package com.ethosclan;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(EthosConfig.GROUP)
public interface EthosConfig extends Config
{
	String GROUP = "ethosclan";

	@ConfigItem(
		keyName = "showWelcome",
		name = "Welcome message",
		description = "Show an Ethos welcome message in the chatbox when you log in"
	)
	default boolean showWelcome()
	{
		return true;
	}
}
