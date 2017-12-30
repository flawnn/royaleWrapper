package eu.flawn.royalewrapper.requests;

import com.jsoniter.JsonIterator;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import eu.flawn.royalewrapper.models.Model;
import eu.flawn.royalewrapper.models.PlayerModel;
import java.io.IOException;

/**
 * Creation of Flawn
 */
public class PlayerRequest extends Request {

  String playerID;
  String authkey;

  /**
   *
   * @param id ID of Player, whose Stats should be requested
   */
  public PlayerRequest(String key, String id){
    this.playerID = id;
    this.authkey = key;
  }

  @Override
  public Model makeGET() {
    PlayerModel player = null;
    try {
      HttpResponse<String> payload = Unirest.get("http://api.cr-api.com/player/" + playerID).header("auth", authkey).asString();
      JsonIterator iter = JsonIterator.parse(payload.getBody());
      player = iter.read(PlayerModel.class);
      player.res = iter.toString();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (UnirestException e) {
      e.printStackTrace();
    }
    return player;
  }
}
