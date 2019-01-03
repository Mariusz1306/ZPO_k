import java.util.Random;

public class Square {
    private final int x; //column
    private final int y; //row

    public Square(int x, int y) {
        this.x = x-1;
        this.y = y-1;
    }

    public String path(Knight startKnight, Knight endKnight){
        Knight currentPosition = startKnight;
        String result = "(" + currentPosition.getX() + ", " + currentPosition.getY() + ")";
        while (currentPosition.getX() != endKnight.getX() || currentPosition.getY() != endKnight.getY()){
            Knight tempPosition = new Knight(currentPosition.getX(), currentPosition.getY());
            tempPosition = moveKnight(tempPosition);
            if (tempPosition != null) { //if tempPosition is null then we went off board
                currentPosition = tempPosition;
                result = result + " -> " + "(" + currentPosition.getX() + ", " + currentPosition.getY() + ")";
            }
        }
        return result;
    }

    public Knight moveKnight(Knight currentPosition){
        Knight newPosition = currentPosition;

        Random rand = new Random();
        boolean longColumn = rand.nextBoolean(); //if longColumn == true: move by two columns
        if (longColumn){
            boolean positive = rand.nextBoolean();
            if (positive)
                newPosition.setX(newPosition.getX()+2);
            else
                newPosition.setX(newPosition.getX()-2);
            positive = rand.nextBoolean();
            if (positive)
                newPosition.setY(newPosition.getY()+1);
            else
                newPosition.setY(newPosition.getY()-1);
        } else {
            boolean positive = rand.nextBoolean();
            if (positive)
                newPosition.setX(newPosition.getX()+1);
            else
                newPosition.setX(newPosition.getX()-1);
            positive = rand.nextBoolean();
            if (positive)
                newPosition.setY(newPosition.getY()+2);
            else
                newPosition.setY(newPosition.getY()-2);
        }
        if (newPosition.getX() > this.x || newPosition.getY() > this.y || newPosition.getX() < 0 || newPosition.getY() < 0) //are we on board?
            return null;
        else
            return newPosition;
    }
}
