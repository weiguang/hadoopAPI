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

    /**
     *  初始
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        System.out.println("start");
        configuration = new Configuration();
        fs = FileSystem.get(URI.create(HDFS_PATH), configuration);
    }

    /**
     * 创建目录
     * @throws IOException
     */
    @Test
    public void mkdirs() throws IOException {
        String folder = "/java";
        Path path = new Path(folder);
        if (!fs.exists(path)) {
            fs.mkdirs(path);
            System.out.println("Create: " + folder);
        }

    }

    /**
     * 关闭文件系统
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("end");
        configuration = null;
        fs.close();
        fs = null;
        System.out.println("HDFSApp tearDown");
    }


}
