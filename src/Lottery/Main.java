package Lottery;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args)
    {



    }

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
}

    /*
    viết 1 hàm trả về int để check giải trúng
    không trúng return 0;
    trúng giải đặc biệt return 6;
    trúng giải nhất return 1;
    trúng giải nhì return 2;
    trúng giải 3 return 3;
     */
    /*
    ở hàm main làm 1 array list để lưu thông tin người chơi kiểu dữ liệu là nguoiChoi

    làm hàm check dữ liệu đầu vào từ file input2.txt
    làm 1 hàm đếm số người chơi trúng thưởng để tính tiền thưởng

    làm 1 hàm để tạo 1 file output.txt xuất ra tên người trúng thưởng với giải đã trúng thưởng
     */