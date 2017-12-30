package eu.flawn.royalewrapper.models;

import java.util.List;

/**
 * @author Flawn
 */
public class MultiplePlayerModel extends Model {

  public List<PlayerModel> getPlayers() {
    return players;
  }

  public void setPlayers(List<PlayerModel> players) {
    this.players = players;
  }

  private List<PlayerModel> players;
}
