import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SudokuCreator sc = new SudokuCreator();
        SudokuSolver ss = new SudokuSolver();
        System.out.println("Sudoku Programımıza Hoşgeldiniz ");
        String işlemler = "C) Sudoku Oluştur \n" +
                "S) Sudokoyu Çöz \n" +
                "Q) Çıkış(Q)";

        System.out.println("*******************");

        System.out.println("İşlemler : \n" + işlemler);


        while(true){
            Scanner scanner = new Scanner(System.in);
            String işlem = scanner.nextLine();
            işlem = işlem.toUpperCase();

            if(işlem.equals("Q")){
                System.out.println("Sistemden Çıkılıyor !");
                break;
            }
            else if(işlem.equals("C")){
                SudokuCreator.bastir();
                System.out.println("Sudokunuz Başarıyla Oluşturuldu");
            }
            else if(işlem.equals("S")){
                if(ss.solve()){
                    ss.display();
                    System.out.println("Sudoku Başarıyla Çözüldü . Sistemden Otomatik Çıkılıyor ");
                    break;

                }
                else{
                    System.out.println("Çözülemeyen Sudoku !!! Sistemden Otomatik Çıkılıyor.");
                    break;
                }
            }
            else{
                System.out.println("Başarısız İşlem. Lütfen Tekrar Deneyiniz !");
            }
        }

    }
}
