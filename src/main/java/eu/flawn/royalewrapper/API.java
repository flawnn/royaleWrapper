package eu.flawn.royalewrapper;

import eu.flawn.royalewrapper.models.ClanModel;
import eu.flawn.royalewrapper.models.Model;
import eu.flawn.royalewrapper.models.MultiplePlayerModel;
import eu.flawn.royalewrapper.models.PlayerModel;
import eu.flawn.royalewrapper.requests.ClanRequest;
import eu.flawn.royalewrapper.requests.MultiplePlayersRequest;
import eu.flawn.royalewrapper.requests.PlayerRequest;
import eu.flawn.royalewrapper.requests.Request;

/**
 * Creation of Flawn
 */

public class API {

    // Key for auth
    private String apiKey;

    /**
     *  Generating API Instance
     * @param key Authkey for accessing API
     */
    public API(String key){
        this.apiKey = key;
    }

    /**
     *
     * @param c Class of Request, which should be executed
     * @return Model Model, that implements Response
     */
    public Model makeRequest(Class<? extends Request> c, String... params){
        Model m = null;
        if(c.isAssignableFrom(PlayerRequest.class)){
            PlayerRequest psr = new PlayerRequest(apiKey, params[0]);
            PlayerModel player = (PlayerModel) psr.makeGET();
            m = player;
        } else if(c.isAssignableFrom(MultiplePlayersRequest.class)) {
            MultiplePlayersRequest mpsr = new MultiplePlayersRequest(apiKey, params);
            MultiplePlayerModel players = (MultiplePlayerModel) mpsr.makeGET();
            m = players;
        } else if(c.isAssignableFrom(ClanRequest.class)){
            ClanRequest cr = new ClanRequest(apiKey, params[0]);
            ClanModel cm = (ClanModel) cr.makeGET();
            m = cm;
        }
        return m;
    }

}
