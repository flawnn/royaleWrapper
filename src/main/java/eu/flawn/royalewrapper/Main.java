package eu.flawn.royalewrapper;

import eu.flawn.royalewrapper.models.ClanModel;
import eu.flawn.royalewrapper.requests.ClanRequest;

/**
 * @author Flawn
 */
public class Main {
    public static void main(String[] args){
      API api = new API("88f805feb4b24ef19a0a3a6bfe476b2dffe4ee50bb9f4029b41ee17255fa4425");
     ClanModel pm = (ClanModel) api.makeRequest(ClanRequest.class, "2CCCP");
      System.out.println(pm.members.asList().get(0).get("name"));

    }
}
