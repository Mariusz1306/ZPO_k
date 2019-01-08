public class Main {
    public static void main(String args[]){
        Knight start = new Knight(2,1); //startowa pozycja konia
        Knight end = new Knight(2,2); //końcowa pozycja konia
        Square board = new Square(8,8); //kolumny są od 1 do x, rzędy od 1 do y
        System.out.println(board.path(start,end));
    }
}
