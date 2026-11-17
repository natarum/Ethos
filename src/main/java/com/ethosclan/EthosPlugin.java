package com.ethosclan;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Ethos Clan",
	description = "Clan tools for Ethos: drop logging, clan events and more",
	tags = {"clan", "ethos", "discord", "wise old man", "bingo"}
)
public class EthosPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private EthosConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Ethos Clan started");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("Ethos Clan stopped");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN && config.showWelcome())
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Ethos Clan plugin is running.", null);
		}
	}

	@Provides
	EthosConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(EthosConfig.class);
	}
}
