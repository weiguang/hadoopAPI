import com.okayjam.hadoop.fs.FileUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

/**
 * Created by Weiguang Chen <chen2621978@gmail.com> on 2018/5/8 10:08.
 */
public class HDFSAPP {

    /*链接获取方式：
    1.在命令行输入 hdfs getconf -confKey fs.default.name
    2.在core-site.xml中fs.defaultFS字段定义
    */

    public static final String HDFS_PATH = "hdfs://192.168.98.100:9000";


    Configuration configuration;
    FileSystem fs;


    public FileUtil fileUtil = new FileUtil(HDFS_PATH);

    /**
     *  初始
     * @throws Exception
     */
//    @Before
    public void setUp() throws Exception {
        System.out.println("start");
        configuration = new Configuration();
        fs = FileSystem.get(URI.create(HDFS_PATH), configuration);
    }

/*    @Test
    public void  testmkdirs () throws IOException {
        fileUtil.mkdirs("/javaTest/te");
    }

    @Test
    public void  testRename () throws IOException {
        fileUtil.rename("/javaTest/te", "/javaTest/aa");
    }

    @Test
    public void  testLs () throws IOException {
        fileUtil.ls("/");
    }

    @Test
    public void  testCreateFile () throws IOException {
        String file = "/javaTest/testfile.txt";
        String content = "This crate by Java";
        fileUtil.createFile(file,content);
    }*/

//
//    @Test
//    public void  testDelete () throws IOException {
////        fileUtil.deleteOnExit("/javaTest");
//        fileUtil.deleteOnExit("/hello.txt");
//    }

//
//    @Test
//    public void  testCopyFile () throws IOException {
//        fileUtil.copyFile("/home/hadoop/hello.txt", "/hello.txt");
//    }

    @Test
    public void  testDownload () throws IOException {
        fileUtil.download("/hello.txt", "/home/hadoop/test");
    }


    /**
     * 创建目录
     * @throws IOException
     */
//    @Test
    public void mkdirs() throws IOException {
    }

    /**
     * 关闭文件系统
     * @throws Exception
     */
//    @After
    public void tearDown() throws Exception {
        System.out.println("end");
        configuration = null;
        fs.close();
        fs = null;
        System.out.println("HDFSApp tearDown");
    }


}
