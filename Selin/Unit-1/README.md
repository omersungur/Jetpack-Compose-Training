# Unit 1 Step 2-3 Video

Composable fonksiyonlar, XML'den farklı olarak UI elementlerini objelerden ziyade fonksiyonlar aracılığıyla oluşturur. Bu fonksiyonlar Event State'i kontrol eder ve State değişikliklerine tepki verir. UI event handlerları, örneğin onClick gibi fonksiyonları emit eder. Daha sonra event handler, UI state'inin değişip değişmeyeceğini kontrol eder. Eğer UI state'i değişirse, o UI'a bağlı olan fonksiyonlar ve elemanlar tekrar execute edilir. Buna recomposition denir ve her bir state değişikliğinde farklı bir UI oluşturulabilir. Örneğin, State1 için UI 1 oluşturulurken, State2 için UI 2 oluşturulabilir.

remember bloğu, Composable'lar recomposition gerçekleştiğinde bile değişkenin state'inin tutulmasını sağlar,state değişkeninin değerinin resetlenmemesi ve saklanması amacıyla kullanılmaktadır. Ancak, konfigürasyon değişikliklerinde remember işe yaramayacaktır. Bu durumda rememberSaveable kullanılabilir.

Composable fonksiyonlar paralel olarak çalışabilir ve herhangi bir sırayla çalışabilirler. Bu nedenle, özel olarak state'i observe etmeye veya manuel olarak UI'ı update etmeye gerek yoktur.

Ancak, Composables'in side effect içermemesi gerekir. Bu, Composables'in sadece UI oluşturma ve güncelleme işlevini yerine getirmesi gerektiği anlamına gelir.Compose side effect, Composable fonksiyonların UI oluşturma ve güncelleme işlevinin dışında ekstra işlevler gerçekleştirmesi anlamına gelir. Bu ekstra işlevler genellikle UI dışında bir kaynağa erişmek veya dış dünyayı etkilemek için kullanılır. Örnek olarak, ağ istekleri yapmak, veritabanı işlemleri gerçekleştirmek, dosya okuma/yazma gibi işlemler side effect örnekleridir.Compose, side effect'leri uygun şekilde yönetmeyi ve sınırlamayı teşvik eder. Çünkü yan etkilerin kontrolsüz kullanımı, uygulamanın durumunu karmaşık hale getirebilir ve hata ayıklamayı zorlaştırabilir. Bu nedenle, Composables'in sadece UI ile ilgili işlevleri gerçekleştirmesi ve yan etkilere karışmaması önemlidir. Side effect'lerin yönetimi için Composables içinde uygun kütüphaneler veya yapılar kullanılabilir. Örneğin, Jetpack Compose'in coroutine desteği sayesinde side effect'ler asenkron olarak yönetilebilir.


### Event -> State -> UI


# Unit 1 Step 5 Video

## **Scaffold:**

Kotlin Compose'de kullanıcı arayüzlerinin temel yapısını oluşturmak için yaygın olarak kullanılan bir yapıdır. Scaffold, uygulamanızın temel bileşenlerini ve uygulama çerçevesini sağlar.

1. **AppBar**: Scaffold içinde yer alan AppBar bileşeni, genellikle uygulamanın üst kısmında bulunan başlık çubuğunu temsil eder. Burada başlık, menüler veya diğer uygulama özelliklerini içeren bir araç çubuğu yer alabilir.
2. **Body Content (Gövde İçeriği)**: Scaffold'ın ana içeriği burada bulunur. Bu genellikle uygulamanızın ana sayfası veya içeriğidir. Scaffold'ın geri kalanı, bu gövde içeriğini çevreleyen yapıyı sağlar.
3. **Bottom Bar (Alt Çubuk)**: Bazı durumlarda, uygulamanın alt kısmında bir navigasyon çubuğu veya başka bir kontrol paneli bulunabilir. Scaffold, alt çubuğu da destekler.

### **Column, Box, Row: Temel Düzenleme Yapı Taşları**

1. **Column**: Dikey düzenlemeler için idealdir. Öğeleri üstten alta doğru düzenler ve ekranın üstünden aşağı doğru uzanan bir sütun oluşturur. Örneğin, bir kullanıcı arayüzünde bir dizi düğme veya metin alanını dikey olarak sıralamak için kullanılabilir.
2. **Row**: Yatay düzenlemeler için kullanılır. Öğeleri soldan sağa doğru düzenler ve yatay bir sıra oluşturur. Örneğin, bir menü çubuğunda simgeleri veya yatay bir bilgi panelini oluşturmak için kullanılabilir.
3. **Box**: Esnek düzenlemeler için kullanılır. İçeriği düzenlemek için çok yönlü bir yapı sağlar. Öğeleri bir araya getirirken özgür olmak istediğinizde tercih edilir. Örneğin, bir kutu içinde bir görüntü ve bir metin parçası bir araya getirilebilir.

### **Vertical Alignment  ve Horizontal Alignment**

 **Vertical Alignment (Dikey Hizalama)**: Column, içeriğini dikey olarak hizalamak için kullanılır. Bu, ekranın üstünden aşağıya doğru bir sıralama sağlar. Elemanlar, genellikle her birinin altında bir diğerinin yer aldığı bir düzen oluşturur.
 
  → Seçenekler:

- Start
- CenterHorizontally
- End

 **Horizontal Alignment (Yatay Hizalama)**: Row, içeriğini yatay olarak hizalamak için kullanılır. Bu, elemanların soldan sağa doğru bir sıralama sağlar. Öğeler yatay olarak hizalanır ve genellikle birbiri ardına ekranın üstünden aşağıya doğru yerleştirilir.

  → Seçenekler:

- Top
- CenterVertically
- Bottom



 **Box için hem vertical hem horizontal alignment yapılabilir.**

  → Seçenekler:

- TopStart
- TopCenter
- TopEnd
- CenterStart
- Center
- CenterEnd
- BottomStart
- BottomCenter
- BottomEnd

### **Vertical Arrangement ve Horizontal Arrangement**

1. **Vertical Arrangement (Dikey Düzenleme)**: Bir dikey düzenleme yapısı oluşturmak için genellikle Column bileşeni kullanılır. Column, içerdiği bileşenleri dikey bir sıra halinde yerleştirir. Örneğin, bir kullanıcı arayüzünde dikey olarak düzenlenmiş bir dizi düğme veya metin alanı için kullanılabilir.
   
 ![layouts31](https://github.com/omersungur/Jetpack-Compose-Training/assets/60012262/04fe0f02-c5d6-4e92-873c-6f112cbce60e)

    
2. **Horizontal Arrangement (Yatay Düzenleme)**: Yatay düzenleme için Row bileşeni kullanılır. Row, içerdiği bileşenleri yatay bir sıra halinde yerleştirir. Örneğin, bir menü çubuğunda simgelerin veya bir yatay bilgi panelinin sıralanması için kullanılabilir.
   

   ![layouts30](https://github.com/omersungur/Jetpack-Compose-Training/assets/60012262/0656127a-d7f3-4033-8f74-73ce2a2b02a3)

        

> Daha spesifik bir arrangement için **Arrangement.spacedBy() fonksiyonu kullanılabilir.**
> 

### **Modifier'lar ve Hizalama**

1. **Modifiers (Düzenleyiciler)**: Modifier'lar, bileşenlerin davranışını veya görünümünü değiştirmek için kullanılır. Örneğin, boyutları, kenar boşluklarını, arka plan renklerini veya kenarları belirlemek için kullanılabilir.
2. **Modifier.align**: Bu düzenleyici, bir bileşenin hizalanmasını ayarlamak için kullanılır. Örneğin, Modifier.align(Alignment.Center) bir bileşeni ortalar.

