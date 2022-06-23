import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class kasirMain {
    public static Scanner input=new Scanner(System.in);

    public static String getNama(produk x){
        return x.nama;
    }//Mengambil produk.nama

    public static int getHarga(produk x){
        return x.harga;
    }//Mengambil produk.harga

    public static int getID(produk x){ return x.id;}//Mengambil produk.id

    public static void tambahKeStruk(linkedList llist,ArrayList<produk> struk,int id,int jumlah ){//Menambahkan setiap produk dibeli ke ArrayList (Belum dihitung duplikasi)
        for(int i=0;i<jumlah;i++){
            produk produkDiCari= llist.find(id);
            if(produkDiCari==null){
                break;
            }
            struk.add(produkDiCari);

        }
    }

    public static int totalHarga(ArrayList<ArrayList<Object>> arList, int arrLength){
        //Menghitung total harga dari seluruh produk yang sudah dihitung duplikasinya dalam Arraylist(Arraylist(Produk, jumlah))
        //int harTotal = 0;
        if(arrLength<=0){ //((mie, 2), (telur, 3), (kecap, 8))
            return 0;
        }
        return (totalHarga(arList,arrLength-1)+ ((Integer) arList.get(arrLength-1).get(1)*getHarga((produk) arList.get(arrLength-1).get(0))));
    }
    //(mie, mie,mie, telur, telur )
    //((mie,3),(telur,2))

    public static ArrayList<ArrayList<Object>> mapProduk(ArrayList<produk>list){
        //Menghitung Duplikasi produk menggunakan Map hashmap sehingga menghasilkan jumlah tiap produk
        Map<produk,Integer> mapedProduk=new HashMap<>(); //inisialisasi Map dengan key = produk, value = int jumlah
        ArrayList<ArrayList<Object>> listProdukDanJumlah=new ArrayList<>();//Tempat memasukan hasil  map menghasilkan ArrayList(ArraList(produk, jumlah))

        //Melakukan Loop untuk setiap i pada ArrayList<produk> list
        for(produk i:list){
            if(mapedProduk.containsKey(i)){
                //apabila map sudah terdapat item sama maka value akan ditambah 1
                mapedProduk.put(i, mapedProduk.get(i)+1);
            }
            else{
                // jika tidak langsung masukan value 1
                mapedProduk.put(i,1);
            }
        }

        for (produk m:mapedProduk.keySet()){
            //Memasukan value dan key map ke ArrayList(ArralyList(produk, jumlah))
            listProdukDanJumlah.add(new ArrayList<>(List.of(m,mapedProduk.get(m))));
        }
        return listProdukDanJumlah;

    }



    public static File buatFile(String namaFile){
        //Membuat File Txt untuk menyimpan Struk
        //inisialisasi File myObj yang membuat file pada direktori D:\Struk dengan format nama "namafile"+jumlahDuplikasiKe+".txt"
        File myObj=new File("D:\\Struk\\"+namaFile+"0"+".txt");
        int duplicate=1; //jumlah duplikasi


        while(myObj.exists()){//Jika  nama file sudah ada maka buat file  baru dengan tambahan angka duplikasi
            duplicate++;
            myObj=new File("D:\\Struk\\"+namaFile+duplicate+".txt");
        }

        if(myObj.exists()==false){//Membuat file baru
            try{
                myObj.createNewFile();
            }
            catch (IOException e){
            }
        }
        return myObj;

    }

    public static void Tulis(File struk, String produk, int Jumlah){
        //Menuliskan String yang sudah diformat sedemikian rupa ke fileStruk.txt
        try{
            FileWriter inputWriter=new FileWriter(struk); //inisialisasi FileWriter
            inputWriter.write(produk+"\n");//Menuliskan String produk yang sudah diformat
            inputWriter.write(("------------------------------------\n"));
            inputWriter.write(String.valueOf("Total Harga = "+Jumlah));//Menuliskan Jumlah harga pada akhir txt

            inputWriter.close();

        }
        catch (IOException e) {

        }

    }
    public static String formatStruk(int id,String nama, int harga, int jumlah, int total){
        //Memformat id, nama, harga, jumlah, dan total
        String format ="%1$-3d|%2$-15s|%3$-6d|%4$-6d|%5$-6d\n";
        return String.format(format,id,nama,harga,jumlah,total );
    }

    public static String arrToString(ArrayList<ArrayList<Object>> list){
        //memformat ArrayList(ArrList(produk, jumlah)) menjadi String
        String formatTable="%1$-3s|%2$-15s|%3$-6s|%4$-6s|%5$-6s\n"; //Format untuk Baris pertama Tabel
        String Struk=String.format(formatTable,"ID", "Nama","Harga","Jumlah","Total");
        for(int i=0;i< list.size();i++){
            //Melakukan loop untuk memformat tiap index

            int id=getID((produk) list.get(i).get(0)); //Mengambil id pada ArrayList(i(ArrayList(0))
            int harga=getHarga((produk) list.get(i).get(0));//Mengambil harga pada ArrayList(i(ArrayList(0))
            String nama=(getNama((produk) list.get(i).get(0)));//Mengambil nama pada ArrayList(i(ArrayList(0))
            int jumlah= (int) list.get(i).get(1);//Mengambil jumlah pada ArrayList(i(ArrayList(1))
            int jumHarga=harga*jumlah;
            Struk=Struk+formatStruk(id,nama,harga,jumlah,jumHarga);
        }
        return Struk;
    }




    public static void main(String[] args) {
        ArrayList<produk> strukBelanja=new ArrayList<>();
        //Buat Arraylist strukbelanja 2d dengan isi { {produk, jumlah}, {produk, jumlah}}

        int id=0;
        int jumlah=0;
        System.out.println("-----------Kasir Toko X-------------");
        while(true){
            System.out.println("------------------------------------");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Cetak Struk");
            System.out.println("3. Keluar");
            System.out.println("------------------------------------");

            int choice= input.nextInt();
            if(choice==1){
                System.out.print("Masukan id : ");
                id=input.nextInt();
                System.out.print("Masukan Jumlah : ");
                jumlah= input.nextInt();
                tambahKeStruk(daftarProduk.listedProduct(),strukBelanja,id,jumlah);// menambahkan produk ke Arlist Struk


            }
            else if(choice==2){
                int jumlahHarga=0;

                ArrayList<ArrayList<Object>> strukDanJumlah =mapProduk(strukBelanja);//Membuat arrList yang terdapat Produk dan Jumlah duplikasi
                int harTot=totalHarga(strukDanJumlah,strukDanJumlah.size()); //Total Belanja

                for(int i=0;i<strukDanJumlah.size();i++){
                    jumlahHarga=((produk)strukDanJumlah.get(i).get(0)).harga*(int) strukDanJumlah.get(i).get(1);
                    //System.out.println(getNama((produk) strukDanJumlah.get(i).get(0))+" "+strukDanJumlah.get(i).get(1)+" "+jumlahHarga);
                    System.out.print(formatStruk(getID((produk) strukDanJumlah.get(i).get(0)),getNama((produk) strukDanJumlah.get(i).get(0)),getHarga((produk) strukDanJumlah.get(i).get(0)), (Integer) strukDanJumlah.get(i).get(1),jumlahHarga));

                }
                System.out.println("------------------------------------");
                System.out.println("Total = " + totalHarga(strukDanJumlah,strukDanJumlah.size()));
                File newStruk=buatFile("fileStruk");//Membuat fileStruk(nomor).txt
                System.out.println("------------------------------------");
                System.out.println("Struk tersimpan di "+ newStruk.getName()+"\n");

                String produkUntukDiPrint=arrToString(strukDanJumlah); //Memformat seluruh produk  menjadi string lalu menuliskanya ke fileStruk.txt
                Tulis(newStruk,produkUntukDiPrint,harTot);//Menuliskan String produkUntukDiprint ke file.txt
                strukBelanja.clear();

            }
            else{
                break;
            }

        }

    }
}
