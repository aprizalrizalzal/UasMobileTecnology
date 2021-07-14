package com.tamanmandiri.orderfoodanddrink.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.tamanmandiri.orderfoodanddrink.R;
import com.tamanmandiri.orderfoodanddrink.dao.EatDao;
import com.tamanmandiri.orderfoodanddrink.model.EatModel;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {EatModel.class}, version = 1)
public abstract class EatRoomDatabase extends RoomDatabase {
    public abstract EatDao eatDao();

    private static volatile EatRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized EatRoomDatabase getDatabaseEat(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    EatRoomDatabase.class, "eat_database")
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
                EatDao eatDao = INSTANCE.eatDao();

                eatDao.insert(new EatModel(
                        "e1",
                        R.raw.brokoli,
                        "Brokoli",
                        "Sayur brokoli juga menjadi salah satu jenis sayuran yang rasanya tidak pahit. Selain itu, brokoli juga mengandung kalori yang rendah. Brokoli dapat diolah menjadi beragam jenis sayuran, semisal tumis brokoli atau dicampur dengan sayur lain menjadi capcai. Banyak manfaat yang bisa kamu dapat dari mengonsumsi brokoli yang kaya antioksidan ini, misalnya mencegah penyakit kanker, jantung, dan alzheimer",
                        5_000));
                eatDao.insert(new EatModel(
                        "e2",
                        R.raw.gado_gado,
                        "Gado-Gado",
                        "Nah, kalau menu makanan sehat satu ini bisa dibilang sebagai saladnya Indonesia. Cara membuatnya pun cukup mudah, kamu cukup mencampur beberapa jenis sayur, semisal tauge, wortel, kubis, mentimun, tempe, dan lain-lain. Lalu, guyurlah campuran sayur tersebu menggunakan bumbu kacang.segar, tetapi juga mengandung banyak gizi di dalamnya.",
                        8_000));
                eatDao.insert(new EatModel(
                        "e3",
                        R.raw.ikan_salmon,
                        "Ikan Salmon",
                        "Ikan salmon menjadi salah satu menu makanan diet sehat yang harus kamu coba. Olahan ikan salmon mengandung protein, vitamin B, lemak sehat, kalium, dan selenium yang bermanfaat untuk kesehatan tubuh. Selain menurunkan berat badan, mengonsumsi ikan salmon secara teratur dapat menurunkan risiko sakit jantung dan diabetes.",
                        10_000));
                eatDao.insert(new EatModel(
                        "e4",
                        R.raw.oatmeal,
                        "Oatmel",
                        "Oatmeal adalah salah satu makanan superfood yang biasa disantap ketika sarapan. Kandungan serat yang tinggi dalam oatmeal sangat baik untuk sistem pencernaan. Makanan ini juga bisa membuat kamu merasa kenyang lebih lama, sehingga konsumsi makanan sepanjang hari dapat lebih terjaga. Sajikan oatmeal dengan susu dan madu untuk menambah rasa manis alami, atau bisa juga diolah menjadi snack seperti granola bar, cookies, dan lain-lain.",
                        18_000));
                eatDao.insert(new EatModel(
                        "e5",
                        R.raw.pepes_ikan,
                        "Pepes Ikan",
                        "Pepes ikan adalah salah satu contoh menu makanan sehat yang menggabungkan gizi dari ikan dan sayur-sayuran. Kandungan asam lemak omega 3 pada ikan dipercaya dapat membantu mencegah penyakit jantung. Santapan ini terasa lebih nikmat jika kita memakannya dengan lalap sayur yang menyegarkan.",
                        15_000));
                eatDao.insert(new EatModel(
                        "e6",
                        R.raw.roti_bakar_alpukat,
                        "Roti Bakar Alpukat",
                        "Apakah kamu pernah mencoba mencampurkan roti bakar dengan telur dan alpukat? Cobain deh, karena telur dan alpukat yang dilapisi roti bakar bisa jadi alternatif menu makanan diet sehat di pagi hari. Alpukat yang kaya vitamin ditambah protein dalam telur dapat membuat kamu lebih bugar dalam menjalani aktivitas sehari-hari.",
                        6_000));
                eatDao.insert(new EatModel(
                        "e7",
                        R.raw.sandwich,
                        "Sandwich",
                        "Sama halnya dengan roti bakar, sandwich juga menjadi menu sarapan sehat. Tentu sangat nikmat menyantap selada, mentimun, tomat, keju, dan daging di dalam dua lapis roti sebelum berangkat kerja. Kandungan antioksidan pada sayur dan protein pada daging dapat menjadi sumber energi kamu menjalani rutinitas.",
                        12_000));
                eatDao.insert(new EatModel(
                        "e8",
                        R.raw.sop_bening,
                        "Sop Bening",
                        "Satu lagi menu campuran sayuran yang menyehatkan tubuh adalah sop bening. Makanan ini tentu sangat nikmat dikonsumi pada malam hari yang dingin. Sayuran dalam sop dapat membantu tubuh kamu lebih bugar dan sehat. Selain itu, jangan lupakan kandungan protein dalam daging di sop tersebut yang bisa membuat kamu meningkatkan kekebalan tubuh.",
                        5_000));
                eatDao.insert(new EatModel(
                        "e9",
                        R.raw.steak_salad,
                        "Steak Salad",
                        "Steak salad adalah menu sehat sehari yang mirip dengan salad. Perbedaannya, salah satu ini ditambah dengan sajian daging steak. Karena ada bahan yang ditambah, maka manfaatnya juga bertambah. Kandungan protein dan zat besi dalam daging sapi dapat membantu kamu meningkatkan kekebalan tubuh dan kekuatan otot.",
                        15_000));
                eatDao.insert(new EatModel(
                        "e10",
                        R.raw.telur,
                        "Telur",
                        "Bahan makanan yang sudah biasa dikonsumsi sehari-hari ini ternyata memiliki banyak nutrisi yang sangat baik untuk tubuh lho, Toppers. Kandungan dalam kuning telur dapat menjaga kesehatan mata dan melindungi kulit dari kerusakan karena terpapar sinar UV. Kamu bisa mengkonsumsi telur dengan cara apapun sesuai dengan selera, tetapi jika ingin benar-benar sehat, disarankan untuk menyajikan telur rebus atau kukus.",
                        5_000));
            });
        }
    };
}
