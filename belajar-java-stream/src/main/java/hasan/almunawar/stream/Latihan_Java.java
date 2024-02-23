package hasan.almunawar.stream;

import java.util.HashMap;

public class Latihan_Java {

    public static void main(String[] args) {
      //  System.out.println(pristiwaPenting(17));
    }


    static String peristiwaPenting(int tanggal) {

        if(tanggal == 1) {
            return "Pada tanggal 1 November 1945, Lazkar Hizbullah, sebuah Kelompok pemuda yang dipimpin oleh Suhud, berhasil merebut alun-alun Yogyakarta dar penjajah Belanda";
        } else if ( tanggal == 10 ) {
            return"Tanggal 10 November diperingati sebagai Hari Pahlawan untuk mengenang jasa-jasa para pejuang kemerdekaan Indonesia. Pada tanggal ini, tahun 1945, Letnan Jendral Soederman, panglima besar Tentara Indonesia, wafat";
        } else if( tanggal == 14) {
            return "Tanggal 10 November diperingati sebagai Hari Pahlawan untuk mengenang jasa-jasa para pejuang kemerdekaan Indonesia. Pada tanggal ini, tahun 1945, Letnan Jendral Soederman, panglima besar Tentara Indonesia, wafat";

        } else if(tanggal == 17) {
            return "Pada tanggal 17 November 1945, memasuki bulan Muharram tahun 1365 Hijriah, Indonesia memutuskan untuk memakai kalender Hijriah sebagai kelnder resmi";

        } else if (tanggal == 25) {
            return "Tanggal 25 November diperingati sebagai Hari Guru untuk menghormati peran guru dalam pendidikan Indonesia";

        } else if ( tanggal == 27) {
            return "Pada tanggal 27 November 1945, sebuah pesawat Dakota yang membawa deligasi Indonesia ke Konfrensi Asia-Afrika jatuh di Bukit Tinggi, Sumatera Barat";

        } else if (tanggal == 30) {
            return "Pada tanggal 30 November 1947. Serangan Umum 1 Maret (SU 1 Maret) dimulai, yang merupakan salah satu peristiwa penting dalam perang kemerdekaan Indonesia";

        } else {
            return "tidak ada peristiwa bersejarah pada tanggal tersebut";
        }



    }
}
