package data;

public class Actor {

    //TODO actor is currently a completely pointless wrapper class for the position class - eg. it adds no functionality!
    protected Position position;

    public Actor(Position position) {
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }
}
