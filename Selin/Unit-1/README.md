## Unit 1 Step 2-3 Video

Composable fonksiyonlar, XML'den farklı olarak UI elementlerini objelerden ziyade fonksiyonlar aracılığıyla oluşturur. Bu fonksiyonlar Event State'i kontrol eder ve State değişikliklerine tepki verir. UI event handlerları, örneğin onClick gibi fonksiyonları emit eder. Daha sonra event handler, UI state'inin değişip değişmeyeceğini kontrol eder. Eğer UI state'i değişirse, o UI'a bağlı olan fonksiyonlar ve elemanlar tekrar execute edilir. Buna recomposition denir ve her bir state değişikliğinde farklı bir UI oluşturulabilir. Örneğin, State1 için UI 1 oluşturulurken, State2 için UI 2 oluşturulabilir.

remember bloğu, Composable'lar recomposition gerçekleştiğinde bile değişkenin state'inin tutulmasını sağlar,state değişkeninin değerinin resetlenmemesi ve saklanması amacıyla kullanılmaktadır. Ancak, konfigürasyon değişikliklerinde remember işe yaramayacaktır. Bu durumda rememberSaveable kullanılabilir.

Composable fonksiyonlar paralel olarak çalışabilir ve herhangi bir sırayla çalışabilirler. Bu nedenle, özel olarak state'i observe etmeye veya manuel olarak UI'ı update etmeye gerek yoktur.

Ancak, Composables'in side effect içermemesi gerekir. Bu, Composables'in sadece UI oluşturma ve güncelleme işlevini yerine getirmesi gerektiği anlamına gelir.Compose side effect, Composable fonksiyonların UI oluşturma ve güncelleme işlevinin dışında ekstra işlevler gerçekleştirmesi anlamına gelir. Bu ekstra işlevler genellikle UI dışında bir kaynağa erişmek veya dış dünyayı etkilemek için kullanılır. Örnek olarak, ağ istekleri yapmak, veritabanı işlemleri gerçekleştirmek, dosya okuma/yazma gibi işlemler side effect örnekleridir.Compose, side effect'leri uygun şekilde yönetmeyi ve sınırlamayı teşvik eder. Çünkü yan etkilerin kontrolsüz kullanımı, uygulamanın durumunu karmaşık hale getirebilir ve hata ayıklamayı zorlaştırabilir. Bu nedenle, Composables'in sadece UI ile ilgili işlevleri gerçekleştirmesi ve yan etkilere karışmaması önemlidir. Side effect'lerin yönetimi için Composables içinde uygun kütüphaneler veya yapılar kullanılabilir. Örneğin, Jetpack Compose'in coroutine desteği sayesinde side effect'ler asenkron olarak yönetilebilir.


### Event -> State -> UI

