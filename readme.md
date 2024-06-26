# UYGULAMA NOTLARIM

## Docker

Projemizde docker üzerinde gerekli kurulumları gerçekleştireceğiz.
Bu nedenle ilk olarak Docker Desktop kurulumunu yapınız.

## MongoDB İşlemleri

MongoDB kurulumu birkaç aşamadan oluşacak ve bu DB'yi yönetmek için gerekli toolları kurmamız gerekecektir.

``` bash
docker run --name hsMongo -d -p 27017:27017 -e "MONGO_INITDB_ROOT_USERNAME=BilgeAdmin" -e "MONGO_INITDB_ROOT_PASSWORD=Aa123456**" mongo:latest
```

Yukarıdaki komut terminalde çalıştırıldıktan sonra mongoDB default ayarları ile çalışmaya başlayacaktır.

MongoDB Compass Tool kurularak bağlantı sağlanır ve bu bağlantı üzerinden gerekli konfiglerin yapılması gereklidir.

1. Öncelikle Root Admin ile ilgili DB'ye bağlanıyoruz;
    - New Connection
    - localhost:27017 şeklinde ilgili PC ip adresi ve portu girilir.
    - Authentication kısmında username/password seçilerek root bilgilieri girilir.

_**DİKKAT!!!**_ Burada DB adı girilmez. Çünkü root kullanıcısıdır.

2. DB'ler oluşturulur ve bunlara kullanıcılar tanımlanır.
   - Sol üst tarafta bulunan + simgesine basarak yeni bir DB oluşturma ekranına geçilir. Burada ad ve index adı verilerek oluşturma tanımlanır.
   - DB'yi yönetecek yeni bir kullanıcı ve yetkilendirmeleri tanımlanır.
   - Mongo Compass içerisinde sol altta bulunan mongosh'a tıklayıp terminal ekranını açıyoruz.
   - Burada ilgili DB'ye geçmek için "use" komutu kullanıyoruz.

          use UserProfileDB
   
   - İlgili DB'ye geçtikten sonra yeni bir yetkili kullanıcı oluşturuyoruz.

           db.createUser(
              {
                 user: "admin",
                 pwd:  "root", 
                 roles: ["readWrite", role: "dbAdmin"]
              }
           )

       ``db.createUser({user:"hs1",pwd:"root",roles:["readWrite","dbAdmin"]})``  

   - Buradan sonra root bağlantısından çıkarak yeniden bağlantı yapıyoruz. 
   - Burada dikkat etmemiz gereken husus artık bir kullanıcı bir DB'ye yetkili kılınmış durumda bu nedenle bağlantı kısmında DB adının mutlaka yazılması gerekmektedir.     

_**DİKKAT!!!**_ Asla root kullanıcısını DB temel işlemleri(CRUD) için kullanmayın. Zaten MongoDB default olarak bu işlemlerin yapılmasını reddeder.

## MongoDB & Spring Boot Configleri

