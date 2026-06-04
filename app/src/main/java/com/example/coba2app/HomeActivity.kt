package com.example.coba2app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coba2app.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerViewBerita: RecyclerView
    private lateinit var beritaAdapter: BeritaAdapter


    private lateinit var binding: ActivityHomeBinding

    private val listBerita = listOf(
        Berita(
            "Kerusuhan Usai Laga Persipura, Polda Papua Tangkap 32 Orang, 9 Berpotensi Tersangka",
            R.drawable.berita1,
            "JAYAPURA, Papua.com – Polda Papua terus melakukan langkah penegakan hukum terkait kerusuhan usai pertandingan sepak bola antara Persipura Jayapura melawan Adhyaksa FC yang berlangsung di Stadion Lukas Enembe pada Jumat (8/5/2026) lalu. Dari langkah penegakkan hukum yang dilakukan, polisi menangkap 32 orang yang diduga kuat terlibat dalam kerusuhan di Stadion Lukas Enembe. “Dari 32 orang yang diperiksa, 9 orang berpotensi menjadi tersangka karena telah memenuhi dua alat bukti. Sedangkan untuk 23 orang lainnya dipulangkan dan dikenakan wajib lapor,” kata Kabid Humas Polda Papua, Kombes Pol Cahyo Sukarnito pada Senin (11/5/2026) malam. Baca juga: Manajer Persipura Sebut Kericuhan Stadion Lukas Enembe Sudah Direncanakan \"9 orang tersebut diduga melakukan aksi pelemparan terhadap petugas, penganiayaan, perusakan kendaraan, hingga penjarahan,\" terangnya.\n" +
                    "\n" +
                    "Cahyo menyebutkan, hingga saat ini penyidik telah menerima sebanyak 28 laporan polisi terkait berbagai tindak pidana yang terjadi dalam insiden tersebut.\n" +
                    "\n" +
                    "Dari total 28 laporan polisi yang diterima, kasus yang ditangani meliputi pencurian kendaraan bermotor, pembakaran kendaraan, perusakan hingga pengeroyokan. \"Laporan tersebut terdiri dari 16 kasus curanmor, 8 kasus pembakaran kendaraan, 1 kasus perusakan, 1 kasus pengeroyokan, dan 1 kasus pencurian telepon genggam,\" ungkap Kombes Cahyo.\n" +
                    "\n" +
                    "Lebih lanjut, kata Kombes Cahyo, dampak kerusuhan tidak menyebabkan korban jiwa. Namun, terdapat korban luka dari masyarakat sebanyak satu orang dan anggota Polri sebanyak 10 personel. Sementara kerugian material meliputi 16 bangunan, 11 kendaraan roda dua, dan 21 kendaraan roda empat yang mengalami kerusakan maupun pembakaran. \"Dalam proses penyelidikan dan pengembangan kasus, aparat kepolisian juga berhasil mengamankan barang bukti berupa 35 unit kendaraan roda dua hasil dugaan penjarahan,\" bebernya. Saat ini, penyidik masih terus melakukan pengembangan melalui pengumpulan rekaman video, profiling pelaku, pemeriksaan saksi dan terduga pelaku, serta koordinasi dengan Jaksa Penuntut Umum guna melengkapi proses penyidikan.\n" +
                    "“Kami mengimbau kepada seluruh masyarakat agar tetap menjaga situasi kamtibmas yang kondusif dan tidak mudah terprovokasi. Polda Papua akan menindak tegas setiap pelaku tindak pidana sesuai aturan hukum yang berlaku,” tegas Kombes Cahyo. Polda Papua memastikan proses penegakan hukum akan dilakukan secara profesional, transparan, dan berkeadilan terhadap seluruh pihak yang terlibat dalam insiden tersebut.\n"
        ),
        Berita(
            "Dari Kanjuruhan ke Jayapura: Sepak Bola Indonesia dan Pengawasan FIFA",
            R.drawable.berita2,
            "Papua.com, TIGA setengah tahun setelah Tragedi Kanjuruhan, sepak bola Indonesia kembali dipertontonkan pada kenyataan pahit yang sama.\n" +
            "Stadion yang seharusnya menjadi panggung hiburan publik justru berubah menjadi arena kekerasan.\n" +
            "Pada Jumat (8/5/2026) malam, Stadion Lukas Enembe di Kabupaten Jayapura menjadi saksi kerusuhan setelah Persipura Jayapura kalah 0-1 dari Adhyaksa FC dalam laga play-off promosi Championship 2025/2026.\n" +
            "Kekalahan itu memastikan Mutiara Hitam gagal promosi ke Super League.\n" +
            "Kekecewaan tidak disalurkan secara elegan. Sejumlah oknum suporter masuk ke lapangan, merusak kursi pemain hingga monitor VAR, kemudian meluapkan amarah ke luar stadion dengan melempari petugas keamanan dan membakar kendaraan.\n" +
            "Polda Papua mengamankan 14 orang. Puluhan kendaraan rusak. Fasilitas stadion hancur dan korban luka berjatuhan.\n" +
            "Manajer Persipura Owen Rahadiyan mengklaim kerusuhan ini bukan ulah suporter klubnya.\n" +
            "Menurutnya, ada oknum luar yang memanfaatkan momentum pertandingan untuk melakukan aksi anarkistis. Penyelidikan polisi masih berjalan. \n" +
            "Terlepas dari siapa pelakunya, insiden ini kembali memperlihatkan persoalan lama yang belum benar-benar terselesaikan dalam sepak bola Indonesia.\n" +
            "Secara hukum, pelaku kekerasan yang dilakukan secara bersama-sama di muka umum dapat dijerat Pasal 262 UU No. 1 Tahun 2023 (KUHP), dengan ancaman pidana penjara mulai dari 5 tahun hingga 12 tahun, tergantung pada akibat yang ditimbulkan.\n" +
            "Pelaku juga dapat diwajibkan membayar ganti rugi berdasarkan Pasal 66 ayat (1) huruf d KUHP.\n" +
            "Sementara itu, pelaku yang merusak atau membakar kendaraan maupun fasilitas stadion berpotensi dijerat Pasal 521 KUHP dengan ancaman pidana penjara paling lama 2 tahun 6 bulan atau denda paling banyak Rp 200 juta.\n" +
            "Tanggung jawab hukum tidak berhenti pada pelaku individual. UU No. 11 Tahun 2022 tentang Keolahragaan, khususnya Pasal 52, mewajibkan penyelenggara menjamin keselamatan dan keamanan penonton. \n" +
            "FIFA Stadium Safety and Security Regulations juga mewajibkan klub tuan rumah menyusun rencana pengamanan yang komprehensif sebelum pertandingan digelar.\n" +
            "Artinya, jika terbukti ada kelalaian dalam perencanaan dan pelaksanaan keamanan, Persipura sebagai tuan rumah berpotensi ikut menanggung tanggung jawab, terlepas dari siapa yang memulai kerusuhan.\n"
        ),
        Berita(
            "Papua Tanpa Wakil di Super League: Persipura Gagal, PSBS Degradasi",
            R.drawable.berita3,
            "JAYAPURA, Papua.com — Persipura Jayapura gagal promosi ke Super League setelah kalah 0-1 dari Adhyaksa FC Banten dalam laga play-off promosi Championship 2 musim 2025-2026 di Stadion Lukas Enembe, Kabupaten Jayapura, Papua, Jumat (8/5/2026). Tim berjuluk Mutiara Hitam itu menjadi satu-satunya wakil Papua yang diharapkan kembali promosi ke kasta tertinggi sepak bola Indonesia melalui laga play-off tersebut. Namun, langkah Persipura harus terhenti setelah Adhyaksa FC mencetak gol tunggal lewat penyerangnya, Adilson Silva, pada masa injury time babak pertama.\n" +
            "Gol tersebut sempat diprotes pemain Persipura karena Adilson diduga berada dalam posisi offside. Meski demikian, wasit tetap mengesahkan gol tersebut.\n" +
            "\n" +
            "Gol Adilson Silva membawa tim berjuluk Sang Jaksa itu meraih satu tiket terakhir promosi ke Super League musim 2026/2027.\n" +
            "Sementara itu, Persipura harus kembali bertahan di Liga Pegadaian Championship 2 untuk musim 2026/2027. PSBS Biak Terdegradasi Tak hanya Persipura, wakil Papua lainnya, PSBS Biak, juga dipastikan turun kasta ke Liga Pegadaian Championship 2 musim depan. PSBS Biak resmi terdegradasi setelah kalah telak 0-4 dari Persebaya Surabaya pada Sabtu (2/5/2026). Kekalahan itu membuat PSBS tidak memiliki poin cukup untuk keluar dari zona degradasi. Tim berjuluk Badai Pasifik itu menjadi tim pertama yang dipastikan terdegradasi dari Super League musim 2025/2026.\n" +
            "\n" +
            "Pada pertandingan berikutnya melawan Dewa United di Stadion Cenderawasih, Jumat (8/5/2026), PSBS kembali kalah dengan skor 0-5. Hasil tersebut membuat PSBS Biak berada di posisi ke-18 klasemen sementara dengan koleksi 18 poin dari 32 pertandingan. Dengan demikian, Persipura Jayapura dan PSBS Biak akan kembali berkompetisi di Liga Pegadaian Championship 2 musim 2026/2027 wilayah timur.\n" +
            "\n" +
            "Adapun tiga tim yang berhasil promosi ke Super League musim 2026/2027 yakni Garudayaksa FC dari wilayah barat, PSS Sleman dari wilayah timur, dan Adhyaksa FC Banten. Adhyaksa FC memastikan tiket promosi terakhir usai mengalahkan Persipura Jayapura 1-0 dalam laga play-off di Stadion Lukas Enembe.\n"
        ),
        Berita(
            "Satu Darah Indonesia: Dari Jayapura ke Tribune Kebangsaan",
            R.drawable.berita4,
            "Papua.com, KERUSUHAN di Stadion Lukas Enembe, Jayapura, seusai laga Persipura Jayapura melawan Adhyaksa FC pada 8 Mei 2026 bukan sekadar ledakan emosi akibat kekalahan tim kesayangan. Mobil dibakar, fasilitas stadion dirusak, dan kemarahan massa meluas setelah Persipura gagal kembali ke Liga 1 yang merupakan kasta tertinggi sepak bola nasional. Namun, di balik kekacauan itu, tersimpan persoalan yang jauh lebih besar: sepak bola Indonesia sedang memperlihatkan retakan sosial yang selama ini tersembunyi di balik euforia tribune. Di Papua, Persipura bukan sekadar klub sepak bola. Ia adalah simbol harga diri sosial, identitas kolektif, dan kebanggaan masyarakat.\n" +
            "Karena itu, kekalahan tidak pernah dipahami semata sebagai hasil pertandingan, melainkan luka sosial yang menyentuh rasa memiliki sebuah komunitas.\n" +
            "\n" +
            "Gary Armstrong dan Richard Giulianotti dalam Fear and Loathing in World Football (2001) menjelaskan,  sepak bola modern merupakan arena produksi identitas kolektif paling kuat dalam masyarakat kontemporer. Loyalitas terhadap klub bahkan kerap melampaui institusi sosial lain karena sepak bola bekerja melalui emosi paling mendasar manusia: rasa memiliki. Namun ironisnya, sepak bola juga memperlihatkan wajah Indonesia yang lain. Ketika Persib, Persija, Persebaya, Arema, PSM, atau Persipura bertanding dalam kompetisi domestik, rivalitas justru kerap menjadi wajah utama kompetisi nasional. Tribune dipenuhi nyanyian fanatik, media sosial dibanjiri pertikaian emosional, dan identitas kedaerahan seolah menjadi batas yang sulit ditembus. Akan tetapi, semua sekat itu mendadak runtuh ketika Tim Nasional Indonesia bermain. Ribuan orang berdiri bersama menyanyikan “Indonesia Raya”, mengibarkan Merah Putih, dan larut dalam satu identitas yang sama: Indonesia. Di titik itulah sepak bola memperlihatkan kekuatan sosial dan politiknya yang paling besar. Benedict Anderson dalam Imagined Communities (2006) menyebut bangsa sebagai imagined community—komunitas politik yang dibayangkan bersama. Bangsa tidak lahir karena seluruh warganya saling mengenal, melainkan karena mereka merasa memiliki nasib dan identitas kolektif yang sama.\n" +
            "Dalam konteks Indonesia, sepak bola menjadi medium paling nyata bagi lahirnya imajinasi kebangsaan tersebut.\n" +
            "Ketika Tim Nasional bermain, jutaan orang dari Aceh hingga Papua mengalami emosi kolektif yang sama sebagai sesama warga bangsa Indonesia. Stadion sebagai Arena Solidaritas Andy Fuller (2015) menjelaskan bahwa sepak bola telah mengakar kuat dalam kehidupan sosial masyarakat Indonesia. Klub sepak bola bukan sekadar institusi olahraga, melainkan simbol identitas kota, solidaritas sosial, dan kebanggaan kolektif. Di tribune stadion, masyarakat menemukan ruang tempat mereka merasa setara dan menjadi bagian dari komunitas yang lebih besar daripada dirinya sendiri\n" +
            "\n" +
            "Buruh, mahasiswa, pedagang, pejabat, hingga pengangguran berdiri berdampingan meneriakkan dukungan yang sama. Namun justru karena itulah sepak bola sangat rentan terhadap ledakan konflik. Kukuh Wahyudin Pratama (2021) menjelaskan, konflik sepak bola Indonesia tidak lahir semata dari perilaku suporter.\n"
        ),
        Berita(
            "Championship Liga 2 Berakhir, Skuad Persipura Resmi Dibubarkan",
            R.drawable.berita5,
            "Papua.com - Skuad Persipura Jayapura untuk Championship Liga 2 2025-2026 resmi dibubarkan oleh manajemen melalui acara internal yang berlangsung di Hotel Horison Kotaraja, Kota Jayapura, Papua, Minggu (10/5/2026). Manajer Persipura, Owen Rahadiyan, mengungkapkan bahwa pembubaran skuad Persipura, karena kompetisi Championship Liga 2 2025-2026 telah berakhir. Para pemain dan tim ofisial pelatih akan kembali ke daerah asalnya masing-masing.\n" +
            "\n" +
            "“Kompetisi Liga 2 sudah selesai, sehingga kami dari Manajemen Persipura resmi membubarkan pemain untuk kembali ke kampung halamannya masing-masing,” ungkapnya.\n" +
            "Owen mengucapkan terima kasih kepada seluruh pemain Persipura yang telah berjuang keras dan menunjukkan semangat luar biasa di Liga 2 musim ini. “Kami juga menyampaikan terima kasih kepada tim pelatih, tim ofisial Persipura serta panitia penyelenggara yang memberikan dukungan penuh selama kompetisi Liga 2 Championship yang dilakoni oleh Persipura,” ucapnya.\n" +
            "\n" +
            "Dalam suasana itu, Owen menyampaikan terima kasih kepada Pemerintah Provinsi Papua, Pemerintah Kota Jayapura dan seluruh kepala daerah yang ada di tanah Papua yang sudah memberikan dukungan kepada tim kebanggaan masyarakat Papua, Persipura selama musim ini. “Dalam momentum ini kami ingin menyampaikan terima kasih kepada seluruh masyarakat Papua yang telah memberikan dukungan penuh terhadap tim Persipura selama kompetisi Liga 2,” ujarnya. Optimis Persipura akan Bangkit Musim Depan Meskipun gagal meraih tiket ke Liga 1 Super League, mantan Manajer PSBS Biak ini tetap memberikan optimisme bahwa tim berjuluk Mutiara Hitam ini akan bangkit kembali untuk berjuang pada kompetisi Championship Liga 2 2026-2027.\n" +
            "\n" +
            "“Ini bukan akhir dari perjalanan Persipura. Kami optimis Persipura akan bangkit dan kembali berjuang lebih kuat di musim mendatang,” ungkapnya.\n" +
            "\n" +
            "Kegagalan meraih tiket di Liga Super League memang menjadi sebuah kekecewaan besar bagi seluruh masyarakat Papua. Namun, pihak manajemen Persipura akan melakukan pembenahan, sehingga bisa menghadapi kompetisi musim depan. “Saya tetap yakin, Persipura akan kembali ke kasta tertinggi sepak bola Indonesia sesuai harapan besar masyarakat Papua,” ucapnya.\n" +
            "\n" +
            "“Saya juga menyampaikan permohonan maaf kepada seluruh masyarakat Papua, karena Persipura gagal meraih tiket untuk promosi kembali ke Liga Super League,” tutupnya. Persipura sendiri gagal meraih tiket promosi ke Super League setelah kalah 0-1 dalam laga play off melawan Adhyaksa FC Banten dalam lanjutan Liga 2 Championship perebutan satu tiket promosi ke Super League di Stadion Lukas Enembe, Kabupaten Jayapura, Papua, Jumat (8/5/2026). Kekalahan yang dialami Persipura ini sempat membuat kericuhan terjadi di Stadion Lukas Enembe usai pertandingan berakhir. Suporter kecewa atas kepemimpinan wasit yang memimpin laga tersebut.\n"
        ),
        Berita(
            "Rusuh di Jayapura dan Flare di Sleman, Aturan Suporter Away Tetap Berlanjut?",
            R.drawable.berita6,
            "Papua.com - Sekretaris Jenderal PSSI, Yunus Nusi, menegaskan federasi hingga saat ini masih belum mencabut larangan suporter away atau menghadiri laga tandang. Namun, dia menunggu laporan penyelenggaraan liga secara keseluruhan dari I.League selaku operator kompetisi sepak bola nasional untuk mengkaji apakah peraturan tersebut perlu dicabut atau diperpanjang pada kompetisi musim depan. Terhitung sejak terjadinya Tragedi Kanjuruhan pada Oktober 2022 silam, sampai sekarang PSSI masih terus memberlakukan aturan larangan suporter tim tamu untuk hadir langsung ke stadion. Kebijakan tersebut merupakan bagian dari transformasi sepak bola Indonesia yang sejalan dengan arahan yang diterima dari FIFA terkait tata kelola pertandingan.\n" +
            "\n" +
            "Bahkan, regulasi Super League 2025-2026 mengatur secara spesifik mengenai aturan suporter tim tamu.\n" +
            "\n" +
            "Pada Pasal 5 ayat 7, disebutkan bahwa pada masa transisi transformasi sepak bola nasional, seluruh pertandingan sepak bola nasional, termasuk kompetisi, tidak dapat dihadiri oleh suporter klub tamu. \n" +
            "\n" +
            "Regulasi ini juga menegaskan bahwa klub terkait akan bertanggung jawab penuh atas kehadiran suporter mereka jika larangan tersebut dilanggar. Selanjutnya, Pasal 5 ayat 8 memberikan mandat kepada Panitia Pelaksana (Panpel) Pertandingan.  Panpel diwajibkan untuk mengambil langkah-langkah antisipasi atas potensi kehadiran suporter klub tamu, serta harus mempersiapkan rencana keselamatan dan keamanan yang merujuk pada Regulasi Keselamatan dan Keamanan PSSI 2021. Namun, pada Super League musim ini, terdapat sejumlah pertandingan yang tampak dihadiri oleh para suporter tim tamu walaupun pada akhirnya tim yang bersangkutan akan menerima sanksi berupa denda dari Komite Disiplin (Komdis) PSSI.\n" +
            "\n" +
            "Jawaban I.League Lantas, apakah aturan tersebut akan tetap diterapkan pada musim depan?  Merespons pernyataan tersebut, Sekjen PSSI, Yunus Nusi, mengaku masih belum bisa memastikan. Federasi masih menunggu laporan lengkap dari I.League sebelum mengambil keputusan mengenai aturan tersebut. \"Yang jelas sampai dengan saat ini PSSI belum mencabut larangan tersebut dan kita minta kepada PT LIB untuk sesegera juga menyampaikan laporan tentang bagaimana perkembangan yang terjadi saat ini pada proses penyelenggaraan I.League, Championship mulai dari awal sampai akhir,\" kata Yunus Nusi kepada awak media selepas final Championship 2025-2026 di Stadion Maguwoharjo, Sleman, Sabtu (9/5/2026).\n" +
            "\n" +
            "\"Kita lihat perkembangannya seperti apa, I.League juga menyampaikan laporan kepada PSSI dan tentu Ketua Umum juga Komite Eksekutif akan mengkaji itu apakah layak atau tidak untuk dibuka suporter kandang dan tandang,\" tutur dia. Laga di Championship Ikut Jadi Bahan Pertimbangan Sejumlah peristiwa yang terjadi di playoff dan final Championship Liga 2 2025-2026 juga akan menjadi bahan pertimbangan dalam pembahasan mengenai aturan tersebut. Mulai dari ricuh pasca-kekalahan Persipura Jayapura pada laga playoff promosi kontra Adhyaksa FC Banten dan adanya \"pesta\" flare setelah PSS Sleman kalah dari Garudayaksa FC di partai puncak. \n" +
            "Seluruh hasil pembahasan nantinya akan diutarakan kepada FIFA sebagai bahan pertimbangan apakah larangan suporter tim tamu tetap berlanjut atau dihapuskan. \"Makanya kita setelah ini selesai Championship, I.League menyampaikan laporan, PSSI juga akan menyampaikan kepada FIFA tentang perkembangan mulai dari A sampai Z kejadian, termasuk terakhir kejadian yang terjadi di Jayapura usai laga Persipura,\" ungkap Yunus Nusi.\n"
        ),
        Berita(
            "PSSI Ingatkan Indonesia Masih Diawasi FIFA Usai Insiden Kerusuhan dan \"Pesta\" Flare",
            R.drawable.berita7,
            "Papua.com - Sekretaris Jenderal PSSI, Yunus Nusi, memberikan peringatan keras bahwa posisi sepak bola Indonesia saat ini masih berada di bawah pemantauan ketat FIFA. Hal ini menyusul rentetan insiden yang terjadi pada pengujung kompetisi kasta kedua, termasuk kerusuhan suporter dan penyalaan suar (flare) di dalam stadion. Peringatan dari PSSI ini muncul setelah adanya aksi penyalaan flare secara masif dalam laga final Championship Liga 2 2025-2026 di Stadion Maguwoharjo, Sleman, Sabtu (9/5/2026). Pertandingan tersebut berakhir dengan kemenangan Garudayaksa FC atas PSS Sleman melalui drama adu penalti dengan skor 4-3, setelah bermain imbang 2-2 hingga babak tambahan waktu.\n" +
            "\n" +
            "Yunus Nusi menekankan pentingnya sikap dewasa dari para pendukung dalam menyikapi hasil pertandingan.\n" +
            "Ia mengingatkan bahwa sanksi atau pengawasan dari federasi sepak bola dunia masih berlaku sejak tragedi besar pada Oktober 2022 silam. \"Dan ada reaksi setelah pertandingan, kita juga berharap semoga ini tidak terulang lagi,\" ujar Yunus dikutip dari Antara, Minggu (10//5/2026). \"Dan tentu juga perlahan-lahan kita berharap kawan-kawan suporter untuk selalu dewasa menerima kemenangan, kekalahan, dan kemudian meluapkan kemenangan dan atau kekalahannya.\"\n" +
            "\n" +
            "Ia menambahkan bahwa sportivitas adalah kunci agar sepak bola tanah air bisa terus berkembang. \"Kita ingat masih dalam pengawasan FIFA, kita berharap sepak bola ke depan berjalan dengan baik tentu tidak terlepas dari sportivitas, elegan yang diberikan oleh suporter masing-masing klub kepada sepak bola Indonesia dan atau kepada timnya,\" tambahnya. Kericuhan di Jayapura Jadi Catatan Merah Selain pesta flare di Sleman, dunia sepak bola nasional juga dikejutkan dengan kerusuhan hebat di Stadion Lukas Enembe, Jayapura, pada Jumat (8/5/2026).\n" +
            "\n" +
            "Insiden terjadi saat Persipura Jayapura dipastikan gagal promosi ke kasta tertinggi setelah ditumbangkan oleh Adhyaksa FC dengan skor 0-1\n" +
            "\n" +
            "Ribuan suporter tim Mutiara Hitam yang kecewa meluapkan kemarahan dengan masuk ke lapangan, merusak fasilitas stadion, hingga melakukan pembakaran kendaraan. Kejadian ini menjadi noda dalam penyelenggaraan Championship musim ini dan menjadi perhatian serius federasi.\n"
        ),
        Berita(
            "Daftar Lengkap Penghargaan Championship Liga 2 2025-2026",
            R.drawable.berita8,
            "Papua.com - Kompetisi kasta kedua Liga Indonesia atau yang dikenal dengan Championship Liga 2 2025-2026 telah menutup musimnya pada Sabtu (9/5/2026). Rangkaian pertandingan Championship Liga 2 2025-2026 ditutup dengan laga grand final PSS Sleman vs Garudayaksa FC yang bergulir di Stadion Maguwoharjo, Sleman. Duel tersebut berakhir dengan kemenangan Garudayaksa lewat drama adu penalti yang berkesudahan 4-3 setelah bermain imbang 2-2 selama 120 menit. Kemenangan ini juga membuat Garudayaksa mencetak sejarah setelah mengukir namanya sebagai juara Liga 2 musim ini.\n" +
            "\n" +
            "Selepas pertandingan, I.League selaku operator kompetisi tak serta-merta menutup kompetisi ini begitu saja.\n" +
            "\n" +
            "Mereka sekaligus merilis daftar penghargaan baik untuk individu maupun secara tim. Penghargaan individu paling bergengsi, yakni Pemain Terbaik, jatuh kepada bomber PSS Sleman, Gustavo Tocantins. Bomber asal Brasil menunjukkan kelasnya dengan hampir membawa Laskar Super Elang Jawa juara Championship setelah mencetak brace yang memaksa laga final berlanjut hingga babak adu penalti. Namun, Dewi Fortuna belum berpihak pada Tocantins setelah performanya menjadi antiklimaks usai tendangannya dari titik putih gagal menggetarkan gawang Yoewanto Beny yang sekaligus memastikan gelar juara jatuh ke Garudayaksa. Kendati demikian, kontribusinya kepada tim di sepanjang musim ini terbilang luar biasa dengan torehan 24 gol dan 10 assists.\n" +
            "\n" +
            "Koleksi gol Tocantins hanya kalah dari penyerang Adhyaksa FC Banten, Adilson Silva, yang mengoleksi 26 gol sekaligus memastikan diri menjadi Top Skor Championship musim ini.\n" +
            "\n" +
            "Selain itu, penghargaan Pemain Muda Terbaik jatuh kepada Ikram Algiffari. Sebagai penjaga gawang FC Bekasi City, dia berhasil menyelamatkan 85 persen dari 98 tendangan on target yang dihadapinya sepanjang musim. Lalu, penghargaan Pelatih Terbaik dibawa pulang oleh juru taktik Adhyaksa FC Banten, Ade Suhendra. Kemudian, Persipura Jayapura meraih penghargaan sebagai tim Fair Play setelah hanya mencatatkan 50 kartu kuning dan 3 kartu merah sepanjang musim 2025-2026. Sayangnya, tim Mutiara Hitam gagal promosi ke kasta tertinggi setelah kalah dari Adhyaksa FC dengan skor 0-1 pada laga playoff promosi.\n"
        ),
        Berita(
            "14 Orang Diamankan Usai Kericuhan Pascalaga Persipura Vs Adhyaksa FC",
            R.drawable.berita9,
            "JAYAPURA, Papua.com - Polisi mengamankan 14 orang yang diduga terlibat dalam kericuhan pasca pertandingan playoff Persipura Jayapura kontra Adhyaksa FC, Sabtu (9/5/2026) dini hari. \"Tadi malam ada 14 orang yang diamankan karena diduga terlibat dalam kericuhan. Saat ini mereka masih ada di Polres Jayapura untuk dimintai keterangan,\" kata Kabid Humas Polda Papua, Kombes Pol Cahyo Sukarnito, Sabtu. \"Pada prinsipnya kita tetap akan melakukan upaya penegakan hukum terhadap para pelaku yang menyebabkan kericuhan. Baik yang memprovokasi maupun yang terlibat langsung dalam pembakaran kendaraan,\" imbuhnya.\n" +
            "\n" +
            "Akibat kerusuhan semalam, 10 anggota polisi terluka akibat dilempar massa sehingga harus mendapatkan perawatan medis. \"Dampak ricuh ada 10 personel kita yang terluka termasuk Kapolres Jayapura. Dari jumlah itu 9 orang rawat jalan sementara satu anggota masih di rumah sakit,\" kata dia.\n" +
            "\n" +
            "\"Sementara untuk korban dari warga sipil ada 1 orang dan masih menjalani perawatan karena luka cukup serius,\" sambungnya. Selain korban luka, ricuh juga menyebabkan 25 mobil dan 8 motor dibakar, 27 motor hilang dan sejumlah fasilitas seperti pagar pembatas, pos jaga dirusak massa.\n" +
            "\n" +
            "\"Kendaraan roda empat yang dibakar dan dirusak ada 25, kemudian kendaraan roda enam yang dibakar ada 3 unit dan sekitar 27 motor hilang,\" bebernya.\n"
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val beritaAdapter = BeritaAdapter(listBerita) { berita ->
            val intent = Intent(this, DetailBeritaActivity::class.java)
            intent.putExtra(DetailBeritaActivity.EXTRA_BERITA, berita)
            startActivity(intent)
        }

        binding.recyclerViewBerita.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = beritaAdapter
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener{menuItem->
            when(menuItem.itemId){
                R.id.nav_home->{
                    Toast.makeText(this,"home click", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_search->{
                    Toast.makeText(this,"search click", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_favorite->{
                    Toast.makeText(this,"favorite click", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_logout->{
                    FirebaseAuth.getInstance().signOut()
                    Intent(this, LoginActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
//                    Toast.makeText(this,"favorite click", Toast.LENGTH_SHORT).show()
//                    true
                }
//                else -> false
            }
            return@setOnItemSelectedListener true
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.menu_setting -> {
                Toast.makeText(this, "Menu Setting dipilih", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.menu_help -> {
                Toast.makeText(this, "Menu Help dipilih", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.menu_about -> {
                Toast.makeText(this, "Menu About dipilih", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }



}