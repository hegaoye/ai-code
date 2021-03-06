/*
 *
 *                       http://www.aicode.io
 *
 *
 *      本代码仅用于AI-Code.
 */
package com.aicode.core.tools;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class FileUtil {

    /**
     * @param path
     * @return
     * @Enclosing_Method : filtPath
     * @Written by : czq
     * @Creation Date : Sep 20, 2010 9:37:33 PM
     * @version : v1.00
     * @Description : 过滤路径，把路径过滤成形如“/aa/bb”的形式
     */
    public static String filtPath(String path) {
        path = path.replace("\\", "/");
        path = path.replace("//", "/");

        if (path.lastIndexOf("/") == path.length()) {
            path = path.substring(path.length() - 1, path.length());
        }
        return path;
    }

    /**
     * @param sourceFileName 源文件名
     * @param targetFileName 目标文件名
     * @throws IOException
     * @Enclosing_Method : copyFile
     * @Written by : czq
     * @Creation Date : Oct 23, 2010 5:13:47 PM
     * @version : v1.00
     * @Description : 复制文件
     */
    public static void copyFile(String sourceFileName, String targetFileName)
            throws IOException {
        File sourceFile = new File(targetFileName);
        File targetFile = new File(sourceFileName);
        copyFile(sourceFile, targetFile);
    }

    /**
     * @param sourceFile     源文件
     * @param targetFileName 目标文件
     * @throws IOException
     * @Enclosing_Method : copyFile
     * @Written by : czq
     * @Creation Date : Oct 23, 2010 5:13:18 PM
     * @version : v1.00
     * @Description : 复制文件
     */
    public static void copyFile(File sourceFile, String targetFileName)
            throws IOException {
        File file = new File(targetFileName);
        copyFile(sourceFile, file);
    }

    /**
     * @param sourceFileName 源文件名
     * @param targetFile     目标文件
     * @throws IOException
     * @Enclosing_Method : copyFile
     * @Written by : czq
     * @Creation Date : Oct 23, 2010 5:12:34 PM
     * @version : v1.00
     * @Description : 复制文件
     */
    public static void copyFile(String sourceFileName, File targetFile)
            throws IOException {
        File file = new File(sourceFileName);
        copyFile(file, targetFile);
    }

    /**
     * @param input      源文件
     * @param targetFile 目录文件
     * @throws IOException
     * @Enclosing_Method : copyFile
     * @Written by : czq
     * @Creation Date : Oct 23, 2010 5:08:04 PM
     * @version : v1.00
     * @Description : 复制文件
     */
    public static void copyFile(FileInputStream input, File targetFile)
            throws IOException {
        // 新建文件输出流并对它进行缓冲
        FileOutputStream output = new FileOutputStream(targetFile);
        //相互copy
        copyFile(input, output);
    }

    /**
     * @param input          源文件
     * @param targetFileName 目录文件
     * @throws IOException
     * @Enclosing_Method : copyFile
     * @Written by : czq
     * @Creation Date : Oct 23, 2010 5:08:04 PM
     * @version : v1.00
     * @Description : 复制文件
     */
    public static void copyFile(InputStream input, String targetFileName)
            throws IOException {
        // 新建文件输出流并对它进行缓冲
        File targetFile = new File(targetFileName);
        FileOutputStream output = new FileOutputStream(targetFile);
        //相互copy
        copyFile(input, output);
    }

    /**
     * @param sourceFile 源文件
     * @param targetFile 目录文件
     * @throws IOException
     * @Enclosing_Method : copyFile
     * @Written by : czq
     * @Creation Date : Oct 23, 2010 5:08:04 PM
     * @version : v1.00
     * @Description : 复制文件
     */
    public static void copyFile(File sourceFile, File targetFile)
            throws IOException {
        // 新建文件输入流并对它进行缓冲
        FileInputStream input = new FileInputStream(sourceFile);
        // 新建文件输出流并对它进行缓冲
        FileOutputStream output = new FileOutputStream(targetFile);
        //相互copy
        copyFile(input, output);
    }

    /**
     * @param input  源文件
     * @param output 目录文件
     * @throws IOException
     * @Enclosing_Method : copyFile
     * @Written by : czq
     * @Creation Date : Oct 23, 2010 5:08:04 PM
     * @version : v1.00
     * @Description : 复制文件
     */
    public static void copyFile(InputStream input, FileOutputStream output)
            throws IOException {
        // 新建文件输入流并对它进行缓冲
        BufferedInputStream inBuff = new BufferedInputStream(input);
        // 新建文件输出流并对它进行缓冲
        BufferedOutputStream outBuff = new BufferedOutputStream(output);

        // 缓冲数组
        byte[] b = new byte[1024 * 5];
        int len;
        while ((len = inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }
        // 刷新此缓冲的输出流
        outBuff.flush();

        // 关闭流
        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }


    /**
     * 把字节数组保存为一个文件
     */
    public static File getFileFromBytes(byte[] b, String outputFile) {
        BufferedOutputStream stream = null;
        File file = null;
        try {
            file = new File(outputFile);
            FileOutputStream fstream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fstream);
            stream.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }


    /**
     * @param sourceDir 　源目录
     * @param targetDir 　目标目录
     * @throws IOException
     * @Enclosing_Method : copyDirectiory
     * @Written by        : czq
     * @Creation Date     : Oct 23, 2010 5:14:36 PM
     * @version : v1.00
     * @Description : 复制目录
     **/
    public static void copyDirectiory(String sourceDir, String targetDir)
            throws IOException {
        // 新建目标目录
        (new File(targetDir)).mkdirs();
        // 获取源文件夹当前下的文件或目录
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // 源文件
                File sourceFile = file[i];
                // 目标文件
                File targetFile = new File(new File(targetDir)
                        .getAbsolutePath()
                        + File.separator + file[i].getName());
                copyFile(sourceFile, targetFile);
            }
            if (file[i].isDirectory()) {
                // 准备复制的源文件夹
                String dir1 = sourceDir + "/" + file[i].getName();
                // 准备复制的目标文件夹
                String dir2 = targetDir + "/" + file[i].getName();
                copyDirectiory(dir1, dir2);
            }
        }
    }

    /**
     * 删除文件夹和其下所有文件
     *
     * @param folderPath 文件夹完整绝对路径
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定文件夹下所有文件（不删除指定文件夹）
     *
     * @param path
     * @return
     */
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 删除文件
     *
     * @param path
     * @return
     */
    public static boolean delFile(String path) {
        boolean flag = false;
        if (StringUtils.isNotBlank(path)) {
            File temp = new File(path);
            if (temp.exists() && temp.isFile()) {
                temp.delete();
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 下载文件
     *
     * @param remoteFilePath 远端文件路径
     * @param localFilePath  本地保存文件路径
     */
    public static void downloadFile(String remoteFilePath, String localFilePath) {
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File f = new File(localFilePath);
        try {
            urlfile = new URL(remoteFilePath);
            httpUrl = (HttpURLConnection) urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取指定目录下所有文件路径
     *
     * @param dirPath
     */
    public static List<File> getDirFiles(String dirPath) {
        List<File> ret = new ArrayList<File>();
        File file = new File(dirPath);
        //获取目录下的所有文件或文件夹
        File[] files = file.listFiles();
        if (files == null) {
            return null;
        }
        // 遍历目录下的所有文件
        for (File f : files) {
            if (f.isFile()) {
                ret.add(f);
            } else if (f.isDirectory()) {
                ret.addAll(getDirFiles(f.getAbsolutePath()));
            }
        }
        return ret;
    }

    /**
     * 获取指定目录下所有文件路径
     *
     * @param dir
     */
    public static List<Map<String, String>> sanDirFiles(String dir, String subStr) {
        List<Map<String, String>> fileList = new ArrayList<>();
        File fileDir = new File(dir);
        //获取目录下的所有文件或文件夹
        File[] files = fileDir.listFiles();
        if (files == null) {
            return null;
        }
        for (File file : files) {
            Map<String, String> map = new HashedMap();
            if (file.isFile()) {
                map.put("type", "File");
                map.put("filePath", file.getPath().substring(file.getPath().indexOf(subStr)).replace("\\", "/").replace("//", "/"));
            } else if (file.isDirectory()) {
                map.put("type", "Directory");
                map.put("filePath", file.getPath().substring(file.getPath().indexOf(subStr)).replace("\\", "/").replace("//", "/"));
            }
            fileList.add(map);
        }
        return fileList;
    }

    /**
     * 获取文件路径
     *
     * @param dirPath 目录
     * @return 路径集合
     */
    public static List<String> getDirFilesPath(String dirPath) {
        List<File> list = getDirFiles(dirPath);
        List<String> pathList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String path = list.get(i).getAbsoluteFile().toString().replace("\\", "/");
            if (!path.contains(".git") && !path.contains("git")) {
                if (new File(path).isFile()) {
                    pathList.add(path);
                }
            }
        }
        return pathList;
    }


    public static void createDir(String filePath, String fileName) {
        File folder = new File(filePath);
        //文件夹路径不存在
        if (!folder.exists() && !folder.isDirectory()) {
            log.info("文件夹路径不存在，创建路径:" + filePath);
            folder.mkdirs();
        } else {
            log.info("文件夹路径存在:" + filePath);
        }
        // 如果文件不存在就创建
        if (!"null".equals(fileName) && !StringUtils.isEmpty(fileName)) {
            File file = new File(filePath + "/" + fileName);
            if (!file.exists()) {
                log.info("文件不存在，创建文件:" + filePath + "/" + fileName);
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        File file = new File("C:\\workspaces\\AI-Code\\AI\\src\\main\\webapp\\templates");
        File[] list1 = file.listFiles();
        for (File file1 : list1) {
            log.info(file1.getName());
        }

        GitTools.cloneGit("https://gitee.com/helixin/aicode_template.git", "C:\\workspaces\\AI-Code\\AI\\build\\libs\\exploded\\AI.war\\templates\\aicode_template");
        GitTools.deleteGitRepository("C:\\workspaces\\AI-Code\\AI\\build\\libs\\exploded\\AI.war\\templates\\aicode_template\\.git");


        List<File> list = getDirFiles("C:\\workspaces\\AI-Code\\AI\\src\\main\\webapp\\templates\\spring-cloud-redis-lombok-sentry");
        for (int i = 0; i < list.size(); i++) {
            String path = list.get(i).getAbsoluteFile().toString().replace("C:\\workspaces\\AI-Code\\AI\\src\\main\\webapp\\templates", "").replace("\\", "/");
            String sql = "INSERT into frameworks_template(code,frameworkCode,path) values('" + (888888 + i) + "','888888','" + path + "');";
            log.info(sql);
        }

//        List<Map<String, String>> mapList = sanDirFiles("C:\\workspaces\\AI-Code\\AI\\src\\main\\webapp\\templates\\spring-cloud-redis-lombok-sentry", "announce");
//        log.info(JSON.toJSONString(mapList));
//        try {
//            String fileStr = FileUtils.readFileToString(new File("C:\\workspaces\\AI-Code\\AI\\build\\libs\\exploded\\AI.war\\workspace\\announce\\cycle\\src\\main\\java\\com\\cycle\\admin\\ctrl\\AdminCtrl.java"));
//            log.info(fileStr);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
