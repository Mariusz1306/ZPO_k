import java.util.Random;

public class Square {
    private final int x; //kolumny
    private final int y; //wiersze
    //rozmiary planszy

    public Square(int x, int y) {
        this.x = x-1;
        this.y = y-1;
    }

    public String path(Knight startKnight, Knight endKnight){
        Knight currentPosition = startKnight;
        String result = "(" + currentPosition.getX() + ", " + currentPosition.getY() + ")"; //w result zapisujemy napis, który mamy zwrócić
        while (currentPosition.getX() != endKnight.getX() || currentPosition.getY() != endKnight.getY()){ //jeśli nie doszliśmy do końcowej pozycji
            Knight tempPosition = new Knight(currentPosition.getX(), currentPosition.getY()); //tworzymy tymczasową pozycję, jeśli wyjdzie poza planszę, to ją pominiemy
            tempPosition = moveKnight(tempPosition);
            if (tempPosition != null) { //jeśli będzie null, to wyszliśmy poza planszę
                currentPosition = tempPosition; //skoro nie wyszliśmy poza planszę, to zapisujemy
                result = result + " -> " + "(" + currentPosition.getX() + ", " + currentPosition.getY() + ")"; //aktualizacja result
            }
        }
        return result;
    }

    public Knight moveKnight(Knight currentPosition){ //metoda porusza koniem w losowym kierunku
        Knight newPosition = currentPosition;

        Random rand = new Random();
        boolean longColumn = rand.nextBoolean(); //jeśli longColumn == true: poruszamy się o dwie kolumny i jeden wiersz, jeśli false, to 1 kolumna i 2 wiersze
        if (longColumn){
            boolean positive = rand.nextBoolean(); //sprawdzamy czy x się zwiększy o 2, czy zmniejszy o 2
            if (positive)
                newPosition.setX(newPosition.getX()+2);
            else
                newPosition.setX(newPosition.getX()-2);
            positive = rand.nextBoolean(); //sprawdzamy czy y się zwiekszy o 1, czy zmniejszy o 1
            if (positive)
                newPosition.setY(newPosition.getY()+1);
            else
                newPosition.setY(newPosition.getY()-1);
        } else {
            boolean positive = rand.nextBoolean(); //sprawdzamy czy x się zwiększy o 1, czy zmniejszy o 1
            if (positive)
                newPosition.setX(newPosition.getX()+1);
            else
                newPosition.setX(newPosition.getX()-1);
            positive = rand.nextBoolean(); //sprawdzamy czy y się zwiekszy o 2, czy zmniejszy o 2
            if (positive)
                newPosition.setY(newPosition.getY()+2);
            else
                newPosition.setY(newPosition.getY()-2);
        }
        if (newPosition.getX() > this.x || newPosition.getY() > this.y || newPosition.getX() < 0 || newPosition.getY() < 0) //jeśli true, to wyszliśmy poza plansze
            return null;
        else
            return newPosition;
    }
}
