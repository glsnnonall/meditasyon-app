package com.gulsum.onal.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gulsum.onal.Helper.Utils;
import com.gulsum.onal.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.internal.Util;

public class HoroscopeActivity extends AppCompatActivity {

    CircleImageView circleImageView;
    TextView username;
    String profileImage = "https://hthayat.haberturk.com/im/2015/03/18/ver1429277259/1028324_620x360.jpg";
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);
        username = (TextView)findViewById(R.id.username);
        username.setText("@rezzankiraz");
        circleImageView = (CircleImageView)findViewById(R.id.profileImage);
        progressBar = (ProgressBar)findViewById(R.id.progres);
        Picasso.get().load(profileImage).resize(256,256).centerCrop().into(circleImageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });

        initActionBar();
    }
    private void initActionBar() {
        // Initialize the Toolbar( this is the new ActionBar in Lollipop)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Mistik İşler");
        TextView title = (TextView)toolbar.findViewById(R.id.toolbar_title);
        ImageButton back = (ImageButton)toolbar.findViewById(R.id.back);
        back.setVisibility(View.VISIBLE);
        title.setText("Mistik işler");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setElevation(4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finish();
                Utils.back(HoroscopeActivity.this);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
        Utils.back(HoroscopeActivity.this);
    }

    public void yengec(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Yengeç");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Yeni başlangıçlar zamanı\n" +
                "\n" +
                "İkizler burcunun iki çizgisinin çift karakteriyle ayın birinde hem yeni bir ayı hem de yeni bir haftayı karşılıyoruz. Güneş burcunuza ilerleyip bunu yapar yapmaz bir Güneş tutulmasına imzasını atarken oldukça heyecan verici, sürpriz veya mucize şeklinde gelişen bir ay olabilir. Akışta huzuru bir şekilde bulup yakalamaya çalışan bir haliniz olabilir ayın 20’sine kadar. Beklenmedik olaylar yanında sürpriz gelişmelere de hazırlıklı olmalısınız. 5 Haziran’daki Ay tutulması, çalışma ortamınızla, gündelik yaşamınızla, sağlık ve şifayla ilgili bir konuyu açığa çıkarabilir. 21 Haziran’da burcunuzda gerçekleşen 0 dereceli tutulma yaşamınızı değiştirebilecek güçlü bir etkiyi beraberinde getirebilir. Yeni bir yaşam şekli veya şartının içinde kendinizi bir anda bulabilirsiniz. 18 Haziran’da burcunuzdaki Merkür’ün retrosu iletişimi, haberleşmeyi bir miktar zorlaştırabilir. Kendinizi iyi ifade etme konusunda dikkatli maddi konuları kafanızda, zihninizde değerlendirmenizi bir şekilde zorlaştırabilir. 25 Haziran’da Venüs retrosunun son bulmasıyla ilişkilerdeki karışıklıklar son bulabilir, ama o zamana kadar gizli hayranlara dikkat, farklı şekillerde karşınıza çıkabilirler. 28 Haziran’dan itibaren Mars yıl sonuna dek sürecek olan yeni transitine başlıyor, bu süreç sizi hedef ve planlarınız doğrultusunda daha mücadeleci olmaya itebilir, enerjinizin büyük bir kısmını iş ve kariyer konularına aktarabilirsiniz.");
        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void kova(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Kova");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Astrolojik açıdan dikkat çeken Ay ve Güneş tutulmaları\n" +
                "\n" +
                "Haziran ayında Ay ve Güneş tutulmaları oldukça dikkat çekici bir görünüm sergilemekte. 5 Haziran’da gerçekleşen Ay tutulması sosyal yaşamınızla ve arkadaşlık ve dostluk ilişkilerinize ışık tutmakta. Bu ilişkilerle ilgili önemli kararlarda maddi kısıtlamalar ve engeller belirleyici olabilir. 21 Haziran’daki Güneş tutulması ise gündelik yaşamınıza ve rutinlerinize ışık tutmakta ve bu alanda önemli gelişme, değişim ve başlangıçları beraberinde getirmekte. Sağlık ve şifayla ilgili yeni adımlar dikkat çekici olabilir. 18 Haziran’da başlayacak olan Merkür retrosunda gündelik iletişimde aksaklıklara, iletişim kopukluklarına dikkat etmelisiniz. 25 Haziran’da Venüs retrosunun son bulmasıyla aşkta engeller ortadan kalkıyor, sevdiğinizle daha fazla beraber olabileceğiniz, aranızdaki sorunları daha kolay halledebileceğiniz bir dönem başlıyor. Çocuklarınız varsa onlarla ilgili güzel gelişmeler yaşayabilirsiniz. 28 Haziran’dan itibaren Mars yeni transitine başlıyor ve bu transit yıl sonuna dek sürecek. Bu dönemde sizi en çok uğraştıracak konu diliniz olabilir, farkında olarak veya olmadan daha sert ve dolaysız bir ifade ve anlatım diliniz olabilir, kırıcı olmamaya özen göstermelisiniz. Komşu, kardeş ve akraba ilişkileri bu dönemde sizi en çok uğraştıracak alan olabilir.");

        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void basak(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Başak");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Sosyal alanda değişimler\n" +
                "\n" +
                "Haziran ayına Ay ve Güneş tutulmaları eşliğinde giriş yapıyoruz. Tutulmalar farkındalığımızın yükseldiği önemli başlangıçlara işaret eden ve bunları tetikleyen astrolojik yönden kritik olaylardır. 5 Haziran’daki Ay tutulması aileyle ve ev konularıyla ilgili bir tutulma olabilir. Geçmişinizin izleri size kendisini hatırlatırken ilişkiler, evlilik ve ortaklık konuları daha fazla gayret, çaba ve mücadele gerektirebilir. 21 Haziran’daki Güneş tutulması ise sosyal alanınızda gerçekleşen güçlü bir tutulma ve arkadaşlık ilişkilerinizi masaya yatırıp önemli çıkarımlar eşliğinde güçlü başlangıçları, yeni dostluklar veya ayrılıkları beraberinde getirebilir. 18 Haziran’da başlayacak olan Merkür retrosunda sosyal iletişime dikkat etmelisiniz. 25 Haziran’da Venüs retrosunun son bulması otorite ve yönetici konumundaki kişilerle ilişki ve etkileşiminizi kolaylaştırabilir. 28 Haziran’dan itibaren Mars yeni transitine başlıyor ve bu transit yıl sonuna dek sürecek. Bu süreç mücadeleci yanınızı iyice ortaya çıkarırken ruhsal olarak kendinizi korumaya özen göstermelisiniz.");
        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void balik(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Balık");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Sevdiklerinizle ilgili önemli gelişmeler\n" +
                "\n" +
                "Haziran ayı yepyeni gelişmeleri ve de tutulmaları beraberinde getiren bir ay. 5 Haziran’daki Ay tutulması iş hayatınıza ve kariyerinize ışık tutan bir tutulma ancak tutulmada ilişkinizdeki gölgeleri daha çok hissedebilirsiniz. Hedef ve planlarınızı, yolunuzu ve kariyerinizi size hatırlatan bir tutulma olabilir. 21 Haziran’daki Güneş tutulması ise güçlü bir tutulma ve aşk hayatınız, sevdikleriniz ve varsa çocuklarınızla ilgili önemli bir gelişme veya başlangıcı beraberinde getirebilir. Yeni bir aşkı veya tutku alanını doğurabilir ve ilham verici bir tutulma olabilir. 18 Haziran’da başlayacak olan Merkür retrosunda sevdiklerinizle iletişime daha fazla özen göstermelisiniz. 25 Haziran’da Venüs retrosunun son bulmasıyla ailenizden ve evdekilerden daha çok destek göreceğiniz bir dönem başlıyor. 28 Haziran’dan itibaren Mars yeni transitine başlıyor ve bu transit yıl sonuna dek sürecek. Bu dönemde maddi konular, iş ve para konuları sizi en çok uğraştıran, enerjinizi tükettiğiniz alan olabilir. Harcamalara dikkat etmeli, bütçenizi gözetmelisiniz.");

        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void yay(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Yay");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Burcunuzda Ay tutulması var\n" +
                "\n" +
                "Haziran ayının en önemli gelişmelerinden olan Ay tutulması 5 Haziran’da burcunuzda gerçekleşiyor. Bu tutulma kendinizde, yaşamınızda önemli bir farkındalığa dikkat çekerken ev ve aile yaşamınızdaki koşulların güçlüğünü apaçık ortaya çıkarabilir, görünür kılabilir. 21 Haziran’daki Güneş tutulması ise eşinizin veya ortağınızın iş yaşamındaki önemli değişimler açısından dikkat çekici görünmekte. Ortak maddi konularda yeni imkanlar, fırsatlarla birlikte yeni bir iş de doğabilir. Yeni bir yatırım veya finansman gündeme gelebilir. 18 Haziran’da başlayacak olan Merkür retrosunda hesap karışıklıklarında ve işyerindeki iletişime daha çok özen göstermeniz gerekebilir. 25 Haziran’da Venüs retrosunun son bulmasıyla ilişkilerde sizi daha fazla destekleyen bir döneme ilerliyorsunuz. Yeni bir ilişkiyi başlatabilirsiniz. 28 Haziran’dan itibaren Mars yeni transitine başlıyor ve bu transit yıl sonuna dek sürecek. Bu dönemde sizi en çok uğraştırıp oyalayacak, zamanınızı ve enerjinizi tüketecek konu aşk, sevdikleriniz, tutku ve heyecanlarınız olabilir. Yüreğinizin sesini dinlemek büyük bir mücadeleyi beraberinde getirebilir.");

        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void boga(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Boğa");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Ay ve Güneş tutulmaları\n" +
                "\n" +
                "İş ve maddi konuların giderek önem kazanacağı bir aya ilerliyorsunuz. 20’sine kadar kazançlarınız, gelirleriniz, giderleriniz konusunda epeyce hesap kitap yaptıktan sonra, tutulmalarla birlikte özellikle aile içi iletişimin giderek hızlanarak arttığı bir ortamda kendinizi bulabilirsiniz. Annenizle, ailenizle çok konuşacağınız bir ay kapanışı olabilir. 5 Haziran’daki Ay tutulması iş ve ortak maddi konularda, varsa vergi ve miras işlerinizde birtakım farkındalık ve kararları beraberinde getirebilir. Biraz umutlarınızın kırıldığı bir dönem olsa da bunlara çok takılmamaya çalışmalısınız. Ay tutulması eşinizin iş yaşamıyla ilgili bir durumu da çarpıcı şekilde gösterebilir. 21 Haziran’da ise bir Güneş tutulması var ve bu tutulma yakın çevrenizde, komşu, kardeş ortamınızda çarpıcı bir şekilde gelişen bir durumu ve bu durumun getireceği yeni yaklaşımları tetikleyebilir. 18 Haziran’da başlayacak olan Merkür retrosunda iletişim, haberleşme problemlerine dikkat etmelisiniz. 25 Haziran’da Venüs retrosunun sonlanması sizi epeyce hızlandırabilir, üzerinizdeki ağırlıktan kurtulmanızı sağlayabilir ve harekete geçmenizi kolaylaştırabilir. 28 Haziran’dan itibaren Mars yeni transitine başlıyor ve bu transit yıl sonuna dek sürecek. Bu süreçte başta sağlığınız olmak üzere hemen her konuda arkanızı iki kez kontrol ettiğinize emin olun. Mars avcı pozisyonunda sizi hiç ummadığınız veya beklemediğiniz yerden avlayabilir.");

        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void ikizler(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","İkizler");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Yeni bir iş veya kazanç fırsatı doğabilir\n" +
                "\n" +
                "Yeni ayın en önemli konuları hiç şüphesiz tutulmalar. Tutulmalar özellikle duygusal açılardan oldukça etkileyici zamanlar olarak dikkat çekici. İlk tutulma 5 Haziran’da karşıt burcunuz Yay’da meydana geliyor ve ilişkinize, evliliğinize, ortaklığınıza ışık tutuyor. Bir ilişkiniz yoksa bu bir farkındalık zili olabilir. Karşınızda sizi bekleyen, size göz kırpan birini görebilirsiniz. Bu tutulmanın açıları ise iş hayatınızdaki dinamiklere etki edebilir. Hedeflerden uzaklaşma ya da onları yakalayamama duygusu getirebilir. Duygusal kızgınlık ve öfke patlamalarına dikkat etmelisiniz. 21 Haziran’da ise bir Güneş tutulması var ve bu tutulma maddi konularda yenilik ve değişimi beraberinde getirebilir. Yeni bir işe girebilirsiniz. Kendi başına güçlü ancak başka gezegenlerden desteksiz ve bir başına olan bu tutulma mekan değiştirme, taşınma, aile içi değişiklikler getirebilir. 18 Haziran’da başlayacak olan Merkür retrosu maddi konuları kafanızda, zihninizde değerlendirmenizi bir şekilde zorlaştırabilir. 25 Haziran’da Venüs retrosunun son bulması bu ayın en güzel haberlerinden biri, zira çekiciliğiniz, zarafetiniz artmaya ve giderek daha da dikkat çekici olmaya başlayacak. 28 Haziran’dan itibaren Mars yeni transitine başlıyor ve bu transit yıl sonuna dek sürecek. Bu süreç özellikle sosyal ilişkilerinizi çalkantıya, karmaşaya itebilir. Güçlü kişiler ortaya çıkabilir. Kendinizi dışlanmış, uzaklaşmak zorunda bırakılmış hissedebilirsiniz.");

        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void terazi(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Terazi");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Tutulma ayındayız\n" +
                "\n" +
                "Haziran ayı tutulmalar açısından oldukça dikkat çekici bir görünüm sergilemekte. 5 Haziran’daki Ay tutulması eğitim konularına dikkatinizi çekerek farkındalığınızı yükseltebilir. Eğitim konusunda daha önce fark etmediğiniz bir durumu, gelişmeyi, imkanı veya fırsatı fark etmenizi sağlayabilir. Bu durumun gündelik yaşamınızda daha fazla iş veya mücadeleyi beraberinde getirebileceğini ve bu alanı etkileyebileceğini göz önünde bulundurabilirsiniz. 21 Haziran’daki Güneş tutulması oldukça güçlü bir tutulma ve iş hayatınızda ve kariyerinizde yeni başlangıçlara, yeni bir döneme işaret edebilir. 18 Haziran’da başlayacak olan Merkür retrosunda bu alandaki iletişime, özellikle otorite konumundaki kişilerle ve üstlerinizle olan etkileşime dikkat etmelisiniz. 25 Haziran’da Venüs retrosunun son bulması Venüs’ün yönetici gezegeniniz olması açısından önemli, daha rahat hareket edip hızlanabileceğiniz bir süreci başlatabilir. Sesinizi daha çok duyurabileceğiniz bir dönem güzel bir tatili de beraberinde getirebilir.  28 Haziran’dan itibaren Mars yeni transitine başlıyor ve bu transit yıl sonuna dek sürecek. Bu süreç özellikle ikili ve birebir ilişkilerinizde hareketli bir döneme işaret ediyor. Görünen o ki yıl sonuna kadar sizi en çok yorup uğraştıracak olan kişi en yakınınızda duran eşiniz, ortağınız, arkadaşınız olabilir.");

        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void aslan(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Aslan");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Aşk tutulması\n" +
                "\n" +
                "Haziran ayına Yay burcundaki Ay tutulması ve ardından Yengeç burcundaki Güneş tutulması damga vuruyor. 5 Haziran’daki Ay tutulması bir aşk tutulması olabilir. Aşkınız için mücadele etmenizi gerektiren bir tutulma yaşayabilirsiniz. Tutkularınızın getirdiği duyguların karmaşası dikkat çekici olabilir. 21 Haziran’da ise spiritüel ve mistik yanınızı iyice ortaya çıkaran bilge bir tutulma sizi bekliyor. Bu tutulmada bırakmanız ve vazgeçmeniz gereken konularda ortaya koymanız gereken yeni tutum ve davranış şekli dikkat çekici olabilir. 18 Haziran’da başlayacak olan Merkür retrosu sizi sosyal konularda iletişime daha çok dikkat etmeniz gereken bir sürece çekebilir. Konuşmalarınızın duygusal tonunun yanlış anlaşılabileceğine dikkat etmelisiniz. 25 Haziran’da Venüs retrosunun son bulmasıyla arkadaşlarınızdan daha çok destek görebileceğiniz bir döneme ilerliyorsunuz, en azından onlarla daha rahat görüşüp konuşma imkanı bulabilirsiniz. 28 Haziran’dan itibaren Mars yeni transitine başlıyor ve bu transit yıl sonuna dek sürecek. Bu süreçte özellikle seyahatler ve yurt dışı ve yabancılarla ilgili temas ve bağlantılar artabilir, yeni yerler görmek, ziyaret etmek, yeni macera ve ufuklara açılmak konusunda enerjiniz yükseliyor.");

        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void oglak(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Oğlak");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Burcunuz açısından önemli bir ay\n" +
                "\n" +
                "Haziran ayı Ay ve Güneş tutulmaları açısından oldukça dikkat çekici bir görünüm sergilemekte. 5 Haziran’daki Ay tutulması yaşanan kayıpların, bu kayıplardan gördüğününüz zararların ruhunuzdaki yansımalarına dikkat çekebilir. Mistik ve spiritüel yanınızın altını çizen bir tutulma yaşayabilirsiniz. Bazı imkân veya fırsatlardan vazgeçtiğinizi veya vazgeçebileceğinizi size gösteren ve sezgilerinizi oldukça güçlendiren bir tutulma olabilir. 21 Haziran’daki Güneş tutulması ise eşinizle ilgili durumlara dikkatinizi çekmekte. Evliliğiniz ve birlikteliğiniz açısından yeni bir dönemin başlangıcına işaret eden önemli bir tutulma yaşayabilirsiniz. Bir ilişkiniz yoksa bu tutulma yeni bir ilişkiyi de beraberinde getirebilir. 18 Haziran’da başlayacak olan Merkür retrosu ilişkilerde iletişime daha çok dikkat etmenizi gerektirebilir. 25 Haziran’da Venüs retrosunun son bulması sizi sağlık açısından destekleyen bir görünüm yaratabilir, gündelik rutinlerinizi destekleyen ilişkiler rahatlatıcı olabilir. 28 Haziran’dan itibaren Mars yeni transitine başlıyor ve bu transit yıl sonuna dek sürecek. Bu süreçte ev ve aile konuları sizi epeyce uğraştırıp, enerjinizin büyük bir kısmını tüketecek gibi görünmekte.");

        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void koc(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Koç");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Tutulma mevsimi ve yeni bir ay\n" +
                "\n" +
                "Tutulma mevsiminde yepyeni bir ayı karşılarken bu dönemde en çok özen göstermeniz gereken şey dağılmamak, kendinize belli sınırlar koyup bunlara riayet etmek ve dalgınlığa ve unutkanlığa çok dikkat etmek olmalı. Eğitimle ilgili konulara odaklısınız ayın 20’sine kadar, ancak sonrasında ev ve aile önem kazanıyor. 5 Haziran’daki tutulma akademik konuları ve uzakları gündeminize taşıyan bir farkındalık anı olabilir. Aklınıza, mantığınıza güvenmeli ve akışın sularında kaybolmamaya gayret etmelisiniz. 21 Haziran’daki Güneş tutulması ise ailenizde, evinizde yeni bir başlangıç veya düzene işaret edebilir. 18 Haziran’da başlayacak olan Merkür retrosunda ailenize kendinizi anlatmanız da, karşılığında anlaşılmanız da zor olabilir. 25 Haziran’da Venüs retrosunun sonlanmasıyla okul veya eğitim hayatınızdaki ilişkileri düzene koyabilirsiniz. 28 Haziran’dan itibaren burcunuzda seyredecek olan Mars sene sonuna kadar sizi daha da aktif, hareketli ve dinamik kılabilir. Spor ve fiziksel aktiviteleri hızlandırabilirsiniz ancak sağlığınızı korumayı ihmal etmeyin.");
        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }

    public void akrep(View view) {
        Intent i = new Intent(HoroscopeActivity.this,ZodiacSingleSing.class);
        i.putExtra("burc","Akrep");
        i.putExtra("text","1 Haziran, 2020\n" +
                "\n" +
                "Güneş tutulması yer ve mekan değişimi getirebilir\n" +
                "\n" +
                "Haziran ayı Ay ve Güneş tutulmaları açısından oldukça dikkat çekici bir görünüm sergiliyor. İlk tutulma olan Ay tutulması 5 Haziran’da gerçekleşiyor ve özellikle iş ve maddi konularda farkındalıklara işaret ediyor. Ancak Ay tutulmalarının harekete geçme zamanı olmadığını aklınızdan çıkarmayın ve bu süreçte sevdiklerinizin ve aşk yaşamınızın enerjinizi tüketebileceğini bir kenara not edin. 21 Haziran’daki Güneş tutulması ise uzak ufuklara, yeni maceralara ve keşiflere göz kırpan güçlü bir tutulma izlenimi veriyor. Sizi bulunduğunuz ortamın dışında bir yer, ev ve mekan değişikliğine iten bir tutulma yaşayabilirsiniz. 18 Haziran’da başlayacak olan Merkür retrosu uzaklarla olan iletişiminizde daha dikkatli olmanızı gerektirebilir. 25 Haziran’da Venüs retrosunun son bulmasıyla ortak maddi konularda, iş ve para konularında daha rahat ilerleme sağlayabileceğiniz bir süreç doğabilir. Eşiniz ve ortağınızın işlerinde olumlu gelişmeler yaşayabilirsiniz. 28 Haziran’dan itibaren Mars yeni transitine başlıyor ve bu transit yıl sonuna dek sürecek. Bu süreçte Mars’ın yönetici gezegeniniz olması sizi oldukça aktif bir sürece itebilir, lider, yönetici yönlerinizi açık bir şekilde ortaya koyabilir, başkalarını yönetmede tozu dumana katabilirsiniz. Sağlığınıza özen göstermeyi ihmal etmeyin.");

        startActivity(i);
        Utils.go(HoroscopeActivity.this);
    }
}
