package eu.flawn.royalewrapper.requests;

import com.jsoniter.JsonIterator;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import eu.flawn.royalewrapper.models.ClanModel;
import eu.flawn.royalewrapper.models.Model;
import java.io.IOException;

/**
 * @author Flawn
 */
public class ClanRequest extends Request {

  String clanID;
  String authkey;

  /**
   *
   * @param id ID of Clan, whose Infos should be requested
   */
  public ClanRequest(String key, String id){
    this.clanID = id;
    this.authkey = key;
  }

  @Override
  public Model makeGET() {
    ClanModel clan = null;
    try {
      HttpResponse<String> payload = Unirest
          .get("http://api.cr-api.com/clan/" + clanID).header("auth", authkey).asString();
      JsonIterator iter = JsonIterator.parse(payload.getBody());
      clan = iter.read(ClanModel.class);
      clan.res = iter.toString();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (UnirestException e) {
      e.printStackTrace();
    }
    return clan;
  }

}
