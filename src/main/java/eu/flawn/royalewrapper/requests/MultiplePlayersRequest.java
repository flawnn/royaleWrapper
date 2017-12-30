package eu.flawn.royalewrapper.requests;

import com.jsoniter.JsonIterator;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import eu.flawn.royalewrapper.models.Model;
import eu.flawn.royalewrapper.models.MultiplePlayerModel;
import eu.flawn.royalewrapper.models.PlayerModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Flawn
 */
public class MultiplePlayersRequest extends Request {

  String[] playerIDs;
  String authkey;

  /**
   *
   * @param ids IDs of Player, whose Stats should be requested
   */
  public MultiplePlayersRequest(String key, String... ids){
    this.authkey = key;
    this.playerIDs = ids;
  }

  @Override
  public Model makeGET() {
    List<PlayerModel> players = new ArrayList<PlayerModel>();
    MultiplePlayerModel mpm = new MultiplePlayerModel();
    try {
      for(String playerID: playerIDs){
        PlayerModel pm;
        HttpResponse<String> payload = Unirest
            .get("http://api.cr-api.com/player/" + playerID).header("auth", authkey).asString();
        JsonIterator iter = JsonIterator.parse(payload.getBody());
        pm = iter.read(PlayerModel.class);
        pm.res = iter.toString();
        players.add(pm);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (UnirestException e) {
      e.printStackTrace();
    }
    mpm.setPlayers(players);
    return mpm;
  }

}
