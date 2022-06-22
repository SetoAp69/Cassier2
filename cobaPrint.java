import java.util.Scanner;
public class cobaPrint {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String []args){
        int id, harga ,jumlah, total;
        String Nama ;
        System.out.println("Masukan id") ;
        id = scan.nextInt();

        System.out.println("Isi Nama");
        Nama = scan.next();

        System.out.println("Harga");
        harga = scan.nextInt();

        System.out.println("Jumlah");
        jumlah = scan.nextInt();

        System.out.println("Harga Total "  );
        total = jumlah*harga;
        System.out.println(total);
        System.out.println();
        System.out.println(printString(id, Nama, harga, jumlah, total));
        System.out.println(printString(2, "KitKatvmakiu", 5000, 2, 10000));




    }
    public static String printString(int id,String nama, int harga, int jumlah, int total) {
        String format ="%1$-3d|%2$-10s|%3$-5d|%3$-3s|%3$-6s\n";
        return String.format(format,id,nama,harga,jumlah,total );

    }
}
