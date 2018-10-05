package com.rzhkj.project.ctrl;

import com.jcraft.jsch.*;
import com.rzhkj.core.tools.SSH2;
import com.rzhkj.core.tools.SSHResInfo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by lixin on 2018/9/30.
 */
public class Test {


    public static void test() {

        String host = "192.168.1.220";
        int port = 22;
        String user = "pitop";
        String password = "0";

        String command1 = "ls -ltr";
        try {

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();

            System.out.println("Connected");
            ChannelShell channel = (ChannelShell) session.openChannel("shell");
            InputStream in = channel.getInputStream();
            channel.setPty(true);

            channel.connect();

            OutputStream os = channel.getOutputStream();
            os.write((command1 + "\r\n").getBytes());
            os.flush();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    String s = new String(tmp, 0, i);
                    if (s.indexOf("--More--") >= 0) {
                        os.write((" ").getBytes());
                        os.flush();
                    }
                    System.out.print(s);
                }
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            os.close();
            in.close();
            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void test2() {
        SSH2 ssh = null;
        while (true) {
            Scanner scan = new Scanner(System.in);
            String read = scan.nextLine();
            if (read != null) {
                try {

                    if (ssh == null) {
                        //使用目标服务器机上的用户名和密码登陆
                        ssh = new SSH2("192.168.1.220", 22, "pitop", "0");
                    }
                    try {
                        SSHResInfo resInfo = ssh.shell(read, 200);
                        System.out.println(resInfo.toString());
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        ssh.close();
                    }
                } catch (JSchException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


    public static void test3() throws JSchException, IOException {
        JSch jsch = new JSch();
        Session session = jsch.getSession("pi", "192.168.1.36", 22);
        session.setPassword("0");
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect(50000);

        Channel channel = session.openChannel("shell");
//        InputStream inputStream = new ByteArrayInputStream(new String("ps -ef").getBytes());
//        channel.setInputStream(inputStream);
        channel.setInputStream(System.in);
//        FileOutputStream fileOutputStream=new FileOutputStream(File.createTempFile("aaa","txt",new File("C:\\")));
//        channel.setOutputStream(fileOutputStream);
        InputStream inputStream1 = channel.getInputStream();
        byte[] tmp1 = new byte[1024];

//        OutputStream outputStream = new ByteArrayOutputStream();
//        channel.setOutputStream(outputStream);
//        byte[] tmp = new byte[1024];
//        outputStream.write(tmp);
//        outputStream.flush();

//        InputStream inputStream = new ByteArrayInputStream(tmp);
        channel.connect(3 * 1000);


        new Thread() {
            public void run() {
                try {
                    while (true) {
                        while (inputStream1.available() > 0) {
                            int i = inputStream1.read(tmp1, 0, 1024);
                            System.out.println("111111111111");
                            System.out.println(new String(tmp1, 0, i));
                        }
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


    public static void main(String[] args) throws Exception {


//        test2();
        test3();


    }
}