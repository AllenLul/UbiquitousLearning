package just.learn.common.utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
/**
 * 获取和判断文件头信息 
 *
 * @author Sud
 *
 */
public class GetTypeByHead {
    // 缓存文件头信息-文件头信息
    public static final HashMap<String, String> mFileTypes = new HashMap<String, String>();
    static {
        // images
        mFileTypes.put("ffd8ff", "jpg");
        mFileTypes.put("89504e", "png");
        mFileTypes.put("47494638", "gif");
        mFileTypes.put("49492a00", "tif");
        mFileTypes.put("424d", "bmp");
        //
        mFileTypes.put("41433130", "dwg"); // CAD
        mFileTypes.put("38425053", "psd");
        mFileTypes.put("7b5c727466", "rtf"); // 日记本
        mFileTypes.put("3c3f786d6c", "xml");
        mFileTypes.put("68746d6c3e", "html");
        mFileTypes.put("44656c69766572792d646174653a", "eml"); // 邮件
        mFileTypes.put("d0cf11e0", "doc");
        mFileTypes.put("5374616e64617264204a", "mdb");
        mFileTypes.put("252150532d41646f6265", "ps");
        mFileTypes.put("255044462d312e", "pdf");
        mFileTypes.put("504b03", "docx");
        mFileTypes.put("52617221", "rar");
        mFileTypes.put("57415645", "wav");
        mFileTypes.put("41564920", "avi");
        mFileTypes.put("000000", "mp4");
        mFileTypes.put("000001ba", "mpg");
        mFileTypes.put("000001b3", "mpg");
        mFileTypes.put("6d6f6f76", "mov");
        mFileTypes.put("3026B2758E66CF11", "asf");
        mFileTypes.put("4D546864", "mid");
        mFileTypes.put("1F8B08", "gz");
        mFileTypes.put("4D5A9000", "exe/dll");
        mFileTypes.put("75736167", "txt");
    }
    /**
     * 根据文件路径获取文件头信息
     *
     * @param file
     *   文件路径
     * @return 文件头信息
     */
    public static String getFileType(MultipartFile file) throws Exception {

        return mFileTypes.get(getFileHeader((FileInputStream) file.getInputStream()));
    }
    public static String test(File file) throws Exception {

        return mFileTypes.get(getFileHeader(new FileInputStream(file)));
    }


    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static String getFileHeader(InputStream is) throws Exception {
        byte[] b = new byte[3];
        is.read(b, 0, b.length);
        System.out.println(bytesToHexString(b));
        return bytesToHexString(b);

    }

    public static void main(String[] args) throws Exception {
        System.out.println(test(new File("E:\\图片\\pexels-photo-440731.jpeg")));
    }

} 