1 - Thinking in Compose

- Compose ile bir şeyin ne olduğunu tanımlarız fakat nasıl olduğunu tanımlamayız.

- XML'de bir view'a Kotlin kodlarıyla ona erişecek kodlar yazarız. (findByViewId viewBinding vs.) Ardından o view'a erişerek set fonksiyonlarıyla beraber güncellemesini yaparız. Compose'da hem UI'ları hem de bunların state'ini Kotlin kodları şeklinde yazarız.

- Compose'da UI elementleri sınıf değildir, birer composable fonksiyonlardır. Bu yüzden referansları yoktur ve direkt bunları değiştirdiğimiz bir set fonksiyonları yoktur. Buradaki stateleri tamamen kendimiz güncelleriz. Örneğin bir radio buton'a tıkladığımızda onun seçili olmasını biz kendimiz kodlardan ayarlarız. Bu XML'de otomatik oluyordu. Tam olarak bu yüzden Compose'da bir UI'ı nedir diye tanımlarız, nasıl diye tanımlamayız. Radio buton'un görünümünü, gerekli stateler ile tanımlıyoruz fakat bu state'i nasıl render edeceğini söylemeyiz.

- Bu satateleri eventler kontrol eder. Örneğin click işlemi gibi.

- Stateler UI'ları kontrol eder. Bir UI elemanının state'i değişirse o UI elemanı yeniden çizdirilir, buna recomposition denir.

Özet:
- Ne olduğunu tanımlarız nasıl olduğunu tanımlamayız.
- UI elementler fonksiyondur. Sınıf değildir.
- Stateler UI'ı kontrol eder.
- Eventler Stateleri kontrol eder.

2 - Composable Functions

- UI component'i oluşturabilmek için fonksiyonu @Composable notasyonuyla işaretlememiş gerekir. Bu notasyon Compose derleyiciye bu kodların birer UI'a dönüşeceğini söyler.

- Bu composable fonksiyonlar tekrar tekrar kullanılabilir.

- Composable fonksiyonlar immutable'dır. Bunları bir değişkene eşitlik olarak yazmamalıyız.

- Compose'da visible, invisible, gone gibi yapılara ihtiyaç yoktur. Bir composable'ı ya gösteririz ya da göstermeyiz.

- Composable fonksiyonlar her çağrılında aynısı gibi davranmalıdır. propertyleri veya global değişkenleri değiştirmemelidir.

- Composable fonksiyonlarda stateler değiştiği zaman recomposition oluyordu. Bu recomposition olayı için bir değişken tanımlamalıyız. Bu değişkenin değeri değiştiğinde composable fonksiyonların da recompositiona uğrayacağından haberi olmalı. Bunun için değişkeni mutable state içine sarmamız gerekir. Bu, compose run time'da gözlemlenebilir bir tipdir. Ayrıca bu değişkeni remember'a delege ederiz çünkü recomposition olduğu zaman state'inin sıfırlanmamasını garanti etmemiz gerekir. Burada delege ederekte kullanabiliriz veya direkt eşitlik olarakta kullanabiliriz. Aşağıda iki örnekteki fark, by ile kullanımda direkt değişkeni kullanabilirken diğerinde expanded.value diyerek bir kullanım yapıyoruz.

var expanded by remember { mutableStateOf(false) }
var expanded = remember { mutableStateOf(false) }

- Config ayarları değiştiğinde (ekranı yan çevirme vs.) stateleri kaybetmek istemiyorsak rememberSaveable kullanabiliriz.

Davranışlar:

- Composable fonksiyonlar çağrıldığı sırada çalışmazlar. Bazı UI elementlerine öncelik verilir ve bu yüzden önce onlar çizilir.

- Composable fonksiyonlar paralel olarak çalışabilir. Yani render işlemlerinde birden fazla çekirdek bunları beraber çalıştırabilir. Bu da performans artışı demektir.

- Composable fonksiyonlar side effect free olmalı.

- Recomposition, olabildiğince ilgili yerlerde gerçekleşir. Yani state'i değişmeyen composable'lar recomposition'a uğramıyor.

- Recomposition iyimser bir yaklaşım sergiler. Yani recomposition gerçekleşeceği sırada o an state tekrardan değişirse, çizilecek UI iptal edilir ve yeni state'e, parametreye göre bir recomposition gerçekleşir.

- Composable fonksiyonlar sık sık çalışabilir. Bir composable animasyon içeriyorsa bu durumu önemseyebiliriz çünkü animasyonlarda her bir kare çok önemlidir. Hızlı olması ve framelerin atlanmaması gerekir.
