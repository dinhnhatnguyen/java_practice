package Lottery;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

/*
        MÔ TẢ CHƯƠNG TRÌNH
        - Chương trình này thực hiện việc đọc thông tin người chơi và số dự thưởng từ các file đầu vào (input1.txt và input2.txt),
          sau đó tính toán số tiền thưởng và ghi danh sách trúng thưởng vào file đầu ra (output.txt).

        - Phương thức getNumbers() đọc các số dự thưởng từ file input1.txt và trả về một danh sách các số.

        - Phương thức getInFor() đọc thông tin người chơi từ file input2.txt và trả về một danh sách các đối tượng nguoiChoi chứa thông tin của từng người chơi.

        - Phương thức checkGiaiThuong() kiểm tra giải thưởng của mỗi người chơi dựa trên số dự thưởng và số vé của người chơi.

        - Phương thức tienThuong() tính toán tiền thưởng của mỗi người chơi dựa trên kết quả kiểm tra giải thưởng và số vé của người chơi.

        - Phương thức danhSachTrungThuong() ghi danh sách trúng thưởng của mỗi người chơi và số tiền thưởng vào file output.txt.
 */
public class Main {
    public static void main(String[] args)
    {
        // Lấy thông tin người chơi và số dự thưởng từ các file input
        ArrayList<nguoiChoi> nc = getInFor();// Lấy thông tin người chơi từ file input2.txt
        ArrayList<Integer> a = getNumbers(); // Lấy số dự thưởng từ file input1.txt
        // Tính toán và lưu danh sách trúng thưởng vào file output.txt
        danhSachTrungThuong(nc,tienThuong(nc));
    }


    // Phương thức đọc số dự thưởng từ file input1.txt
    public static ArrayList<Integer> getNumbers() {
        ArrayList<Integer> a = new ArrayList<>();
        File f = new File("/Users/nhatnguyendinh/IdeaProjects/java_review/src/Lottery/input1.txt");
        try {
            BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            String line = null;
            while (true)
            {
                line = br.readLine();
                if(line==null)
                {
                    break;
                }else
                {
                    a.add(Integer.parseInt(line));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return  a;
    }

    // Phương thức đọc thông tin người chơi từ file input2.txt
    public static ArrayList <nguoiChoi> getInFor()
    {
        ArrayList<nguoiChoi> Player = new ArrayList<>();
        File f = new File("/Users/nhatnguyendinh/IdeaProjects/java_review/src/Lottery/input2.txt");
        try{
            BufferedReader br = Files.newBufferedReader(f.toPath(),StandardCharsets.UTF_8);
            String line = null;
            while (true)
            {
                line = br.readLine();
                if(line==null)
                {
                    break;
                }else
                {
                    String [] slice = line.split(", ");

                   nguoiChoi tmp  = new nguoiChoi();
                   tmp.HoTen = slice[0];
                   tmp.Diachi = slice[1];
                   tmp.SoDienThoai = slice[2];
                   tmp.soVe = Integer.parseInt(slice[3]);
                   tmp.soThu1 = Integer.parseInt(slice[4]);
                   tmp.soThu2 = Integer.parseInt(slice[5]);
                   tmp.soThu3 = Integer.parseInt(slice[6]);
                   tmp.soThu4 = Integer.parseInt(slice[7]);
                   tmp.soThu5 = Integer.parseInt(slice[8]);
                   tmp.soThu6 = Integer.parseInt(slice[9]);
                   Player.add(tmp);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Player;
    }

    // Kiểm tra giải thưởng của người chơi
    static  int checkGiaiThuong(nguoiChoi nc,int s1, int s2, int s3, int s4, int s5, int s6)
    {

        if(nc.giaiDacBiet(s1, s2, s3, s4, s5, s6)) return 6; // giải đặc biệt
        if(nc.giaiNhat(s1, s2, s3, s4, s5, s6)) return 1; // giải nhẩt
        if(nc.giaiNhi(s1, s2, s3, s4, s5, s6)) return 2;// giải nhì
        if(nc.giaiBa(s1, s2, s3, s4, s5, s6)) return 3;// giải 3

        return 0;
    }

    // Tính toán tiền thưởng của người chơi
    static ArrayList<Integer> tienThuong(ArrayList<nguoiChoi> list)
    {
        ArrayList<Integer> a = getNumbers();

        ArrayList<Integer> b = new ArrayList<>(); // mảng để lưu kết quả kiểm tra ai đã trúng thưởng
        for(int i = 0 ; i<list.size() ; i++)
        {
            b.add(checkGiaiThuong( list.get(i),a.get(0),a.get(1),
                                    a.get(2),a.get(3),a.get(4),a.get(5))); // kiểm tra và lưu thông tin trúng thưởng
        }
        ArrayList<Integer> Tienthuong = new ArrayList<>();
        int giaiDB=0;
        for (Integer integer : b) {
            if (integer == 6) giaiDB+=list.get(integer).soVe;
        }
        long db = 12000000000L;
        if(giaiDB!=0) {
            db = db/giaiDB;
        }

        for (int i = 0 ; i<list.size() ; i++)
        {
            if(b.get(i)==6) {
                Tienthuong.add((int) (list.get(i).soVe*db));
            }
            if(b.get(i)==1) Tienthuong.add(10000000);
            if(b.get(i)==2) Tienthuong.add(300000);
            if(b.get(i)==3) Tienthuong.add(30000);
            else Tienthuong.add(0);
        }
        return  Tienthuong;
    }

    // Ghi danh sách trúng thưởng vào file output.txt
    public  static  void danhSachTrungThuong (ArrayList<nguoiChoi> Player , ArrayList<Integer> Tienthuong)
    {
        File f = new File("/Users/nhatnguyendinh/IdeaProjects/java_review/src/Lottery/ouput.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f.getPath()))) {
            for(int i= 0 ; i<Player.size() ; i++)
            {
                String content = Player.get(i).toString()+" ,"+String.valueOf(Tienthuong.get(i))+"\n";
                writer.write(content);
            }
            System.out.println("Dữ liệu đã được ghi vào file thành công.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi dữ liệu vào file.");
            e.printStackTrace();
        }
    }

}

