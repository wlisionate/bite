package bite18.网络.TCP;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncodeDecodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "庞陈勃";
        // URL 编码
        String 编码后的结果  = URLEncoder.encode(s, "UTF-8");
        System.out.println(编码后的结果);

        // URL -
        String o = 编码后的结果;
        String 解码后的结果 = URLDecoder.decode(o, "UTF-8");
        System.out.println(解码后的结果);
    }
}
