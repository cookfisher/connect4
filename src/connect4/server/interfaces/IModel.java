package connect4.server.interfaces;

import connect4.client.interfaces.GameListener;
import connect4.server.enums.GameResult;
import connect4.server.objects.User;

// used by server
public interface IModel 
{
	public boolean connectToDatabase();
	public void fallBackOnMock();
	public User[] getScoreTableFromDatabase();
	public void updatePlayersScoresInDatabase(String username, GameResult result);
	
	public String validateUsername(String username);
	public void addClient(String player, GameListener client);
	void removeClient(String player);
	
	public void initializeClientBoard(GameListener client, String name);
	
	void updateClientsCurrentPlayer();
	void updateClientsBoardCase(int column, int row, String player);
	void notifyOfEndOfTheGame(GameResult result, String player);
	
	boolean makeMove(int column, int row, String player);
	
	void makeNextPlayerCurrent();
	void setCurrentPlayer(String player);
	boolean isPlaying(String player);
	
	String getCurrentPlayer();
	int getColumnLowestFreeRow(int column);
	
	boolean floorFull();
	boolean playerAvailable();
	boolean positionAvailable(int column, int row);
	boolean positionMakeWinning(int column, int row);
}