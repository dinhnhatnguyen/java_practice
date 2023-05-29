package Lottery;

public class nguoiChoi{
    String HoTen;
    String Diachi;
    String SoDienThoai;
    int soVe;
    int soThu1, soThu2, soThu3, soThu4, soThu5, soThu6;


    public nguoiChoi() {
        HoTen = Diachi = SoDienThoai = "";
        soVe = soThu1 = soThu2 = soThu3 = soThu4 = soThu5 = soThu6 = 0;
    }
    public nguoiChoi(String hoTen, String diachi, String soDienThoai, int soVe, int soThu1, int soThu2, int soThu3, int soThu4, int soThu5, int soThu6) {
        if (Validate(soThu1, soThu2, soThu3, soThu4, soThu5, soThu6)) {
            System.out.println("Dữ liệu không hợp lệ");
        }
        HoTen = hoTen;
        Diachi = diachi;
        SoDienThoai = soDienThoai;
        this.soVe = soVe;
        this.soThu1 = soThu1;
        this.soThu2 = soThu2;
        this.soThu3 = soThu3;
        this.soThu4 = soThu4;
        this.soThu5 = soThu5;
        this.soThu6 = soThu6;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %s, %d, %d, %d, %d, %d, %d, %d]",HoTen ,Diachi , SoDienThoai ,soVe, soThu1,soThu2,soThu3,soThu4,soThu5,soThu6);
    }

    boolean Validate(int s1, int s2, int s3, int s4, int s5, int s6) {
        int[] a = {s1, s2, s3, s4, s5, s6};
        for (int i = 0; i < 6; i++)
            for (int j = i + 1; j < 6; j++) {
                if (a[i] == a[j]) return true;
            }
        for (int i = 0; i < 6; i++)
            if (a[i] < 1 || a[i] > 45) return true;
        return false;
    }

    public boolean giaiDacBiet(int s1, int s2, int s3, int s4, int s5, int s6) {
        if (s1 == soThu1 && s2 == soThu2 && s3 == soThu3 && s4 == soThu4 && s5 == soThu5 && s6 == soThu6) {
            return true;
        }
        return false;
    }

    public boolean giaiNhat(int s1, int s2, int s3, int s4, int s5, int s6) {
        int[] a = {s1, s2, s3, s4, s5, s6};
        int[] b = {soThu1, soThu2, soThu3, soThu4, soThu5, soThu6};
        int cnt = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++) {
                if (a[i] != b[j]) cnt++;
            }
        if (cnt > 1) return false;
        return true;
    }

    public boolean giaiNhi(int s1, int s2, int s3, int s4, int s5, int s6) {
        int[] a = {s1, s2, s3, s4, s5, s6};
        int[] b = {soThu1, soThu2, soThu3, soThu4, soThu5, soThu6};
        int cnt = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++) {
                if (a[i] != b[j]) cnt++;
            }
        if (cnt > 2) return false;
        return true;
    }

    public boolean giaiBa(int s1, int s2, int s3, int s4, int s5, int s6) {
        int[] a = {s1, s2, s3, s4, s5, s6};
        int[] b = {soThu1, soThu2, soThu3, soThu4, soThu5, soThu6};
        int cnt = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++) {
                if (a[i] != b[j]) cnt++;
            }
        if (cnt > 3) return false;
        return true;
    }
}
