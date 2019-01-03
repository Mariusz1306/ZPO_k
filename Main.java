public class Main {
    public static void main(String args[]){
        Knight start = new Knight(2,1);
        Knight end = new Knight(2,2);
        Square board = new Square(8,8); //columns are from 1 to x, rows from 1 to y
        System.out.println(board.path(start,end));
    }
}
