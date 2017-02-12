package cn.aijuntj.test_file_io.utility;

import android.os.Environment;
import android.text.Editable;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by a on 2017/2/12.
 */

public class File_IO {
    private String file_path;
    private String Dir_Name;
    private String File_Name;
    public File_IO(){
        Dir_Name = "AJ_Files";
        File_Name = "File_IO_data.txt";
    }

    public String get_file_path(){
        String my_path = new String();
        if(file_path!=null){
        my_path = file_path;}

        return my_path;
    }

    public boolean build_a_txt_file(String file_content) {
        //默认是失败的，除非创建成功了 ;
        boolean result = false;

        File SD_Card_Dir = Environment.getExternalStorageDirectory();
        try {
            file_path = new String(SD_Card_Dir.getPath());
            file_content = "\n"+file_content +". " + file_path+"\n" ;
            File targetFile = new File(SD_Card_Dir.getCanonicalPath() + "/001nn.txt");
            RandomAccessFile randomAccessFile = new RandomAccessFile(targetFile, "rw");
            randomAccessFile.seek(targetFile.length());
            randomAccessFile.write(file_content.getBytes());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
            result = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
