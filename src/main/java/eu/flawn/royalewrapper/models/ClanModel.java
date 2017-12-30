package eu.flawn.royalewrapper.models;

import com.jsoniter.any.Any;

/**
 * @author Flawn
 */
public class ClanModel extends Model {
    public String tag;
    public String name;
    public String description;
    public String type;
    public int score;
    public int memberCount;
    public int requiredScore;
    public int donations;
    public Any clanChest;
    public Any badge;
    public Any location;
    public Any members;
}
