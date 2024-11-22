// package com.twentyforseven;

// import java.util.logging.Logger;

// import com.twentyforseven.model.commands.LoadMapCommand;
// import com.twentyforseven.model.commands.SaveMapCommand;
// import com.twentyforseven.model.factory.ITileFactory;
// import com.twentyforseven.model.factory.TileFactoryImpl;
// import com.twentyforseven.model.interfaces.IBoardManager;
// import com.twentyforseven.model.services.BoardManager;
// import com.twentyforseven.util.LoggerConfig;

// public class Main {
// private static final Logger logger = Logger.getLogger(Main.class.getName());

// public static void main(String[] args) {
// LoggerConfig.configureLogger();
// logger.info("Starting application");

// ITileFactory tileFactory = new TileFactoryImpl();
// IBoardManager boardManager = new BoardManager();

// // Create a new map
// boardManager.createMap(6, 12, tileFactory);
// boardManager.printBoard();

// // Save the map
// SaveMapCommand saveCommand = new SaveMapCommand(boardManager, "map.dat");
// saveCommand.execute();
// logger.info("Map saved");

// // Load the map
// LoadMapCommand loadCommand = new LoadMapCommand(boardManager, "map.dat");
// loadCommand.execute();
// boardManager.printBoard();
// logger.info("Map loaded");
// }
// }