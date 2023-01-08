import entities.Customer;
import services.Impl.CustomerServiceImpl;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Runner {
    static CustomerServiceImpl customerService = new CustomerServiceImpl();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        boolean flag = true;

        while (flag) {
            ustMenu();
            int islemNo = scan.nextInt();
            switch (islemNo) {
                case 1:
                    int musteriIslemleriNo = musteriIslemleriMenu();
                    switch (musteriIslemleriNo) {
                        case 1:
                            addCustomer();
                            customerService.customers.entrySet().stream().forEach(System.out::println);
                            break;
                        case 2:
                            createOrUpdateCustomer();
                            break;
                        case 3:
                            musteriSil();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Yanlis giris yaptiniz, tekrar deneyiniz!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Henüz olusturulmadi");
                    break;
                case 3:
                    System.out.println("Henüz olusturulmadi");
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Yanlis bir giris yaptiniz. Lütfen tekrardan deneyiniz.");
            }
        }
    }

    private static void musteriSil() {
        System.out.println("Silmek istediginiz müsteri numarasini giriniz : ");
        customerService.customers.entrySet().stream().forEach(System.out::println);
        Long id = scan.nextLong();
        customerService.deleteCustomer(id);
        System.out.println("Müsteri basariyla silindi!");
        customerService.customers.entrySet().stream().forEach(System.out::println);
    }

    private static void ustMenu() {
        System.out.println("=====================HOSGELDINIZ======================");
        System.out.println("Lütfen bir islem seciniz");
        System.out.println("1- Musteri Islemleri ");
        System.out.println("2- Personel Islemleri ");
        System.out.println("3- Oda Bilgileri ");
        System.out.println("4- Cikis ");
    }

    private static int musteriIslemleriMenu() {
        System.out.println("Lütfen bir islem seciniz");
        System.out.println("1- Musteri Ekle ");
        System.out.println("2- Rezervasyon olustur veya güncelle");
        System.out.println("3- Müsteri sil ");
        System.out.println("4- Üst menüye dön");
        return scan.nextInt();
    }

    private static void addCustomer() {
        Long id = (long) (customerService.customers.entrySet().size() + 1);
        System.out.println("Musteri ismini giriniz: ");
        String firstName = scan.next();
        System.out.println("Musteri soy ismini giriniz: ");
        String lastName = scan.next();
        System.out.println("Musteri mobil numarasini giriniz: ");
        String mobilePhone = scan.next();
        Customer customer = new Customer(id, firstName, lastName, mobilePhone);
        customerService.addCustomer(customer);
    }

    private static void createOrUpdateCustomer() {
        System.out.println("Hangi musteri icin rezervasyon olusturacaksiniz: ");
        customerService.customers.entrySet().stream().forEach(System.out::println);
        Long musteriId = scan.nextLong();
        Customer customer = customerService.customers.get(musteriId);
        System.out.println("Check in tarihini giriniz (gg/mm/yyyy): ");
        String checkIn = scan.next();
        String[] tarihGiris = checkIn.split("/");
        LocalDateTime checkInTarih = LocalDateTime.of(Integer.parseInt(tarihGiris[2]), Integer.parseInt(tarihGiris[1]), Integer.parseInt(tarihGiris[0]),
                13, 00);
        System.out.println("Check out tarihini giriniz (gg/mm/yyyy): ");
        String checkOut = scan.next();
        String[] tarihCikis = checkIn.split("/");
        LocalDateTime checkOutTarih = LocalDateTime.of(Integer.parseInt(tarihCikis[2]), Integer.parseInt(tarihCikis[1]), Integer.parseInt(tarihCikis[0]),
                11, 00);

        customerService.createOrUpdateReservation(customer, checkInTarih, checkOutTarih);
        System.out.println(customer);
    }
}
