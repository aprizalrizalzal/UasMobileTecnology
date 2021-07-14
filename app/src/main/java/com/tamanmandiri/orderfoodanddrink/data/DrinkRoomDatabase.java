package com.tamanmandiri.orderfoodanddrink.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.tamanmandiri.orderfoodanddrink.R;
import com.tamanmandiri.orderfoodanddrink.dao.DrinkDao;
import com.tamanmandiri.orderfoodanddrink.model.DrinkModel;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DrinkModel.class}, version = 1)
public abstract class DrinkRoomDatabase extends RoomDatabase {
    public abstract DrinkDao drinkDao();

    private static volatile DrinkRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized DrinkRoomDatabase getDatabaseDrink(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    DrinkRoomDatabase.class, "drink_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return INSTANCE;
    }
    private static final RoomDatabase.Callback callback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                DrinkDao drinkDao = INSTANCE.drinkDao();

                drinkDao.insert(new DrinkModel(
                        "d1",
                        R.raw.cokelat_panas,
                        "Cokelat Panas",
                        "Coklat panas? Bagaimana mungkin? Jika kamu berurusan dengan kram menstruasi, salah satu cara alami terbaik untuk meredakan rasa sakit adalah melalui minum minuman dengan kandungan magnesium tinggi. Untuk mendapatkan magnesium itu, kamu perlu membuat cokelat panas buatan sendiri dengan bubuk cokelat mentah. Jika kmu perlu sedikit mempermanisnya, cobalah susu almond dan madu atau sedikit sirup maple.",
                        10_000));
                drinkDao.insert(new DrinkModel(
                        "d2",
                        R.raw.jus_bit,
                        "Jus Bit",
                        "Bit memiliki kemampuan untuk menurunkan tekanan darah kamu, meningkatkan stamina kamu dan meningkatkan aliran darah ke otak pada orang dewasa yang lebih tua (memperlambat perkembangan demensia). Buah bit juga mampu membuat hati yang sehat dengan nol trans dan lemak jenuh, serta mengandung magnesium tinggi, kalsium, dan tingkat zat besi. Lalu, satu-satunya kekurangan dari jus bit adalah sulit untuk ditemukan di sebagian besar supermarket atau pasar. Jadi, kamu mungkin perlu membuatnya di rumah atau memesannya dari toko jus tertentu.",
                        12_000));
                drinkDao.insert(new DrinkModel(
                        "d3",
                        R.raw.jus_delima,
                        "Jus Delima",
                        "Delima atau pomegranate ini telah dipuji hingga akhirnya nge-trend karena antioksidan kuat yang dibungkusnya. Penelitian menunjukkan bahwa jus merah ini dapat membantu mencegah peradangan, penyakit jantung, dan kanker. Jadi, mengonsumsi jus delima segelas setiap hari adalah pilihan yang baik. Pastikan kamu minum jus delima yang murni dan jauhkan minuman delima yang berkemas dan dijual dengan harga yang murah. Hal ini dilakukan untuk menghindari jus yang sudah dicampur dengan berbagai campuran zat kimia.",
                        16_000));
                drinkDao.insert(new DrinkModel(
                        "d4",
                        R.raw.jus_jeruk,
                        "Jus Jeruk",
                        "Segelas jus jeruk segar segar benar-benar sehat untuk asupan vitamin C pada tubuh. Namun, banyak yang menganggap cara membuat jus jeruk ini merupakan cara yang rumit. Jika itu masalahnya, simpanlah untuk saat yang paling praktis, seperti musim alergi. Alergi musiman telah terbukti ditenangkan dengan vitamin C dan quercetin (suatu bentuk flavonol yang ditemukan dalam buah-buahan dan sayuran tertentu), yang keduanya terkandung dalam jus jeruk segar.",
                        12_000));
                drinkDao.insert(new DrinkModel(
                        "d5",
                        R.raw.jus_kale,
                        "Jus Kale",
                        "Semua orang suka kale. Tetapi ada alasan yang tepat mengapa begitu banyak orang jatuh cinta dengan minuman sehat ini. Hijau gelap dan berdaun keriting dengan vitamin dan mineral yang dapat membantu segala hal mulai dari kesehatan tulang hingga mengatur usus kamu. Hindari membeli botol, karena variasi tersebut cenderung mengandung cukup banyak natrium. Mungkin bukan ide yang buruk untuk berinvestasi dalam juicer dan mulai membuat jus kale, dan jus sayuran lainnya di rumah.",
                        12_000));
                drinkDao.insert(new DrinkModel(
                        "d6",
                        R.raw.jus_kanberi,
                        "Jus Kanberi",
                        "Jus cranberry atau kranberi dikemas dengan antioksidan yang dapat membantu mencegah penyakit kardiovaskular dan beberapa jenis kanker, dan menjaga saluran kemih agar tetap sehat. Minuman olahan dari buah ini punya cita rasa asam sendiri, sehingga dikombinasikan dengan gula atau jus buah manis lainnya. Pastikan juga kamu mencari varietas yang 100% murni tanpa tambahan pemanis buatan atau lainnya.",
                        14_000));
                drinkDao.insert(new DrinkModel(
                        "d7",
                        R.raw.jus_lemon,
                        "Jus Lemon",
                        "Lemon memiliki kemampuan seperti membersihkan hati, merangsang produksi empedu, dan membantu pencernaan. Lemon juga dapat membawa vitamin C ke tubuh untuk meningkatkan sistem kekebalan tubuh kamu. Kamu dapat mengonsumsi jus lemon ini setiap pagi untuk mendetoks tubuh kamu agar terbebas dari radikal bebas yang membandel.",
                        16_000));
                drinkDao.insert(new DrinkModel(
                        "d8",
                        R.raw.susu_rendah_lemak,
                        "Susu Rendah Lemak",
                        "Susu merupakan minuman yang sudah sering ditemui sejak kecil. Dianggap sebagai sumber kalsium dan vitamin D yang sangat baik sejak masih kanak-kanak, susu rendah lemak dan skim juga merupakan sumber protein dan mikronutrien yang penting untuk tubuh kamu. Dan varietas rendah lemak ini adalah pilihan terbaik karena mengandung jauh lebih sedikit lemak jenuh daripada susu murni. Nah, dengan pilihan susu rendah lemak ini, kamu dapat melengkapi menu kudapan sehat setiap hari dengan susu yang sehat.",
                        10_000));
                drinkDao.insert(new DrinkModel(
                        "d9",
                        R.raw.teh_hijau,
                        "Teh Hijau",
                        "Teh hijau diakui sebagai salah satu minuman terbaik untuk pencegah kanker, tetapi tahukah kamu bahwa teh hijau juga terbukti meningkatkan fungsi arteri, sehingga mengurangi risiko penyakit kardiovaskular? Sebuah penelitian menemukan bahwa orang tua Tionghoa yang diteliti memiliki fungsi arteri orang Australia di usia 20-an! Apa rahasia mereka? Para peneliti percaya bahwa teh hijau termasuk dalam diet tradisional yang dilakukan oleh masyarakat China sejak dulu.",
                        8_000));
                drinkDao.insert(new DrinkModel(
                        "d10",
                        R.raw.teh_jahe,
                        "Teh Jahe",
                        "Jahe adalah obat alami yang sangat baik untuk semua masalah perut. Jahe telah dipromosikan sebagai cara untuk meredakan sakit perut, meringankan mabuk perjalanan dan mual terkait kehamilan, dan meringankan pencernaan. Buat secangkir teh jahe segar sendiri dengan merendam satu atau dua irisan tipis jahe segar dalam secangkir air panas. Sendok sedikit madu agar lebih halus dan menenangkan tenggorokan.",
                        8_000));
            });
        }
    };
}
