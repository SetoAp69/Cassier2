//import java.util.ArrayList;
public  class linkedList<T>    { //Class LinkedList
    public class Node{//Class Node
        public produk data;
        public Node next;
        public Node(produk data){
            this.data=data;
            this.next=null;
        }
    }
    public Node head=null;
    public void add(produk data){
        Node newNode= new Node(data); //Make new Node
        if(head == null){ //if linkedList is empty ---> set newNode as Head
            head=newNode;
            return;
        }

        Node current=head; //Traversing linkedList until current.next is null or empty
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;//Set newNode as Current.next
    }

    public produk find(int key){ //Finding the Product from given id(key)
        produk productFound=new produk(0,"",0);
        Node current=head; //Traversing until current.next is null
        while(current.next!=null){
            produk currentProduct= current.data;
            if(currentProduct.id==key){ //if product with the id has been found ---> return
                productFound=currentProduct;
                return currentProduct;

            }
            current=current.next;
        }
        return productFound;
    }

    /*public static void sort(ArrayList<produk>list){

        list.sort(((o1, o2) ->o1.getInteger().compareTo(o2.getInteger()))) ;
    }
    public void tambahKeStruk(linkedList<T> llist, ArrayList<produk> list, int jumlah, int id){
        for(int i=0;i<=jumlah;i++){
            list.add(llist.find(id));
        }
    }*/








        /*for(int i=0;i<strukBelanja.size();i++){
            System.out.println(strukBelanja.get(i).nama);
        }*/

        //Map ke String
        /*Map result=countByClassicalLoop(strukBelanja);
        System.out.println(result);
        for(Object name:result.keySet()){
            String key=name.toString();
            String value=result.get(name).toString();
            System.out.println(key +" "+ value);
        }*/



        /*while(true){

            System.out.println("-------Kasir Toko Saya-----------");
            System.out.println("1. Tambah barang ");
            System.out.println("2. Cetak Struk");
            System.out.println("3. Keluar");
            System.out.println("----------------------------------");
            pilihan= input.nextInt();
            if(pilihan==1){
                System.out.println("Masukan id : ");
                idDicari= input.nextInt();
                System.out.println("Masukan Jumlah : ");
                jumlahDibeli= input.nextInt();
                for(int j=0;j<jumlahDibeli;j++){
                    strukBelanja.add(list.find(idDicari));
                }
            }

            else if(pilihan==2){
                sort(strukBelanja);
                int jumlahBarang=0;

                System.out.println("\n \n");
            }

            else{
                break;
            }





        }*/
        //System.out.println(daftarProduk.listedProduct().head.data.nama);










}
